package com.ss.android.downloadlib.addownload.mb;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb/ox.class */
public class ox {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> mb(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = x.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.model.mb mb = com.ss.android.downloadlib.addownload.model.mb.mb(jSONObject.optJSONObject(keys.next()));
                    if (mb != null) {
                        copyOnWriteArrayList.add(mb);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.model.mb> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.model.mb next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.ox), next.mb());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        x.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ox(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        x.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }
}
