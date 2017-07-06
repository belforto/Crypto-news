/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.businessLogic;

import hello.model.CoinValidator;
import hello.model.Crypto;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.stereotype.Component;

/**
 *
 * @author mognjenovic
 */
@Component
public class Rules {

    private final BigInteger MARKET_CAP = new BigInteger("100000000");
    private final BigInteger VOLUME = new BigInteger("500000");

    public CoinValidator examineCoinPotential(Crypto cto) {
        if(cto==null) return null;
        if (MARKET_CAP.compareTo(new BigInteger(cleanSymbols(cto.getMarketCap()))) == -1 && VOLUME.compareTo(new BigInteger(cleanSymbols(cto.getVolume24H()))) == -1) {
            CoinValidator cv = new CoinValidator();
            cv.setName(cto.getName());
            cv.setMarketcap(new BigInteger(cleanSymbols(cto.getMarketCap())));
            cv.setVolume(new BigInteger(cleanSymbols(cto.getVolume24H())));
            cv.setPrice(new BigDecimal(cleanSymbols(cto.getPrice())));
            cv.setChange(Double.valueOf(cleanSymbols(cto.getChange())));
            return cv;
        }
        return null;
    }
     private String cleanSymbols(String dirtyString) {
        return dirtyString.replaceAll("[$%,]", "");
    }

}
