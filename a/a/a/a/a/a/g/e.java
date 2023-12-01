package a.a.a.a.a.a.g;

import a.a.a.a.a.a.j.f;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.processing.image.ImageProcessor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/g/e.class */
public class e extends c {
    public a.a.a.a.a.a.i.c k;
    public ArrayDeque<PLAVFrame> l = new ArrayDeque<>();
    public final Object m = new Object();
    public volatile int n = 0;
    public ByteBuffer o;
    public ImageProcessor p;

    public e(MediaFormat mediaFormat, String str, boolean z, f.a aVar) {
        this.g = z;
        this.k = aVar.f1271a;
        try {
            this.f1229c = new MediaCodec.BufferInfo();
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
            this.b = createEncoderByType;
            createEncoderByType.configure(mediaFormat, null, null, 1);
            this.f = !z;
            a(aVar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // a.a.a.a.a.a.g.c, a.a.a.a.a.a.g.b
    public void a() {
        super.a();
        ImageProcessor imageProcessor = this.p;
        if (imageProcessor != null) {
            imageProcessor.a();
        }
    }

    public final void a(f.a aVar) {
        a.a.a.a.a.a.b d = aVar.f1271a.d();
        int a2 = d.a().a();
        int b = d.a().b();
        Point c2 = d.c();
        a.a.a.a.a.e.f b2 = d.b();
        ImageProcessor imageProcessor = new ImageProcessor();
        this.p = imageProcessor;
        imageProcessor.initYUVProcessor(aVar.h, false, aVar.b, aVar.f1272c, c2.x, c2.y, b2.a(), b2.b(), a2, b, aVar.e, aVar.f, aVar.k, aVar.m);
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(WatermarkSetting watermarkSetting) {
        ImageProcessor imageProcessor = this.p;
        if (imageProcessor != null) {
            imageProcessor.updateWatermarkSetting(watermarkSetting);
        }
    }

    public void a(PLAVFrame pLAVFrame) {
        synchronized (this.m) {
            if (pLAVFrame != null) {
                this.l.add(pLAVFrame);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01fe A[Catch: all -> 0x067e, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0013, B:8:0x001a, B:10:0x0020, B:13:0x002a, B:14:0x002f, B:14:0x002f, B:15:0x0032, B:18:0x008f, B:19:0x0094, B:19:0x0094, B:20:0x0097, B:22:0x00f9, B:27:0x0115, B:28:0x0145, B:28:0x0145, B:29:0x0148, B:31:0x01b8, B:34:0x01f1, B:37:0x01fe, B:38:0x020b, B:40:0x020d, B:46:0x022d, B:49:0x023f, B:50:0x024c, B:50:0x024c, B:51:0x024f, B:53:0x0281, B:56:0x028f, B:57:0x029d, B:57:0x029d, B:58:0x02a0, B:54:0x0289, B:61:0x02e2, B:62:0x02e6, B:62:0x02e6, B:63:0x02e9, B:66:0x0319, B:67:0x031d, B:67:0x031d, B:68:0x0320, B:72:0x038c, B:74:0x03a8, B:76:0x03d1, B:78:0x03ed, B:80:0x03fa, B:82:0x0401, B:83:0x0405, B:83:0x0405, B:84:0x0408, B:86:0x044e, B:88:0x0457, B:90:0x0461, B:92:0x046a, B:93:0x0471, B:93:0x0471, B:94:0x0474, B:106:0x04e1, B:108:0x04f0, B:110:0x04f7, B:112:0x0504, B:115:0x0563, B:116:0x0580, B:116:0x0580, B:117:0x0583, B:113:0x0552, B:95:0x048f, B:97:0x04a5, B:99:0x04ae, B:102:0x04b8, B:104:0x04c5, B:119:0x05d4, B:121:0x05df, B:125:0x05ee, B:126:0x0618, B:123:0x05ec, B:25:0x0109, B:33:0x01e3, B:128:0x061a, B:129:0x0622, B:129:0x0622, B:130:0x0625, B:131:0x067c), top: B:140:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x020d A[Catch: all -> 0x067e, LOOP:0: B:40:0x020d->B:150:0x020d, LOOP_START, PHI: r11 
      PHI: (r11v3 java.nio.ByteBuffer[]) = (r11v2 java.nio.ByteBuffer[]), (r11v5 java.nio.ByteBuffer[]) binds: [B:36:0x01fb, B:150:0x020d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0013, B:8:0x001a, B:10:0x0020, B:13:0x002a, B:14:0x002f, B:14:0x002f, B:15:0x0032, B:18:0x008f, B:19:0x0094, B:19:0x0094, B:20:0x0097, B:22:0x00f9, B:27:0x0115, B:28:0x0145, B:28:0x0145, B:29:0x0148, B:31:0x01b8, B:34:0x01f1, B:37:0x01fe, B:38:0x020b, B:40:0x020d, B:46:0x022d, B:49:0x023f, B:50:0x024c, B:50:0x024c, B:51:0x024f, B:53:0x0281, B:56:0x028f, B:57:0x029d, B:57:0x029d, B:58:0x02a0, B:54:0x0289, B:61:0x02e2, B:62:0x02e6, B:62:0x02e6, B:63:0x02e9, B:66:0x0319, B:67:0x031d, B:67:0x031d, B:68:0x0320, B:72:0x038c, B:74:0x03a8, B:76:0x03d1, B:78:0x03ed, B:80:0x03fa, B:82:0x0401, B:83:0x0405, B:83:0x0405, B:84:0x0408, B:86:0x044e, B:88:0x0457, B:90:0x0461, B:92:0x046a, B:93:0x0471, B:93:0x0471, B:94:0x0474, B:106:0x04e1, B:108:0x04f0, B:110:0x04f7, B:112:0x0504, B:115:0x0563, B:116:0x0580, B:116:0x0580, B:117:0x0583, B:113:0x0552, B:95:0x048f, B:97:0x04a5, B:99:0x04ae, B:102:0x04b8, B:104:0x04c5, B:119:0x05d4, B:121:0x05df, B:125:0x05ee, B:126:0x0618, B:123:0x05ec, B:25:0x0109, B:33:0x01e3, B:128:0x061a, B:129:0x0622, B:129:0x0622, B:130:0x0625, B:131:0x067c), top: B:140:0x0009 }] */
    @Override // a.a.a.a.a.a.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.qiniu.pili.droid.streaming.av.common.PLAVFrame r10, a.a.a.a.a.a.j.f.a r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 1679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.g.e.a(com.qiniu.pili.droid.streaming.av.common.PLAVFrame, a.a.a.a.a.a.j.f$a, boolean):void");
    }

    @Override // a.a.a.a.a.a.g.b
    public PLAVFrame b(int i) {
        PLAVFrame pLAVFrame;
        synchronized (this.m) {
            if (i <= 0) {
                a.a.a.a.a.e.e.i.e("PLYuvHWEncoder", "Init improperly:" + i);
                return null;
            }
            if (!this.l.isEmpty()) {
                PLAVFrame remove = this.l.remove();
                if (remove != null && remove.mBuffer != null && remove.mBuffer.capacity() >= i) {
                    return remove;
                }
                a.a.a.a.a.e.e.i.d("PLYuvHWEncoder", "The frame is:" + remove);
            }
            if (this.n < 2) {
                try {
                    pLAVFrame = new PLAVFrame(ByteBuffer.allocateDirect(i), 0, 0L);
                    try {
                        this.n++;
                        a.a.a.a.a.e.e.i.c("PLYuvHWEncoder", "Allocate extra buffer mInputExtraNum:" + this.n + ",frame.buffer:" + pLAVFrame.mBuffer);
                    } catch (OutOfMemoryError e) {
                        a.a.a.a.a.e.e.i.e("PLYuvHWEncoder", "Fatal Error. OOM !!!");
                        return pLAVFrame;
                    }
                } catch (OutOfMemoryError e2) {
                    pLAVFrame = null;
                }
                return pLAVFrame;
            }
            return null;
        }
    }
}
