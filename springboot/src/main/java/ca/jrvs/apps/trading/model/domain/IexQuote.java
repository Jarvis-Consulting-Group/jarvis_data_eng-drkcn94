package ca.jrvs.apps.trading.model.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class IexQuote {

    private int avgTotalVolume;
    private String calculationPrice;
    private double change;
    private double changePercent;
    private Object close;
    private String closeSource;
    private Object closeTime;
    private String companyName;
    private String currency;
    private Object delayedPrice;
    private Object delayedPriceTime;
    private Object extendedChange;
    private Object extendedChangePercent;
    private Object extendedPrice;
    private Object extendedPriceTime;
    private Object high;
    private String highSource;
    private long highTime;
    private double iexAskPrice;
    private int iexAskSize;
    private double iexBidPrice;
    private int iexBidSize;
    private int iexClose;
    private long iexCloseTime;
    private long iexLastUpdated;
    private double iexMarketPercent;
    private double iexOpen;
    private long iexOpenTime;
    private int iexRealtimePrice;
    private int iexRealtimeSize;
    private int iexVolume;
    private long lastTradeTime;
    private int latestPrice;
    private String latestSource;
    private String latestTime;
    private long latestUpdate;
    private Object latestVolume;
    private Object low;
    private Object lowSource;
    private Object lowTime;
    private long marketCap;
    private Object oddLotDelayedPrice;
    private Object oddLotDelayedPriceTime;
    private Object open;
    private Object openTime;
    private String openSource;
    private double peRatio;
    private double previousClose;
    private int previousVolume;
    private String primaryExchange;
    private String symbol;
    private Object volume;
    private double week52High;
    private double week52Low;
    private double ytdChange;
    private boolean isUSMarketOpen;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public IexQuote() {
    }

    /**
     *
     * @param symbol
     * @param highTime
     * @param avgTotalVolume
     * @param companyName
     * @param openSource
     * @param delayedPrice
     * @param iexMarketPercent
     * @param primaryExchange
     * @param latestUpdate
     * @param high
     * @param iexOpenTime
     * @param delayedPriceTime
     * @param extendedPrice
     * @param week52Low
     * @param highSource
     * @param latestPrice
     * @param marketCap
     * @param iexClose
     * @param volume
     * @param ytdChange
     * @param lastTradeTime
     * @param closeSource
     * @param extendedChange
     * @param iexRealtimePrice
     * @param calculationPrice
     * @param extendedChangePercent
     * @param latestSource
     * @param iexOpen
     * @param iexBidPrice
     * @param previousClose
     * @param peRatio
     * @param isUSMarketOpen
     * @param low
     * @param oddLotDelayedPrice
     * @param extendedPriceTime
     * @param changePercent
     * @param closeTime
     * @param currency
     * @param week52High
     * @param openTime
     * @param close
     * @param iexCloseTime
     * @param oddLotDelayedPriceTime
     * @param previousVolume
     * @param iexRealtimeSize
     * @param iexLastUpdated
     * @param change
     * @param iexAskPrice
     * @param latestVolume
     * @param lowSource
     * @param iexVolume
     * @param iexAskSize
     * @param latestTime
     * @param iexBidSize
     * @param lowTime
     * @param open
     */
    public IexQuote(int avgTotalVolume, String calculationPrice, double change, double changePercent, Object close, String closeSource, Object closeTime, String companyName, String currency, Object delayedPrice, Object delayedPriceTime, Object extendedChange, Object extendedChangePercent, Object extendedPrice, Object extendedPriceTime, Object high, String highSource, long highTime, double iexAskPrice, int iexAskSize, double iexBidPrice, int iexBidSize, int iexClose, long iexCloseTime, long iexLastUpdated, double iexMarketPercent, double iexOpen, long iexOpenTime, int iexRealtimePrice, int iexRealtimeSize, int iexVolume, long lastTradeTime, int latestPrice, String latestSource, String latestTime, long latestUpdate, Object latestVolume, Object low, Object lowSource, Object lowTime, long marketCap, Object oddLotDelayedPrice, Object oddLotDelayedPriceTime, Object open, Object openTime, String openSource, double peRatio, double previousClose, int previousVolume, String primaryExchange, String symbol, Object volume, double week52High, double week52Low, double ytdChange, boolean isUSMarketOpen) {
        super();
        this.avgTotalVolume = avgTotalVolume;
        this.calculationPrice = calculationPrice;
        this.change = change;
        this.changePercent = changePercent;
        this.close = close;
        this.closeSource = closeSource;
        this.closeTime = closeTime;
        this.companyName = companyName;
        this.currency = currency;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPrice = extendedPrice;
        this.extendedPriceTime = extendedPriceTime;
        this.high = high;
        this.highSource = highSource;
        this.highTime = highTime;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.iexLastUpdated = iexLastUpdated;
        this.iexMarketPercent = iexMarketPercent;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexVolume = iexVolume;
        this.lastTradeTime = lastTradeTime;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.low = low;
        this.lowSource = lowSource;
        this.lowTime = lowTime;
        this.marketCap = marketCap;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.peRatio = peRatio;
        this.previousClose = previousClose;
        this.previousVolume = previousVolume;
        this.primaryExchange = primaryExchange;
        this.symbol = symbol;
        this.volume = volume;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.isUSMarketOpen = isUSMarketOpen;
    }

    public int getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(int avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public Object getClose() {
        return close;
    }

    public void setClose(Object close) {
        this.close = close;
    }

    public String getCloseSource() {
        return closeSource;
    }

    public void setCloseSource(String closeSource) {
        this.closeSource = closeSource;
    }

    public Object getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Object closeTime) {
        this.closeTime = closeTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(Object delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public Object getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(Object delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public Object getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(Object extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Object getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Object extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public Object getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(Object extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public Object getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(Object extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public Object getHigh() {
        return high;
    }

    public void setHigh(Object high) {
        this.high = high;
    }

    public String getHighSource() {
        return highSource;
    }

    public void setHighSource(String highSource) {
        this.highSource = highSource;
    }

    public long getHighTime() {
        return highTime;
    }

    public void setHighTime(long highTime) {
        this.highTime = highTime;
    }

    public double getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(double iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public int getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(int iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public double getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(double iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public int getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(int iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public int getIexClose() {
        return iexClose;
    }

    public void setIexClose(int iexClose) {
        this.iexClose = iexClose;
    }

    public long getIexCloseTime() {
        return iexCloseTime;
    }

    public void setIexCloseTime(long iexCloseTime) {
        this.iexCloseTime = iexCloseTime;
    }

    public long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public double getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(double iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public double getIexOpen() {
        return iexOpen;
    }

    public void setIexOpen(double iexOpen) {
        this.iexOpen = iexOpen;
    }

    public long getIexOpenTime() {
        return iexOpenTime;
    }

    public void setIexOpenTime(long iexOpenTime) {
        this.iexOpenTime = iexOpenTime;
    }

    public int getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public void setIexRealtimePrice(int iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
    }

    public int getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public void setIexRealtimeSize(int iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
    }

    public int getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(int iexVolume) {
        this.iexVolume = iexVolume;
    }

    public long getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public int getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(int latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public long getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public Object getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Object latestVolume) {
        this.latestVolume = latestVolume;
    }

    public Object getLow() {
        return low;
    }

    public void setLow(Object low) {
        this.low = low;
    }

    public Object getLowSource() {
        return lowSource;
    }

    public void setLowSource(Object lowSource) {
        this.lowSource = lowSource;
    }

    public Object getLowTime() {
        return lowTime;
    }

    public void setLowTime(Object lowTime) {
        this.lowTime = lowTime;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public Object getOddLotDelayedPrice() {
        return oddLotDelayedPrice;
    }

    public void setOddLotDelayedPrice(Object oddLotDelayedPrice) {
        this.oddLotDelayedPrice = oddLotDelayedPrice;
    }

    public Object getOddLotDelayedPriceTime() {
        return oddLotDelayedPriceTime;
    }

    public void setOddLotDelayedPriceTime(Object oddLotDelayedPriceTime) {
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
    }

    public Object getOpen() {
        return open;
    }

    public void setOpen(Object open) {
        this.open = open;
    }

    public Object getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Object openTime) {
        this.openTime = openTime;
    }

    public String getOpenSource() {
        return openSource;
    }

    public void setOpenSource(String openSource) {
        this.openSource = openSource;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(double peRatio) {
        this.peRatio = peRatio;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public int getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(int previousVolume) {
        this.previousVolume = previousVolume;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Object getVolume() {
        return volume;
    }

    public void setVolume(Object volume) {
        this.volume = volume;
    }

    public double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(double week52High) {
        this.week52High = week52High;
    }

    public double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(double week52Low) {
        this.week52Low = week52Low;
    }

    public double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public boolean isIsUSMarketOpen() {
        return isUSMarketOpen;
    }

    public void setIsUSMarketOpen(boolean isUSMarketOpen) {
        this.isUSMarketOpen = isUSMarketOpen;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IexQuote.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("avgTotalVolume");
        sb.append('=');
        sb.append(this.avgTotalVolume);
        sb.append(',');
        sb.append("calculationPrice");
        sb.append('=');
        sb.append(((this.calculationPrice == null)?"<null>":this.calculationPrice));
        sb.append(',');
        sb.append("change");
        sb.append('=');
        sb.append(this.change);
        sb.append(',');
        sb.append("changePercent");
        sb.append('=');
        sb.append(this.changePercent);
        sb.append(',');
        sb.append("close");
        sb.append('=');
        sb.append(((this.close == null)?"<null>":this.close));
        sb.append(',');
        sb.append("closeSource");
        sb.append('=');
        sb.append(((this.closeSource == null)?"<null>":this.closeSource));
        sb.append(',');
        sb.append("closeTime");
        sb.append('=');
        sb.append(((this.closeTime == null)?"<null>":this.closeTime));
        sb.append(',');
        sb.append("companyName");
        sb.append('=');
        sb.append(((this.companyName == null)?"<null>":this.companyName));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("delayedPrice");
        sb.append('=');
        sb.append(((this.delayedPrice == null)?"<null>":this.delayedPrice));
        sb.append(',');
        sb.append("delayedPriceTime");
        sb.append('=');
        sb.append(((this.delayedPriceTime == null)?"<null>":this.delayedPriceTime));
        sb.append(',');
        sb.append("extendedChange");
        sb.append('=');
        sb.append(((this.extendedChange == null)?"<null>":this.extendedChange));
        sb.append(',');
        sb.append("extendedChangePercent");
        sb.append('=');
        sb.append(((this.extendedChangePercent == null)?"<null>":this.extendedChangePercent));
        sb.append(',');
        sb.append("extendedPrice");
        sb.append('=');
        sb.append(((this.extendedPrice == null)?"<null>":this.extendedPrice));
        sb.append(',');
        sb.append("extendedPriceTime");
        sb.append('=');
        sb.append(((this.extendedPriceTime == null)?"<null>":this.extendedPriceTime));
        sb.append(',');
        sb.append("high");
        sb.append('=');
        sb.append(((this.high == null)?"<null>":this.high));
        sb.append(',');
        sb.append("highSource");
        sb.append('=');
        sb.append(((this.highSource == null)?"<null>":this.highSource));
        sb.append(',');
        sb.append("highTime");
        sb.append('=');
        sb.append(this.highTime);
        sb.append(',');
        sb.append("iexAskPrice");
        sb.append('=');
        sb.append(this.iexAskPrice);
        sb.append(',');
        sb.append("iexAskSize");
        sb.append('=');
        sb.append(this.iexAskSize);
        sb.append(',');
        sb.append("iexBidPrice");
        sb.append('=');
        sb.append(this.iexBidPrice);
        sb.append(',');
        sb.append("iexBidSize");
        sb.append('=');
        sb.append(this.iexBidSize);
        sb.append(',');
        sb.append("iexClose");
        sb.append('=');
        sb.append(this.iexClose);
        sb.append(',');
        sb.append("iexCloseTime");
        sb.append('=');
        sb.append(this.iexCloseTime);
        sb.append(',');
        sb.append("iexLastUpdated");
        sb.append('=');
        sb.append(this.iexLastUpdated);
        sb.append(',');
        sb.append("iexMarketPercent");
        sb.append('=');
        sb.append(this.iexMarketPercent);
        sb.append(',');
        sb.append("iexOpen");
        sb.append('=');
        sb.append(this.iexOpen);
        sb.append(',');
        sb.append("iexOpenTime");
        sb.append('=');
        sb.append(this.iexOpenTime);
        sb.append(',');
        sb.append("iexRealtimePrice");
        sb.append('=');
        sb.append(this.iexRealtimePrice);
        sb.append(',');
        sb.append("iexRealtimeSize");
        sb.append('=');
        sb.append(this.iexRealtimeSize);
        sb.append(',');
        sb.append("iexVolume");
        sb.append('=');
        sb.append(this.iexVolume);
        sb.append(',');
        sb.append("lastTradeTime");
        sb.append('=');
        sb.append(this.lastTradeTime);
        sb.append(',');
        sb.append("latestPrice");
        sb.append('=');
        sb.append(this.latestPrice);
        sb.append(',');
        sb.append("latestSource");
        sb.append('=');
        sb.append(((this.latestSource == null)?"<null>":this.latestSource));
        sb.append(',');
        sb.append("latestTime");
        sb.append('=');
        sb.append(((this.latestTime == null)?"<null>":this.latestTime));
        sb.append(',');
        sb.append("latestUpdate");
        sb.append('=');
        sb.append(this.latestUpdate);
        sb.append(',');
        sb.append("latestVolume");
        sb.append('=');
        sb.append(((this.latestVolume == null)?"<null>":this.latestVolume));
        sb.append(',');
        sb.append("low");
        sb.append('=');
        sb.append(((this.low == null)?"<null>":this.low));
        sb.append(',');
        sb.append("lowSource");
        sb.append('=');
        sb.append(((this.lowSource == null)?"<null>":this.lowSource));
        sb.append(',');
        sb.append("lowTime");
        sb.append('=');
        sb.append(((this.lowTime == null)?"<null>":this.lowTime));
        sb.append(',');
        sb.append("marketCap");
        sb.append('=');
        sb.append(this.marketCap);
        sb.append(',');
        sb.append("oddLotDelayedPrice");
        sb.append('=');
        sb.append(((this.oddLotDelayedPrice == null)?"<null>":this.oddLotDelayedPrice));
        sb.append(',');
        sb.append("oddLotDelayedPriceTime");
        sb.append('=');
        sb.append(((this.oddLotDelayedPriceTime == null)?"<null>":this.oddLotDelayedPriceTime));
        sb.append(',');
        sb.append("open");
        sb.append('=');
        sb.append(((this.open == null)?"<null>":this.open));
        sb.append(',');
        sb.append("openTime");
        sb.append('=');
        sb.append(((this.openTime == null)?"<null>":this.openTime));
        sb.append(',');
        sb.append("openSource");
        sb.append('=');
        sb.append(((this.openSource == null)?"<null>":this.openSource));
        sb.append(',');
        sb.append("peRatio");
        sb.append('=');
        sb.append(this.peRatio);
        sb.append(',');
        sb.append("previousClose");
        sb.append('=');
        sb.append(this.previousClose);
        sb.append(',');
        sb.append("previousVolume");
        sb.append('=');
        sb.append(this.previousVolume);
        sb.append(',');
        sb.append("primaryExchange");
        sb.append('=');
        sb.append(((this.primaryExchange == null)?"<null>":this.primaryExchange));
        sb.append(',');
        sb.append("symbol");
        sb.append('=');
        sb.append(((this.symbol == null)?"<null>":this.symbol));
        sb.append(',');
        sb.append("volume");
        sb.append('=');
        sb.append(((this.volume == null)?"<null>":this.volume));
        sb.append(',');
        sb.append("week52High");
        sb.append('=');
        sb.append(this.week52High);
        sb.append(',');
        sb.append("week52Low");
        sb.append('=');
        sb.append(this.week52Low);
        sb.append(',');
        sb.append("ytdChange");
        sb.append('=');
        sb.append(this.ytdChange);
        sb.append(',');
        sb.append("isUSMarketOpen");
        sb.append('=');
        sb.append(this.isUSMarketOpen);
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.symbol == null)? 0 :this.symbol.hashCode()));
        result = ((result* 31)+((int)(this.highTime^(this.highTime >>> 32))));
        result = ((result* 31)+ this.avgTotalVolume);
        result = ((result* 31)+((this.companyName == null)? 0 :this.companyName.hashCode()));
        result = ((result* 31)+((this.openSource == null)? 0 :this.openSource.hashCode()));
        result = ((result* 31)+((this.delayedPrice == null)? 0 :this.delayedPrice.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexMarketPercent)^(Double.doubleToLongBits(this.iexMarketPercent)>>> 32))));
        result = ((result* 31)+((this.primaryExchange == null)? 0 :this.primaryExchange.hashCode()));
        result = ((result* 31)+((int)(this.latestUpdate^(this.latestUpdate >>> 32))));
        result = ((result* 31)+((this.high == null)? 0 :this.high.hashCode()));
        result = ((result* 31)+((int)(this.iexOpenTime^(this.iexOpenTime >>> 32))));
        result = ((result* 31)+((this.delayedPriceTime == null)? 0 :this.delayedPriceTime.hashCode()));
        result = ((result* 31)+((this.extendedPrice == null)? 0 :this.extendedPrice.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.week52Low)^(Double.doubleToLongBits(this.week52Low)>>> 32))));
        result = ((result* 31)+((this.highSource == null)? 0 :this.highSource.hashCode()));
        result = ((result* 31)+ this.latestPrice);
        result = ((result* 31)+((int)(this.marketCap^(this.marketCap >>> 32))));
        result = ((result* 31)+ this.iexClose);
        result = ((result* 31)+((this.volume == null)? 0 :this.volume.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.ytdChange)^(Double.doubleToLongBits(this.ytdChange)>>> 32))));
        result = ((result* 31)+((int)(this.lastTradeTime^(this.lastTradeTime >>> 32))));
        result = ((result* 31)+((this.closeSource == null)? 0 :this.closeSource.hashCode()));
        result = ((result* 31)+((this.extendedChange == null)? 0 :this.extendedChange.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+ this.iexRealtimePrice);
        result = ((result* 31)+((this.calculationPrice == null)? 0 :this.calculationPrice.hashCode()));
        result = ((result* 31)+((this.extendedChangePercent == null)? 0 :this.extendedChangePercent.hashCode()));
        result = ((result* 31)+((this.latestSource == null)? 0 :this.latestSource.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexOpen)^(Double.doubleToLongBits(this.iexOpen)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexBidPrice)^(Double.doubleToLongBits(this.iexBidPrice)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.previousClose)^(Double.doubleToLongBits(this.previousClose)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.peRatio)^(Double.doubleToLongBits(this.peRatio)>>> 32))));
        result = ((result* 31)+(this.isUSMarketOpen? 1 : 0));
        result = ((result* 31)+((this.low == null)? 0 :this.low.hashCode()));
        result = ((result* 31)+((this.oddLotDelayedPrice == null)? 0 :this.oddLotDelayedPrice.hashCode()));
        result = ((result* 31)+((this.extendedPriceTime == null)? 0 :this.extendedPriceTime.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.changePercent)^(Double.doubleToLongBits(this.changePercent)>>> 32))));
        result = ((result* 31)+((this.closeTime == null)? 0 :this.closeTime.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.week52High)^(Double.doubleToLongBits(this.week52High)>>> 32))));
        result = ((result* 31)+((this.openTime == null)? 0 :this.openTime.hashCode()));
        result = ((result* 31)+((this.close == null)? 0 :this.close.hashCode()));
        result = ((result* 31)+((int)(this.iexCloseTime^(this.iexCloseTime >>> 32))));
        result = ((result* 31)+((this.oddLotDelayedPriceTime == null)? 0 :this.oddLotDelayedPriceTime.hashCode()));
        result = ((result* 31)+ this.previousVolume);
        result = ((result* 31)+ this.iexRealtimeSize);
        result = ((result* 31)+((int)(this.iexLastUpdated^(this.iexLastUpdated >>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.change)^(Double.doubleToLongBits(this.change)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.iexAskPrice)^(Double.doubleToLongBits(this.iexAskPrice)>>> 32))));
        result = ((result* 31)+((this.latestVolume == null)? 0 :this.latestVolume.hashCode()));
        result = ((result* 31)+((this.lowSource == null)? 0 :this.lowSource.hashCode()));
        result = ((result* 31)+ this.iexVolume);
        result = ((result* 31)+ this.iexAskSize);
        result = ((result* 31)+((this.latestTime == null)? 0 :this.latestTime.hashCode()));
        result = ((result* 31)+ this.iexBidSize);
        result = ((result* 31)+((this.lowTime == null)? 0 :this.lowTime.hashCode()));
        result = ((result* 31)+((this.open == null)? 0 :this.open.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IexQuote) == false) {
            return false;
        }
        IexQuote rhs = ((IexQuote) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.symbol == rhs.symbol)||((this.symbol!= null)&&this.symbol.equals(rhs.symbol)))&&(this.highTime == rhs.highTime))&&(this.avgTotalVolume == rhs.avgTotalVolume))&&((this.companyName == rhs.companyName)||((this.companyName!= null)&&this.companyName.equals(rhs.companyName))))&&((this.openSource == rhs.openSource)||((this.openSource!= null)&&this.openSource.equals(rhs.openSource))))&&((this.delayedPrice == rhs.delayedPrice)||((this.delayedPrice!= null)&&this.delayedPrice.equals(rhs.delayedPrice))))&&(Double.doubleToLongBits(this.iexMarketPercent) == Double.doubleToLongBits(rhs.iexMarketPercent)))&&((this.primaryExchange == rhs.primaryExchange)||((this.primaryExchange!= null)&&this.primaryExchange.equals(rhs.primaryExchange))))&&(this.latestUpdate == rhs.latestUpdate))&&((this.high == rhs.high)||((this.high!= null)&&this.high.equals(rhs.high))))&&(this.iexOpenTime == rhs.iexOpenTime))&&((this.delayedPriceTime == rhs.delayedPriceTime)||((this.delayedPriceTime!= null)&&this.delayedPriceTime.equals(rhs.delayedPriceTime))))&&((this.extendedPrice == rhs.extendedPrice)||((this.extendedPrice!= null)&&this.extendedPrice.equals(rhs.extendedPrice))))&&(Double.doubleToLongBits(this.week52Low) == Double.doubleToLongBits(rhs.week52Low)))&&((this.highSource == rhs.highSource)||((this.highSource!= null)&&this.highSource.equals(rhs.highSource))))&&(this.latestPrice == rhs.latestPrice))&&(this.marketCap == rhs.marketCap))&&(this.iexClose == rhs.iexClose))&&((this.volume == rhs.volume)||((this.volume!= null)&&this.volume.equals(rhs.volume))))&&(Double.doubleToLongBits(this.ytdChange) == Double.doubleToLongBits(rhs.ytdChange)))&&(this.lastTradeTime == rhs.lastTradeTime))&&((this.closeSource == rhs.closeSource)||((this.closeSource!= null)&&this.closeSource.equals(rhs.closeSource))))&&((this.extendedChange == rhs.extendedChange)||((this.extendedChange!= null)&&this.extendedChange.equals(rhs.extendedChange))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.iexRealtimePrice == rhs.iexRealtimePrice))&&((this.calculationPrice == rhs.calculationPrice)||((this.calculationPrice!= null)&&this.calculationPrice.equals(rhs.calculationPrice))))&&((this.extendedChangePercent == rhs.extendedChangePercent)||((this.extendedChangePercent!= null)&&this.extendedChangePercent.equals(rhs.extendedChangePercent))))&&((this.latestSource == rhs.latestSource)||((this.latestSource!= null)&&this.latestSource.equals(rhs.latestSource))))&&(Double.doubleToLongBits(this.iexOpen) == Double.doubleToLongBits(rhs.iexOpen)))&&(Double.doubleToLongBits(this.iexBidPrice) == Double.doubleToLongBits(rhs.iexBidPrice)))&&(Double.doubleToLongBits(this.previousClose) == Double.doubleToLongBits(rhs.previousClose)))&&(Double.doubleToLongBits(this.peRatio) == Double.doubleToLongBits(rhs.peRatio)))&&(this.isUSMarketOpen == rhs.isUSMarketOpen))&&((this.low == rhs.low)||((this.low!= null)&&this.low.equals(rhs.low))))&&((this.oddLotDelayedPrice == rhs.oddLotDelayedPrice)||((this.oddLotDelayedPrice!= null)&&this.oddLotDelayedPrice.equals(rhs.oddLotDelayedPrice))))&&((this.extendedPriceTime == rhs.extendedPriceTime)||((this.extendedPriceTime!= null)&&this.extendedPriceTime.equals(rhs.extendedPriceTime))))&&(Double.doubleToLongBits(this.changePercent) == Double.doubleToLongBits(rhs.changePercent)))&&((this.closeTime == rhs.closeTime)||((this.closeTime!= null)&&this.closeTime.equals(rhs.closeTime))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&(Double.doubleToLongBits(this.week52High) == Double.doubleToLongBits(rhs.week52High)))&&((this.openTime == rhs.openTime)||((this.openTime!= null)&&this.openTime.equals(rhs.openTime))))&&((this.close == rhs.close)||((this.close!= null)&&this.close.equals(rhs.close))))&&(this.iexCloseTime == rhs.iexCloseTime))&&((this.oddLotDelayedPriceTime == rhs.oddLotDelayedPriceTime)||((this.oddLotDelayedPriceTime!= null)&&this.oddLotDelayedPriceTime.equals(rhs.oddLotDelayedPriceTime))))&&(this.previousVolume == rhs.previousVolume))&&(this.iexRealtimeSize == rhs.iexRealtimeSize))&&(this.iexLastUpdated == rhs.iexLastUpdated))&&(Double.doubleToLongBits(this.change) == Double.doubleToLongBits(rhs.change)))&&(Double.doubleToLongBits(this.iexAskPrice) == Double.doubleToLongBits(rhs.iexAskPrice)))&&((this.latestVolume == rhs.latestVolume)||((this.latestVolume!= null)&&this.latestVolume.equals(rhs.latestVolume))))&&((this.lowSource == rhs.lowSource)||((this.lowSource!= null)&&this.lowSource.equals(rhs.lowSource))))&&(this.iexVolume == rhs.iexVolume))&&(this.iexAskSize == rhs.iexAskSize))&&((this.latestTime == rhs.latestTime)||((this.latestTime!= null)&&this.latestTime.equals(rhs.latestTime))))&&(this.iexBidSize == rhs.iexBidSize))&&((this.lowTime == rhs.lowTime)||((this.lowTime!= null)&&this.lowTime.equals(rhs.lowTime))))&&((this.open == rhs.open)||((this.open!= null)&&this.open.equals(rhs.open))));
    }

}
