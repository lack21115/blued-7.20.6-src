package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VipInvisibleToUserState.class */
public final class VipInvisibleToUserState implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final InvisibleToUserModel f20623a;

    public VipInvisibleToUserState() {
        this(null, 1, null);
    }

    public VipInvisibleToUserState(InvisibleToUserModel invisibleToUserModel) {
        this.f20623a = invisibleToUserModel;
    }

    public /* synthetic */ VipInvisibleToUserState(InvisibleToUserModel invisibleToUserModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : invisibleToUserModel);
    }

    public final InvisibleToUserModel a() {
        return this.f20623a;
    }

    public final VipInvisibleToUserState a(InvisibleToUserModel invisibleToUserModel) {
        return new VipInvisibleToUserState(invisibleToUserModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VipInvisibleToUserState) && Intrinsics.a(this.f20623a, ((VipInvisibleToUserState) obj).f20623a);
    }

    public int hashCode() {
        InvisibleToUserModel invisibleToUserModel = this.f20623a;
        if (invisibleToUserModel == null) {
            return 0;
        }
        return invisibleToUserModel.hashCode();
    }

    public String toString() {
        return "VipInvisibleToUserState(data=" + this.f20623a + ')';
    }
}
