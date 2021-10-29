package display.price.cryptocurrency.my.controller;

import display.price.cryptocurrency.my.rest.CoinbaseTicker;
import display.price.cryptocurrency.my.rest.TickerResponse;
import display.price.cryptocurrency.my.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/price")
@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/tickers/Coinbase")
    public CoinbaseTicker getCoinbaseTicker() {
        return priceService.getCoinbaseTicker("BTC-USD");
    }

    @GetMapping("/tickers/Bitfinex")
    public BigDecimal[] getBitfinexTicker() {
        return priceService.getBitfinexTicker("BTC-USD");
    }

    @GetMapping("/tickers/all")
    public TickerResponse getTickers() {
        return priceService.getTickers();
    }
}
