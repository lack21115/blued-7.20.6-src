package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveNobleConfigModel.class */
public final class LiveNobleConfigModel extends BluedEntityBaseExtra {
    private int has_target_noble;

    public LiveNobleConfigModel(int i) {
        this.has_target_noble = i;
    }

    public static /* synthetic */ LiveNobleConfigModel copy$default(LiveNobleConfigModel liveNobleConfigModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = liveNobleConfigModel.has_target_noble;
        }
        return liveNobleConfigModel.copy(i);
    }

    public final int component1() {
        return this.has_target_noble;
    }

    public final LiveNobleConfigModel copy(int i) {
        return new LiveNobleConfigModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveNobleConfigModel) && this.has_target_noble == ((LiveNobleConfigModel) obj).has_target_noble;
    }

    public final int getHas_target_noble() {
        return this.has_target_noble;
    }

    public int hashCode() {
        return this.has_target_noble;
    }

    public final void setHas_target_noble(int i) {
        this.has_target_noble = i;
    }

    public String toString() {
        return "LiveNobleConfigModel(has_target_noble=" + this.has_target_noble + ')';
    }
}
