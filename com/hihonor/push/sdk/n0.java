package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/n0.class */
public class n0 extends p0<Void> {
    public n0(String str, IMessageEntity iMessageEntity) {
        super(str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.p0
    public void a(ApiException apiException, Object obj) {
        ApiException apiException2 = apiException;
        if (apiException == null) {
            apiException2 = HonorPushErrorEnum.ERROR_UNKNOWN.toApiException();
        }
        if (apiException2.getErrorCode() == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
            this.f.a((x<TResult>) null);
            return;
        }
        new StringBuilder("task execute failed. error:").append(apiException2.getErrorCode());
        this.f.a((Exception) apiException2);
    }
}
