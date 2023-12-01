package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import java.util.Arrays;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYGiftPackageModel.class */
public class YYGiftPackageModel extends CommonGiftPackageModel<YYGiftModel> {
    public static final String YY_GIFT_BAG_TYPE_ID = "-1";
    public int itemPadding;
    public String type_id;
    public String type_name;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof YYGiftPackageModel) {
            YYGiftPackageModel yYGiftPackageModel = (YYGiftPackageModel) obj;
            boolean equals = (yYGiftPackageModel.goods == null || this.goods == null) ? false : Arrays.equals(yYGiftPackageModel.goods.toArray(), this.goods.toArray());
            Logger.a("niu", "goodsCompare = ", Boolean.valueOf(equals));
            return equals;
        }
        return false;
    }

    public boolean isBag() {
        return TextUtils.equals("-1", this.type_id);
    }
}
