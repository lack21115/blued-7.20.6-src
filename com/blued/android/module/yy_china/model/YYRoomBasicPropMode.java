package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicPropMode.class */
public final class YYRoomBasicPropMode {
    private final YYRoomBasicPropItemMode enter_effects;
    private final YYRoomBasicPropItemMode message_bubble;
    private final YYRoomBasicPropItemMode mounts;
    private final YYRoomBasicPropItemMode pendant;
    private final YYRoomBasicPropItemMode personal_profile;
    private final ArrayList<YYRoomBasicPropItemMode> title;

    public YYRoomBasicPropMode(YYRoomBasicPropItemMode pendant, YYRoomBasicPropItemMode message_bubble, YYRoomBasicPropItemMode enter_effects, YYRoomBasicPropItemMode mounts, YYRoomBasicPropItemMode personal_profile, ArrayList<YYRoomBasicPropItemMode> title) {
        Intrinsics.e(pendant, "pendant");
        Intrinsics.e(message_bubble, "message_bubble");
        Intrinsics.e(enter_effects, "enter_effects");
        Intrinsics.e(mounts, "mounts");
        Intrinsics.e(personal_profile, "personal_profile");
        Intrinsics.e(title, "title");
        this.pendant = pendant;
        this.message_bubble = message_bubble;
        this.enter_effects = enter_effects;
        this.mounts = mounts;
        this.personal_profile = personal_profile;
        this.title = title;
    }

    public static /* synthetic */ YYRoomBasicPropMode copy$default(YYRoomBasicPropMode yYRoomBasicPropMode, YYRoomBasicPropItemMode yYRoomBasicPropItemMode, YYRoomBasicPropItemMode yYRoomBasicPropItemMode2, YYRoomBasicPropItemMode yYRoomBasicPropItemMode3, YYRoomBasicPropItemMode yYRoomBasicPropItemMode4, YYRoomBasicPropItemMode yYRoomBasicPropItemMode5, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            yYRoomBasicPropItemMode = yYRoomBasicPropMode.pendant;
        }
        if ((i & 2) != 0) {
            yYRoomBasicPropItemMode2 = yYRoomBasicPropMode.message_bubble;
        }
        if ((i & 4) != 0) {
            yYRoomBasicPropItemMode3 = yYRoomBasicPropMode.enter_effects;
        }
        if ((i & 8) != 0) {
            yYRoomBasicPropItemMode4 = yYRoomBasicPropMode.mounts;
        }
        if ((i & 16) != 0) {
            yYRoomBasicPropItemMode5 = yYRoomBasicPropMode.personal_profile;
        }
        if ((i & 32) != 0) {
            arrayList = yYRoomBasicPropMode.title;
        }
        return yYRoomBasicPropMode.copy(yYRoomBasicPropItemMode, yYRoomBasicPropItemMode2, yYRoomBasicPropItemMode3, yYRoomBasicPropItemMode4, yYRoomBasicPropItemMode5, arrayList);
    }

    public final YYRoomBasicPropItemMode component1() {
        return this.pendant;
    }

    public final YYRoomBasicPropItemMode component2() {
        return this.message_bubble;
    }

    public final YYRoomBasicPropItemMode component3() {
        return this.enter_effects;
    }

    public final YYRoomBasicPropItemMode component4() {
        return this.mounts;
    }

    public final YYRoomBasicPropItemMode component5() {
        return this.personal_profile;
    }

    public final ArrayList<YYRoomBasicPropItemMode> component6() {
        return this.title;
    }

    public final YYRoomBasicPropMode copy(YYRoomBasicPropItemMode pendant, YYRoomBasicPropItemMode message_bubble, YYRoomBasicPropItemMode enter_effects, YYRoomBasicPropItemMode mounts, YYRoomBasicPropItemMode personal_profile, ArrayList<YYRoomBasicPropItemMode> title) {
        Intrinsics.e(pendant, "pendant");
        Intrinsics.e(message_bubble, "message_bubble");
        Intrinsics.e(enter_effects, "enter_effects");
        Intrinsics.e(mounts, "mounts");
        Intrinsics.e(personal_profile, "personal_profile");
        Intrinsics.e(title, "title");
        return new YYRoomBasicPropMode(pendant, message_bubble, enter_effects, mounts, personal_profile, title);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicPropMode) {
            YYRoomBasicPropMode yYRoomBasicPropMode = (YYRoomBasicPropMode) obj;
            return Intrinsics.a(this.pendant, yYRoomBasicPropMode.pendant) && Intrinsics.a(this.message_bubble, yYRoomBasicPropMode.message_bubble) && Intrinsics.a(this.enter_effects, yYRoomBasicPropMode.enter_effects) && Intrinsics.a(this.mounts, yYRoomBasicPropMode.mounts) && Intrinsics.a(this.personal_profile, yYRoomBasicPropMode.personal_profile) && Intrinsics.a(this.title, yYRoomBasicPropMode.title);
        }
        return false;
    }

    public final YYRoomBasicPropItemMode getEnter_effects() {
        return this.enter_effects;
    }

    public final YYRoomBasicPropItemMode getMessage_bubble() {
        return this.message_bubble;
    }

    public final YYRoomBasicPropItemMode getMounts() {
        return this.mounts;
    }

    public final YYRoomBasicPropItemMode getPendant() {
        return this.pendant;
    }

    public final YYRoomBasicPropItemMode getPersonal_profile() {
        return this.personal_profile;
    }

    public final ArrayList<YYRoomBasicPropItemMode> getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.pendant.hashCode() * 31) + this.message_bubble.hashCode()) * 31) + this.enter_effects.hashCode()) * 31) + this.mounts.hashCode()) * 31) + this.personal_profile.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "YYRoomBasicPropMode(pendant=" + this.pendant + ", message_bubble=" + this.message_bubble + ", enter_effects=" + this.enter_effects + ", mounts=" + this.mounts + ", personal_profile=" + this.personal_profile + ", title=" + this.title + ')';
    }
}
