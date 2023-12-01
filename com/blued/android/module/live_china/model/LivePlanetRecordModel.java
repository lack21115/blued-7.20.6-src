package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetRecordModel.class */
public final class LivePlanetRecordModel implements MultiItemEntity, Serializable {
    private boolean expand;
    private List<LivePlanetRecordGiftModel> result;
    private int type;
    private String id = "";
    private String planet_id = "";
    private String expedition_id = "";
    private String planet_name = "";
    private String draw_planet_name = "";
    private String draw_beans = "";
    private String create_time = "";

    public final String getCreate_time() {
        return this.create_time;
    }

    public final String getDraw_beans() {
        return this.draw_beans;
    }

    public final String getDraw_planet_name() {
        return this.draw_planet_name;
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final String getExpedition_id() {
        return this.expedition_id;
    }

    public final String getId() {
        return this.id;
    }

    public int getItemType() {
        return this.type;
    }

    public final String getPlanet_id() {
        return this.planet_id;
    }

    public final String getPlanet_name() {
        return this.planet_name;
    }

    public final List<LivePlanetRecordGiftModel> getResult() {
        return this.result;
    }

    public final int getType() {
        return this.type;
    }

    public final void setCreate_time(String str) {
        Intrinsics.e(str, "<set-?>");
        this.create_time = str;
    }

    public final void setDraw_beans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.draw_beans = str;
    }

    public final void setDraw_planet_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.draw_planet_name = str;
    }

    public final void setExpand(boolean z) {
        this.expand = z;
    }

    public final void setExpedition_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.expedition_id = str;
    }

    public final void setId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.id = str;
    }

    public final void setPlanet_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.planet_id = str;
    }

    public final void setPlanet_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.planet_name = str;
    }

    public final void setResult(List<LivePlanetRecordGiftModel> list) {
        this.result = list;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
