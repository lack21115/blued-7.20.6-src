package com.blued.android.third_library;

import android.media.AudioRecord;
import android.os.Handler;
import com.naman14.androidlame.AndroidLame;
import com.naman14.androidlame.LameBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/third_library/BluedMp3Recorder.class */
public class BluedMp3Recorder {
    private ErrorListener a;
    private Handler b;
    private boolean c;
    private String d;
    private volatile int e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/third_library/BluedMp3Recorder$ErrorListener.class */
    public interface ErrorListener {
        void a();
    }

    public BluedMp3Recorder(String str) {
        this(str, null, null);
    }

    public BluedMp3Recorder(String str, ErrorListener errorListener, Handler handler) {
        this.c = false;
        this.d = str;
        this.a = errorListener;
        this.b = handler;
    }

    private void a(int i, short[] sArr) {
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.e = Math.abs((int) (Math.log10(j / i) * 10.0d));
                return;
            } else {
                j += sArr[i3] * sArr[i3];
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int minBufferSize;
        AudioRecord audioRecord;
        int i;
        boolean z;
        int i2;
        int i3 = 8000;
        AudioRecord audioRecord2 = null;
        do {
            minBufferSize = AudioRecord.getMinBufferSize(i3, 16, 2);
            try {
                audioRecord = new AudioRecord(1, i3, 16, 2, minBufferSize * 2);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                audioRecord = audioRecord2;
                if (i3 != 44100) {
                    i = 44100;
                    z = true;
                    audioRecord = audioRecord2;
                }
            }
            z = false;
            i = i3;
            i3 = i;
            audioRecord2 = audioRecord;
        } while (z);
        if (audioRecord == null) {
            b();
            f();
            return;
        }
        short[] sArr = new short[i * 2 * 5];
        byte[] bArr = new byte[(int) ((i2 * 2 * 1.25d) + 7200.0d)];
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.d));
            AndroidLame a = new LameBuilder().a(i).d(1).c(32).b(i).a();
            try {
                audioRecord.startRecording();
                while (this.c) {
                    int read = audioRecord.read(sArr, 0, minBufferSize);
                    if (read > 0) {
                        a(read, sArr);
                        int a2 = a.a(sArr, sArr, read, bArr);
                        if (a2 > 0) {
                            try {
                                fileOutputStream.write(bArr, 0, a2);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                int a3 = a.a(bArr);
                if (a3 > 0) {
                    try {
                        fileOutputStream.write(bArr, 0, a3);
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                try {
                    audioRecord.stop();
                    audioRecord.release();
                } catch (IllegalStateException e4) {
                    e4.printStackTrace();
                }
                a.a();
            } catch (IllegalStateException e5) {
                e5.printStackTrace();
                b();
                f();
            }
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            b();
            f();
        }
    }

    private void f() {
        Handler handler = this.b;
        if (handler == null || this.a == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.blued.android.third_library.BluedMp3Recorder.2
            @Override // java.lang.Runnable
            public void run() {
                BluedMp3Recorder.this.a.a();
            }
        });
    }

    public void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        new Thread() { // from class: com.blued.android.third_library.BluedMp3Recorder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                BluedMp3Recorder.this.e();
            }
        }.start();
    }

    public void b() {
        this.c = false;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        if (this.c) {
            return this.e;
        }
        return 0;
    }
}
