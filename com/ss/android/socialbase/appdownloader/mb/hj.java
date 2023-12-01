package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/hj.class */
public class hj {
    public static mb mb(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        nk nkVar = null;
        if (downloadInfo != null) {
            nkVar = null;
            if (context != null) {
                if (jSONObject == null) {
                    return null;
                }
                String savePath = downloadInfo.getSavePath();
                nkVar = null;
                if (!TextUtils.isEmpty(savePath)) {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    File file = new File(savePath);
                    DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
                    if (str.equals(com.huawei.hms.ads.dynamicloader.b.f)) {
                        return new x(context, obtain, downloadInfo.getTargetFilePath());
                    }
                    if (str.equals(com.huawei.hms.ads.dynamicloader.b.g)) {
                        return new jb(context, obtain, file.getAbsolutePath());
                    }
                    if (str.equals(a.j)) {
                        return new je(context, obtain, file.getAbsolutePath());
                    }
                    if (str.equals("o1")) {
                        return new ko(context, obtain, file.getAbsolutePath());
                    }
                    if (str.equals("o2")) {
                        return new ww(context, obtain, file.getAbsolutePath());
                    }
                    if (str.equals("o3")) {
                        String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
                        nkVar = null;
                        if (!TextUtils.isEmpty(dBJsonString)) {
                            return new lz(context, obtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
                        }
                    } else if (str.equals("custom")) {
                        return new b(context, obtain, file.getAbsolutePath(), jSONObject);
                    } else {
                        nkVar = null;
                        if (str.equals("vbi")) {
                            nkVar = new nk(context, obtain, com.ss.android.socialbase.appdownloader.b.mb(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.hj.x().hj(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
                        }
                    }
                }
            }
        }
        return nkVar;
    }

    public static boolean mb(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        mb mbVar;
        boolean z = false;
        if (context != null) {
            if (str == null) {
                return false;
            }
            String ox = com.ss.android.socialbase.appdownloader.b.ox();
            z = false;
            if (!TextUtils.isEmpty(ox)) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals(com.huawei.hms.ads.dynamicloader.b.f)) {
                    mbVar = new x(context, downloadSetting, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals(com.huawei.hms.ads.dynamicloader.b.g)) {
                    mbVar = new jb(context, downloadSetting, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals(a.j)) {
                    mbVar = new je(context, downloadSetting, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o1")) {
                    mbVar = new ko(context, downloadSetting, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o2")) {
                    mbVar = new ww(context, downloadSetting, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o3")) {
                    mbVar = new lz(context, downloadSetting, ox, ox, ox);
                } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals("custom")) {
                    mbVar = new b(context, downloadSetting, ox, jSONObject);
                } else {
                    mbVar = null;
                    if (com.ss.android.socialbase.appdownloader.u.hj.b()) {
                        mbVar = null;
                        if (str.equals("vbi")) {
                            mbVar = new nk(context, downloadSetting, ox);
                        }
                    }
                }
                z = false;
                if (mbVar != null) {
                    z = false;
                    if (mbVar.mb()) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }
}
