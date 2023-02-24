package io.algostrategy.client.mexc;

import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;
import io.algostrategy.client.mexc.domain.market.MarketTicker;
import io.algostrategy.client.mexc.domain.market.OrderBook;

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

    // Market endpoints

    /**
     * Get market information (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<ExchangeInfo> getExchangeInfo();

    /**
     * Get market ticker information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<List<MarketTicker>> getMarketTickers();

    /**
     * Get order book for the market (asynchronous).
     *
     * @param market market symbol (e.g. ETHBTC)
     * @param limit  depth of the order book. Default 100; max 5000.
     * @return order book
     */
    CompletableFuture<OrderBook> getOrderBook(String market, Integer limit);
}