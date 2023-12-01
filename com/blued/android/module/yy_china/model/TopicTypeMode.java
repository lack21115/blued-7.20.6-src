package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/TopicTypeMode.class */
public final class TopicTypeMode {
    private final String theme_id;
    private final String theme_name;
    private final ArrayList<TopicTypeListMode> topic_lists;

    public TopicTypeMode(String theme_id, String theme_name, ArrayList<TopicTypeListMode> topic_lists) {
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(topic_lists, "topic_lists");
        this.theme_id = theme_id;
        this.theme_name = theme_name;
        this.topic_lists = topic_lists;
    }

    public static /* synthetic */ TopicTypeMode copy$default(TopicTypeMode topicTypeMode, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topicTypeMode.theme_id;
        }
        if ((i & 2) != 0) {
            str2 = topicTypeMode.theme_name;
        }
        if ((i & 4) != 0) {
            arrayList = topicTypeMode.topic_lists;
        }
        return topicTypeMode.copy(str, str2, arrayList);
    }

    public final String component1() {
        return this.theme_id;
    }

    public final String component2() {
        return this.theme_name;
    }

    public final ArrayList<TopicTypeListMode> component3() {
        return this.topic_lists;
    }

    public final TopicTypeMode copy(String theme_id, String theme_name, ArrayList<TopicTypeListMode> topic_lists) {
        Intrinsics.e(theme_id, "theme_id");
        Intrinsics.e(theme_name, "theme_name");
        Intrinsics.e(topic_lists, "topic_lists");
        return new TopicTypeMode(theme_id, theme_name, topic_lists);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopicTypeMode) {
            TopicTypeMode topicTypeMode = (TopicTypeMode) obj;
            return Intrinsics.a((Object) this.theme_id, (Object) topicTypeMode.theme_id) && Intrinsics.a((Object) this.theme_name, (Object) topicTypeMode.theme_name) && Intrinsics.a(this.topic_lists, topicTypeMode.topic_lists);
        }
        return false;
    }

    public final String getTheme_id() {
        return this.theme_id;
    }

    public final String getTheme_name() {
        return this.theme_name;
    }

    public final ArrayList<TopicTypeListMode> getTopic_lists() {
        return this.topic_lists;
    }

    public int hashCode() {
        return (((this.theme_id.hashCode() * 31) + this.theme_name.hashCode()) * 31) + this.topic_lists.hashCode();
    }

    public String toString() {
        return "TopicTypeMode(theme_id=" + this.theme_id + ", theme_name=" + this.theme_name + ", topic_lists=" + this.topic_lists + ')';
    }
}
