package hello.jobs;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import hello.email.EmailServiceImpl;
import hello.businessLogic.Rules;
import hello.model.CoinValidator;
import hello.model.Crypto;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.jsoup.nodes.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private String WEBSITE="https://coinmarketcap.com/";
    private String WEBSITE_ELEMENT_ID="currencies";

    @Autowired
    EmailServiceImpl emailServiceImpl;
    @Autowired
    SimpleMailMessage template;
    @Autowired
    Rules rules;

    @Scheduled(fixedRate = 3600000)//6h 21600000
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        checkValueOfCoinsAndSendEmail();
    }

    private void checkValueOfCoinsAndSendEmail() {
        Document doc;
        try {

            WebClient webClient = new WebClient();
            HtmlPage page = webClient.getPage(WEBSITE);
            HtmlTable table = page.getHtmlElementById(WEBSITE_ELEMENT_ID);

            List<Crypto> listOfCurrData = new ArrayList();
            List<CoinValidator> listOfValidCoins = new ArrayList();

            for (HtmlTableRow row : table.getRows()) {
                String[] rowdata = new String[row.getCells().size()];
                int i = 0;
                for (HtmlTableCell cell : row.getCells()) {
                    rowdata[i] = cell.asText();

                    i++;
                }
                System.out.println(Arrays.toString(rowdata));

                listOfCurrData.add(makeObjectOfArray(rowdata));
                listOfValidCoins.add(rules.examineCoinPotential(makeObjectOfArray(rowdata)));

            }
            String emailBody = null;
            listOfValidCoins.removeAll(Collections.singleton(null));

            //emailServiceImpl.sendSimpleMessage("marko.ognjenovich@gmail.com", "TESTEMAIL", emailBody);
            emailServiceImpl.sendMessageWithHTML("x", "Cryptocurrencies Daily Advice", "", listOfCurrData, listOfValidCoins);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(ScheduledTasks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String format(String dirtyString) {
        return dirtyString.replaceAll("[^ a-zA-Z0-9-+$%.,*]", "");

    }

    private String cleanSymbols(String dirtyString) {
        return dirtyString.replaceAll("[$%]", "");

    }

    private Crypto makeObjectOfArray(String[] rowdata) {
        Crypto crypto = new Crypto();
        if (rowdata[0].equals("#")) {
            return null;

        }
        crypto.setRank(rowdata[0]);
        crypto.setName(rowdata[1]);
        crypto.setMarketCap(rowdata[2]);
        crypto.setPrice(rowdata[3]);
        crypto.setCirculatingSupply(rowdata[4]);
        crypto.setVolume24H(rowdata[5]);
        crypto.setChange(rowdata[6]);
        crypto.setPriceGraph7d("");
        return crypto;

    }

}
