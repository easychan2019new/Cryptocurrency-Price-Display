package display.price.cryptocurrency.my.service;

import display.price.cryptocurrency.my.rest.CoinbaseTicker;
import display.price.cryptocurrency.my.rest.TickerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    private static Logger LOGGER = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CoinbaseTicker getCoinbaseTicker(String pair) {
        String url = "https://api.exchange.coinbase.com/products/" + pair + "/ticker";
        //LOGGER.info(url);
        ResponseEntity<CoinbaseTicker> responseEntity = restTemplate.getForEntity(url, CoinbaseTicker.class);
        return responseEntity.getBody();
    }

    @Override
    public BigDecimal[] getBitfinexTicker(String pair) {
        String url = "https://api-pub.bitfinex.com/v2/ticker/t" + pair.substring(0,3) + pair.substring(4);
        //LOGGER.info(url);
        ResponseEntity<BigDecimal[]> responseEntity = restTemplate.getForEntity(url, BigDecimal[].class);
        return responseEntity.getBody();
    }

    @Override
    public TickerResponse getTickers() {
        // transfer the data from public API to TickerResponse
        CoinbaseTicker coinbaseTickerBTC = getCoinbaseTicker("BTC-USD");
        CoinbaseTicker coinbaseTickerETH = getCoinbaseTicker("ETH-USD");
        BigDecimal[] bitfinexBTC = getBitfinexTicker("BTC-USD");
        BigDecimal[] bitfinexETH = getBitfinexTicker("ETH-USD");

        TickerResponse ticker = new TickerResponse();
        ticker.setCoinbaseBtcBuy(coinbaseTickerBTC.getAsk());
        ticker.setCoinbaseBtcSell(coinbaseTickerBTC.getBid());
        ticker.setCoinbaseBtcLast(coinbaseTickerBTC.getPrice());

        ticker.setCoinbaseEthBuy(coinbaseTickerETH.getAsk());
        ticker.setCoinbaseEthSell(coinbaseTickerETH.getBid());
        ticker.setCoinbaseEthLast(coinbaseTickerETH.getPrice());

        ticker.setBitfinexBtcBuy(bitfinexBTC[2]);
        ticker.setBitfinexBtcSell(bitfinexBTC[0]);
        ticker.setBitfinexBtcLast(bitfinexBTC[6]);

        ticker.setBitfinexEthBuy(bitfinexETH[2]);
        ticker.setBitfinexEthSell(bitfinexETH[0]);
        ticker.setBitfinexEthLast(bitfinexETH[6]);

        // BTC exchange buy/sell recommendation
        if (ticker.getBitfinexBtcBuy().intValue() < ticker.getCoinbaseBtcBuy().intValue()) {
            ticker.setRecommendBuyBtc("Bitfinex");
        } else {
            ticker.setRecommendBuyBtc("Coninbase");
        }

        if (ticker.getBitfinexBtcSell().intValue() > ticker.getCoinbaseBtcSell().intValue()) {
            ticker.setRecommendSellBtc("Bitfinex");
        } else {
            ticker.setRecommendSellBtc("Coninbase");
        }

        // ETH exchange buy/sell recommendation
        if (ticker.getBitfinexEthBuy().intValue() < ticker.getCoinbaseEthBuy().intValue()) {
            ticker.setRecommendBuyEth("Bitfinex");
        } else {
            ticker.setRecommendBuyEth("Coninbase");
        }

        if (ticker.getBitfinexEthSell().intValue() > ticker.getCoinbaseEthSell().intValue()) {
            ticker.setRecommendSellEth("Bitfinex");
        } else {
            ticker.setRecommendSellEth("Coninbase");
        }

        return ticker;
    }
}
