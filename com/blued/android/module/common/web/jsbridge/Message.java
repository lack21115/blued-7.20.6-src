package com.blued.android.module.common.web.jsbridge;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/Message.class */
public class Message {
    private static final String CALLBACK_ID_STR = "callbackId";
    private static final String DATA_STR = "data";
    private static final String HANDLER_NAME_STR = "handlerName";
    private static final String RESPONSE_DATA_STR = "responseData";
    private static final String RESPONSE_ID_STR = "responseId";
    private String callbackId;
    private String data;
    private String handlerName;
    private String responseData;
    private String responseId;

    public static List<Message> toArrayList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                Message message = new Message();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                message.setHandlerName(jSONObject.has(HANDLER_NAME_STR) ? jSONObject.getString(HANDLER_NAME_STR) : null);
                message.setCallbackId(jSONObject.has(CALLBACK_ID_STR) ? jSONObject.getString(CALLBACK_ID_STR) : null);
                message.setResponseData(jSONObject.has(RESPONSE_DATA_STR) ? jSONObject.getString(RESPONSE_DATA_STR) : null);
                message.setResponseId(jSONObject.has(RESPONSE_ID_STR) ? jSONObject.getString(RESPONSE_ID_STR) : null);
                String str2 = null;
                if (jSONObject.has("data")) {
                    str2 = jSONObject.getString("data");
                }
                message.setData(str2);
                arrayList.add(message);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static Message toObject(String str) {
        Message message = new Message();
        try {
            JSONObject jSONObject = new JSONObject(str);
            message.setHandlerName(jSONObject.has(HANDLER_NAME_STR) ? jSONObject.getString(HANDLER_NAME_STR) : null);
            message.setCallbackId(jSONObject.has(CALLBACK_ID_STR) ? jSONObject.getString(CALLBACK_ID_STR) : null);
            message.setResponseData(jSONObject.has(RESPONSE_DATA_STR) ? jSONObject.getString(RESPONSE_DATA_STR) : null);
            message.setResponseId(jSONObject.has(RESPONSE_ID_STR) ? jSONObject.getString(RESPONSE_ID_STR) : null);
            String str2 = null;
            if (jSONObject.has("data")) {
                str2 = jSONObject.getString("data");
            }
            message.setData(str2);
            return message;
        } catch (JSONException e) {
            e.printStackTrace();
            return message;
        }
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public String getData() {
        return this.data;
    }

    public String getHandlerName() {
        return this.handlerName;
    }

    public String getResponseData() {
        return this.responseData;
    }

    public String getResponseId() {
        return this.responseId;
    }

    public void setCallbackId(String str) {
        this.callbackId = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setHandlerName(String str) {
        this.handlerName = str;
    }

    public void setResponseData(String str) {
        this.responseData = str;
    }

    public void setResponseId(String str) {
        this.responseId = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CALLBACK_ID_STR, getCallbackId());
            jSONObject.put("data", getData());
            jSONObject.put(HANDLER_NAME_STR, getHandlerName());
            jSONObject.put(RESPONSE_DATA_STR, getResponseData());
            jSONObject.put(RESPONSE_ID_STR, getResponseId());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
