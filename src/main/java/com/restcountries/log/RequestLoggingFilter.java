package com.restcountries.log;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;

@Filter("/**")
public class RequestLoggingFilter implements HttpServerFilter {

    @Inject
    RequestCounter counter;

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        counter.increment(request.getPath());
        return chain.proceed(request);
    }
}