package com.soft.blued.ui.welcome;

import android.content.Context;
import com.soft.blued.ui.welcome.WelcomeFragment;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "WelcomeFragment.kt", c = {167}, d = "invokeSuspend", e = "com.soft.blued.ui.welcome.WelcomeFragment$initData$1$result$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment$initData$1$result$1.class */
final class WelcomeFragment$initData$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20930a;
    final /* synthetic */ WelcomeFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WelcomeFragment$initData$1$result$1(WelcomeFragment welcomeFragment, Continuation<? super WelcomeFragment$initData$1$result$1> continuation) {
        super(2, continuation);
        this.b = welcomeFragment;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WelcomeFragment$initData$1$result$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2;
        boolean z;
        SplashEntity.ShowEntity showEntity;
        Object a3 = IntrinsicsKt.a();
        int i = this.f20930a;
        if (i == 0) {
            ResultKt.a(obj);
            this.b.a("开始请求开机图接口");
            this.f20930a = 1;
            a2 = this.b.a((Continuation) this);
            obj = a2;
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        SplashModel splashModel = (SplashModel) obj;
        if (!splashModel.isSuccess()) {
            WelcomeFragment.Companion companion = WelcomeFragment.f20927a;
            Context context = this.b.getContext();
            z = this.b.f20928c;
            companion.b(context, z);
            return Unit.a;
        }
        SplashEntity splashEntity = splashModel.getSplashEntity();
        if (splashEntity == null || (showEntity = splashEntity.today) == null) {
            return null;
        }
        this.b.a(showEntity);
        return Unit.a;
    }
}
