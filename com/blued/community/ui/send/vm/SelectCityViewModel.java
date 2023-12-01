package com.blued.community.ui.send.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectCityViewModel.class */
public final class SelectCityViewModel extends BaseViewModel {
    private final MutableLiveData<String> a = new MutableLiveData<>();
    private String b;
    private String c;

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final MutableLiveData<String> d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }
}
