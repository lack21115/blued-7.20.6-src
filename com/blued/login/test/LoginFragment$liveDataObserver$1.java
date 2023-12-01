package com.blued.login.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/test/LoginFragment$liveDataObserver$1.class */
final /* synthetic */ class LoginFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginFragment$liveDataObserver$1(Object obj) {
        super(1, obj, LoginFragment.class, "login", "login(Z)V", 0);
    }

    public final void a(boolean z) {
        ((LoginFragment) this.receiver).b(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.f42314a;
    }
}
