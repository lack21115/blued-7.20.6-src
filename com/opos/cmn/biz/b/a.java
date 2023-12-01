package com.opos.cmn.biz.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.opos.cmn.biz.a.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10921a = a.class.getSimpleName();

    public static final boolean a(Context context, String str) {
        String str2;
        String str3;
        if (context == null) {
            str2 = f10921a;
            str3 = "executeBrowser with null context";
        } else if (!TextUtils.isEmpty(str)) {
            String b = c.b(context);
            String str4 = f10921a;
            com.opos.cmn.an.f.a.b(str4, "getBrowserName=" + b);
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setClassName(b, "com.android.browser.BrowserActivity");
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                Log.e(f10921a, "executeBrowserWeb fail", e);
                return false;
            }
        } else {
            str2 = f10921a;
            str3 = "executeBrowserWeb with null url";
        }
        com.opos.cmn.an.f.a.b(str2, str3);
        return false;
    }
}
