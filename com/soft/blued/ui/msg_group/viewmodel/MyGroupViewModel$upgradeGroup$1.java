package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MyGroupViewModel.kt", c = {59}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel$upgradeGroup$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupViewModel$upgradeGroup$1.class */
public final class MyGroupViewModel$upgradeGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32866a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MyGroupViewModel f32867c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupViewModel$upgradeGroup$1(String str, MyGroupViewModel myGroupViewModel, Continuation<? super MyGroupViewModel$upgradeGroup$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f32867c = myGroupViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyGroupViewModel$upgradeGroup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupViewModel$upgradeGroup$1(this.b, this.f32867c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f32866a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f32866a = 1;
            Object a3 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).a(this.b, this);
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
        MyGroupViewModel myGroupViewModel = this.f32867c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Collection data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
            } else {
                CollectionsKt.b();
            }
            myGroupViewModel.h().setValue(Boxing.a(1));
            LiveEventBus.get("LIVE_WEB_PAGE_REFRESH", String.class).post("");
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
