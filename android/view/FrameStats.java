package android.view;

/* loaded from: source-9557208-dex2jar.jar:android/view/FrameStats.class */
public abstract class FrameStats {
    public static final long UNDEFINED_TIME_NANO = -1;
    protected long[] mFramesPresentedTimeNano;
    protected long mRefreshPeriodNano;

    public final long getEndTimeNano() {
        if (getFrameCount() <= 0) {
            return -1L;
        }
        return this.mFramesPresentedTimeNano[this.mFramesPresentedTimeNano.length - 1];
    }

    public final int getFrameCount() {
        if (this.mFramesPresentedTimeNano != null) {
            return this.mFramesPresentedTimeNano.length;
        }
        return 0;
    }

    public final long getFramePresentedTimeNano(int i) {
        if (this.mFramesPresentedTimeNano == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.mFramesPresentedTimeNano[i];
    }

    public final long getRefreshPeriodNano() {
        return this.mRefreshPeriodNano;
    }

    public final long getStartTimeNano() {
        if (getFrameCount() <= 0) {
            return -1L;
        }
        return this.mFramesPresentedTimeNano[0];
    }
}
