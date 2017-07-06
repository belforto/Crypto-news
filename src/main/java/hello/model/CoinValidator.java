/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mognjenovic
 */
public class CoinValidator {
   
    private BigInteger marketcap;
    private BigInteger volume;
    private BigDecimal price;
    private String name;
    private Double change;

    public CoinValidator() {
    }

    /**
     * @return the marketcap
     */
    public BigInteger getMarketcap() {
        return marketcap;
    }

    /**
     * @param marketcap the marketcap to set
     */
    public void setMarketcap(BigInteger marketcap) {
        this.marketcap = marketcap;
    }

    /**
     * @return the volume
     */
    public BigInteger getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    

    /**
     * @param change the change to set
     */
    public void setChange(Double change) {
        this.change = change;
    }

    /**
     * @return the change
     */
    public Double getChange() {
        return change;
    }
   

}
