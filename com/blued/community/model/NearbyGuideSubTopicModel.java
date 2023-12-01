package com.blued.community.model;

import com.blued.community.ui.topic.model.BluedTopic;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/NearbyGuideSubTopicModel.class */
public final class NearbyGuideSubTopicModel {
    private String button;
    private String subheading;
    private String title;
    private List<BluedTopic> topic;

    public final String getButton() {
        return this.button;
    }

    public final String getSubheading() {
        return this.subheading;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<BluedTopic> getTopic() {
        return this.topic;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final void setSubheading(String str) {
        this.subheading = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTopic(List<BluedTopic> list) {
        this.topic = list;
    }
}
