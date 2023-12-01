package java.util.jar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/Attributes.class */
public class Attributes implements Cloneable, Map<Object, Object> {
    protected Map<Object, Object> map;

    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/Attributes$Name.class */
    public static class Name {
        private final String name;
        public static final Name CLASS_PATH = new Name("Class-Path");
        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        public static final Name MAIN_CLASS = new Name("Main-Class");
        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        public static final Name CONTENT_TYPE = new Name("Content-Type");
        public static final Name SEALED = new Name("Sealed");
        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        public static final Name EXTENSION_LIST = new Name("Extension-List");
        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        public static final Name NAME = new Name("Name");

        public Name(String str) {
            if (str.isEmpty() || str.length() > 70) {
                throw new IllegalArgumentException(str);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    this.name = str;
                    return;
                }
                char charAt = str.charAt(i2);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != '_' && charAt != '-' && (charAt < '0' || charAt > '9'))) {
                    break;
                }
                i = i2 + 1;
            }
            throw new IllegalArgumentException(str);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Name) && ((Name) obj).name.equalsIgnoreCase(this.name);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.toLowerCase(Locale.US).hashCode();
        }

        public String toString() {
            return this.name;
        }
    }

    public Attributes() {
        this.map = new HashMap();
    }

    public Attributes(int i) {
        this.map = new HashMap(i);
    }

    public Attributes(Attributes attributes) {
        this.map = (Map) ((HashMap) attributes.map).clone();
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.map = (Map) ((HashMap) this.map).clone();
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attributes) {
            return this.map.equals(((Attributes) obj).map);
        }
        return false;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public String getValue(String str) {
        return getValue(new Name(str));
    }

    public String getValue(Name name) {
        return (String) this.map.get(name);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return this.map.put((Name) obj, (String) obj2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends Object, ? extends Object> map) {
        if (map == null) {
            throw new NullPointerException("attrib == null");
        }
        if (!(map instanceof Attributes)) {
            throw new ClassCastException(map.getClass().getName() + " not an Attributes");
        }
        this.map.putAll(map);
    }

    public String putValue(String str, String str2) {
        return (String) this.map.put(new Name(str), str2);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }
}
