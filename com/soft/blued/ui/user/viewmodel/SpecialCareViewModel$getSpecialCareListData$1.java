package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.SpecialCareAction;
import com.soft.blued.ui.user.state.SpecialCareState;
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
@DebugMetadata(b = "SpecialCareViewModel.kt", c = {42}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$getSpecialCareListData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel$getSpecialCareListData$1.class */
public final class SpecialCareViewModel$getSpecialCareListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34351a;
    final /* synthetic */ SpecialCareAction.getSpecialCareData b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SpecialCareViewModel f34352c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialCareViewModel$getSpecialCareListData$1(SpecialCareAction.getSpecialCareData getspecialcaredata, SpecialCareViewModel specialCareViewModel, Continuation<? super SpecialCareViewModel$getSpecialCareListData$1> continuation) {
        super(2, continuation);
        this.b = getspecialcaredata;
        this.f34352c = specialCareViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpecialCareViewModel$getSpecialCareListData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpecialCareViewModel$getSpecialCareListData$1(this.b, this.f34352c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        Object a2 = IntrinsicsKt.a();
        int i = this.f34351a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f34351a = 1;
            Object b = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).b(this.b.a(), this.b.b(), this);
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
        SpecialCareViewModel specialCareViewModel = this.f34352c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                boolean hasMore = bluedEntityA.hasMore();
                SpecialCareViewModel specialCareViewModel2 = specialCareViewModel;
                BluedStructureExtKt.a(specialCareViewModel2, new Function1<SpecialCareState, SpecialCareState>() { // from class: com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$getSpecialCareListData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final SpecialCareState invoke(SpecialCareState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(data.get(0));
                    }
                });
                BluedStructureExtKt.a(specialCareViewModel2, new MviEvent.LoadFinished(true, hasMore));
            } else {
                final List b2 = CollectionsKt.b();
                SpecialCareViewModel specialCareViewModel3 = specialCareViewModel;
                BluedStructureExtKt.a(specialCareViewModel3, new Function1<SpecialCareState, SpecialCareState>() { // from class: com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$getSpecialCareListData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final SpecialCareState invoke(SpecialCareState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(b2.get(0));
                    }
                });
                BluedStructureExtKt.a(specialCareViewModel3, new MviEvent.LoadFinished(true, false));
            }
            error = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        }
        SpecialCareViewModel specialCareViewModel4 = this.f34352c;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            BluedStructureExtKt.a(specialCareViewModel4, new MviEvent.LoadFinished(false, false));
        }
        return Unit.f42314a;
    }
}
