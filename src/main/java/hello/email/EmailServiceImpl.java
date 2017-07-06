package hello.email;

import hello.model.CoinValidator;
import hello.model.Crypto;
import hello.model.recipients.Recipients;
import hello.model.recipients.RecipientsDAO;
import java.util.Date;
import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailServiceImpl {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Autowired
    RecipientsDAO recipientsDAO;

//    public void sendSimpleMessage(
//            String to, String subject, String text) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);
//
//    }
    public void sendMessageWithHTML( String to, String subject, String text, List<Crypto> arrayListOfStocksData, List<CoinValidator> sugestedCoins) throws MessagingException {

        Recipients r = recipientsDAO.findByIdrecipient(1L);
        String multipleEmailIds = r.getEmailLongString();
        final Context ctx = new Context();
        ctx.setVariable("name", to);
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("hobbies", arrayListOfStocksData);
        ctx.setVariable("sugcoins", sugestedCoins);
        MimeMessage message = emailSender.createMimeMessage();
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(multipleEmailIds));
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("email.service.mail@gmail.com");
        helper.setSubject(subject);
        final String htmlContent = this.htmlTemplateEngine.process("mails/sample", ctx);
        helper.setText(htmlContent /* isHtml */, true);
        helper.addInline("background", new ClassPathResource("images/background.jpg"), "image/jpg");
        helper.addInline("thymeleaf-banner", new ClassPathResource("images/thymeleaf-banner.png"), "image/png");

        emailSender.send(message);

    }
}
