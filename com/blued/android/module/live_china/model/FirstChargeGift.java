package com.blued.android.module.live_china.model;

import com.blued.android.module.live.base.model.PayOption;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/FirstChargeGift.class */
public class FirstChargeGift {
    public List<FirstChargeGiftItem> gifts;
    public List<PayOption._pay_list> pay_list;
    public String rule;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/FirstChargeGift$FirstChargeGiftItem.class */
    public static class FirstChargeGiftItem {
        public int amount;
        public String image;
        public int price;
        public String title;
    }
}
