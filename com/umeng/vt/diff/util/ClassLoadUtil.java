package com.umeng.vt.diff.util;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/vt/diff/util/ClassLoadUtil.class */
public class ClassLoadUtil {
    public static Class<?> findClass(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
