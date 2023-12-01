package android.hardware.input;

import android.content.Context;
import android.hardware.input.IInputDevicesChangedListener;
import android.hardware.input.IInputManager;
import android.media.AudioAttributes;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.InputEvent;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManager.class */
public final class InputManager {
    public static final String ACTION_QUERY_KEYBOARD_LAYOUTS = "android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS";
    private static final boolean DEBUG = false;
    public static final int DEFAULT_POINTER_SPEED = 0;
    public static final int INJECT_INPUT_EVENT_MODE_ASYNC = 0;
    public static final int INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH = 2;
    public static final int INJECT_INPUT_EVENT_MODE_WAIT_FOR_RESULT = 1;
    public static final int MAX_POINTER_SPEED = 7;
    public static final String META_DATA_KEYBOARD_LAYOUTS = "android.hardware.input.metadata.KEYBOARD_LAYOUTS";
    public static final int MIN_POINTER_SPEED = -7;
    private static final int MSG_DEVICE_ADDED = 1;
    private static final int MSG_DEVICE_CHANGED = 3;
    private static final int MSG_DEVICE_REMOVED = 2;
    private static final String TAG = "InputManager";
    private static InputManager sInstance;
    private final IInputManager mIm;
    private SparseArray<InputDevice> mInputDevices;
    private InputDevicesChangedListener mInputDevicesChangedListener;
    private final Object mInputDevicesLock = new Object();
    private final ArrayList<InputDeviceListenerDelegate> mInputDeviceListeners = new ArrayList<>();

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManager$InputDeviceListener.class */
    public interface InputDeviceListener {
        void onInputDeviceAdded(int i);

        void onInputDeviceChanged(int i);

