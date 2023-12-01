package com.soft.blued.ui.msg.viewModel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.msg.api.MsgService;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MsgListViewModel.kt", c = {40}, d = "invokeSuspend", e = "com.soft.blued.ui.msg.viewModel.MsgListViewModel$getCheatUserInfo$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/viewModel/MsgListViewModel$getCheatUserInfo$1.class */
public final class MsgListViewModel$getCheatUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32615a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MsgListViewModel f32616c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgListViewModel$getCheatUserInfo$1(String str, MsgListViewModel msgListViewModel, Continuation<? super MsgListViewModel$getCheatUserInfo$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f32616c = msgListViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MsgListViewModel$getCheatUserInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MsgListViewModel$getCheatUserInfo$1(this.b, this.f32616c, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f32615a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f32615a = 1;
            Object a3 = ((MsgService) BluedApiProxy.b().a(MsgService.class)).a(this.b, this);
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
        MsgListViewModel msgListViewModel = this.f32616c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                if (!data.isEmpty()) {
                    msgListViewModel.e().postValue(data.get(0));
                }
            } else {
                List b = CollectionsKt.b();
                List list = b;
                boolean z = true;
                if (list != null) {
                    z = list.isEmpty();
                }
                if (!z) {
                    msgListViewModel.e().postValue(b.get(0));
                }
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
