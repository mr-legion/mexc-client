package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketType {
    SPOT,
    MARGIN
}
