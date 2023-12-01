package com.blued.community.ui.event.model;

import com.blued.community.ui.feed.model.FeedDetailParams;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/model/EventLogData.class */
public final class EventLogData extends FeedDetailParams {
    private FeedProtos.SourcePage sourcePage;
    private String eventId = "";
    private String eventManagerUid = "";
    private String uid = "";

    public final String getEventId() {
        return this.eventId;
    }

    public final String getEventManagerUid() {
        return this.eventManagerUid;
    }

    public final FeedProtos.SourcePage getSourcePage() {
        return this.sourcePage;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public final void setEventManagerUid(String str) {
        this.eventManagerUid = str;
    }

    public final void setSourcePage(FeedProtos.SourcePage sourcePage) {
        this.sourcePage = sourcePage;
    }

    public final void setUid(String str) {
        this.uid = str;
    }
}
