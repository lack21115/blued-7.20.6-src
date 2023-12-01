package com.soft.blued.ui.user.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.VirtualImageEvent;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "VirtualImageVM.kt", c = {76}, d = "invokeSuspend", e = "com.soft.blued.ui.user.vm.VirtualImageVM$save$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$save$1.class */
final class VirtualImageVM$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34421a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VirtualImageVM f34422c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageVM$save$1(String str, VirtualImageVM virtualImageVM, Continuation<? super VirtualImageVM$save$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f34422c = virtualImageVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VirtualImageVM$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageVM$save$1(this.b, this.f34422c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        VirtualImageVM virtualImageVM;
        VirtualImageEvent.SaveEvent saveEvent;
        Object a2 = IntrinsicsKt.a();
        int i = this.f34421a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f34421a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(MapsKt.a(TuplesKt.a("uid", UserInfo.getInstance().getLoginUserInfo().uid)), this.b, this);
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
        VirtualImageVM virtualImageVM2 = this.f34422c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Collection data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                virtualImageVM = virtualImageVM2;
                saveEvent = new VirtualImageEvent.SaveEvent(true);
            } else {
                CollectionsKt.b();
                virtualImageVM = virtualImageVM2;
                saveEvent = new VirtualImageEvent.SaveEvent(true);
            }
            BluedStructureExtKt.a(virtualImageVM, saveEvent);
            error = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        }
        VirtualImageVM virtualImageVM3 = this.f34422c;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            BluedStructureExtKt.a(virtualImageVM3, new VirtualImageEvent.SaveEvent(false));
        }
        return Unit.f42314a;
    }
}
