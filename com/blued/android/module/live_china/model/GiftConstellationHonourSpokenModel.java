package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GiftConstellationHonourSpokenModel.class */
public final class GiftConstellationHonourSpokenModel implements Serializable {
    private int bonus;
    private int is_hide;
    private float king_percent;
    private float percent;
    private int score;
    private String title = "";
    private int season = 1;
    private int anchor = 1;
    private String anchor_name = "";
    private String anchor_avatar = "";
    private String uid = "";
    private String name = "";
    private String avatar = "";

    public final int getAnchor() {
        return this.anchor;
    }

    public final String getAnchor_avatar() {
        return this.anchor_avatar;
    }

    public final String getAnchor_name() {
        return this.anchor_name;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getBonus() {
        return this.bonus;
    }

    public final float getKing_percent() {
        return this.king_percent;
    }

    public final String getName() {
        return this.name;
    }

    public final float getPercent() {
        return this.percent;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getSeason() {
        return this.season;
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

    public final void setAnchor(int i) {
        this.anchor = i;
    }

    public final void setAnchor_avatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_avatar = str;
    }

    public final void setAnchor_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_name = str;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBonus(int i) {
        this.bonus = i;
    }

    public final void setKing_percent(float f) {
        this.king_percent = f;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setPercent(float f) {
        this.percent = f;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setSeason(int i) {
        this.season = i;
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
}
