package com.blued.community.ui.send.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.community.ui.topic.model.BluedTopic;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedTemplateExtra.class */
public final class FeedTemplateExtra extends BluedEntityBaseExtra {
    private BluedTopic questionnaire_topics;

    public final BluedTopic getQuestionnaire_topics() {
        return this.questionnaire_topics;
    }

    public final void setQuestionnaire_topics(BluedTopic bluedTopic) {
        this.questionnaire_topics = bluedTopic;
    }
}
