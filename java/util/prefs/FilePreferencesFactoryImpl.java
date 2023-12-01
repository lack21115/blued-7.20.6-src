package java.util.prefs;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/FilePreferencesFactoryImpl.class */
public class FilePreferencesFactoryImpl implements PreferencesFactory {
    private static final Preferences USER_ROOT = new FilePreferencesImpl(System.getProperty("user.home") + "/.java/.userPrefs", true);
    private static final Preferences SYSTEM_ROOT = new FilePreferencesImpl(System.getProperty("java.home") + "/.systemPrefs", false);

    @Override // java.util.prefs.PreferencesFactory
    public Preferences systemRoot() {
        return SYSTEM_ROOT;
    }

    @Override // java.util.prefs.PreferencesFactory
    public Preferences userRoot() {
        return USER_ROOT;
    }
}
