package com.blued.android.module.live_china.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveEffectModel.class */
public class LiveEffectModel implements Serializable {
    public int beans;
    public long effect_id;
    public long expire;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveEffectModel) {
            LiveEffectModel liveEffectModel = (LiveEffectModel) obj;
            return liveEffectModel.effect_id == this.effect_id && liveEffectModel.beans == this.beans && liveEffectModel.expire == this.expire;
        }
        return false;
    }
}
