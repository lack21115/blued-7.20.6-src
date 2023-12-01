package com.blued.login.utils;

import com.blued.login.model.LoginSplashModel;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/LoginPreLoad.class */
public final class LoginPreLoad {

    /* renamed from: a  reason: collision with root package name */
    public static final LoginPreLoad f6986a = new LoginPreLoad();
    private static LoginSplashModel b;

    /* renamed from: c  reason: collision with root package name */
    private static Job f6987c;

    private LoginPreLoad() {
    }

    public final LoginSplashModel a() {
        return b;
    }

    public final void a(LoginSplashModel loginSplashModel) {
        b = loginSplashModel;
    }

    public final void b() {
        f6987c = BuildersKt.a(GlobalScope.a, Dispatchers.b(), (CoroutineStart) null, new LoginPreLoad$requestLoginSplash$1(null), 2, (Object) null);
    }
}
