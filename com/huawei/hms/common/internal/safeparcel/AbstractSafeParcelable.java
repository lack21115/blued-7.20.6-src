package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/safeparcel/AbstractSafeParcelable.class */
public abstract class AbstractSafeParcelable extends Result implements SafeParcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }
}
