package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/InstanceCreator.class */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
