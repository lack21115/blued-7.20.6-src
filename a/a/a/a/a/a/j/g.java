package a.a.a.a.a.a.j;

import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.h;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/g.class */
public class g extends f {

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.a.a.a.a f1273a;
    public volatile a b;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/g$a.class */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<g> f1274a;

        public a(Looper looper, g gVar) {
            super(looper);
            this.f1274a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            g gVar = this.f1274a.get();
            if (gVar == null) {
                a.a.a.a.a.e.e.f.d("YUVDataTransfer", "EncoderHandler.handleMessage: encoder is null");
            } else if (i == 0) {
                gVar.d(((Boolean) obj).booleanValue());
            } else if (i == 1) {
                gVar.a();
            } else if (i != 2) {
            } else {
                gVar.a((PLAVFrame) obj);
            }
        }
    }

    public final void a() {
        f.a aVar = this.w;
        if (aVar.g) {
            this.f1273a = new a.a.a.a.a.a.j.i.a(aVar);
        } else {
            this.f1273a = new e(aVar);
        }
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.d();
        }
        this.y = 0L;
        a.a.a.a.a.e.e.f.c("YUVDataTransfer", "startEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.RUNNING;
            e();
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(int i) {
        synchronized (this) {
            a.a.a.a.a.a.a aVar = this.f1273a;
            if (aVar != null) {
                aVar.a(i);
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(f.a aVar) {
        synchronized (this) {
            if (aVar == null) {
                a.a.a.a.a.e.e.f.d("YUVDataTransfer", "config is null when startEncoding");
            } else if (this.t == a.a.a.a.a.f.c.RUNNING) {
                a.a.a.a.a.e.e.f.d("YUVDataTransfer", "startEncoding failed as already being running");
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                a.a.a.a.a.e.e.f.c("YUVDataTransfer", "set pending action as START");
                this.u = a.a.a.a.a.f.a.START;
                this.x = aVar;
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                if (this.u == a.a.a.a.a.f.a.STOP) {
                    a.a.a.a.a.e.e.f.c("YUVDataTransfer", "set pending action as RESTART");
                    this.u = a.a.a.a.a.f.a.RESTART;
                    this.x = aVar;
                }
            } else {
                a.a.a.a.a.e.e.f.c("YUVDataTransfer", "startEncoding +");
                this.w = aVar;
                this.t = a.a.a.a.a.f.c.STARTING;
                HandlerThread handlerThread = new HandlerThread("YUVDataTransfer");
                handlerThread.start();
                this.b = new a(handlerThread.getLooper(), this);
                this.b.sendEmptyMessage(1);
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(WatermarkSetting watermarkSetting) {
        f.a aVar = this.w;
        if (aVar != null) {
            aVar.a(watermarkSetting);
        }
        a.a.a.a.a.a.a aVar2 = this.f1273a;
        if (aVar2 != null) {
            aVar2.a(watermarkSetting);
        }
    }

    public final void a(PLAVFrame pLAVFrame) {
        a.a.a.a.a.a.a aVar = this.f1273a;
        if (aVar != null) {
            aVar.a(pLAVFrame, this.w, false);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(ByteBuffer byteBuffer, int i, long j) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.RUNNING && this.f1273a != null && this.b != null && !a.a.a.a.a.a.j.a.a().b()) {
                this.y++;
                if (h.d() && this.y % 2 == 0) {
                    a.a.a.a.a.e.e.f.c("YUVDataTransfer", "Drop the in frame");
                    this.w.f1271a.e().l++;
                    this.w.f1271a.e().w++;
                    return;
                }
                PLAVFrame b = this.f1273a.b(byteBuffer.capacity());
                if (b != null) {
                    b.fillFrame(byteBuffer, byteBuffer.capacity(), j);
                    this.b.sendMessage(this.b.obtainMessage(2, b));
                } else {
                    a.a.a.a.a.e.e.f.b("YUVDataTransfer", "inputFrame is null. so drop the frame...");
                    this.w.f1271a.e().l++;
                    this.w.f1271a.e().w++;
                }
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(byte[] bArr, long j) {
        synchronized (this) {
            a.a.a.a.a.e.e.f.a("YUVDataTransfer", "onPreviewFrame + bytes.len:" + bArr.length + ",ts:" + j);
            if (this.t == a.a.a.a.a.f.c.RUNNING && this.f1273a != null && this.b != null && !a.a.a.a.a.a.j.a.a().b()) {
                this.y++;
                if (h.d() && this.y % 2 == 0) {
                    a.a.a.a.a.e.e.f.c("YUVDataTransfer", "Drop the in frame");
                    this.w.f1271a.e().l++;
                    this.w.f1271a.e().w++;
                    return;
                }
                PLAVFrame b = this.f1273a.b(bArr.length);
                if (b != null) {
                    b.fillFrame(bArr, j);
                    this.b.sendMessage(this.b.obtainMessage(2, b));
                } else {
                    a.a.a.a.a.e.e.f.a("YUVDataTransfer", "inputFrame is null. so drop the frame...");
                    this.w.f1271a.e().l++;
                    this.w.f1271a.e().w++;
                }
                a.a.a.a.a.e.e.f.a("YUVDataTransfer", "onPreviewFrame -");
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
        a.a.a.a.a.e.e.f.c("YUVDataTransfer", "setEncodingMirror failed");
        return false;
    }

    public final void b() {
        a.a.a.a.a.a.a aVar = this.f1273a;
        if (aVar != null) {
            aVar.b();
            this.f1273a = null;
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void b(boolean z) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.IDLE) {
                a.a.a.a.a.e.e.f.d("YUVDataTransfer", "stopEncoding failed as not being running");
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                a.a.a.a.a.e.e.f.c("YUVDataTransfer", "set pending action as STOP");
                this.u = a.a.a.a.a.f.a.STOP;
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                if (this.u == a.a.a.a.a.f.a.START) {
                    a.a.a.a.a.e.e.f.d("YUVDataTransfer", "clear pending start action");
                    this.u = a.a.a.a.a.f.a.NONE;
                }
            } else {
                a.a.a.a.a.e.e.f.c("YUVDataTransfer", "stopEncoding +");
                this.t = a.a.a.a.a.f.c.STOPPING;
                this.b.sendMessage(this.b.obtainMessage(0, Boolean.valueOf(z)));
            }
        }
    }

    public final void d(boolean z) {
        Looper.myLooper().quit();
        a.a.a.a.a.a.a aVar = this.f1273a;
        if (aVar != null && z) {
            aVar.a();
            this.f1273a.a(true);
        }
        b();
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.a();
        }
        a.a.a.a.a.e.e.f.c("YUVDataTransfer", "stopEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.IDLE;
            e();
        }
    }
}
