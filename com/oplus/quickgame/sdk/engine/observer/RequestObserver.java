package com.oplus.quickgame.sdk.engine.observer;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.j;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/engine/observer/RequestObserver.class */
public class RequestObserver extends ContentObserver {
    private static final Object mLock = new Object();
    private static Handler sHandler;
    private static HandlerThread sThread;
    private Callback mCallback;
    private Context mContext;
    private Map<String, Object> mReq;
    private Uri mUri;

    public RequestObserver(Context context, Map<String, Object> map, Callback callback, Uri uri) {
        super(createHandler());
        this.mContext = context;
        this.mReq = map;
        this.mCallback = callback;
        this.mUri = uri;
    }

    protected static Handler createHandler() {
        Handler handler;
        synchronized (mLock) {
            if (sThread == null || !sThread.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("xgame_router");
                sThread = handlerThread;
                handlerThread.start();
                Looper looper = sThread.getLooper();
                sHandler = looper != null ? new Handler(looper) : new Handler();
            }
            handler = sHandler;
        }
        return handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Uri uri = this.mUri;
        if (uri != null) {
            onChange(z, uri);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        Context context;
        Uri uri2 = this.mUri;
        if (uri2 == null || !uri2.equals(uri) || (context = this.mContext) == null) {
            return;
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onResponse(this.mReq, j.a(context, uri));
        }
        this.mContext.getContentResolver().unregisterContentObserver(this);
    }
}
