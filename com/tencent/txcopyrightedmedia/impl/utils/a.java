package com.tencent.txcopyrightedmedia.impl.utils;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.impl.utils.at;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import com.tencent.txcopyrightedmedia.impl.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f26335a = true;

    /* renamed from: com.tencent.txcopyrightedmedia.impl.utils.a$3  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a$3.class */
    static final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ at f26340a;
        final /* synthetic */ AtomicInteger b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InterfaceC0894a f26341c;
        final /* synthetic */ CountDownLatch d;

        AnonymousClass3(at atVar, AtomicInteger atomicInteger, InterfaceC0894a interfaceC0894a, CountDownLatch countDownLatch) {
            this.f26340a = atVar;
            this.b = atomicInteger;
            this.f26341c = interfaceC0894a;
            this.d = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i d = this.f26340a.d();
            synchronized (this.b) {
                if (this.b.compareAndSet(0, d.code) && d.code != 0 && this.f26341c != null) {
                    this.f26341c.a(d);
                }
                if (this.f26340a.b != 3) {
                    this.d.countDown();
                }
            }
        }
    }

    /* renamed from: com.tencent.txcopyrightedmedia.impl.utils.a$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a$4.class */
    static final class AnonymousClass4 implements com.tencent.txcopyrightedmedia.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f26342a;
        final /* synthetic */ float[] b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26343c;
        final /* synthetic */ at d;
        final /* synthetic */ float[] e;
        final /* synthetic */ int[] f;
        final /* synthetic */ InterfaceC0894a g;

        AnonymousClass4(AtomicInteger atomicInteger, float[] fArr, int i, at atVar, float[] fArr2, int[] iArr, InterfaceC0894a interfaceC0894a) {
            this.f26342a = atomicInteger;
            this.b = fArr;
            this.f26343c = i;
            this.d = atVar;
            this.e = fArr2;
            this.f = iArr;
            this.g = interfaceC0894a;
        }

        @Override // com.tencent.txcopyrightedmedia.a
        public final void a(String str, String str2, float f) {
            synchronized (this.f26342a) {
                this.b[this.f26343c] = f;
                if (this.f26342a.get() != 0) {
                    TXCopyrightedMedia.instance().cancelPreloadMusic(this.d.i(), this.d.j());
                    return;
                }
                this.e[0] = 0.0f;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f[0]) {
                        break;
                    }
                    float[] fArr = this.e;
                    fArr[0] = fArr[0] + this.b[i2];
                    i = i2 + 1;
                }
                this.e[0] = this.e[0] / this.f[0];
                if (this.g != null) {
                    this.g.a(this.e[0]);
                }
            }
        }
    }

    /* renamed from: com.tencent.txcopyrightedmedia.impl.utils.a$5  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a$5.class */
    static final class AnonymousClass5 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f26344a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ at f26345c;
        final /* synthetic */ b d;
        final /* synthetic */ CountDownLatch e;

        AnonymousClass5(int i, int i2, at atVar, b bVar, CountDownLatch countDownLatch) {
            this.f26344a = i;
            this.b = i2;
            this.f26345c = atVar;
            this.d = bVar;
            this.e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar;
            int i = this.f26344a;
            while (true) {
                int i2 = i;
                if (i2 < this.b) {
                    ar a2 = this.f26345c.a(i2);
                    if (a2 == null) {
                        iVar = new i(-5, "Async error.");
                    } else if (a2.f().b) {
                        iVar = new i(-2, "Cancel by user.");
                    } else if (TextUtils.isEmpty(a2.f26376a)) {
                        iVar = new i(-6, "Get url fail.");
                    } else {
                        StringBuilder sb = new StringBuilder("fill content: abort: ");
                        sb.append(a2.f().b);
                        sb.append(", thread id: ");
                        sb.append(Thread.currentThread().getId());
                        sb.append(". url: ");
                        sb.append(a2.f26376a);
                        if (a2.g() != null) {
                            a2.m = a2.g().a(a2.f26376a, a2.j());
                        }
                        if (a2.o().a()) {
                            w wVar = w.c.f26493a;
                            w.d a3 = w.a(a2.m());
                            if (a2.f().b) {
                                iVar = new i(-2, "Cancel by user.");
                            } else if (a3.f26494a < 200 || a3.f26494a >= 300) {
                                iVar = new i(-4, "Fetch " + a2.f26376a + " fail. Status: " + a3.f26494a);
                                i.a aVar = iVar.f26410a;
                                aVar.b = String.valueOf(a3.f26494a);
                                aVar.a(a3.e);
                            } else {
                                a2.o().a(a3.b, a3.d);
                                if (a2.h().a() > 0) {
                                    a2.g().a(a2);
                                }
                            }
                        }
                        if (a2.f().d && a2.b != null) {
                            az azVar = a2.b;
                            if (!(azVar.f26391a == null || azVar.b == null || azVar.f26392c == null)) {
                                a2.o().f26397a = ac.a(a2.o().f26397a, a2.b.f26391a, a2.b.b, "PKCS5Padding");
                                if (a2.o().f26397a == null) {
                                    iVar = new i(-7, "Decrypt fail.");
                                }
                            }
                        }
                        iVar = new i(0, null);
                    }
                    b bVar = this.d;
                    if (bVar != null) {
                        bVar.a(iVar);
                    }
                    if (iVar.code != 0) {
                        break;
                    }
                    i = i2 + 1;
                } else {
                    break;
                }
            }
            this.e.countDown();
            new StringBuilder("Thread end. Thread id: ").append(Thread.currentThread().getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.txcopyrightedmedia.impl.utils.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a$a.class */
    public interface InterfaceC0894a {
        void a(float f);

        void a(i iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/a$b.class */
    public interface b {
        void a(i iVar);
    }

    public static i a(as asVar) {
        if (TXCopyrightedMedia.instance().getAppID() == -1) {
            return new i(-1, "Licence init fail.");
        }
        asVar.f26377a = "https://play.yinsuda.qcloud.com/v1/playapi?musicid=" + asVar.i();
        return new i(0, null);
    }

    public static i a(com.tencent.txcopyrightedmedia.impl.utils.b bVar, final as asVar, int i, ArrayList<at.a> arrayList, final com.tencent.txcopyrightedmedia.a aVar) {
        Pair<String, String>[] a2;
        ax axVar;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        ax axVar2 = asVar.f().f26396c;
        if (asVar.f26377a == null) {
            asVar.f26377a = axVar2.f26388c;
        } else if (TextUtils.isEmpty(axVar2.f26388c)) {
            axVar2.f26388c = asVar.f26377a;
            axVar2.e = 0;
            int a3 = bVar.b.a();
            int a4 = bVar.d.a();
            int i2 = a4 <= 0 ? 0 : a4 - 1;
            if (a3 >= i2 && (a2 = bVar.b.a(i2, a3 - i2)) != null) {
                int length = a2.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        break;
                    }
                    Pair<String, String> pair = a2[i4];
                    bVar.b.b(pair.first, pair.second);
                    bVar.f26393a.b(pair.first, pair.second);
                    d.a(pair.first);
                    i3 = i4 + 1;
                }
            }
            if (a4 > 0) {
                SQLiteDatabase writableDatabase = bVar.b.f26405a.getWritableDatabase();
                Object[] objArr = new Object[9];
                if (axVar2.f26387a != null) {
                    objArr[0] = axVar2.f26387a;
                } else {
                    objArr[0] = "";
                }
                if (axVar2.b != null) {
                    objArr[1] = axVar2.b;
                } else {
                    objArr[1] = "";
                }
                if (axVar2.f26388c != null) {
                    objArr[2] = axVar2.f26388c;
                } else {
                    objArr[2] = "";
                }
                if (axVar2.d != null) {
                    objArr[3] = axVar2.d;
                } else {
                    objArr[3] = "";
                }
                objArr[4] = Integer.valueOf(axVar2.e);
                if (axVar2.f != null) {
                    objArr[5] = axVar2.f;
                } else {
                    objArr[5] = "";
                }
                if (axVar2.g != null) {
                    objArr[6] = axVar2.g;
                } else {
                    objArr[6] = "";
                }
                objArr[7] = Long.valueOf(System.currentTimeMillis());
                objArr[8] = Integer.valueOf(axVar2.j);
                writableDatabase.execSQL("REPLACE INTO m4a_file_id_cache ( music_id, file_id,url,music_ext_id,cache_progress,overlay_key,overlay_iv,date,source_type) VALUES (?,?,?,?,?,?,?,?,?);", objArr);
            }
        } else if (!TextUtils.equals(asVar.f26377a, axVar2.f26388c)) {
            axVar2.f26388c = asVar.f26377a;
            axVar2.e = 0;
            bVar.b.a(axVar2);
        }
        if (axVar2.h) {
            bVar.b.a(axVar2);
        }
        i e = asVar.e();
        if (e.code == 0) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            final i iVar5 = new i(0, null);
            a(asVar, arrayList2, new InterfaceC0894a() { // from class: com.tencent.txcopyrightedmedia.impl.utils.a.1
                @Override // com.tencent.txcopyrightedmedia.impl.utils.a.InterfaceC0894a
                public final void a(float f) {
                    com.tencent.txcopyrightedmedia.a aVar2 = com.tencent.txcopyrightedmedia.a.this;
                    if (aVar2 != null) {
                        aVar2.a(asVar.i(), asVar.j(), f);
                    }
                }

                @Override // com.tencent.txcopyrightedmedia.impl.utils.a.InterfaceC0894a
                public final void a(i iVar6) {
                    iVar5.code = iVar6.code;
                    iVar5.msg = iVar6.msg;
                    iVar5.f26410a = iVar6.f26410a;
                }
            });
            if (iVar5.code == 0) {
                CountDownLatch countDownLatch = new CountDownLatch(i * 0);
                final AtomicInteger atomicInteger2 = new AtomicInteger(0);
                i iVar6 = new i(0, null);
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        iVar2 = iVar5;
                        break;
                    }
                    at.a aVar2 = (at.a) it.next();
                    at a5 = asVar.a(aVar2.f26380a, aVar2.b, aVar2.f26381c);
                    if (a5.e != null) {
                        aq aqVar = a5.e;
                        if (aqVar.f().b) {
                            iVar5 = new i(-2, "Cancel by user.");
                        } else if (TextUtils.isEmpty(aqVar.f26375a)) {
                            iVar5 = new i(-6, "Get url fail.");
                        } else {
                            new StringBuilder("fill content: url: ").append(aqVar.f26375a);
                            if (aqVar.g() != null) {
                                aqVar.m = aqVar.g().a(aqVar.f26375a, aqVar.j());
                            }
                            if (aqVar.o().a()) {
                                w wVar = w.c.f26493a;
                                w.d a6 = w.a(aqVar.m());
                                if (aqVar.f().b) {
                                    iVar5 = new i(-2, "Cancel by user.");
                                } else if (a6.f26494a < 200 || a6.f26494a >= 300) {
                                    iVar5 = new i(-4, "Fetch " + aqVar.f26375a + " fail. Status: " + a6.f26494a);
                                    i.a aVar3 = iVar5.f26410a;
                                    aVar3.b = String.valueOf(a6.f26494a);
                                    aVar3.a(a6.e);
                                } else {
                                    aqVar.o().a(a6.b, a6.d);
                                    if (aqVar.h().a() > 0) {
                                        aqVar.g().a(aqVar);
                                    }
                                }
                            }
                            iVar5 = new i(0, null);
                        }
                        if (iVar5.code != 0) {
                            iVar2 = iVar5;
                            break;
                        }
                    }
                    final i iVar7 = iVar6;
                    if (a5.g != null) {
                        au auVar = a5.g;
                        if (auVar.f().b) {
                            iVar4 = new i(-2, "Cancel by user.");
                        } else if (TextUtils.isEmpty(auVar.f26382a)) {
                            iVar4 = new i(-6, "Get url fail.");
                        } else {
                            new StringBuilder("fill content: url: ").append(auVar.f26382a);
                            if (auVar.g() != null) {
                                auVar.o().f26397a = d.a(d.b(auVar));
                                auVar.o().b = auVar.a() == null ? 0L : auVar.a().length;
                            }
                            if (auVar.o().a()) {
                                if (auVar.f26382a.startsWith("http")) {
                                    w wVar2 = w.c.f26493a;
                                    w.d a7 = w.a(auVar.m());
                                    if (auVar.f().b) {
                                        iVar4 = new i(-2, "Cancel by user.");
                                    } else if (a7.f26494a < 200 || a7.f26494a >= 300) {
                                        iVar4 = new i(-4, "Fetch " + auVar.f26382a + " fail. Status: " + a7.f26494a);
                                        i.a aVar4 = iVar4.f26410a;
                                        aVar4.b = String.valueOf(a7.f26494a);
                                        aVar4.a(a7.e);
                                    } else {
                                        auVar.o().a(a7.b, a7.d);
                                    }
                                } else {
                                    auVar.o().a(auVar.f26382a.getBytes(), auVar.f26382a.length());
                                }
                                d.a(auVar);
                            }
                            iVar4 = new i(0, null);
                        }
                        iVar2 = iVar4;
                        if (iVar4.code != 0) {
                            break;
                        }
                        iVar3 = iVar4;
                    } else {
                        iVar3 = iVar5;
                    }
                    if (a5.f.size() > 0) {
                        a(a5, countDownLatch, i, new b() { // from class: com.tencent.txcopyrightedmedia.impl.utils.a.2
                            final /* synthetic */ int d = 0;

                            @Override // com.tencent.txcopyrightedmedia.impl.utils.a.b
                            public final void a(i iVar8) {
                                if (iVar8.code == 0) {
                                    atomicInteger.incrementAndGet();
                                    com.tencent.txcopyrightedmedia.a aVar5 = aVar;
                                    if (aVar5 != null) {
                                        aVar5.a(asVar.i(), asVar.j(), (atomicInteger.get() * 1.0f) / this.d);
                                    }
                                } else if (atomicInteger2.compareAndSet(0, iVar8.code)) {
                                    iVar7.code = iVar8.code;
                                    iVar7.msg = iVar8.msg;
                                    iVar7.f26410a = iVar8.f26410a;
                                }
                            }
                        });
                    }
                    iVar5 = iVar3;
                    iVar6 = iVar7;
                }
                iVar = iVar2;
                axVar = axVar2;
                if (iVar2.code == 0) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    StringBuilder sb = new StringBuilder("deep full bgm end. err_code: ");
                    sb.append(iVar6.code);
                    sb.append(", msg: ");
                    sb.append(iVar6.msg);
                    iVar = iVar6;
                    axVar = axVar2;
                }
            } else {
                axVar = axVar2;
                iVar = iVar5;
            }
        } else {
            axVar = axVar2;
            iVar = e;
        }
        if (iVar.code == 0) {
            axVar.e = 100;
            bVar.b.a(axVar);
        }
        z a8 = bVar.a();
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        a8.b.obtainMessage(100, countDownLatch2).sendToTarget();
        try {
            if (a8.f26500a.isAlive()) {
                countDownLatch2.await(5000L, TimeUnit.MILLISECONDS);
                return iVar;
            }
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        return iVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(as asVar, ArrayList<at.a> arrayList, InterfaceC0894a interfaceC0894a) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(at atVar, CountDownLatch countDownLatch, int i, b bVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
