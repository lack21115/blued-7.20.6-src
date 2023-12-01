package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetBallModel.class */
public final class PlanetBallModel implements Serializable {
    private int bet_count;
    private int bet_limit;
    private int id;
    private int rate;
    private String name = "";
    private String name_image = "";
    private String image = "";

    public final int getBet_count() {
        return this.bet_count;
    }

    public final int getBet_limit() {
        return this.bet_limit;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getName_image() {
        return this.name_image;
    }

    public final int getRate() {
        return this.rate;
    }

    public final void setBet_count(int i) {
        this.bet_count = i;
    }

    public final void setBet_limit(int i) {
        this.bet_limit = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setName_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name_image = str;
    }

    public final void setRate(int i) {
        this.rate = i;
    }
}
