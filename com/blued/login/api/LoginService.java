package com.blued.login.api;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.NoVerification;
import com.blued.android.module.common.api.annotation.POST;
import com.blued.android.module.common.api.annotation.Param;
import com.blued.android.module.common.api.annotation.ParamsMap;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.login.model.BluedCheckResult;
import com.blued.login.model.FaceSignModel;
import com.blued.login.model.LoginAVConfigExtra;
import com.blued.login.model.LoginSplashModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/api/LoginService.class */
public interface LoginService extends BluedApiService {
    @POST(a = "/passport/detect")
    Object a(@Param(a = "status") int i, Continuation<? super BluedEntityA<Object>> continuation);

    @POST(a = "/passport/face-id")
    Object a(@Param(a = "name") String str, @Param(a = "id_no") String str2, Continuation<? super BluedEntityA<FaceSignModel>> continuation);

    @NoVerification
    @POST(a = "/passport/name")
    Object a(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<BluedCheckResult>> continuation);

    @GET(a = "/blued/carouse/images")
    @NoVerification
    Object a(Continuation<? super BluedEntityA<LoginSplashModel>> continuation);

    @NoVerification
    @POST(a = "/passport/binding")
    Object b(@ParamsMap Map<String, String> map, Continuation<? super BluedEntity<BluedLoginResult, LoginAVConfigExtra>> continuation);
}
