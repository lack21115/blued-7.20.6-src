package com.soft.blued.ui.user.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.state.VIPCenterAction;
import com.soft.blued.ui.user.state.VIPCenterState;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VIPCenterTabPageViewModel.class */
public final class VIPCenterTabPageViewModel extends MVIBaseViewModel<VIPCenterState, VIPCenterAction> {

    /* renamed from: a  reason: collision with root package name */
    private int f20665a;
    private BluedBlackList.privacySettingEntity b;

    private final void c() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new VIPCenterTabPageViewModel$getData$1(this, null), 3, (Object) null);
    }

    public final int a() {
        return this.f20665a;
    }

    public final void a(int i) {
        this.f20665a = i;
    }

    public final void a(BluedBlackList.privacySettingEntity privacysettingentity) {
        this.b = privacysettingentity;
    }

    /* renamed from: a */
    public void dispatchAction(VIPCenterAction vIPCenterAction) {
        Intrinsics.e(vIPCenterAction, "action");
        if (vIPCenterAction instanceof VIPCenterAction.GetVIPData) {
            c();
        }
    }

    public final BluedBlackList.privacySettingEntity b() {
        return this.b;
    }
}
