package com.soft.blued.ui.msg_group.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupIdentifyViewModel.class */
public final class GroupIdentifyViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<GroupIdentifyModel> f32844a = new MutableLiveData<>();
    private final MutableLiveData<Void> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private String f32845c = "";
    private String d = "";

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            String string = bundle.getString("from", "");
            Intrinsics.c(string, "arguments.getString(\"from\", \"\")");
            this.f32845c = string;
            String string2 = bundle.getString("event_id", "");
            Intrinsics.c(string2, "arguments.getString(\"event_id\", \"\")");
            this.d = string2;
        }
    }

    public final void a(String card_name, String card_num) {
        Intrinsics.e(card_name, "card_name");
        Intrinsics.e(card_num, "card_num");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupIdentifyViewModel$submit$1(this, card_name, card_num, null), 3, null);
    }

    public final MutableLiveData<GroupIdentifyModel> d() {
        return this.f32844a;
    }

    public final MutableLiveData<Void> e() {
        return this.b;
    }

    public final String f() {
        return this.d;
    }

    public final boolean g() {
        return TextUtils.equals(this.f32845c, "event");
    }

    public final void h() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new GroupIdentifyViewModel$getIdentifyInfo$1(this, null), 3, null);
    }
}
