package com.soft.blued.ui.welcome;

import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "WelcomeFragment.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragment$loadAd$2$1.class */
public final class WelcomeFragment$loadAd$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34622a;
    final /* synthetic */ WelcomeFragment b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<SplashModel> f34623c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WelcomeFragment$loadAd$2$1(WelcomeFragment welcomeFragment, CancellableContinuation<? super SplashModel> cancellableContinuation, Continuation<? super WelcomeFragment$loadAd$2$1> continuation) {
        super(2, continuation);
        this.b = welcomeFragment;
        this.f34623c = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WelcomeFragment$loadAd$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WelcomeFragment$loadAd$2$1(this.b, this.f34623c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f34622a == 0) {
            ResultKt.a(obj);
            WelcomeFragment welcomeFragment = this.b;
            final CancellableContinuation<SplashModel> cancellableContinuation = this.f34623c;
            welcomeFragment.a(new SplashAdListener() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1.1
                @Override // com.soft.blued.ui.welcome.SplashAdListener
                public void a(int i, String msg) {
                    Intrinsics.e(msg, "msg");
                    if (cancellableContinuation.a()) {
                        cancellableContinuation.a((CancellableContinuation<SplashModel>) new SplashModel(false, i, msg), (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1$1$onFailed$1
                            public final void a(Throwable it) {
                                Intrinsics.e(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(Throwable th) {
                                a(th);
                                return Unit.f42314a;
                            }
                        });
                    }
                }

                @Override // com.soft.blued.ui.welcome.SplashAdListener
                public void a(SplashEntity splashEntity) {
                    Intrinsics.e(splashEntity, "splashEntity");
                    if (cancellableContinuation.a()) {
                        cancellableContinuation.a((CancellableContinuation<SplashModel>) new SplashModel(true, splashEntity), (Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1$1$onSuccess$1
                            public final void a(Throwable it) {
                                Intrinsics.e(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(Throwable th) {
                                a(th);
                                return Unit.f42314a;
                            }
                        });
                    }
                }
            });
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
