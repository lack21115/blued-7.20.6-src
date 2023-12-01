package com.qiniu.pili.droid.shortvideo.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/muxer/a.class */
public class a extends c {
    private MediaMuxer f;

    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    public void a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            if (this.f == null || i < 0) {
                e.n.d("DroidMP4Muxer", "write failed, mMediaMuxer == null or trackIndex < 0 !");
                return;
            }
            if (this.b == i) {
                if (bufferInfo.presentationTimeUs <= this.d) {
                    e eVar = e.n;
                    eVar.d("DroidMP4Muxer", "ignored, video timestamp fall back, this: " + bufferInfo.presentationTimeUs + " last: " + this.d);
                    return;
                }
                this.d = bufferInfo.presentationTimeUs;
            }
            if (this.f27734c == i) {
                if (bufferInfo.presentationTimeUs <= this.e) {
                    e eVar2 = e.n;
                    eVar2.d("DroidMP4Muxer", "ignored, audio timestamp fall back, this: " + bufferInfo.presentationTimeUs + " last: " + this.e);
                    return;
                }
                this.e = bufferInfo.presentationTimeUs;
            }
            try {
                this.f.writeSampleData(i, byteBuffer, bufferInfo);
            } catch (Exception e) {
                e eVar3 = e.n;
                eVar3.e("DroidMP4Muxer", "mux write data failed: " + e.getMessage());
            }
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    public boolean a() {
        synchronized (this) {
            e.n.c("DroidMP4Muxer", "stop +");
            if (this.f == null) {
                return false;
            }
            try {
                this.f.stop();
                this.f.release();
                this.f = null;
                e.n.c("DroidMP4Muxer", "stop -");
                return true;
            } catch (IllegalStateException e) {
                e.n.e("DroidMP4Muxer", e.getMessage());
                new File(this.f27733a).delete();
                this.f = null;
                e.n.c("DroidMP4Muxer", "stop -");
                return false;
            }
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.muxer.c
    public boolean a(String str, MediaFormat mediaFormat, MediaFormat mediaFormat2, int i) {
        synchronized (this) {
            e.n.c("DroidMP4Muxer", "start +");
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.delete();
                e eVar = e.n;
                eVar.c("DroidMP4Muxer", "delete existed file: " + str);
            }
            try {
                this.f27733a = str;
                MediaMuxer mediaMuxer = new MediaMuxer(this.f27733a, 0);
                this.f = mediaMuxer;
                if (mediaFormat != null) {
                    this.b = mediaMuxer.addTrack(mediaFormat);
                    e eVar2 = e.n;
                    eVar2.c("DroidMP4Muxer", "addTrack video track: " + this.b);
                }
                if (mediaFormat2 != null) {
                    this.f27734c = this.f.addTrack(mediaFormat2);
                    e eVar3 = e.n;
                    eVar3.c("DroidMP4Muxer", "addTrack audio track: " + this.f27734c);
                }
                this.f.setOrientationHint(i);
                this.f.start();
                e.n.c("DroidMP4Muxer", "start -");
            } catch (Exception e) {
                e.n.e("DroidMP4Muxer", e.getMessage());
                e.n.c("DroidMP4Muxer", "start -");
                return false;
            }
        }
        return true;
    }
}
