package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngRenderTask.class */
public class ApngRenderTask implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private ApngDrawable f9638a;
    private ApngFrameDecode b;

    public ApngRenderTask(ApngDrawable apngDrawable, ApngFrameDecode apngFrameDecode) {
        this.f9638a = apngDrawable;
        this.b = apngFrameDecode;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.f9638a.e + 1;
        int i2 = i;
        if (i >= this.b.b) {
            if (!this.f9638a.h()) {
                return;
            }
            this.f9638a.e = -1;
            i2 = 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Bitmap b = this.b.b(i2);
        if (this.f9638a.j != null && this.f9638a.j != b) {
            this.f9638a.h.b(this.f9638a.j);
        }
        this.f9638a.j = b;
        this.f9638a.e++;
        this.f9638a.f.schedule(this, (int) (this.b.a(i2) - (SystemClock.uptimeMillis() - uptimeMillis)), TimeUnit.MILLISECONDS);
        if (this.f9638a.isVisible() && this.f9638a.isRunning() && !this.f9638a.i.hasMessages(0)) {
            this.f9638a.i.sendEmptyMessageAtTime(0, 0L);
        }
    }
}
