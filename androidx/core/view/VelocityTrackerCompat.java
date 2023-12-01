package androidx.core.view;

import android.view.VelocityTracker;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/VelocityTrackerCompat.class */
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
