package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.expressad.foundation.d.c;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.ko;
import com.ss.android.downloadlib.utils.Chain;
import com.ss.android.downloadlib.utils.jb;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/ox.class */
public class ox {
    private SoftReference<Activity> mb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/ox$mb.class */
    public static class mb {
        private static ox mb = new ox();
    }

    private ox() {
    }

    public static ox mb() {
        return mb.mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mb(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.model.ox oxVar = new com.ss.android.downloadlib.addownload.model.ox();
                oxVar.mb = j;
                oxVar.ox = j2;
                oxVar.hj = optJSONObject.optString(c.H);
                oxVar.h = optJSONObject.optString("app_name");
                oxVar.b = optJSONObject.optString("package_name");
                oxVar.u = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                oxVar.ko = optJSONObject.optString("developer_name");
                oxVar.lz = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                        oxVar.ww.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                        i = i2 + 1;
                    }
                }
                b.mb().mb(oxVar);
                hj.mb().mb(oxVar.mb(), j2, oxVar.hj);
                return true;
            }
            h.mb(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.exception.b.mb().mb(e, "AdLpComplianceManager parseResponse");
            h.mb(7, j2);
            return false;
        }
    }

    public void mb(long j) {
        TTDelegateActivity.mb(j);
    }

    public void mb(Activity activity) {
        this.mb = new SoftReference<>(activity);
    }

    public boolean mb(DownloadModel downloadModel) {
        if (downloadModel.isAd() && x.lz().optInt("ad_lp_show_app_dialog") != 0) {
            String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
            return (TextUtils.isEmpty(webUrl) || Pattern.compile(x.lz().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
        }
        return false;
    }

    public boolean mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        long j;
        if (TextUtils.isEmpty(hVar.ox.getLogExtra())) {
            h.mb(9, hVar);
            com.ss.android.downloadlib.exception.b.mb().mb("requestAppInfo getLogExtra null");
            j = 0;
        } else {
            try {
                j = jb.mb(new JSONObject(hVar.ox.getLogExtra()), "convert_id");
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                h.mb(3, hVar);
            }
        }
        final long j2 = hVar.mb;
        com.ss.android.downloadlib.addownload.model.ox mb2 = b.mb().mb(j, j2);
        if (mb2 != null) {
            hj.mb().mb(mb2.mb(), j2, mb2.hj);
            mb(mb2.mb());
            h.mb(EventConstants.Label.LP_APP_DIALOG_TRY_SHOW, hVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=");
            sb.append(j);
        }
        if (!TextUtils.isEmpty(hVar.ox.getPackageName())) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append("package_name=");
            sb.append(hVar.ox.getPackageName());
        }
        if (sb.length() <= 0) {
            h.mb(6, hVar);
            return false;
        }
        final long j3 = j;
        final long j4 = j;
        Chain.mb((Chain.mb<String, R>) new Chain.mb<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.2
            @Override // com.ss.android.downloadlib.utils.Chain.mb
            public Boolean mb(String str) {
                final boolean[] zArr = {false};
                x.hj().mb("GET", str, new HashMap(), new l() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.2.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        zArr[0] = ox.this.mb(j3, j2, str2);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        h.mb(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).mb(new Chain.mb<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.ox.1
            @Override // com.ss.android.downloadlib.utils.Chain.mb
            public Object mb(Boolean bool) {
                if (!bool.booleanValue()) {
                    ox.this.ox(j2);
                    return null;
                }
                ox.this.mb(com.ss.android.downloadlib.addownload.model.ox.mb(j4, j2));
                h.ox(EventConstants.Label.LP_APP_DIALOG_TRY_SHOW, j2);
                return null;
            }
        }).mb();
        return true;
    }

    public Activity ox() {
        Activity activity = this.mb.get();
        this.mb = null;
        return activity;
    }

    public void ox(long j) {
        com.ss.android.downloadlib.addownload.h mb2 = ko.mb().mb(u.mb().h(j).ox.getDownloadUrl());
        if (mb2 != null) {
            mb2.mb(true, true);
            return;
        }
        h.mb(11, j);
        com.ss.android.downloadlib.exception.b.mb().ox("startDownload handler null");
    }
}
