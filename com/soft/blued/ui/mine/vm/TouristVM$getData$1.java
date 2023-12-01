package com.soft.blued.ui.mine.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.mine.api.MineService;
import com.soft.blued.ui.mine.model.MinePageModel;
import com.soft.blued.ui.mine.state.TouristState;
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
@DebugMetadata(b = "TouristVM.kt", c = {33}, d = "invokeSuspend", e = "com.soft.blued.ui.mine.vm.TouristVM$getData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/vm/TouristVM$getData$1.class */
final class TouristVM$getData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f17969a;
    final /* synthetic */ TouristVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouristVM$getData$1(TouristVM touristVM, Continuation<? super TouristVM$getData$1> continuation) {
        super(2, continuation);
        this.b = touristVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TouristVM$getData$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f17969a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f17969a = 1;
            Object a3 = ((MineService) BluedApiProxy.b().a(MineService.class)).a((Continuation) this);
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
        TouristVM touristVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(touristVM, new Function1<TouristState, TouristState>() { // from class: com.soft.blued.ui.mine.vm.TouristVM$getData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final TouristState invoke(TouristState touristState) {
                        Intrinsics.e(touristState, "$this$setState");
                        List<MinePageModel> list2 = list;
                        return touristState.copy(!(list2 == null || list2.isEmpty()) ? list.get(0) : null);
                    }
                });
            } else {
                final List b = CollectionsKt.b();
                BluedStructureExtKt.a(touristVM, new Function1<TouristState, TouristState>() { // from class: com.soft.blued.ui.mine.vm.TouristVM$getData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final TouristState invoke(TouristState touristState) {
                        Intrinsics.e(touristState, "$this$setState");
                        List<MinePageModel> list2 = b;
                        return touristState.copy(!(list2 == null || list2.isEmpty()) ? b.get(0) : null);
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
