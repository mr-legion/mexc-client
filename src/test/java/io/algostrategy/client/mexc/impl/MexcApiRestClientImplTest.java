package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiClientFactory;
import io.algostrategy.client.mexc.MexcApiRestClient;
import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MexcApiRestClientImplTest {

    private MexcApiRestClient mexcApiRestClient;

    @BeforeEach
    public void setUp() {
        String apiKey = System.getenv("API_KEY");
        String secret = System.getenv("SECRET");
        ApiCredentials apiCredentials = new ApiCredentials(apiKey, secret);
        this.mexcApiRestClient = MexcApiClientFactory.newInstance(apiCredentials).newRestClient();
    }

    @Test
    public void getAssets_ShouldReturnAssets() {
        List<Asset> assets = mexcApiRestClient.getAssets();
        assertThat(assets, is(not(empty())));
    }
}