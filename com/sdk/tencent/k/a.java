package com.sdk.tencent.k;

import com.sdk.tencent.base.framework.bean.KInfo;
import com.sdk.tencent.f.c;
import com.sdk.tencent.n.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/k/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28059a = "com.sdk.tencent.k.a";
    public static final boolean b = c.b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    public static String a(Object obj) {
        try {
            Field[] declaredFields = Class.forName(obj.getClass().getName()).getDeclaredFields();
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= declaredFields.length) {
                    return jSONObject.toString();
                }
                Field field = declaredFields[i2];
                field.setAccessible(true);
                String name = field.getName();
                if (!"serialVersionUID".equals(name)) {
                    Object obj2 = field.get(obj);
                    JSONArray jSONArray = obj2;
                    if (field.getType().equals(ArrayList.class)) {
                        jSONArray = new JSONArray();
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= arrayList.size()) {
                                    break;
                                }
                                Object obj3 = arrayList.get(i4);
                                Class<?> cls = obj3.getClass();
                                if (cls.equals(KInfo.class)) {
                                    Field[] declaredFields2 = cls.getDeclaredFields();
                                    JSONObject jSONObject2 = new JSONObject();
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5;
                                        if (i6 >= declaredFields2.length) {
                                            break;
                                        }
                                        Field field2 = declaredFields2[i6];
                                        field2.setAccessible(true);
                                        jSONObject2.put(field2.getName(), field2.get(obj3));
                                        i5 = i6 + 1;
                                    }
                                    jSONArray.put(jSONObject2);
                                } else {
                                    jSONArray.put(obj3);
                                }
                                i3 = i4 + 1;
                            }
                        }
                    }
                    jSONObject.put(name, (Object) jSONArray);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            b.a(f28059a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
