package com.soft.blued.ui.find.observer;

import android.app.Application;
import android.graphics.Rect;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyViewModel.class */
public class NearbyViewModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public MutableLiveData<Rect> f30625a;
    public MutableLiveData<Void> b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<Void> f30626c;
    public MutableLiveData<Void> d;
    public MutableLiveData<Void> e;

    public NearbyViewModel(Application application) {
        super(application);
        this.f30625a = new MutableLiveData<>();
        this.b = new MutableLiveData<>();
        this.f30626c = new MutableLiveData<>();
        this.d = new MutableLiveData<>();
        this.e = new MutableLiveData<>();
    }
}
