package io.algostrategy.client.mexc;

import io.algostrategy.client.mexc.impl.MexcApiAsyncRestClientImpl;
import io.algostrategy.client.mexc.impl.MexcApiRestClientImpl;
import io.algostrategy.client.mexc.impl.MexcApiService;
import io.algostrategy.client.mexc.impl.MexcApiServiceGenerator;
import io.algostrategy.client.mexc.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Mexc API client objects.
 */
public class MexcApiClientFactory {

    private final MexcApiServiceGenerator serviceGenerator;

    private ApiCredentials apiCredentials;

    public MexcApiClientFactory() {
        this.serviceGenerator = new MexcApiServiceGenerator(new OkHttpClient());
    }

    public MexcApiClientFactory(ApiCredentials apiCredentials) {
        this.serviceGenerator = new MexcApiServiceGenerator(new OkHttpClient());
        this.apiCredentials = apiCredentials;
    }

    public MexcApiClientFactory(ApiCredentials apiCredentials, ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiCredentials, apiInteractionConfig);
    }

    public MexcApiClientFactory(OkHttpClient client,
                                   ApiCredentials apiCredentials,
                                   ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new MexcApiServiceGenerator(newClient);
        this.apiCredentials = apiCredentials;
    }

    /**
     * New instance without authentication.
     *
     * @return the Binance API client factory
     */
    public static MexcApiClientFactory newInstance() {
        return new MexcApiClientFactory();
    }

    /**
     * New instance with authentication.
     *
     * @return the Binance API client factory
     */
    public static MexcApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new MexcApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public MexcApiRestClient newRestClient() {
        return new MexcApiRestClientImpl(serviceGenerator.createService(MexcApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public MexcApiAsyncRestClient newAsyncRestClient() {
        return new MexcApiAsyncRestClientImpl(serviceGenerator.createService(MexcApiService.class, apiCredentials));
    }
}
