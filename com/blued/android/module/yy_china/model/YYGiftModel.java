package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGiftModel.class */
public class YYGiftModel extends CommonLiveGiftModel {
    public YYGiftActivityModel activity;
    public String description;
    public String expire;
    public LuckGiftModel extra;
    public String fans_exclusive_level;
    private String freeTime;
    public int free_count;
    public String goodsDescribe;
    public List<LiveGiftNumberModel> goods_number;
    public int goods_type;
    public String images_apng;
    public int is_all;
    public int is_displayed;
    public String is_free;
    public String is_hot;
    public int is_luck_gift;
    public String json_contents;
    public String marker;
    public String rain;
    public LiveGiftNumberModel selectedGiftNumModel;
    public int type = 0;
    public String yyTarget_uid;
    public String yy_password_success_event;

    @Override // com.blued.android.module.common.model.BaseGiftModel
    public int getDeleteItemCount() {
        return this.count;
    }

    public String getFreeTime() {
        if (this.free_count <= 0) {
            this.freeTime = "不可送出";
        } else if (TextUtils.isEmpty(this.freeTime)) {
            this.freeTime = YYRoomInfoManager.e().n();
        }
        return this.freeTime;
    }

    public boolean isBag() {
        return this.goods_type == new Integer("-1").intValue();
    }

    public void setFreeTime(String str) {
        this.freeTime = str;
    }
}
