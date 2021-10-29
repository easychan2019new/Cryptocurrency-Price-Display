package display.price.cryptocurrency.my.service;

import display.price.cryptocurrency.my.rest.CoinbaseTicker;
import display.price.cryptocurrency.my.rest.TickerResponse;

import java.math.BigDecimal;

public interface PriceService {
    CoinbaseTicker getCoinbaseTicker(String pair);
    BigDecimal[] getBitfinexTicker(String pair);
    TickerResponse getTickers();
}
