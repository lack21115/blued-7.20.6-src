package com.soft.blued.ui.live.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/LiveGrabModel.class */
public class LiveGrabModel implements MultiItemEntity {
    public int beans;
    public int contentType;
    public String cover;
    public String game_name;
    private int itemType;
    public long lid;
    public String name;
    public long time;
    public long uid;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }
}
