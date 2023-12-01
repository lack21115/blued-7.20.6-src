package java.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.callback.CallbackHandler;
import libcore.io.IoUtils;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore.class */
public class KeyStore {
    private static final String DEFAULT_KEYSTORE_TYPE = "jks";
    private static final String PROPERTY_NAME = "keystore.type";
    private final KeyStoreSpi implSpi;
    private boolean isInit = false;
    private final Provider provider;
    private final String type;
    private static final String SERVICE = "KeyStore";
    private static final Engine ENGINE = new Engine(SERVICE);

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$Builder.class */
    public static abstract class Builder {

        /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$Builder$BuilderImpl.class */
        private static class BuilderImpl extends Builder {
            private final File fileForLoad;
            private boolean isGetKeyStore;
            private KeyStore keyStore;
            private KeyStoreException lastException = null;
            private ProtectionParameter protParameter;
            private final Provider providerForKeyStore;
            private final String typeForKeyStore;

            BuilderImpl(KeyStore keyStore, ProtectionParameter protectionParameter, File file, String str, Provider provider) {
                this.isGetKeyStore = false;
                this.keyStore = keyStore;
                this.protParameter = protectionParameter;
                this.fileForLoad = file;
                this.typeForKeyStore = str;
                this.providerForKeyStore = provider;
                this.isGetKeyStore = false;
            }

            @Override // java.security.KeyStore.Builder
            public KeyStore getKeyStore() throws KeyStoreException {
                KeyStore keyStore;
                char[] passwordFromCallBack;
                FileInputStream fileInputStream;
                FileInputStream fileInputStream2;
                synchronized (this) {
                    if (this.lastException != null) {
                        throw this.lastException;
                    }
                    if (this.keyStore != null) {
                        this.isGetKeyStore = true;
                        keyStore = this.keyStore;
                    } else {
                        try {
                            keyStore = this.providerForKeyStore == null ? KeyStore.getInstance(this.typeForKeyStore) : KeyStore.getInstance(this.typeForKeyStore, this.providerForKeyStore);
                            if (this.protParameter instanceof PasswordProtection) {
                                passwordFromCallBack = ((PasswordProtection) this.protParameter).getPassword();
                            } else if (!(this.protParameter instanceof CallbackHandlerProtection)) {
                                throw new KeyStoreException("protectionParameter is neither PasswordProtection nor CallbackHandlerProtection instance");
                            } else {
                                passwordFromCallBack = KeyStoreSpi.getPasswordFromCallBack(this.protParameter);
                            }
                            if (this.fileForLoad != null) {
                                try {
                                    fileInputStream2 = new FileInputStream(this.fileForLoad);
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = null;
                                }
                                try {
                                    keyStore.load(fileInputStream2, passwordFromCallBack);
                                    IoUtils.closeQuietly(fileInputStream2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    IoUtils.closeQuietly(fileInputStream);
                                    throw th;
                                }
                            } else {
                                keyStore.load(new TmpLSParameter(this.protParameter));
                            }
                            this.isGetKeyStore = true;
                        } catch (KeyStoreException e) {
                            this.lastException = e;
                            throw e;
                        } catch (Exception e2) {
                            KeyStoreException keyStoreException = new KeyStoreException(e2);
                            this.lastException = keyStoreException;
                            throw keyStoreException;
                        }
                    }
                }
                return keyStore;
            }

            @Override // java.security.KeyStore.Builder
            public ProtectionParameter getProtectionParameter(String str) throws KeyStoreException {
                ProtectionParameter protectionParameter;
                synchronized (this) {
                    if (str == null) {
                        throw new NullPointerException("alias == null");
                    }
                    if (!this.isGetKeyStore) {
                        throw new IllegalStateException("getKeyStore() was not invoked");
                    }
                    protectionParameter = this.protParameter;
                }
                return protectionParameter;
            }
        }

        /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$Builder$TmpLSParameter.class */
        private static class TmpLSParameter implements LoadStoreParameter {
            private final ProtectionParameter protPar;

            public TmpLSParameter(ProtectionParameter protectionParameter) {
                this.protPar = protectionParameter;
            }

            @Override // java.security.KeyStore.LoadStoreParameter
            public ProtectionParameter getProtectionParameter() {
                return this.protPar;
            }
        }

        protected Builder() {
        }

