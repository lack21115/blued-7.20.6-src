package com.blued.android.module.chat.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/model/SessionRelationModel.class */
public class SessionRelationModel extends SessionBaseModel {
    private int delete;
    private int follower;
    private int initiator;
    private int is_hide_last_operate;
    private int nearby;
    private int online;
    private String status_img;
    private long uid;

    public void copySessionRelation(SessionRelationModel sessionRelationModel) {
        if (sessionRelationModel == null) {
            return;
        }
        setNearby(sessionRelationModel.getNearby());
        setOnline(sessionRelationModel.getOnline());
        setFollower(sessionRelationModel.getFollower());
        setInitiator(sessionRelationModel.getInitiator());
        setDelete(sessionRelationModel.getDelete());
        setIs_hide_last_operate(sessionRelationModel.getIs_hide_last_operate());
        setStatus_img(sessionRelationModel.status_img);
    }

    public int getDelete() {
        return this.delete;
    }

    public int getFollower() {
        return this.follower;
    }

    public int getInitiator() {
        return this.initiator;
    }

    public int getIs_hide_last_operate() {
        return this.is_hide_last_operate;
    }

    public int getNearby() {
        return this.nearby;
    }

    public int getOnline() {
        return this.online;
    }

    public String getStatus_img() {
        return this.status_img;
    }

    public long getUid() {
        return this.uid;
    }

    public void setDelete(int i) {
        this.delete = i;
    }

    public void setFollower(int i) {
        this.follower = i;
    }

    public void setInitiator(int i) {
        this.initiator = i;
    }

    public void setIs_hide_last_operate(int i) {
        this.is_hide_last_operate = i;
    }

    public void setNearby(int i) {
        this.nearby = i;
    }

    public void setOnline(int i) {
        this.online = i;
    }

    public void setStatus_img(String str) {
        this.status_img = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    @Override // com.blued.android.module.chat.model.SessionBaseModel
    public String toString() {
        return "SessionRelationModel{uid=" + this.uid + ", nearby=" + this.nearby + ", online=" + this.online + ", follower=" + this.follower + ", initiator=" + this.initiator + ", delete=" + this.delete + ", is_hide_last_operate=" + this.is_hide_last_operate + "} " + super.toString();
    }
}
