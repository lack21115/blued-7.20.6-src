package androidx.appcompat.widget;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/RtlSpacingHelper.class */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private int f1803a = 0;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1804c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int getEnd() {
        return this.g ? this.f1803a : this.b;
    }

    public int getLeft() {
        return this.f1803a;
    }

    public int getRight() {
        return this.b;
    }

    public int getStart() {
        return this.g ? this.b : this.f1803a;
    }

    public void setAbsolute(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f1803a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.b = i2;
        }
    }

    public void setDirection(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f1803a = this.e;
            this.b = this.f;
        } else if (z) {
            int i = this.d;
            if (i == Integer.MIN_VALUE) {
                i = this.e;
            }
            this.f1803a = i;
            int i2 = this.f1804c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.b = i2;
        } else {
            int i3 = this.f1804c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.e;
            }
            this.f1803a = i3;
            int i4 = this.d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f;
            }
            this.b = i4;
        }
    }

    public void setRelative(int i, int i2) {
        this.f1804c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1803a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1803a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }
}
