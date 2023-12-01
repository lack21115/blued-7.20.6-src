package com.blued.android.module.yy_china.utils;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/UserRelationshipUtils.class */
public class UserRelationshipUtils {
    public static String a(Context context, String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "0";
        }
        boolean z = true;
        switch (str2.hashCode()) {
            case 49:
                if (str2.equals("1")) {
                    z = false;
                    break;
                }
                break;
            case 50:
                if (str2.equals("2")) {
                    z = true;
                    break;
                }
                break;
            case 51:
                if (str2.equals("3")) {
                    z = true;
                    break;
                }
                break;
        }
        return z ? !z ? context.getResources().getString(R.string.yy_follow) : context.getResources().getString(R.string.yy_follow_eachother) : context.getResources().getString(R.string.yy_followed);
    }

    public static String b(Context context, String str) {
        return TextUtils.equals(str, "2") ? context.getResources().getString(R.string.yy_role_manager) : TextUtils.equals(str, "1") ? context.getResources().getString(R.string.yy_role_host) : "";
    }
}
