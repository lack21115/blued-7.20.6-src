package com.soft.blued.ui.msg_group.model;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "GroupNoticeViewModel.kt", c = {20}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.model.GroupNoticeViewModel$requestData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupNoticeViewModel$requestData$1.class */
final class GroupNoticeViewModel$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32791a;
    final /* synthetic */ GroupNoticeViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupNoticeViewModel$requestData$1(GroupNoticeViewModel groupNoticeViewModel, Continuation<? super GroupNoticeViewModel$requestData$1> continuation) {
        super(2, continuation);
        this.b = groupNoticeViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupNoticeViewModel$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupNoticeViewModel$requestData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiState error;
        Object a2 = IntrinsicsKt.a();
        int i = this.f32791a;
        if (i == 0) {
            ResultKt.a(obj);
            GroupApiService groupApiService = (GroupApiService) BluedApiProxy.b().a(GroupApiService.class);
            Pair[] pairArr = {TuplesKt.a("size", String.valueOf(this.b.getMPageSize())), TuplesKt.a(WBPageConstants.ParamKey.PAGE, String.valueOf(this.b.getMPage()))};
            this.f32791a = 1;
            Object e = groupApiService.e(MapsKt.b(pairArr), this);
            obj = e;
            if (e == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        GroupNoticeViewModel groupNoticeViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                groupNoticeViewModel.loadListSucceed(data, bluedEntityA.hasMore());
            } else {
                groupNoticeViewModel.loadListSucceed(CollectionsKt.b(), false);
            }
            error = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            error = new Error(i2, message);
        }
        GroupNoticeViewModel groupNoticeViewModel2 = this.b;
        if (error instanceof Error) {
            Error error2 = (Error) error;
            error2.a();
            error2.b();
            groupNoticeViewModel2.loadListFailed();
        }
        return Unit.f42314a;
    }
}
