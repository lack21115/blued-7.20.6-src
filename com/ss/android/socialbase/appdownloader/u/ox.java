package com.ss.android.socialbase.appdownloader.u;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/ox.class */
public class ox {
    public static void mb(DownloadInfo downloadInfo) {
        ox(downloadInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r7.getMimeType().equals(com.ss.android.downloadad.api.constant.AdBaseConstants.MIME_APK) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ox(final com.ss.android.socialbase.downloader.model.DownloadInfo r7) {
        /*
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()
            r11 = r0
            r0 = r7
            boolean r0 = r0.isAutoResumed()
            r10 = r0
            r0 = 1
            r9 = r0
            r0 = r10
            if (r0 == 0) goto L17
            r0 = r7
            boolean r0 = r0.isShowNotificationForNetworkResumed()
            if (r0 == 0) goto L39
        L17:
            r0 = r7
            java.lang.String r0 = r0.getExtra()
            boolean r0 = com.ss.android.socialbase.appdownloader.b.ox(r0)
            if (r0 != 0) goto L39
            r0 = r7
            java.lang.String r0 = r0.getMimeType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L39
            r0 = r9
            r8 = r0
            r0 = r7
            java.lang.String r0 = r0.getMimeType()
            java.lang.String r1 = "application/vnd.android.package-archive"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4e
        L39:
            r0 = r9
            r8 = r0
            r0 = r7
            int r0 = r0.getId()
            com.ss.android.socialbase.downloader.setting.DownloadSetting r0 = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(r0)
            java.lang.String r1 = "auto_install_when_resume"
            r2 = 0
            int r0 = r0.optInt(r1, r2)
            r1 = 1
            if (r0 == r1) goto L4e
            r0 = 0
            r8 = r0
        L4e:
            r0 = r8
            if (r0 == 0) goto L60
            r0 = r11
            r1 = r7
            int r1 = r1.getId()
            r2 = 0
            int r0 = com.ss.android.socialbase.appdownloader.b.mb(r0, r1, r2)
            r8 = r0
            goto L62
        L60:
            r0 = 2
            r8 = r0
        L62:
            java.util.concurrent.ExecutorService r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getCPUThreadExecutor()
            com.ss.android.socialbase.appdownloader.u.ox$1 r1 = new com.ss.android.socialbase.appdownloader.u.ox$1
            r2 = r1
            r3 = r11
            r4 = r7
            r5 = r8
            r2.<init>()
            r0.execute(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.ox.ox(com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }
}
