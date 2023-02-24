package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiAsyncRestClient;
import io.algostrategy.client.mexc.MexcApiClientFactory;
import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;
import io.algostrategy.client.mexc.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MexcApiAsyncRestClientImplTest {

    private MexcApiAsyncRestClient mexcApiAsyncRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.mexcApiAsyncRestClient = MexcApiClientFactory.newInstance(apiCredentials).newAsyncRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        List<Asset> assets = mexcApiAsyncRestClient.getAssets().get();
        assertThat(assets, is(not(empty())));
    }

    @Test
    public void getExchangeInfo_ShouldReturnExchangeInfo() throws ExecutionException, InterruptedException {
        ExchangeInfo exchangeInfo = mexcApiAsyncRestClient.getExchangeInfo().get();
        assertNotNull(exchangeInfo);
        assertThat(exchangeInfo.getMarkets(), is(not(empty())));
    }
}