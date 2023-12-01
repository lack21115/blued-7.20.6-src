package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ChatroomRecommendUserModel.class */
public final class ChatroomRecommendUserModel {
    private final String avatar;
    private final long user_id;

    public ChatroomRecommendUserModel() {
        this(0L, null, 3, null);
    }

    public ChatroomRecommendUserModel(long j, String str) {
        this.user_id = j;
        this.avatar = str;
    }

    public /* synthetic */ ChatroomRecommendUserModel(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ ChatroomRecommendUserModel copy$default(ChatroomRecommendUserModel chatroomRecommendUserModel, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = chatroomRecommendUserModel.user_id;
        }
        if ((i & 2) != 0) {
            str = chatroomRecommendUserModel.avatar;
        }
        return chatroomRecommendUserModel.copy(j, str);
    }

    public final long component1() {
        return this.user_id;
    }

    public final String component2() {
        return this.avatar;
    }

    public final ChatroomRecommendUserModel copy(long j, String str) {
        return new ChatroomRecommendUserModel(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatroomRecommendUserModel) {
            ChatroomRecommendUserModel chatroomRecommendUserModel = (ChatroomRecommendUserModel) obj;
            return this.user_id == chatroomRecommendUserModel.user_id && Intrinsics.a((Object) this.avatar, (Object) chatroomRecommendUserModel.avatar);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getUser_id() {
        return this.user_id;
    }

    public int hashCode() {
        int hashCode = C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.user_id);
        String str = this.avatar;
        return (hashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ChatroomRecommendUserModel(user_id=" + this.user_id + ", avatar=" + ((Object) this.avatar) + ')';
    }
}
