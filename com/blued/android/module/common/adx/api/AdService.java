package com.blued.android.module.common.adx.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.login.model.BluedADExtra;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/api/AdService.class */
public interface AdService extends BluedApiService {
    @GET(a = "/tx/adx/banner")
    Object a(Continuation<? super BluedEntityA<BluedADExtra>> continuation);
}
