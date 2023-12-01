package com.cdo.oaps.ad;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/z.class */
public class z {
    private static String a(long j, String str, int i, String str2, String str3, String str4, int i2) {
        String str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str5 = "";
        } else {
            str5 = "^out_match_type#" + str4;
        }
        sb.append(str5);
        return Uri.encode("out_package_name=" + str + ContainerUtils.FIELD_DELIMITER + "out_pid=" + j + ContainerUtils.FIELD_DELIMITER + "out_operator_type=" + i + ContainerUtils.FIELD_DELIMITER + "out_intent_from=" + i2 + ContainerUtils.FIELD_DELIMITER + "enter_id=" + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params=" + sb.toString());
    }

    private static String a(long j, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("out_pid=" + j + ContainerUtils.FIELD_DELIMITER + "out_package_name=" + str + ContainerUtils.FIELD_DELIMITER + "out_start_download=" + z + ContainerUtils.FIELD_DELIMITER + "out_intent_from=" + i + ContainerUtils.FIELD_DELIMITER + "enter_id=" + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params=" + sb.toString() + ContainerUtils.FIELD_DELIMITER + "cpd_params=" + str7);
    }

    public static String a(Context context, long j, String str, int i, String str2, String str3, String str4, int i2) {
        String a2 = a(j, str, i, str2, str3, str4, i2);
        return "softmarket://market_pre_download?params=" + a2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static String a(Context context, long j, String str, boolean z, boolean z2, String str2, String str3, String str4, int i, String str5) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static String a(Context context, String str, String str2, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static String a(Context context, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + ContainerUtils.FIELD_DELIMITER + "enter_params=" + ("out_operator#" + str2));
    }

    public static String a(String str, String str2, String str3, String str4, int i, String str5) {
        String str6;
        String str7 = "Ext-Module#" + str5;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str3);
        if (ab.a(str4)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str4;
        }
        sb.append(str6);
        return Uri.encode("url=" + str + ContainerUtils.FIELD_DELIMITER + "out_intent_from=" + i + ContainerUtils.FIELD_DELIMITER + "enter_id=" + str2 + ContainerUtils.FIELD_DELIMITER + "enter_params=" + sb.toString() + ContainerUtils.FIELD_DELIMITER + "cpd_params=" + str7);
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, String str5, int i) {
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("out_operator#");
        sb.append(str4);
        if (ab.a(str5)) {
            str6 = "";
        } else {
            str6 = "^out_match_type#" + str5;
        }
        sb.append(str6);
        return Uri.encode("out_package_name=" + str2 + ContainerUtils.FIELD_DELIMITER + "out_app_name=" + str + ContainerUtils.FIELD_DELIMITER + "out_operator=" + str4 + ContainerUtils.FIELD_DELIMITER + "out_start_download=" + z + ContainerUtils.FIELD_DELIMITER + "out_intent_from=" + i + ContainerUtils.FIELD_DELIMITER + "enter_id=" + str3 + ContainerUtils.FIELD_DELIMITER + "enter_params=" + sb.toString());
    }
}
