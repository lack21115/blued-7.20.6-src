package com.blued.android.core.image.http;

import android.os.Looper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.http.StatusCode;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/http/HttpRequestListener.class */
public class HttpRequestListener implements RequestListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageLoadResult f9557a;

    public HttpRequestListener(ImageLoadResult imageLoadResult) {
        this.f9557a = imageLoadResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageLoadResult imageLoadResult = this.f9557a;
        if (imageLoadResult == null || !imageLoadResult.c()) {
            return;
        }
        this.f9557a.a();
        this.f9557a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GlideException glideException) {
        ImageLoadResult imageLoadResult = this.f9557a;
        if (imageLoadResult == null || !imageLoadResult.c()) {
            return;
        }
        Exception exc = null;
        int i = 0;
        if (glideException != null) {
            Exception a2 = glideException.a();
            if (a2 != null) {
                i = 0;
                exc = a2;
                if (a2 instanceof IOException) {
                    i = StatusCode.a((IOException) a2);
                    exc = a2;
                }
            } else {
                exc = new Exception(glideException.getMessage());
                i = 0;
            }
        }
        Exception exc2 = exc;
        if (exc == null) {
            exc2 = new Exception("unknown");
        }
        if (ImageLoader.a()) {
            Log.e("IMAGE", "onLoadFailed : " + i + ", " + exc2);
        }
        this.f9557a.a(i, exc2);
        this.f9557a.b();
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(final GlideException glideException, Object obj, Target target, boolean z) {
        if (ImageLoader.a()) {
            Log.e("IMAGE", "HttpRequestListener onLoadFailed");
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a(glideException);
            return false;
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.http.HttpRequestListener.1
            @Override // java.lang.Runnable
            public void run() {
                HttpRequestListener.this.a(glideException);
            }
        });
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
        if (ImageLoader.a()) {
            Log.c("IMAGE", "HttpRequestListener onResourceReady");
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a();
            return false;
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.core.image.http.HttpRequestListener.2
            @Override // java.lang.Runnable
            public void run() {
                HttpRequestListener.this.a();
            }
        });
        return false;
    }
}
