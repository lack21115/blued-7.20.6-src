package com.blued.android.module.live_china.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.ApiHost;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.live_china.model.LiveCloseInfoModel;
import com.blued.android.module.live_china.model.LiveFinishData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/api/LiveApiService.class */
public interface LiveApiService extends BluedApiService {
    @ApiHost(a = "HOST_HTTP")
    @GET(a = "/live/room/info")
    Object a(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveCloseInfoModel>> continuation);

    @GET(a = "/live/room/info/contributors")
    Object b(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/audiences")
    Object c(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/audience-from")
    Object d(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/giver-from")
    Object e(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/likes")
    Object f(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/new-fans")
    Object g(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/new-followers")
    Object h(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);

    @GET(a = "/live/room/info/comments")
    Object i(@Param(a = "lid") String str, @Param(a = "page") String str2, Continuation<? super BluedEntityA<LiveFinishData>> continuation);
}
