package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/q.class */
public class q {
    public static boolean a(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (TextUtils.isEmpty(strArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
