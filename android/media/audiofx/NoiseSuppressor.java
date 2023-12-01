package android.media.audiofx;

import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/NoiseSuppressor.class */
public class NoiseSuppressor extends AudioEffect {
    private static final String TAG = "NoiseSuppressor";

    private NoiseSuppressor(int i) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_NS, EFFECT_TYPE_NULL, 0, i);
    }

    public static NoiseSuppressor create(int i) {
        try {
            try {
                return new NoiseSuppressor(i);
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "not implemented on this device " + ((Object) null));
                return null;
            } catch (UnsupportedOperationException e2) {
                Log.w(TAG, "not enough resources");
                return null;
            } catch (RuntimeException e3) {
                Log.w(TAG, "not enough memory");
                return null;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean isAvailable() {
        return AudioEffect.isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }
}
