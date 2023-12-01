package android.hardware.display;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.util.SparseArray;
import android.view.Display;
import android.view.Surface;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManager.class */
public final class DisplayManager {
    public static final String ACTION_WIFI_DISPLAY_STATUS_CHANGED = "android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED";
    private static final boolean DEBUG = false;
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    public static final String EXTRA_WIFI_DISPLAY_STATUS = "android.hardware.display.extra.WIFI_DISPLAY_STATUS";
    private static final String TAG = "DisplayManager";
    public static final int VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR = 16;
    public static final int VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY = 8;
    public static final int VIRTUAL_DISPLAY_FLAG_PRESENTATION = 2;
    public static final int VIRTUAL_DISPLAY_FLAG_PUBLIC = 1;
    public static final int VIRTUAL_DISPLAY_FLAG_SECURE = 4;
    public static final int VIRTUAL_DISPLAY_FLAG_SUPPORTS_PROTECTED_BUFFERS = 32;
    private final Context mContext;
    private final Object mLock = new Object();
    private final SparseArray<Display> mDisplays = new SparseArray<>();
    private final ArrayList<Display> mTempDisplays = new ArrayList<>();
    private final DisplayManagerGlobal mGlobal = DisplayManagerGlobal.getInstance();

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/display/DisplayManager$DisplayListener.class */
    public interface DisplayListener {
        void onDisplayAdded(int i);

        void onDisplayChanged(int i);

        void onDisplayRemoved(int i);
    }

    public DisplayManager(Context context) {
        this.mContext = context;
    }

    private void addAllDisplaysLocked(ArrayList<Display> arrayList, int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return;
            }
            Display orCreateDisplayLocked = getOrCreateDisplayLocked(iArr[i2], true);
            if (orCreateDisplayLocked != null) {
                arrayList.add(orCreateDisplayLocked);
            }
            i = i2 + 1;
        }
    }

    private void addPresentationDisplaysLocked(ArrayList<Display> arrayList, int[] iArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return;
            }
            Display orCreateDisplayLocked = getOrCreateDisplayLocked(iArr[i3], true);
            if (orCreateDisplayLocked != null && (orCreateDisplayLocked.getFlags() & 8) != 0 && orCreateDisplayLocked.getType() == i) {
                arrayList.add(orCreateDisplayLocked);
            }
            i2 = i3 + 1;
        }
    }

    private Display getOrCreateDisplayLocked(int i, boolean z) {
        Display display;
        Display display2 = this.mDisplays.get(i);
        if (display2 == null) {
            Display compatibleDisplay = this.mGlobal.getCompatibleDisplay(i, this.mContext.getDisplayAdjustments(i));
            display = compatibleDisplay;
            if (compatibleDisplay != null) {
                this.mDisplays.put(i, compatibleDisplay);
                display = compatibleDisplay;
            }
        } else {
            display = display2;
            if (!z) {
                display = display2;
                if (!display2.isValid()) {
                    return null;
                }
            }
        }
        return display;
    }

    public void connectWifiDisplay(String str) {
        this.mGlobal.connectWifiDisplay(str);
    }

    public VirtualDisplay createVirtualDisplay(MediaProjection mediaProjection, String str, int i, int i2, int i3, Surface surface, int i4, VirtualDisplay.Callback callback, Handler handler) {
        return this.mGlobal.createVirtualDisplay(this.mContext, mediaProjection, str, i, i2, i3, surface, i4, callback, handler);
    }

    public VirtualDisplay createVirtualDisplay(String str, int i, int i2, int i3, Surface surface, int i4) {
        return createVirtualDisplay(str, i, i2, i3, surface, i4, null, null);
    }

    public VirtualDisplay createVirtualDisplay(String str, int i, int i2, int i3, Surface surface, int i4, VirtualDisplay.Callback callback, Handler handler) {
        return createVirtualDisplay(null, str, i, i2, i3, surface, i4, callback, handler);
    }

    public void disconnectWifiDisplay() {
        this.mGlobal.disconnectWifiDisplay();
    }

    public void forgetWifiDisplay(String str) {
        this.mGlobal.forgetWifiDisplay(str);
    }

    public Display getDisplay(int i) {
        Display orCreateDisplayLocked;
        synchronized (this.mLock) {
            orCreateDisplayLocked = getOrCreateDisplayLocked(i, false);
        }
        return orCreateDisplayLocked;
    }

    public Display[] getDisplays() {
        return getDisplays(null);
    }

    public Display[] getDisplays(String str) {
        Display[] displayArr;
        int[] displayIds = this.mGlobal.getDisplayIds();
        synchronized (this.mLock) {
            if (str == null) {
                addAllDisplaysLocked(this.mTempDisplays, displayIds);
            } else if (str.equals("android.hardware.display.category.PRESENTATION")) {
                addPresentationDisplaysLocked(this.mTempDisplays, displayIds, 3);
                addPresentationDisplaysLocked(this.mTempDisplays, displayIds, 2);
                addPresentationDisplaysLocked(this.mTempDisplays, displayIds, 4);
                addPresentationDisplaysLocked(this.mTempDisplays, displayIds, 5);
            }
            displayArr = (Display[]) this.mTempDisplays.toArray(new Display[this.mTempDisplays.size()]);
            this.mTempDisplays.clear();
        }
        return displayArr;
    }

    public WifiDisplayStatus getWifiDisplayStatus() {
        return this.mGlobal.getWifiDisplayStatus();
    }

    public void pauseWifiDisplay() {
        this.mGlobal.pauseWifiDisplay();
    }

    public void registerDisplayListener(DisplayListener displayListener, Handler handler) {
        this.mGlobal.registerDisplayListener(displayListener, handler);
    }

    public void renameWifiDisplay(String str, String str2) {
        this.mGlobal.renameWifiDisplay(str, str2);
    }

    public void resumeWifiDisplay() {
        this.mGlobal.resumeWifiDisplay();
    }

    public void startWifiDisplayScan() {
        this.mGlobal.startWifiDisplayScan();
    }

    public void stopWifiDisplayScan() {
        this.mGlobal.stopWifiDisplayScan();
    }

    public void unregisterDisplayListener(DisplayListener displayListener) {
        this.mGlobal.unregisterDisplayListener(displayListener);
    }
}
