package java.io;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/io/SerializationHandleMap.class */
public final class SerializationHandleMap {
    private static final int LOAD_FACTOR = 7500;
    private Object[] keys;
    private int size = 0;
    private int threshold = 21;
    private int[] values;

    public SerializationHandleMap() {
        resizeArrays((int) ((this.threshold * 10000) / 7500));
    }

    private int findIndex(Object obj, Object[] objArr) {
        int i;
        int length = objArr.length;
        int moduloHash = getModuloHash(obj, length);
        int i2 = moduloHash;
        while (true) {
            i = i2;
            if (i == ((moduloHash + length) - 1) % length || objArr[i] == obj || objArr[i] == null) {
                break;
            }
            i2 = (i + 1) % length;
        }
        return i;
    }

    private int getModuloHash(Object obj, int i) {
        return (System.identityHashCode(obj) & Integer.MAX_VALUE) % i;
    }

    private void rehash() {
        resizeArrays(this.keys.length * 2);
        this.threshold = (int) ((this.keys.length * 7500) / 10000);
    }

    private void resizeArrays(int i) {
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        this.keys = new Object[i];
        this.values = new int[i];
        if (objArr == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= objArr.length) {
                return;
            }
            Object obj = objArr[i3];
            int i4 = iArr[i3];
            int findIndex = findIndex(obj, this.keys);
            this.keys[findIndex] = obj;
            this.values[findIndex] = i4;
            i2 = i3 + 1;
        }
    }

    public int get(Object obj) {
        int findIndex = findIndex(obj, this.keys);
        if (this.keys[findIndex] == obj) {
            return this.values[findIndex];
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int put(Object obj, int i) {
        int findIndex = findIndex(obj, this.keys);
        int i2 = findIndex;
        if (this.keys[findIndex] != obj) {
            int i3 = this.size + 1;
            this.size = i3;
            if (i3 > this.threshold) {
                rehash();
                findIndex = findIndex(obj, this.keys);
            }
            this.keys[findIndex] = obj;
            this.values[findIndex] = -1;
            i2 = findIndex;
        }
        int i4 = this.values[i2];
        this.values[i2] = i;
        return i4;
    }

    public int remove(Object obj) {
        int findIndex = findIndex(obj, this.keys);
        int i = findIndex;
        if (this.keys[i] != obj) {
            return -1;
        }
        int i2 = this.values[i];
        int length = this.keys.length;
        while (true) {
            int i3 = (findIndex + 2) % length;
            Object obj2 = this.keys[i3];
            if (obj2 == null) {
                this.size--;
                this.keys[i] = null;
                this.values[i] = -1;
                return i2;
            }
            int moduloHash = getModuloHash(obj2, length);
            boolean z = moduloHash > i;
            findIndex = i3;
            if (!(i3 < i ? z || moduloHash <= i3 : z && moduloHash <= i3)) {
                this.keys[i] = obj2;
                this.values[i] = this.values[i3];
                i = i3;
                findIndex = i3;
            }
        }
    }
}
