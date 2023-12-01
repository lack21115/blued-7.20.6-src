package com.ss.android.downloadlib.ox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox/mb.class */
public class mb {
    public static void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        String u = oxVar.u();
        JSONObject mb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), oxVar);
        jb.mb(mb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.NOTIFY_CLICK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, mb, oxVar);
        OpenAppResult mb2 = com.ss.android.downloadlib.utils.ww.mb(u, oxVar);
        OpenAppResult openAppResult = mb2;
        if (mb2.getType() == 2) {
            if (!TextUtils.isEmpty(u)) {
                ox(EventConstants.AppLinkSource.NOTIFY_BY_URL, mb2, mb, oxVar);
            }
            openAppResult = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), oxVar.h(), oxVar);
        }
        int type = openAppResult.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.NOTIFY_BY_URL, mb, oxVar);
        } else if (type == 3) {
            mb(EventConstants.AppLinkSource.NOTIFY_BY_PACKAGE, mb, oxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClickNotification default");
        } else {
            mb(EventConstants.AppLinkSource.NOTIFY_BY_PACKAGE, openAppResult, mb, oxVar);
        }
    }

    public static void mb(OpenAppResult openAppResult, com.ss.android.downloadlib.addownload.model.h hVar, boolean z) {
        String mb = jb.mb(openAppResult.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, Context.BACKUP_SERVICE);
        int type = openAppResult.getType();
        if (type == 5) {
            mb(mb, jSONObject, hVar, z);
        } else if (type != 6) {
        } else {
            jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
            jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
        }
    }

    public static void mb(String str, OpenAppResult openAppResult, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_APP_OPEN_FAIL, jSONObject, mbVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void mb(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.mb.mb mbVar) {
        boolean z;
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_APP_OPEN, jSONObject, mbVar);
        switch (str.hashCode()) {
            case -1282070764:
                if (str.equals(EventConstants.AppLinkSource.NOTIFY_BY_PACKAGE)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -441514770:
                if (str.equals(EventConstants.AppLinkSource.AUTO_BY_PACKAGE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -185950114:
                if (str.equals(EventConstants.AppLinkSource.BY_PACKAGE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 368401333:
                if (str.equals(EventConstants.AppLinkSource.DIALOG_BY_PACKAGE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z || z || z) {
            if ((com.ss.android.downloadlib.addownload.x.lz().optInt("check_applink_mode") & 1) == 0) {
                com.ss.android.downloadlib.addownload.x.ox().mb(com.ss.android.downloadlib.addownload.x.getContext(), mbVar.g(), mbVar.r(), mbVar.df(), mbVar.h(), str);
                return;
            }
            jb.mb(jSONObject, EventConstants.ExtraJson.CHECK_APPLINK_RESULT_BY_SDK, (Object) 1);
            h.mb().mb(new hj() { // from class: com.ss.android.downloadlib.ox.mb.1
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z2) {
                    AdEventHandler.mb().ox(z2 ? EventConstants.Label.DEEPLINK_SUCCESS : EventConstants.Label.DEEPLINK_FAILED, JSONObject.this, mbVar);
                    if (z2) {
                        com.ss.android.downloadlib.addownload.x.gm().mb(com.ss.android.downloadlib.addownload.x.getContext(), mbVar.g(), mbVar.r(), mbVar.df(), mbVar.h(), 0);
                    }
                }
            });
        }
    }

    public static void mb(final String str, JSONObject jSONObject, final com.ss.android.downloadlib.addownload.model.h hVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.exception.b.mb().mb(e, "onMarketSuccess");
                return;
            }
        }
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
        if (z) {
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_SUCCESS, jSONObject, hVar);
        }
        if ((com.ss.android.downloadlib.addownload.x.lz().optInt("check_applink_mode") & 4) != 0) {
            final JSONObject jSONObject2 = jSONObject;
            h.mb().ox(new hj() { // from class: com.ss.android.downloadlib.ox.mb.3
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z2) {
                    if (!z2 && !EventConstants.AppLinkSource.OPEN_MARKET.equals(String.this)) {
                        Context context = com.ss.android.downloadlib.addownload.x.getContext();
                        mb.mb(com.ss.android.downloadlib.utils.ww.mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + hVar.h())), hVar, false);
                    }
                    AdEventHandler.mb().mb(z2 ? EventConstants.UnityLabel.MARKET_DELAY_SUCCESS : EventConstants.UnityLabel.MARKET_DELAY_FAILED, jSONObject2, hVar);
                    if (z2) {
                        com.ss.android.downloadlib.addownload.x.gm().mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar.ox, hVar.hj, hVar.b, hVar.ox.getPackageName(), 2);
                    }
                }
            });
        } else {
            com.ss.android.downloadlib.addownload.x.ox().mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar.ox, hVar.hj, hVar.b, hVar.ox.getPackageName(), str);
        }
        com.ss.android.downloadad.api.mb.ox oxVar = new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj);
        oxVar.h(2);
        oxVar.u(System.currentTimeMillis());
        oxVar.ww(4);
        oxVar.lz(2);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVar);
    }

    public static boolean mb(long j) {
        return com.ss.android.downloadlib.addownload.model.u.mb().hj(j) == null;
    }

    public static boolean mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        boolean z;
        DeepLink deepLink = hVar.ox.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject mb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), hVar);
        jb.mb(mb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.CLICK_BY_SDK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, mb, hVar);
        OpenAppResult mb2 = com.ss.android.downloadlib.utils.ww.mb(openUrl, hVar);
        OpenAppResult openAppResult = mb2;
        if (mb2.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                ox(EventConstants.AppLinkSource.BY_URL, mb2, mb, hVar);
            }
            openAppResult = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar.ox.getPackageName(), hVar);
        }
        boolean z2 = false;
        if (mb(hVar.mb) && com.ss.android.downloadlib.addownload.x.lz().optInt("link_ad_click_event") == 1) {
            if (hVar.ox instanceof AdDownloadModel) {
                ((AdDownloadModel) hVar.ox).setFunnelType(4);
            }
            AdEventHandler.mb().mb(hVar.mb, 0);
            z = true;
        } else {
            z = false;
        }
        int type = openAppResult.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.BY_URL, mb, hVar);
        } else if (type != 3) {
            if (type != 4) {
                com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClick default");
            } else {
                mb(EventConstants.AppLinkSource.BY_PACKAGE, openAppResult, mb, hVar);
            }
            if (z2 && !z && ((com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(hVar.mb, hVar.ox.getLogExtra())) || com.ss.android.downloadlib.event.ox.mb().b())) {
                AdEventHandler.mb().mb(hVar.mb, 2);
            }
            return z2;
        } else {
            mb(EventConstants.AppLinkSource.BY_PACKAGE, mb, hVar);
        }
        z2 = true;
        if (z2) {
            AdEventHandler.mb().mb(hVar.mb, 2);
        }
        return z2;
    }

    public static boolean mb(com.ss.android.downloadlib.addownload.model.h hVar, int i) {
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.MARKET_CLICK_OPEN, jSONObject, hVar);
        OpenAppResult mb = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), hVar, hVar.ox.getPackageName());
        String mb2 = jb.mb(mb.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
        int type = mb.getType();
        if (type == 5) {
            mb(mb2, jSONObject, hVar, true);
        } else if (type == 6) {
            jb.mb(jSONObject, "error_code", Integer.valueOf(mb.mb()));
            jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(hVar.gm()));
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
            return false;
        } else if (type != 7) {
            return false;
        }
        AdEventHandler.mb().mb(hVar.mb, i);
        return true;
    }

    public static boolean mb(String str, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (com.ss.android.downloadlib.addownload.ww.ox(oxVar.yr())) {
            if (TextUtils.isEmpty(oxVar.u()) && TextUtils.isEmpty(str)) {
                return false;
            }
            DownloadNotificationManager.getInstance().cancelNotification(oxVar.m());
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.utils.h.mb(jSONObject, oxVar);
            jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.AUTO_CLICK);
            AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, oxVar);
            OpenAppResult mb = com.ss.android.downloadlib.utils.ww.mb(oxVar, oxVar.u(), oxVar.h());
            int type = mb.getType();
            if (type == 1) {
                ox(EventConstants.AppLinkSource.AUTO_BY_URL, jSONObject, oxVar);
                return true;
            } else if (type == 2) {
                ox(EventConstants.AppLinkSource.AUTO_BY_URL, mb, jSONObject, oxVar);
                return false;
            } else if (type == 3) {
                mb(EventConstants.AppLinkSource.AUTO_BY_PACKAGE, jSONObject, oxVar);
                return true;
            } else if (type != 4) {
                return false;
            } else {
                mb(EventConstants.AppLinkSource.AUTO_BY_PACKAGE, mb, jSONObject, oxVar);
                return false;
            }
        }
        return false;
    }

    public static void ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        String str = null;
        if (DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1) {
            str = oxVar.u();
        }
        JSONObject mb = com.ss.android.downloadlib.utils.h.mb(new JSONObject(), oxVar);
        jb.mb(mb, EventConstants.ExtraJson.APPLINK_SOURCE, EventConstants.AppLinkSource.DIALOG_CLICK);
        AdEventHandler.mb().ox(EventConstants.Label.APPLINK_CLICK, mb, oxVar);
        OpenAppResult mb2 = com.ss.android.downloadlib.utils.ww.mb(str, oxVar);
        OpenAppResult openAppResult = mb2;
        if (mb2.getType() == 2) {
            if (!TextUtils.isEmpty(str)) {
                ox(EventConstants.AppLinkSource.DIALOG_BY_URL, mb2, mb, oxVar);
            }
            openAppResult = com.ss.android.downloadlib.utils.ww.mb(com.ss.android.downloadlib.addownload.x.getContext(), oxVar.h(), oxVar);
        }
        int type = openAppResult.getType();
        if (type == 1) {
            ox(EventConstants.AppLinkSource.DIALOG_BY_URL, mb, oxVar);
        } else if (type == 3) {
            mb(EventConstants.AppLinkSource.DIALOG_BY_PACKAGE, mb, oxVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.exception.b.mb().ox("AppLinkClickDialog default");
        } else {
            mb(EventConstants.AppLinkSource.DIALOG_BY_PACKAGE, openAppResult, mb, oxVar);
        }
    }

    public static void ox(String str, OpenAppResult openAppResult, JSONObject jSONObject, com.ss.android.downloadad.api.mb.mb mbVar) {
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResult.mb()));
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_URL_OPEN_FAIL, jSONObject, mbVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void ox(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.mb.mb mbVar) {
        boolean z;
        jb.mb(jSONObject, EventConstants.ExtraJson.APPLINK_SOURCE, str);
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, Integer.valueOf(mbVar.gm()));
        AdEventHandler.mb().ox(EventConstants.Label.DEEPLINK_URL_OPEN, jSONObject, mbVar);
        switch (str.hashCode()) {
            case -1721882089:
                if (str.equals(EventConstants.AppLinkSource.AUTO_BY_URL)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1374618233:
                if (str.equals(EventConstants.AppLinkSource.BY_URL)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -129544387:
                if (str.equals(EventConstants.AppLinkSource.NOTIFY_BY_URL)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 829750366:
                if (str.equals(EventConstants.AppLinkSource.DIALOG_BY_URL)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z || z || z || z) {
            if ((com.ss.android.downloadlib.addownload.x.lz().optInt("check_applink_mode") & 1) == 0) {
                com.ss.android.downloadlib.addownload.x.ox().mb(com.ss.android.downloadlib.addownload.x.getContext(), mbVar.g(), mbVar.r(), mbVar.df(), mbVar.h(), str);
                return;
            }
            jb.mb(jSONObject, EventConstants.ExtraJson.CHECK_APPLINK_RESULT_BY_SDK, (Object) 1);
            h.mb().mb(new hj() { // from class: com.ss.android.downloadlib.ox.mb.2
                @Override // com.ss.android.downloadlib.ox.hj
                public void mb(boolean z2) {
                    AdEventHandler.mb().ox(z2 ? EventConstants.Label.DEEPLINK_SUCCESS : EventConstants.Label.DEEPLINK_FAILED, JSONObject.this, mbVar);
                    if (z2) {
                        com.ss.android.downloadlib.addownload.x.gm().mb(com.ss.android.downloadlib.addownload.x.getContext(), mbVar.g(), mbVar.r(), mbVar.df(), mbVar.h(), 0);
                    }
                }
            });
        }
    }
}
