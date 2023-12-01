package com.soft.blued.ui.msg_group.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupIdentifyModel.class */
public final class GroupIdentifyModel {
    private String card_name = "";
    private String card_number = "";
    private int verify;
    private int video_verify;

    public final String getCard_name() {
        return this.card_name;
    }

    public final String getCard_number() {
        return this.card_number;
    }

    public final int getVerify() {
        return this.verify;
    }

    public final int getVideo_verify() {
        return this.video_verify;
    }

    public final void setCard_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.card_name = str;
    }

    public final void setCard_number(String str) {
        Intrinsics.e(str, "<set-?>");
        this.card_number = str;
    }

    public final void setVerify(int i) {
        this.verify = i;
    }

    public final void setVideo_verify(int i) {
        this.video_verify = i;
    }
}
