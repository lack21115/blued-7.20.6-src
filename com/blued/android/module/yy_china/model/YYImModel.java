package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYImModel.class */
public class YYImModel implements MultiItemEntity, Serializable {
    public String contents;
    public Object extra;
    private String msgExtra;
    public HashMap<String, Object> msgMapExtra;
    public long msg_time;
    public boolean resend;
    public boolean sayHello;
    public YYAudienceModel source_profile;
    public YYAudienceModel target_profile;
    public int type;
    public boolean isUpEven = false;
    public boolean isKtvSendGift = false;
    public boolean is_play_only_mp4 = false;

    public int getItemType() {
        return this.type;
    }

    public String getMsgExtra() {
        if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null) {
            this.msgExtra = AppInfo.f().toJson(this.msgMapExtra);
        }
        return this.msgExtra;
    }

    public void setMsgExtra(String str) {
        this.msgExtra = str;
    }
}
