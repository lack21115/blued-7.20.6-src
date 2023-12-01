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

@Metadata
@DebugMetadata(b = "SpecialCareViewModel.kt", c = {42}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$getSpecialCareListData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/SpecialCareViewModel$getSpecialCareListData$1.class */
final class SpecialCareViewModel$getSpecialCareListData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20660a;
    final /* synthetic */ SpecialCareAction.getSpecialCareData b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SpecialCareViewModel f20661c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialCareViewModel$getSpecialCareListData$1(SpecialCareAction.getSpecialCareData getspecialcaredata, SpecialCareViewModel specialCareViewModel, Continuation<? super SpecialCareViewModel$getSpecialCareListData$1> continuation) {
        super(2, continuation);
        this.b = getspecialcaredata;
        this.f20661c = specialCareViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpecialCareViewModel$getSpecialCareListData$1(this.b, this.f20661c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        ApiState apiState;
        Object a2 = IntrinsicsKt.a();
        int i = this.f20660a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20660a = 1;
            Object b = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).b(this.b.a(), this.b.b(), (Continuation) this);
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
        SpecialCareViewModel specialCareViewModel = this.f20661c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                boolean hasMore = bluedEntityA.hasMore();
                SpecialCareViewModel specialCareViewModel2 = specialCareViewModel;
                BluedStructureExtKt.a(specialCareViewModel2, new Function1<SpecialCareState, SpecialCareState>() { // from class: com.soft.blued.ui.user.viewmodel.SpecialCareViewModel$getSpecialCareListData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final SpecialCareState invoke(SpecialCareState specialCareState) {
                        Intrinsics.e(specialCareState, "$this$setState");
                        return specialCareState.a(list.get(0));
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

                    /* renamed from: a */
                    public final SpecialCareState invoke(SpecialCareState specialCareState) {
                        Intrinsics.e(specialCareState, "$this$setState");
                        return specialCareState.a(b2.get(0));
                    }
                });
                BluedStructureExtKt.a(specialCareViewModel3, new MviEvent.LoadFinished(true, false));
            }
            apiState = (ApiState) Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        }
        SpecialCareViewModel specialCareViewModel4 = this.f20661c;
        if (apiState instanceof Error) {
            Error error = apiState;
            error.a();
            error.b();
            BluedStructureExtKt.a(specialCareViewModel4, new MviEvent.LoadFinished(false, false));
        }
        return Unit.a;
    }
}
