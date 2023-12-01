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
    int f20931a;
    final /* synthetic */ WelcomeFragment b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<SplashModel> f20932c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WelcomeFragment$loadAd$2$1(WelcomeFragment welcomeFragment, CancellableContinuation<? super SplashModel> cancellableContinuation, Continuation<? super WelcomeFragment$loadAd$2$1> continuation) {
        super(2, continuation);
        this.b = welcomeFragment;
        this.f20932c = cancellableContinuation;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WelcomeFragment$loadAd$2$1(this.b, this.f20932c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f20931a == 0) {
            ResultKt.a(obj);
            WelcomeFragment welcomeFragment = this.b;
            final CancellableContinuation<SplashModel> cancellableContinuation = this.f20932c;
            welcomeFragment.a(new SplashAdListener() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1.1
                @Override // com.soft.blued.ui.welcome.SplashAdListener
                public void a(int i, String str) {
                    Intrinsics.e(str, "msg");
                    if (cancellableContinuation.a()) {
                        cancellableContinuation.a(new SplashModel(false, i, str), new Function1<Throwable, Unit>() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1$1$onFailed$1
                            public final void a(Throwable th) {
                                Intrinsics.e(th, "it");
                            }

                            public /* synthetic */ Object invoke(Object obj2) {
                                a((Throwable) obj2);
                                return Unit.a;
                            }
                        });
                    }
                }

                @Override // com.soft.blued.ui.welcome.SplashAdListener
                public void a(SplashEntity splashEntity) {
                    Intrinsics.e(splashEntity, "splashEntity");
                    if (cancellableContinuation.a()) {
                        cancellableContinuation.a(new SplashModel(true, splashEntity), new Function1<Throwable, Unit>() { // from class: com.soft.blued.ui.welcome.WelcomeFragment$loadAd$2$1$1$onSuccess$1
                            public final void a(Throwable th) {
                                Intrinsics.e(th, "it");
                            }

                            public /* synthetic */ Object invoke(Object obj2) {
                                a((Throwable) obj2);
                                return Unit.a;
                            }
                        });
                    }
                }
            });
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
