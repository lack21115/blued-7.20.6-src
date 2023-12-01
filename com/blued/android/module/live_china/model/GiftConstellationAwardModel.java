package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationAwardModel.class */
public final class GiftConstellationAwardModel implements Serializable {
    private ArrayList<GiftConstellationAwardItemModel> king;
    private ArrayList<GiftConstellationAwardItemModel> spokesman;

    public final ArrayList<GiftConstellationAwardItemModel> getKing() {
        return this.king;
    }

    public final ArrayList<GiftConstellationAwardItemModel> getSpokesman() {
        return this.spokesman;
    }

    public final void setKing(ArrayList<GiftConstellationAwardItemModel> arrayList) {
        this.king = arrayList;
    }

    public final void setSpokesman(ArrayList<GiftConstellationAwardItemModel> arrayList) {
        this.spokesman = arrayList;
    }
}
