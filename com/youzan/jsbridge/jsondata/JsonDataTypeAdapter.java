package com.youzan.jsbridge.jsondata;

import android.text.TextUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/jsondata/JsonDataTypeAdapter.class */
public class JsonDataTypeAdapter extends TypeAdapter<JsonDataValue> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public JsonDataValue read(JsonReader jsonReader) throws IOException {
        JsonDataValue jsonDataValue = new JsonDataValue();
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_OBJECT) {
            jsonReader.beginObject();
            HashMap hashMap = new HashMap();
            while (jsonReader.hasNext()) {
                hashMap.put(jsonReader.nextName(), read(jsonReader));
            }
            jsonDataValue.mapValue = hashMap;
            jsonReader.endObject();
            return jsonDataValue;
        } else if (peek != JsonToken.BEGIN_ARRAY) {
            jsonDataValue.stringValue = jsonReader.nextString();
            return jsonDataValue;
        } else {
            jsonReader.beginArray();
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                arrayList.add(read(jsonReader));
            }
            jsonDataValue.arrayValue = arrayList;
            jsonReader.endArray();
            return jsonDataValue;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, JsonDataValue jsonDataValue) throws IOException {
        if (jsonDataValue == null) {
            jsonWriter.nullValue();
        } else if (!TextUtils.isEmpty(jsonDataValue.stringValue)) {
            jsonWriter.value(jsonDataValue.stringValue);
        } else if (jsonDataValue.mapValue != null) {
            jsonWriter.beginObject();
            for (Map.Entry<String, JsonDataValue> entry : jsonDataValue.mapValue.entrySet()) {
                jsonWriter.name(entry.getKey());
                write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        } else if (jsonDataValue.arrayValue == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.beginArray();
            for (JsonDataValue jsonDataValue2 : jsonDataValue.arrayValue) {
                write(jsonWriter, jsonDataValue2);
            }
            jsonWriter.endArray();
        }
    }
}
