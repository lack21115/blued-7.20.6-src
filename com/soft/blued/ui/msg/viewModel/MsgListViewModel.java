package com.soft.blued.ui.msg.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg.model.MsgListCheatModel;
import com.soft.blued.ui.msg.model.MsgUserCheatModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/MsgListViewModel.class */
public final class MsgListViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private MutableLiveData<MsgListCheatModel> f18922a = new MutableLiveData<>();
    private MutableLiveData<MsgUserCheatModel> b = new MutableLiveData<>();

    public final void a(String str) {
        Intrinsics.e(str, "uid");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MsgListViewModel$getCheatUserInfo$1(str, this, null), 3, (Object) null);
    }

    public final MutableLiveData<MsgListCheatModel> d() {
        return this.f18922a;
    }

    public final MutableLiveData<MsgUserCheatModel> e() {
        return this.b;
    }

    public final void f() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new MsgListViewModel$getCheatDialogInfo$1(this, null), 3, (Object) null);
    }
}
