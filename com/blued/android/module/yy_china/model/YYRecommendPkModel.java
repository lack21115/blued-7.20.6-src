package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRecommendPkModel.class */
public class YYRecommendPkModel implements MultiItemEntity, Serializable {
    public String room_id;
    public int room_member_count;
    public String room_name;
    public String room_type_id;
    public String room_type_name;
    public int type;
    public String uid;
    public String user_avatar;
    public String user_name;

    public int getItemType() {
        return this.type;
    }
}
