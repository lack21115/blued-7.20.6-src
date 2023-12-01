package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeExtraModel.class */
public final class YYHomeExtraModel extends BluedEntityBaseExtra {
    private final String experiment_group;
    private int switch_svga;

    public YYHomeExtraModel(String experiment_group, int i) {
        Intrinsics.e(experiment_group, "experiment_group");
        this.experiment_group = experiment_group;
        this.switch_svga = i;
    }

    public /* synthetic */ YYHomeExtraModel(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i);
    }

    public static /* synthetic */ YYHomeExtraModel copy$default(YYHomeExtraModel yYHomeExtraModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYHomeExtraModel.experiment_group;
        }
        if ((i2 & 2) != 0) {
            i = yYHomeExtraModel.switch_svga;
        }
        return yYHomeExtraModel.copy(str, i);
    }

    public final String component1() {
        return this.experiment_group;
    }

    public final int component2() {
        return this.switch_svga;
    }

    public final YYHomeExtraModel copy(String experiment_group, int i) {
        Intrinsics.e(experiment_group, "experiment_group");
        return new YYHomeExtraModel(experiment_group, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYHomeExtraModel) {
            YYHomeExtraModel yYHomeExtraModel = (YYHomeExtraModel) obj;
            return Intrinsics.a((Object) this.experiment_group, (Object) yYHomeExtraModel.experiment_group) && this.switch_svga == yYHomeExtraModel.switch_svga;
        }
        return false;
    }

    public final String getExperiment_group() {
        return this.experiment_group;
    }

    public final int getSwitch_svga() {
        return this.switch_svga;
    }

    public int hashCode() {
        return (this.experiment_group.hashCode() * 31) + this.switch_svga;
    }

    public final void setSwitch_svga(int i) {
        this.switch_svga = i;
    }

    public String toString() {
        return "YYHomeExtraModel(experiment_group=" + this.experiment_group + ", switch_svga=" + this.switch_svga + ')';
    }
}
