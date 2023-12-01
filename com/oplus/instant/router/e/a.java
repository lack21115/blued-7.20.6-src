package com.oplus.instant.router.e;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.g.e;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/e/a.class */
public class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f24291a;
    private static HandlerThread b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f24292c = new Object();
    private Context d;
    private Map<String, Object> e;
    private Callback f;
    private Uri g;

    public a(Context context, Map<String, Object> map, Callback callback, Uri uri) {
        super(a());
        this.d = context;
        this.e = map;
        this.f = callback;
        this.g = uri;
    }

    protected static Handler a() {
        Handler handler;
        synchronized (f24292c) {
            if (b == null || !b.isAlive()) {
                HandlerThread handlerThread = new HandlerThread("instant_callback");
                b = handlerThread;
                handlerThread.start();
                Looper looper = b.getLooper();
                f24291a = looper != null ? new Handler(looper) : new Handler();
            }
            handler = f24291a;
        }
        return handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Uri uri = this.g;
        if (uri != null) {
            onChange(z, uri);
            return;
        }
        Context context = this.d;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        Context context;
        Uri uri2 = this.g;
        if (uri2 == null || !uri2.equals(uri) || (context = this.d) == null) {
            return;
        }
        Callback callback = this.f;
        if (callback != null) {
            callback.onResponse(this.e, e.a(context, uri));
        }
        this.d.getContentResolver().unregisterContentObserver(this);
    }
}
