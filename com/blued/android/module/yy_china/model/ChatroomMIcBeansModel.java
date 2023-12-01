package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ChatroomMIcBeansModel.class */
public final class ChatroomMIcBeansModel {
    private final ArrayList<MIcBeansInfoModel> mic_beans_info;
    private final String room_id;
    private final int status;
    private final String uid;

    public ChatroomMIcBeansModel(String room_id, String uid, int i, ArrayList<MIcBeansInfoModel> mic_beans_info) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(mic_beans_info, "mic_beans_info");
        this.room_id = room_id;
        this.uid = uid;
        this.status = i;
        this.mic_beans_info = mic_beans_info;
    }

    public static /* synthetic */ ChatroomMIcBeansModel copy$default(ChatroomMIcBeansModel chatroomMIcBeansModel, String str, String str2, int i, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chatroomMIcBeansModel.room_id;
        }
        if ((i2 & 2) != 0) {
            str2 = chatroomMIcBeansModel.uid;
        }
        if ((i2 & 4) != 0) {
            i = chatroomMIcBeansModel.status;
        }
        if ((i2 & 8) != 0) {
            arrayList = chatroomMIcBeansModel.mic_beans_info;
        }
        return chatroomMIcBeansModel.copy(str, str2, i, arrayList);
    }

    public final String component1() {
        return this.room_id;
    }

    public final String component2() {
        return this.uid;
    }

    public final int component3() {
        return this.status;
    }

    public final ArrayList<MIcBeansInfoModel> component4() {
        return this.mic_beans_info;
    }

    public final ChatroomMIcBeansModel copy(String room_id, String uid, int i, ArrayList<MIcBeansInfoModel> mic_beans_info) {
        Intrinsics.e(room_id, "room_id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(mic_beans_info, "mic_beans_info");
        return new ChatroomMIcBeansModel(room_id, uid, i, mic_beans_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatroomMIcBeansModel) {
            ChatroomMIcBeansModel chatroomMIcBeansModel = (ChatroomMIcBeansModel) obj;
            return Intrinsics.a((Object) this.room_id, (Object) chatroomMIcBeansModel.room_id) && Intrinsics.a((Object) this.uid, (Object) chatroomMIcBeansModel.uid) && this.status == chatroomMIcBeansModel.status && Intrinsics.a(this.mic_beans_info, chatroomMIcBeansModel.mic_beans_info);
        }
        return false;
    }

    public final ArrayList<MIcBeansInfoModel> getMic_beans_info() {
        return this.mic_beans_info;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.room_id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.status) * 31) + this.mic_beans_info.hashCode();
    }

    public String toString() {
        return "ChatroomMIcBeansModel(room_id=" + this.room_id + ", uid=" + this.uid + ", status=" + this.status + ", mic_beans_info=" + this.mic_beans_info + ')';
    }
}
