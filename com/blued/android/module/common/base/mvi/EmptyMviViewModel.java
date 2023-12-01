package com.blued.android.module.common.base.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/EmptyMviViewModel.class */
public final class EmptyMviViewModel extends MVIBaseViewModel<EmptyState, EmptyAction> {
    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(EmptyAction action) {
        Intrinsics.e(action, "action");
    }
}
