package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePopCommonModel.class */
public final class LivePopCommonModel implements Serializable {
    private List<LivePopItemModel> pop_text;

    public final List<LivePopItemModel> getPop_text() {
        return this.pop_text;
    }

    public final void setPop_text(List<LivePopItemModel> list) {
        this.pop_text = list;
    }
}
