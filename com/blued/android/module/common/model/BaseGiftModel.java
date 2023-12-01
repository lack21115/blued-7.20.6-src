package com.blued.android.module.common.model;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/model/BaseGiftModel.class */
public class BaseGiftModel implements Serializable {
    public String index;
    public boolean isMp4;
    public boolean isSelected;
    public String name;
    public String packageIndex;
    public int packageTabIndex;
    public int pageIndex;
    public String pic;
    public String pic_apng;
    public int positionInPage;
    public int count = 1;
    public boolean isBagGift = false;

    public String getCompareParam() {
        return this.index;
    }

    public int getDeleteItemCount() {
        return this.count;
    }

    public String toString() {
        return "BaseGiftModel:[index:" + this.index + ", packageIndex:" + this.packageIndex + ", isSelected:" + this.isSelected + ", name:" + this.name + ", count:" + this.count + "]";
    }
}
