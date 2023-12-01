package com.kwad.components.core.d.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/b/e.class */
public final class e {
    private static boolean Jn = false;

    private static void J(final AdTemplate adTemplate) {
        if (nt()) {
            return;
        }
        az(true);
        int abs = Math.abs(com.kwad.sdk.core.config.d.uo());
        if (abs > 0) {
            bi.a(new Runnable() { // from class: com.kwad.components.core.d.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.az(false);
                    com.kwad.sdk.core.b.b.vS();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(AdTemplate.this, "wxsmallapp", 1);
                }
            }, null, abs * 1000);
        } else {
            az(false);
        }
    }

    public static int a(Context context, String str, String str2, String str3, AdTemplate adTemplate) {
        Cursor cursor;
        Cursor cursor2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            com.kwad.sdk.core.report.a.k(adTemplate, 1);
            return -1;
        }
        try {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.addFlags(268435456);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
                cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str2, str3, "0", ""}, null);
                if (cursor != null) {
                    try {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    } catch (Exception e) {
                        com.kwad.sdk.core.report.a.k(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                com.kwad.sdk.core.report.a.a(adTemplate, "wxsmallapp", 1, (y.b) null);
                J(adTemplate);
                return 1;
            } catch (Exception e2) {
                cursor = null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void az(boolean z) {
        Jn = z;
    }

    public static int f(Context context, AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.core.response.a.a.L(cb) || com.kwad.sdk.core.response.a.a.M(cb)) {
            return 0;
        }
        return a(context, cb.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, cb.adConversionInfo.smallAppJumpInfo.originId, cb.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl, adTemplate);
    }

    private static boolean nt() {
        return Jn;
    }
}
