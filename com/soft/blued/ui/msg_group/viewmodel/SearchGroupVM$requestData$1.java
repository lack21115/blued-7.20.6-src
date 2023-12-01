package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.msg_group.api.GroupApiService;
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
@DebugMetadata(b = "SearchGroupVM.kt", c = {28}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.SearchGroupVM$requestData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/SearchGroupVM$requestData$1.class */
final class SearchGroupVM$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32869a;
    final /* synthetic */ SearchGroupVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGroupVM$requestData$1(SearchGroupVM searchGroupVM, Continuation<? super SearchGroupVM$requestData$1> continuation) {
        super(2, continuation);
        this.b = searchGroupVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchGroupVM$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchGroupVM$requestData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        ApiState error;
        Object a2 = IntrinsicsKt.a();
        int i = this.f32869a;
        if (i == 0) {
            ResultKt.a(obj);
            GroupApiService groupApiService = (GroupApiService) BluedApiProxy.b().a(GroupApiService.class);
            str = this.b.f32868a;
            this.f32869a = 1;
            Object a3 = groupApiService.a(str, this.b.getMPage(), this.b.getMPageSize(), this);
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
        SearchGroupVM searchGroupVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                searchGroupVM.loadListSucceed(data, bluedEntityA.hasMore());
            } else {
                searchGroupVM.loadListSucceed(CollectionsKt.b(), false);
            }
            error = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        }
        SearchGroupVM searchGroupVM2 = this.b;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            searchGroupVM2.loadListFailed();
        }
        return Unit.f42314a;
    }
}
