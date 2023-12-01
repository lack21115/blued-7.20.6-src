package com.jeremyliao.liveeventbus.ipc.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/json/GsonConverter.class */
public class GsonConverter implements JsonConverter {
    private Gson gson = new Gson();

    @Override // com.jeremyliao.liveeventbus.ipc.json.JsonConverter
    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) this.gson.fromJson(str, (Class<Object>) cls);
    }

    @Override // com.jeremyliao.liveeventbus.ipc.json.JsonConverter
    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }
}
