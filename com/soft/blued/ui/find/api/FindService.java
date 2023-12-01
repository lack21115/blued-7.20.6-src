package com.soft.blued.ui.find.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.user.model.UserTagAll;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/api/FindService.class */
public interface FindService extends BluedApiService {
    @GET(a = "/users/tags")
    Object a(Continuation<? super BluedEntityA<UserTagAll>> continuation);
}
