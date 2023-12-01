package com.kwad.components.core.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/e.class */
public class e implements h {
    private static volatile e Ib;
    private String Ic;
    private int Id = 0;
    private int Ie = 1;
    private long If = com.anythink.expressad.d.a.b.aC;
    private boolean Ig = false;

    private e() {
    }

    private e(long j) {
        this.Ic = String.valueOf(j);
    }

    public static e E(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        e eVar = new e(j);
        eVar.Id = cb.adBaseInfo.adCacheStrategy;
        eVar.If = cb.adBaseInfo.adCacheSecond;
        eVar.Ie = cb.adBaseInfo.adCacheSize;
        boolean z = true;
        if (cb.adBaseInfo.adCacheSwitch != 1) {
            z = false;
        }
        eVar.Ig = z;
        return eVar;
    }

    public static List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(b(cursor));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            try {
                String string = cursor.getString(cursor.getColumnIndex("posId"));
                int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
                int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
                long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
                boolean z = true;
                if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                    z = false;
                }
                eVar = new e();
                eVar.Ic = string;
                eVar.Id = i;
                eVar.Ie = i2;
                eVar.If = j;
                eVar.Ig = z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    private static e mf() {
        if (Ib == null) {
            synchronized (e.class) {
                try {
                    if (Ib == null) {
                        Ib = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Ib;
    }

    public static e n(long j) {
        e ah;
        return (a.lW() == null || (ah = a.lW().ah(String.valueOf(j))) == null) ? mf() : ah;
    }

    public final boolean isDefault() {
        return equals(mf());
    }

    public final boolean isEnable() {
        return this.Ig;
    }

    public final int mg() {
        return this.Id;
    }

    public final int mh() {
        return this.Ie;
    }

    public final long mi() {
        return this.If;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.kwad.components.core.b.h
    public final ContentValues mj() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
