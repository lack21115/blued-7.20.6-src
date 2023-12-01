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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "IdentifyFaceVM.kt", c = {85}, d = "invokeSuspend", e = "com.blued.login.vm.IdentifyFaceVM$requestSign$1")
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM$requestSign$1.class */
public final class IdentifyFaceVM$requestSign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f7007a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7008c;
    final /* synthetic */ IdentifyFaceVM d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifyFaceVM$requestSign$1(String str, String str2, IdentifyFaceVM identifyFaceVM, Continuation<? super IdentifyFaceVM$requestSign$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f7008c = str2;
        this.d = identifyFaceVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IdentifyFaceVM$requestSign$1(this.b, this.f7008c, this.d, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        ApiState apiState;
        Object obj2;
        Object a2 = IntrinsicsKt.a();
        int i = this.f7007a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f7007a = 1;
            Object a3 = ((LoginService) BluedApiProxy.b().a(LoginService.class)).a(this.b, this.f7008c, (Continuation) this);
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
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        } else if (bluedEntityA.hasData()) {
            List list = bluedEntityA.data;
            Intrinsics.c(list, "data");
            bluedEntityA.hasMore();
            if (!list.isEmpty()) {
                obj2 = list.get(0);
                identifyFaceVM.a((FaceSignModel) obj2);
            }
            apiState = (ApiState) Succeed.a;
        } else {
            List b = CollectionsKt.b();
            List list2 = b;
            boolean z = true;
            if (list2 != null) {
                z = list2.isEmpty();
            }
            if (!z) {
                obj2 = b.get(0);
                identifyFaceVM.a((FaceSignModel) obj2);
            }
            apiState = (ApiState) Succeed.a;
        }
        IdentifyFaceVM identifyFaceVM2 = this.d;
        if (apiState instanceof Error) {
            Error error = apiState;
            error.a();
            error.b();
            BluedStructureExtKt.a(identifyFaceVM2, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
        }
        return Unit.a;
    }
}
