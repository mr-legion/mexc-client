package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Order types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType {
    LIMIT,
    LIMIT_MAKER,
    MARKET
}
