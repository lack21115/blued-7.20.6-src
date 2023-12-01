package android.media.audiofx;

import android.media.audiofx.AudioEffect;
import android.util.Log;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/LoudnessEnhancer.class */
public class LoudnessEnhancer extends AudioEffect {
    public static final int PARAM_TARGET_GAIN_MB = 0;
    private static final String TAG = "LoudnessEnhancer";
    private BaseParameterListener mBaseParamListener;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/LoudnessEnhancer$BaseParameterListener.class */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        private BaseParameterListener() {
        }

        @Override // android.media.audiofx.AudioEffect.OnParameterChangeListener
        public void onParameterChange(AudioEffect audioEffect, int i, byte[] bArr, byte[] bArr2) {
            if (i != 0) {
                return;
            }
            OnParameterChangeListener onParameterChangeListener = null;
            synchronized (LoudnessEnhancer.this.mParamListenerLock) {
                if (LoudnessEnhancer.this.mParamListener != null) {
                    onParameterChangeListener = LoudnessEnhancer.this.mParamListener;
                }
            }
            if (onParameterChangeListener != null) {
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                if (bArr.length == 4) {
                    i2 = AudioEffect.byteArrayToInt(bArr, 0);
                }
                if (bArr2.length == 4) {
                    i3 = AudioEffect.byteArrayToInt(bArr2, 0);
                }
                if (i2 == -1 || i3 == Integer.MIN_VALUE) {
                    return;
                }
                onParameterChangeListener.onParameterChange(LoudnessEnhancer.this, i2, i3);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/LoudnessEnhancer$OnParameterChangeListener.class */
    public interface OnParameterChangeListener {
        void onParameterChange(LoudnessEnhancer loudnessEnhancer, int i, int i2);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/LoudnessEnhancer$Settings.class */
    public static class Settings {
        public int targetGainmB;

        public Settings() {
        }

        public Settings(String str) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "=;");
            if (stringTokenizer.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + str);
            }
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.equals(LoudnessEnhancer.TAG)) {
                throw new IllegalArgumentException("invalid settings for LoudnessEnhancer: " + nextToken);
            }
            try {
                String nextToken2 = stringTokenizer.nextToken();
                if (!nextToken2.equals("targetGainmB")) {
                    throw new IllegalArgumentException("invalid key name: " + nextToken2);
                }
                this.targetGainmB = Integer.parseInt(stringTokenizer.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid value for key: " + nextToken);
            }
        }

        public String toString() {
            return new String("LoudnessEnhancer;targetGainmB=" + Integer.toString(this.targetGainmB));
        }
    }

    public LoudnessEnhancer(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_LOUDNESS_ENHANCER, EFFECT_TYPE_NULL, 0, i);
        this.mParamListener = null;
        this.mBaseParamListener = null;
        this.mParamListenerLock = new Object();
        if (i == 0) {
            Log.w(TAG, "WARNING: attaching a LoudnessEnhancer to global output mix is deprecated!");
        }
    }

    public LoudnessEnhancer(int i, int i2) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_LOUDNESS_ENHANCER, EFFECT_TYPE_NULL, i, i2);
        this.mParamListener = null;
        this.mBaseParamListener = null;
        this.mParamListenerLock = new Object();
        if (i2 == 0) {
            Log.w(TAG, "WARNING: attaching a LoudnessEnhancer to global output mix is deprecated!");
        }
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        int[] iArr = new int[1];
        checkStatus(getParameter(0, iArr));
        settings.targetGainmB = iArr[0];
        return settings;
    }

    public float getTargetGain() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] iArr = new int[1];
        checkStatus(getParameter(0, iArr));
        return iArr[0];
    }

    public void setParameterListener(OnParameterChangeListener onParameterChangeListener) {
        synchronized (this.mParamListenerLock) {
            if (this.mParamListener == null) {
                this.mBaseParamListener = new BaseParameterListener();
                super.setParameterListener(this.mBaseParamListener);
            }
            this.mParamListener = onParameterChangeListener;
        }
    }

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, settings.targetGainmB));
    }

    public void setTargetGain(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, i));
    }
}
