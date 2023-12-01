package com.blued.android.core.imagecache;

import com.blued.android.core.imagecache.FailReason;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadDrawableException.class */
public class LoadDrawableException extends Throwable {

    /* renamed from: a  reason: collision with root package name */
    FailReason.FailType f9585a;
    Throwable b;

    public LoadDrawableException(FailReason.FailType failType, Throwable th) {
        this.f9585a = FailReason.FailType.SUCCESS;
        this.b = null;
        this.f9585a = failType;
        this.b = th;
    }
}
