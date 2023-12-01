package com.blued.community.ui.send.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectCityViewModel.class */
public final class SelectCityViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<String> f20100a = new MutableLiveData<>();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f20101c;

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.f20101c = str;
    }

    public final MutableLiveData<String> d() {
        return this.f20100a;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.f20101c;
    }
}
