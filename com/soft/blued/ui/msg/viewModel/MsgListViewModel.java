package com.soft.blued.ui.msg.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg.model.MsgListCheatModel;
import com.soft.blued.ui.msg.model.MsgUserCheatModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/MsgListViewModel.class */
public final class MsgListViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private MutableLiveData<MsgListCheatModel> f32613a = new MutableLiveData<>();
    private MutableLiveData<MsgUserCheatModel> b = new MutableLiveData<>();

    public final void a(String uid) {
        Intrinsics.e(uid, "uid");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgListViewModel$getCheatUserInfo$1(uid, this, null), 3, null);
    }

    public final MutableLiveData<MsgListCheatModel> d() {
        return this.f32613a;
    }

    public final MutableLiveData<MsgUserCheatModel> e() {
        return this.b;
    }

    public final void f() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new MsgListViewModel$getCheatDialogInfo$1(this, null), 3, null);
    }
}
