package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VIPCenterState.class */
public final class VIPCenterState implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final VIPCenterNewModel f20620a;

    public VIPCenterState() {
        this(null, 1, null);
    }

    public VIPCenterState(VIPCenterNewModel vIPCenterNewModel) {
        this.f20620a = vIPCenterNewModel;
    }

    public /* synthetic */ VIPCenterState(VIPCenterNewModel vIPCenterNewModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : vIPCenterNewModel);
    }

    public final VIPCenterNewModel a() {
        return this.f20620a;
    }

    public final VIPCenterState a(VIPCenterNewModel vIPCenterNewModel) {
        return new VIPCenterState(vIPCenterNewModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VIPCenterState) && Intrinsics.a(this.f20620a, ((VIPCenterState) obj).f20620a);
    }

    public int hashCode() {
        VIPCenterNewModel vIPCenterNewModel = this.f20620a;
        if (vIPCenterNewModel == null) {
            return 0;
        }
        return vIPCenterNewModel.hashCode();
    }

    public String toString() {
        return "VIPCenterState(model=" + this.f20620a + ')';
    }
}
