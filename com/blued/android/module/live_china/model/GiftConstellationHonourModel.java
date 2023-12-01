package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationHonourModel.class */
public final class GiftConstellationHonourModel implements Serializable {
    private GiftConstellationHonourTopModel king;
    private ArrayList<GiftConstellationHonourSpokenModel> spokesman;
    private GiftConstellationHonourTopModel top;
    private int constellation_id = 1;
    private String name = "";
    private String constellation_name = "";

    public final int getConstellation_id() {
        return this.constellation_id;
    }

    public final String getConstellation_name() {
        return this.constellation_name;
    }

    public final GiftConstellationHonourTopModel getKing() {
        return this.king;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<GiftConstellationHonourSpokenModel> getSpokesman() {
        return this.spokesman;
    }

    public final GiftConstellationHonourTopModel getTop() {
        return this.top;
    }

    public final void setConstellation_id(int i) {
        this.constellation_id = i;
    }

    public final void setConstellation_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.constellation_name = str;
    }

    public final void setKing(GiftConstellationHonourTopModel giftConstellationHonourTopModel) {
        this.king = giftConstellationHonourTopModel;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setSpokesman(ArrayList<GiftConstellationHonourSpokenModel> arrayList) {
        this.spokesman = arrayList;
    }

    public final void setTop(GiftConstellationHonourTopModel giftConstellationHonourTopModel) {
        this.top = giftConstellationHonourTopModel;
    }
}
