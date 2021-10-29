package display.price.cryptocurrency.my.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TickerResponse {

    private BigDecimal coinbaseBtcBuy;
    private BigDecimal coinbaseBtcSell;
    private BigDecimal coinbaseBtcLast;

    private BigDecimal coinbaseEthBuy;
    private BigDecimal coinbaseEthSell;
    private BigDecimal coinbaseEthLast;

    private BigDecimal bitfinexBtcBuy;
    private BigDecimal bitfinexBtcSell;
    private BigDecimal bitfinexBtcLast;

    private BigDecimal bitfinexEthBuy;
    private BigDecimal bitfinexEthSell;
    private BigDecimal bitfinexEthLast;

    private String recommendBuyBtc;
    private String recommendSellBtc;
    private String recommendBuyEth;
    private String recommendSellEth;

}
