package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.drm.DrmManagerClient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.api.ErrorCode;
import com.anythink.expressad.video.bt.a.c;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/LJPko.class */
public final class LJPko {

    /* renamed from: a  reason: collision with root package name */
    public static CvowV f39893a;
    public static final AtomicReference<YaDRx> b = new AtomicReference<>(null);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/LJPko$spXPg.class */
    public static final class spXPg implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final Handler f39894a;
        public static final AtomicReference<AtomicReference<YaDRx>> b = new AtomicReference<>(null);

        static {
            HandlerThread handlerThread = new HandlerThread("TuringRiskThread", 0);
            handlerThread.start();
            f39894a = new Handler(handlerThread.getLooper());
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            YaDRx yaDRx;
            synchronized (i3cNc.class) {
                try {
                    context = i3cNc.f39958a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            ZIDl7 zIDl7 = new ZIDl7();
            try {
                DO0IX.f39867a.a(context);
                zIDl7.b = 1;
                zIDl7.e = System.currentTimeMillis();
                byte[] a2 = LJPko.a(context, zIDl7, true);
                zIDl7.f = System.currentTimeMillis();
                zIDl7.f39934c = a2.length;
                yaDRx = LJPko.a(context, a2, zIDl7);
            } catch (Throwable th2) {
                yaDRx = null;
            }
            try {
                LJPko.a(context, yaDRx);
                LJPko.a(context, zIDl7);
                AtomicReference<AtomicReference<YaDRx>> atomicReference = b;
                synchronized (atomicReference) {
                    AtomicReference<YaDRx> andSet = atomicReference.getAndSet(null);
                    if (andSet != null) {
                        andSet.set(yaDRx);
                    }
                    atomicReference.notifyAll();
                }
            } catch (Throwable th3) {
                AtomicReference<AtomicReference<YaDRx>> atomicReference2 = b;
                synchronized (atomicReference2) {
                    AtomicReference<YaDRx> andSet2 = atomicReference2.getAndSet(null);
                    if (andSet2 != null) {
                        if (yaDRx == null) {
                            yaDRx = new YaDRx(-10015);
                        }
                        andSet2.set(yaDRx);
                    }
                    atomicReference2.notifyAll();
                }
            }
        }
    }

    public static YaDRx a(Context context, byte[] bArr, ZIDl7 zIDl7) {
        if (bArr.length == 0) {
            return new YaDRx(-1000);
        }
        tmnyR a2 = A48DB.f39857a.a(bArr);
        int i = a2.b;
        if (i != 0) {
            return new YaDRx(i);
        }
        byte[] bArr2 = a2.f39999c;
        try {
            sWkeo swkeo = new sWkeo();
            swkeo.f39990a = c.f8290a;
            if (zIDl7.b == 1) {
                swkeo = (sWkeo) com.tencent.turingcam.oqKCa.a(swkeo, bArr2);
            } else {
                swkeo.a(new nyvKz(bArr2));
            }
            if (swkeo == null) {
                return new YaDRx(-1002);
            }
            int i2 = swkeo.f39990a;
            if (i2 == 0) {
                if (TextUtils.isEmpty(swkeo.b)) {
                    return new YaDRx(-1001);
                }
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (swkeo.f39991c < seconds) {
                    swkeo.f39991c = seconds;
                }
                return new YaDRx(0, swkeo.b, System.currentTimeMillis(), swkeo.f39991c * 1000, swkeo.d);
            }
            return new YaDRx(DrmManagerClient.ERROR_UNKNOWN - i2);
        } catch (Throwable th) {
            return new YaDRx(c.f8290a);
        }
    }

    public static String a(Context context, int i) {
        List<String> list;
        HashMap hashMap = new HashMap();
        hashMap.put("3", "" + i);
        if (i == 17 || i == 40) {
            f39893a.getClass();
            synchronized (BijG2.class) {
                try {
                    list = BijG2.f39861a;
                    list.isEmpty();
                } catch (Throwable th) {
                    throw th;
                }
            }
            HashSet hashSet = new HashSet();
            if (!list.isEmpty()) {
                hashSet.addAll(list);
            }
            if (hashSet.size() > 0) {
                hashMap.put("277", BijG2.a(hashSet));
            }
        }
        try {
            SparseArray<Object> h77 = TNative$aa.h77(new SparseArray(), context, hashMap, 0);
            if (com.tencent.turingcam.oqKCa.b(h77) != 0) {
                return "";
            }
            String str = (String) com.tencent.turingcam.oqKCa.a(h77, 205, String.class);
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            String[] split = str2.split(",");
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return sb.toString();
                }
                String str3 = split[i3];
                if (!str3.split(":")[0].equals("0")) {
                    sb.append(str3);
                    sb.append(":");
                    sb.append(",");
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    public static void a(Context context, YaDRx yaDRx) {
        AtomicReference<YaDRx> atomicReference = b;
        synchronized (atomicReference) {
            if (yaDRx.f39930a != 0) {
                return;
            }
            atomicReference.set(yaDRx);
            String str = fenkF.f39952a;
            if (TextUtils.isEmpty(yaDRx.b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ErrorCode.networkError, yaDRx.b);
            hashMap.put(ErrorCode.serverError, String.valueOf(yaDRx.f39931c));
            hashMap.put("1003", String.valueOf(yaDRx.d));
            hashMap.put("1004", String.valueOf(yaDRx.e));
            fenkF.a(context, hashMap);
        }
    }

    public static void a(Context context, ZIDl7 zIDl7) {
        long j;
        StringBuilder b2 = com.tencent.turingcam.oqKCa.b("5_");
        b2.append(zIDl7.b);
        b2.append(BridgeUtil.UNDERLINE_STR);
        b2.append(zIDl7.d);
        b2.append(BridgeUtil.UNDERLINE_STR);
        b2.append(System.currentTimeMillis() - zIDl7.f39933a);
        b2.append(BridgeUtil.UNDERLINE_STR);
        b2.append(zIDl7.f39934c);
        b2.append(BridgeUtil.UNDERLINE_STR);
        long j2 = zIDl7.e;
        if (j2 >= 0) {
            long j3 = zIDl7.f;
            if (j3 >= j2) {
                j = j3 - j2;
                b2.append(j);
                String sb = b2.toString();
                String str = fenkF.f39952a;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb);
                fenkF.a(context, hashMap);
            }
        }
        j = -1;
        b2.append(j);
        String sb2 = b2.toString();
        String str2 = fenkF.f39952a;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb2);
        fenkF.a(context, hashMap2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static byte[] a(Context context, ZIDl7 zIDl7, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
