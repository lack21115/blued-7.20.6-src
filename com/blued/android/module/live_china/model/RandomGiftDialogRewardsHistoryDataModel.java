package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RandomGiftDialogRewardsHistoryDataModel.class */
public final class RandomGiftDialogRewardsHistoryDataModel implements Serializable {
    private String title = "";
    private String time = "";

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTime(String str) {
        Intrinsics.e(str, "<set-?>");
        this.time = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
