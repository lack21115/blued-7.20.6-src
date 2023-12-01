package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.g.g;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/HDnuc.class */
public final class HDnuc {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f39879a = new AtomicBoolean(false);
    public static final AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f39880c = new Object();
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static CvowV e;

    public static int a() {
        if (f39879a.get()) {
            if (com.tencent.turingcam.oqKCa.f39831a == 0) {
                return -10018;
            }
            if (b.get()) {
                spXPg spxpg = e.f39866c;
                spXPg spxpg2 = spxpg;
                if (spxpg == null) {
                    spxpg2 = CvowV.f39865a;
                }
                return !spxpg2.a() ? -10019 : 0;
            }
            return g.k;
        }
        return g.j;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(CvowV cvowV) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static int b(CvowV cvowV) {
        AtomicBoolean atomicBoolean = f39879a;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z = true;
        if (cvowV.h) {
            TextUtils.isEmpty(cvowV.j);
            String str = cvowV.j;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingmfa");
                } else {
                    System.load(str);
                }
            } catch (Throwable th) {
                Log.w("TuringFdJava", th);
                z = false;
            }
            f39879a.set(z);
            if (!z) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        if (f39879a.get()) {
            return 0;
        }
        return g.j;
    }

    public static int c(CvowV cvowV) {
        Context context = cvowV.e;
        HashMap hashMap = new HashMap();
        G1g37 g1g37 = G1g37.b;
        hashMap.put(ErrorCode.loadFailInPacingError, g1g37.a(context, "e_w_d", false) ? "1" : "0");
        hashMap.put(ErrorCode.loadCappingError, g1g37.a(context, "e_r_d", true) ? "1" : "0");
        hashMap.put(ErrorCode.filterSourceError, g1g37.a(context, "e_w_nd", true) ? "1" : "0");
        hashMap.put(ErrorCode.loadInShowingFilter, g1g37.a(context, "e_r_nd", true) ? "1" : "0");
        try {
            return com.tencent.turingcam.oqKCa.b(TNative$aa.i77(new SparseArray(), context, hashMap)) != 0 ? -10020 : 0;
        } catch (Throwable th) {
            return -10020;
        }
    }
}
