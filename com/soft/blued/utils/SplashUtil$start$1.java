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
@DebugMetadata(b = "SplashUtil.kt", c = {33}, d = "invokeSuspend", e = "com.soft.blued.utils.SplashUtil$start$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/SplashUtil$start$1.class */
public final class SplashUtil$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f21088a;
    final /* synthetic */ SplashUtil b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashUtil$start$1(SplashUtil splashUtil, Continuation<? super SplashUtil$start$1> continuation) {
        super(2, continuation);
        this.b = splashUtil;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashUtil$start$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        Fragment fragment;
        SplashEntity.ShowEntity b;
        Object a2 = IntrinsicsKt.a();
        int i = this.f21088a;
        if (i == 0) {
            ResultKt.a(obj);
            j = this.b.e;
            this.f21088a = 1;
            if (DelayKt.a(j, (Continuation) this) == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        fragment = this.b.f21085a;
        b = this.b.b();
        SerialSplashFragment.a(fragment, b, 105);
        return Unit.a;
    }
}
