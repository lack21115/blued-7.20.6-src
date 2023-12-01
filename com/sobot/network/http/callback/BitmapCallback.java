package com.sobot.network.http.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/BitmapCallback.class */
public abstract class BitmapCallback extends Callback<Bitmap> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sobot.network.http.callback.Callback
    public Bitmap parseNetworkResponse(Response response) throws Exception {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }
}
