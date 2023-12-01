package com.blued.login.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.login.api.LoginService;
import com.blued.login.model.FaceSignModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "IdentifyFaceVM.kt", c = {85}, d = "invokeSuspend", e = "com.blued.login.vm.IdentifyFaceVM$requestSign$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM$requestSign$1.class */
public final class IdentifyFaceVM$requestSign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20613a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f20614c;
    final /* synthetic */ IdentifyFaceVM d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifyFaceVM$requestSign$1(String str, String str2, IdentifyFaceVM identifyFaceVM, Continuation<? super IdentifyFaceVM$requestSign$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f20614c = str2;
        this.d = identifyFaceVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IdentifyFaceVM$requestSign$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IdentifyFaceVM$requestSign$1(this.b, this.f20614c, this.d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        Object obj2;
        Object a2 = IntrinsicsKt.a();
        int i = this.f20613a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20613a = 1;
            Object a3 = ((LoginService) BluedApiProxy.b().a(LoginService.class)).a(this.b, this.f20614c, this);
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
        IdentifyFaceVM identifyFaceVM = this.d;
        if (bluedEntityA.code != 200) {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        } else if (bluedEntityA.hasData()) {
            List<T> data = bluedEntityA.data;
            Intrinsics.c(data, "data");
            bluedEntityA.hasMore();
            if (!data.isEmpty()) {
                obj2 = data.get(0);
                identifyFaceVM.a((FaceSignModel) obj2);
            }
            error = Succeed.f10631a;
        } else {
            List b = CollectionsKt.b();
            List list = b;
            boolean z = true;
            if (list != null) {
                z = list.isEmpty();
            }
            if (!z) {
                obj2 = b.get(0);
                identifyFaceVM.a((FaceSignModel) obj2);
            }
            error = Succeed.f10631a;
        }
        IdentifyFaceVM identifyFaceVM2 = this.d;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            BluedStructureExtKt.a(identifyFaceVM2, new MviEvent.LoadFinished(false, false, 3, null));
        }
        return Unit.f42314a;
    }
}
