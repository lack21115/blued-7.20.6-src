package com.soft.blued.ui.mine.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "TouristVM.kt", c = {33}, d = "invokeSuspend", e = "com.soft.blued.ui.mine.vm.TouristVM$getData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/vm/TouristVM$getData$1.class */
public final class TouristVM$getData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f31659a;
    final /* synthetic */ TouristVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouristVM$getData$1(TouristVM touristVM, Continuation<? super TouristVM$getData$1> continuation) {
        super(2, continuation);
        this.b = touristVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TouristVM$getData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TouristVM$getData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f31659a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f31659a = 1;
            Object a3 = ((MineService) BluedApiProxy.b().a(MineService.class)).a(this);
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
                final List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(touristVM, new Function1<TouristState, TouristState>() { // from class: com.soft.blued.ui.mine.vm.TouristVM$getData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final TouristState invoke(TouristState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        List<MinePageModel> list = data;
                        return setState.copy(!(list == null || list.isEmpty()) ? data.get(0) : null);
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

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final TouristState invoke(TouristState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        List<MinePageModel> list = b;
                        return setState.copy(!(list == null || list.isEmpty()) ? b.get(0) : null);
                    }
                });
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
