package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/ApiException.class */
public class ApiException extends Exception {
    protected final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ApiException(com.huawei.hms.support.api.client.Status r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r4
            int r1 = r1.getStatusCode()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = ": "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.getStatusMessage()
            if (r0 == 0) goto L27
            r0 = r4
            java.lang.String r0 = r0.getStatusMessage()
            r5 = r0
            goto L2a
        L27:
            java.lang.String r0 = ""
            r5 = r0
        L2a:
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r6
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r0 = r3
            r1 = r4
            r0.mStatus = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.ApiException.<init>(com.huawei.hms.support.api.client.Status):void");
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
