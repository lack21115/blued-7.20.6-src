package com.blued.community.model;

import com.blued.community.ui.send.model.FeedTemplateTitleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/AttentionFeedPostGuideModel.class */
public final class AttentionFeedPostGuideModel implements Serializable {
    private ArrayList<BluedTopic> admin_topic_data;
    private ArrayList<FeedTemplateTitleModel> questionnaire_data;

    public final ArrayList<BluedTopic> getAdmin_topic_data() {
        return this.admin_topic_data;
    }

    public final ArrayList<FeedTemplateTitleModel> getQuestionnaire_data() {
        return this.questionnaire_data;
    }

    public final void setAdmin_topic_data(ArrayList<BluedTopic> arrayList) {
        this.admin_topic_data = arrayList;
    }

    public final void setQuestionnaire_data(ArrayList<FeedTemplateTitleModel> arrayList) {
        this.questionnaire_data = arrayList;
    }
}
