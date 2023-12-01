package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: source-8110460-dex2jar.jar:com/google/gson/JsonDeserializationContext.class */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
