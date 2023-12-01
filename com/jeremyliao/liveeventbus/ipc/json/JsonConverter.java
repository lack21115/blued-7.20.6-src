package com.jeremyliao.liveeventbus.ipc.json;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/json/JsonConverter.class */
public interface JsonConverter {
    <T> T fromJson(String str, Class<T> cls);

    String toJson(Object obj);
}
