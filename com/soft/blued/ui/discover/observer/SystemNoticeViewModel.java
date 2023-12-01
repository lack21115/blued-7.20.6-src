package com.soft.blued.ui.discover.observer;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/observer/SystemNoticeViewModel.class */
public class SystemNoticeViewModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public int f29846a;
    public ViewpointNoticeCount b;

    /* renamed from: c  reason: collision with root package name */
    public int f29847c;
    public MutableLiveData<Integer> d;
    public MutableLiveData<Integer> e;
    public MutableLiveData<Integer> f;
    public MutableLiveData<Integer> g;
    public MutableLiveData<ViewpointNoticeCount> h;

    public SystemNoticeViewModel(Application application) {
        super(application);
        this.f29846a = 0;
        this.b = new ViewpointNoticeCount();
        this.f29847c = 0;
        this.d = new MutableLiveData<>();
        this.e = new MutableLiveData<>();
        this.f = new MutableLiveData<>();
        this.g = new MutableLiveData<>();
        this.h = new MutableLiveData<>();
    }
}
