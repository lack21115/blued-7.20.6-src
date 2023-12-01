package com.soft.blued.ui.home.model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.blued.android.module.common.base.mvvm.SingleLiveEvent;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/model/HomeViewModel.class */
public class HomeViewModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public SingleLiveEvent<Integer> f17357a;

    public HomeViewModel(Application application) {
        super(application);
        this.f17357a = new SingleLiveEvent<>();
    }
}
