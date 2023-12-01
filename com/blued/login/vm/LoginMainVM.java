package com.blued.login.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.login.model.LoginSplashModel;
import com.blued.login.utils.LoginPreLoad;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/LoginMainVM.class */
public final class LoginMainVM extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<LoginSplashModel> f7011a = new MutableLiveData<>();
    private final MutableLiveData<Void> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private Timer f7012c;

    public final MutableLiveData<LoginSplashModel> d() {
        return this.f7011a;
    }

    public final MutableLiveData<Void> e() {
        return this.b;
    }

    public final void f() {
        if (LoginPreLoad.f6986a.a() != null) {
            LoginSplashModel a2 = LoginPreLoad.f6986a.a();
            boolean z = false;
            if (a2 != null && a2.is_open() == 1) {
                z = true;
            }
            if (z) {
                this.f7011a.postValue(LoginPreLoad.f6986a.a());
                return;
            }
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new LoginMainVM$requestSplash$1(this, null), 3, (Object) null);
    }

    public final void g() {
        LoginSplashModel a2 = LoginPreLoad.f6986a.a();
        if (a2 == null) {
            return;
        }
        Timer timer = new Timer();
        this.f7012c = timer;
        if (timer == null) {
            return;
        }
        timer.schedule(new TimerTask() { // from class: com.blued.login.vm.LoginMainVM$startTimer$1$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LoginMainVM.this.e().postValue(null);
            }
        }, a2.getDuration() * 1000, 1000 * a2.getDuration());
    }

    public void onCleared() {
        super.onCleared();
        Timer timer = this.f7012c;
        if (timer == null) {
            return;
        }
        timer.cancel();
    }
}
