package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    private String symbol;

    private String baseAsset;
    private String quoteAsset;

    private MarketStatus status;

    private Integer baseAssetPrecision;
    private Integer quotePrecision;
    private Integer quoteAssetPrecision;
    private Integer baseCommissionPrecision;
    private Integer quoteCommissionPrecision;

    private List<OrderType> orderTypes;

    @JsonProperty("isSpotTradingAllowed")
    private Boolean spotTradingAllowed;

    @JsonProperty("isMarginTradingAllowed")
    private Boolean marginTradingAllowed;

    private Boolean quoteOrderQtyMarketAllowed;

    private Double quoteAmountPrecision;
    private Double baseSizePrecision;

    @JsonProperty("permissions")
    private List<MarketType> types;

    private Double maxQuoteAmount;
    private Double makerCommission;
    private Double takerCommission;
    private Double quoteAmountPrecisionMarket;
    private Double maxQuoteAmountMarket;

    private List<Object> filters;
}
