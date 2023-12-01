package com.blued.community.ui.feed.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/RecommendFeedRefreshGuideModel.class */
public final class RecommendFeedRefreshGuideModel {
    private int index;
    private int locY;

    public final int getIndex() {
        return this.index;
    }

    public final int getLocY() {
        return this.locY;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setLocY(int i) {
        this.locY = i;
    }

    public String toString() {
        return "index:" + this.index + ", locY:" + this.locY;
    }
}
