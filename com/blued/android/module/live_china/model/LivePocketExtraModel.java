package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePocketExtraModel.class */
public final class LivePocketExtraModel extends BluedEntityBaseExtra implements Serializable {
    private List<LivePocketModel> in_use;

    public final List<LivePocketModel> getIn_use() {
        return this.in_use;
    }

    public final void setIn_use(List<LivePocketModel> list) {
        this.in_use = list;
    }
}
