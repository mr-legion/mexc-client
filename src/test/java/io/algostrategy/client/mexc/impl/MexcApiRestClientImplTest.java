package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiClientFactory;
import io.algostrategy.client.mexc.MexcApiRestClient;
import io.algostrategy.client.mexc.domain.general.Asset;
import io.algostrategy.client.mexc.domain.market.ExchangeInfo;
import io.algostrategy.client.mexc.domain.market.MarketTicker;
import io.algostrategy.client.mexc.domain.market.OrderBook;
import io.algostrategy.client.mexc.security.ApiCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void getExchangeInfo_ShouldReturnExchangeInfo() {
        ExchangeInfo exchangeInfo = mexcApiRestClient.getExchangeInfo();
        assertNotNull(exchangeInfo);
        assertThat(exchangeInfo.getMarkets(), is(not(empty())));
    }

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        List<MarketTicker> marketTickers = mexcApiRestClient.getMarketTickers();
        assertThat(marketTickers, allOf(notNullValue(), is(not(empty()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForETHBTC() {
        OrderBook orderBook = mexcApiRestClient.getOrderBook("BTCUSDT", 10);
        assertNotNull(orderBook);
        assertThat(orderBook.getAsks(), is(not(empty())));
        assertThat(orderBook.getBids(), is(not(empty())));
    }
}