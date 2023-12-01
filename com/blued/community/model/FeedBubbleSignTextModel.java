package com.blued.community.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedBubbleSignTextModel.class */
public final class FeedBubbleSignTextModel {
    private String date;
    private int is_today;
    private String state_icon;

    public final String getDate() {
        return this.date;
    }

    public final String getState_icon() {
        return this.state_icon;
    }

    public final int is_today() {
        return this.is_today;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final void setState_icon(String str) {
        this.state_icon = str;
    }

    public final void set_today(int i) {
        this.is_today = i;
    }
}
