package com.blued.android.module.live_china.model;

import com.blued.android.module.live_china.manager.LiveRoomManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomFunctionItemModel.class */
public final class LiveRoomFunctionItemModel {
    private int link_type;
    private int weight;
    private String title = "";
    private String icon = "";
    private String icon_off = "";
    private String link = "";
    private String description = "";
    private String action = "";

    public final String getAction() {
        return this.action;
    }

    public final String getCurrentIcon() {
        if (Intrinsics.a((Object) this.link, (Object) ConstFunction.LIVE_ROOM_GIFT_ANIMATION) && !LiveRoomManager.a().H()) {
            return this.icon_off;
        }
        return this.icon;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_off() {
        return this.icon_off;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getLink_type() {
        return this.link_type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setAction(String str) {
        Intrinsics.e(str, "<set-?>");
        this.action = str;
    }

    public final void setDescription(String str) {
        Intrinsics.e(str, "<set-?>");
        this.description = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setIcon_off(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon_off = str;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setLink_type(int i) {
        this.link_type = i;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setWeight(int i) {
        this.weight = i;
    }
}
