package com.baidu.idl.facesdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/idl/facesdk/BDFaceUtils.class */
public class BDFaceUtils {
    public static boolean hasModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getAssets().open(str) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
