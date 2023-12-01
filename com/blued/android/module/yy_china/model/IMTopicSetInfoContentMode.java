package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMTopicSetInfoContentMode.class */
public final class IMTopicSetInfoContentMode {
    private final String topic_id;

    public IMTopicSetInfoContentMode(String topic_id) {
        Intrinsics.e(topic_id, "topic_id");
        this.topic_id = topic_id;
    }

    public static /* synthetic */ IMTopicSetInfoContentMode copy$default(IMTopicSetInfoContentMode iMTopicSetInfoContentMode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMTopicSetInfoContentMode.topic_id;
        }
        return iMTopicSetInfoContentMode.copy(str);
    }

    public final String component1() {
        return this.topic_id;
    }

    public final IMTopicSetInfoContentMode copy(String topic_id) {
        Intrinsics.e(topic_id, "topic_id");
        return new IMTopicSetInfoContentMode(topic_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMTopicSetInfoContentMode) && Intrinsics.a((Object) this.topic_id, (Object) ((IMTopicSetInfoContentMode) obj).topic_id);
    }

    public final String getTopic_id() {
        return this.topic_id;
    }

    public int hashCode() {
        return this.topic_id.hashCode();
    }

    public String toString() {
        return "IMTopicSetInfoContentMode(topic_id=" + this.topic_id + ')';
    }
}
