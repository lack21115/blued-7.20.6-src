package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cdo.oaps.ad.p;
import com.igexin.assist.sdk.AssistPushConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.turingface.sdk.mfa.LJPko;
import com.tencent.turingface.sdk.mfa.vqARY;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/rBDKv.class */
public final class rBDKv {

    /* renamed from: a  reason: collision with root package name */
    public static final rBDKv f26294a = new rBDKv();
    public static long b = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: c  reason: collision with root package name */
    public static int[] f26295c = {0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, p.j};
    public CvowV d;
    public spXPg e;
    public fenkF g;
    public boolean f = false;
    public final Object h = new Object();
    public final AtomicReference<vneRm> i = new AtomicReference<>(null);
    public final AtomicReference<Boolean> j = new AtomicReference<>(Boolean.FALSE);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/rBDKv$spXPg.class */
    public final class spXPg extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Context f26296a;

        public spXPg(Looper looper, Context context) {
            super(looper);
            this.f26296a = context;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            System.currentTimeMillis();
            int i = message.what;
            if (i == 1) {
                rBDKv.this.a(this.f26296a, true, 3);
            } else if (i != 2) {
            } else {
                rBDKv.this.a(rBDKv.this.a(this.f26296a, true, false, ((Integer) message.obj).intValue()), false);
                synchronized (rBDKv.this.j) {
                    rBDKv.this.j.set(Boolean.FALSE);
                    rBDKv.this.j.notifyAll();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v84, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x0410 -> B:8:0x0023). Please submit an issue!!! */
    public static void a(rBDKv rbdkv) {
        Context context;
        Context context2;
        YaDRx yaDRx;
        long j;
        int i;
        long j2;
        String str;
        File file;
        rbdkv.getClass();
        synchronized (i3cNc.class) {
            try {
                context = i3cNc.f26267a;
            } catch (Throwable th) {
                throw th;
            }
        }
        MtmV0.a(context, rbdkv.g);
        try {
            Thread.sleep(rbdkv.d.w);
        } catch (InterruptedException e) {
        }
        DO0IX do0ix = DO0IX.f26176a;
        synchronized (do0ix) {
            try {
                System.currentTimeMillis();
                do0ix.c(context);
                System.currentTimeMillis();
                do0ix.b(context);
            } catch (Throwable th2) {
            }
        }
        if (do0ix.a(39)) {
            rbdkv.g.getClass();
            if (TextUtils.isEmpty(fenkF.b(context, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE))) {
                StringBuilder sb = new StringBuilder();
                try {
                    String[] split = new String(com.tencent.turingcam.oqKCa.d("/proc/self/maps")).split("\n");
                    HashSet hashSet = new HashSet();
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        String[] split2 = split[i3].split(" +");
                        if (split2.length >= 2) {
                            String trim = split2[split2.length - 1].trim();
                            try {
                                file = new File(trim);
                            } catch (Throwable th3) {
                                str = null;
                            }
                            if (file.exists()) {
                                str = file.getName();
                                if (str != null && str.contains(ShareConstants.RES_PATH) && str.endsWith(".apk") && !str.contains("mediatek") && !TextUtils.equals("/system/framework/framework-res.apk", trim) && !hashSet.contains(trim)) {
                                    hashSet.add(trim);
                                    String a2 = EQsUZ.a(context, trim);
                                    if (a2 != null && !TextUtils.equals(a2, "android.auto_generated_rro__") && !TextUtils.equals(a2, "android.overlay")) {
                                        if (sb.length() > 0) {
                                            sb.append(":");
                                        }
                                        sb.append(a2);
                                    }
                                }
                            }
                        }
                        i2 = i3 + 1;
                    }
                } catch (Throwable th4) {
                }
                sb.append(",");
                String name = Resources.getSystem().getClass().getName();
                if (!TextUtils.equals("android.content.res.Resources", name)) {
                    sb.append(name);
                }
                rbdkv.g.a(context, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE, sb.toString().replace("(\\|)|\\s*|\t|\r|\n", ""), true);
            }
        }
        long j3 = 0;
        if (rbdkv.d.t && do0ix.a(45)) {
            fenkF fenkf = rbdkv.g;
            int i4 = z5VDt.b;
            fenkf.getClass();
            try {
                j2 = Long.valueOf(fenkF.b(context, "902")).longValue();
            } catch (Throwable th5) {
                j2 = 0;
            }
            if (Math.abs(j2 - System.currentTimeMillis()) >= z5VDt.f26324a) {
                if (TextUtils.isEmpty(fenkF.b(context, "901")) ? true : Math.abs(j2 - System.currentTimeMillis()) >= G1g37.b.a(context, "sid_refresh_period", G1g37.f26185a, 3600000L)) {
                    Bi3eT b2 = kWj12.b(context);
                    if (b2.f26168a != 0) {
                        b2 = kWj12.a(context);
                    }
                    if (b2.f26168a == 0) {
                        String str2 = b2.d;
                        HashMap hashMap = new HashMap();
                        hashMap.put("901", str2);
                        fenkF.a(context, hashMap);
                        String bi3eT = b2.toString();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("904", bi3eT);
                        fenkF.a(context, hashMap2);
                    }
                }
                fenkf.b(context, System.currentTimeMillis());
            }
        }
        CvowV cvowV = rbdkv.d;
        if (cvowV.p) {
            com.tencent.turingface.sdk.mfa.spXPg spxpg = cvowV.f26175c;
            com.tencent.turingface.sdk.mfa.spXPg spxpg2 = spxpg;
            if (spxpg == null) {
                spxpg2 = CvowV.f26174a;
            }
            if (spxpg2.a()) {
                if (do0ix.a(41) && vqARY.f26315a.containsKey(vqARY.f26316c)) {
                    new X7aJM((vqARY.spXPg) vqARY.f26315a.get(vqARY.f26316c), context).start();
                }
                rbdkv.a(rbdkv.d.e, false, 0);
                CvowV cvowV2 = LJPko.f26202a;
                synchronized (i3cNc.class) {
                    try {
                        context2 = i3cNc.f26267a;
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
                AtomicReference<YaDRx> atomicReference = LJPko.b;
                synchronized (atomicReference) {
                    YaDRx yaDRx2 = atomicReference.get();
                    yaDRx = yaDRx2;
                    if (yaDRx2 == null) {
                        String b3 = fenkF.b(context2, "1001");
                        if (TextUtils.isEmpty(b3)) {
                            yaDRx = null;
                        } else {
                            try {
                                j = Long.parseLong(fenkF.b(context2, "1002"));
                            } catch (Throwable th7) {
                                j = 0;
                            }
                            try {
                                j3 = Long.parseLong(fenkF.b(context2, "1003"));
                            } catch (Throwable th8) {
                            }
                            try {
                                i = Integer.parseInt(fenkF.b(context2, "1004"));
                            } catch (Throwable th9) {
                                i = 0;
                            }
                            yaDRx = new YaDRx(0, b3, j, j3, i);
                            LJPko.b.set(yaDRx);
                        }
                    }
                }
                if (yaDRx != null) {
                    return;
                }
                LJPko.spXPg spxpg3 = new LJPko.spXPg();
                AtomicReference<AtomicReference<YaDRx>> atomicReference2 = LJPko.spXPg.b;
                synchronized (atomicReference2) {
                    if (atomicReference2.get() != null) {
                        return;
                    }
                    atomicReference2.set(new AtomicReference<>(null));
                    LJPko.spXPg.f26203a.post(spxpg3);
                }
            }
        }
    }

    public final int a(vneRm vnerm) {
        Context context;
        long j;
        Context context2;
        if (this.d.q || vnerm.f26312c != 0 || TextUtils.isEmpty(vnerm.f26311a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= vnerm.b) {
            this.d.getClass();
            return 3;
        }
        fenkF fenkf = this.g;
        synchronized (i3cNc.class) {
            try {
                context = i3cNc.f26267a;
            } finally {
            }
        }
        fenkf.getClass();
        try {
            j = Long.valueOf(fenkF.b(context, "107")).longValue();
        } catch (Throwable th) {
            j = 0;
        }
        fenkF fenkf2 = this.g;
        synchronized (i3cNc.class) {
            try {
                context2 = i3cNc.f26267a;
            } finally {
            }
        }
        if (Math.abs(currentTimeMillis - fenkf2.a(context2, "108")) >= j) {
            this.d.getClass();
            return 3;
        }
        return 1;
    }

    public final vneRm a(Context context) {
        vneRm vnerm;
        synchronized (this.i) {
            vneRm vnerm2 = this.i.get();
            vnerm = vnerm2;
            if (vnerm2 == null) {
                fenkF fenkf = this.g;
                vneRm a2 = fenkf != null ? fenkf.a(context) : vneRm.a(1);
                this.i.set(a2);
                vnerm = a2;
            }
        }
        return vnerm;
    }

    public final vneRm a(Context context, boolean z, int i) {
        vneRm a2 = a(context);
        if (this.d == null) {
            return vneRm.a(-10002);
        }
        int a3 = a(a2);
        if (a3 == 1) {
            return a2;
        }
        if (a3 != 2) {
            if (a3 == 3) {
                a();
            }
            return a2;
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return vneRm.a(-10008);
        } else {
            synchronized (this.h) {
                vneRm a4 = a(context);
                if (a4 == a2 || a(a4) != 1) {
                    synchronized (this.j) {
                        if (!this.j.get().booleanValue()) {
                            this.j.set(Boolean.TRUE);
                            this.e.post(new eCoqw(this, context, i));
                        }
                        try {
                            this.j.wait(z ? this.d.u : 10000L);
                        } catch (InterruptedException e) {
                        }
                    }
                    vneRm a5 = a(context);
                    if (a5 != a2) {
                        return a5;
                    }
                    return vneRm.a(-10004);
                }
                return a4;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final vneRm a(Context context, boolean z, boolean z2, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a() {
        synchronized (this.j) {
            if (this.j.get().booleanValue()) {
                return;
            }
            this.j.set(Boolean.TRUE);
            this.e.sendMessageDelayed(Message.obtain(this.e, 2, 3), 0L);
        }
    }

    public final void a(vneRm vnerm, boolean z) {
        synchronized (this.i) {
            if (!z) {
                if (vnerm.f26312c != 0) {
                    return;
                }
            }
            this.i.set(vnerm);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final vneRm b(Context context, boolean z, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
