package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiRestClient;
import io.algostrategy.client.mexc.domain.general.Asset;

import java.time.Instant;
import java.util.List;

import static io.algostrategy.client.mexc.constant.MexcApiConstants.DEFAULT_RECEIVING_WINDOW;

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
        return MexcApiServiceGenerator.executeSync(
                mexcApiService.getAssets(DEFAULT_RECEIVING_WINDOW, Instant.now().toEpochMilli())
        );
    }
}