        void onInputDeviceRemoved(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManager$InputDeviceListenerDelegate.class */
    public static final class InputDeviceListenerDelegate extends Handler {
        public final InputDeviceListener mListener;

        public InputDeviceListenerDelegate(InputDeviceListener inputDeviceListener, Handler handler) {
            super(handler != null ? handler.getLooper() : Looper.myLooper());
            this.mListener = inputDeviceListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.mListener.onInputDeviceAdded(message.arg1);
                    return;
                case 2:
                    this.mListener.onInputDeviceRemoved(message.arg1);
                    return;
                case 3:
                    this.mListener.onInputDeviceChanged(message.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManager$InputDeviceVibrator.class */
    public final class InputDeviceVibrator extends Vibrator {
        private final int mDeviceId;
        private final Binder mToken = new Binder();

        public InputDeviceVibrator(int i) {
            this.mDeviceId = i;
        }

        @Override // android.os.Vibrator
        public void cancel() {
            try {
                InputManager.this.mIm.cancelVibrate(this.mDeviceId, this.mToken);
            } catch (RemoteException e) {
                Log.w(InputManager.TAG, "Failed to cancel vibration.", e);
            }
        }

        @Override // android.os.Vibrator
        public boolean hasVibrator() {
            return true;
        }

        @Override // android.os.Vibrator
        public void vibrate(int i, String str, long j, AudioAttributes audioAttributes) {
            vibrate(new long[]{0, j}, -1);
        }

        @Override // android.os.Vibrator
        public void vibrate(int i, String str, long[] jArr, int i2, AudioAttributes audioAttributes) {
            if (i2 >= jArr.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                InputManager.this.mIm.vibrate(this.mDeviceId, jArr, i2, this.mToken);
            } catch (RemoteException e) {
                Log.w(InputManager.TAG, "Failed to vibrate.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/input/InputManager$InputDevicesChangedListener.class */
    public final class InputDevicesChangedListener extends IInputDevicesChangedListener.Stub {
        private InputDevicesChangedListener() {
        }

        @Override // android.hardware.input.IInputDevicesChangedListener
        public void onInputDevicesChanged(int[] iArr) throws RemoteException {
            InputManager.this.onInputDevicesChanged(iArr);
        }
    }

    private InputManager(IInputManager iInputManager) {
        this.mIm = iInputManager;
    }

    private static boolean containsDeviceId(int[] iArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return false;
            }
            if (iArr[i3] == i) {
                return true;
            }
            i2 = i3 + 2;
        }
    }

    private int findInputDeviceListenerLocked(InputDeviceListener inputDeviceListener) {
        int size = this.mInputDeviceListeners.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            if (this.mInputDeviceListeners.get(i2).mListener == inputDeviceListener) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static InputManager getInstance() {
        InputManager inputManager;
        synchronized (InputManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new InputManager(IInputManager.Stub.asInterface(ServiceManager.getService("input")));
                }
                inputManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inputManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInputDevicesChanged(int[] iArr) {
        synchronized (this.mInputDevicesLock) {
            int size = this.mInputDevices.size();
            while (true) {
                int i = size - 1;
                if (i <= 0) {
                    break;
                }
                int keyAt = this.mInputDevices.keyAt(i);
                size = i;
                if (!containsDeviceId(iArr, keyAt)) {
                    this.mInputDevices.removeAt(i);
                    sendMessageToInputDeviceListenersLocked(2, keyAt);
                    size = i;
                }
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < iArr.length) {
                    int i4 = iArr[i3];
                    int indexOfKey = this.mInputDevices.indexOfKey(i4);
                    if (indexOfKey >= 0) {
                        InputDevice valueAt = this.mInputDevices.valueAt(indexOfKey);
                        if (valueAt != null) {
                            if (valueAt.getGeneration() != iArr[i3 + 1]) {
                                this.mInputDevices.setValueAt(indexOfKey, null);
                                sendMessageToInputDeviceListenersLocked(3, i4);
                            }
                        }
                    } else {
                        this.mInputDevices.put(i4, null);
                        sendMessageToInputDeviceListenersLocked(1, i4);
                    }
                    i2 = i3 + 2;
                }
            }
        }
    }

    private void populateInputDevicesLocked() {
        if (this.mInputDevicesChangedListener == null) {
            InputDevicesChangedListener inputDevicesChangedListener = new InputDevicesChangedListener();
            try {
                this.mIm.registerInputDevicesChangedListener(inputDevicesChangedListener);
                this.mInputDevicesChangedListener = inputDevicesChangedListener;
            } catch (RemoteException e) {
                throw new RuntimeException("Could not get register input device changed listener", e);
            }
        }
        if (this.mInputDevices != null) {
            return;
        }
        try {
            int[] inputDeviceIds = this.mIm.getInputDeviceIds();
            this.mInputDevices = new SparseArray<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= inputDeviceIds.length) {
                    return;
                }
                this.mInputDevices.put(inputDeviceIds[i2], null);
                i = i2 + 1;
            }
        } catch (RemoteException e2) {
            throw new RuntimeException("Could not get input device ids.", e2);
        }
    }

    private void sendMessageToInputDeviceListenersLocked(int i, int i2) {
        int size = this.mInputDeviceListeners.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            InputDeviceListenerDelegate inputDeviceListenerDelegate = this.mInputDeviceListeners.get(i4);
            inputDeviceListenerDelegate.sendMessage(inputDeviceListenerDelegate.obtainMessage(i, i2, 0));
            i3 = i4 + 1;
        }
    }

    public void addKeyboardLayoutForInputDevice(InputDeviceIdentifier inputDeviceIdentifier, String str) {
        if (inputDeviceIdentifier == null) {
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        }
        try {
            this.mIm.addKeyboardLayoutForInputDevice(inputDeviceIdentifier, str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not add keyboard layout for input device.", e);
        }
    }

    public boolean[] deviceHasKeys(int i, int[] iArr) {
        boolean[] zArr = new boolean[iArr.length];
        try {
            this.mIm.hasKeys(i, -256, iArr, zArr);
            return zArr;
        } catch (RemoteException e) {
            return zArr;
        }
    }

    public boolean[] deviceHasKeys(int[] iArr) {
        return deviceHasKeys(-1, iArr);
    }

    public String getCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier inputDeviceIdentifier) {
        try {
            return this.mIm.getCurrentKeyboardLayoutForInputDevice(inputDeviceIdentifier);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get current keyboard layout for input device.", e);
            return null;
        }
    }

    public InputDevice getInputDevice(int i) {
        synchronized (this.mInputDevicesLock) {
            populateInputDevicesLocked();
            int indexOfKey = this.mInputDevices.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            InputDevice valueAt = this.mInputDevices.valueAt(indexOfKey);
            InputDevice inputDevice = valueAt;
            if (valueAt == null) {
                try {
                    InputDevice inputDevice2 = this.mIm.getInputDevice(i);
                    inputDevice = inputDevice2;
                    if (inputDevice2 != null) {
                        this.mInputDevices.setValueAt(indexOfKey, inputDevice2);
                        inputDevice = inputDevice2;
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Could not get input device information.", e);
                }
            }
            return inputDevice;
        }
    }

    public InputDevice getInputDeviceByDescriptor(String str) {
        if (str == null) {
            throw new IllegalArgumentException("descriptor must not be null.");
        }
        synchronized (this.mInputDevicesLock) {
            populateInputDevicesLocked();
            int size = this.mInputDevices.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return null;
                }
                InputDevice valueAt = this.mInputDevices.valueAt(i2);
                InputDevice inputDevice = valueAt;
                if (valueAt == null) {
                    try {
                        valueAt = this.mIm.getInputDevice(this.mInputDevices.keyAt(i2));
                    } catch (RemoteException e) {
                    }
                    if (valueAt == null) {
                        continue;
                        i = i2 + 1;
                    } else {
                        this.mInputDevices.setValueAt(i2, valueAt);
                        inputDevice = valueAt;
                    }
                }
                if (str.equals(inputDevice.getDescriptor())) {
                    return inputDevice;
                }
                i = i2 + 1;
            }
        }
    }

    public int[] getInputDeviceIds() {
        int[] iArr;
        synchronized (this.mInputDevicesLock) {
            populateInputDevicesLocked();
            int size = this.mInputDevices.size();
            iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    iArr[i2] = this.mInputDevices.keyAt(i2);
                    i = i2 + 1;
                }
            }
        }
        return iArr;
    }

    public Vibrator getInputDeviceVibrator(int i) {
        return new InputDeviceVibrator(i);
    }

    public KeyboardLayout getKeyboardLayout(String str) {
        if (str == null) {
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        }
        try {
            return this.mIm.getKeyboardLayout(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get keyboard layout information.", e);
            return null;
        }
    }

    public KeyboardLayout[] getKeyboardLayouts() {
        try {
            return this.mIm.getKeyboardLayouts();
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get list of keyboard layout informations.", e);
            return new KeyboardLayout[0];
        }
    }

    public String[] getKeyboardLayoutsForInputDevice(InputDeviceIdentifier inputDeviceIdentifier) {
        if (inputDeviceIdentifier == null) {
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        }
        try {
            return this.mIm.getKeyboardLayoutsForInputDevice(inputDeviceIdentifier);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get keyboard layouts for input device.", e);
            return (String[]) ArrayUtils.emptyArray(String.class);
        }
    }

    public int getPointerSpeed(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), Settings.System.POINTER_SPEED);
        } catch (Settings.SettingNotFoundException e) {
            return 0;
        }
    }

