package com.soft.blued.ui.find.manager;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.user.model.UserTagAll;
import com.soft.blued.ui.find.api.FindService;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "FilterNewHelper.kt", c = {328}, d = "invokeSuspend", e = "com.soft.blued.ui.find.manager.FilterNewHelper$preLoadImages$1")
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/manager/FilterNewHelper$preLoadImages$1.class */
public final class FilterNewHelper$preLoadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f30595a;
    final /* synthetic */ CoroutineScope b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterNewHelper$preLoadImages$1(CoroutineScope coroutineScope, Continuation<? super FilterNewHelper$preLoadImages$1> continuation) {
        super(2, continuation);
        this.b = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilterNewHelper$preLoadImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilterNewHelper$preLoadImages$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        Object a2 = IntrinsicsKt.a();
        int i = this.f30595a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f30595a = 1;
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
        CoroutineScope coroutineScope = this.b;
        if (bluedEntityA.code != 200) {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        } else if (bluedEntityA.hasData()) {
            List<T> data = bluedEntityA.data;
            Intrinsics.c(data, "data");
            bluedEntityA.hasMore();
            if (!data.isEmpty()) {
                FilterNewHelper.f30593a.a((UserTagAll) data.get(0));
                error = Succeed.f10631a;
            }
            CoroutineScopeKt.a(coroutineScope, null, 1, null);
            error = Succeed.f10631a;
        } else {
            List b = CollectionsKt.b();
            List list = b;
            if (!(list == null || list.isEmpty())) {
                FilterNewHelper.f30593a.a((UserTagAll) b.get(0));
                error = Succeed.f10631a;
            }
            CoroutineScopeKt.a(coroutineScope, null, 1, null);
            error = Succeed.f10631a;
        }
        CoroutineScope coroutineScope2 = this.b;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            CoroutineScopeKt.a(coroutineScope2, null, 1, null);
        }
        return Unit.f42314a;
    }
}
