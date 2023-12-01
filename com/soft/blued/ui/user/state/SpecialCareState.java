package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/SpecialCareState.class */
public final class SpecialCareState implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final InvisibleToUserModel f34309a;

    public SpecialCareState() {
        this(null, 1, null);
    }

    public SpecialCareState(InvisibleToUserModel invisibleToUserModel) {
        this.f34309a = invisibleToUserModel;
    }

    public /* synthetic */ SpecialCareState(InvisibleToUserModel invisibleToUserModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : invisibleToUserModel);
    }

    public final InvisibleToUserModel a() {
        return this.f34309a;
    }

    public final SpecialCareState a(InvisibleToUserModel invisibleToUserModel) {
        return new SpecialCareState(invisibleToUserModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SpecialCareState) && Intrinsics.a(this.f34309a, ((SpecialCareState) obj).f34309a);
    }

    public int hashCode() {
        InvisibleToUserModel invisibleToUserModel = this.f34309a;
        if (invisibleToUserModel == null) {
            return 0;
        }
        return invisibleToUserModel.hashCode();
    }

    public String toString() {
        return "SpecialCareState(data=" + this.f34309a + ')';
    }
}
