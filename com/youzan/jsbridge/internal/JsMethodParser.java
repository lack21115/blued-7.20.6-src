package com.youzan.jsbridge.internal;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.jsbridge.method.JsMethodCompat;
import com.youzan.jsbridge.util.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/internal/JsMethodParser.class */
public final class JsMethodParser {
    private static final String TAG = "JsMethodParser";
    private Gson mGson = new Gson();

    public JsMethodModel deserialize(String str) {
        try {
            JsMethodModel jsMethodModel = (JsMethodModel) this.mGson.fromJson(str, (Class<Object>) JsMethodModel.class);
            if (jsMethodModel == null || jsMethodModel.types == null || jsMethodModel.types.size() == 0 || !jsMethodModel.types.get(0).equalsIgnoreCase("String")) {
                return null;
            }
            return jsMethodModel;
        } catch (JsonSyntaxException e) {
            Logger.e(TAG, "failed to parse js data");
            return null;
        }
    }

    public JsMethod parse(JsMethodModel jsMethodModel) {
        try {
            JsMethod jsMethod = (JsMethod) this.mGson.fromJson(jsMethodModel.args.get(0), (Class<Object>) JsMethod.class);
            if (jsMethod != null) {
                if (TextUtils.isEmpty(jsMethod.name)) {
                    return null;
                }
                return jsMethod;
            }
            return null;
        } catch (JsonSyntaxException e) {
            Logger.d(TAG, "failed to parse new js method");
            return null;
        }
    }

    public JsMethod parse(String str) {
        JsMethodModel deserialize = deserialize(str);
        if (deserialize != null) {
            return parse(deserialize);
        }
        return null;
    }

    public JsMethodCompat parseCompat(JsMethodModel jsMethodModel) {
        return new JsMethodCompat(jsMethodModel.method, jsMethodModel.args.get(0));
    }

    public JsMethodCompat parseCompat(String str) {
        JsMethodModel deserialize = deserialize(str);
        if (deserialize != null) {
            return parseCompat(deserialize);
        }
        return null;
    }
}
