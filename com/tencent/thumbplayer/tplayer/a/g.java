package com.tencent.thumbplayer.tplayer.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thumbplayer.api.reportv2.ITPExtendReportController;
import com.tencent.thumbplayer.api.reportv2.ITPReportChannelListener;
import com.tencent.thumbplayer.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/g.class */
public class g implements ITPExtendReportController, com.tencent.thumbplayer.d.a {
    private static final Map<Integer, Integer> k;
    private Context g;

    /* renamed from: a  reason: collision with root package name */
    private ITPReportInfoGetter f25699a = null;
    private HandlerThread b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f25700c = null;
    private com.tencent.thumbplayer.tplayer.a.a d = null;
    private l e = new l();
    private com.tencent.thumbplayer.tplayer.a.a.a h = null;
    private h i = new h();
    private Object j = new Object();
    private CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> f = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/a/g$a.class */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            b.a aVar = (b.a) message.obj;
            g.this.a(i, aVar);
            if (g.this.d != null) {
                g.this.d.a(i, aVar);
            }
            g.this.b(i, aVar);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put(117, 0);
        k.put(204, 103);
        k.put(101, 1);
        k.put(102, 2);
        k.put(103, 3);
        k.put(104, 4);
        k.put(105, 5);
        k.put(107, 5);
        k.put(108, 5);
        k.put(106, 6);
        k.put(109, 7);
        k.put(110, 8);
        k.put(111, 9);
        k.put(112, 10);
        k.put(114, 11);
        k.put(115, 12);
        k.put(201, 100);
        k.put(202, 101);
        k.put(203, 102);
        k.put(116, 14);
        k.put(113, 13);
        k.put(118, 15);
    }

    public g(Context context) {
        this.g = null;
        this.g = context.getApplicationContext();
    }

    private void a(int i) {
        String str;
        if (this.d != null) {
            str = "mITPReporter has been create, do not create again.";
        } else {
            com.tencent.thumbplayer.tplayer.a.a a2 = k.a(i);
            this.d = a2;
            if (a2 != null) {
                a2.a(this.g, this.e);
                this.d.a(this.f25699a);
                this.d.a(this.h);
                Iterator<WeakReference<ITPReportChannelListener>> it = this.f.iterator();
                while (it.hasNext()) {
                    ITPReportChannelListener iTPReportChannelListener = it.next().get();
                    if (iTPReportChannelListener != null) {
                        this.d.a(iTPReportChannelListener);
                    }
                }
                return;
            }
            str = "initReporter(" + i + ") fail, mITPReporter is null.";
        }
        TPLogUtil.w("TPReportController", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, b.a aVar) {
        if (i == 0) {
            c(aVar);
        } else if (i == 1) {
            d(aVar);
        } else if (i == 2) {
            e(aVar);
        } else if (i == 6) {
            f(aVar);
        } else if (i != 103) {
        } else {
            b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, b.a aVar) {
        if (i == 5) {
            g(aVar);
        } else if (i != 1000) {
        } else {
            h(aVar);
        }
    }

    private void b(b.a aVar) {
        if (aVar instanceof b.g) {
            this.e.b = ((b.g) aVar).b();
            TPLogUtil.i("TPReportController", "onGetConvertedDataSource time:" + this.e.b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void c(b.a aVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void d(b.a aVar) {
        this.i.a(2);
        if (aVar instanceof b.p) {
            b.p pVar = (b.p) aVar;
            this.e.f25706c = pVar.b();
            this.e.d = pVar.c();
            this.e.i = pVar.d();
        }
    }

    private void e(b.a aVar) {
        if (!this.i.b(2)) {
            TPLogUtil.e("TPReportController", "onPrepareEnd Current state is not match:" + this.i.toString());
            return;
        }
        this.i.a(3);
        if (aVar instanceof b.o) {
            b.o oVar = (b.o) aVar;
            this.e.g = j.b(oVar.e());
            TPLogUtil.i("TPReportController", "onPrepareEnd durationMs:" + oVar.d() + " playType:" + this.e.g);
            if (oVar.d() == 0) {
                a(1);
            } else {
                a(0);
            }
        }
    }

    private void f(b.a aVar) {
        if (this.i.b(2)) {
            a(2);
        }
        this.i.a(1);
    }

    private void g(b.a aVar) {
        this.i.a(1);
        com.tencent.thumbplayer.tplayer.a.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.a();
            this.d = null;
        }
        this.e = new l();
    }

    private void h(b.a aVar) {
        TPLogUtil.i("TPReportController", "onControllerRelease");
        synchronized (this.j) {
            if (this.b != null) {
                o.a().a(this.b, this.f25700c);
                this.b = null;
                this.f25700c = null;
            }
            this.f.clear();
            this.j.notifyAll();
            this.j = null;
        }
    }

    public void a() {
        this.b = o.a().a("TPReportController_Thread");
        this.f25700c = new a(this.b.getLooper());
    }

    @Override // com.tencent.thumbplayer.d.a
    public void a(b.a aVar) {
        if (k.containsKey(Integer.valueOf(aVar.a()))) {
            this.f25700c.obtainMessage(k.get(Integer.valueOf(aVar.a())).intValue(), aVar).sendToTarget();
            return;
        }
        TPLogUtil.w("TPReportController", "EventId:" + aVar.a() + " is not need process");
    }

    public void a(com.tencent.thumbplayer.tplayer.a.a.a aVar) {
        this.h = aVar;
    }

    @Override // com.tencent.thumbplayer.api.reportv2.ITPExtendReportController
    public void addReportChannelListener(ITPReportChannelListener iTPReportChannelListener) {
        CopyOnWriteArrayList<WeakReference<ITPReportChannelListener>> copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList == null) {
            TPLogUtil.w("TPReportController", "mReportChannelListenerList is null");
            return;
        }
        Iterator<WeakReference<ITPReportChannelListener>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == iTPReportChannelListener) {
                TPLogUtil.w("TPReportController", "mReportChannelListenerList has contain reportChannelListener");
                return;
            }
        }
        this.f.add(new WeakReference<>(iTPReportChannelListener));
    }

    public void b() {
        TPLogUtil.i("TPReportController", "release");
        synchronized (this.j) {
            if (this.f25700c != null) {
                this.f25700c.sendEmptyMessage(1000);
            }
            try {
                this.j.wait(500L);
            } catch (InterruptedException e) {
                TPLogUtil.e("TPReportController", e);
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.reportv2.ITPExtendReportController
    public void setReportInfoGetter(ITPReportInfoGetter iTPReportInfoGetter) {
        this.f25699a = iTPReportInfoGetter;
    }
}
