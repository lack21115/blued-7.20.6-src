package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMTopicSetInfoMode.class */
public final class IMTopicSetInfoMode {
    private String content;
    private final String room_id;
    private String topic;
    private String type_id;
    private String type_name;

    public IMTopicSetInfoMode(String room_id, String type_id, String type_name, String topic, String content) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(type_id, "type_id");
        Intrinsics.e(type_name, "type_name");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(content, "content");
        this.room_id = room_id;
        this.type_id = type_id;
        this.type_name = type_name;
        this.topic = topic;
        this.content = content;
    }

    public static /* synthetic */ IMTopicSetInfoMode copy$default(IMTopicSetInfoMode iMTopicSetInfoMode, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iMTopicSetInfoMode.room_id;
        }
        if ((i & 2) != 0) {
            str2 = iMTopicSetInfoMode.type_id;
        }
        if ((i & 4) != 0) {
            str3 = iMTopicSetInfoMode.type_name;
        }
        if ((i & 8) != 0) {
            str4 = iMTopicSetInfoMode.topic;
        }
        if ((i & 16) != 0) {
            str5 = iMTopicSetInfoMode.content;
        }
        return iMTopicSetInfoMode.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.room_id;
    }

    public final String component2() {
        return this.type_id;
    }

    public final String component3() {
        return this.type_name;
    }

    public final String component4() {
        return this.topic;
    }

    public final String component5() {
        return this.content;
    }

    public final IMTopicSetInfoMode copy(String room_id, String type_id, String type_name, String topic, String content) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(type_id, "type_id");
        Intrinsics.e(type_name, "type_name");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(content, "content");
        return new IMTopicSetInfoMode(room_id, type_id, type_name, topic, content);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMTopicSetInfoMode) {
            IMTopicSetInfoMode iMTopicSetInfoMode = (IMTopicSetInfoMode) obj;
            return Intrinsics.a((Object) this.room_id, (Object) iMTopicSetInfoMode.room_id) && Intrinsics.a((Object) this.type_id, (Object) iMTopicSetInfoMode.type_id) && Intrinsics.a((Object) this.type_name, (Object) iMTopicSetInfoMode.type_name) && Intrinsics.a((Object) this.topic, (Object) iMTopicSetInfoMode.topic) && Intrinsics.a((Object) this.content, (Object) iMTopicSetInfoMode.content);
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getType_id() {
        return this.type_id;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public int hashCode() {
        return (((((((this.room_id.hashCode() * 31) + this.type_id.hashCode()) * 31) + this.type_name.hashCode()) * 31) + this.topic.hashCode()) * 31) + this.content.hashCode();
    }

    public final void setContent(String str) {
        Intrinsics.e(str, "<set-?>");
        this.content = str;
    }

    public final void setTopic(String str) {
        Intrinsics.e(str, "<set-?>");
        this.topic = str;
    }

    public final void setType_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type_id = str;
    }

    public final void setType_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type_name = str;
    }

    public String toString() {
        return "IMTopicSetInfoMode(room_id=" + this.room_id + ", type_id=" + this.type_id + ", type_name=" + this.type_name + ", topic=" + this.topic + ", content=" + this.content + ')';
    }
}
