package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dp.class */
public class dp {
    private static final String Code = "AppDownloadUtils";

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r2.S() > 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r2) {
        /*
            r0 = r2
            int r0 = r0.B()
            switch(r0) {
                case 0: goto L52;
                case 1: goto L4e;
                case 2: goto L4a;
                case 3: goto L46;
                case 4: goto L3c;
                case 5: goto L38;
                case 6: goto L34;
                default: goto L30;
            }
        L30:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            return r0
        L34:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            return r0
        L38:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLING
            return r0
        L3c:
            r0 = r2
            int r0 = r0.S()
            if (r0 <= 0) goto L30
            goto L52
        L46:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALL
            return r0
        L4a:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
            return r0
        L4e:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.WAITING
            return r0
        L52:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.PAUSE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.dp.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask):com.huawei.openalliance.ad.download.app.k");
    }

    public static String Code(Context context, AppInfo appInfo) {
        return (context == null || appInfo == null) ? "" : Code(appInfo.j(), context.getString(R.string.hiad_download_download));
    }

    public static String Code(Context context, AppInfo appInfo, int i) {
        int i2;
        if (context == null || appInfo == null) {
            return "";
        }
        String k = appInfo.k();
        if (!Code(appInfo)) {
            i2 = R.string.hiad_download_open;
        } else if (i == 1) {
            return context.getString(R.string.hiad_app_preordered);
        } else {
            i2 = R.string.hiad_app_preorder;
        }
        return Code(k, context.getString(i2));
    }

    public static String Code(Context context, AppInfo appInfo, String str) {
        return (appInfo == null || context == null || com.huawei.openalliance.ad.utils.e.V(context, appInfo.Code()) == null || !TextUtils.isEmpty(appInfo.G())) ? str : context.getString(R.string.hiad_download_open);
    }

    public static String Code(String str, String str2) {
        return (TextUtils.isEmpty(str) || (!(com.huawei.openalliance.ad.utils.ay.B() && com.huawei.openalliance.ad.utils.ay.Code.equalsIgnoreCase(c.V())) && com.huawei.openalliance.ad.utils.ay.B())) ? str2 : str;
    }

    public static boolean Code(AppInfo appInfo) {
        return (appInfo == null || TextUtils.isEmpty(appInfo.G())) ? false : true;
    }
}
