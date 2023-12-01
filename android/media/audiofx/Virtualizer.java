package android.media.audiofx;

import android.media.AudioDevice;
import android.media.AudioFormat;
import android.media.audiofx.AudioEffect;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.StringTokenizer;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Virtualizer.class */
public class Virtualizer extends AudioEffect {
    private static final boolean DEBUG = false;
    public static final int PARAM_FORCE_VIRTUALIZATION_MODE = 3;
    public static final int PARAM_STRENGTH = 1;
    public static final int PARAM_STRENGTH_SUPPORTED = 0;
    public static final int PARAM_VIRTUALIZATION_MODE = 4;
    public static final int PARAM_VIRTUAL_SPEAKER_ANGLES = 2;
    private static final String TAG = "Virtualizer";
    public static final int VIRTUALIZATION_MODE_AUTO = 1;
    public static final int VIRTUALIZATION_MODE_BINAURAL = 2;
    public static final int VIRTUALIZATION_MODE_OFF = 0;
    public static final int VIRTUALIZATION_MODE_TRANSAURAL = 3;
    private BaseParameterListener mBaseParamListener;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock;
    private boolean mStrengthSupported;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Virtualizer$BaseParameterListener.class */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        private BaseParameterListener() {
        }

        @Override // android.media.audiofx.AudioEffect.OnParameterChangeListener
        public void onParameterChange(AudioEffect audioEffect, int i, byte[] bArr, byte[] bArr2) {
            OnParameterChangeListener onParameterChangeListener = null;
            synchronized (Virtualizer.this.mParamListenerLock) {
                if (Virtualizer.this.mParamListener != null) {
                    onParameterChangeListener = Virtualizer.this.mParamListener;
                }
            }
            if (onParameterChangeListener != null) {
                int i2 = -1;
                short s = -1;
                if (bArr.length == 4) {
                    i2 = AudioEffect.byteArrayToInt(bArr, 0);
                }
                if (bArr2.length == 2) {
                    s = AudioEffect.byteArrayToShort(bArr2, 0);
                }
                if (i2 == -1 || s == -1) {
                    return;
                }
                onParameterChangeListener.onParameterChange(Virtualizer.this, i, i2, s);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Virtualizer$OnParameterChangeListener.class */
    public interface OnParameterChangeListener {
        void onParameterChange(Virtualizer virtualizer, int i, int i2, short s);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiofx/Virtualizer$Settings.class */
    public static class Settings {
        public short strength;

        public Settings() {
        }

        public Settings(String str) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "=;");
            stringTokenizer.countTokens();
            if (stringTokenizer.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + str);
            }
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.equals(Virtualizer.TAG)) {
                throw new IllegalArgumentException("invalid settings for Virtualizer: " + nextToken);
            }
            try {
                String nextToken2 = stringTokenizer.nextToken();
                if (!nextToken2.equals("strength")) {
                    throw new IllegalArgumentException("invalid key name: " + nextToken2);
                }
                this.strength = Short.parseShort(stringTokenizer.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid value for key: " + nextToken);
            }
        }

        public String toString() {
            return new String("Virtualizer;strength=" + Short.toString(this.strength));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Virtualizer(int i, int i2) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_VIRTUALIZER, EFFECT_TYPE_NULL, i, i2);
        boolean z = true;
        this.mStrengthSupported = false;
        this.mParamListener = null;
        this.mBaseParamListener = null;
        this.mParamListenerLock = new Object();
        if (i2 == 0) {
            Log.w(TAG, "WARNING: attaching a Virtualizer to global output mix is deprecated!");
        }
        int[] iArr = new int[1];
        checkStatus(getParameter(0, iArr));
        this.mStrengthSupported = iArr[0] == 0 ? false : z;
    }

    private static int deviceToMode(int i) {
        switch (i) {
            case 1:
            case 3:
            case 4:
            case 7:
                return 2;
            case 2:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 19:
                return 3;
            case 15:
            case 16:
            case 17:
            case 18:
            default:
                return 0;
        }
    }

