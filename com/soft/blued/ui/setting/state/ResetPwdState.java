package com.soft.blued.ui.setting.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.setting.model.ResetPwdModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdState.class */
public final class ResetPwdState implements UiState {
    private final Integer countdown;
    private final Boolean modifySucceed;
    private final ResetPwdModel phoneModel;
    private final Boolean smsClickable;

    public ResetPwdState() {
        this(null, null, null, null, 15, null);
    }

    public ResetPwdState(Integer num, ResetPwdModel resetPwdModel, Boolean bool, Boolean bool2) {
        this.countdown = num;
        this.phoneModel = resetPwdModel;
        this.smsClickable = bool;
        this.modifySucceed = bool2;
    }

    public /* synthetic */ ResetPwdState(Integer num, ResetPwdModel resetPwdModel, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : resetPwdModel, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    public static /* synthetic */ ResetPwdState copy$default(ResetPwdState resetPwdState, Integer num, ResetPwdModel resetPwdModel, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = resetPwdState.countdown;
        }
        if ((i & 2) != 0) {
            resetPwdModel = resetPwdState.phoneModel;
        }
        if ((i & 4) != 0) {
            bool = resetPwdState.smsClickable;
        }
        if ((i & 8) != 0) {
            bool2 = resetPwdState.modifySucceed;
        }
        return resetPwdState.copy(num, resetPwdModel, bool, bool2);
    }

    public final Integer component1() {
        return this.countdown;
    }

    public final ResetPwdModel component2() {
        return this.phoneModel;
    }

    public final Boolean component3() {
        return this.smsClickable;
    }

    public final Boolean component4() {
        return this.modifySucceed;
    }

    public final ResetPwdState copy(Integer num, ResetPwdModel resetPwdModel, Boolean bool, Boolean bool2) {
        return new ResetPwdState(num, resetPwdModel, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResetPwdState) {
            ResetPwdState resetPwdState = (ResetPwdState) obj;
            return Intrinsics.a(this.countdown, resetPwdState.countdown) && Intrinsics.a(this.phoneModel, resetPwdState.phoneModel) && Intrinsics.a(this.smsClickable, resetPwdState.smsClickable) && Intrinsics.a(this.modifySucceed, resetPwdState.modifySucceed);
        }
        return false;
    }

    public final Integer getCountdown() {
        return this.countdown;
    }

    public final Boolean getModifySucceed() {
        return this.modifySucceed;
    }

    public final ResetPwdModel getPhoneModel() {
        return this.phoneModel;
    }

    public final Boolean getSmsClickable() {
        return this.smsClickable;
    }

    public int hashCode() {
        Integer num = this.countdown;
        int i = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        ResetPwdModel resetPwdModel = this.phoneModel;
        int hashCode2 = resetPwdModel == null ? 0 : resetPwdModel.hashCode();
        Boolean bool = this.smsClickable;
        int hashCode3 = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.modifySucceed;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
    }

    public String toString() {
        return "ResetPwdState(countdown=" + this.countdown + ", phoneModel=" + this.phoneModel + ", smsClickable=" + this.smsClickable + ", modifySucceed=" + this.modifySucceed + ')';
    }
}
