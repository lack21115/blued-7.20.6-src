package androidx.media;

import android.os.Build;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/VolumeProviderCompat.class */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;

    /* renamed from: a  reason: collision with root package name */
    private final int f3121a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f3122c;
    private Callback d;
    private Object e;

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/VolumeProviderCompat$Callback.class */
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/media/VolumeProviderCompat$ControlType.class */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.f3121a = i;
        this.b = i2;
        this.f3122c = i3;
    }

    public final int getCurrentVolume() {
        return this.f3122c;
    }

    public final int getMaxVolume() {
        return this.b;
    }

    public final int getVolumeControl() {
        return this.f3121a;
    }

    public Object getVolumeProvider() {
        if (this.e == null && Build.VERSION.SDK_INT >= 21) {
            this.e = VolumeProviderCompatApi21.createVolumeProvider(this.f3121a, this.b, this.f3122c, new VolumeProviderCompatApi21.Delegate() { // from class: androidx.media.VolumeProviderCompat.1
                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onAdjustVolume(int i) {
                    VolumeProviderCompat.this.onAdjustVolume(i);
                }

                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onSetVolumeTo(int i) {
                    VolumeProviderCompat.this.onSetVolumeTo(i);
                }
            });
        }
        return this.e;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        this.d = callback;
    }

    public final void setCurrentVolume(int i) {
        this.f3122c = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        Callback callback = this.d;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
