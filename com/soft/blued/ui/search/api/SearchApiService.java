package com.soft.blued.ui.search.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/api/SearchApiService.class */
public interface SearchApiService extends BluedApiService {
    @GET(a = "/users/search")
    Object a(@Param(a = "keywords") String str, @Param(a = "page") int i, @Param(a = "tab") int i2, Continuation<? super BluedEntityA<SearchGlobalInfo.SearchUserModel>> continuation);

    @GET(a = "/groups/search/mini")
    Object a(@Param(a = "keywords") String str, Continuation<? super BluedEntityA<GroupInfoModel>> continuation);

    @GET(a = "/users/search/mini")
    Object b(@Param(a = "keywords") String str, Continuation<? super BluedEntityA<SearchGlobalInfo.SearchUserModel>> continuation);
}
