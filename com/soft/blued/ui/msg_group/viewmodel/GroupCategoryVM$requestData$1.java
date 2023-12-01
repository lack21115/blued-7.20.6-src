package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.group.GroupCategoryModel;
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
@DebugMetadata(b = "GroupCategoryVM.kt", c = {23}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupCategoryVM$requestData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCategoryVM$requestData$1.class */
final class GroupCategoryVM$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19148a;
    final /* synthetic */ GroupCategoryVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCategoryVM$requestData$1(GroupCategoryVM groupCategoryVM, Continuation<? super GroupCategoryVM$requestData$1> continuation) {
        super(2, continuation);
        this.b = groupCategoryVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupCategoryVM$requestData$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f19148a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19148a = 1;
            Object d = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).d((Continuation) this);
            obj = d;
            if (d == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        GroupCategoryVM groupCategoryVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                boolean hasMore = bluedEntityA.hasMore();
                int a3 = CollectionsKt.a(list, groupCategoryVM.a());
                if (a3 != -1) {
                    ((GroupCategoryModel) list.get(a3)).setSelected(true);
                }
                groupCategoryVM.loadListSucceed(list, hasMore);
            } else {
                List b = CollectionsKt.b();
                int a4 = CollectionsKt.a(b, groupCategoryVM.a());
                if (a4 != -1) {
                    ((GroupCategoryModel) b.get(a4)).setSelected(true);
                }
                groupCategoryVM.loadListSucceed(b, false);
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
