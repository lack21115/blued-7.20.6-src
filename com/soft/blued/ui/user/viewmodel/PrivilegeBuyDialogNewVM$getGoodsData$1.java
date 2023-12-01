package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.state.PrivilegeBuyAction;
import com.soft.blued.ui.user.state.PrivilegeBuyState;
import java.util.List;
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
@DebugMetadata(b = "PrivilegeBuyDialogNewVM.kt", c = {37}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$getGoodsData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/PrivilegeBuyDialogNewVM$getGoodsData$1.class */
final class PrivilegeBuyDialogNewVM$getGoodsData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20655a;
    final /* synthetic */ PrivilegeBuyAction.getGoodsList b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ PrivilegeBuyDialogNewVM f20656c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeBuyDialogNewVM$getGoodsData$1(PrivilegeBuyAction.getGoodsList getgoodslist, PrivilegeBuyDialogNewVM privilegeBuyDialogNewVM, Continuation<? super PrivilegeBuyDialogNewVM$getGoodsData$1> continuation) {
        super(2, continuation);
        this.b = getgoodslist;
        this.f20656c = privilegeBuyDialogNewVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrivilegeBuyDialogNewVM$getGoodsData$1(this.b, this.f20656c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f20655a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20655a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(this.b.a(), (Continuation) this);
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
        PrivilegeBuyDialogNewVM privilegeBuyDialogNewVM = this.f20656c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(privilegeBuyDialogNewVM, new Function1<PrivilegeBuyState, PrivilegeBuyState>() { // from class: com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$getGoodsData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final PrivilegeBuyState invoke(PrivilegeBuyState privilegeBuyState) {
                        Intrinsics.e(privilegeBuyState, "$this$setState");
                        List<PrivilegeBuyOptionForJsonParse> list2 = list;
                        return PrivilegeBuyState.copy$default(privilegeBuyState, !(list2 == null || list2.isEmpty()) ? list.get(0) : null, null, 2, null);
                    }
                });
            } else {
                final List b = CollectionsKt.b();
                BluedStructureExtKt.a(privilegeBuyDialogNewVM, new Function1<PrivilegeBuyState, PrivilegeBuyState>() { // from class: com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM$getGoodsData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final PrivilegeBuyState invoke(PrivilegeBuyState privilegeBuyState) {
                        Intrinsics.e(privilegeBuyState, "$this$setState");
                        List<PrivilegeBuyOptionForJsonParse> list2 = b;
                        return PrivilegeBuyState.copy$default(privilegeBuyState, !(list2 == null || list2.isEmpty()) ? b.get(0) : null, null, 2, null);
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
