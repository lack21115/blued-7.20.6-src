package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogAnimationModel.class */
public final class RandomGiftDialogAnimationModel implements Serializable {
    private ArrayList<RandomGiftItemModel> list;
    private String random_weight_incr = "";
    private String random_weight_incr_desc = "";

    public final ArrayList<RandomGiftItemModel> getList() {
        return this.list;
    }

    public final String getRandom_weight_incr() {
        return this.random_weight_incr;
    }

    public final String getRandom_weight_incr_desc() {
        return this.random_weight_incr_desc;
    }

    public final void setList(ArrayList<RandomGiftItemModel> arrayList) {
        this.list = arrayList;
    }

    public final void setRandom_weight_incr(String str) {
        Intrinsics.e(str, "<set-?>");
        this.random_weight_incr = str;
    }

    public final void setRandom_weight_incr_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.random_weight_incr_desc = str;
    }
}
