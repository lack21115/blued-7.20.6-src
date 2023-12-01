package com.soft.blued.ui.msg.model;

import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.BlueAppLocal;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraGift.class */
public class MsgExtraGift implements Serializable {
    public GiftInfo gift_like;
    public MsgSourceEntity msgSource;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgExtraGift$GiftInfo.class */
    public static class GiftInfo implements Serializable {
        public GiftGivingOptionForJsonParse.CardGift cardGift;
        public String giftId;
        public int giftTye;
        public String gift_name_cn;
        public String gift_name_en;
        public String gift_name_tw;
        public String gift_url;
        public String img_url;
        public float money;
        public String toNickName;
        public int topTime;
    }

    public String getGiftName() {
        if (this.gift_like == null) {
            return "";
        }
        String language = BlueAppLocal.c().getLanguage();
        return language.equals("en") ? this.gift_like.gift_name_en : language.equals(a.V) ? this.gift_like.gift_name_cn : this.gift_like.gift_name_tw;
    }
}
