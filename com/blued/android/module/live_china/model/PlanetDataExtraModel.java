package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/PlanetDataExtraModel.class */
public final class PlanetDataExtraModel extends BluedEntityBaseExtra implements Serializable {
    private int beans;
    private ArrayList<PlanetGiftModel> goods_info;
    private int is_join;
    private int is_lucky;
    private int planet_id;
    private int rate;
    private int remain_time;
    private int ship_count;
    private String planet_name = "";
    private String planet_name_image = "";
    private String planet_image = "";

    public final int getBeans() {
        return this.beans;
    }

    public final ArrayList<PlanetGiftModel> getGoods_info() {
        return this.goods_info;
    }

    public final int getPlanet_id() {
        return this.planet_id;
    }

    public final String getPlanet_image() {
        return this.planet_image;
    }

    public final String getPlanet_name() {
        return this.planet_name;
    }

    public final String getPlanet_name_image() {
        return this.planet_name_image;
    }

    public final int getRate() {
        return this.rate;
    }

    public final int getRemain_time() {
        return this.remain_time;
    }

    public final int getShip_count() {
        return this.ship_count;
    }

    public final int is_join() {
        return this.is_join;
    }

    public final int is_lucky() {
        return this.is_lucky;
    }

    public final void setBeans(int i) {
        this.beans = i;
    }

    public final void setGoods_info(ArrayList<PlanetGiftModel> arrayList) {
        this.goods_info = arrayList;
    }

    public final void setPlanet_id(int i) {
        this.planet_id = i;
    }

    public final void setPlanet_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.planet_image = str;
    }

    public final void setPlanet_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.planet_name = str;
    }

    public final void setPlanet_name_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.planet_name_image = str;
    }

    public final void setRate(int i) {
        this.rate = i;
    }

    public final void setRemain_time(int i) {
        this.remain_time = i;
    }

    public final void setShip_count(int i) {
        this.ship_count = i;
    }

    public final void set_join(int i) {
        this.is_join = i;
    }

    public final void set_lucky(int i) {
        this.is_lucky = i;
    }
}
