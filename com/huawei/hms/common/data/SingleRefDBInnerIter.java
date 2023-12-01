package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/data/SingleRefDBInnerIter.class */
public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
    public SingleRefDBInnerIter(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.huawei.hms.common.data.DBInnerIter, java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i = this.index + 1;
            this.index = i;
            if (i == 0) {
                boolean z = this.dataBuffer.get(0) instanceof DataBufferRef;
                Preconditions.checkState(z, "DataBuffer reference of type " + this.dataBuffer.get(0).getClass() + " is not movable");
                ((DataBufferRef) this.dataBuffer.get(0)).getWindowIndex(this.index);
            }
            return (T) this.dataBuffer.get(0);
        }
        return null;
    }
}
