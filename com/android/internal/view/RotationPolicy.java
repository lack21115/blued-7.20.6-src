package com.android.internal.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/RotationPolicy.class */
public final class RotationPolicy {
    private static final int CURRENT_ROTATION = -1;
    private static final int NATURAL_ROTATION = SystemProperties.getInt("persist.panel.orientation", 0) / 90;
    private static final String TAG = "RotationPolicy";

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/RotationPolicy$RotationPolicyListener.class */
    public static abstract class RotationPolicyListener {
        final ContentObserver mObserver = new ContentObserver(new Handler()) { // from class: com.android.internal.view.RotationPolicy.RotationPolicyListener.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                RotationPolicyListener.this.onChange();
            }
        };

        public abstract void onChange();
    }

    private RotationPolicy() {
    }

    public static int getRotationLockOrientation(Context context) {
        int i = 0;
        if (!isCurrentRotationAllowed(context)) {
            Point point = new Point();
            try {
                WindowManagerGlobal.getWindowManagerService().getInitialDisplaySize(0, point);
                if (point.x >= point.y) {
                    return 2;
                }
                i = 1;
            } catch (RemoteException e) {
                Log.w(TAG, "Unable to get the display size");
                return 0;
            }
        }
        return i;
    }

    private static boolean isCurrentRotationAllowed(Context context) {
        try {
            return isRotationAllowed(WindowManagerGlobal.getWindowManagerService().getRotation(), Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION_ANGLES, -1), context.getResources().getBoolean(R.bool.config_allowAllRotations));
        } catch (RemoteException e) {
            Log.w(TAG, "Unable to getWindowManagerService.getRotation()");
            return false;
        }
    }

    public static boolean isRotationAllowed(int i, int i2, boolean z) {
        boolean z2;
        int i3 = i2;
        if (i2 < 0) {
            i3 = z ? 15 : 11;
        }
        switch (i) {
            case 0:
                z2 = true;
                if ((i3 & 1) == 0) {
                    return false;
                }
                break;
            case 1:
                z2 = true;
                if ((i3 & 2) == 0) {
                    return false;
                }
                break;
            case 2:
                z2 = true;
                if ((i3 & 4) == 0) {
                    return false;
                }
                break;
            case 3:
                z2 = true;
                if ((i3 & 8) == 0) {
                    return false;
                }
                break;
            default:
                z2 = false;
                break;
        }
        return z2;
    }

    public static boolean isRotationLockToggleVisible(Context context) {
        boolean z = false;
        if (isRotationSupported(context)) {
            z = false;
            if (Settings.System.getIntForUser(context.getContentResolver(), Settings.System.HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY, 0, -2) == 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isRotationLocked(Context context) {
        boolean z = false;
        if (Settings.System.getIntForUser(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0, -2) == 0) {
            z = true;
        }
        return z;
    }

    public static boolean isRotationSupported(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER) && packageManager.hasSystemFeature(PackageManager.FEATURE_SCREEN_PORTRAIT) && packageManager.hasSystemFeature(PackageManager.FEATURE_SCREEN_LANDSCAPE) && context.getResources().getBoolean(R.bool.config_supportAutoRotation);
    }

    public static void registerRotationPolicyListener(Context context, RotationPolicyListener rotationPolicyListener) {
        registerRotationPolicyListener(context, rotationPolicyListener, UserHandle.getCallingUserId());
    }

    public static void registerRotationPolicyListener(Context context, RotationPolicyListener rotationPolicyListener, int i) {
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.ACCELEROMETER_ROTATION), false, rotationPolicyListener.mObserver, i);
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY), false, rotationPolicyListener.mObserver, i);
    }

    public static void setRotationLock(Context context, boolean z) {
        Settings.System.putIntForUser(context.getContentResolver(), Settings.System.HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY, 0, -2);
        setRotationLock(z, isCurrentRotationAllowed(context) ? -1 : NATURAL_ROTATION);
    }

    private static void setRotationLock(final boolean z, final int i) {
        AsyncTask.execute(new Runnable() { // from class: com.android.internal.view.RotationPolicy.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
                    if (z) {
                        windowManagerService.freezeRotation(i);
                    } else {
                        windowManagerService.thawRotation();
                    }
                } catch (RemoteException e) {
                    Log.w(RotationPolicy.TAG, "Unable to save auto-rotate setting");
                }
            }
        });
    }

    public static void setRotationLockForAccessibility(Context context, boolean z) {
        Settings.System.putIntForUser(context.getContentResolver(), Settings.System.HIDE_ROTATION_LOCK_TOGGLE_FOR_ACCESSIBILITY, z ? 1 : 0, -2);
        setRotationLock(z, NATURAL_ROTATION);
    }

    public static void unregisterRotationPolicyListener(Context context, RotationPolicyListener rotationPolicyListener) {
        context.getContentResolver().unregisterContentObserver(rotationPolicyListener.mObserver);
    }
}
