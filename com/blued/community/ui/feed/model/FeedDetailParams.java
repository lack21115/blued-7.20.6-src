package com.blued.community.ui.feed.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/FeedDetailParams.class */
public class FeedDetailParams extends FeedTrackParams {
    public String agency;
    public int comeCode;
    public String commentID;
    public boolean hasComment;
    public boolean isFromComment;

    public FeedDetailParams() {
    }

    public FeedDetailParams(int i) {
        this.comeCode = i;
    }
}
