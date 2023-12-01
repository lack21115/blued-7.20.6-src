package com.anythink.core.common.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.anythink.core.basead.ui.web.WebLandPageActivity;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/l.class */
public final class l {
    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268468224);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context, String str) {
        try {
            WebLandPageActivity.a(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
