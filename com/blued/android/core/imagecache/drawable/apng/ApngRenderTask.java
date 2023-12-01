package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/ApngRenderTask.class */
public class ApngRenderTask implements Runnable {
    private ApngDrawable a;
    private ApngFrameDecode b;

    public ApngRenderTask(ApngDrawable apngDrawable, ApngFrameDecode apngFrameDecode) {
        this.a = apngDrawable;
        this.b = apngFrameDecode;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.a.e + 1;
        int i2 = i;
        if (i >= this.b.b) {
            if (!this.a.h()) {
                return;
            }
            this.a.e = -1;
            i2 = 0;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Bitmap b = this.b.b(i2);
        if (this.a.j != null && this.a.j != b) {
            this.a.h.b(this.a.j);
        }
        this.a.j = b;
        this.a.e++;
        this.a.f.schedule(this, (int) (this.b.a(i2) - (SystemClock.uptimeMillis() - uptimeMillis)), TimeUnit.MILLISECONDS);
        if (this.a.isVisible() && this.a.isRunning() && !this.a.i.hasMessages(0)) {
            this.a.i.sendEmptyMessageAtTime(0, 0L);
        }
    }
}
