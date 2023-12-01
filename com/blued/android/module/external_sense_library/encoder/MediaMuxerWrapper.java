package com.blued.android.module.external_sense_library.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaMuxerWrapper.class */
public class MediaMuxerWrapper {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
    private final MediaMuxer b;
    private int c;
    private int d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(MediaFormat mediaFormat) {
        int addTrack;
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("muxer already started");
            }
            addTrack = this.b.addTrack(mediaFormat);
        }
        return addTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            if (this.d > 0) {
                this.b.writeSampleData(i, byteBuffer, bufferInfo);
            }
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.e;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        boolean z;
        synchronized (this) {
            int i = this.d + 1;
            this.d = i;
            if (this.c > 0 && i == this.c) {
                this.b.start();
                this.e = true;
                notifyAll();
            }
            z = this.e;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        synchronized (this) {
            int i = this.d - 1;
            this.d = i;
            if (this.c > 0 && i <= 0) {
                this.b.stop();
                this.b.release();
                this.e = false;
            }
        }
    }
}
