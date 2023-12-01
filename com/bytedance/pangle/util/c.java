package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/c.class */
public final class c {
    public static String[] a(File file) {
        String[] a2 = com.bytedance.pangle.util.a.b.a(file);
        String[] strArr = a2;
        if (TextUtils.isEmpty(a2[0])) {
            strArr = com.bytedance.pangle.util.a.a.a(file);
        }
        return strArr;
    }
}
