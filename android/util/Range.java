package android.util;

import android.hardware.camera2.utils.HashCodeHelpers;
import com.android.internal.util.Preconditions;
import java.lang.Comparable;

/* loaded from: source-9557208-dex2jar.jar:android/util/Range.class */
public final class Range<T extends Comparable<? super T>> {
    private final T mLower;
    private final T mUpper;

    public Range(T t, T t2) {
        this.mLower = (T) Preconditions.checkNotNull(t, "lower must not be null");
        this.mUpper = (T) Preconditions.checkNotNull(t2, "upper must not be null");
        if (t.compareTo(t2) > 0) {
            throw new IllegalArgumentException("lower must be less than or equal to upper");
        }
    }

    public static <T extends Comparable<? super T>> Range<T> create(T t, T t2) {
        return new Range<>(t, t2);
    }

    public T clamp(T t) {
        T t2;
        Preconditions.checkNotNull(t, "value must not be null");
        if (t.compareTo(this.mLower) < 0) {
            t2 = this.mLower;
        } else {
            t2 = t;
            if (t.compareTo(this.mUpper) > 0) {
                return this.mUpper;
            }
        }
        return t2;
    }

    public boolean contains(Range<T> range) {
        Preconditions.checkNotNull(range, "value must not be null");
        return (range.mLower.compareTo(this.mLower) >= 0) && (range.mUpper.compareTo(this.mUpper) <= 0);
    }

    public boolean contains(T t) {
        Preconditions.checkNotNull(t, "value must not be null");
        return (t.compareTo(this.mLower) >= 0) && (t.compareTo(this.mUpper) <= 0);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Range) {
            Range range = (Range) obj;
            if (!this.mLower.equals(range.mLower) || !this.mUpper.equals(range.mUpper)) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public Range<T> extend(Range<T> range) {
        Preconditions.checkNotNull(range, "range must not be null");
        int compareTo = range.mLower.compareTo(this.mLower);
        int compareTo2 = range.mUpper.compareTo(this.mUpper);
        if (compareTo > 0 || compareTo2 < 0) {
            if (compareTo < 0 || compareTo2 > 0) {
                return create(compareTo >= 0 ? this.mLower : range.mLower, compareTo2 <= 0 ? this.mUpper : range.mUpper);
            }
            return this;
        }
        return range;
    }

    public Range<T> extend(T t) {
        Preconditions.checkNotNull(t, "value must not be null");
        return extend(t, t);
    }

    public Range<T> extend(T t, T t2) {
        Preconditions.checkNotNull(t, "lower must not be null");
        Preconditions.checkNotNull(t2, "upper must not be null");
        int compareTo = t.compareTo(this.mLower);
        int compareTo2 = t2.compareTo(this.mUpper);
        if (compareTo < 0 || compareTo2 > 0) {
            if (compareTo >= 0) {
                t = this.mLower;
            }
            if (compareTo2 <= 0) {
                t2 = this.mUpper;
            }
            return create(t, t2);
        }
        return this;
    }

    public T getLower() {
        return this.mLower;
    }

    public T getUpper() {
        return this.mUpper;
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode(this.mLower, this.mUpper);
    }

    public Range<T> intersect(Range<T> range) {
        Preconditions.checkNotNull(range, "range must not be null");
        int compareTo = range.mLower.compareTo(this.mLower);
        int compareTo2 = range.mUpper.compareTo(this.mUpper);
        if (compareTo > 0 || compareTo2 < 0) {
            if (compareTo < 0 || compareTo2 > 0) {
                return create(compareTo <= 0 ? this.mLower : range.mLower, compareTo2 >= 0 ? this.mUpper : range.mUpper);
            }
            return range;
        }
        return this;
    }

    public Range<T> intersect(T t, T t2) {
        Preconditions.checkNotNull(t, "lower must not be null");
        Preconditions.checkNotNull(t2, "upper must not be null");
        int compareTo = t.compareTo(this.mLower);
        int compareTo2 = t2.compareTo(this.mUpper);
        if (compareTo > 0 || compareTo2 < 0) {
            if (compareTo <= 0) {
                t = this.mLower;
            }
            if (compareTo2 >= 0) {
                t2 = this.mUpper;
            }
            return create(t, t2);
        }
        return this;
    }

    public String toString() {
        return String.format("[%s, %s]", this.mLower, this.mUpper);
    }
}
