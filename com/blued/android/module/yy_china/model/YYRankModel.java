package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRankModel.class */
public class YYRankModel implements MultiItemEntity {
    public String avatar;
    public String beans;
    public String name;
    public List<YYRankModel> topList;
    public int type = 0;
    public String uid;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
