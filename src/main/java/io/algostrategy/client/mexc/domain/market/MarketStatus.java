package io.algostrategy.client.mexc.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Market status.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum MarketStatus {
    ENABLED,
    DISABLED
}
