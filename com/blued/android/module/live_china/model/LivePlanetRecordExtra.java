package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetRecordExtra.class */
public final class LivePlanetRecordExtra extends BluedEntityBaseExtra implements Serializable {
    private int has_more;

    public final int getHas_more() {
        return this.has_more;
    }

    public final void setHas_more(int i) {
        this.has_more = i;
    }
}
