package skin.support.collection;

/* loaded from: source-3503164-dex2jar.jar:skin/support/collection/ContainerHelpers.class */
class ContainerHelpers {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f44206a = new int[0];
    static final long[] b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f44207c = new Object[0];

    private ContainerHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
