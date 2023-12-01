package java.security;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: source-2895416-dex2jar.jar:java/security/SecureClassLoader.class */
public class SecureClassLoader extends ClassLoader {
    private HashMap<CodeSource, ProtectionDomain> pds;

    protected SecureClassLoader() {
        this.pds = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecureClassLoader(ClassLoader classLoader) {
        super(classLoader);
        this.pds = new HashMap<>();
    }

    private ProtectionDomain getPD(CodeSource codeSource) {
        if (codeSource == null) {
            return null;
        }
        synchronized (this.pds) {
            ProtectionDomain protectionDomain = this.pds.get(codeSource);
            if (protectionDomain != null) {
                return protectionDomain;
            }
            ProtectionDomain protectionDomain2 = new ProtectionDomain(codeSource, getPermissions(codeSource), this, null);
            this.pds.put(codeSource, protectionDomain2);
            return protectionDomain2;
        }
    }

    protected final Class<?> defineClass(String str, ByteBuffer byteBuffer, CodeSource codeSource) {
        byte[] array = byteBuffer.array();
        return codeSource == null ? defineClass(str, array, 0, array.length) : defineClass(str, array, 0, array.length, getPD(codeSource));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String str, byte[] bArr, int i, int i2, CodeSource codeSource) {
        return codeSource == null ? defineClass(str, bArr, i, i2) : defineClass(str, bArr, i, i2, getPD(codeSource));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PermissionCollection getPermissions(CodeSource codeSource) {
        return new Permissions();
    }
}
