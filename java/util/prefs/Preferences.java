package java.util.prefs;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/Preferences.class */
public abstract class Preferences {
    public static final int MAX_KEY_LENGTH = 80;
    public static final int MAX_NAME_LENGTH = 80;
    public static final int MAX_VALUE_LENGTH = 8192;
    private static volatile PreferencesFactory factory = findPreferencesFactory();

    private static PreferencesFactory findPreferencesFactory() {
        PreferencesFactory preferencesFactory = (PreferencesFactory) ServiceLoader.loadFromSystemProperty(PreferencesFactory.class);
        if (preferencesFactory != null) {
            return preferencesFactory;
        }
        Iterator it = ServiceLoader.load(PreferencesFactory.class).iterator();
        return it.hasNext() ? (PreferencesFactory) it.next() : new FilePreferencesFactoryImpl();
    }

    private static String getNodeName(Class<?> cls) {
        Package r0 = cls.getPackage();
        return r0 == null ? "/<unnamed>" : BridgeUtil.SPLIT_MARK + r0.getName().replace('.', '/');
    }

    public static void importPreferences(InputStream inputStream) throws InvalidPreferencesFormatException, IOException {
        if (inputStream == null) {
            throw new MalformedURLException("Inputstream cannot be null");
        }
        XMLParser.importPrefs(inputStream);
    }

    public static PreferencesFactory setPreferencesFactory(PreferencesFactory preferencesFactory) {
        PreferencesFactory preferencesFactory2 = factory;
        factory = preferencesFactory;
        return preferencesFactory2;
    }

    public static Preferences systemNodeForPackage(Class<?> cls) {
        return factory.systemRoot().node(getNodeName(cls));
    }

    public static Preferences systemRoot() {
        return factory.systemRoot();
    }

    public static Preferences userNodeForPackage(Class<?> cls) {
        return factory.userRoot().node(getNodeName(cls));
    }

    public static Preferences userRoot() {
        return factory.userRoot();
    }

    public abstract String absolutePath();

    public abstract void addNodeChangeListener(NodeChangeListener nodeChangeListener);

    public abstract void addPreferenceChangeListener(PreferenceChangeListener preferenceChangeListener);

    public abstract String[] childrenNames() throws BackingStoreException;

    public abstract void clear() throws BackingStoreException;

    public abstract void exportNode(OutputStream outputStream) throws IOException, BackingStoreException;

    public abstract void exportSubtree(OutputStream outputStream) throws IOException, BackingStoreException;

    public abstract void flush() throws BackingStoreException;

    public abstract String get(String str, String str2);

    public abstract boolean getBoolean(String str, boolean z);

    public abstract byte[] getByteArray(String str, byte[] bArr);

    public abstract double getDouble(String str, double d);

    public abstract float getFloat(String str, float f);

    public abstract int getInt(String str, int i);

    public abstract long getLong(String str, long j);

    public abstract boolean isUserNode();

    public abstract String[] keys() throws BackingStoreException;

    public abstract String name();

    public abstract Preferences node(String str);

    public abstract boolean nodeExists(String str) throws BackingStoreException;

    public abstract Preferences parent();

    public abstract void put(String str, String str2);

    public abstract void putBoolean(String str, boolean z);

    public abstract void putByteArray(String str, byte[] bArr);

    public abstract void putDouble(String str, double d);

    public abstract void putFloat(String str, float f);

    public abstract void putInt(String str, int i);

    public abstract void putLong(String str, long j);

    public abstract void remove(String str);

    public abstract void removeNode() throws BackingStoreException;

    public abstract void removeNodeChangeListener(NodeChangeListener nodeChangeListener);

    public abstract void removePreferenceChangeListener(PreferenceChangeListener preferenceChangeListener);

    public abstract void sync() throws BackingStoreException;

    public abstract String toString();
}
