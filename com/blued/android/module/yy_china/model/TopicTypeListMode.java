package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/TopicTypeListMode.class */
public final class TopicTypeListMode {
    private final String id;
    private final String is_default;
    private final String topic;

    public TopicTypeListMode(String id, String topic, String is_default) {
        Intrinsics.e(id, "id");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(is_default, "is_default");
        this.id = id;
        this.topic = topic;
        this.is_default = is_default;
    }

    public static /* synthetic */ TopicTypeListMode copy$default(TopicTypeListMode topicTypeListMode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topicTypeListMode.id;
        }
        if ((i & 2) != 0) {
            str2 = topicTypeListMode.topic;
        }
        if ((i & 4) != 0) {
            str3 = topicTypeListMode.is_default;
        }
        return topicTypeListMode.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.topic;
    }

    public final String component3() {
        return this.is_default;
    }

    public final TopicTypeListMode copy(String id, String topic, String is_default) {
        Intrinsics.e(id, "id");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(is_default, "is_default");
        return new TopicTypeListMode(id, topic, is_default);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopicTypeListMode) {
            TopicTypeListMode topicTypeListMode = (TopicTypeListMode) obj;
            return Intrinsics.a((Object) this.id, (Object) topicTypeListMode.id) && Intrinsics.a((Object) this.topic, (Object) topicTypeListMode.topic) && Intrinsics.a((Object) this.is_default, (Object) topicTypeListMode.is_default);
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.topic.hashCode()) * 31) + this.is_default.hashCode();
    }

    public final String is_default() {
        return this.is_default;
    }

    public String toString() {
        return "TopicTypeListMode(id=" + this.id + ", topic=" + this.topic + ", is_default=" + this.is_default + ')';
    }
}
