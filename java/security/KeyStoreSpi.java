package java.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.SecretKey;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyStoreSpi.class */
public abstract class KeyStoreSpi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] getPasswordFromCallBack(KeyStore.ProtectionParameter protectionParameter) throws UnrecoverableEntryException {
        if (protectionParameter == null) {
            return null;
        }
        if (protectionParameter instanceof KeyStore.CallbackHandlerProtection) {
            String property = Security.getProperty("auth.login.defaultCallbackHandler");
            if (property == null) {
                throw new UnrecoverableEntryException("Default CallbackHandler was not defined");
            }
            try {
                CallbackHandler callbackHandler = (CallbackHandler) Class.forName(property).newInstance();
                PasswordCallback[] passwordCallbackArr = {new PasswordCallback("password: ", true)};
                callbackHandler.handle(passwordCallbackArr);
                return passwordCallbackArr[0].getPassword();
            } catch (Exception e) {
                throw new UnrecoverableEntryException(e.toString());
            }
        }
        throw new UnrecoverableEntryException("Incorrect ProtectionParameter");
    }

    public abstract Enumeration<String> engineAliases();

    public abstract boolean engineContainsAlias(String str);

    public abstract void engineDeleteEntry(String str) throws KeyStoreException;

    public boolean engineEntryInstanceOf(String str, Class<? extends KeyStore.Entry> cls) {
        boolean z = true;
        if (engineContainsAlias(str)) {
            try {
                if (engineIsCertificateEntry(str)) {
                    return cls.isAssignableFrom(Class.forName("java.security.KeyStore$TrustedCertificateEntry"));
                }
                if (engineIsKeyEntry(str)) {
                    if (cls.isAssignableFrom(Class.forName("java.security.KeyStore$PrivateKeyEntry"))) {
                        return engineGetCertificate(str) != null;
                    } else if (cls.isAssignableFrom(Class.forName("java.security.KeyStore$SecretKeyEntry"))) {
                        if (engineGetCertificate(str) != null) {
                            z = false;
                        }
                        return z;
                    } else {
                        return false;
                    }
                }
                return false;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
        return false;
    }

    public abstract java.security.cert.Certificate engineGetCertificate(String str);

    public abstract String engineGetCertificateAlias(java.security.cert.Certificate certificate);

    public abstract java.security.cert.Certificate[] engineGetCertificateChain(String str);

    public abstract Date engineGetCreationDate(String str);

    public KeyStore.Entry engineGetEntry(String str, KeyStore.ProtectionParameter protectionParameter) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException {
        if (engineContainsAlias(str)) {
            if (engineIsCertificateEntry(str)) {
                return new KeyStore.TrustedCertificateEntry(engineGetCertificate(str));
            }
            char[] cArr = null;
            if (protectionParameter != null) {
                if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    try {
                        cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                    } catch (IllegalStateException e) {
                        throw new KeyStoreException("Password was destroyed", e);
                    }
                } else if (!(protectionParameter instanceof KeyStore.CallbackHandlerProtection)) {
                    throw new UnrecoverableEntryException("ProtectionParameter object is not PasswordProtection: " + protectionParameter);
                } else {
                    cArr = getPasswordFromCallBack(protectionParameter);
                }
            }
            if (engineIsKeyEntry(str)) {
                Key engineGetKey = engineGetKey(str, cArr);
                if (engineGetKey instanceof PrivateKey) {
                    return new KeyStore.PrivateKeyEntry((PrivateKey) engineGetKey, engineGetCertificateChain(str));
                }
                if (engineGetKey instanceof SecretKey) {
                    return new KeyStore.SecretKeyEntry((SecretKey) engineGetKey);
                }
            }
            throw new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
        }
        return null;
    }

    public abstract Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException;

    public abstract boolean engineIsCertificateEntry(String str);

    public abstract boolean engineIsKeyEntry(String str);

    public abstract void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException;

    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
            return;
        }
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter instanceof KeyStore.PasswordProtection) {
            try {
                engineLoad(null, ((KeyStore.PasswordProtection) protectionParameter).getPassword());
            } catch (IllegalStateException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (!(protectionParameter instanceof KeyStore.CallbackHandlerProtection)) {
            throw new UnsupportedOperationException("protectionParameter is neither PasswordProtection nor CallbackHandlerProtection instance");
        } else {
            try {
                engineLoad(null, getPasswordFromCallBack(protectionParameter));
            } catch (UnrecoverableEntryException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    public abstract void engineSetCertificateEntry(String str, java.security.cert.Certificate certificate) throws KeyStoreException;

    public void engineSetEntry(String str, KeyStore.Entry entry, KeyStore.ProtectionParameter protectionParameter) throws KeyStoreException {
        if (entry == null) {
            throw new KeyStoreException("entry == null");
        }
        if (engineContainsAlias(str)) {
            engineDeleteEntry(str);
        }
        if (entry instanceof KeyStore.TrustedCertificateEntry) {
            engineSetCertificateEntry(str, ((KeyStore.TrustedCertificateEntry) entry).getTrustedCertificate());
            return;
        }
        char[] cArr = null;
        if (protectionParameter != null) {
            if (protectionParameter instanceof KeyStore.PasswordProtection) {
                try {
                    cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } catch (IllegalStateException e) {
                    throw new KeyStoreException("Password was destroyed", e);
                }
            } else if (!(protectionParameter instanceof KeyStore.CallbackHandlerProtection)) {
                throw new KeyStoreException("protParam should be PasswordProtection or CallbackHandlerProtection");
            } else {
                try {
                    cArr = getPasswordFromCallBack(protectionParameter);
                } catch (Exception e2) {
                    throw new KeyStoreException(e2);
                }
            }
        }
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
            engineSetKeyEntry(str, privateKeyEntry.getPrivateKey(), cArr, privateKeyEntry.getCertificateChain());
        } else if (!(entry instanceof KeyStore.SecretKeyEntry)) {
            throw new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry nor TrustedCertificateEntry: " + entry);
        } else {
            engineSetKeyEntry(str, ((KeyStore.SecretKeyEntry) entry).getSecretKey(), cArr, null);
        }
    }

    public abstract void engineSetKeyEntry(String str, Key key, char[] cArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException;

    public abstract void engineSetKeyEntry(String str, byte[] bArr, java.security.cert.Certificate[] certificateArr) throws KeyStoreException;

    public abstract int engineSize();

    public abstract void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException;

    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        throw new UnsupportedOperationException();
    }
}
