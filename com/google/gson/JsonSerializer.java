package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/JsonSerializer.class */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
