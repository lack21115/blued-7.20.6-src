package com.soft.blued.ui.mine.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.soft.blued.ui.mine.model.MinePageModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/api/MineService.class */
public interface MineService extends BluedApiService {
    @GET(a = "/users/no_auth/benefit")
    Object a(Continuation<? super BluedEntityA<MinePageModel>> continuation);
}
