package com.blued.android.module.external_sense_library.encoder;

import android.media.MediaCodec;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaEncoder.class */
public abstract class MediaEncoder implements Runnable {
    protected final Object a;
    protected volatile boolean b;
    protected volatile boolean c;
    protected boolean d;
    protected boolean e;
    protected int f;
    protected MediaCodec g;
    protected final WeakReference<MediaMuxerWrapper> h;
    protected final MediaEncoderListener i;
    private int j;
    private MediaCodec.BufferInfo k;
    private long l;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/MediaEncoder$MediaEncoderListener.class */
    public interface MediaEncoderListener {
        void a(MediaEncoder mediaEncoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        try {
            this.i.a(this);
        } catch (Exception e) {
            Log.e("MediaEncoder", "failed onStopped", e);
        }
        this.b = false;
        MediaCodec mediaCodec = this.g;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.g.release();
                this.g = null;
            } catch (Exception e2) {
                Log.e("MediaEncoder", "failed releasing MediaCodec", e2);
            }
        }
        if (this.e) {
            WeakReference<MediaMuxerWrapper> weakReference = this.h;
            MediaMuxerWrapper mediaMuxerWrapper = weakReference != null ? weakReference.get() : null;
            if (mediaMuxerWrapper != null) {
                try {
                    mediaMuxerWrapper.c();
                } catch (Exception e3) {
                    Log.e("MediaEncoder", "failed stopping muxer", e3);
                }
            }
        }
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (this.b) {
            ByteBuffer[] inputBuffers = this.g.getInputBuffers();
            while (this.b) {
                int dequeueInputBuffer = this.g.dequeueInputBuffer(10000L);
                Log.e("MediaEncoder", "inputBufferIndex: " + dequeueInputBuffer);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i > 0) {
                        this.g.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                        return;
                    }
                    this.d = true;
                    this.g.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                    return;
                }
            }
        }
    }

    public boolean c() {
        synchronized (this.a) {
            if (this.b && !this.c) {
                this.j++;
                this.a.notifyAll();
                return true;
            }
            return false;
        }
    }

    protected void d() {
        a(null, 0, f());
    }

    protected void e() {
        MediaCodec mediaCodec = this.g;
        if (mediaCodec == null) {
            return;
        }
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        Log.e("MediaEncoder", "encoderOutputBuffers: " + outputBuffers.length);
        MediaMuxerWrapper mediaMuxerWrapper = this.h.get();
        if (mediaMuxerWrapper == null) {
            Log.w("MediaEncoder", "muxer is unexpectedly null");
            return;
        }
        Log.e("MediaEncoder", "mIsCapturing: " + this.b);
        int i = 0;
        while (this.b) {
            int dequeueOutputBuffer = this.g.dequeueOutputBuffer(this.k, 10000L);
            Log.e("MediaEncoder", "encoderStatus: " + dequeueOutputBuffer);
            if (dequeueOutputBuffer == -1) {
                if (this.d) {
                    continue;
                } else {
                    int i2 = i + 1;
                    i = i2;
                    if (i2 > 5) {
                        return;
                    }
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.g.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (this.e) {
                    throw new RuntimeException("format changed twice");
                }
                this.f = mediaMuxerWrapper.a(this.g.getOutputFormat());
                this.e = true;
                if (mediaMuxerWrapper.b()) {
                    continue;
                } else {
                    synchronized (mediaMuxerWrapper) {
                        while (!mediaMuxerWrapper.a()) {
                            try {
                                mediaMuxerWrapper.wait(100L);
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                    }
                }
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if ((this.k.flags & 2) != 0) {
                    this.k.size = 0;
                }
                if (this.k.size != 0) {
                    if (!this.e) {
                        throw new RuntimeException("drain:muxer hasn't started");
                    }
                    this.k.presentationTimeUs = f();
                    mediaMuxerWrapper.a(this.f, byteBuffer, this.k);
                    this.l = this.k.presentationTimeUs;
                    i = 0;
                }
                this.g.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.k.flags & 4) != 0) {
                    this.b = false;
                    return;
                }
            } else {
                continue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long f() {
        long nanoTime = System.nanoTime() / 1000;
        long j = this.l;
        long j2 = nanoTime;
        if (nanoTime < j) {
            j2 = nanoTime + (j - nanoTime);
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.external_sense_library.encoder.MediaEncoder.run():void");
    }
}
