package com.blued.android.module.live.base.model;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/PayRemainingText.class */
public class PayRemainingText implements Serializable {
    public String exchange;
    public String goods;
    public String jump_url;
    public String sums;

    public String toString() {
        return "PayRemainingText[exchange:" + this.exchange + ", goods" + this.goods + ", sums:" + this.sums + ", jump_url:" + this.jump_url + "]";
    }
}
