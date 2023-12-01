package com.soft.blued.ui.msg_group;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.ApiHost;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.InterruptError;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.api.annotation.ParamsMap;
import com.blued.android.module.common.user.model.UserInfo;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/TestService.class */
public interface TestService extends BluedApiService {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/TestService$DefaultImpls.class */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(TestService testService, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = UserInfo.getInstance().getLoginUserInfo().name;
                    Intrinsics.c(str, "getInstance().loginUserInfo.name");
                }
                return testService.a(str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserInfo");
        }

        public static /* synthetic */ Object a(TestService testService, Map map, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = MapsKt.a(TuplesKt.a("size", BaseWrapper.ENTER_ID_SYSTEM_HELPER), TuplesKt.a(WBPageConstants.ParamKey.PAGE, "1"));
                }
                return testService.a(map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyGroup");
        }
    }

    @GET(a = "/users/name")
    Object a(@Param(a = "name") String str, Continuation<? super BluedEntityA<UserInfoEntity>> continuation);

    @ApiHost(a = "HOST_HTTP")
    @GET(a = "/groups/mine")
    @InterruptError
    Object a(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<MyGroupModel>> continuation);
}
