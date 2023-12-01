package com.blued.community.ui.feed.model;

import com.blued.community.ui.send.model.FeedPostSignStateItem;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/FeedBubbleListGuideExtra.class */
public final class FeedBubbleListGuideExtra {
    private String button;
    private String remove;
    private ArrayList<FeedPostSignStateItem> state_data;
    private String title;

    public final String getButton() {
        return this.button;
    }

    public final String getRemove() {
        return this.remove;
    }

    public final ArrayList<FeedPostSignStateItem> getState_data() {
        return this.state_data;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final void setRemove(String str) {
        this.remove = str;
    }

    public final void setState_data(ArrayList<FeedPostSignStateItem> arrayList) {
        this.state_data = arrayList;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("button:");
        sb.append((Object) this.button);
        sb.append(", title:");
        sb.append((Object) this.title);
        sb.append(", state_data.size:");
        ArrayList<FeedPostSignStateItem> arrayList = this.state_data;
        sb.append(arrayList == null ? null : Integer.valueOf(arrayList.size()));
        return sb.toString();
    }
}
