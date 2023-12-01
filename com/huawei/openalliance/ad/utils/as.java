package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/as.class */
public abstract class as {
    private static final List<String> Code = new ArrayList();

    public static void Code(Context context) {
        Code.clear();
        Code.add(ar.Z(context));
        Code.add(ar.V(context));
        Code.add(ar.B(context));
        Code.add(ar.I(context));
    }

    public static boolean Code(String str) {
        if (Code.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return Code.contains(str);
    }
}
