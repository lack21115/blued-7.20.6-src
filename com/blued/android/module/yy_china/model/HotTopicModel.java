package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HotTopicModel.class */
public final class HotTopicModel {
    private final String topic;
    private final String topic_id;

    public HotTopicModel(String topic_id, String topic) {
        Intrinsics.e(topic_id, "topic_id");
        Intrinsics.e(topic, "topic");
        this.topic_id = topic_id;
        this.topic = topic;
    }

    public static /* synthetic */ HotTopicModel copy$default(HotTopicModel hotTopicModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hotTopicModel.topic_id;
        }
        if ((i & 2) != 0) {
            str2 = hotTopicModel.topic;
        }
        return hotTopicModel.copy(str, str2);
    }

    public final String component1() {
        return this.topic_id;
    }

    public final String component2() {
        return this.topic;
    }

    public final HotTopicModel copy(String topic_id, String topic) {
        Intrinsics.e(topic_id, "topic_id");
        Intrinsics.e(topic, "topic");
        return new HotTopicModel(topic_id, topic);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HotTopicModel) {
            HotTopicModel hotTopicModel = (HotTopicModel) obj;
            return Intrinsics.a((Object) this.topic_id, (Object) hotTopicModel.topic_id) && Intrinsics.a((Object) this.topic, (Object) hotTopicModel.topic);
        }
        return false;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getTopic_id() {
        return this.topic_id;
    }

    public int hashCode() {
        return (this.topic_id.hashCode() * 31) + this.topic.hashCode();
    }

    public String toString() {
        return "HotTopicModel(topic_id=" + this.topic_id + ", topic=" + this.topic + ')';
    }
}
