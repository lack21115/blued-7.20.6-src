package com.blued.android.core.imagecache.drawable.apng;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngInvalidationHandler.class */
public class ApngInvalidationHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<ApngDrawable> f9637a;

    public ApngInvalidationHandler(ApngDrawable apngDrawable) {
        super(Looper.getMainLooper());
        this.f9637a = new WeakReference<>(apngDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ApngDrawable apngDrawable = this.f9637a.get();
        if (apngDrawable != null) {
            apngDrawable.invalidateSelf();
        }
    }
}
