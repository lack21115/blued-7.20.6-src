package android.security;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.security.IKeystoreService;
import android.util.Log;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/security/KeyStore.class */
public class KeyStore {
    public static final int FLAG_ENCRYPTED = 1;
    public static final int FLAG_NONE = 0;
    public static final int KEY_NOT_FOUND = 7;
    public static final int LOCKED = 2;
    public static final int NO_ERROR = 1;
    public static final int PERMISSION_DENIED = 6;
    public static final int PROTOCOL_ERROR = 5;
    public static final int SYSTEM_ERROR = 4;
    private static final String TAG = "KeyStore";
    public static final int UID_SELF = -1;
    public static final int UNDEFINED_ACTION = 9;
    public static final int UNINITIALIZED = 3;
    public static final int VALUE_CORRUPTED = 8;
    public static final int WRONG_PASSWORD = 10;
    private final IKeystoreService mBinder;
    private int mError = 1;

    /* loaded from: source-9557208-dex2jar.jar:android/security/KeyStore$State.class */
    public enum State {
        UNLOCKED,
        LOCKED,
        UNINITIALIZED
    }

    private KeyStore(IKeystoreService iKeystoreService) {
        this.mBinder = iKeystoreService;
    }

    public static KeyStore getInstance() {
        return new KeyStore(IKeystoreService.Stub.asInterface(ServiceManager.getService("android.security.keystore")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getKeyTypeForAlgorithm(String str) throws IllegalArgumentException {
        if ("RSA".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("DSA".equalsIgnoreCase(str)) {
            return 116;
        }
        if ("EC".equalsIgnoreCase(str)) {
            return 408;
        }
        throw new IllegalArgumentException("Unsupported key type: " + str);
    }

    public boolean clearUid(int i) {
        try {
            return this.mBinder.clear_uid((long) i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean contains(String str) {
        return contains(str, -1);
    }

    public boolean contains(String str, int i) {
        try {
            return this.mBinder.exist(str, i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean delKey(String str) {
        return delKey(str, -1);
    }

    public boolean delKey(String str, int i) {
        try {
            return this.mBinder.del_key(str, i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean delete(String str) {
        return delete(str, -1);
    }

    public boolean delete(String str, int i) {
        try {
            return this.mBinder.del(str, i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean duplicate(String str, int i, String str2, int i2) {
        try {
            return this.mBinder.duplicate(str, i, str2, i2) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean generate(String str, int i, int i2, int i3, int i4, byte[][] bArr) {
        try {
            return this.mBinder.generate(str, i, i2, i3, i4, bArr) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public byte[] get(String str) {
        try {
            return this.mBinder.get(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return null;
        }
    }

    public int getLastError() {
        return this.mError;
    }

    public byte[] getPubkey(String str) {
        try {
            return this.mBinder.get_pubkey(str);
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return null;
        }
    }

    public long getmtime(String str) {
        try {
            long j = this.mBinder.getmtime(str);
            if (j == -1) {
                return -1L;
            }
            return 1000 * j;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return -1L;
        }
    }

    public boolean grant(String str, int i) {
        try {
            return this.mBinder.grant(str, i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean importKey(String str, byte[] bArr, int i, int i2) {
        try {
            return this.mBinder.import_key(str, bArr, i, i2) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean isEmpty() {
        boolean z = false;
        try {
            if (this.mBinder.zero() == 7) {
                z = true;
            }
            return z;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean isHardwareBacked() {
        return isHardwareBacked("RSA");
    }

    public boolean isHardwareBacked(String str) {
        try {
            return this.mBinder.is_hardware_backed(str.toUpperCase(Locale.US)) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean isUnlocked() {
        return state() == State.UNLOCKED;
    }

    public boolean lock() {
        try {
            return this.mBinder.lock() == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean password(String str) {
        try {
            return this.mBinder.password(str) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean passwordUid(String str, int i) {
        try {
            this.mError = this.mBinder.password_uid(str, i);
            return this.mError == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean put(String str, byte[] bArr, int i, int i2) {
        try {
            return this.mBinder.insert(str, bArr, i, i2) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean reset() {
        try {
            return this.mBinder.reset() == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean resetUid(int i) {
        try {
            this.mError = this.mBinder.reset_uid(i);
            return this.mError == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public String[] saw(String str) {
        return saw(str, -1);
    }

    public String[] saw(String str, int i) {
        try {
            return this.mBinder.saw(str, i);
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return null;
        }
    }

    public byte[] sign(String str, byte[] bArr) {
        try {
            return this.mBinder.sign(str, bArr);
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return null;
        }
    }

    public State state() {
        try {
            switch (this.mBinder.test()) {
                case 1:
                    return State.UNLOCKED;
                case 2:
                    return State.LOCKED;
                case 3:
                    return State.UNINITIALIZED;
                default:
                    throw new AssertionError(this.mError);
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            throw new AssertionError(e);
        }
    }

    public boolean syncUid(int i, int i2) {
        try {
            this.mError = this.mBinder.sync_uid(i, i2);
            return this.mError == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean ungrant(String str, int i) {
        try {
            return this.mBinder.ungrant(str, i) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean unlock(String str) {
        try {
            this.mError = this.mBinder.unlock(str);
            return this.mError == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }

    public boolean verify(String str, byte[] bArr, byte[] bArr2) {
        try {
            return this.mBinder.verify(str, bArr, bArr2) == 1;
        } catch (RemoteException e) {
            Log.w(TAG, "Cannot connect to keystore", e);
            return false;
        }
    }
}
