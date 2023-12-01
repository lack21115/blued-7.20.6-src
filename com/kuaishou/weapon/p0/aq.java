package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/aq.class */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f23728a;

    public aq(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f23783c).intValue(), 3, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f23728a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f23728a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Set b(String str) {
        JSONObject jSONObject = this.f23728a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(str, null);
            if (TextUtils.isEmpty(optString) || optString.length() <= 3) {
                return null;
            }
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = new JSONArray(optString);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return hashSet;
                }
                hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i2), 16).intValue()));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
