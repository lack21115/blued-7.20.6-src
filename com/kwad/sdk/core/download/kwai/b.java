package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/kwai/b.class */
public class b {
    public static int g(Context context, String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                return 0;
            }
            try {
                com.kwad.sdk.core.d.b.d("BaseDeepLinkHelper", "handleDeepLink: " + str);
                Uri parse = Uri.parse(str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(parse);
                intent.setFlags(268435456);
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                i = 0;
                if (queryIntentActivities != null) {
                    i = 0;
                    if (queryIntentActivities.size() > 0) {
                        context.startActivity(intent);
                        return 1;
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                i = -1;
            }
        }
        return i;
    }
}
