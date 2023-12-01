package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveOnLineBehalfExtra.class */
public final class LiveOnLineBehalfExtra {
    private String popover_desc;
    private String popover_title;
    private boolean status;
    private String switch_disable_name;
    private String switch_enable_name;

    public LiveOnLineBehalfExtra(boolean z, String switch_enable_name, String switch_disable_name, String popover_title, String popover_desc) {
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        Intrinsics.e(popover_title, "popover_title");
        Intrinsics.e(popover_desc, "popover_desc");
        this.status = z;
        this.switch_enable_name = switch_enable_name;
        this.switch_disable_name = switch_disable_name;
        this.popover_title = popover_title;
        this.popover_desc = popover_desc;
    }

    public static /* synthetic */ LiveOnLineBehalfExtra copy$default(LiveOnLineBehalfExtra liveOnLineBehalfExtra, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = liveOnLineBehalfExtra.status;
        }
        if ((i & 2) != 0) {
            str = liveOnLineBehalfExtra.switch_enable_name;
        }
        if ((i & 4) != 0) {
            str2 = liveOnLineBehalfExtra.switch_disable_name;
        }
        if ((i & 8) != 0) {
            str3 = liveOnLineBehalfExtra.popover_title;
        }
        if ((i & 16) != 0) {
            str4 = liveOnLineBehalfExtra.popover_desc;
        }
        return liveOnLineBehalfExtra.copy(z, str, str2, str3, str4);
    }

    public final boolean component1() {
        return this.status;
    }

    public final String component2() {
        return this.switch_enable_name;
    }

    public final String component3() {
        return this.switch_disable_name;
    }

    public final String component4() {
        return this.popover_title;
    }

    public final String component5() {
        return this.popover_desc;
    }

    public final LiveOnLineBehalfExtra copy(boolean z, String switch_enable_name, String switch_disable_name, String popover_title, String popover_desc) {
        Intrinsics.e(switch_enable_name, "switch_enable_name");
        Intrinsics.e(switch_disable_name, "switch_disable_name");
        Intrinsics.e(popover_title, "popover_title");
        Intrinsics.e(popover_desc, "popover_desc");
        return new LiveOnLineBehalfExtra(z, switch_enable_name, switch_disable_name, popover_title, popover_desc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveOnLineBehalfExtra) {
            LiveOnLineBehalfExtra liveOnLineBehalfExtra = (LiveOnLineBehalfExtra) obj;
            return this.status == liveOnLineBehalfExtra.status && Intrinsics.a((Object) this.switch_enable_name, (Object) liveOnLineBehalfExtra.switch_enable_name) && Intrinsics.a((Object) this.switch_disable_name, (Object) liveOnLineBehalfExtra.switch_disable_name) && Intrinsics.a((Object) this.popover_title, (Object) liveOnLineBehalfExtra.popover_title) && Intrinsics.a((Object) this.popover_desc, (Object) liveOnLineBehalfExtra.popover_desc);
        }
        return false;
    }

    public final String getPopover_desc() {
        return this.popover_desc;
    }

    public final String getPopover_title() {
        return this.popover_title;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getSwitch_disable_name() {
        return this.switch_disable_name;
    }

    public final String getSwitch_enable_name() {
        return this.switch_enable_name;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void setPopover_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popover_desc = str;
    }

    public final void setPopover_title(String str) {
        Intrinsics.e(str, "<set-?>");
        this.popover_title = str;
    }

    public final void setStatus(boolean z) {
        this.status = z;
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
        return "LiveOnLineBehalfExtra(status=" + this.status + ", switch_enable_name=" + this.switch_enable_name + ", switch_disable_name=" + this.switch_disable_name + ", popover_title=" + this.popover_title + ", popover_desc=" + this.popover_desc + ')';
    }
}
