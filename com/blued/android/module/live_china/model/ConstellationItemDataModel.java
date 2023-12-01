package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/ConstellationItemDataModel.class */
public final class ConstellationItemDataModel extends BluedEntityBaseExtra implements Serializable {
    private int anchor;
    private int bonus;
    private int is_hide;
    private int is_king;
    private float king_percent;
    private float percent;
    private int rank;
    private int ranking;
    private int score;
    private int uid;
    private String anchor_name = "";
    private String anchor_avatar = "";
    private String avatar = "";
    private String name = "";

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

    public final int getRank() {
        return this.rank;
    }

    public final int getRanking() {
        return this.ranking;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getUid() {
        return this.uid;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final int is_king() {
        return this.is_king;
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

    public final void setRank(int i) {
        this.rank = i;
    }

    public final void setRanking(int i) {
        this.ranking = i;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setUid(int i) {
        this.uid = i;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }

    public final void set_king(int i) {
        this.is_king = i;
    }
}
