package com.blued.android.module.live_china.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBagModel.class */
public class LiveGiftBagModel {
    public LiveGiftBagPic background_pic;
    public int buy_state;
    public int daily_sold;
    public int daily_total;
    public int is_shelves_new;
    public int remain;
    public String url;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftBagModel$LiveGiftBagPic.class */
    public class LiveGiftBagPic {
        public String has_buy;
        public String not_topUp_and_not_remain;
        public String not_topUp_and_remain;
        public String topUp_and_not_remain;
        public String topUp_and_remain;

        public LiveGiftBagPic() {
        }
    }
}
