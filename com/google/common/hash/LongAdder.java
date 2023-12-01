package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/hash/LongAdder.class */
final class LongAdder extends Striped64 implements LongAddable, Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long j) {
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = threadHashCode.get();
        boolean z = true;
        if (iArr != null) {
            z = true;
            if (cellArr != null) {
                int length = cellArr.length;
                z = true;
                if (length >= 1) {
                    Striped64.Cell cell = cellArr[(length - 1) & iArr[0]];
                    z = true;
                    if (cell != null) {
                        long j3 = cell.value;
                        z = cell.cas(j3, j3 + j);
                        if (z) {
                            return;
                        }
                    }
                }
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // com.google.common.hash.Striped64
    final long fn(long j, long j2) {
        return j + j2;
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long j = this.base;
        Striped64.Cell[] cellArr = this.cells;
        long j2 = j;
        if (cellArr != null) {
            int length = cellArr.length;
            int i = 0;
            while (true) {
                j2 = j;
                if (i >= length) {
                    break;
                }
                Striped64.Cell cell = cellArr[i];
                long j3 = j;
                if (cell != null) {
                    j3 = j + cell.value;
                }
                i++;
                j = j3;
            }
        }
        return j2;
    }

    public long sumThenReset() {
        long j = this.base;
        Striped64.Cell[] cellArr = this.cells;
        this.base = 0L;
        long j2 = j;
        if (cellArr != null) {
            int length = cellArr.length;
            int i = 0;
            while (true) {
                j2 = j;
                if (i >= length) {
                    break;
                }
                Striped64.Cell cell = cellArr[i];
                long j3 = j;
                if (cell != null) {
                    j3 = j + cell.value;
                    cell.value = 0L;
                }
                i++;
                j = j3;
            }
        }
        return j2;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
