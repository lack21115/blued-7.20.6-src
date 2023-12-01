package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.state.VIPCenterAction;
import com.soft.blued.ui.user.state.VIPCenterState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VIPCenterTabPageViewModel.class */
public final class VIPCenterTabPageViewModel extends MVIBaseViewModel<VIPCenterState, VIPCenterAction> {

    /* renamed from: a  reason: collision with root package name */
    private int f34356a;
    private BluedBlackList.privacySettingEntity b;

    private final void c() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new VIPCenterTabPageViewModel$getData$1(this, null), 3, null);
    }

    public final int a() {
        return this.f34356a;
    }

    public final void a(int i) {
        this.f34356a = i;
    }

    public final void a(BluedBlackList.privacySettingEntity privacysettingentity) {
        this.b = privacysettingentity;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(VIPCenterAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof VIPCenterAction.GetVIPData) {
            c();
        }
    }

    public final BluedBlackList.privacySettingEntity b() {
        return this.b;
    }
}
