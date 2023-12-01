package com.sobot.network.http.callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/Callback.class */
public abstract class Callback<T> {
    public static Callback CALLBACK_DEFAULT = new Callback() { // from class: com.sobot.network.http.callback.Callback.1
        @Override // com.sobot.network.http.callback.Callback
        public void onError(Call call, Exception exc) {
        }

        @Override // com.sobot.network.http.callback.Callback
        public void onResponse(Object obj) {
        }

        @Override // com.sobot.network.http.callback.Callback
        public Object parseNetworkResponse(Response response) throws Exception {
            return null;
        }
    };

    public void inProgress(float f) {
    }

    public void onAfter() {
    }

    public void onBefore(Request request) {
    }

    public abstract void onError(Call call, Exception exc);

    public abstract void onResponse(T t);

    public abstract T parseNetworkResponse(Response response) throws Exception;
}
