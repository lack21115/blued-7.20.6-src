package com.blued.android.module.live_china.model;

import com.blued.android.module.live.base.model.PayOption;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/ReChargeGift.class */
public class ReChargeGift {
    public List<GiftItem> gifts;
    public List<PayOption._pay_list> pay_list;
    public List<String> statements;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/ReChargeGift$GiftItem.class */
    public static class GiftItem {
        public String image;
        public String title;
    }
}
