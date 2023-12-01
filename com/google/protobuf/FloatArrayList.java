package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/FloatArrayList.class */
public final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, PrimitiveNonBoxingCollection, RandomAccess {
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        EMPTY_LIST = floatArrayList;
        floatArrayList.makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatArrayList() {
        this(new float[10], 0);
    }

    private FloatArrayList(float[] fArr, int i) {
        this.array = fArr;
        this.size = i;
    }

    private void addFloat(int i, float f) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
        float[] fArr = this.array;
        if (i2 < fArr.length) {
            System.arraycopy((Object) fArr, i, (Object) fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, i);
            System.arraycopy((Object) this.array, i, (Object) fArr2, i + 1, this.size - i);
            this.array = fArr2;
        }
        this.array[i] = f;
        this.size++;
        this.modCount++;
    }

    public static FloatArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        return "Index:" + i + ", Size:" + this.size;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Float f) {
        addFloat(i, f.floatValue());
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Float f) {
        addFloat(f.floatValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (collection instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) collection;
            int i = floatArrayList.size;
            if (i == 0) {
                return false;
            }
            int i2 = this.size;
            if (Integer.MAX_VALUE - i2 >= i) {
                int i3 = i2 + i;
                float[] fArr = this.array;
                if (i3 > fArr.length) {
                    this.array = Arrays.copyOf(fArr, i3);
                }
                System.arraycopy((Object) floatArrayList.array, 0, (Object) this.array, this.size, floatArrayList.size);
                this.size = i3;
                this.modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        return super.addAll(collection);
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float f) {
        ensureIsMutable();
        int i = this.size;
        float[] fArr = this.array;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, i);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return true;
            }
            if (Float.floatToIntBits(this.array[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i) {
        return Float.valueOf(getFloat(i));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.size) {
                return i;
            }
            i = (i * 31) + Float.floatToIntBits(this.array[i3]);
            i2 = i3 + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            if (this.array[i2] == floatValue) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i) {
        if (i >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        float[] fArr = this.array;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy((Object) fArr, i + 1, (Object) fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        ensureIsMutable();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.size) {
                return false;
            }
            if (obj.equals(Float.valueOf(this.array[i2]))) {
                float[] fArr = this.array;
                System.arraycopy((Object) fArr, i2 + 1, (Object) fArr, i2, (this.size - i2) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.array;
        System.arraycopy((Object) fArr, i2, (Object) fArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int i, Float f) {
        return Float.valueOf(setFloat(i, f.floatValue()));
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int i, float f) {
        ensureIsMutable();
        ensureIndexInRange(i);
        float[] fArr = this.array;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }
}