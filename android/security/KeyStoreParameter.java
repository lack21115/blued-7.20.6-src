package android.security;

import android.content.Context;
import java.security.KeyStore;

/* loaded from: source-9557208-dex2jar.jar:android/security/KeyStoreParameter.class */
public final class KeyStoreParameter implements KeyStore.ProtectionParameter {
    private int mFlags;

    /* loaded from: source-9557208-dex2jar.jar:android/security/KeyStoreParameter$Builder.class */
    public static final class Builder {
        private int mFlags;

        public Builder(Context context) {
            if (context == null) {
                throw new NullPointerException("context == null");
            }
        }

        public KeyStoreParameter build() {
            return new KeyStoreParameter(this.mFlags);
        }

        public Builder setEncryptionRequired(boolean z) {
            if (z) {
                this.mFlags |= 1;
                return this;
            }
            this.mFlags &= -2;
            return this;
        }
    }

    private KeyStoreParameter(int i) {
        this.mFlags = i;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public boolean isEncryptionRequired() {
        return (this.mFlags & 1) != 0;
    }
}
