package android.media;

import android.util.SparseIntArray;

/* loaded from: source-9557208-dex2jar.jar:android/media/AudioDevice.class */
public class AudioDevice {
    private static final SparseIntArray EXT_TO_INT_DEVICE_MAPPING;
    private static final SparseIntArray INT_TO_EXT_DEVICE_MAPPING = new SparseIntArray();
    public static final int TYPE_AUX_LINE = 19;
    public static final int TYPE_BLUETOOTH_A2DP = 8;
    public static final int TYPE_BLUETOOTH_SCO = 7;
    public static final int TYPE_BUILTIN_EARPIECE = 1;
    public static final int TYPE_BUILTIN_MIC = 15;
    public static final int TYPE_BUILTIN_SPEAKER = 2;
    public static final int TYPE_DOCK = 13;
    public static final int TYPE_FM = 14;
    public static final int TYPE_FM_TUNER = 16;
    public static final int TYPE_HDMI = 9;
    public static final int TYPE_HDMI_ARC = 10;
    public static final int TYPE_LINE_ANALOG = 5;
    public static final int TYPE_LINE_DIGITAL = 6;
    public static final int TYPE_TELEPHONY = 18;
    public static final int TYPE_TV_TUNER = 17;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_USB_ACCESSORY = 12;
    public static final int TYPE_USB_DEVICE = 11;
    public static final int TYPE_WIRED_HEADPHONES = 4;
    public static final int TYPE_WIRED_HEADSET = 3;
    AudioDevicePortConfig mConfig;

    static {
        INT_TO_EXT_DEVICE_MAPPING.put(1, 1);
        INT_TO_EXT_DEVICE_MAPPING.put(2, 2);
        INT_TO_EXT_DEVICE_MAPPING.put(4, 3);
        INT_TO_EXT_DEVICE_MAPPING.put(8, 4);
        INT_TO_EXT_DEVICE_MAPPING.put(16, 7);
        INT_TO_EXT_DEVICE_MAPPING.put(32, 7);
        INT_TO_EXT_DEVICE_MAPPING.put(64, 7);
        INT_TO_EXT_DEVICE_MAPPING.put(128, 8);
        INT_TO_EXT_DEVICE_MAPPING.put(256, 8);
        INT_TO_EXT_DEVICE_MAPPING.put(512, 8);
        INT_TO_EXT_DEVICE_MAPPING.put(1024, 9);
        INT_TO_EXT_DEVICE_MAPPING.put(2048, 13);
        INT_TO_EXT_DEVICE_MAPPING.put(4096, 13);
        INT_TO_EXT_DEVICE_MAPPING.put(8192, 12);
        INT_TO_EXT_DEVICE_MAPPING.put(16384, 11);
        INT_TO_EXT_DEVICE_MAPPING.put(65536, 18);
        INT_TO_EXT_DEVICE_MAPPING.put(131072, 5);
        INT_TO_EXT_DEVICE_MAPPING.put(262144, 10);
        INT_TO_EXT_DEVICE_MAPPING.put(524288, 6);
        INT_TO_EXT_DEVICE_MAPPING.put(1048576, 14);
        INT_TO_EXT_DEVICE_MAPPING.put(2097152, 19);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483644, 15);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483640, 7);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483632, 3);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483616, 9);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483584, 18);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483520, 15);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147483136, 13);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147482624, 13);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147481600, 12);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147479552, 11);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147475456, 16);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147467264, 17);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147450880, 5);
        INT_TO_EXT_DEVICE_MAPPING.put(-2147418112, 6);
        INT_TO_EXT_DEVICE_MAPPING.put(AudioSystem.DEVICE_IN_BLUETOOTH_A2DP, 8);
        EXT_TO_INT_DEVICE_MAPPING = new SparseIntArray();
        EXT_TO_INT_DEVICE_MAPPING.put(1, 1);
        EXT_TO_INT_DEVICE_MAPPING.put(2, 2);
        EXT_TO_INT_DEVICE_MAPPING.put(3, 4);
        EXT_TO_INT_DEVICE_MAPPING.put(4, 8);
        EXT_TO_INT_DEVICE_MAPPING.put(5, 131072);
        EXT_TO_INT_DEVICE_MAPPING.put(6, 524288);
        EXT_TO_INT_DEVICE_MAPPING.put(7, 16);
        EXT_TO_INT_DEVICE_MAPPING.put(8, 128);
        EXT_TO_INT_DEVICE_MAPPING.put(9, 1024);
        EXT_TO_INT_DEVICE_MAPPING.put(10, 262144);
        EXT_TO_INT_DEVICE_MAPPING.put(11, 16384);
        EXT_TO_INT_DEVICE_MAPPING.put(12, 8192);
        EXT_TO_INT_DEVICE_MAPPING.put(13, 2048);
        EXT_TO_INT_DEVICE_MAPPING.put(14, 1048576);
        EXT_TO_INT_DEVICE_MAPPING.put(15, -2147483644);
        EXT_TO_INT_DEVICE_MAPPING.put(16, -2147475456);
        EXT_TO_INT_DEVICE_MAPPING.put(17, -2147467264);
        EXT_TO_INT_DEVICE_MAPPING.put(18, 65536);
        EXT_TO_INT_DEVICE_MAPPING.put(19, 2097152);
    }

    AudioDevice(AudioDevicePortConfig audioDevicePortConfig) {
        this.mConfig = new AudioDevicePortConfig(audioDevicePortConfig);
    }

    public static int convertDeviceTypeToInternalDevice(int i) {
        return EXT_TO_INT_DEVICE_MAPPING.get(i, 0);
    }

    public static int convertInternalDeviceToDeviceType(int i) {
        return INT_TO_EXT_DEVICE_MAPPING.get(i, 0);
    }

    public String getAddress() {
        return this.mConfig.port().address();
    }

    public int getDeviceType() {
        return INT_TO_EXT_DEVICE_MAPPING.get(this.mConfig.port().type(), 0);
    }

    public boolean isInputDevice() {
        return this.mConfig.port().role() == 1;
    }

    public boolean isOutputDevice() {
        return this.mConfig.port().role() == 2;
    }
}
