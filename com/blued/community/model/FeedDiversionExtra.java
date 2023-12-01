package com.blued.community.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.ui.topic.model.BluedTopic;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedDiversionExtra.class */
public final class FeedDiversionExtra extends BluedEntityBaseExtra {
    private BluedTopic guide;

    public final BluedTopic getGuide() {
        return this.guide;
    }

    public final void setGuide(BluedTopic bluedTopic) {
        this.guide = bluedTopic;
    }
}
