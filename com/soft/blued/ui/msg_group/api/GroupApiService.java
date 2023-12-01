package com.soft.blued.ui.msg_group.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.DELETE;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.InterruptError;
import com.blued.android.module.common.api.annotation.POST;
import com.blued.android.module.common.api.annotation.PUT;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.api.annotation.ParamsMap;
import com.blued.android.module.common.group.GroupCategoryModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.sina.weibo.sdk.constant.WBPageConstants;
import com.soft.blued.ui.find.model.CityLocation;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/api/GroupApiService.class */
public interface GroupApiService extends BluedApiService {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/api/GroupApiService$DefaultImpls.class */
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(GroupApiService groupApiService, Map map, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    map = MapsKt.a(new Pair[]{TuplesKt.a(OapsKey.KEY_SIZE, BaseWrapper.ENTER_ID_SYSTEM_HELPER), TuplesKt.a(WBPageConstants.ParamKey.PAGE, "1")});
                }
                return groupApiService.a(map, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyGroup");
        }
    }

    @GET(a = "/groups/search")
    Object a(@Param(a = "keyword") String str, @Param(a = "page") int i, @Param(a = "size") int i2, Continuation<? super BluedEntityA<GroupInfoModel>> continuation);

    @POST(a = "/users/activity/identify")
    Object a(@Param(a = "card_name") String str, @Param(a = "card_number") String str2, @Param(a = "activity_id") String str3, Continuation<? super BluedEntityA<Object>> continuation);

    @POST(a = "/groups/identify")
    Object a(@Param(a = "card_name") String str, @Param(a = "card_number") String str2, Continuation<? super BluedEntityA<Object>> continuation);

    @PUT(a = "/groups/super")
    Object a(@Param(a = "group_id") String str, Continuation<? super BluedEntityA<Object>> continuation);

    @GET(a = "/groups/mine")
    Object a(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<MyGroupModel>> continuation);

    @GET(a = "/groups/identify")
    @InterruptError
    Object a(Continuation<? super BluedEntityA<GroupIdentifyModel>> continuation);

    @GET(a = "/blued/city_code")
    Object b(@Param(a = "lot") String str, @Param(a = "lat") String str2, Continuation<? super BluedEntityA<CityLocation>> continuation);

    @DELETE(a = "/groups/super")
    @InterruptError
    Object b(@Param(a = "group_id") String str, Continuation<? super BluedEntityA<Object>> continuation);

    @GET(a = "/groups/recommend")
    Object b(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<GroupInfoModel>> continuation);

    @GET(a = "/users/activity/identify")
    Object b(Continuation<? super BluedEntityA<GroupIdentifyModel>> continuation);

    @GET(a = "/groups/nearby")
    Object c(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<GroupInfoModel>> continuation);

    @GET(a = "/groups/super")
    @InterruptError
    Object c(Continuation<? super BluedEntityA<GroupPrivilegeModel>> continuation);

    @PUT(a = "/groups/info")
    Object d(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<GroupInfoModel>> continuation);

    @GET(a = "/groups/category")
    Object d(Continuation<? super BluedEntityA<GroupCategoryModel>> continuation);

    @GET(a = "/groups/notice")
    Object e(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<GroupNoticeModel>> continuation);
}
