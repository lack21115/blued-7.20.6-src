package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BehalfExtra.class */
public final class BehalfExtra {
    private int status;
    private String switch_disable_name;
    private String switch_enable_name;

    public BehalfExtra(int i, String switch_enable_name, String switch_disable_name) {
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        this.status = i;
        this.switch_enable_name = switch_enable_name;
        this.switch_disable_name = switch_disable_name;
    }

    public static /* synthetic */ BehalfExtra copy$default(BehalfExtra behalfExtra, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = behalfExtra.status;
        }
        if ((i2 & 2) != 0) {
            str = behalfExtra.switch_enable_name;
        }
        if ((i2 & 4) != 0) {
            str2 = behalfExtra.switch_disable_name;
        }
        return behalfExtra.copy(i, str, str2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.switch_enable_name;
    }

    public final String component3() {
        return this.switch_disable_name;
    }

    public final BehalfExtra copy(int i, String switch_enable_name, String switch_disable_name) {
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        return new BehalfExtra(i, switch_enable_name, switch_disable_name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BehalfExtra) {
            BehalfExtra behalfExtra = (BehalfExtra) obj;
            return this.status == behalfExtra.status && Intrinsics.a((Object) this.switch_enable_name, (Object) behalfExtra.switch_enable_name) && Intrinsics.a((Object) this.switch_disable_name, (Object) behalfExtra.switch_disable_name);
        }
        return false;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSwitch_disable_name() {
        return this.switch_disable_name;
    }

    public final String getSwitch_enable_name() {
        return this.switch_enable_name;
    }

    public int hashCode() {
        return (((this.status * 31) + this.switch_enable_name.hashCode()) * 31) + this.switch_disable_name.hashCode();
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setSwitch_disable_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.switch_disable_name = str;
    }

    public final void setSwitch_enable_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.switch_enable_name = str;
    }

    public String toString() {
        return "BehalfExtra(status=" + this.status + ", switch_enable_name=" + this.switch_enable_name + ", switch_disable_name=" + this.switch_disable_name + ')';
    }
}
