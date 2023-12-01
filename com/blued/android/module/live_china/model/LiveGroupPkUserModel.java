package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGroupPkUserModel.class */
public final class LiveGroupPkUserModel implements Serializable {
    private int group_id;
    private long uid;

    public LiveGroupPkUserModel(long j, int i) {
        this.uid = j;
        this.group_id = i;
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void setGroup_id(int i) {
        this.group_id = i;
    }

    public final void setUid(long j) {
        this.uid = j;
    }
}
