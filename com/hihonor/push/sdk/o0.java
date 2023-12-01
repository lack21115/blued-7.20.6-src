package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/o0.class */
public class o0 extends p0<PushTokenResult> {
    public o0(String str, IMessageEntity iMessageEntity) {
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
            if (obj instanceof PushTokenResult) {
                PushTokenResult pushTokenResult = (PushTokenResult) obj;
                String pushToken = pushTokenResult.getPushToken();
                try {
                    c.b.a(d.e.a(), pushToken);
                } catch (Exception e) {
                }
                this.f.a((x<TResult>) pushTokenResult);
                return;
            }
            apiException3 = HonorPushErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        new StringBuilder("task execute failed. error:").append(apiException3.getErrorCode());
        this.f.a((Exception) apiException3);
    }
}
