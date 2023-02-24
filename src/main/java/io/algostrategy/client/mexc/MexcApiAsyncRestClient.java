package io.algostrategy.client.mexc;

import io.algostrategy.client.mexc.domain.general.Asset;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Mexc API facade, supporting asynchronous/non-blocking access Mexc's REST API.
 */
public interface MexcApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<List<Asset>> getAssets();
}