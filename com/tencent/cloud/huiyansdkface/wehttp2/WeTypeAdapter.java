package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.lang.reflect.Type;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeTypeAdapter.class */
public class WeTypeAdapter extends TypeAdaptor2 {

    /* renamed from: a  reason: collision with root package name */
    private WeJson f36136a = new WeJson();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdaptor2
    public <T> T a(String str, Type type) throws WeJsonException {
        return (T) this.f36136a.fromJson(str, type);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdapter
    public <T> String to(T t) {
        return this.f36136a.toJson(t);
    }
}
