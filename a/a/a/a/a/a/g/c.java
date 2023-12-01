package a.a.a.a.a.a.g;

import a.a.a.a.a.e.h;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/g/c.class */
public class c extends b {
    public MediaCodec b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f1181c;
    public ByteBuffer d;
    public int e;
    public volatile boolean f;
    public boolean g;
    public volatile boolean h;
    public int i;
    public ArrayDeque<PLAVFrame> j;

    public c() {
        this.e = 0;
        this.g = false;
        this.h = false;
        this.j = new ArrayDeque<>();
    }

    public c(MediaFormat mediaFormat, String str, boolean z) {
        this.e = 0;
        this.g = false;
        this.h = false;
        this.j = new ArrayDeque<>();
        this.g = z;
        try {
            this.f1181c = new MediaCodec.BufferInfo();
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
            this.b = createEncoderByType;
            createEncoderByType.configure(mediaFormat, null, null, 1);
            this.f = !z;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a() {
        if (this.b == null) {
            a.a.a.a.a.e.e.i.d("PLHWEncoder", "mEncoder had been released!");
            return;
        }
        try {
            this.f = false;
            this.b.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.j.clear();
        this.b.release();
        this.b = null;
        a.a.a.a.a.e.e.i.c("PLHWEncoder", "Released encoder");
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(int i) {
        if (h.a() && this.b != null && this.f) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodec.PARAMETER_KEY_VIDEO_BITRATE, i);
            this.b.setParameters(bundle);
        } else if (h.a()) {
        } else {
            a.a.a.a.a.e.e.i.d("PLHWEncoder", "Ignoring adjustVideoBitrate call. This functionality is only available on Android API 19+");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x04d2, code lost:
        if (r9 == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x04d9, code lost:
        if (r7.g == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x04dc, code lost:
        a.a.a.a.a.e.e.i.a("PLHWEncoder", "final video drain complete");
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x04ea, code lost:
        a.a.a.a.a.e.e.i.a("PLHWEncoder", "final audio drain complete");
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x04f7, code lost:
        return;
     */
    @Override // a.a.a.a.a.a.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(a.a.a.a.a.a.i.c r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.g.c.a(a.a.a.a.a.a.i.c, boolean):void");
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(PLAVFrame pLAVFrame, int i) {
        if (this.b != null) {
            this.j.add(pLAVFrame);
            this.b.releaseOutputBuffer(i, false);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void b() {
        this.h = true;
    }

    @Override // a.a.a.a.a.a.g.b
    public Object c() {
        return this.b;
    }

    @Override // a.a.a.a.a.a.g.b
    public void d() {
        MediaCodec mediaCodec = this.b;
        if (mediaCodec != null) {
            try {
                mediaCodec.start();
                this.f = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public Surface e() {
        MediaCodec mediaCodec = this.b;
        if (mediaCodec != null) {
            try {
                return mediaCodec.createInputSurface();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void f() {
        PLBufferInfo pLBufferInfo = this.f1180a;
        MediaCodec.BufferInfo bufferInfo = this.f1181c;
        pLBufferInfo.flags = bufferInfo.flags;
        pLBufferInfo.offset = bufferInfo.offset;
        pLBufferInfo.size = bufferInfo.size;
        pLBufferInfo.presentationTimeUs = bufferInfo.presentationTimeUs;
    }
}
