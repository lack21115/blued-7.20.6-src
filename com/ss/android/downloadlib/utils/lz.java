package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/lz.class */
public class lz {
    private static Map<String, mb> mb = Collections.synchronizedMap(new HashMap());

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/lz$mb.class */
    public interface mb {
        void mb();

        void mb(String str);
    }

    private static mb b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mb.remove(str);
    }

    public static void mb(String str) {
        mb b;
        if (TextUtils.isEmpty(str) || (b = b(str)) == null) {
            return;
        }
        b.mb();
    }

    private static void mb(String str, mb mbVar) {
        if (TextUtils.isEmpty(str) || mbVar == null) {
            return;
        }
        mb.put(str, mbVar);
    }

    public static void mb(String str, String str2) {
        mb b;
        if (TextUtils.isEmpty(str) || (b = b(str)) == null) {
            return;
        }
        b.mb(str2);
    }

    public static void mb(String[] strArr, mb mbVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        mb(valueOf, mbVar);
        TTDelegateActivity.mb(valueOf, strArr);
    }

    public static boolean ox(String str) {
        return com.ss.android.downloadlib.addownload.x.h().mb(com.ss.android.downloadlib.addownload.x.getContext(), str);
    }
}
