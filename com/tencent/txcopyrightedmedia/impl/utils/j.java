package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public String f40104a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f40105c;

    public j() {
        c();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public j(String str) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static String a(int i) {
        return i == 1 ? "chorus" : com.anythink.expressad.d.a.b.ax;
    }

    private static String a(String[] strArr, String[] strArr2) {
        int i;
        if (strArr.length != strArr2.length || strArr.length == 0) {
            return "";
        }
        int length = strArr.length;
        while (true) {
            i = length - 1;
            if (i < 0 || !((TextUtils.isEmpty(strArr[i]) && TextUtils.isEmpty(strArr2[i])) || TextUtils.equals(strArr[i], strArr2[i]))) {
                break;
            }
            length = i;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > i) {
                return sb.substring(0, sb.length() - 1);
            }
            if (TextUtils.isEmpty(strArr[i3]) && TextUtils.isEmpty(strArr2[i3])) {
                strArr[i3] = "default";
            }
            sb.append(strArr[i3]);
            sb.append(BridgeUtil.SPLIT_MARK);
            i2 = i3 + 1;
        }
    }

    private void c() {
        this.f40104a = aj.e();
        this.b = 0;
        this.f40105c = null;
    }

    public final String a() {
        return a(new String[]{this.f40104a, a(this.b), this.f40105c}, new String[]{"audio/unset", com.anythink.expressad.d.a.b.ax, null});
    }

    public final String b() {
        return a(new String[]{this.f40104a, a(this.b)}, new String[]{"audio/unset", com.anythink.expressad.d.a.b.ax});
    }
}
