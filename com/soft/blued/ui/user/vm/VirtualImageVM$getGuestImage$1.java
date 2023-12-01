package com.soft.blued.ui.user.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.VirtualImageState;
import java.util.List;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "VirtualImageVM.kt", c = {66}, d = "invokeSuspend", e = "com.soft.blued.ui.user.vm.VirtualImageVM$getGuestImage$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$getGuestImage$1.class */
final class VirtualImageVM$getGuestImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20721a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VirtualImageVM f20722c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageVM$getGuestImage$1(String str, VirtualImageVM virtualImageVM, Continuation<? super VirtualImageVM$getGuestImage$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f20722c = virtualImageVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageVM$getGuestImage$1(this.b, this.f20722c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f20721a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20721a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(MapsKt.a(TuplesKt.a("uid", this.b)), (Continuation) this);
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
        VirtualImageVM virtualImageVM = this.f20722c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(virtualImageVM, new Function1<VirtualImageState, VirtualImageState>() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$getGuestImage$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final VirtualImageState invoke(VirtualImageState virtualImageState) {
                        Intrinsics.e(virtualImageState, "$this$setState");
                        return VirtualImageState.copy$default(virtualImageState, null, null, list, 0, 11, null);
                    }
                });
            } else {
                final List b = CollectionsKt.b();
                BluedStructureExtKt.a(virtualImageVM, new Function1<VirtualImageState, VirtualImageState>() { // from class: com.soft.blued.ui.user.vm.VirtualImageVM$getGuestImage$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final VirtualImageState invoke(VirtualImageState virtualImageState) {
                        Intrinsics.e(virtualImageState, "$this$setState");
                        return VirtualImageState.copy$default(virtualImageState, null, null, b, 0, 11, null);
                    }
                });
            }
            ApiState apiState = Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            new Error(i2, str);
        }
        return Unit.a;
    }
}
