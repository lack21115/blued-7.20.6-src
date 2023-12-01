package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgUserCheatModel.class */
public final class MsgUserCheatModel {
    private String alert = "";
    private int risk;

    public final String getAlert() {
        return this.alert;
    }

    public final int getRisk() {
        return this.risk;
    }

    public final void setAlert(String str) {
        Intrinsics.e(str, "<set-?>");
        this.alert = str;
    }

    public final void setRisk(int i) {
        this.risk = i;
    }
}
