package android.hardware.camera2.params;

import android.hardware.camera2.utils.HashCodeHelpers;
import android.util.Range;
import android.util.Size;
import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/HighSpeedVideoConfiguration.class */
public final class HighSpeedVideoConfiguration {
    private final int mFpsMax;
    private final int mFpsMin;
    private final Range<Integer> mFpsRange;
    private final int mHeight;
    private final Size mSize;
    private final int mWidth;

    public HighSpeedVideoConfiguration(int i, int i2, int i3, int i4) {
        if (i4 < 60) {
            throw new IllegalArgumentException("fpsMax must be at least 60");
        }
        this.mFpsMax = i4;
        this.mWidth = Preconditions.checkArgumentPositive(i, "width must be positive");
        this.mHeight = Preconditions.checkArgumentPositive(i2, "height must be positive");
        this.mFpsMin = Preconditions.checkArgumentPositive(i3, "fpsMin must be positive");
        this.mSize = new Size(this.mWidth, this.mHeight);
        this.mFpsRange = new Range<>(Integer.valueOf(this.mFpsMin), Integer.valueOf(this.mFpsMax));
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof HighSpeedVideoConfiguration) {
            HighSpeedVideoConfiguration highSpeedVideoConfiguration = (HighSpeedVideoConfiguration) obj;
            if (this.mWidth != highSpeedVideoConfiguration.mWidth || this.mHeight != highSpeedVideoConfiguration.mHeight || this.mFpsMin != highSpeedVideoConfiguration.mFpsMin || this.mFpsMax != highSpeedVideoConfiguration.mFpsMax) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public int getFpsMax() {
        return this.mFpsMax;
    }

    public int getFpsMin() {
        return this.mFpsMin;
    }

    public Range<Integer> getFpsRange() {
        return this.mFpsRange;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Size getSize() {
        return this.mSize;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return HashCodeHelpers.hashCode(this.mWidth, this.mHeight, this.mFpsMin, this.mFpsMax);
    }
}
