package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiAsyncRestClient;
import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;
import io.algostrategy.client.mexc.domain.market.MarketTicker;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static io.algostrategy.client.mexc.constant.MexcApiConstants.DEFAULT_RECEIVING_WINDOW;

/**
 * Implementation of Mexc's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class MexcApiAsyncRestClientImpl implements MexcApiAsyncRestClient {

    private final MexcApiService mexcApiService;

    public MexcApiAsyncRestClientImpl(MexcApiService mexcApiService) {
        this.mexcApiService = mexcApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<List<Asset>> getAssets() {
        CompletableFuture<List<Asset>> future = new CompletableFuture<>();
        mexcApiService.getAssets(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli())
                .enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<ExchangeInfo> getExchangeInfo() {
        CompletableFuture<ExchangeInfo> future = new CompletableFuture<>();
        mexcApiService.getExchangeInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<List<MarketTicker>> getMarketTickers() {
        CompletableFuture<List<MarketTicker>> future = new CompletableFuture<>();
        mexcApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
