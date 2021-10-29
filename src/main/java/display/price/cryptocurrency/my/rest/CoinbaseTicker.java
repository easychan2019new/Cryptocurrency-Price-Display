package display.price.cryptocurrency.my.rest;

import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;


@Data
public class CoinbaseTicker {

    private int trade_id;
    private BigDecimal price;
    private BigDecimal size;
    private Date time;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal volume;

}
