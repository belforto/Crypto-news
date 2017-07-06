/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model;

/**
 *
 * @author mognjenovic
 */
public class Crypto {
    private String rank;
    private String name;
    private String marketCap;
    private String price;
    private String CirculatingSupply;
    private String volume24H;
    private String change;
    private String priceGraph7d;

    public Crypto() {
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
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
     * @return the marketCap
     */
    public String getMarketCap() {
        return marketCap;
    }

    /**
     * @param marketCap the marketCap to set
     */
    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    /**
     * @return the CirculatingSupply
     */
    public String getCirculatingSupply() {
        return CirculatingSupply;
    }

    /**
     * @param CirculatingSupply the CirculatingSupply to set
     */
    public void setCirculatingSupply(String CirculatingSupply) {
        this.CirculatingSupply = CirculatingSupply;
    }

    /**
     * @return the volume24H
     */
    public String getVolume24H() {
        return volume24H;
    }

    /**
     * @param volume24H the volume24H to set
     */
    public void setVolume24H(String volume24H) {
        this.volume24H = volume24H;
    }

    /**
     * @return the priceGraph7d
     */
    public String getPriceGraph7d() {
        return priceGraph7d;
    }

    /**
     * @param priceGraph7d the priceGraph7d to set
     */
    public void setPriceGraph7d(String priceGraph7d) {
        this.priceGraph7d = priceGraph7d;
    }

    /**
     * @return the change
     */
    public String getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(String change) {
        this.change = change;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
}
