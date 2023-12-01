package com.tencent.cloud.huiyansdkface.facelight.c;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f35582a;
    private static SharedPreferences.Editor b;

    public g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wb_face_config", 0);
        f35582a = sharedPreferences;
        b = sharedPreferences.edit();
    }

    public void a(String str, Object obj) {
        SharedPreferences.Editor editor;
        String str2;
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                b.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                b.putBoolean(str, ((Boolean) obj).booleanValue());
            } else {
                SharedPreferences.Editor editor2 = b;
                String obj2 = obj.toString();
                editor = editor2;
                str2 = obj2;
            }
            b.commit();
        }
        str2 = (String) obj;
        editor = b;
        editor.putString(str, str2);
        b.commit();
    }

    public Object b(String str, Object obj) {
        return obj instanceof String ? f35582a.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(f35582a.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(f35582a.getBoolean(str, ((Boolean) obj).booleanValue())) : f35582a.getString(str, null);
    }
}
