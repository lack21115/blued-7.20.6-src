package com.blued.android.module.external_sense_library.test;

import android.opengl.GLES20;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.widget.ProgressBar;
import com.blued.android.core.AppMethods;
import com.blued.android.module.external_sense_library.test.gles.EglCore;
import com.blued.android.module.external_sense_library.test.gles.OffscreenSurface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/ReadPixelsTask.class */
public class ReadPixelsTask extends AsyncTask<Void, Integer, Long> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11279a = ReadPixelsTask.class.getSimpleName();
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f11280c;
    private int d;
    private ProgressBar e;

    private long a(OffscreenSurface offscreenSurface) {
        offscreenSurface.d();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.b * this.f11280c * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        Log.d(f11279a, "Running...");
        float f = 1.0f / this.d;
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = this.d;
            if (i2 >= i3) {
                Log.d(f11279a, "done");
                long nanoTime = System.nanoTime();
                try {
                    offscreenSurface.a(new File(Environment.getExternalStorageDirectory(), "test.png"));
                    Log.d(f11279a, "Saved frame in " + ((System.nanoTime() - nanoTime) / 1000000) + "ms");
                    return j;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (i2 % (i3 / 8) == 0) {
                publishProgress(Integer.valueOf(i2));
            }
            float f2 = i2 * f;
            float f3 = 1.0f - f2;
            float f4 = (f2 + f3) / 2.0f;
            GLES20.glClearColor(f2, f3, f4, 1.0f);
            GLES20.glClear(16384);
            GLES20.glEnable(3089);
            int i4 = this.b;
            int i5 = i4 / 4;
            int i6 = this.f11280c;
            GLES20.glScissor(i5, i6 / 4, i4 / 2, i6 / 2);
            GLES20.glClearColor(f4, f3, f2, 1.0f);
            GLES20.glClear(16384);
            GLES20.glDisable(3089);
            GLES20.glFinish();
            GLES20.glReadPixels(0, 0, 1, 1, 6408, 5121, allocateDirect);
            long nanoTime2 = System.nanoTime();
            GLES20.glReadPixels(0, 0, this.b, this.f11280c, 6408, 5121, allocateDirect);
            j += System.nanoTime() - nanoTime2;
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Long doInBackground(Void... voidArr) {
        OffscreenSurface offscreenSurface;
        EglCore eglCore;
        Process.setThreadPriority(-2);
        try {
            eglCore = new EglCore(null, 0);
            try {
                offscreenSurface = new OffscreenSurface(eglCore, this.b, this.f11280c);
            } catch (Throwable th) {
                th = th;
                offscreenSurface = null;
            }
            try {
                Log.d(f11279a, "Buffer size " + this.b + "x" + this.f11280c);
                long a2 = a(offscreenSurface);
                offscreenSurface.e();
                eglCore.a();
                if (a2 > 0) {
                    a2 /= this.d;
                }
                return Long.valueOf(a2);
            } catch (Throwable th2) {
                th = th2;
                if (offscreenSurface != null) {
                    offscreenSurface.e();
                }
                if (eglCore != null) {
                    eglCore.a();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            offscreenSurface = null;
            eglCore = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Long l) {
        String str = f11279a;
        Log.d(str, "onPostExecute result=" + l);
        if (l.longValue() < 0) {
            AppMethods.a((CharSequence) "没有保存完成");
            return;
        }
        AppMethods.a((CharSequence) ("保存中.." + (l.longValue() / 1000)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        this.e.setProgress(numArr[0].intValue());
    }
}
