package com.android.org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLEngine.class */
public class OpenSSLEngine {
    private static final Object mLoadingLock;
    private final long ctx;

    static {
        NativeCrypto.ENGINE_load_dynamic();
        mLoadingLock = new Object();
    }

    private OpenSSLEngine(long j) {
        this.ctx = j;
        if (NativeCrypto.ENGINE_init(j) == 0) {
            NativeCrypto.ENGINE_free(j);
            throw new IllegalArgumentException("Could not initialize engine");
        }
    }

    public static OpenSSLEngine getInstance(String str) throws IllegalArgumentException {
        long ENGINE_by_id;
        if (str == null) {
            throw new NullPointerException("engine == null");
        }
        synchronized (mLoadingLock) {
            ENGINE_by_id = NativeCrypto.ENGINE_by_id(str);
            if (ENGINE_by_id == 0) {
                throw new IllegalArgumentException("Unknown ENGINE id: " + str);
            }
            NativeCrypto.ENGINE_add(ENGINE_by_id);
        }
        return new OpenSSLEngine(ENGINE_by_id);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLEngine) {
            OpenSSLEngine openSSLEngine = (OpenSSLEngine) obj;
            if (openSSLEngine.getEngineContext() != this.ctx) {
                String ENGINE_get_id = NativeCrypto.ENGINE_get_id(this.ctx);
                if (ENGINE_get_id == null) {
                    return false;
                }
                return ENGINE_get_id.equals(NativeCrypto.ENGINE_get_id(openSSLEngine.getEngineContext()));
            }
            return true;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            NativeCrypto.ENGINE_finish(this.ctx);
            NativeCrypto.ENGINE_free(this.ctx);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getEngineContext() {
        return this.ctx;
    }

    public PrivateKey getPrivateKeyById(String str) throws InvalidKeyException {
        if (str == null) {
            throw new NullPointerException("id == null");
        }
        long ENGINE_load_private_key = NativeCrypto.ENGINE_load_private_key(this.ctx, str);
        if (ENGINE_load_private_key == 0) {
            return null;
        }
        try {
            return new OpenSSLKey(ENGINE_load_private_key, this, str).getPrivateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidKeyException(e);
        }
    }

    public SecretKey getSecretKeyById(String str, String str2) throws InvalidKeyException {
        if (str == null) {
            throw new NullPointerException("id == null");
        }
        long ENGINE_load_private_key = NativeCrypto.ENGINE_load_private_key(this.ctx, str);
        if (ENGINE_load_private_key == 0) {
            return null;
        }
        try {
            return new OpenSSLKey(ENGINE_load_private_key, this, str).getSecretKey(str2);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidKeyException(e);
        }
    }

    public int hashCode() {
        return (int) this.ctx;
    }
}
