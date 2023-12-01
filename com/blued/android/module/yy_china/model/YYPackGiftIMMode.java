package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftIMMode.class */
public final class YYPackGiftIMMode {
    private final String content;
    private final YYGlobalMsgMarqueeModel full_server_notification;
    private final long round_end_time;
    private final String special_effect_result;
    private final int status;
    private final String trigger_avatar;
    private final String trigger_name;
    private final String trigger_uid;

    public YYPackGiftIMMode(long j, int i, String special_effect_result, String content, String trigger_avatar, String trigger_uid, String trigger_name, YYGlobalMsgMarqueeModel full_server_notification) {
        Intrinsics.e(special_effect_result, "special_effect_result");
        Intrinsics.e(content, "content");
        Intrinsics.e(trigger_avatar, "trigger_avatar");
        Intrinsics.e(trigger_uid, "trigger_uid");
        Intrinsics.e(trigger_name, "trigger_name");
        Intrinsics.e(full_server_notification, "full_server_notification");
        this.round_end_time = j;
        this.status = i;
        this.special_effect_result = special_effect_result;
        this.content = content;
        this.trigger_avatar = trigger_avatar;
        this.trigger_uid = trigger_uid;
        this.trigger_name = trigger_name;
        this.full_server_notification = full_server_notification;
    }

    public static /* synthetic */ YYPackGiftIMMode copy$default(YYPackGiftIMMode yYPackGiftIMMode, long j, int i, String str, String str2, String str3, String str4, String str5, YYGlobalMsgMarqueeModel yYGlobalMsgMarqueeModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = yYPackGiftIMMode.round_end_time;
        }
        if ((i2 & 2) != 0) {
            i = yYPackGiftIMMode.status;
        }
        if ((i2 & 4) != 0) {
            str = yYPackGiftIMMode.special_effect_result;
        }
        if ((i2 & 8) != 0) {
            str2 = yYPackGiftIMMode.content;
        }
        if ((i2 & 16) != 0) {
            str3 = yYPackGiftIMMode.trigger_avatar;
        }
        if ((i2 & 32) != 0) {
            str4 = yYPackGiftIMMode.trigger_uid;
        }
        if ((i2 & 64) != 0) {
            str5 = yYPackGiftIMMode.trigger_name;
        }
        if ((i2 & 128) != 0) {
            yYGlobalMsgMarqueeModel = yYPackGiftIMMode.full_server_notification;
        }
        return yYPackGiftIMMode.copy(j, i, str, str2, str3, str4, str5, yYGlobalMsgMarqueeModel);
    }

    public final long component1() {
        return this.round_end_time;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.special_effect_result;
    }

    public final String component4() {
        return this.content;
    }

    public final String component5() {
        return this.trigger_avatar;
    }

    public final String component6() {
        return this.trigger_uid;
    }

    public final String component7() {
        return this.trigger_name;
    }

    public final YYGlobalMsgMarqueeModel component8() {
        return this.full_server_notification;
    }

    public final YYPackGiftIMMode copy(long j, int i, String special_effect_result, String content, String trigger_avatar, String trigger_uid, String trigger_name, YYGlobalMsgMarqueeModel full_server_notification) {
        Intrinsics.e(special_effect_result, "special_effect_result");
        Intrinsics.e(content, "content");
        Intrinsics.e(trigger_avatar, "trigger_avatar");
        Intrinsics.e(trigger_uid, "trigger_uid");
        Intrinsics.e(trigger_name, "trigger_name");
        Intrinsics.e(full_server_notification, "full_server_notification");
        return new YYPackGiftIMMode(j, i, special_effect_result, content, trigger_avatar, trigger_uid, trigger_name, full_server_notification);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftIMMode) {
            YYPackGiftIMMode yYPackGiftIMMode = (YYPackGiftIMMode) obj;
            return this.round_end_time == yYPackGiftIMMode.round_end_time && this.status == yYPackGiftIMMode.status && Intrinsics.a((Object) this.special_effect_result, (Object) yYPackGiftIMMode.special_effect_result) && Intrinsics.a((Object) this.content, (Object) yYPackGiftIMMode.content) && Intrinsics.a((Object) this.trigger_avatar, (Object) yYPackGiftIMMode.trigger_avatar) && Intrinsics.a((Object) this.trigger_uid, (Object) yYPackGiftIMMode.trigger_uid) && Intrinsics.a((Object) this.trigger_name, (Object) yYPackGiftIMMode.trigger_name) && Intrinsics.a(this.full_server_notification, yYPackGiftIMMode.full_server_notification);
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final YYGlobalMsgMarqueeModel getFull_server_notification() {
        return this.full_server_notification;
    }

    public final long getRound_end_time() {
        return this.round_end_time;
    }

    public final String getSpecial_effect_result() {
        return this.special_effect_result;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTrigger_avatar() {
        return this.trigger_avatar;
    }

    public final String getTrigger_name() {
        return this.trigger_name;
    }

    public final String getTrigger_uid() {
        return this.trigger_uid;
    }

    public int hashCode() {
        return ((((((((((((($r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.round_end_time) * 31) + this.status) * 31) + this.special_effect_result.hashCode()) * 31) + this.content.hashCode()) * 31) + this.trigger_avatar.hashCode()) * 31) + this.trigger_uid.hashCode()) * 31) + this.trigger_name.hashCode()) * 31) + this.full_server_notification.hashCode();
    }

    public String toString() {
        return "YYPackGiftIMMode(round_end_time=" + this.round_end_time + ", status=" + this.status + ", special_effect_result=" + this.special_effect_result + ", content=" + this.content + ", trigger_avatar=" + this.trigger_avatar + ", trigger_uid=" + this.trigger_uid + ", trigger_name=" + this.trigger_name + ", full_server_notification=" + this.full_server_notification + ')';
    }
}
