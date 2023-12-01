package android.hardware.usb;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbManager.class */
public class UsbManager {
    public static final String ACTION_USB_ACCESSORY_ATTACHED = "android.hardware.usb.action.USB_ACCESSORY_ATTACHED";
    public static final String ACTION_USB_ACCESSORY_DETACHED = "android.hardware.usb.action.USB_ACCESSORY_DETACHED";
    public static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    public static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    public static final String ACTION_USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static final String EXTRA_ACCESSORY = "accessory";
    public static final String EXTRA_DEVICE = "device";
    public static final String EXTRA_PERMISSION_GRANTED = "permission";
    private static final String TAG = "UsbManager";
    public static final String USB_CONFIGURED = "configured";
    public static final String USB_CONNECTED = "connected";
    public static final String USB_FUNCTION_ACCESSORY = "accessory";
    public static final String USB_FUNCTION_ADB = "adb";
    public static final String USB_FUNCTION_AUDIO_SOURCE = "audio_source";
    public static final String USB_FUNCTION_CHARGING = "charging";
    public static final String USB_FUNCTION_MASS_STORAGE = "mass_storage";
    public static final String USB_FUNCTION_MTP = "mtp";
    public static final String USB_FUNCTION_PTP = "ptp";
    public static final String USB_FUNCTION_RNDIS = "rndis";
    private final Context mContext;
    private final IUsbManager mService;

    public UsbManager(Context context, IUsbManager iUsbManager) {
        this.mContext = context;
        this.mService = iUsbManager;
    }

    private static boolean propertyContainsFunction(String str, String str2) {
        String str3 = SystemProperties.get(str, "");
        int indexOf = str3.indexOf(str2);
        if (indexOf < 0) {
            return false;
        }
        if (indexOf <= 0 || str3.charAt(indexOf - 1) == ',') {
            int length = indexOf + str2.length();
            return length >= str3.length() || str3.charAt(length) == ',';
        }
        return false;
    }

    public UsbAccessory[] getAccessoryList() {
        try {
            UsbAccessory currentAccessory = this.mService.getCurrentAccessory();
            if (currentAccessory == null) {
                return null;
            }
            return new UsbAccessory[]{currentAccessory};
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getAccessoryList", e);
            return null;
        }
    }

    public String getDefaultFunction() {
        String str = SystemProperties.get("persist.sys.usb.config", "");
        int indexOf = str.indexOf(44);
        String str2 = str;
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
        }
        return str2;
    }

    public HashMap<String, UsbDevice> getDeviceList() {
        HashMap<String, UsbDevice> hashMap;
        Bundle bundle = new Bundle();
        try {
            this.mService.getDeviceList(bundle);
            HashMap<String, UsbDevice> hashMap2 = new HashMap<>();
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                hashMap = hashMap2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                hashMap2.put(next, (UsbDevice) bundle.get(next));
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getDeviceList", e);
            hashMap = null;
        }
        return hashMap;
    }

    public boolean hasPermission(UsbAccessory usbAccessory) {
        try {
            return this.mService.hasAccessoryPermission(usbAccessory);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in hasPermission", e);
            return false;
        }
    }

    public boolean hasPermission(UsbDevice usbDevice) {
        try {
            return this.mService.hasDevicePermission(usbDevice);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in hasPermission", e);
            return false;
        }
    }

    public boolean isFunctionEnabled(String str) {
        return propertyContainsFunction("sys.usb.config", str);
    }

    public ParcelFileDescriptor openAccessory(UsbAccessory usbAccessory) {
        try {
            return this.mService.openAccessory(usbAccessory);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in openAccessory", e);
            return null;
        }
    }

    public UsbDeviceConnection openDevice(UsbDevice usbDevice) {
        try {
            String deviceName = usbDevice.getDeviceName();
            ParcelFileDescriptor openDevice = this.mService.openDevice(deviceName);
            if (openDevice != null) {
                UsbDeviceConnection usbDeviceConnection = new UsbDeviceConnection(usbDevice);
                boolean open = usbDeviceConnection.open(deviceName, openDevice);
                openDevice.close();
                if (open) {
                    return usbDeviceConnection;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "exception in UsbManager.openDevice", e);
            return null;
        }
    }

    public void requestPermission(UsbAccessory usbAccessory, PendingIntent pendingIntent) {
        try {
            this.mService.requestAccessoryPermission(usbAccessory, this.mContext.getPackageName(), pendingIntent);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in requestPermission", e);
        }
    }

    public void requestPermission(UsbDevice usbDevice, PendingIntent pendingIntent) {
        try {
            this.mService.requestDevicePermission(usbDevice, this.mContext.getPackageName(), pendingIntent);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in requestPermission", e);
        }
    }

    public void setCurrentFunction(String str, boolean z) {
        try {
            this.mService.setCurrentFunction(str, z);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setCurrentFunction", e);
        }
    }

    public void setMassStorageBackingFile(String str) {
        try {
            this.mService.setMassStorageBackingFile(str);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setDefaultFunction", e);
        }
    }
}
