package javax.xml.namespace;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/namespace/QName.class */
public class QName implements Serializable {
    private static final long compatibilitySerialVersionUID = 4418622981026545151L;
    private static final long defaultSerialVersionUID = -9120448754896609940L;
    private static final long serialVersionUID;
    private final String localPart;
    private final String namespaceURI;
    private String prefix;
    private transient String qNameAsString;

    static {
        serialVersionUID = !"1.0".equals(System.getProperty("org.apache.xml.namespace.QName.useCompatibleSerialVersionUID")) ? -9120448754896609940L : 4418622981026545151L;
    }

    public QName(String str) {
        this("", str, "");
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str, String str2, String str3) {
        if (str == null) {
            this.namespaceURI = "";
        } else {
            this.namespaceURI = str;
        }
        if (str2 == null) {
            throw new IllegalArgumentException("local part cannot be \"null\" when creating a QName");
        }
        this.localPart = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("prefix cannot be \"null\" when creating a QName");
        }
        this.prefix = str3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.prefix == null) {
            this.prefix = "";
        }
    }

    public static QName valueOf(String str) {
        if (str == null) {
            throw new IllegalArgumentException("cannot create QName from \"null\" or \"\" String");
        }
        if (str.length() != 0 && str.charAt(0) == '{') {
            if (str.startsWith("{}")) {
                throw new IllegalArgumentException("Namespace URI .equals(XMLConstants.NULL_NS_URI), .equals(\"\"), only the local part, \"" + str.substring("".length() + 2) + "\", should be provided.");
            }
            int indexOf = str.indexOf(125);
            if (indexOf == -1) {
                throw new IllegalArgumentException("cannot create QName from \"" + str + "\", missing closing \"}\"");
            }
            return new QName(str.substring(1, indexOf), str.substring(indexOf + 1), "");
        }
        return new QName("", str, "");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI);
        }
        return false;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public String toString() {
        String str = this.qNameAsString;
        String str2 = str;
        if (str == null) {
            int length = this.namespaceURI.length();
            if (length == 0) {
                str2 = this.localPart;
            } else {
                StringBuilder sb = new StringBuilder(this.localPart.length() + length + 2);
                sb.append('{');
                sb.append(this.namespaceURI);
                sb.append('}');
                sb.append(this.localPart);
                str2 = sb.toString();
            }
            this.qNameAsString = str2;
        }
        return str2;
    }
}
