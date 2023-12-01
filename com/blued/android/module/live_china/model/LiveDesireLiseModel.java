package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveDesireLiseModel.class */
public class LiveDesireLiseModel implements MultiItemEntity {
    public static final int DESIRE_MODEL = 0;
    public static final int DESIRE_MODEL_ADD = 1;
    public static final int DESIRE_MODEL_TIPS = 2;
    public String avatar;
    public int count;
    public LiveDesireGiftInfo gift_info;
    public long id;
    public boolean isCreate;
    public int progress;
    public List<LiveDesireRank> rank;
    public String return_way;
    public int status;
    public String tips;
    public int type = 0;
    public int uid;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
