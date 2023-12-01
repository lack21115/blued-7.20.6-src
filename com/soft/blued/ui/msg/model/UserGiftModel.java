package com.soft.blued.ui.msg.model;

import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/UserGiftModel.class */
public class UserGiftModel {
    public PayPlatformDiscountModel._channel channel;
    public List<GiftGivingOptionForJsonParse> list;
    public GiftGivingOptionForJsonParse lucky_bag;
    public UserInfo users;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/UserGiftModel$UserInfo.class */
    public class UserInfo {
        public int beans;
        public int has_payment_code;

        public UserInfo() {
        }
    }
}
