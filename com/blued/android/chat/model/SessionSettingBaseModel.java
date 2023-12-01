package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/model/SessionSettingBaseModel.class */
public abstract class SessionSettingBaseModel {
    private static final String TAG = "Chat_SessionSetting";

    private boolean setField(Object obj, String str, Object obj2) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            field = null;
        }
        Class<? super Object> superclass = obj.getClass().getSuperclass();
        while (field == null && superclass != null) {
            try {
                field = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException e2) {
                superclass = superclass.getSuperclass();
            }
        }
        if (field == null) {
            return false;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
            return true;
        } catch (IllegalAccessException e3) {
            return false;
        }
    }

    public abstract void copyValue(SessionSettingBaseModel sessionSettingBaseModel);

    public abstract int getDBId();

    public abstract void setDBId(int i);

    public void updateValues(Map<String, Object> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        boolean field = setField(this, key, entry.getValue());
                        if (ChatManager.debug) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("updateValues() | 更新");
                            sb.append(field ? "成功" : "失败！！！");
                            sb.append(" | ");
                            sb.append(key);
                            sb.append(":");
                            sb.append(entry.getValue());
                            Log.v(TAG, sb.toString());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
