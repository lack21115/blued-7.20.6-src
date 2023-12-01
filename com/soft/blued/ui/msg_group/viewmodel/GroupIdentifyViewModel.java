package com.soft.blued.ui.msg_group.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupIdentifyViewModel.class */
public final class GroupIdentifyViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<GroupIdentifyModel> f19153a = new MutableLiveData<>();
    private final MutableLiveData<Void> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private String f19154c = "";
    private String d = "";

    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            String string = bundle.getString("from", "");
            Intrinsics.c(string, "arguments.getString(\"from\", \"\")");
            this.f19154c = string;
            String string2 = bundle.getString("event_id", "");
            Intrinsics.c(string2, "arguments.getString(\"event_id\", \"\")");
            this.d = string2;
        }
    }

    public final void a(String str, String str2) {
        Intrinsics.e(str, "card_name");
        Intrinsics.e(str2, "card_num");
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupIdentifyViewModel$submit$1(this, str, str2, null), 3, (Object) null);
    }

    public final MutableLiveData<GroupIdentifyModel> d() {
        return this.f19153a;
    }

    public final MutableLiveData<Void> e() {
        return this.b;
    }

    public final String f() {
        return this.d;
    }

    public final boolean g() {
        return TextUtils.equals(this.f19154c, "event");
    }

    public final void h() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GroupIdentifyViewModel$getIdentifyInfo$1(this, null), 3, (Object) null);
    }
}
