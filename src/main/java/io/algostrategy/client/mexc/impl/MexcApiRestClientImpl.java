package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiRestClient;
import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;

import java.time.Instant;
import java.util.List;

import static io.algostrategy.client.mexc.constant.MexcApiConstants.DEFAULT_RECEIVING_WINDOW;
import static io.algostrategy.client.mexc.impl.MexcApiServiceGenerator.executeSync;

/**
 * Implementation of Mexc's REST API using Retrofit with synchronous/blocking method calls.
 */
public class MexcApiRestClientImpl implements MexcApiRestClient {

    private final MexcApiService mexcApiService;

    public MexcApiRestClientImpl(MexcApiService mexcApiService) {
        this.mexcApiService = mexcApiService;
    }

    // General endpoints

    @Override
    public List<Asset> getAssets() {
        return executeSync(
                mexcApiService.getAssets(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli())
        );
    }

    // Market endpoints

    @Override
    public ExchangeInfo getExchangeInfo() {
        return executeSync(mexcApiService.getExchangeInfo());
    }
}
