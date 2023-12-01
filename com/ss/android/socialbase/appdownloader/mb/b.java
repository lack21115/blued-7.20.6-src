package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/b.class */
public class b extends mb {
    private final JSONObject hj;

    public b(Context context, DownloadSetting downloadSetting, String str, JSONObject jSONObject) {
        super(context, downloadSetting, str);
        this.hj = jSONObject;
    }

    private static void mb(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                mb(jSONObject, next, optString, intent);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void mb(JSONObject jSONObject, String str, String str2, Intent intent) {
        boolean z;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -891985903:
                if (str2.equals("string")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 104431:
                if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 3327612:
                if (str2.equals("long")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 64711720:
                if (str2.equals(TypedValues.Custom.S_BOOLEAN)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            intent.putExtra(str, jSONObject.optInt(str));
        } else if (z) {
            intent.putExtra(str, jSONObject.optBoolean(str));
        } else if (z) {
            intent.putExtra(str, jSONObject.optLong(str));
        } else if (z) {
            intent.putExtra(str, jSONObject.optDouble(str));
        } else if (!z) {
        } else {
            intent.putExtra(str, jSONObject.optString(str));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String optString = this.hj.optString("action");
        String optString2 = this.hj.optString("category");
        int optInt = this.hj.optInt("flags", 1342210048);
        String optString3 = this.hj.optString("path_extra_key");
        String optString4 = this.hj.optString("path_data_key");
        JSONObject optJSONObject = this.hj.optJSONObject("extra");
        JSONObject optJSONObject2 = this.hj.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.b)));
            } catch (Throwable th) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.b);
        }
        mb(intent, optJSONObject, optJSONObject2);
        return intent;
    }
}
