package com.soft.blued.ui.user.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.ApiHost;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.InterruptError;
import com.blued.android.module.common.api.annotation.POST;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.api.annotation.ReplaceMap;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import com.soft.blued.ui.user.model.VirtualImageModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/api/UserApiService.class */
public interface UserApiService extends BluedApiService {
    @POST(a = "/users/stealth/lists")
    Object a(@Param(a = "page") int i, @Param(a = "size") int i2, Continuation<? super BluedEntityA<InvisibleToUserModel>> continuation);

    @ApiHost(a = "HOST_PAY")
    @GET(a = "/pay/config/call")
    Object a(@Param(a = "recommend") int i, Continuation<? super BluedEntityA<PrivilegeBuyOptionForJsonParse>> continuation);

    @InterruptError
    @POST(a = "/users/face/uid")
    Object a(@ReplaceMap Map<String, String> map, @Param(a = "JSON") String str, Continuation<? super BluedEntityA<Object>> continuation);

    @GET(a = "/users/face/uid")
    Object a(@ReplaceMap Map<String, String> map, Continuation<? super BluedEntityA<VirtualImageModel.GuestImageGoodsModel>> continuation);

    @ApiHost(a = "HOST_PAY")
    @GET(a = "/sums/android")
    Object a(Continuation<? super BluedEntityA<PayRemaining>> continuation);

    @GET(a = "/users/special/friend")
    Object b(@Param(a = "page") int i, @Param(a = "size") int i2, Continuation<? super BluedEntityA<InvisibleToUserModel>> continuation);

    @ApiHost(a = "HOST_PAY")
    @GET(a = "/pay/config/vip_v2")
    Object b(@Param(a = "from") int i, Continuation<? super BluedEntityA<VIPCenterNewModel>> continuation);

    @GET(a = "/users/face/entry/info")
    Object b(Continuation<? super BluedEntityA<VirtualImageModel.MarketingPicture>> continuation);

    @GET(a = "/users/face/goods_list")
    Object c(Continuation<? super BluedEntityA<VirtualImageModel>> continuation);
}
