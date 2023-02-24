package io.algostrategy.client.mexc.impl;

import io.algostrategy.client.mexc.MexcApiError;
import io.algostrategy.client.mexc.exception.MexcApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.algostrategy.client.mexc.impl.MexcApiServiceGenerator.getMexcApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                MexcApiError apiError = getMexcApiError(response);
                onFailure(call, new MexcApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new MexcApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof MexcApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new MexcApiException(t));
        }
    }
}
