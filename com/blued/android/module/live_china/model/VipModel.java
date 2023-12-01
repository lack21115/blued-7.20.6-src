package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipModel.class */
public final class VipModel implements Serializable {
    private int desc_color;
    private int level;
    private float next_level_score;
    private ArrayList<VipPrivilegeModel> privileges;
    private float score;
    private int tag_color;
    private int tag_text_color;
    private String name = "";
    private String last_level_name = "";
    private String next_level_name = "";
    private String desc_light_color = "";
    private String bg_url = "";
    private String card_bg_url = "";
    private String level_title_url = "";
    private String ornament_url = "";
    private int placeholder = -1;

    public final String getBg_url() {
        return this.bg_url;
    }

    public final String getCard_bg_url() {
        return this.card_bg_url;
    }

    public final int getDesc_color() {
        return this.desc_color;
    }

    public final String getDesc_light_color() {
        return this.desc_light_color;
    }

    public final String getLast_level_name() {
        return this.last_level_name;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLevel_title_url() {
        return this.level_title_url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNext_level_name() {
        return this.next_level_name;
    }

    public final float getNext_level_score() {
        return this.next_level_score;
    }

    public final String getOrnament_url() {
        return this.ornament_url;
    }

    public final int getPlaceholder() {
        return this.placeholder;
    }

    public final ArrayList<VipPrivilegeModel> getPrivileges() {
        return this.privileges;
    }

    public final float getScore() {
        return this.score;
    }

    public final int getTag_color() {
        return this.tag_color;
    }

    public final int getTag_text_color() {
        return this.tag_text_color;
    }

    public final void setBg_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bg_url = str;
    }

    public final void setCard_bg_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.card_bg_url = str;
    }

    public final void setDesc_color(int i) {
        this.desc_color = i;
    }

    public final void setDesc_light_color(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc_light_color = str;
    }

    public final void setLast_level_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.last_level_name = str;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setLevel_title_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.level_title_url = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setNext_level_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.next_level_name = str;
    }

    public final void setNext_level_score(float f) {
        this.next_level_score = f;
    }

    public final void setOrnament_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.ornament_url = str;
    }

    public final void setPlaceholder(int i) {
        this.placeholder = i;
    }

    public final void setPrivileges(ArrayList<VipPrivilegeModel> arrayList) {
        this.privileges = arrayList;
    }

    public final void setScore(float f) {
        this.score = f;
    }

    public final void setTag_color(int i) {
        this.tag_color = i;
    }

    public final void setTag_text_color(int i) {
        this.tag_text_color = i;
    }
}
