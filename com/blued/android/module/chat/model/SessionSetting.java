package com.blued.android.module.chat.model;

import android.text.TextUtils;
import com.blued.android.module.chat.ModuleChatConstant;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/model/SessionSetting.class */
public class SessionSetting extends SessionRelationModel {
    private String groupAdiminIDs;
    private long groupCreateId;
    private int id;
    private String sessinoNote;
    private int remindAudio = ModuleChatConstant.DEFAULT_REMIND_AUDIO_VALUE;
    private int groupNumberNum = 0;
    private int lietop = 0;
    private int uiStatus = 0;
    private String chatBgUri = "";
    private int sessionMsgBoxMsgNum = 0;
    private String sessionCommonStatus = "";

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

    public String getChatBgUri() {
        return this.chatBgUri;
    }

    public int getDBId() {
        return this.id;
    }

    public String getGroupAdiminIDs() {
        return this.groupAdiminIDs;
    }

    public long getGroupCreateId() {
        return this.groupCreateId;
    }

    public int getGroupNumberNum() {
        return this.groupNumberNum;
    }

    public int getId() {
        return this.id;
    }

    public int getLietop() {
        return this.lietop;
    }

    public int getRemindAudio() {
        return this.remindAudio;
    }

    public String getSessinoNote() {
        return this.sessinoNote;
    }

    public String getSessionCommonStatus() {
        return this.sessionCommonStatus;
    }

    public int getSessionMsgBoxMsgNum() {
        return this.sessionMsgBoxMsgNum;
    }

    public int getUiStatus() {
        return this.uiStatus;
    }

    public void setChatBgUri(String str) {
        this.chatBgUri = str;
    }

    public void setDBId(int i) {
        this.id = i;
    }

    public void setGroupAdiminIDs(String str) {
        this.groupAdiminIDs = str;
    }

    public void setGroupCreateId(long j) {
        this.groupCreateId = j;
    }

    public void setGroupNumberNum(int i) {
        this.groupNumberNum = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLietop(int i) {
        this.lietop = i;
    }

    public void setRemindAudio(int i) {
        this.remindAudio = i;
    }

    public void setSessinoNote(String str) {
        this.sessinoNote = str;
    }

    public void setSessionCommonStatus(String str) {
        this.sessionCommonStatus = str;
    }

    public void setSessionMsgBoxMsgNum(int i) {
        this.sessionMsgBoxMsgNum = i;
    }

    public void setUiStatus(int i) {
        this.uiStatus = i;
    }

    @Override // com.blued.android.module.chat.model.SessionRelationModel, com.blued.android.module.chat.model.SessionBaseModel
    public String toString() {
        return super.toString();
    }

    public void updateValues(Map<String, Object> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        setField(this, key, entry.getValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
