package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/hardware/fingerprint/FingerprintManagerCompat.class */
public class FingerprintManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2430a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/hardware/fingerprint/FingerprintManagerCompat$AuthenticationCallback.class */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/hardware/fingerprint/FingerprintManagerCompat$AuthenticationResult.class */
    public static final class AuthenticationResult {

        /* renamed from: a  reason: collision with root package name */
        private final CryptoObject f2432a;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.f2432a = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.f2432a;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/hardware/fingerprint/FingerprintManagerCompat$CryptoObject.class */
    public static class CryptoObject {

        /* renamed from: a  reason: collision with root package name */
        private final Signature f2433a;
        private final Cipher b;

        /* renamed from: c  reason: collision with root package name */
        private final Mac f2434c;

        public CryptoObject(Signature signature) {
            this.f2433a = signature;
            this.b = null;
            this.f2434c = null;
        }

        public CryptoObject(Cipher cipher) {
            this.b = cipher;
            this.f2433a = null;
            this.f2434c = null;
        }

        public CryptoObject(Mac mac) {
            this.f2434c = mac;
            this.b = null;
            this.f2433a = null;
        }

        public Cipher getCipher() {
            return this.b;
        }

        public Mac getMac() {
            return this.f2434c;
        }

        public Signature getSignature() {
            return this.f2433a;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.f2430a = context;
    }

    private static FingerprintManager.AuthenticationCallback a(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() { // from class: androidx.core.hardware.fingerprint.FingerprintManagerCompat.1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.a(authenticationResult.getCryptoObject())));
            }
        };
    }

    private static FingerprintManager.CryptoObject a(CryptoObject cryptoObject) {
        FingerprintManager.CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            cryptoObject2 = new FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return cryptoObject2;
    }

    private static FingerprintManager a(Context context) {
        if (Build.VERSION.SDK_INT == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (Build.VERSION.SDK_INT <= 23 || !context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    static CryptoObject a(FingerprintManager.CryptoObject cryptoObject) {
        CryptoObject cryptoObject2 = null;
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getMac());
        }
        return cryptoObject2;
    }

    public static FingerprintManagerCompat from(Context context) {
        return new FingerprintManagerCompat(context);
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManager a2;
        if (Build.VERSION.SDK_INT < 23 || (a2 = a(this.f2430a)) == null) {
            return;
        }
        a2.authenticate(a(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, a(authenticationCallback), handler);
    }

    public boolean hasEnrolledFingerprints() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23) {
            FingerprintManager a2 = a(this.f2430a);
            z = false;
            if (a2 != null) {
                z = false;
                if (a2.hasEnrolledFingerprints()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isHardwareDetected() {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 23) {
            FingerprintManager a2 = a(this.f2430a);
            z = false;
            if (a2 != null) {
                z = false;
                if (a2.isHardwareDetected()) {
                    z = true;
                }
            }
        }
        return z;
    }
}
