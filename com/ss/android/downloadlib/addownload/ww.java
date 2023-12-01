package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ww.class */
public class ww {
    public static int mb(com.ss.android.downloadlib.addownload.model.h hVar, boolean z, com.ss.android.socialbase.appdownloader.u uVar) {
        int i;
        if (uVar == null || TextUtils.isEmpty(uVar.mb()) || uVar.getContext() == null) {
            return 0;
        }
        try {
            i = mb(uVar, uVar.mb());
        } catch (Throwable th) {
            x.m().mb(th, "redirectSavePathIfPossible");
            i = 4;
        }
        uVar.mb(i);
        if (i == 0) {
            uVar.mb(new com.ss.android.downloadlib.b.mb());
        }
        if (!uVar.cd()) {
            uVar.mb(new com.ss.android.downloadlib.b.ox());
        }
        int mb = com.ss.android.socialbase.appdownloader.hj.x().mb(uVar);
        com.ss.android.downloadad.api.mb.ox mb2 = mb(hVar, mb);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(mb2);
        mb2.ko(mb);
        mb2.ww(System.currentTimeMillis());
        mb2.lz(0L);
        DownloadSetting obtain = DownloadSetting.obtain(uVar.kg());
        if (!mb(uVar, obtain, mb) && hVar.ox.isShowToast()) {
            String startToast = hVar.ox.getStartToast();
            String str = startToast;
            if (TextUtils.isEmpty(startToast)) {
                str = obtain.optString("download_start_toast_text");
            }
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            x.b().mb(2, uVar.getContext(), hVar.ox, str2, null, 0);
        }
        return mb;
    }

    private static int mb(com.ss.android.socialbase.appdownloader.u uVar, String str) {
        int i;
        DownloadSetting obtain = DownloadSetting.obtain(uVar.kg());
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        String ox = uVar.ox();
        String al = uVar.al();
        String str2 = al;
        if (TextUtils.isEmpty(al)) {
            str2 = com.ss.android.socialbase.appdownloader.b.mb(str, ox, uVar.je(), true);
        }
        String str3 = str2;
        if (str2.length() > 255) {
            str3 = str2.substring(str2.length() - 255);
        }
        String str4 = ox;
        if (TextUtils.isEmpty(ox)) {
            str4 = str3;
        }
        String b = uVar.b();
        String str5 = b;
        if (TextUtils.isEmpty(b)) {
            str5 = com.ss.android.socialbase.appdownloader.b.ox();
        }
        String str6 = str5 + File.separator + com.ss.android.socialbase.appdownloader.b.mb(str4, obtain);
        DownloadInfo mb = com.ss.android.socialbase.appdownloader.hj.x().mb(uVar.getContext(), str);
        if (mb != null && mb.isSavePathRedirected()) {
            uVar.b(mb.getSavePath());
            try {
                uVar.mb(new JSONObject(mb.getDownloadSettingString()));
                return 0;
            } catch (Throwable th) {
                return 0;
            }
        }
        if (mb == null && AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.hj.x().mb(str3, uVar.je()))) {
            int mb2 = com.ss.android.socialbase.appdownloader.ox.mb(obtain);
            i = mb2;
            if (mb2 == 0) {
                uVar.b(str6);
                return mb2;
            }
        } else if (mb != null) {
            return 8;
        } else {
            i = 9;
        }
        return i;
    }

    private static com.ss.android.downloadad.api.mb.ox mb(com.ss.android.downloadlib.addownload.model.h hVar, int i) {
        com.ss.android.downloadad.api.mb.ox oxVar = new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj, i);
        boolean z = true;
        if (DownloadSetting.obtain(i).optInt("download_event_opt", 1) > 1) {
            try {
                String packageName = hVar.ox.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (x.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    oxVar.ww(z);
                }
            } catch (Throwable th) {
                return oxVar;
            }
        }
        return oxVar;
    }

    public static String mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (TextUtils.isEmpty(extra)) {
                return null;
            }
            return new JSONObject(extra).optString("notification_jump_url", null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean mb(int i) {
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static boolean mb(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean mb(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean mb(com.ss.android.socialbase.appdownloader.u r7, com.ss.android.socialbase.downloader.setting.DownloadSetting r8, int r9) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ww.mb(com.ss.android.socialbase.appdownloader.u, com.ss.android.socialbase.downloader.setting.DownloadSetting, int):boolean");
    }

    public static boolean ox(int i) {
        boolean z = true;
        if (i != 2) {
            if (i == 1) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public static boolean ox(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }
}
