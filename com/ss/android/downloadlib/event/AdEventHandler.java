package com.ss.android.downloadlib.event;

import android.os.Build;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ox;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.model.ww;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.utils.h;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.u.hj;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/event/AdEventHandler.class */
public class AdEventHandler {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/event/AdEventHandler$EventType.class */
    public @interface EventType {
        public static final int CLICK_CONTINUE = 4;
        public static final int CLICK_INSTALL = 5;
        public static final int CLICK_PAUSE = 3;
        public static final int CLICK_START = 2;
        public static final int STORAGE_DENY = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/event/AdEventHandler$mb.class */
    public static class mb {
        private static AdEventHandler mb = new AdEventHandler();
    }

    private AdEventHandler() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String AdEventHandler1672829046082dc(java.lang.String r5) {
        /*
        L0:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L0;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L85;
                case 95: goto L5f;
                case 96: goto L5f;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L85;
                case 56: goto L85;
                case 57: goto L5f;
                default: goto L5c;
            }
        L5c:
            goto L85
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
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.event.AdEventHandler.AdEventHandler1672829046082dc(java.lang.String):java.lang.String");
    }

    public static AdEventHandler mb() {
        return mb.mb;
    }

    private JSONObject mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jb.mb(mbVar.ko(), jSONObject);
            jb.mb(mbVar.io(), jSONObject);
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_URL, mbVar.mb());
            jSONObject.putOpt("package_name", mbVar.h());
            jSONObject.putOpt(EventConstants.ExtraJson.ANDROID_INT, Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt(EventConstants.ExtraJson.ROM_NAME, hj.ko());
            jSONObject.putOpt(EventConstants.ExtraJson.ROM_VERSION, hj.ww());
            jSONObject.putOpt(EventConstants.ExtraJson.TTDOWNLOADER, 1);
            jSONObject.putOpt(EventConstants.ExtraJson.FUNNEL_TYPE, Integer.valueOf(mbVar.ww()));
            if (mbVar.ww() == 2) {
                h.ox(jSONObject, mbVar);
                return jSONObject;
            }
        } catch (Exception e) {
            x.m().mb(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void mb(com.ss.android.download.api.model.ox oxVar) {
        if (x.mb() == null) {
            return;
        }
        if (oxVar.nk()) {
            x.mb().mb(oxVar);
        } else {
            x.mb().ox(oxVar);
        }
    }

    private void mb(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.mb.mb mbVar) {
        b mb2;
        String str3;
        if (mbVar == null) {
            mb2 = b.mb();
            str3 = "onEvent data null";
        } else if (!(mbVar instanceof com.ss.android.downloadlib.addownload.model.h) || !((com.ss.android.downloadlib.addownload.model.h) mbVar).on()) {
            try {
                ox.mb b = new ox.mb().mb(jb.mb(str, mbVar.x(), EventConstants.Tag.EMBEDED_AD)).ox(str2).ox(mbVar.b()).mb(mbVar.ox()).b(mbVar.hj());
                if (j <= 0) {
                    j = mbVar.je();
                }
                ox.mb mb3 = b.ox(j).hj(mbVar.lz()).mb(mbVar.o()).mb(jb.mb(mb(mbVar), jSONObject)).ox(mbVar.jb()).mb(mbVar.lc());
                if (i <= 0) {
                    i = 2;
                }
                mb(mb3.mb(i).mb(mbVar.nk()).mb());
                return;
            } catch (Exception e) {
                b.mb().mb(e, "onEvent");
                return;
            }
        } else {
            mb2 = b.mb();
            str3 = "onEvent ModelBox notValid";
        }
        mb2.mb(str3);
    }

    public void mb(long j, int i) {
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        if (h.on()) {
            b.mb().mb("sendClickEvent ModelBox notValid");
        } else if (h.b.isEnableClickEvent()) {
            DownloadEventConfig downloadEventConfig = h.b;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String mb2 = jb.mb(h.b.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.CLICK_TYPE, Integer.valueOf(i));
                jSONObject.putOpt(EventConstants.ExtraJson.PERMISSION_NOTIFICATION, Integer.valueOf(com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2));
                jSONObject.putOpt(EventConstants.ExtraJson.NETWORK_AVAILABLE, Integer.valueOf(DownloadUtils.isNetworkConnected(x.getContext()) ? 1 : 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mb(clickItemTag, mb2, jSONObject, h);
            if (!"click".equals(mb2) || h.ox == null) {
                return;
            }
            ox.mb().mb(j, h.ox.getLogExtra());
        }
    }

    public void mb(long j, int i, DownloadInfo downloadInfo) {
        String mb2;
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        if (h.on()) {
            b.mb().mb("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(h.gm()));
        if (i == 1) {
            mb2 = jb.mb(h.b.getStorageDenyLabel(), EventConstants.Label.STORAGE_DENY);
        } else if (i == 2) {
            String mb3 = jb.mb(h.b.getClickStartLabel(), EventConstants.Label.CLICK_START);
            h.mb(downloadInfo, jSONObject);
            mb2 = mb3;
        } else if (i == 3) {
            String mb4 = jb.mb(h.b.getClickPauseLabel(), EventConstants.Label.CLICK_PAUSE);
            h.ox(downloadInfo, jSONObject);
            mb2 = mb4;
        } else if (i == 4) {
            String mb5 = jb.mb(h.b.getClickContinueLabel(), EventConstants.Label.CLICK_CONTINUE);
            h.b(downloadInfo, jSONObject);
            mb2 = mb5;
        } else if (i != 5) {
            mb2 = null;
        } else {
            if (downloadInfo != null) {
                try {
                    h.mb(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.mb.ox(jSONObject, downloadInfo);
                } catch (Throwable th) {
                }
            }
            mb2 = jb.mb(h.b.getClickInstallLabel(), EventConstants.Label.CLICK_INSTALL);
        }
        mb(null, mb2, jSONObject, 0L, 1, h);
    }

    public void mb(long j, BaseException baseException) {
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, baseException.getErrorMessage());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ox(EventConstants.Label.DOWNLOAD_FAILED, jSONObject, h);
    }

    public void mb(long j, boolean z, int i) {
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        if (h.on()) {
            b.mb().mb("sendQuickAppEvent ModelBox notValid");
        } else if (h.ox.getQuickAppModel() == null) {
        } else {
            if (h.ox instanceof AdDownloadModel) {
                ((AdDownloadModel) h.ox).setFunnelType(3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.CLICK_TYPE, Integer.valueOf(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ox(z ? EventConstants.Label.DEEPLINK_QUICKAPP_SUCCESS : EventConstants.Label.DEEPLINK_QUICKAPP_FAILED, jSONObject, h);
        }
    }

    public void mb(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.mb.ox mb2 = u.mb().mb(downloadInfo);
        if (mb2 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            h.b(downloadInfo, jSONObject);
            mb2.mb(System.currentTimeMillis());
            mb(mb2.x(), EventConstants.Label.DOWNLOAD_RESUME, jSONObject, mb2);
            ww.mb().mb(mb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void mb(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.mb.ox mb2;
        if (downloadInfo == null || (mb2 = u.mb().mb(downloadInfo)) == null || mb2.b.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.mb.mb(jSONObject, downloadInfo);
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(mb2.fu()));
            jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, mb2.ep());
            jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, mb2.on());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (mb2.wn() > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_START_DOWNLOAD, currentTimeMillis - mb2.wn());
            }
            if (mb2.ge() > 0) {
                jSONObject.put(EventConstants.ExtraJson.KEY_TIME_FROM_DOWNLOAD_RESUME, currentTimeMillis - mb2.ge());
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, mb2.qa() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_CAN_SHOW_NOTIFICATION, com.ss.android.socialbase.appdownloader.h.hj.mb() ? 1 : 2);
            jSONObject.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, mb2.hj.get() ? 1 : 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mb(mb2.x(), EventConstants.Label.DOWNLOAD_CANCEL, jSONObject, mb2);
    }

    public void mb(String str, int i, com.ss.android.downloadlib.addownload.model.h hVar) {
        mb(null, str, null, i, 0, hVar);
    }

    public void mb(String str, long j) {
        com.ss.android.downloadad.api.mb.ox hj = u.mb().hj(j);
        if (hj != null) {
            ox(str, hj);
        } else {
            ox(str, u.mb().h(j));
        }
    }

    public void mb(String str, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ox(str, new com.ss.android.downloadlib.addownload.model.h(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, (JSONObject) null, mbVar);
    }

    public void mb(String str, String str2, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, str2, (JSONObject) null, mbVar);
    }

    public void mb(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(str, str2, jSONObject, 0L, 0, mbVar);
    }

    public void mb(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.mb.mb hj = u.mb().hj(j);
        if (hj != null) {
            mb(str, jSONObject, hj);
            return;
        }
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        if (h.on()) {
            b.mb().mb("sendUnityEvent ModelBox notValid");
        } else {
            mb(str, jSONObject, h);
        }
    }

    public void mb(String str, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        JSONObject jSONObject2 = new JSONObject();
        jb.mb(jSONObject2, EventConstants.ExtraJson.UNITY_LABEL, str);
        mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.UNITY, jb.mb(jSONObject, jSONObject2), mbVar);
    }

    public void mb(JSONObject jSONObject, com.ss.android.downloadad.api.mb.ox oxVar) {
        mb(oxVar.x(), EventConstants.Label.INSTALL_FINISH, jSONObject, oxVar);
    }

    public void ox(long j, int i) {
        mb(j, i, (DownloadInfo) null);
    }

    public void ox(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.mb.ox mb2 = u.mb().mb(downloadInfo);
        if (mb2 == null) {
            b.mb().mb("sendDownloadFailedEvent nativeModel null");
        } else if (mb2.b.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                h.b(downloadInfo, jSONObject);
                com.ss.android.downloadlib.mb.mb(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt(EventConstants.ExtraJson.FAIL_STATUS, Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt(EventConstants.ExtraJson.FAIL_MSG, baseException.getErrorMessage());
                    mb2.hj(baseException.getErrorCode());
                    mb2.mb(baseException.getErrorMessage());
                }
                mb2.jq();
                jSONObject.put(EventConstants.ExtraJson.KEY_DOWNLOAD_FAILED_TIMES, mb2.on());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put(EventConstants.ExtraJson.KEY_HAS_SEND_DOWNLOAD_FAILED_FINALLY, mb2.hj.get() ? 1 : 2);
                h.mb(mb2, jSONObject);
                jSONObject.put(EventConstants.ExtraJson.KEY_IS_UPDATE_DOWNLOAD, mb2.qa() ? 1 : 2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mb(mb2.x(), EventConstants.Label.DOWNLOAD_FAILED, jSONObject, mb2);
            ww.mb().mb(mb2);
        }
    }

    public void ox(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb((String) null, str, mbVar);
    }

    public void ox(String str, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        mb((String) null, str, jSONObject, mbVar);
    }
}
