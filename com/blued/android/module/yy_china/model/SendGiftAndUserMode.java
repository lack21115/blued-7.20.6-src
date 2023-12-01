package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/SendGiftAndUserMode.class */
public final class SendGiftAndUserMode {
    private final String avatar;
    private final boolean isFirstToMicsInTeam;
    private final String name;
    private final int room_role;
    private final YYGiftModel selectedModel;
    private final String uid;

    public SendGiftAndUserMode(YYGiftModel selectedModel, String uid, String name, String avatar, int i, boolean z) {
        Intrinsics.e(selectedModel, "selectedModel");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        this.selectedModel = selectedModel;
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.room_role = i;
        this.isFirstToMicsInTeam = z;
    }

    public static /* synthetic */ SendGiftAndUserMode copy$default(SendGiftAndUserMode sendGiftAndUserMode, YYGiftModel yYGiftModel, String str, String str2, String str3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            yYGiftModel = sendGiftAndUserMode.selectedModel;
        }
        if ((i2 & 2) != 0) {
            str = sendGiftAndUserMode.uid;
        }
        if ((i2 & 4) != 0) {
            str2 = sendGiftAndUserMode.name;
        }
        if ((i2 & 8) != 0) {
            str3 = sendGiftAndUserMode.avatar;
        }
        if ((i2 & 16) != 0) {
            i = sendGiftAndUserMode.room_role;
        }
        if ((i2 & 32) != 0) {
            z = sendGiftAndUserMode.isFirstToMicsInTeam;
        }
        return sendGiftAndUserMode.copy(yYGiftModel, str, str2, str3, i, z);
    }

    public final YYGiftModel component1() {
        return this.selectedModel;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.avatar;
    }

    public final int component5() {
        return this.room_role;
    }

    public final boolean component6() {
        return this.isFirstToMicsInTeam;
    }

    public final SendGiftAndUserMode copy(YYGiftModel selectedModel, String uid, String name, String avatar, int i, boolean z) {
        Intrinsics.e(selectedModel, "selectedModel");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        return new SendGiftAndUserMode(selectedModel, uid, name, avatar, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendGiftAndUserMode) {
            SendGiftAndUserMode sendGiftAndUserMode = (SendGiftAndUserMode) obj;
            return Intrinsics.a(this.selectedModel, sendGiftAndUserMode.selectedModel) && Intrinsics.a((Object) this.uid, (Object) sendGiftAndUserMode.uid) && Intrinsics.a((Object) this.name, (Object) sendGiftAndUserMode.name) && Intrinsics.a((Object) this.avatar, (Object) sendGiftAndUserMode.avatar) && this.room_role == sendGiftAndUserMode.room_role && this.isFirstToMicsInTeam == sendGiftAndUserMode.isFirstToMicsInTeam;
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRoom_role() {
        return this.room_role;
    }

    public final YYGiftModel getSelectedModel() {
        return this.selectedModel;
    }

    public final String getUid() {
        return this.uid;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isFirstToMicsInTeam() {
        return this.isFirstToMicsInTeam;
    }

    public String toString() {
        return "SendGiftAndUserMode(selectedModel=" + this.selectedModel + ", uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ", room_role=" + this.room_role + ", isFirstToMicsInTeam=" + this.isFirstToMicsInTeam + ')';
    }
}
