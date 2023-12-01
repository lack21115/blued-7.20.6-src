package com.huawei.hms.common.data;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/data/DataBufferObserver.class */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i, int i2);

    void onDataRangeInserted(int i, int i2);

    void onDataRangeMoved(int i, int i2, int i3);

    void onDataRangeRemoved(int i, int i2);
}
