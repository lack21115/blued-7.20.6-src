package org.apache.harmony.security;

import java.security.Identity;
import java.security.IdentityScope;
import java.security.KeyManagementException;
import java.security.PublicKey;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/SystemScope.class */
public class SystemScope extends IdentityScope {
    private static final long serialVersionUID = -4810285697932522607L;
    private Hashtable keys;
    private Hashtable names;

    public SystemScope() {
        this.names = new Hashtable();
        this.keys = new Hashtable();
    }

    public SystemScope(String str) {
        super(str);
        this.names = new Hashtable();
        this.keys = new Hashtable();
    }

    public SystemScope(String str, IdentityScope identityScope) throws KeyManagementException {
        super(str, identityScope);
        this.names = new Hashtable();
        this.keys = new Hashtable();
    }

    @Override // java.security.IdentityScope
    public void addIdentity(Identity identity) throws KeyManagementException {
        synchronized (this) {
            if (identity == null) {
                throw new NullPointerException("identity == null");
            }
            String name = identity.getName();
            if (this.names.containsKey(name)) {
                throw new KeyManagementException("name '" + name + "' is already used");
            }
            PublicKey publicKey = identity.getPublicKey();
            if (publicKey != null && this.keys.containsKey(publicKey)) {
                throw new KeyManagementException("key '" + publicKey + "' is already used");
            }
            this.names.put(name, identity);
            if (publicKey != null) {
                this.keys.put(publicKey, identity);
            }
        }
    }

    @Override // java.security.IdentityScope
    public Identity getIdentity(String str) {
        Identity identity;
        synchronized (this) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            identity = (Identity) this.names.get(str);
        }
        return identity;
    }

    @Override // java.security.IdentityScope
    public Identity getIdentity(PublicKey publicKey) {
        Identity identity;
        synchronized (this) {
            identity = publicKey == null ? null : (Identity) this.keys.get(publicKey);
        }
        return identity;
    }

    @Override // java.security.IdentityScope
    public Enumeration identities() {
        return this.names.elements();
    }

    @Override // java.security.IdentityScope
    public void removeIdentity(Identity identity) throws KeyManagementException {
        synchronized (this) {
            if (identity == null) {
                throw new NullPointerException("identity == null");
            }
            String name = identity.getName();
            if (name == null) {
                throw new NullPointerException("name == null");
            }
            boolean containsKey = this.names.containsKey(name);
            this.names.remove(name);
            PublicKey publicKey = identity.getPublicKey();
            boolean z = containsKey;
            if (publicKey != null) {
                if (!containsKey && !this.keys.containsKey(publicKey)) {
                    z = false;
                    this.keys.remove(publicKey);
                }
                z = true;
                this.keys.remove(publicKey);
            }
            if (!z) {
                throw new KeyManagementException("identity not found");
            }
        }
    }

    @Override // java.security.IdentityScope
    public int size() {
        return this.names.size();
    }
}
