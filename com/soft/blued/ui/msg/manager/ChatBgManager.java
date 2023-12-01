package com.soft.blued.ui.msg.manager;

import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.utils.Md5;
import com.soft.blued.utils.BluedPreferences;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/manager/ChatBgManager.class */
public class ChatBgManager {
    public static void a(String str) {
        if (TextUtils.isEmpty(BluedPreferences.ad())) {
            return;
        }
        BluedPreferences.a(str, BluedPreferences.ad());
        BluedPreferences.y("");
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals("default");
    }

    public static String c(String str) {
        String b = AppMethods.b("ChatBgImg");
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        File file = new File(b);
        if (file.exists() || file.mkdirs()) {
            return new File(file, "bg_" + Md5.a(str.toLowerCase().trim())).getAbsolutePath();
        }
        return "";
    }
}
