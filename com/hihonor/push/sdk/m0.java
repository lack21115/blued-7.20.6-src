package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/m0.class */
public class m0 extends p0<BooleanResult> {
    public m0(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.p0
    public void a(ApiException apiException, Object obj) {
        ApiException apiException2 = apiException;
        if (apiException == null) {
            apiException2 = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
        }
        ApiException apiException3 = apiException2;
        if (apiException2.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
            if (obj instanceof BooleanResult) {
                this.f.a((x<TResult>) ((BooleanResult) obj));
                return;
            }
            apiException3 = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        new StringBuilder("task execute failed. error:").append(apiException3.getErrorCode());
        this.f.a((Exception) apiException3);
    }
}
