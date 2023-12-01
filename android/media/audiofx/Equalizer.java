package android.media.audiofx;

import android.media.audiofx.AudioEffect;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Equalizer.class */
public class Equalizer extends AudioEffect {
    public static final int PARAM_BAND_FREQ_RANGE = 4;
    public static final int PARAM_BAND_LEVEL = 2;
    public static final int PARAM_CENTER_FREQ = 3;
    public static final int PARAM_CURRENT_PRESET = 6;
    public static final int PARAM_GET_BAND = 5;
    public static final int PARAM_GET_NUM_OF_PRESETS = 7;
    public static final int PARAM_GET_PRESET_NAME = 8;
    public static final int PARAM_LEVEL_RANGE = 1;
    public static final int PARAM_NUM_BANDS = 0;
    private static final int PARAM_PROPERTIES = 9;
    public static final int PARAM_STRING_SIZE_MAX = 32;
    private static final String TAG = "Equalizer";
    private BaseParameterListener mBaseParamListener;
    private short mNumBands;
    private int mNumPresets;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock;
    private String[] mPresetNames;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Equalizer$BaseParameterListener.class */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        private BaseParameterListener() {
        }

        @Override // android.media.audiofx.AudioEffect.OnParameterChangeListener
        public void onParameterChange(AudioEffect audioEffect, int i, byte[] bArr, byte[] bArr2) {
            OnParameterChangeListener onParameterChangeListener = null;
            synchronized (Equalizer.this.mParamListenerLock) {
                if (Equalizer.this.mParamListener != null) {
                    onParameterChangeListener = Equalizer.this.mParamListener;
                }
            }
            if (onParameterChangeListener != null) {
                int i2 = -1;
                short s = -1;
                int i3 = -1;
                if (bArr.length >= 4) {
                    int byteArrayToInt = AudioEffect.byteArrayToInt(bArr, 0);
                    i2 = byteArrayToInt;
                    i3 = -1;
                    if (bArr.length >= 8) {
                        i3 = AudioEffect.byteArrayToInt(bArr, 4);
                        i2 = byteArrayToInt;
                    }
                }
                if (bArr2.length == 2) {
                    s = AudioEffect.byteArrayToShort(bArr2, 0);
                } else if (bArr2.length == 4) {
                    s = AudioEffect.byteArrayToInt(bArr2, 0);
                }
                if (i2 == -1 || s == -1) {
                    return;
                }
                onParameterChangeListener.onParameterChange(Equalizer.this, i, i2, i3, s);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Equalizer$OnParameterChangeListener.class */
    public interface OnParameterChangeListener {
        void onParameterChange(Equalizer equalizer, int i, int i2, int i3, int i4);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Equalizer$Settings.class */
    public static class Settings {
        public short[] bandLevels;
        public short curPreset;
        public short numBands;

        public Settings() {
            this.numBands = (short) 0;
            this.bandLevels = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v49, types: [int] */
        public Settings(String str) {
            this.numBands = (short) 0;
            this.bandLevels = null;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "=;");
            stringTokenizer.countTokens();
            if (stringTokenizer.countTokens() < 5) {
                throw new IllegalArgumentException("settings: " + str);
            }
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.equals(Equalizer.TAG)) {
                throw new IllegalArgumentException("invalid settings for Equalizer: " + nextToken);
            }
            try {
                String nextToken2 = stringTokenizer.nextToken();
                if (!nextToken2.equals("curPreset")) {
                    throw new IllegalArgumentException("invalid key name: " + nextToken2);
                }
                this.curPreset = Short.parseShort(stringTokenizer.nextToken());
                String nextToken3 = stringTokenizer.nextToken();
                if (!nextToken3.equals("numBands")) {
                    throw new IllegalArgumentException("invalid key name: " + nextToken3);
                }
                this.numBands = Short.parseShort(stringTokenizer.nextToken());
                if (stringTokenizer.countTokens() != this.numBands * 2) {
                    throw new IllegalArgumentException("settings: " + str);
                }
                this.bandLevels = new short[this.numBands];
                String str2 = nextToken3;
                for (short s = 0; s < this.numBands; s++) {
                    String str3 = str2;
                    str2 = stringTokenizer.nextToken();
                    if (!str2.equals("band" + (s + 1) + "Level")) {
                        throw new IllegalArgumentException("invalid key name: " + str2);
                    }
                    this.bandLevels[s] = Short.parseShort(stringTokenizer.nextToken());
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid value for key: " + nextToken);
            }
        }

        public String toString() {
            String str = new String("Equalizer;curPreset=" + Short.toString(this.curPreset) + ";numBands=" + Short.toString(this.numBands));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.numBands) {
                    return str;
                }
                str = str.concat(";band" + (i2 + 1) + "Level=" + Short.toString(this.bandLevels[i2]));
                i = i2 + 1;
            }
        }
    }

    public Equalizer(int i, int i2) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_EQUALIZER, EFFECT_TYPE_NULL, i, i2);
        int i3;
        this.mNumBands = (short) 0;
        this.mParamListener = null;
        this.mBaseParamListener = null;
        this.mParamListenerLock = new Object();
        if (i2 == 0) {
            Log.w(TAG, "WARNING: attaching an Equalizer to global output mix is deprecated!");
        }
        getNumberOfBands();
        this.mNumPresets = getNumberOfPresets();
        if (this.mNumPresets == 0) {
            return;
        }
        this.mPresetNames = new String[this.mNumPresets];
        byte[] bArr = new byte[32];
        int[] iArr = new int[2];
        iArr[0] = 8;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.mNumPresets) {
                return;
            }
            iArr[1] = i5;
            checkStatus(getParameter(iArr, bArr));
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (bArr[i3] != 0) {
                    i6 = i3 + 1;
                } else {
                    try {
                        break;
                    } catch (UnsupportedEncodingException e) {
                        Log.e(TAG, "preset name decode error");
                    }
                }
            }
            this.mPresetNames[i5] = new String(bArr, 0, i3, "ISO-8859-1");
            i4 = i5 + 1;
        }
    }

    public short getBand(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[1];
        checkStatus(getParameter(new int[]{5, i}, sArr));
        return sArr[0];
    }

    public int[] getBandFreqRange(short s) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] iArr = new int[2];
        checkStatus(getParameter(new int[]{4, s}, iArr));
        return iArr;
    }

    public short getBandLevel(short s) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[1];
        checkStatus(getParameter(new int[]{2, s}, sArr));
        return sArr[0];
    }

    public short[] getBandLevelRange() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[2];
        checkStatus(getParameter(1, sArr));
        return sArr;
    }

    public int getCenterFreq(short s) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] iArr = new int[1];
        checkStatus(getParameter(new int[]{3, s}, iArr));
        return iArr[0];
    }

    public short getCurrentPreset() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[1];
        checkStatus(getParameter(6, sArr));
        return sArr[0];
    }

    public short getNumberOfBands() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (this.mNumBands != 0) {
            return this.mNumBands;
        }
        short[] sArr = new short[1];
        checkStatus(getParameter(new int[]{0}, sArr));
        this.mNumBands = sArr[0];
        return this.mNumBands;
    }

    public short getNumberOfPresets() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[1];
        checkStatus(getParameter(7, sArr));
        return sArr[0];
    }

    public String getPresetName(short s) {
        return (s < 0 || s >= this.mNumPresets) ? "" : this.mPresetNames[s];
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] bArr = new byte[(this.mNumBands * 2) + 4];
        checkStatus(getParameter(9, bArr));
        Settings settings = new Settings();
        settings.curPreset = byteArrayToShort(bArr, 0);
        settings.numBands = byteArrayToShort(bArr, 2);
        settings.bandLevels = new short[this.mNumBands];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNumBands) {
                return settings;
            }
            settings.bandLevels[i2] = byteArrayToShort(bArr, (i2 * 2) + 4);
            i = i2 + 1;
        }
    }

    public void setBandLevel(short s, short s2) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(new int[]{2, s}, new short[]{s2}));
    }

    public void setParameterListener(OnParameterChangeListener onParameterChangeListener) {
        synchronized (this.mParamListenerLock) {
            if (this.mParamListener == null) {
                this.mParamListener = onParameterChangeListener;
                this.mBaseParamListener = new BaseParameterListener();
                super.setParameterListener(this.mBaseParamListener);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[], byte[][]] */
    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (settings.numBands != settings.bandLevels.length || settings.numBands != this.mNumBands) {
            throw new IllegalArgumentException("settings invalid band count: " + ((int) settings.numBands));
        }
        byte[] concatArrays = concatArrays(new byte[]{shortToByteArray(settings.curPreset), shortToByteArray(this.mNumBands)});
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNumBands) {
                checkStatus(setParameter(9, concatArrays));
                return;
            } else {
                concatArrays = concatArrays(new byte[]{concatArrays, shortToByteArray(settings.bandLevels[i2])});
                i = i2 + 1;
            }
        }
    }

    public void usePreset(short s) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(6, s));
    }
}
