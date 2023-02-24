package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Exchange information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {

    private String timezone;

    private Long serverTime;

    private List<Object> rateLimits;
    private List<Object> exchangeFilters;

    @JsonProperty("symbols")
    private List<MarketInfo> markets;
}