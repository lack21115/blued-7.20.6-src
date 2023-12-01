package com.soft.blued.ui.discover.observer;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/observer/DiscoverSquareViewModel.class */
public class DiscoverSquareViewModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public MutableLiveData<Integer> f16154a;
    public MutableLiveData<Void> b;

    public DiscoverSquareViewModel(Application application) {
        super(application);
        this.f16154a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
    }
}
