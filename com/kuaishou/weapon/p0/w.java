package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private Context f23871a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private h f23872c;

    public w(Context context) {
        this.b = 0;
        this.f23871a = context;
        h a2 = h.a(context, "re_po_rt");
        this.f23872c = a2;
        if (a2 != null) {
            this.b = a2.b(de.p, 0);
        }
    }

    public JSONArray a(int i) {
        try {
            new A(this.f23871a, i);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject == null) {
                return null;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jsonObject.length()) {
                    A.setJsonObject(null);
                    return jSONArray;
                }
                jSONArray.put(jsonObject.get(i3));
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONArray b(int i) {
        try {
            return c(i);
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONArray c(int i) {
        return d(i);
    }

    public JSONArray d(int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f23871a.getPackageManager();
            int i2 = 1000;
            while (true) {
                int i3 = i2;
                if (i3 > 19999) {
                    return jSONArray;
                }
                String[] strArr = null;
                try {
                    strArr = packageManager.getPackagesForUid(i3);
                } catch (Exception e) {
                }
                if (strArr != null) {
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < length) {
                            try {
                                PackageInfo packageInfo = packageManager.getPackageInfo(strArr[i5], 0);
                                if (i != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                    v vVar = new v(packageInfo, this.f23871a);
                                    vVar.h();
                                    jSONArray.put(vVar.k());
                                }
                            } catch (Exception e2) {
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
                i2 = i3 + 1;
            }
        } catch (Exception e3) {
            return jSONArray;
        }
    }
}
