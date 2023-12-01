package com.sobot.network.http.callback;

import java.io.IOException;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/StringCallback.class */
public abstract class StringCallback extends Callback<String> {
    @Override // com.sobot.network.http.callback.Callback
    public String parseNetworkResponse(Response response) throws IOException {
        return response.body().string();
    }
}
