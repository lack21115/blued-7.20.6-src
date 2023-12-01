package com.blued.community.ui.topic.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/model/BluedTopicOuterExtra.class */
public final class BluedTopicOuterExtra extends BluedEntityBaseExtra {
    private BluedTopic back_topics_id;

    public final BluedTopic getBack_topics_id() {
        return this.back_topics_id;
    }

    public final void setBack_topics_id(BluedTopic bluedTopic) {
        this.back_topics_id = bluedTopic;
    }
}
