package com.weimob.library.groups.wjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.weimob.library.groups.wjson.exception.WJSONException;
import java.lang.reflect.Type;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/wjson/WJSON.class */
public final class WJSON {
    public static final <T> T parseObject(String str, WTypeReference<T> wTypeReference) {
        try {
            return (T) JSON.parseObject(str, wTypeReference, new Feature[0]);
        } catch (Exception e) {
            throw new WJSONException(e.getMessage(), e);
        }
    }

    public static final <T> T parseObject(String str, Class<T> cls) {
        return (T) JSON.parseObject(str, cls);
    }

    public static final <T> T parseObject(String str, Type type) {
        try {
            return (T) JSON.parseObject(str, type, new Feature[0]);
        } catch (Exception e) {
            throw new WJSONException(e.getMessage(), e);
        }
    }

    public static final WJSONArray parseWJSONArray(String str) {
        return (WJSONArray) parseObject(str, (Class<Object>) WJSONArray.class);
    }

    public static final WJSONObject parseWJSONObject(String str) {
        return (WJSONObject) parseObject(str, (Class<Object>) WJSONObject.class);
    }

    public static final byte[] toJSONBytes(Object obj) {
        return JSON.toJSONBytes(obj, new SerializerFeature[0]);
    }

    public static String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static String toJSONString(Object obj, boolean z) {
        return JSON.toJSONString(obj, z);
    }
}
