package com.soft.blued.ui.user.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.model.VirtualImageModel;
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
@DebugMetadata(b = "VirtualImageVM.kt", c = {54}, d = "invokeSuspend", e = "com.soft.blued.ui.user.vm.VirtualImageVM$getMarketingPicture$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/vm/VirtualImageVM$getMarketingPicture$1.class */
final class VirtualImageVM$getMarketingPicture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20726a;
    final /* synthetic */ VirtualImageVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageVM$getMarketingPicture$1(VirtualImageVM virtualImageVM, Continuation<? super VirtualImageVM$getMarketingPicture$1> continuation) {
        super(2, continuation);
        this.b = virtualImageVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VirtualImageVM$getMarketingPicture$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f20726a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20726a = 1;
            Object b = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).b((Continuation) this);
            obj = b;
            if (b == a2) {
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
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                if (!list.isEmpty()) {
                    BluedStructureExtKt.a(virtualImageVM, new VirtualImageEvent.MarketingPictureEvent((VirtualImageModel.MarketingPicture) list.get(0)));
                }
            } else {
                List b2 = CollectionsKt.b();
                if (!b2.isEmpty()) {
                    BluedStructureExtKt.a(virtualImageVM, new VirtualImageEvent.MarketingPictureEvent((VirtualImageModel.MarketingPicture) b2.get(0)));
                }
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
