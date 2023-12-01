package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.user.model.UserInfo;
import com.cdo.oaps.ad.OapsKey;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import java.util.List;
import java.util.Map;
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
@DebugMetadata(b = "GroupRecommendViewModel.kt", c = {34, 36}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupRecommendViewModel$requestData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupRecommendViewModel$requestData$1.class */
final class GroupRecommendViewModel$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19166a;
    final /* synthetic */ GroupRecommendViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupRecommendViewModel$requestData$1(GroupRecommendViewModel groupRecommendViewModel, Continuation<? super GroupRecommendViewModel$requestData$1> continuation) {
        super(2, continuation);
        this.b = groupRecommendViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupRecommendViewModel$requestData$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        BluedEntityA bluedEntityA;
        ApiState apiState;
        Object a2 = IntrinsicsKt.a();
        int i = this.f19166a;
        if (i == 0) {
            ResultKt.a(obj);
            Map<String, String> b = MapsKt.b(new Pair[]{TuplesKt.a(OapsKey.KEY_SIZE, String.valueOf(this.b.getMPageSize())), TuplesKt.a(WBPageConstants.ParamKey.PAGE, String.valueOf(this.b.getMPage()))});
            if (this.b.getType() == RecommendGroupFragment.RecommendType.NEARBY) {
                try {
                    String longitude = UserInfo.getInstance().getLoginUserInfo().getLongitude();
                    Intrinsics.c(longitude, "getInstance().loginUserInfo.longitude");
                    b.put("longitude", longitude);
                    String latitude = UserInfo.getInstance().getLoginUserInfo().getLatitude();
                    Intrinsics.c(latitude, "getInstance().loginUserInfo.latitude");
                    b.put("latitude", latitude);
                } catch (Throwable th) {
                }
            }
            if (this.b.getType() == RecommendGroupFragment.RecommendType.NEARBY) {
                this.f19166a = 1;
                Object c2 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).c(b, (Continuation) this);
                obj = c2;
                if (c2 == a2) {
                    return a2;
                }
                bluedEntityA = (BluedEntityA) obj;
            } else {
                this.f19166a = 2;
                Object b2 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).b(b, (Continuation) this);
                obj = b2;
                if (b2 == a2) {
                    return a2;
                }
                bluedEntityA = (BluedEntityA) obj;
            }
        } else if (i == 1) {
            ResultKt.a(obj);
            bluedEntityA = (BluedEntityA) obj;
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
            bluedEntityA = (BluedEntityA) obj;
        }
        GroupRecommendViewModel groupRecommendViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                groupRecommendViewModel.loadListSucceed(CollectionsKt.j(list), bluedEntityA.hasMore());
            } else {
                List b3 = CollectionsKt.b();
                groupRecommendViewModel.loadListSucceed(b3 == null ? null : CollectionsKt.j(b3), false);
            }
            apiState = (ApiState) Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        }
        GroupRecommendViewModel groupRecommendViewModel2 = this.b;
        if (apiState instanceof Error) {
            Error error = apiState;
            error.a();
            error.b();
            groupRecommendViewModel2.loadListFailed();
        }
        return Unit.a;
    }
}
