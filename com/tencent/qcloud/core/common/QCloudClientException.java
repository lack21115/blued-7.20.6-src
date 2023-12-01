package com.tencent.qcloud.core.common;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/common/QCloudClientException.class */
public class QCloudClientException extends Exception {
    private static final long serialVersionUID = 1;

    public QCloudClientException(String str) {
        super(str);
    }

    public QCloudClientException(String str, Throwable th) {
        super(str, th);
    }

    public QCloudClientException(Throwable th) {
        super(th);
    }

    public boolean isRetryable() {
        return true;
    }
}
