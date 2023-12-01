package com.soft.blued.ui.mine.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.mine.model.MinePageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/state/TouristState.class */
public final class TouristState implements UiState {
    private final MinePageModel data;

    public TouristState() {
        this(null, 1, null);
    }

    public TouristState(MinePageModel minePageModel) {
        this.data = minePageModel;
    }

    public /* synthetic */ TouristState(MinePageModel minePageModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : minePageModel);
    }

    public static /* synthetic */ TouristState copy$default(TouristState touristState, MinePageModel minePageModel, int i, Object obj) {
        if ((i & 1) != 0) {
            minePageModel = touristState.data;
        }
        return touristState.copy(minePageModel);
    }

    public final MinePageModel component1() {
        return this.data;
    }

    public final TouristState copy(MinePageModel minePageModel) {
        return new TouristState(minePageModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TouristState) && Intrinsics.a(this.data, ((TouristState) obj).data);
    }

    public final MinePageModel getData() {
        return this.data;
    }

    public int hashCode() {
        MinePageModel minePageModel = this.data;
        if (minePageModel == null) {
            return 0;
        }
        return minePageModel.hashCode();
    }

    public String toString() {
        return "TouristState(data=" + this.data + ')';
    }
}
