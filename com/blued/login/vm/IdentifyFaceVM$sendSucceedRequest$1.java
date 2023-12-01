package com.blued.login.vm;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.login.api.LoginService;
import com.blued.login.state.IdentifyFaceState;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "IdentifyFaceVM.kt", c = {205}, d = "invokeSuspend", e = "com.blued.login.vm.IdentifyFaceVM$sendSucceedRequest$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM$sendSucceedRequest$1.class */
final class IdentifyFaceVM$sendSucceedRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20615a;
    final /* synthetic */ IdentifyFaceVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifyFaceVM$sendSucceedRequest$1(IdentifyFaceVM identifyFaceVM, Continuation<? super IdentifyFaceVM$sendSucceedRequest$1> continuation) {
        super(2, continuation);
        this.b = identifyFaceVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IdentifyFaceVM identifyFaceVM) {
        BluedStructureExtKt.a(identifyFaceVM, new Function1<IdentifyFaceState, IdentifyFaceState>() { // from class: com.blued.login.vm.IdentifyFaceVM$sendSucceedRequest$1$1$1$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final IdentifyFaceState invoke(IdentifyFaceState setState) {
                Intrinsics.e(setState, "$this$setState");
                return setState.copy(true);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IdentifyFaceVM$sendSucceedRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IdentifyFaceVM$sendSucceedRequest$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Handler n;
        Runnable runnable;
        Object a2 = IntrinsicsKt.a();
        int i = this.f20615a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20615a = 1;
            Object a3 = ((LoginService) BluedApiProxy.b().a(LoginService.class)).a(1, this);
            obj = a3;
            if (a3 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        final IdentifyFaceVM identifyFaceVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Collection data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                n = AppInfo.n();
                runnable = new Runnable() { // from class: com.blued.login.vm.-$$Lambda$IdentifyFaceVM$sendSucceedRequest$1$ZOFRtoMSKEsCMCqhM0CfNksei8U
                    @Override // java.lang.Runnable
                    public final void run() {
                        IdentifyFaceVM$sendSucceedRequest$1.a(IdentifyFaceVM.this);
                    }
                };
            } else {
                CollectionsKt.b();
                n = AppInfo.n();
                runnable = new Runnable() { // from class: com.blued.login.vm.-$$Lambda$IdentifyFaceVM$sendSucceedRequest$1$ZOFRtoMSKEsCMCqhM0CfNksei8U
                    @Override // java.lang.Runnable
                    public final void run() {
                        IdentifyFaceVM$sendSucceedRequest$1.a(IdentifyFaceVM.this);
                    }
                };
            }
            n.postDelayed(runnable, 100L);
            Succeed succeed = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            new Error(i2, message);
        }
        return Unit.f42314a;
    }
}