    private boolean getAnglesInt(int i, int i2, int[] iArr) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (i == 0) {
            throw new IllegalArgumentException("Virtualizer: illegal CHANNEL_INVALID channel mask");
        }
        if (i == 1) {
            i = 12;
        }
        int channelCountFromOutChannelMask = AudioFormat.channelCountFromOutChannelMask(i);
        if (iArr != null && iArr.length < channelCountFromOutChannelMask * 3) {
            Log.e(TAG, "Size of array for angles cannot accomodate number of channels in mask (" + channelCountFromOutChannelMask + ")");
            throw new IllegalArgumentException("Virtualizer: array for channel / angle pairs is too small: is " + iArr.length + ", should be " + (channelCountFromOutChannelMask * 3));
        }
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.nativeOrder());
        allocate.putInt(2);
        allocate.putInt(AudioFormat.convertChannelOutMaskToNativeMask(i));
        allocate.putInt(AudioDevice.convertDeviceTypeToInternalDevice(i2));
        byte[] bArr = new byte[channelCountFromOutChannelMask * 4 * 3];
        int parameter = getParameter(allocate.array(), bArr);
        if (parameter < 0) {
            if (parameter == -4) {
                return false;
            }
            checkStatus(parameter);
            Log.e(TAG, "unexpected status code " + parameter + " after getParameter(PARAM_VIRTUAL_SPEAKER_ANGLES)");
            return false;
        } else if (iArr == null) {
            return true;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.nativeOrder());
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= channelCountFromOutChannelMask) {
                    return true;
                }
                iArr[i4 * 3] = AudioFormat.convertNativeChannelMaskToOutMask(wrap.getInt(i4 * 4 * 3));
                iArr[(i4 * 3) + 1] = wrap.getInt((i4 * 4 * 3) + 4);
                iArr[(i4 * 3) + 2] = wrap.getInt((i4 * 4 * 3) + 8);
                i3 = i4 + 1;
            }
        }
    }

    private static int getDeviceForModeForce(int i) throws IllegalArgumentException {
        if (i == 1) {
            return 0;
        }
        return getDeviceForModeQuery(i);
    }

    private static int getDeviceForModeQuery(int i) throws IllegalArgumentException {
        switch (i) {
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                throw new IllegalArgumentException("Virtualizer: illegal virtualization mode " + i);
        }
    }

    public boolean canVirtualize(int i, int i2) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        return getAnglesInt(i, getDeviceForModeQuery(i2), null);
    }

    public boolean forceVirtualizationMode(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        boolean z = false;
        int parameter = setParameter(3, AudioDevice.convertDeviceTypeToInternalDevice(getDeviceForModeForce(i)));
        if (parameter >= 0) {
            z = true;
        } else if (parameter != -4) {
            checkStatus(parameter);
            Log.e(TAG, "unexpected status code " + parameter + " after setParameter(PARAM_FORCE_VIRTUALIZATION_MODE)");
            return false;
        }
        return z;
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short[] sArr = new short[1];
        checkStatus(getParameter(1, sArr));
        settings.strength = sArr[0];
        return settings;
    }

    public short getRoundedStrength() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] sArr = new short[1];
        checkStatus(getParameter(1, sArr));
        return sArr[0];
    }

    public boolean getSpeakerAngles(int i, int i2, int[] iArr) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (iArr == null) {
            throw new IllegalArgumentException("Virtualizer: illegal null channel / angle array");
        }
        return getAnglesInt(i, getDeviceForModeQuery(i2), iArr);
    }

    public boolean getStrengthSupported() {
        return this.mStrengthSupported;
    }

    public int getVirtualizationMode() throws IllegalStateException, UnsupportedOperationException {
        int i = 0;
        int[] iArr = new int[1];
        int parameter = getParameter(4, iArr);
        if (parameter >= 0) {
            i = deviceToMode(AudioDevice.convertInternalDeviceToDeviceType(iArr[0]));
        } else if (parameter != -4) {
            checkStatus(parameter);
            Log.e(TAG, "unexpected status code " + parameter + " after getParameter(PARAM_VIRTUALIZATION_MODE)");
            return 0;
        }
        return i;
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

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, settings.strength));
    }

    public void setStrength(short s) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, s));
    }
}
