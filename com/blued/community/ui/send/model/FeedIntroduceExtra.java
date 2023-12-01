package com.blued.community.ui.send.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.ui.topic.model.BluedTopic;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedIntroduceExtra.class */
public final class FeedIntroduceExtra extends BluedEntityBaseExtra {
    private BluedTopic label_topics;
    private BluedTopic oneself_topics;

    public final BluedTopic getLabel_topics() {
        return this.label_topics;
    }

    public final BluedTopic getOneself_topics() {
        return this.oneself_topics;
    }

    public final void setLabel_topics(BluedTopic bluedTopic) {
        this.label_topics = bluedTopic;
    }

    public final void setOneself_topics(BluedTopic bluedTopic) {
        this.oneself_topics = bluedTopic;
    }
}