        public static Builder newInstance(String str, Provider provider, File file, ProtectionParameter protectionParameter) {
            if (str == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            if ((protectionParameter instanceof PasswordProtection) || (protectionParameter instanceof CallbackHandlerProtection)) {
                if (file.exists()) {
                    if (file.isFile()) {
                        return new BuilderImpl(null, protectionParameter, file, str, provider);
                    }
                    throw new IllegalArgumentException("Not a regular file: " + file.getName());
                }
                throw new IllegalArgumentException("File does not exist: " + file.getName());
            }
            throw new IllegalArgumentException("protectionParameter is neither PasswordProtection nor CallbackHandlerProtection instance");
        }

        public static Builder newInstance(String str, Provider provider, ProtectionParameter protectionParameter) {
            if (str == null) {
                throw new NullPointerException("type == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            return new BuilderImpl(null, protectionParameter, null, str, provider);
        }

        public static Builder newInstance(KeyStore keyStore, ProtectionParameter protectionParameter) {
            if (keyStore == null) {
                throw new NullPointerException("keyStore == null");
            }
            if (protectionParameter == null) {
                throw new NullPointerException("protectionParameter == null");
            }
            if (keyStore.isInit) {
                return new BuilderImpl(keyStore, protectionParameter, null, null, null);
            }
            throw new IllegalArgumentException("KeyStore was not initialized");
        }

        public abstract KeyStore getKeyStore() throws KeyStoreException;

        public abstract ProtectionParameter getProtectionParameter(String str) throws KeyStoreException;
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$CallbackHandlerProtection.class */
    public static class CallbackHandlerProtection implements ProtectionParameter {
        private final CallbackHandler callbackHandler;

        public CallbackHandlerProtection(CallbackHandler callbackHandler) {
            if (callbackHandler == null) {
                throw new NullPointerException("handler == null");
            }
            this.callbackHandler = callbackHandler;
        }

        public CallbackHandler getCallbackHandler() {
            return this.callbackHandler;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$Entry.class */
    public interface Entry {
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$LoadStoreParameter.class */
    public interface LoadStoreParameter {
        ProtectionParameter getProtectionParameter();
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$PasswordProtection.class */
    public static class PasswordProtection implements ProtectionParameter, Destroyable {
        private boolean isDestroyed = false;
        private char[] password;

        public PasswordProtection(char[] cArr) {
            if (cArr != null) {
                this.password = (char[]) cArr.clone();
            }
        }

        @Override // javax.security.auth.Destroyable
        public void destroy() throws DestroyFailedException {
            synchronized (this) {
                this.isDestroyed = true;
                if (this.password != null) {
                    Arrays.fill(this.password, (char) 0);
                    this.password = null;
                }
            }
        }

        public char[] getPassword() {
            char[] cArr;
            synchronized (this) {
                if (this.isDestroyed) {
                    throw new IllegalStateException("Password was destroyed");
                }
                cArr = this.password;
            }
            return cArr;
        }

        @Override // javax.security.auth.Destroyable
        public boolean isDestroyed() {
            boolean z;
            synchronized (this) {
                z = this.isDestroyed;
            }
            return z;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$PrivateKeyEntry.class */
    public static final class PrivateKeyEntry implements Entry {
        private java.security.cert.Certificate[] chain;
        private PrivateKey privateKey;

        public PrivateKeyEntry(PrivateKey privateKey, java.security.cert.Certificate[] certificateArr) {
            boolean z;
            if (privateKey == null) {
                throw new NullPointerException("privateKey == null");
            }
            if (certificateArr == null) {
                throw new NullPointerException("chain == null");
            }
            if (certificateArr.length == 0) {
                throw new IllegalArgumentException("chain.length == 0");
            }
            String type = certificateArr[0].getType();
            if (!certificateArr[0].getPublicKey().getAlgorithm().equals(privateKey.getAlgorithm())) {
                throw new IllegalArgumentException("Algorithm of private key does not match algorithm of public key in end certificate of entry (with index number: 0)");
            }
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= certificateArr.length) {
                    int length = certificateArr.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        z = true;
                        if (i4 >= length) {
                            break;
                        } else if (!(certificateArr[i4] instanceof X509Certificate)) {
                            z = false;
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    if (z) {
                        this.chain = new X509Certificate[certificateArr.length];
                    } else {
                        this.chain = new java.security.cert.Certificate[certificateArr.length];
                    }
                    System.arraycopy(certificateArr, 0, this.chain, 0, certificateArr.length);
                    this.privateKey = privateKey;
                    return;
                } else if (!type.equals(certificateArr[i2].getType())) {
                    throw new IllegalArgumentException("Certificates from the given chain have different types");
                } else {
                    i = i2 + 1;
                }
            }
        }

        public java.security.cert.Certificate getCertificate() {
            return this.chain[0];
        }

        public java.security.cert.Certificate[] getCertificateChain() {
            return (java.security.cert.Certificate[]) this.chain.clone();
        }

        public PrivateKey getPrivateKey() {
            return this.privateKey;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PrivateKeyEntry: number of elements in certificate chain is ");
            sb.append(Integer.toString(this.chain.length));
            sb.append("\n");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.chain.length) {
                    return sb.toString();
                }
                sb.append(this.chain[i2].toString());
                sb.append("\n");
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$ProtectionParameter.class */
    public interface ProtectionParameter {
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$SecretKeyEntry.class */
    public static final class SecretKeyEntry implements Entry {
        private final SecretKey secretKey;

        public SecretKeyEntry(SecretKey secretKey) {
            if (secretKey == null) {
                throw new NullPointerException("secretKey == null");
            }
            this.secretKey = secretKey;
        }

        public SecretKey getSecretKey() {
            return this.secretKey;
        }

        public String toString() {
            return "SecretKeyEntry: algorithm - " + this.secretKey.getAlgorithm();
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyStore$TrustedCertificateEntry.class */
    public static final class TrustedCertificateEntry implements Entry {
        private final java.security.cert.Certificate trustCertificate;

        public TrustedCertificateEntry(java.security.cert.Certificate certificate) {
            if (certificate == null) {
                throw new NullPointerException("trustCertificate == null");
            }
            this.trustCertificate = certificate;
        }

        public java.security.cert.Certificate getTrustedCertificate() {
            return this.trustCertificate;
        }

        public String toString() {
            return "Trusted certificate entry:\n" + this.trustCertificate;
        }
    }

    protected KeyStore(KeyStoreSpi keyStoreSpi, Provider provider, String str) {
        this.type = str;
        this.provider = provider;
        this.implSpi = keyStoreSpi;
    }

    public static final String getDefaultType() {
        String property = Security.getProperty(PROPERTY_NAME);
        String str = property;
        if (property == null) {
            str = DEFAULT_KEYSTORE_TYPE;
        }
        return str;
    }

    public static KeyStore getInstance(String str) throws KeyStoreException {
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
            return new KeyStore((KeyStoreSpi) engine.spi, engine.provider, str);
        } catch (NoSuchAlgorithmException e) {
            throw new KeyStoreException(e);
        }
    }

    public static KeyStore getInstance(String str, String str2) throws KeyStoreException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        try {
            return getInstance(str, provider);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    public static KeyStore getInstance(String str, Provider provider) throws KeyStoreException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            return new KeyStore((KeyStoreSpi) ENGINE.getInstance(str, provider, null), provider, str);
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    private static void throwNotInitialized() throws KeyStoreException {
        throw new KeyStoreException("KeyStore was not initialized");
    }

    public final Enumeration<String> aliases() throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineAliases();
    }

    public final boolean containsAlias(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineContainsAlias(str);
    }

    public final void deleteEntry(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        this.implSpi.engineDeleteEntry(str);
    }

    public final boolean entryInstanceOf(String str, Class<? extends Entry> cls) throws KeyStoreException {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        if (cls == null) {
            throw new NullPointerException("entryClass == null");
        }
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineEntryInstanceOf(str, cls);
    }

    public final java.security.cert.Certificate getCertificate(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetCertificate(str);
    }

    public final String getCertificateAlias(java.security.cert.Certificate certificate) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetCertificateAlias(certificate);
    }

    public final java.security.cert.Certificate[] getCertificateChain(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetCertificateChain(str);
    }

    public final Date getCreationDate(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetCreationDate(str);
    }

    public final Entry getEntry(String str, ProtectionParameter protectionParameter) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetEntry(str, protectionParameter);
    }

    public final Key getKey(String str, char[] cArr) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineGetKey(str, cArr);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isCertificateEntry(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineIsCertificateEntry(str);
    }

    public final boolean isKeyEntry(String str) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineIsKeyEntry(str);
    }

    public final void load(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.implSpi.engineLoad(inputStream, cArr);
        this.isInit = true;
    }

    public final void load(LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.implSpi.engineLoad(loadStoreParameter);
        this.isInit = true;
    }

    public final void setCertificateEntry(String str, java.security.cert.Certificate certificate) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        this.implSpi.engineSetCertificateEntry(str, certificate);
    }

    public final void setEntry(String str, Entry entry, ProtectionParameter protectionParameter) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        if (entry == null) {
            throw new NullPointerException("entry == null");
        }
        this.implSpi.engineSetEntry(str, entry, protectionParameter);
    }

    public final void setKeyEntry(String str, Key key, char[] cArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        if (key != null && (key instanceof PrivateKey) && (certificateArr == null || certificateArr.length == 0)) {
            throw new IllegalArgumentException("Certificate chain is not defined for Private key");
        }
        this.implSpi.engineSetKeyEntry(str, key, cArr, certificateArr);
    }

    public final void setKeyEntry(String str, byte[] bArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        this.implSpi.engineSetKeyEntry(str, bArr, certificateArr);
    }

    public final int size() throws KeyStoreException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        return this.implSpi.engineSize();
    }

    public final void store(OutputStream outputStream, char[] cArr) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        this.implSpi.engineStore(outputStream, cArr);
    }

    public final void store(LoadStoreParameter loadStoreParameter) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        if (!this.isInit) {
            throwNotInitialized();
        }
        this.implSpi.engineStore(loadStoreParameter);
    }
}
