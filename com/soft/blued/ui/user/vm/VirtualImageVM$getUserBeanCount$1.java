package com.soft.blued.ui.user.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.VirtualImageEvent;
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

@Metadata
@DebugMetadata(b = "VirtualImageVM.kt", c = {42}, d = "invokeSuspend", e = "com.soft.blued.ui.user.vm.VirtualImageVM$getUserBeanCount$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$getUserBeanCount$1.class */
final class VirtualImageVM$getUserBeanCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34418a;
    final /* synthetic */ VirtualImageVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageVM$getUserBeanCount$1(VirtualImageVM virtualImageVM, Continuation<? super VirtualImageVM$getUserBeanCount$1> continuation) {
        super(2, continuation);
        this.b = virtualImageVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VirtualImageVM$getUserBeanCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageVM$getUserBeanCount$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f34418a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f34418a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(this);
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
        VirtualImageVM virtualImageVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                if (!data.isEmpty()) {
                    BluedStructureExtKt.a(virtualImageVM, new VirtualImageEvent.BeanCount(((PayRemaining) data.get(0)).beans));
                }
            } else {
                List b = CollectionsKt.b();
                if (!b.isEmpty()) {
                    BluedStructureExtKt.a(virtualImageVM, new VirtualImageEvent.BeanCount(((PayRemaining) b.get(0)).beans));
                }
            }
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
