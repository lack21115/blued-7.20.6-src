package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/JsonDeserializer.class */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
