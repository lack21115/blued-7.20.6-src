package com.mokee.volley;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/RetryPolicy.class */
public interface RetryPolicy {
    int getCurrentRetryCount();

    int getCurrentTimeout();

    void retry(VolleyError volleyError) throws VolleyError;
}
