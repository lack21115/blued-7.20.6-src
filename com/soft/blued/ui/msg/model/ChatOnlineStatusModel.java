package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ChatOnlineStatusModel.class */
public final class ChatOnlineStatusModel {
    private String jump_url;
    private int social_status;
    private long source_id;
    private String uid;

    public ChatOnlineStatusModel() {
        this(null, 0, 0L, null, 15, null);
    }

    public ChatOnlineStatusModel(String str, int i, long j, String str2) {
        Intrinsics.e(str, "uid");
        Intrinsics.e(str2, "jump_url");
        this.uid = str;
        this.social_status = i;
        this.source_id = j;
        this.jump_url = str2;
    }

    public /* synthetic */ ChatOnlineStatusModel(String str, int i, long j, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? "" : str2);
    }

    public static /* synthetic */ ChatOnlineStatusModel copy$default(ChatOnlineStatusModel chatOnlineStatusModel, String str, int i, long j, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chatOnlineStatusModel.uid;
        }
        if ((i2 & 2) != 0) {
            i = chatOnlineStatusModel.social_status;
        }
        if ((i2 & 4) != 0) {
            j = chatOnlineStatusModel.source_id;
        }
        if ((i2 & 8) != 0) {
            str2 = chatOnlineStatusModel.jump_url;
        }
        return chatOnlineStatusModel.copy(str, i, j, str2);
    }

    public final String component1() {
        return this.uid;
    }

    public final int component2() {
        return this.social_status;
    }

    public final long component3() {
        return this.source_id;
    }

    public final String component4() {
        return this.jump_url;
    }

    public final ChatOnlineStatusModel copy(String str, int i, long j, String str2) {
        Intrinsics.e(str, "uid");
        Intrinsics.e(str2, "jump_url");
        return new ChatOnlineStatusModel(str, i, j, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatOnlineStatusModel) {
            ChatOnlineStatusModel chatOnlineStatusModel = (ChatOnlineStatusModel) obj;
            return Intrinsics.a(this.uid, chatOnlineStatusModel.uid) && this.social_status == chatOnlineStatusModel.social_status && this.source_id == chatOnlineStatusModel.source_id && Intrinsics.a(this.jump_url, chatOnlineStatusModel.jump_url);
        }
        return false;
    }

    public final String getJump_url() {
        return this.jump_url;
    }

    public final int getSocial_status() {
        return this.social_status;
    }

    public final long getSource_id() {
        return this.source_id;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.uid.hashCode() * 31) + this.social_status) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.source_id)) * 31) + this.jump_url.hashCode();
    }

    public final void setJump_url(String str) {
        Intrinsics.e(str, "<set-?>");
        this.jump_url = str;
    }

    public final void setSocial_status(int i) {
        this.social_status = i;
    }

    public final void setSource_id(long j) {
        this.source_id = j;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public String toString() {
        return "ChatOnlineStatusModel(uid=" + this.uid + ", social_status=" + this.social_status + ", source_id=" + this.source_id + ", jump_url=" + this.jump_url + ')';
    }
}
