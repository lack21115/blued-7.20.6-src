package java.util.jar;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.SortedMap;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/Pack200.class */
public abstract class Pack200 {
    private static final String SYSTEM_PROPERTY_PACKER = "java.util.jar.Pack200.Packer";
    private static final String SYSTEM_PROPERTY_UNPACKER = "java.util.jar.Pack200.Unpacker";

    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/Pack200$Packer.class */
    public interface Packer {
        public static final String CLASS_ATTRIBUTE_PFX = "pack.class.attribute.";
        public static final String CODE_ATTRIBUTE_PFX = "pack.code.attribute.";
        public static final String DEFLATE_HINT = "pack.deflate.hint";
        public static final String EFFORT = "pack.effort";
        public static final String ERROR = "error";
        public static final String FALSE = "false";
        public static final String FIELD_ATTRIBUTE_PFX = "pack.field.attribute.";
        public static final String KEEP = "keep";
        public static final String KEEP_FILE_ORDER = "pack.keep.file.order";
        public static final String LATEST = "latest";
        public static final String METHOD_ATTRIBUTE_PFX = "pack.method.attribute.";
        public static final String MODIFICATION_TIME = "pack.modification.time";
        public static final String PASS = "pass";
        public static final String PASS_FILE_PFX = "pack.pass.file.";
        public static final String PROGRESS = "pack.progress";
        public static final String SEGMENT_LIMIT = "pack.segment.limit";
        public static final String STRIP = "strip";
        public static final String TRUE = "true";
        public static final String UNKNOWN_ATTRIBUTE = "pack.unknown.attribute";

        void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

        void pack(JarFile jarFile, OutputStream outputStream) throws IOException;

        void pack(JarInputStream jarInputStream, OutputStream outputStream) throws IOException;

        SortedMap<String, String> properties();

        void removePropertyChangeListener(PropertyChangeListener propertyChangeListener);
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/Pack200$Unpacker.class */
    public interface Unpacker {
        public static final String DEFLATE_HINT = "unpack.deflate.hint";
        public static final String FALSE = "false";
        public static final String KEEP = "keep";
        public static final String PROGRESS = "unpack.progress";
        public static final String TRUE = "true";

        void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

        SortedMap<String, String> properties();

        void removePropertyChangeListener(PropertyChangeListener propertyChangeListener);

        void unpack(File file, JarOutputStream jarOutputStream) throws IOException;

        void unpack(InputStream inputStream, JarOutputStream jarOutputStream) throws IOException;
    }

    private Pack200() {
    }

    public static Packer newPacker() {
        String property = System.getProperty(SYSTEM_PROPERTY_PACKER, "org.apache.harmony.pack200.Pack200PackerAdapter");
        try {
            return (Packer) ClassLoader.getSystemClassLoader().loadClass(property).newInstance();
        } catch (Exception e) {
            throw new Error("Can't load class " + property, e);
        }
    }

    public static Unpacker newUnpacker() {
        String property = System.getProperty(SYSTEM_PROPERTY_UNPACKER, "org.apache.harmony.unpack200.Pack200UnpackerAdapter");
        try {
            return (Unpacker) ClassLoader.getSystemClassLoader().loadClass(property).newInstance();
        } catch (Exception e) {
            throw new Error("Can't load class " + property, e);
        }
    }
}
