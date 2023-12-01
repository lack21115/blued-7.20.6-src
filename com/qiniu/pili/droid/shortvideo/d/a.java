package com.qiniu.pili.droid.shortvideo.d;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.qiniu.pili.droid.shortvideo.f.e;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/d/a.class */
public final class a extends b {
    private Handler f;
    private MediaCodec.Callback g;

    public a(MediaExtractor mediaExtractor, MediaFormat mediaFormat) {
        super(mediaExtractor, mediaFormat);
        this.g = new MediaCodec.Callback() { // from class: com.qiniu.pili.droid.shortvideo.d.a.1
            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                e eVar = e.u;
                String j = a.this.j();
                eVar.c(j, "decoder callback onError " + codecException.getMessage());
                if (a.this.f13948c != null) {
                    a.this.f13948c.a(17);
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
                try {
                    int readSampleData = a.this.f13947a.readSampleData(a.this.b.getInputBuffer(i), 0);
                    if (readSampleData > 0) {
                        a.this.b.queueInputBuffer(i, 0, readSampleData, a.this.f13947a.getSampleTime(), 0);
                        a.this.f13947a.advance();
                        return;
                    }
                    e eVar = e.u;
                    String j = a.this.j();
                    eVar.c(j, "read size <= 0 need loop: " + a.this.e);
                    if (!a.this.e) {
                        a.this.b.queueInputBuffer(i, 0, 0, 0L, 4);
                        return;
                    }
                    a.this.b();
                    a.this.b.flush();
                    a.this.b.start();
                } catch (IllegalStateException e) {
                    e.u.e(a.this.j(), e.toString());
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
                if ((bufferInfo.flags & 2) != 0) {
                    e.i.c(a.this.j(), "codec config frame ignore.");
                    return;
                }
                try {
                    a.this.a(i, bufferInfo, mediaCodec.getOutputBuffer(i));
                } catch (IllegalStateException e) {
                    e.u.e(a.this.j(), e.toString());
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat2) {
                e eVar = e.u;
                String j = a.this.j();
                eVar.c(j, "decoder output format changed: " + mediaFormat2);
                if (a.this.d != null) {
                    a.this.d.a(mediaFormat2);
                }
            }
        };
    }

    @Override // com.qiniu.pili.droid.shortvideo.f.k
    public boolean c() {
        Handler handler = this.f;
        if (handler != null) {
            handler.getLooper().quit();
        }
        return super.c();
    }

    @Override // com.qiniu.pili.droid.shortvideo.d.b, com.qiniu.pili.droid.shortvideo.f.k
    public String j() {
        return "AsyncRawFrameExtractor";
    }

    @Override // com.qiniu.pili.droid.shortvideo.d.b, java.lang.Runnable
    public void run() {
        b();
        Looper.prepare();
        Handler handler = new Handler(Looper.myLooper());
        this.f = handler;
        if (a(this.g, handler)) {
            Looper.loop();
        }
        e();
    }
}
