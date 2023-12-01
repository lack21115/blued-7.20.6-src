package com.mokee.volley;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/ResponseDelivery.class */
public interface ResponseDelivery {
    void postError(Request<?> request, VolleyError volleyError);

    void postResponse(Request<?> request, Response<?> response);

    void postResponse(Request<?> request, Response<?> response, Runnable runnable);
}
