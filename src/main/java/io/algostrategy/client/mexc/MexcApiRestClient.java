package io.algostrategy.client.mexc;

import io.algostrategy.client.mexc.domain.general.Asset;

import java.util.List;

/**
 * Mexc API facade, supporting synchronous/blocking access Mexc's REST API.
 */
public interface MexcApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    List<Asset> getAssets();
}