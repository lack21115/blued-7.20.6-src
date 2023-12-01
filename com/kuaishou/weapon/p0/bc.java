package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bc.class */
public class bc extends df {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f23743a;

    public bc(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f23783c).intValue(), 5, 5, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f23743a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f23743a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() <= 0) {
                    return null;
                }
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!a(set, str)) {
                        hashSet.add(str);
                    }
                }
                return hashSet;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a() {
        return this.f23743a;
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
