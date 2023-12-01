package android.app;

import android.app.trust.ITrustManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.view.IOnKeyguardExitResult;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;

/* loaded from: source-9557208-dex2jar.jar:android/app/KeyguardManager.class */
public class KeyguardManager {
    public static final String ACTION_CONFIRM_DEVICE_CREDENTIAL = "android.app.action.CONFIRM_DEVICE_CREDENTIAL";
    public static final String EXTRA_DESCRIPTION = "android.app.extra.DESCRIPTION";
    public static final String EXTRA_TITLE = "android.app.extra.TITLE";
    private IWindowManager mWM = WindowManagerGlobal.getWindowManagerService();
    private ITrustManager mTrustManager = ITrustManager.Stub.asInterface(ServiceManager.getService(Context.TRUST_SERVICE));

    /* loaded from: source-9557208-dex2jar.jar:android/app/KeyguardManager$KeyguardLock.class */
    public class KeyguardLock {
        private final String mTag;
        private final IBinder mToken = new Binder();

        KeyguardLock(String str) {
            this.mTag = str;
        }

        public void disableKeyguard() {
            try {
                KeyguardManager.this.mWM.disableKeyguard(this.mToken, this.mTag);
            } catch (RemoteException e) {
            }
        }

        public void reenableKeyguard() {
            try {
                KeyguardManager.this.mWM.reenableKeyguard(this.mToken);
            } catch (RemoteException e) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/KeyguardManager$OnKeyguardExitResult.class */
    public interface OnKeyguardExitResult {
        void onKeyguardExitResult(boolean z);
    }

    public Intent createConfirmDeviceCredentialIntent(CharSequence charSequence, CharSequence charSequence2) {
        if (isKeyguardSecure()) {
            Intent intent = new Intent(ACTION_CONFIRM_DEVICE_CREDENTIAL);
            intent.putExtra(EXTRA_TITLE, charSequence);
            intent.putExtra(EXTRA_DESCRIPTION, charSequence2);
            intent.setPackage("com.android.settings");
            return intent;
        }
        return null;
    }

    @Deprecated
    public void exitKeyguardSecurely(final OnKeyguardExitResult onKeyguardExitResult) {
        try {
            this.mWM.exitKeyguardSecurely(new IOnKeyguardExitResult.Stub() { // from class: android.app.KeyguardManager.1
                @Override // android.view.IOnKeyguardExitResult
                public void onKeyguardExitResult(boolean z) throws RemoteException {
                    if (onKeyguardExitResult != null) {
                        onKeyguardExitResult.onKeyguardExitResult(z);
                    }
                }
            });
        } catch (RemoteException e) {
        }
    }

    public boolean inKeyguardRestrictedInputMode() {
        try {
            return this.mWM.inKeyguardRestrictedInputMode();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isDeviceLocked() {
        return isDeviceLocked(UserHandle.getCallingUserId());
    }

    public boolean isDeviceLocked(int i) {
        try {
            return this.mTrustManager.isDeviceLocked(i);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isKeyguardLocked() {
        try {
            return this.mWM.isKeyguardLocked();
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean isKeyguardSecure() {
        try {
            return this.mWM.isKeyguardSecure();
        } catch (RemoteException e) {
            return false;
        }
    }

    @Deprecated
    public KeyguardLock newKeyguardLock(String str) {
        return new KeyguardLock(str);
    }
}
