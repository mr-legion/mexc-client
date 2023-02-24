package io.algostrategy.client.mexc;

import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;
import io.algostrategy.client.mexc.domain.market.MarketTicker;
import io.algostrategy.client.mexc.domain.market.OrderBook;

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

    // Market endpoints

    /**
     * Get market information.
     *
     * @return market info
     */
    ExchangeInfo getExchangeInfo();

    /**
     * Get market ticker information.
     *
     * @return market tickers
     */
    List<MarketTicker> getMarketTickers();

    /**
     * Get order book for the market.
     *
     * @param market market symbol (e.g. ETHBTC)
     * @param limit  depth of the order book. Default 100; max 5000.
     * @return order book
     */
    OrderBook getOrderBook(String market, Integer limit);
}