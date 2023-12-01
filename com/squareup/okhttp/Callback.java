package com.squareup.okhttp;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/squareup/okhttp/Callback.class */
public interface Callback {
    void onFailure(Request request, IOException iOException);

    void onResponse(Response response) throws IOException;
}
