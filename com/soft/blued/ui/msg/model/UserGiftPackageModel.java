package com.soft.blued.ui.msg.model;

import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/UserGiftPackageModel.class */
public class UserGiftPackageModel extends Selectable {
    public long created_timestamp;
    public long end_time;
    public GiftGivingOptionForJsonParse gift_detail;
    public int gift_id;
    public int id;
    public int num;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((UserGiftPackageModel) obj).id;
    }

    public int hashCode() {
        return this.id;
    }
}
