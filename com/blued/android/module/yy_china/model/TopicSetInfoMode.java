package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/TopicSetInfoMode.class */
public final class TopicSetInfoMode {
    private final String room_id;
    private String theme_id;
    private String topic;
    private String topic_id;

    public TopicSetInfoMode(String room_id, String theme_id, String topic, String topic_id) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(topic_id, "topic_id");
        this.room_id = room_id;
        this.theme_id = theme_id;
        this.topic = topic;
        this.topic_id = topic_id;
    }

    public static /* synthetic */ TopicSetInfoMode copy$default(TopicSetInfoMode topicSetInfoMode, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topicSetInfoMode.room_id;
        }
        if ((i & 2) != 0) {
            str2 = topicSetInfoMode.theme_id;
        }
        if ((i & 4) != 0) {
            str3 = topicSetInfoMode.topic;
        }
        if ((i & 8) != 0) {
            str4 = topicSetInfoMode.topic_id;
        }
        return topicSetInfoMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.room_id;
    }

    public final String component2() {
        return this.theme_id;
    }

    public final String component3() {
        return this.topic;
    }

    public final String component4() {
        return this.topic_id;
    }

    public final TopicSetInfoMode copy(String room_id, String theme_id, String topic, String topic_id) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(topic_id, "topic_id");
        return new TopicSetInfoMode(room_id, theme_id, topic, topic_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopicSetInfoMode) {
            TopicSetInfoMode topicSetInfoMode = (TopicSetInfoMode) obj;
            return Intrinsics.a((Object) this.room_id, (Object) topicSetInfoMode.room_id) && Intrinsics.a((Object) this.theme_id, (Object) topicSetInfoMode.theme_id) && Intrinsics.a((Object) this.topic, (Object) topicSetInfoMode.topic) && Intrinsics.a((Object) this.topic_id, (Object) topicSetInfoMode.topic_id);
        }
        return false;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getTheme_id() {
        return this.theme_id;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getTopic_id() {
        return this.topic_id;
    }

    public int hashCode() {
        return (((((this.room_id.hashCode() * 31) + this.theme_id.hashCode()) * 31) + this.topic.hashCode()) * 31) + this.topic_id.hashCode();
    }

    public final void setTheme_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.theme_id = str;
    }

    public final void setTopic(String str) {
        Intrinsics.e(str, "<set-?>");
        this.topic = str;
    }

    public final void setTopic_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.topic_id = str;
    }

    public String toString() {
        return "TopicSetInfoMode(room_id=" + this.room_id + ", theme_id=" + this.theme_id + ", topic=" + this.topic + ", topic_id=" + this.topic_id + ')';
    }
}
