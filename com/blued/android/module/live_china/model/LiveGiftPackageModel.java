package com.blued.android.module.live_china.model;

import com.blued.android.module.common.model.CommonGiftPackageModel;
import java.util.Arrays;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftPackageModel.class */
public class LiveGiftPackageModel extends CommonGiftPackageModel<LiveGiftModel> {
    public static final int GIFT_BACKPACK_AVATAR_FRAME = 10;
    public static final int GIFT_BACKPACK_CHAT_BADGE = 12;
    public static final int GIFT_BACKPACK_CHAT_FRAME = 9;
    public static final int GIFT_BACKPACK_EFFECT = 11;
    public static final int GIFT_BACKPACK_GIFT = 6;
    public static final int GIFT_BACKPACK_GIFT_CARD_FRAME = 14;
    public static final int GIFT_BACKPACK_GIFT_FRAGMENT = 13;
    public static final int GIFT_BACKPACK_IN_PROPS = 7;
    public static final int GIFT_BACKPACK_NOT_PROPS = 8;
    public static final int GIFT_PACKAGE_TYPE_AVATAR = 3;
    public static final int GIFT_PACKAGE_TYPE_BUBBLE_BG = 4;
    public static final int GIFT_PACKAGE_TYPE_CHARGE_COUPON = 5;
    public static final int GIFT_PACKAGE_TYPE_DRIVE = 2;
    public static final int GIFT_PACKAGE_TYPE_MAGIC = 1;
    public static final int GIFT_PACKAGE_TYPE_MIX = -1;
    public static final int GIFT_PACKAGE_TYPE_NORMAL = 0;
    public int is_ar;
    public int is_effect;
    public int itemPadding;
    public int red_point;
    public boolean showQuestion = false;
    public String type_name;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveGiftPackageModel) {
            LiveGiftPackageModel liveGiftPackageModel = (LiveGiftPackageModel) obj;
            boolean z = false;
            if (liveGiftPackageModel.goods != null) {
                z = false;
                if (this.goods != null) {
                    z = Arrays.equals(liveGiftPackageModel.goods.toArray(), this.goods.toArray());
                }
            }
            return z;
        }
        return false;
    }
}
