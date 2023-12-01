package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftConstellationModel.class */
public final class LiveGiftConstellationModel implements Serializable {
    private String title = "";
    private String id = "";
    private String desc = "";
    private int basic_remain = -1;
    private String name = "";
    private int top_anchor = 1;
    private String anchor_avatar = "";
    private int top_uid = 1;
    private String avatar = "";
    private String image = "https://web.bldimg.com/image-manager/1688114458_26976.webp";

    public final String getAnchor_avatar() {
        return this.anchor_avatar;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getBasic_remain() {
        return this.basic_remain;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTop_anchor() {
        return this.top_anchor;
    }

    public final int getTop_uid() {
        return this.top_uid;
    }

    public final void setAnchor_avatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.anchor_avatar = str;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBasic_remain(int i) {
        this.basic_remain = i;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setId(String str) {
        Intrinsics.e(str, "<set-?>");
        this.id = str;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setTop_anchor(int i) {
        this.top_anchor = i;
    }

    public final void setTop_uid(int i) {
        this.top_uid = i;
    }
}
