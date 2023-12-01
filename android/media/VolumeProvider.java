package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/VolumeProvider.class */
public abstract class VolumeProvider {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;

    /* loaded from: source-9557208-dex2jar.jar:android/media/VolumeProvider$Callback.class */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProvider volumeProvider);
    }

    public VolumeProvider(int i, int i2, int i3) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        if (this.mCallback != null) {
            this.mCallback.onVolumeChanged(this);
        }
    }
}
