package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/ww.class */
public class ww {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/ww$mb.class */
    public static class mb {
        private static ww mb = new ww();
    }

    private ww() {
    }

    private void b(final com.ss.android.downloadad.api.mb.ox oxVar, long j) {
        final int m = oxVar.m();
        if (DownloadSetting.obtain(m).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(m);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(m);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 2);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (jb.ox(oxVar)) {
                    jb.mb(jSONObject, "error_code", (Object) 1002);
                } else {
                    ww.this.mb(m, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j * 1000);
    }

    public static ww mb() {
        return mb.mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i, com.ss.android.downloadad.api.mb.ox oxVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.h.hj.mb()) {
            jb.mb(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            jb.mb(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (DownloadNotificationManager.getInstance().getNotificationItem(i) != null) {
            DownloadNotificationManager.getInstance().cancelNotification(i);
        }
        com.ss.android.socialbase.appdownloader.h.mb mbVar = new com.ss.android.socialbase.appdownloader.h.mb(x.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        mbVar.setCurBytes(downloadInfo.getCurBytes());
        mbVar.setTotalBytes(downloadInfo.getTotalBytes());
        mbVar.refreshStatus(downloadInfo.getStatus(), null, false, false);
        DownloadNotificationManager.getInstance().addNotification(mbVar);
        mbVar.updateNotification(null, false);
        AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_SHOW, jSONObject, oxVar);
    }

    private void ox(final com.ss.android.downloadad.api.mb.ox oxVar, long j) {
        final int m = oxVar.m();
        if (DownloadSetting.obtain(m).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(m);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(m);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 1);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (downloadInfo == null || -2 != downloadInfo.getRealStatus() || downloadInfo.isPauseReserveOnWifi()) {
                    jb.mb(jSONObject, "error_code", (Object) 1001);
                } else {
                    ww.this.mb(m, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j * 1000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ww1672829046017dc(java.lang.String r5) {
        /*
        L0:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L85;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L0;
                case 95: goto L85;
                case 96: goto L85;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L5f;
                case 56: goto L85;
                case 57: goto L85;
                default: goto L5c;
            }
        L5c:
            goto L0
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.b.ww.ww1672829046017dc(java.lang.String):java.lang.String");
    }

    public void b(com.ss.android.downloadad.api.mb.ox oxVar) {
        b(oxVar, 5L);
    }

    public void h(com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar, 5L);
    }

    public void hj(com.ss.android.downloadad.api.mb.ox oxVar) {
        b(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_install_delay_secs", 5));
    }

    public void mb(int i) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.h.b.mb().mb(i) != null || (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.h.b.mb().mb(i, downloadInfo.getIconUrl());
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        ox(oxVar, 5L);
    }

    public void mb(final com.ss.android.downloadad.api.mb.ox oxVar, long j) {
        final int m = oxVar.m();
        if (DownloadSetting.obtain(m).optInt("notification_opt_2") != 1) {
            return;
        }
        mb(m);
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.ww.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(m);
                JSONObject jSONObject = new JSONObject();
                jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 3);
                com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
                if (jb.b(oxVar.h())) {
                    jb.mb(jSONObject, "error_code", (Object) 1003);
                } else {
                    ww.this.mb(m, oxVar, jSONObject);
                }
                AdEventHandler.mb().ox(EventConstants.Label.NOTIFICATION_TRY_SHOW, jSONObject, oxVar);
            }
        }, j * 1000);
    }

    public void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        ox(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_continue_delay_secs", 5));
    }

    public void u(com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar, DownloadSetting.obtain(oxVar.m()).optInt("noti_open_delay_secs", 5));
    }
}
