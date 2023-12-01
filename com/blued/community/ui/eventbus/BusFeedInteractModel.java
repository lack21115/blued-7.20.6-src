package com.blued.community.ui.eventbus;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/eventbus/BusFeedInteractModel.class */
public final class BusFeedInteractModel {
    private int expression_id;
    private String feedId;
    private int interaction_count;
    private int interaction_id;
    private boolean isAdd = true;

    public final int getExpression_id() {
        return this.expression_id;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final int getInteraction_count() {
        return this.interaction_count;
    }

    public final int getInteraction_id() {
        return this.interaction_id;
    }

    public final boolean isAdd() {
        return this.isAdd;
    }

    public final void setAdd(boolean z) {
        this.isAdd = z;
    }

    public final void setExpression_id(int i) {
        this.expression_id = i;
    }

    public final void setFeedId(String str) {
        this.feedId = str;
    }

    public final void setInteraction_count(int i) {
        this.interaction_count = i;
    }

    public final void setInteraction_id(int i) {
        this.interaction_id = i;
    }
}
