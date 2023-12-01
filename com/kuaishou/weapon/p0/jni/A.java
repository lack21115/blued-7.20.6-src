package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.Cdo;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/jni/A.class */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public A(Context context, int i) {
        flag = i;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            Cdo a2 = Cdo.a();
            if (a2 != null) {
                return a2.a(str, "");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            Cdo a2 = Cdo.a();
            if (a2 != null) {
                a2.b(str, str2);
            }
        } catch (Exception e) {
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }
}
