package com.soft.blued.ui.find.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserTagAll;
import com.soft.blued.ui.find.api.FindService;
import com.soft.blued.ui.find.state.FilterState;
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
@DebugMetadata(b = "FilterViewModel.kt", c = {31}, d = "invokeSuspend", e = "com.soft.blued.ui.find.viewmodel.FilterViewModel$getUserTagsAllData$1")
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/viewmodel/FilterViewModel$getUserTagsAllData$1.class */
public final class FilterViewModel$getUserTagsAllData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f30743a;
    final /* synthetic */ FilterViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterViewModel$getUserTagsAllData$1(FilterViewModel filterViewModel, Continuation<? super FilterViewModel$getUserTagsAllData$1> continuation) {
        super(2, continuation);
        this.b = filterViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilterViewModel$getUserTagsAllData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilterViewModel$getUserTagsAllData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f30743a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f30743a = 1;
            Object a3 = ((FindService) BluedApiProxy.b().a(FindService.class)).a(this);
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
        FilterViewModel filterViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(filterViewModel, new Function1<FilterState, FilterState>() { // from class: com.soft.blued.ui.find.viewmodel.FilterViewModel$getUserTagsAllData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final FilterState invoke(FilterState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        List<UserTagAll> list = data;
                        return setState.copy(!(list == null || list.isEmpty()) ? data.get(0) : null);
                    }
                });
            } else {
                final List b = CollectionsKt.b();
                BluedStructureExtKt.a(filterViewModel, new Function1<FilterState, FilterState>() { // from class: com.soft.blued.ui.find.viewmodel.FilterViewModel$getUserTagsAllData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final FilterState invoke(FilterState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        List<UserTagAll> list = b;
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
