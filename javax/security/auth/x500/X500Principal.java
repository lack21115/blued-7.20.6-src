package javax.security.auth.x500;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import org.apache.harmony.security.x501.Name;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/x500/X500Principal.class */
public final class X500Principal implements Serializable, Principal {
    public static final String CANONICAL = "CANONICAL";
    public static final String RFC1779 = "RFC1779";
    public static final String RFC2253 = "RFC2253";
    private static final long serialVersionUID = -500463348111345721L;
    private transient String canonicalName;
    private transient Name dn;

    public X500Principal(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        }
        try {
            this.dn = (Name) Name.ASN1.decode(inputStream);
        } catch (IOException e) {
            throw incorrectInputEncoding(e);
        }
    }

    public X500Principal(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        try {
            this.dn = new Name(str);
        } catch (IOException e) {
            throw incorrectInputName(e, str);
        }
    }

    public X500Principal(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        try {
            this.dn = new Name(substituteNameFromMap(str, map));
        } catch (IOException e) {
            throw incorrectInputName(e, str);
        }
    }

    public X500Principal(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        try {
            this.dn = (Name) Name.ASN1.decode(bArr);
        } catch (IOException e) {
            throw incorrectInputEncoding(e);
        }
    }

    private String getCanonicalName() {
        String str;
        synchronized (this) {
            if (this.canonicalName == null) {
                this.canonicalName = this.dn.getName(CANONICAL);
            }
            str = this.canonicalName;
        }
        return str;
    }

    private IllegalArgumentException incorrectInputEncoding(IOException iOException) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incorrect input encoding");
        illegalArgumentException.initCause(iOException);
        throw illegalArgumentException;
    }

    private IllegalArgumentException incorrectInputName(IOException iOException, String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incorrect input name:" + str);
        illegalArgumentException.initCause(iOException);
        throw illegalArgumentException;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.dn = (Name) Name.ASN1.decode((byte[]) objectInputStream.readObject());
    }

    private String substituteNameFromMap(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        while (true) {
            int lastIndexOf = sb.lastIndexOf("=", length);
            if (-1 == lastIndexOf) {
                return sb.toString();
            }
            length = sb.lastIndexOf(",", lastIndexOf);
            String trim = sb.substring(length + 1, lastIndexOf).trim();
            if (map.containsKey(trim)) {
                sb.replace(length + 1, lastIndexOf, map.get(trim));
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.dn.getEncoded());
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return getCanonicalName().equals(((X500Principal) obj).getCanonicalName());
    }

    public byte[] getEncoded() {
        byte[] encoded = this.dn.getEncoded();
        byte[] bArr = new byte[encoded.length];
        System.arraycopy(encoded, 0, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // java.security.Principal
    public String getName() {
        return this.dn.getName(RFC2253);
    }

    public String getName(String str) {
        return CANONICAL.equals(str) ? getCanonicalName() : this.dn.getName(str);
    }

    public String getName(String str, Map<String, String> map) {
        String name = this.dn.getName(RFC1779);
        String name2 = this.dn.getName(RFC2253);
        if (str.equalsIgnoreCase(RFC1779)) {
            StringBuilder sb = new StringBuilder(name);
            int length = sb.length();
            while (true) {
                int lastIndexOf = sb.lastIndexOf("=", length);
                if (-1 == lastIndexOf) {
                    return sb.toString();
                }
                length = sb.lastIndexOf(",", lastIndexOf);
                String trim = sb.substring(length + 1, lastIndexOf).trim();
                if (trim.length() > 4 && trim.substring(0, 4).equals("OID.")) {
                    String substring = trim.substring(4);
                    if (map.containsKey(substring)) {
                        String str2 = map.get(substring);
                        String str3 = str2;
                        if (length > 0) {
                            str3 = " " + str2;
                        }
                        sb.replace(length + 1, lastIndexOf, str3);
                    }
                }
            }
        } else if (!str.equalsIgnoreCase(RFC2253)) {
            throw new IllegalArgumentException("invalid format specified: " + str);
        } else {
            StringBuilder sb2 = new StringBuilder(name2);
            StringBuilder sb3 = new StringBuilder(name);
            int length2 = sb2.length();
            int length3 = sb3.length();
            while (true) {
                int i = length3;
                int lastIndexOf2 = sb2.lastIndexOf("=", length2);
                if (-1 == lastIndexOf2) {
                    return sb2.toString();
                }
                int lastIndexOf3 = sb3.lastIndexOf("=", i);
                int lastIndexOf4 = sb2.lastIndexOf(",", lastIndexOf2);
                String trim2 = sb2.substring(lastIndexOf4 + 1, lastIndexOf2).trim();
                if (map.containsKey(trim2)) {
                    int indexOf = sb2.indexOf(",", lastIndexOf2);
                    int i2 = indexOf;
                    if (indexOf == -1) {
                        i2 = sb2.length();
                    }
                    int indexOf2 = sb3.indexOf(",", lastIndexOf3);
                    int i3 = indexOf2;
                    if (indexOf2 == -1) {
                        i3 = sb3.length();
                    }
                    sb2.replace(lastIndexOf2 + 1, i2, sb3.substring(lastIndexOf3 + 1, i3));
                    sb2.replace(lastIndexOf4 + 1, lastIndexOf2, map.get(trim2));
                }
                length2 = lastIndexOf4;
                length3 = lastIndexOf3 - 1;
            }
        }
    }

    @Override // java.security.Principal
    public int hashCode() {
        return getCanonicalName().hashCode();
    }

    @Override // java.security.Principal
    public String toString() {
        return this.dn.getName(RFC1779);
    }
}
