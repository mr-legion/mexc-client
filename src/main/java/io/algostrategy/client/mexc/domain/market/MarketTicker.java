package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private String symbol;

    private Double lastPrice;

    private Double askPrice;
    private Double askQty;

    private Double bidPrice;
    private Double bidQty;

    private Double openPrice;
    private Double lowPrice;
    private Double highPrice;

    private Double priceChange;
    private Double priceChangePercent;
    private Double prevClosePrice;

    private Double volume;
    private Double quoteVolume;

    private Long openTime;
    private Long closeTime;

    private Object count;
}
