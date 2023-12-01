package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePocketModel.class */
public final class LivePocketModel implements Serializable {
    private int column_num;
    private int count;
    private long effect_time;
    private long expire_time;
    private int id;
    private int line_num;
    private int pocket_goods_id;
    private int reward_count;
    private boolean selected;
    private int status;
    private int type;
    private long use_time;
    private String image = "";
    private String name = "";
    private String description = "";

    public final int getColumn_num() {
        return this.column_num;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getEffect_time() {
        return this.effect_time;
    }

    public final long getExpire_time() {
        return this.expire_time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getLine_num() {
        return this.line_num;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPocket_goods_id() {
        return this.pocket_goods_id;
    }

    public final int getReward_count() {
        return this.reward_count;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUse_time() {
        return this.use_time;
    }

    public final void setColumn_num(int i) {
        this.column_num = i;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setDescription(String str) {
        Intrinsics.e(str, "<set-?>");
        this.description = str;
    }

    public final void setEffect_time(long j) {
        this.effect_time = j;
    }

    public final void setExpire_time(long j) {
        this.expire_time = j;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setLine_num(int i) {
        this.line_num = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setPocket_goods_id(int i) {
        this.pocket_goods_id = i;
    }

    public final void setReward_count(int i) {
        this.reward_count = i;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUse_time(long j) {
        this.use_time = j;
    }
}
