package org.conscrypt;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef.class */
abstract class NativeRef {
    final long address;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EC_GROUP.class */
    static final class EC_GROUP extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EC_GROUP(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EC_GROUP_clear_free(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EC_POINT.class */
    static final class EC_POINT extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EC_POINT(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EC_POINT_clear_free(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EVP_CIPHER_CTX.class */
    static final class EVP_CIPHER_CTX extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EVP_CIPHER_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EVP_CIPHER_CTX_free(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EVP_MD_CTX.class */
    static final class EVP_MD_CTX extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EVP_MD_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EVP_MD_CTX_destroy(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EVP_PKEY.class */
    static final class EVP_PKEY extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EVP_PKEY(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EVP_PKEY_free(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$EVP_PKEY_CTX.class */
    static final class EVP_PKEY_CTX extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EVP_PKEY_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.EVP_PKEY_CTX_free(j);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$HMAC_CTX.class */
    static final class HMAC_CTX extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public HMAC_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.HMAC_CTX_free(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/NativeRef$SSL_SESSION.class */
    public static final class SSL_SESSION extends NativeRef {
        /* JADX INFO: Access modifiers changed from: package-private */
        public SSL_SESSION(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        void doFree(long j) {
            NativeCrypto.SSL_SESSION_free(j);
        }
    }

    NativeRef(long j) {
        if (j == 0) {
            throw new NullPointerException("address == 0");
        }
        this.address = j;
    }

    abstract void doFree(long j);

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof NativeRef) {
            if (((NativeRef) obj).address == this.address) {
                z = true;
            }
            return z;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.address != 0) {
                doFree(this.address);
            }
        } finally {
            super.finalize();
        }
    }

    public int hashCode() {
        long j = this.address;
        return (int) (j ^ (j >>> 32));
    }
}
