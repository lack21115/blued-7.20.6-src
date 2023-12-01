package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePocketModels.class */
public final class LivePocketModels implements Serializable {
    private List<LivePocketModel> datas;

    public final List<LivePocketModel> getDatas() {
        return this.datas;
    }

    public final void setDatas(List<LivePocketModel> list) {
        this.datas = list;
    }
}