    public TouchCalibration getTouchCalibration(String str, int i) {
        try {
            return this.mIm.getTouchCalibrationForInputDevice(str, i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not get calibration matrix for input device.", e);
            return TouchCalibration.IDENTITY;
        }
    }

    public boolean injectInputEvent(InputEvent inputEvent, int i) {
        if (inputEvent == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        if (i == 0 || i == 2 || i == 1) {
            try {
                return this.mIm.injectInputEvent(inputEvent, i);
            } catch (RemoteException e) {
                return false;
            }
        }
        throw new IllegalArgumentException("mode is invalid");
    }

    public void registerInputDeviceListener(InputDeviceListener inputDeviceListener, Handler handler) {
        if (inputDeviceListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.mInputDevicesLock) {
            if (findInputDeviceListenerLocked(inputDeviceListener) < 0) {
                this.mInputDeviceListeners.add(new InputDeviceListenerDelegate(inputDeviceListener, handler));
            }
        }
    }

    public void removeKeyboardLayoutForInputDevice(InputDeviceIdentifier inputDeviceIdentifier, String str) {
        if (inputDeviceIdentifier == null) {
            throw new IllegalArgumentException("inputDeviceDescriptor must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        }
        try {
            this.mIm.removeKeyboardLayoutForInputDevice(inputDeviceIdentifier, str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not remove keyboard layout for input device.", e);
        }
    }

    public void setCurrentKeyboardLayoutForInputDevice(InputDeviceIdentifier inputDeviceIdentifier, String str) {
        if (inputDeviceIdentifier == null) {
            throw new IllegalArgumentException("identifier must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("keyboardLayoutDescriptor must not be null");
        }
        try {
            this.mIm.setCurrentKeyboardLayoutForInputDevice(inputDeviceIdentifier, str);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set current keyboard layout for input device.", e);
        }
    }

    public void setPointerSpeed(Context context, int i) {
        if (i < -7 || i > 7) {
            throw new IllegalArgumentException("speed out of range");
        }
        Settings.System.putInt(context.getContentResolver(), Settings.System.POINTER_SPEED, i);
    }

    public void setTouchCalibration(String str, int i, TouchCalibration touchCalibration) {
        try {
            this.mIm.setTouchCalibrationForInputDevice(str, i, touchCalibration);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set calibration matrix for input device.", e);
        }
    }

    public void tryPointerSpeed(int i) {
        if (i < -7 || i > 7) {
            throw new IllegalArgumentException("speed out of range");
        }
        try {
            this.mIm.tryPointerSpeed(i);
        } catch (RemoteException e) {
            Log.w(TAG, "Could not set temporary pointer speed.", e);
        }
    }

    public void unregisterInputDeviceListener(InputDeviceListener inputDeviceListener) {
        if (inputDeviceListener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }
        synchronized (this.mInputDevicesLock) {
            int findInputDeviceListenerLocked = findInputDeviceListenerLocked(inputDeviceListener);
            if (findInputDeviceListenerLocked >= 0) {
                this.mInputDeviceListeners.get(findInputDeviceListenerLocked).removeCallbacksAndMessages(null);
                this.mInputDeviceListeners.remove(findInputDeviceListenerLocked);
            }
        }
    }
}
