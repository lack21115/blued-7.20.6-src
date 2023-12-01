package com.blued.community.model;

import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedTopBannerModel.class */
public final class FeedTopBannerModel {
    private String button_text;
    private String feed_ids;
    private String subtitle;
    private String title;
    private List<String> user_avatar;

    public final String getButton_text() {
        return this.button_text;
    }

    public final String getFeed_ids() {
        return this.feed_ids;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getUser_avatar() {
        return this.user_avatar;
    }

    public final void setButton_text(String str) {
        this.button_text = str;
    }

    public final void setFeed_ids(String str) {
        this.feed_ids = str;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUser_avatar(List<String> list) {
        this.user_avatar = list;
    }
}
