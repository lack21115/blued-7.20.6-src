package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HotTopicItemModel.class */
public final class HotTopicItemModel implements MultiItemEntity {
    private final String avatar;
    private final String name;
    private final String room_id;
    private final String room_online;
    private final String topic;

    public HotTopicItemModel(String name, String topic, String avatar, String room_online, String room_id) {
        Intrinsics.e(name, "name");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(room_online, "room_online");
        Intrinsics.e(room_id, "room_id");
        this.name = name;
        this.topic = topic;
        this.avatar = avatar;
        this.room_online = room_online;
        this.room_id = room_id;
    }

    public static /* synthetic */ HotTopicItemModel copy$default(HotTopicItemModel hotTopicItemModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hotTopicItemModel.name;
        }
        if ((i & 2) != 0) {
            str2 = hotTopicItemModel.topic;
        }
        if ((i & 4) != 0) {
            str3 = hotTopicItemModel.avatar;
        }
        if ((i & 8) != 0) {
            str4 = hotTopicItemModel.room_online;
        }
        if ((i & 16) != 0) {
            str5 = hotTopicItemModel.room_id;
        }
        return hotTopicItemModel.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.topic;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.room_online;
    }

    public final String component5() {
        return this.room_id;
    }

    public final HotTopicItemModel copy(String name, String topic, String avatar, String room_online, String room_id) {
        Intrinsics.e(name, "name");
        Intrinsics.e(topic, "topic");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(room_online, "room_online");
        Intrinsics.e(room_id, "room_id");
        return new HotTopicItemModel(name, topic, avatar, room_online, room_id);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HotTopicItemModel) {
            HotTopicItemModel hotTopicItemModel = (HotTopicItemModel) obj;
            return Intrinsics.a((Object) this.name, (Object) hotTopicItemModel.name) && Intrinsics.a((Object) this.topic, (Object) hotTopicItemModel.topic) && Intrinsics.a((Object) this.avatar, (Object) hotTopicItemModel.avatar) && Intrinsics.a((Object) this.room_online, (Object) hotTopicItemModel.room_online) && Intrinsics.a((Object) this.room_id, (Object) hotTopicItemModel.room_id);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public int getItemType() {
        return 0;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final String getRoom_online() {
        return this.room_online;
    }

    public final String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.topic.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.room_online.hashCode()) * 31) + this.room_id.hashCode();
    }

    public String toString() {
        return "HotTopicItemModel(name=" + this.name + ", topic=" + this.topic + ", avatar=" + this.avatar + ", room_online=" + this.room_online + ", room_id=" + this.room_id + ')';
    }
}
