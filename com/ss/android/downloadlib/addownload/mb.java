package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb.class */
public class mb implements je.mb {
    private static final String mb = mb.class.getSimpleName();
    private static mb ox;
    private com.ss.android.downloadlib.utils.je b = new com.ss.android.downloadlib.utils.je(Looper.getMainLooper(), this);
    private long hj;

    private mb() {
    }

    public static mb mb() {
        if (ox == null) {
            synchronized (mb.class) {
                try {
                    if (ox == null) {
                        ox = new mb();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    private void mb(com.ss.android.downloadlib.addownload.model.mb mbVar, int i) {
        if (x.jb() == null || x.jb().mb() || mbVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(mbVar.ox);
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                jSONObject.put(EventConstants.ExtraJson.KEY_TYPE, "miui_silent_install");
                if (com.ss.android.downloadlib.utils.jb.hj(x.getContext(), mbVar.hj)) {
                    jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception e) {
            }
            x.u().mb(null, new BaseException(i2, jSONObject.toString()), i2);
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, hj);
        }
        if (com.ss.android.downloadlib.utils.jb.hj(x.getContext(), mbVar.hj)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALLED, mbVar.ox);
        } else if (!com.ss.android.downloadlib.utils.jb.mb(mbVar.ko)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_LOST, mbVar.ox);
        } else if (com.ss.android.downloadlib.addownload.mb.mb.mb().mb(mbVar.hj)) {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_CONFLICT, mbVar.ox);
        } else {
            AdEventHandler.mb().mb(EventConstants.Label.DELAY_INSTALL_START, mbVar.ox);
            com.ss.android.socialbase.appdownloader.hj.mb(x.getContext(), (int) mbVar.mb);
        }
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
        if (message.what != 200) {
            return;
        }
        mb((com.ss.android.downloadlib.addownload.model.mb) message.obj, message.arg1);
    }

    public void mb(DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        DownloadSetting obtain;
        com.ss.android.downloadlib.addownload.model.mb mbVar = new com.ss.android.downloadlib.addownload.model.mb(downloadInfo.getId(), j, j2, str, str2, str3, str4);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.u.hj.je() || com.ss.android.socialbase.appdownloader.u.hj.nk()) && SystemUtils.checkServiceExists(x.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (DownloadUtils.getBoolean(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                Message obtainMessage = this.b.obtainMessage(200, mbVar);
                obtainMessage.arg1 = 2;
                this.b.sendMessageDelayed(obtainMessage, obtain.optInt("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(mbVar.ox);
            JSONObject jSONObject = new JSONObject();
            int i = -1;
            try {
                jSONObject.put(EventConstants.ExtraJson.KEY_TYPE, "miui_silent_install");
                jSONObject.put(EventConstants.ExtraJson.KEY_MESSAGE, "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception e) {
            }
            x.u().mb(null, new BaseException(i, jSONObject.toString()), i);
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.ANTI_HIJACK_RESULT, jSONObject, hj);
        }
        if (com.ss.android.downloadlib.utils.hj.b()) {
            long currentTimeMillis = System.currentTimeMillis() - this.hj;
            long hj2 = com.ss.android.downloadlib.utils.hj.hj();
            if (currentTimeMillis < com.ss.android.downloadlib.utils.hj.h()) {
                long h = com.ss.android.downloadlib.utils.hj.h() - currentTimeMillis;
                hj2 += h;
                this.hj = System.currentTimeMillis() + h;
            } else {
                this.hj = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.utils.je jeVar = this.b;
            jeVar.sendMessageDelayed(jeVar.obtainMessage(200, mbVar), hj2);
        }
    }
}
