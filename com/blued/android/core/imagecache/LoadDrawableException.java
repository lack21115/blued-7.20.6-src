package com.blued.android.core.imagecache;

import com.blued.android.core.imagecache.FailReason;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/LoadDrawableException.class */
public class LoadDrawableException extends Throwable {
    FailReason.FailType a;
    Throwable b;

    public LoadDrawableException(FailReason.FailType failType, Throwable th) {
        this.a = FailReason.FailType.SUCCESS;
        this.b = null;
        this.a = failType;
        this.b = th;
    }
}
