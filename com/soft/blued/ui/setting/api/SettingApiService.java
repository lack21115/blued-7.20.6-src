package com.soft.blued.ui.setting.api;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.annotation.GET;
import com.blued.android.module.common.api.annotation.POST;
import com.blued.android.module.common.api.annotation.ParamsMap;
import com.blued.android.module.common.txcloud.CredentialsInfo;
import com.soft.blued.ui.setting.model.FinanceOpenModel;
import com.soft.blued.ui.setting.model.ResetPwdModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/api/SettingApiService.class */
public interface SettingApiService extends BluedApiService {
    @POST(a = "/passport/passwd/reset")
    Object a(@ParamsMap Map<String, String> map, Continuation<? super BluedEntityA<ResetPwdModel>> continuation);

    @GET(a = "/blued/finance/open")
    Object a(Continuation<? super BluedEntityA<FinanceOpenModel>> continuation);

    @GET(a = "/blued/tencent/cos-key")
    Object b(Continuation<? super BluedEntityA<CredentialsInfo>> continuation);
}
