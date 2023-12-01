package android.security;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.security.IKeyChainAliasCallback;
import android.security.IKeyChainService;
import com.android.org.conscrypt.OpenSSLEngine;
import com.android.org.conscrypt.TrustedCertificateStore;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.security.InvalidKeyException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-9557208-dex2jar.jar:android/security/KeyChain.class */
public final class KeyChain {
    public static final String ACCOUNT_TYPE = "com.android.keychain";
    private static final String ACTION_CHOOSER = "com.android.keychain.CHOOSER";
    private static final String ACTION_INSTALL = "android.credentials.INSTALL";
    public static final String ACTION_STORAGE_CHANGED = "android.security.STORAGE_CHANGED";
    private static final String CERT_INSTALLER_PACKAGE = "com.android.certinstaller";
    public static final String EXTRA_ALIAS = "alias";
    public static final String EXTRA_CERTIFICATE = "CERT";
    public static final String EXTRA_HOST = "host";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PKCS12 = "PKCS12";
    public static final String EXTRA_PORT = "port";
    public static final String EXTRA_RESPONSE = "response";
    public static final String EXTRA_SENDER = "sender";
    private static final String KEYCHAIN_PACKAGE = "com.android.keychain";
    private static final String TAG = "KeyChain";

    /* loaded from: source-9557208-dex2jar.jar:android/security/KeyChain$AliasResponse.class */
    private static class AliasResponse extends IKeyChainAliasCallback.Stub {
        private final KeyChainAliasCallback keyChainAliasResponse;

        private AliasResponse(KeyChainAliasCallback keyChainAliasCallback) {
            this.keyChainAliasResponse = keyChainAliasCallback;
        }

        @Override // android.security.IKeyChainAliasCallback
        public void alias(String str) {
            this.keyChainAliasResponse.alias(str);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/security/KeyChain$KeyChainConnection.class */
    public static final class KeyChainConnection implements Closeable {
        private final Context context;
        private final IKeyChainService service;
        private final ServiceConnection serviceConnection;

        private KeyChainConnection(Context context, ServiceConnection serviceConnection, IKeyChainService iKeyChainService) {
            this.context = context;
            this.serviceConnection = serviceConnection;
            this.service = iKeyChainService;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.context.unbindService(this.serviceConnection);
        }

        public IKeyChainService getService() {
            return this.service;
        }
    }

    public static KeyChainConnection bind(Context context) throws InterruptedException {
        return bindAsUser(context, Process.myUserHandle());
    }

    public static KeyChainConnection bindAsUser(Context context, UserHandle userHandle) throws InterruptedException {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        ensureNotOnMainThread(context);
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: android.security.KeyChain.1
            volatile boolean mConnectedAtLeastOnce = false;

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (this.mConnectedAtLeastOnce) {
                    return;
                }
                this.mConnectedAtLeastOnce = true;
                try {
                    BlockingQueue.this.put(IKeyChainService.Stub.asInterface(iBinder));
                } catch (InterruptedException e) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        Intent intent = new Intent(IKeyChainService.class.getName());
        intent.setComponent(intent.resolveSystemService(context.getPackageManager(), 0));
        if (context.bindServiceAsUser(intent, serviceConnection, 1, userHandle)) {
            return new KeyChainConnection(context, serviceConnection, (IKeyChainService) linkedBlockingQueue.take());
        }
        throw new AssertionError("could not bind to KeyChainService");
    }

    public static void choosePrivateKeyAlias(Activity activity, KeyChainAliasCallback keyChainAliasCallback, String[] strArr, Principal[] principalArr, String str, int i, String str2) {
        if (activity == null) {
            throw new NullPointerException("activity == null");
        }
        if (keyChainAliasCallback == null) {
            throw new NullPointerException("response == null");
        }
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.setPackage("com.android.keychain");
        intent.putExtra("response", new AliasResponse(keyChainAliasCallback));
        intent.putExtra("host", str);
        intent.putExtra(EXTRA_PORT, i);
        intent.putExtra("alias", str2);
        intent.putExtra("sender", PendingIntent.getActivity(activity, 0, new Intent(), 0));
        activity.startActivity(intent);
    }

    public static Intent createInstallIntent() {
        Intent intent = new Intent("android.credentials.INSTALL");
        intent.setClassName(CERT_INSTALLER_PACKAGE, "com.android.certinstaller.CertInstallerMain");
        return intent;
    }

    private static void ensureNotOnMainThread(Context context) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == context.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        }
    }

    public static X509Certificate[] getCertificateChain(Context context, String str) throws KeyChainException, InterruptedException {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection bind = bind(context);
        try {
            try {
                try {
                    byte[] certificate = bind.getService().getCertificate(str);
                    if (certificate == null) {
                        bind.close();
                        return null;
                    }
                    List<X509Certificate> certificateChain = new TrustedCertificateStore().getCertificateChain(toCertificate(certificate));
                    return (X509Certificate[]) certificateChain.toArray(new X509Certificate[certificateChain.size()]);
                } catch (RemoteException e) {
                    throw new KeyChainException(e);
                } catch (CertificateException e2) {
                    throw new KeyChainException(e2);
                }
            } catch (RuntimeException e3) {
                throw new KeyChainException(e3);
            }
        } finally {
            bind.close();
        }
    }

    public static PrivateKey getPrivateKey(Context context, String str) throws KeyChainException, InterruptedException {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection bind = bind(context);
        try {
            try {
                try {
                    String requestPrivateKey = bind.getService().requestPrivateKey(str);
                    if (requestPrivateKey == null) {
                        throw new KeyChainException("keystore had a problem");
                    }
                    return OpenSSLEngine.getInstance(WifiEnterpriseConfig.ENGINE_ID_KEYSTORE).getPrivateKeyById(requestPrivateKey);
                } catch (RemoteException e) {
                    throw new KeyChainException(e);
                } catch (InvalidKeyException e2) {
                    throw new KeyChainException(e2);
                }
            } catch (RuntimeException e3) {
                throw new KeyChainException(e3);
            }
        } finally {
            bind.close();
        }
    }

    public static boolean isBoundKeyAlgorithm(String str) {
        if (isKeyAlgorithmSupported(str)) {
            return KeyStore.getInstance().isHardwareBacked(str);
        }
        return false;
    }

    public static boolean isKeyAlgorithmSupported(String str) {
        String upperCase = str.toUpperCase(Locale.US);
        return "DSA".equals(upperCase) || "EC".equals(upperCase) || "RSA".equals(upperCase);
    }

    public static X509Certificate toCertificate(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes == null");
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            throw new AssertionError(e);
        }
    }
}
