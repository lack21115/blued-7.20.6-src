package com.tencent.qimei.h;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/h/a.class */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public com.tencent.qimei.f.a<?>[] f24639a;

    public a(com.tencent.qimei.f.a<?>... aVarArr) {
        this.f24639a = aVarArr;
    }

    public abstract T a(com.tencent.qimei.f.a<T> aVar, String str);

    public String a(String str, com.tencent.qimei.f.a<?>... aVarArr) {
        if (str == null || str.isEmpty() || aVarArr.length < 1) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aVarArr.length || jSONObject == null) {
                    return "";
                }
                com.tencent.qimei.f.a<?> aVar = aVarArr[i2];
                if (aVar == aVarArr[aVarArr.length - 1]) {
                    return jSONObject.optString(aVar.b());
                }
                jSONObject = jSONObject.optJSONObject(aVar.b());
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public com.tencent.qimei.f.a<?>[] a(com.tencent.qimei.f.a<?> aVar) {
        com.tencent.qimei.f.a<?>[] aVarArr = this.f24639a;
        int length = aVarArr.length + 1;
        com.tencent.qimei.f.a<?>[] aVarArr2 = new com.tencent.qimei.f.a[length];
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        aVarArr2[length - 1] = aVar;
        return aVarArr2;
    }
}
