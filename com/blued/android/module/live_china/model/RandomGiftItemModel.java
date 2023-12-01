package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftItemModel.class */
public final class RandomGiftItemModel implements Serializable {
    private int is_hide;
    private int is_percent_fly;
    private int light_count;
    private int remain_count;
    private String goods_icon = "";
    private String goods_name = "";
    private String goods_type = "";
    private String init_random_weight = "";
    private String current_random_weight = "";
    private String random_weight = "";
    private String label = "";
    private String title = "";
    private String next_title = "";
    private String uid = "";
    private String avatar = "";
    private String name = "";
    private String time = "";
    private String reward_type = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCurrent_random_weight() {
        return this.current_random_weight;
    }

    public final String getGoods_icon() {
        return this.goods_icon;
    }

    public final String getGoods_name() {
        return this.goods_name;
    }

    public final String getGoods_type() {
        return this.goods_type;
    }

    public final String getInit_random_weight() {
        return this.init_random_weight;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getLight_count() {
        return this.light_count;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNext_title() {
        return this.next_title;
    }

    public final String getRandom_weight() {
        return this.random_weight;
    }

    public final int getRemain_count() {
        return this.remain_count;
    }

    public final String getReward_type() {
        return this.reward_type;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUid() {
        return this.uid;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final int is_percent_fly() {
        return this.is_percent_fly;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCurrent_random_weight(String str) {
        Intrinsics.e(str, "<set-?>");
        this.current_random_weight = str;
    }

    public final void setGoods_icon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_icon = str;
    }

    public final void setGoods_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_name = str;
    }

    public final void setGoods_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.goods_type = str;
    }

    public final void setInit_random_weight(String str) {
        Intrinsics.e(str, "<set-?>");
        this.init_random_weight = str;
    }

    public final void setLabel(String str) {
        Intrinsics.e(str, "<set-?>");
        this.label = str;
    }

    public final void setLight_count(int i) {
        this.light_count = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setNext_title(String str) {
        Intrinsics.e(str, "<set-?>");
        this.next_title = str;
    }

    public final void setRandom_weight(String str) {
        Intrinsics.e(str, "<set-?>");
        this.random_weight = str;
    }

    public final void setRemain_count(int i) {
        this.remain_count = i;
    }

    public final void setReward_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.reward_type = str;
    }

    public final void setTime(String str) {
        Intrinsics.e(str, "<set-?>");
        this.time = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }

    public final void set_percent_fly(int i) {
        this.is_percent_fly = i;
    }
}
