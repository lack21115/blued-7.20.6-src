package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/TypeAdapter.class */
public interface TypeAdapter {
    <T> T from(String str, Class<T> cls) throws WeJsonException;

    <T> String to(T t);
}
