package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogTaskModel.class */
public final class RandomGiftDialogTaskModel implements Serializable {
    private ArrayList<RandomGiftItemModel> list;
    private int remain_count;

    public final ArrayList<RandomGiftItemModel> getList() {
        return this.list;
    }

    public final int getRemain_count() {
        return this.remain_count;
    }

    public final void setList(ArrayList<RandomGiftItemModel> arrayList) {
        this.list = arrayList;
    }

    public final void setRemain_count(int i) {
        this.remain_count = i;
    }
}
