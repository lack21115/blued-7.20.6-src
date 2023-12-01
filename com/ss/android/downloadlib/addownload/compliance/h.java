package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/h.class */
public class h {
    public static void mb(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.LP_COMPLIANCE_ERROR, jSONObject, u.mb().h(j));
    }

    public static void mb(int i, com.ss.android.downloadlib.addownload.model.h hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.LP_COMPLIANCE_ERROR, jSONObject, hVar);
    }

    public static void mb(String str, long j) {
        com.ss.android.downloadlib.addownload.model.h h = u.mb().h(j);
        if (h.on()) {
            return;
        }
        h.b.setRefer(str);
        AdEventHandler.mb().ox(EventConstants.Label.LP_APP_DIALOG_CLICK, h);
    }

    public static void mb(String str, com.ss.android.downloadlib.addownload.model.h hVar) {
        AdEventHandler.mb().ox(str, hVar);
    }

    public static void mb(String str, JSONObject jSONObject, long j) {
        AdEventHandler.mb().ox(str, jSONObject, u.mb().h(j));
    }

    public static void ox(String str, long j) {
        mb(str, null, j);
    }
}
