package com.soft.blued.utils;

import androidx.fragment.app.Fragment;
import com.soft.blued.ui.welcome.SerialSplashFragment;
import com.soft.blued.ui.welcome.model.SplashEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "SplashUtil.kt", c = {82}, d = "invokeSuspend", e = "com.soft.blued.utils.SplashUtil$onActivityResult$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/SplashUtil$onActivityResult$1.class */
public final class SplashUtil$onActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34778a;
    final /* synthetic */ SplashUtil b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashUtil$onActivityResult$1(SplashUtil splashUtil, Continuation<? super SplashUtil$onActivityResult$1> continuation) {
        super(2, continuation);
        this.b = splashUtil;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashUtil$onActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashUtil$onActivityResult$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        Fragment fragment;
        SplashEntity.ShowEntity b;
        Object a2 = IntrinsicsKt.a();
        int i = this.f34778a;
        if (i == 0) {
            ResultKt.a(obj);
            j = this.b.e;
            this.f34778a = 1;
            if (DelayKt.a(j, this) == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        if (BluedPreferences.F()) {
            fragment = this.b.f34776a;
            b = this.b.b();
            SerialSplashFragment.a(fragment, b, 105);
        }
        return Unit.f42314a;
    }
}
