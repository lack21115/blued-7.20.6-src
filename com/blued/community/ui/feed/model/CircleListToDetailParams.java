package com.blued.community.ui.feed.model;

import com.blued.das.client.feed.FeedProtos;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/CircleListToDetailParams.class */
public final class CircleListToDetailParams implements Serializable {
    private String mode;
    private FeedProtos.NoteSource source = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE;
    private Boolean showCircleEntry = false;

    public final String getMode() {
        return this.mode;
    }

    public final Boolean getShowCircleEntry() {
        return this.showCircleEntry;
    }

    public final FeedProtos.NoteSource getSource() {
        return this.source;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setShowCircleEntry(Boolean bool) {
        this.showCircleEntry = bool;
    }

    public final void setSource(FeedProtos.NoteSource noteSource) {
        this.source = noteSource;
    }
}
