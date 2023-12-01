package com.blued.android.module.common.db.model;

import android.text.TextUtils;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SessionSettingModel")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/SessionSettingModel.class */
public class SessionSettingModel extends SessionSettingBaseModel {
    public int bubbleThemeId;
    @DatabaseField
    private int follower;
    @DatabaseField
    private String groupAdiminIDs;
    @DatabaseField
    private long groupCreateId;
    @DatabaseField
    public int group_status;
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @DatabaseField
    private int initiator;
    @DatabaseField
    public int is_super;
    @DatabaseField(index = true)
    private long loadName;
    @DatabaseField
    private int nearby;
    @DatabaseField
    private int online;
    @DatabaseField
    private String sessinoNote;
    @DatabaseField
    private String sessionCommonStatus;
    @DatabaseField(index = true)
    private long sessionId;
    @DatabaseField(index = true)
    private short sessionType;
    @DatabaseField
    private int remindAudio = 0;
    @DatabaseField
    private int groupNumberNum = 0;
    @DatabaseField
    private int lietop = 0;
    @DatabaseField
    private int uiStatus = 0;
    @DatabaseField
    private String chatBgUri = "";

    @Override // com.blued.android.chat.model.SessionSettingBaseModel
    public void copyValue(SessionSettingBaseModel sessionSettingBaseModel) {
        if (sessionSettingBaseModel == null) {
            return;
        }
        SessionSettingModel sessionSettingModel = (SessionSettingModel) sessionSettingBaseModel;
        this.remindAudio = sessionSettingModel.remindAudio;
        this.chatBgUri = sessionSettingModel.chatBgUri;
        this.group_status = sessionSettingModel.group_status;
        this.groupCreateId = sessionSettingModel.groupCreateId;
        this.is_super = sessionSettingModel.is_super;
        if (TextUtils.isEmpty(sessionSettingModel.sessinoNote)) {
            return;
        }
        this.sessinoNote = sessionSettingModel.sessinoNote;
    }

    public String getChatBgUri() {
        return this.chatBgUri;
    }

    @Override // com.blued.android.chat.model.SessionSettingBaseModel
    public int getDBId() {
        return this.id;
    }

    public int getFollower() {
        return this.follower;
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

    public int getInitiator() {
        return this.initiator;
    }

    public int getLietop() {
        return this.lietop;
    }

    public long getLoadName() {
        return this.loadName;
    }

    public int getNearby() {
        return this.nearby;
    }

    public int getOnline() {
        return this.online;
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

    public long getSessionId() {
        return this.sessionId;
    }

    public short getSessionType() {
        return this.sessionType;
    }

    public int getUiStatus() {
        return this.uiStatus;
    }

    public void setChatBgUri(String str) {
        this.chatBgUri = str;
    }

    @Override // com.blued.android.chat.model.SessionSettingBaseModel
    public void setDBId(int i) {
        this.id = i;
    }

    public void setFollower(int i) {
        this.follower = i;
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

    public void setInitiator(int i) {
        this.initiator = i;
    }

    public void setLietop(int i) {
        this.lietop = i;
    }

    public void setLoadName(long j) {
        this.loadName = j;
    }

    public void setNearby(int i) {
        this.nearby = i;
    }

    public void setOnline(int i) {
        this.online = i;
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

    public void setSessionId(long j) {
        this.sessionId = j;
    }

    public void setSessionType(short s) {
        this.sessionType = s;
    }

    public void setUiStatus(int i) {
        this.uiStatus = i;
    }

    public String toString() {
        return "SessionSettingModel{id=" + this.id + ", sessionId=" + this.sessionId + ", sessionType=" + ((int) this.sessionType) + ", loadName=" + this.loadName + ", remindAudio=" + this.remindAudio + ", groupCreateId=" + this.groupCreateId + ", groupNumberNum=" + this.groupNumberNum + ", groupAdiminIDs='" + this.groupAdiminIDs + "', lietop=" + this.lietop + ", uiStatus=" + this.uiStatus + ", chatBgUri='" + this.chatBgUri + "', sessinoNote='" + this.sessinoNote + "', nearby=" + this.nearby + ", online=" + this.online + ", follower=" + this.follower + ", initiator=" + this.initiator + "} " + super.toString();
    }
}
