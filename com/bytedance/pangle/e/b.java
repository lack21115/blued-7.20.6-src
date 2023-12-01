package com.bytedance.pangle.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f21384a = 1;
    public static int b = 2;

    public static SharedPreferences a(Context context) {
        return context.getApplicationContext().getSharedPreferences("plugin_oat_info", 0);
    }

    public static String a() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        String substring = str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1);
        String substring2 = substring.substring(substring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ShareConstants.ODEX_SUFFIX : ShareConstants.DEX_SUFFIX;
        String str3 = substring;
        if (!ShareConstants.DEX_SUFFIX.equals(substring2)) {
            if (!".zip".equals(substring2) && !".apk".equals(substring2)) {
                return substring + str2;
            }
            str3 = substring.replace(substring2, str2);
        }
        return str3;
    }

    public static void a(String str, String str2) {
        a.a(a(str, str2, f21384a));
    }

    public static boolean a(String str, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            String str2 = strArr[i2];
            if (!new File(str + File.separator + a(str2)).exists()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(String... strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 0) {
                return true;
            }
            File file = new File(strArr[0]);
            if (!file.exists() || !h.a(file)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] a(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + a());
        if (i == f21384a) {
            if (i.h()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == b) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String b(String str) {
        String substring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ShareConstants.ODEX_SUFFIX : ShareConstants.DEX_SUFFIX;
        if (ShareConstants.DEX_SUFFIX.equals(substring)) {
            return substring;
        }
        if (!".zip".equals(substring) && !".apk".equals(substring)) {
            return str + str2;
        }
        return str2;
    }
}
