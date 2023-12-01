package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/VoiceSkinInfoMode.class */
public final class VoiceSkinInfoMode {
    private final String icon;
    private final String icon_small;

    public VoiceSkinInfoMode(String icon, String icon_small) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(icon_small, "icon_small");
        this.icon = icon;
        this.icon_small = icon_small;
    }

    public static /* synthetic */ VoiceSkinInfoMode copy$default(VoiceSkinInfoMode voiceSkinInfoMode, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceSkinInfoMode.icon;
        }
        if ((i & 2) != 0) {
            str2 = voiceSkinInfoMode.icon_small;
        }
        return voiceSkinInfoMode.copy(str, str2);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.icon_small;
    }

    public final VoiceSkinInfoMode copy(String icon, String icon_small) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(icon_small, "icon_small");
        return new VoiceSkinInfoMode(icon, icon_small);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VoiceSkinInfoMode) {
            VoiceSkinInfoMode voiceSkinInfoMode = (VoiceSkinInfoMode) obj;
            return Intrinsics.a((Object) this.icon, (Object) voiceSkinInfoMode.icon) && Intrinsics.a((Object) this.icon_small, (Object) voiceSkinInfoMode.icon_small);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_small() {
        return this.icon_small;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.icon_small.hashCode();
    }

    public String toString() {
        return "VoiceSkinInfoMode(icon=" + this.icon + ", icon_small=" + this.icon_small + ')';
    }
}
