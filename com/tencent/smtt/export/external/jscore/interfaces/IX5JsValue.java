package com.tencent.smtt.export.external.jscore.interfaces;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/jscore/interfaces/IX5JsValue.class */
public interface IX5JsValue {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/jscore/interfaces/IX5JsValue$JsValueFactory.class */
    public interface JsValueFactory {
        String getJsValueClassName();

        IX5JsValue unwrap(Object obj);

        Object wrap(IX5JsValue iX5JsValue);
    }

    IX5JsValue call(Object[] objArr);

    IX5JsValue construct(Object[] objArr);

    boolean isArray();

    boolean isArrayBufferOrArrayBufferView();

    boolean isBoolean();

    boolean isFunction();

    boolean isInteger();

    boolean isJavascriptInterface();

    boolean isNull();

    boolean isNumber();

    boolean isObject();

    boolean isPromise();

    boolean isString();

    boolean isUndefined();

    void resolveOrReject(Object obj, boolean z);

    boolean toBoolean();

    ByteBuffer toByteBuffer();

    int toInteger();

    Object toJavascriptInterface();

    Number toNumber();

    <T> T toObject(Class<T> cls);

    String toString();
}
