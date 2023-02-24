package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.domain.general.Asset;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

import static io.algostrategy.client.mexc.constant.MexcApiConstants.AUTHORIZATION_REQUIRED_HEADER;

/**
 * Mexc's REST API URL mappings.
 */
public interface MexcApiService {

    // General endpoints

    @Headers(AUTHORIZATION_REQUIRED_HEADER)
    @GET("/api/v3/capital/config/getall")
    Call<List<Asset>> getAssets(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);
}
