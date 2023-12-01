package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/size/Size.class */
public class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f9059a;
    private final int b;

    public Size(int i, int i2) {
        this.f9059a = i;
        this.b = i2;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf("x");
            int i = indexOf;
            if (indexOf < 0) {
                i = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, i)), Integer.parseInt(str.substring(i + 1)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        boolean z = false;
        if (obj instanceof Size) {
            Size size = (Size) obj;
            z = false;
            if (this.f9059a == size.f9059a) {
                z = false;
                if (this.b == size.b) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.f9059a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        int i = this.f9059a;
        int i2 = this.b;
        return "Width is " + i + " Height is " + i2;
    }
}
