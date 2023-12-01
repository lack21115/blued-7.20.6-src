package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.lang.reflect.Type;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/TypeAdaptor2.class */
public abstract class TypeAdaptor2 implements TypeAdapter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T> T a(String str, Type type) throws WeJsonException;

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdapter
    public <T> T from(String str, Class<T> cls) throws WeJsonException {
        return (T) a(str, cls);
    }
}
