package androidx.media;

import android.media.VolumeProvider;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/VolumeProviderCompatApi21.class */
class VolumeProviderCompatApi21 {

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/VolumeProviderCompatApi21$Delegate.class */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i2, int i3, final Delegate delegate) {
        return new VolumeProvider(i, i2, i3) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                delegate.onAdjustVolume(i4);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                delegate.onSetVolumeTo(i4);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
