package com.zego.ve;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/AudioDeviceHelper.class */
public class AudioDeviceHelper {
    public static final int AUDIO_ROUTE_AIR_PLAY = 5;
    public static final int AUDIO_ROUTE_BLUETOOTH = 2;
    public static final int AUDIO_ROUTE_BLUETOOTH_A2DP = 6;
    public static final int AUDIO_ROUTE_CHECK_SCO = -100;
    public static final int AUDIO_ROUTE_HEADSET = 1;
    public static final int AUDIO_ROUTE_INVALID = -1;
    public static final int AUDIO_ROUTE_RECEIVER = 3;
    public static final int AUDIO_ROUTE_SPEAKER = 0;
    public static final int AUDIO_ROUTE_USB_AUDIO = 4;
    public static final int AUDIO_ROUTE_USB_HEADSET = 7;

    public static boolean DetectUsbDeviceState(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            Iterator<Map.Entry<String, UsbDevice>> it = ((UsbManager) context.getSystemService(Context.USB_SERVICE)).getDeviceList().entrySet().iterator();
            boolean z3 = false;
            while (true) {
                z = z3;
                try {
                    if (!it.hasNext()) {
                        break;
                    }
                    boolean z4 = z3;
                    UsbDevice value = it.next().getValue();
                    if (value != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            boolean z5 = z3;
                            z3 = z5;
                            if (!z5) {
                                z3 = z5;
                                if (i2 < value.getConfigurationCount()) {
                                    UsbConfiguration configuration = value.getConfiguration(i2);
                                    if (configuration == null) {
                                        z3 = z5;
                                    } else {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            z3 = z5;
                                            if (i4 >= configuration.getInterfaceCount()) {
                                                break;
                                            }
                                            UsbInterface usbInterface = configuration.getInterface(i4);
                                            if (usbInterface != null && 1 == usbInterface.getInterfaceClass()) {
                                                z3 = true;
                                                break;
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    z2 = z3;
                    th.printStackTrace();
                    z = z2;
                    return z;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    public static boolean HasUsbAudioDevice(Intent intent) {
        boolean z;
        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
        boolean z2 = false;
        if (usbDevice != null) {
            int configurationCount = usbDevice.getConfigurationCount();
            z2 = false;
            int i = 0;
            while (!z2 && i < configurationCount) {
                UsbConfiguration configuration = usbDevice.getConfiguration(i);
                if (configuration != null) {
                    int interfaceCount = configuration.getInterfaceCount();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        z = z2;
                        if (i3 < interfaceCount) {
                            UsbInterface usbInterface = configuration.getInterface(i3);
                            if (usbInterface != null && usbInterface.getInterfaceClass() == 1) {
                                z = true;
                                break;
                            }
                            i2 = i3 + 1;
                        } else {
                            break;
                        }
                    }
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
        }
        return z2;
    }

    public static String RoutType2String(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 6 ? i != 7 ? "DEV_UNKNOWN" : "USB_HEADSET" : "BLUETOOTH_A2DP" : "USB_AUDIO" : "RECEIVER" : "BLUETOOTH_SCO" : "WIRED_HEADSET" : "SPEAKER";
    }

    public static int getBluetoothInput(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        AudioDeviceInfo[] devices = ((AudioManager) context.getSystemService("audio")).getDevices(1);
        int length = devices.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            AudioDeviceInfo audioDeviceInfo = devices[i2];
            if (2 == getRouteType(audioDeviceInfo.getType())) {
                return audioDeviceInfo.getId();
            }
            i = i2 + 1;
        }
    }

    public static int getBluetoothOutput(Context context, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        AudioDeviceInfo[] devices = ((AudioManager) context.getSystemService("audio")).getDevices(2);
        int length = devices.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return 0;
            }
            AudioDeviceInfo audioDeviceInfo = devices[i3];
            int routeType = getRouteType(audioDeviceInfo.getType());
            if (3 == i) {
                if (2 == routeType) {
                    return audioDeviceInfo.getId();
                }
            } else if (6 == routeType) {
                return audioDeviceInfo.getId();
            }
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x013b, code lost:
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0143, code lost:
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0163, code lost:
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018f, code lost:
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0197, code lost:
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01be, code lost:
        if (r0 != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getCurrentRoute(android.content.Context r4, int r5) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.AudioDeviceHelper.getCurrentRoute(android.content.Context, int):int");
    }

    public static String getDeviceTypeStr(int i) {
        switch (i) {
            case 1:
                return "BUILTIN_EARPIECE";
            case 2:
                return "BUILTIN_SPEAKER";
            case 3:
                return "WIRED_HEADSET";
            case 4:
                return "WIRED_HEADPHONES";
            case 5:
                return "LINE_ANALOG";
            case 6:
                return "LINE_DIGITAL";
            case 7:
                return "BLUETOOTH_SCO";
            case 8:
                return "BLUETOOTH_A2DP";
            case 9:
                return "HDMI";
            case 10:
                return "HDMI_ARC";
            case 11:
                return "USB_DEVICE";
            case 12:
                return "USB_ACCESSORY";
            case 13:
                return "DOCK";
            case 14:
                return "FM";
            case 15:
                return "BUILTIN_MIC";
            case 16:
                return "FM_TUNER";
            case 17:
                return "TV_TUNER";
            case 18:
                return "TELEPHONY";
            case 19:
                return "AUX_LINE";
            case 20:
                return "IP";
            case 21:
                return "BUS";
            case 22:
                return "USB_HEADSET";
            case 23:
                return "HEARING_AID";
            case 24:
                return "SPEAKER_SAFE";
            case 25:
                return "REMOTE_SUBMIX";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static int getRouteType(int i) {
        int i2 = 7;
        if (i == 1) {
            i2 = 3;
        } else if (i == 2) {
            return 0;
        } else {
            if (i == 3 || i == 4) {
                return 1;
            }
            if (i == 7) {
                return 2;
            }
            if (i == 8) {
                return 6;
            }
            if (i == 11 || i == 12) {
                return 4;
            }
            if (i != 22) {
                return (i == 24 || i != 25) ? 0 : -1;
            }
        }
        return i2;
    }

    public static boolean scoConnect(Context context) {
        AudioDeviceInfo[] devices = ((AudioManager) context.getSystemService("audio")).getDevices(2);
        int length = devices.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (2 == getRouteType(devices[i2].getType())) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
