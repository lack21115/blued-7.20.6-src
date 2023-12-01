package com.huawei.hms.common.internal;

import android.os.Parcelable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/ResponseErrorCode.class */
public interface ResponseErrorCode {
    int getErrorCode();

    String getErrorReason();

    Parcelable getParcelable();

    String getResolution();

    int getStatusCode();

    String getTransactionId();

    boolean hasResolution();
}
