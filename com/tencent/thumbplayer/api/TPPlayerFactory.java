package com.tencent.thumbplayer.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.f.a.a;
import com.tencent.thumbplayer.f.b;
import com.tencent.thumbplayer.tplayer.d;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerFactory.class */
public class TPPlayerFactory {
    private static final String LOG_TAG = "TPPlayerFactory";

    public static ITPRichMediaAsyncRequester createRichMediaASyncRequester(Context context) {
        try {
            return new a(context.getApplicationContext());
        } catch (UnsupportedOperationException e) {
            TPLogUtil.e(LOG_TAG, "Failed to create rich media async requester:" + e.getMessage());
            return null;
        }
    }

    public static ITPRichMediaSynchronizer createRichMediaSynchronizer(Context context) {
        try {
            return new b(context.getApplicationContext());
        } catch (UnsupportedOperationException e) {
            TPLogUtil.e(LOG_TAG, "Failed to create rich media synchronizer:" + e.getMessage());
            return null;
        }
    }

    public static ITPPlayer createTPPlayer(Context context) {
        return (ITPPlayer) new d(new com.tencent.thumbplayer.tplayer.b(context)).a();
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper) {
        return (ITPPlayer) new d(new com.tencent.thumbplayer.tplayer.b(context, looper)).a();
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper, Looper looper2) {
        return (ITPPlayer) new d(new com.tencent.thumbplayer.tplayer.b(context, looper, looper2)).a();
    }

    public static ITPPlayer createTPPlayer(Context context, Looper looper, Looper looper2, com.tencent.thumbplayer.e.b bVar) {
        return (ITPPlayer) new d(new com.tencent.thumbplayer.tplayer.b(context, looper, looper2, bVar)).a();
    }

    public static ITPPlayer createTPPlayer(Context context, com.tencent.thumbplayer.e.b bVar) {
        return (ITPPlayer) new d(new com.tencent.thumbplayer.tplayer.b(context, null, null, bVar)).a();
    }

    public static TPSurface createTPSurface(SurfaceTexture surfaceTexture) {
        return new TPSurface(surfaceTexture);
    }
}
