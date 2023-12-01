package com.soft.blued.ui.msg.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ChatroomRecommendModel.class */
public final class ChatroomRecommendModel {
    private final String avatar;
    private final List<ChatroomRecommendUserModel> current_users;
    private final int experiment;
    private final long room_id;
    private final String room_name;
    private final String source;
    private final String text_content;
    private final long uid;

    public ChatroomRecommendModel(long j, String str, long j2, String str2, String str3, String str4, List<ChatroomRecommendUserModel> current_users, int i) {
        Intrinsics.e(current_users, "current_users");
        this.uid = j;
        this.source = str;
        this.room_id = j2;
        this.room_name = str2;
        this.avatar = str3;
        this.text_content = str4;
        this.current_users = current_users;
        this.experiment = i;
    }

    public static /* synthetic */ ChatroomRecommendModel copy$default(ChatroomRecommendModel chatroomRecommendModel, long j, String str, long j2, String str2, String str3, String str4, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = chatroomRecommendModel.uid;
        }
        if ((i2 & 2) != 0) {
            str = chatroomRecommendModel.source;
        }
        if ((i2 & 4) != 0) {
            j2 = chatroomRecommendModel.room_id;
        }
        if ((i2 & 8) != 0) {
            str2 = chatroomRecommendModel.room_name;
        }
        if ((i2 & 16) != 0) {
            str3 = chatroomRecommendModel.avatar;
        }
        if ((i2 & 32) != 0) {
            str4 = chatroomRecommendModel.text_content;
        }
        if ((i2 & 64) != 0) {
            list = chatroomRecommendModel.current_users;
        }
        if ((i2 & 128) != 0) {
            i = chatroomRecommendModel.experiment;
        }
        return chatroomRecommendModel.copy(j, str, j2, str2, str3, str4, list, i);
    }

    public final long component1() {
        return this.uid;
    }

    public final String component2() {
        return this.source;
    }

    public final long component3() {
        return this.room_id;
    }

    public final String component4() {
        return this.room_name;
    }

    public final String component5() {
        return this.avatar;
    }

    public final String component6() {
        return this.text_content;
    }

    public final List<ChatroomRecommendUserModel> component7() {
        return this.current_users;
    }

    public final int component8() {
        return this.experiment;
    }

    public final ChatroomRecommendModel copy(long j, String str, long j2, String str2, String str3, String str4, List<ChatroomRecommendUserModel> current_users, int i) {
        Intrinsics.e(current_users, "current_users");
        return new ChatroomRecommendModel(j, str, j2, str2, str3, str4, current_users, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatroomRecommendModel) {
            ChatroomRecommendModel chatroomRecommendModel = (ChatroomRecommendModel) obj;
            return this.uid == chatroomRecommendModel.uid && Intrinsics.a((Object) this.source, (Object) chatroomRecommendModel.source) && this.room_id == chatroomRecommendModel.room_id && Intrinsics.a((Object) this.room_name, (Object) chatroomRecommendModel.room_name) && Intrinsics.a((Object) this.avatar, (Object) chatroomRecommendModel.avatar) && Intrinsics.a((Object) this.text_content, (Object) chatroomRecommendModel.text_content) && Intrinsics.a(this.current_users, chatroomRecommendModel.current_users) && this.experiment == chatroomRecommendModel.experiment;
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final List<ChatroomRecommendUserModel> getCurrent_users() {
        return this.current_users;
    }

    public final int getExperiment() {
        return this.experiment;
    }

    public final long getRoom_id() {
        return this.room_id;
    }

    public final String getRoom_name() {
        return this.room_name;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getText_content() {
        return this.text_content;
    }

    public final long getUid() {
        return this.uid;
    }

    public int hashCode() {
        int hashCode = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.uid);
        String str = this.source;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        int hashCode3 = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.room_id);
        String str2 = this.room_name;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.avatar;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.text_content;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + this.current_users.hashCode()) * 31) + this.experiment;
    }

    public String toString() {
        return "ChatroomRecommendModel(uid=" + this.uid + ", source=" + ((Object) this.source) + ", room_id=" + this.room_id + ", room_name=" + ((Object) this.room_name) + ", avatar=" + ((Object) this.avatar) + ", text_content=" + ((Object) this.text_content) + ", current_users=" + this.current_users + ", experiment=" + this.experiment + ')';
    }
}
