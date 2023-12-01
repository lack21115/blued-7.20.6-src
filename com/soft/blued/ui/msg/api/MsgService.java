package com.soft.blued.ui.msg.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.Param;
import com.soft.blued.ui.msg.model.MsgListCheatModel;
import com.soft.blued.ui.msg.model.MsgUserCheatModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/api/MsgService.class */
public interface MsgService extends BluedApiService {
    @GET(a = "/users/chat/cheat/private")
    Object a(@Param(a = "target_uid") String str, Continuation<? super BluedEntityA<MsgUserCheatModel>> continuation);

    @GET(a = "/users/chat/cheat/list")
    Object a(Continuation<? super BluedEntityA<MsgListCheatModel>> continuation);
}
