package a.a.a.a.a.a.j;

import a.a.a.a.a.a.j.f;
import a.a.a.a.a.b.i.i;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/b.class */
public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.a.a.a.h.g f1256a;
    public a.a.a.a.a.a.h.d b;

    /* renamed from: c  reason: collision with root package name */
    public StreamingPreviewCallback f1257c;
    public a.a.a.a.a.a.a d;
    public j e;
    public p f;
    public o g;
    public i h;
    public byte[] i;
    public volatile a j;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/b$a.class */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<b> f1258a;

        public a(Looper looper, b bVar) {
            super(looper);
            this.f1258a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            b bVar = this.f1258a.get();
            a.a.a.a.a.e.e.f.a("RGBDataTransfer", "EncoderHandler what:" + i + ",encoder=" + bVar);
            if (bVar == null) {
                a.a.a.a.a.e.e.f.d("RGBDataTransfer", "EncoderHandler.handleMessage: encoder is null");
            } else if (i == 0) {
                bVar.a();
            } else {
                boolean z = true;
                if (i == 1) {
                    bVar.b_(((Boolean) obj).booleanValue());
                } else if (i == 2) {
                    int i2 = message.arg1;
                    long longValue = ((Long) obj).longValue();
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    bVar.b(i2, longValue, z);
                } else if (i == 3) {
                    bVar.a((PLAVFrame) obj);
                } else {
                    throw new RuntimeException("Unhandled msg what=" + i);
                }
            }
        }
    }

    public final void a() {
        a_(this.w);
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.d();
        }
        this.y = 0L;
        a.a.a.a.a.e.e.f.c("RGBDataTransfer", "startEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.RUNNING;
            e();
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(int i) {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // a.a.a.a.a.a.j.f
    public void a(int i, long j, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(f.a aVar) {
        synchronized (this) {
            if (aVar == null) {
                a.a.a.a.a.e.e.f.d("RGBDataTransfer", "config is null when startEncoding");
            } else if (this.t == a.a.a.a.a.f.c.RUNNING) {
                a.a.a.a.a.e.e.f.d("RGBDataTransfer", "startEncoding failed as already being running");
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                a.a.a.a.a.e.e.f.c("RGBDataTransfer", "set pending action as START");
                this.u = a.a.a.a.a.f.a.START;
                this.x = aVar;
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                if (this.u == a.a.a.a.a.f.a.STOP) {
                    a.a.a.a.a.e.e.f.c("RGBDataTransfer", "set pending action as RESTART");
                    this.u = a.a.a.a.a.f.a.RESTART;
                    this.x = aVar;
                }
            } else {
                a.a.a.a.a.e.e.f.c("RGBDataTransfer", "startEncoding +");
                this.w = aVar;
                this.t = a.a.a.a.a.f.c.STARTING;
                HandlerThread handlerThread = new HandlerThread("RGBDataTransfer");
                handlerThread.start();
                this.j = new a(handlerThread.getLooper(), this);
                this.j.sendEmptyMessage(0);
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(StreamingPreviewCallback streamingPreviewCallback) {
        this.f1257c = streamingPreviewCallback;
    }

    public final void a(PLAVFrame pLAVFrame) {
        f.a aVar = this.w;
        if (aVar.g) {
            this.d.a(pLAVFrame, aVar, true);
        } else {
            this.d.a(pLAVFrame, aVar, false);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(ByteBuffer byteBuffer, int i, long j) {
        a.a.a.a.a.a.a aVar;
        synchronized (this) {
            if (this.t != a.a.a.a.a.f.c.RUNNING || this.j == null || (aVar = this.d) == null || byteBuffer == null) {
                return;
            }
            PLAVFrame b = aVar.b(byteBuffer.capacity());
            if (b != null) {
                b.fillFrame(byteBuffer, byteBuffer.capacity(), j);
                this.j.sendMessage(this.j.obtainMessage(3, b));
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public boolean a(boolean z) {
        f.a aVar = this.w;
        if (aVar != null) {
            aVar.a(z);
            return true;
        }
        a.a.a.a.a.e.e.f.e("RGBDataTransfer", "setEncodingMirror failed.");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00db A[Catch: Exception -> 0x0177, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0177, blocks: (B:6:0x002c, B:9:0x0086, B:13:0x009f, B:15:0x00db, B:18:0x0113, B:20:0x0119, B:22:0x012d, B:23:0x0152, B:24:0x0160, B:24:0x0160, B:25:0x0163, B:16:0x0101, B:12:0x0092), top: B:31:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0101 A[Catch: Exception -> 0x0177, TRY_ENTER, TryCatch #0 {Exception -> 0x0177, blocks: (B:6:0x002c, B:9:0x0086, B:13:0x009f, B:15:0x00db, B:18:0x0113, B:20:0x0119, B:22:0x012d, B:23:0x0152, B:24:0x0160, B:24:0x0160, B:25:0x0163, B:16:0x0101, B:12:0x0092), top: B:31:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0119 A[Catch: Exception -> 0x0177, TRY_LEAVE, TryCatch #0 {Exception -> 0x0177, blocks: (B:6:0x002c, B:9:0x0086, B:13:0x009f, B:15:0x00db, B:18:0x0113, B:20:0x0119, B:22:0x012d, B:23:0x0152, B:24:0x0160, B:24:0x0160, B:25:0x0163, B:16:0x0101, B:12:0x0092), top: B:31:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a_(a.a.a.a.a.a.j.f.a r10) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.j.b.a_(a.a.a.a.a.a.j.f$a):void");
    }

    public final void b() {
        a.a.a.a.a.e.e.f.c("RGBDataTransfer", "releaseEncoder");
        this.f1257c = null;
        a.a.a.a.a.a.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
            this.d = null;
        }
        a.a.a.a.a.a.h.g gVar = this.f1256a;
        if (gVar != null) {
            gVar.g();
            this.f1256a = null;
        }
        a.a.a.a.a.a.h.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    public final void b(int i, long j, boolean z) {
        f.a aVar;
        int d;
        if (this.h == null || this.f1256a == null || (aVar = this.w) == null) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("RGBDataTransfer", "ERROR. handleFrameAvailable mTextureI420Reader:" + this.h + ",mInputWindowSurface:" + this.f1256a + ",mEncoderConfig:" + this.w);
            return;
        }
        PLAVFrame b = this.d.b(aVar.d);
        if (b == null) {
            a.a.a.a.a.e.e.f.d("RGBDataTransfer", "frame is null");
            return;
        }
        boolean z2 = this.w.m;
        synchronized (a.a.a.a.a.a.h.f.d) {
            d = z2 ? this.e.d(i) : this.g.a(0, i);
        }
        int i2 = d;
        if (z2) {
            i2 = this.g.a(0, d);
        }
        p pVar = this.f;
        if (pVar != null) {
            pVar.a(i2);
        }
        ByteBuffer[] a2 = this.h.a(i2);
        if (a2 != null) {
            b.fillFrame(a2, j);
        }
        this.h.a();
        byte[] bArr = this.i;
        if (bArr == null || bArr.length < b.mSize) {
            this.i = new byte[b.mSize];
        }
        b.mBuffer.rewind();
        if (this.f1257c != null) {
            b.mBuffer.get(this.i, 0, b.mSize);
            this.f1257c.onPreviewFrame(this.i, this.g.a(), this.g.b(), 0, PLFourCC.FOURCC_I420, b.mPresentationTimeUs);
        }
        f.a aVar2 = this.w;
        if (aVar2.g) {
            this.d.a(b, aVar2, true);
        } else {
            this.d.a(b, aVar2, false);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void b(boolean z) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.IDLE) {
                a.a.a.a.a.e.e.f.d("RGBDataTransfer", "stopEncoding failed as not being running");
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                a.a.a.a.a.e.e.f.c("RGBDataTransfer", "set pending action as STOP");
                this.u = a.a.a.a.a.f.a.STOP;
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                if (this.u == a.a.a.a.a.f.a.START) {
                    a.a.a.a.a.e.e.f.d("RGBDataTransfer", "clear pending start action");
                    this.u = a.a.a.a.a.f.a.NONE;
                }
            } else {
                a.a.a.a.a.e.e.f.c("RGBDataTransfer", "stopEncoding +");
                this.t = a.a.a.a.a.f.c.STOPPING;
                this.j.sendMessage(this.j.obtainMessage(1, Boolean.valueOf(z)));
            }
        }
    }

    public final void b_(boolean z) {
        Looper.myLooper().quit();
        a.a.a.a.a.a.a aVar = this.d;
        if (aVar != null && z) {
            aVar.a();
            this.d.a(true);
        }
        b();
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.a();
        }
        a.a.a.a.a.e.e.f.c("RGBDataTransfer", "stopEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.IDLE;
            e();
        }
    }
}
