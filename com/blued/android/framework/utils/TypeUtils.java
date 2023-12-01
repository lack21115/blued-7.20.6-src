package com.blued.android.framework.utils;

import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/TypeUtils.class */
public class TypeUtils {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Object obj) {
        return obj;
    }

    public static boolean a(List<?> list) {
        return list == null || list.isEmpty();
    }
}
