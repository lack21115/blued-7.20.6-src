package java.util.prefs;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/FilePreferencesImpl.class */
public class FilePreferencesImpl extends AbstractPreferences {
    private static final String PREFS_FILE_NAME = "prefs.xml";
    private File dir;
    private final String path;
    private Properties prefs;
    private File prefsFile;
    private Set<String> removed;
    private Set<String> updated;

    public FilePreferencesImpl(String str, boolean z) {
        super(null, "");
        this.removed = new HashSet();
        this.updated = new HashSet();
        this.path = str;
        this.userNode = z;
        initPrefs();
    }

    private FilePreferencesImpl(AbstractPreferences abstractPreferences, String str) {
        super(abstractPreferences, str);
        this.removed = new HashSet();
        this.updated = new HashSet();
        this.path = ((FilePreferencesImpl) abstractPreferences).path + File.separator + str;
        initPrefs();
    }

    private void initPrefs() {
        this.dir = new File(this.path);
        this.newNode = !this.dir.exists();
        this.prefsFile = new File(this.path + File.separator + PREFS_FILE_NAME);
        this.prefs = XMLParser.readXmlPreferences(this.prefsFile);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected AbstractPreferences childSpi(String str) {
        return new FilePreferencesImpl(this, str);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String[] childrenNamesSpi() throws BackingStoreException {
        String[] list = this.dir.list(new FilenameFilter() { // from class: java.util.prefs.FilePreferencesImpl.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return new File(FilePreferencesImpl.this.path + File.separator + str).isDirectory();
            }
        });
        if (list == null) {
            throw new BackingStoreException("Cannot get child names for " + toString() + " (path is " + this.path + ")");
        }
        return list;
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void flushSpi() throws BackingStoreException {
        try {
            if (isRemoved()) {
                return;
            }
            Properties readXmlPreferences = XMLParser.readXmlPreferences(this.prefsFile);
            for (String str : this.removed) {
                readXmlPreferences.remove(str);
            }
            this.removed.clear();
            for (String str2 : this.updated) {
                readXmlPreferences.put(str2, this.prefs.get(str2));
            }
            this.updated.clear();
            this.prefs = readXmlPreferences;
            XMLParser.writeXmlPreferences(this.prefsFile, this.prefs);
        } catch (Exception e) {
            throw new BackingStoreException(e);
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String getSpi(String str) {
        try {
            if (this.prefs == null) {
                this.prefs = XMLParser.readXmlPreferences(this.prefsFile);
            }
            return this.prefs.getProperty(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected String[] keysSpi() throws BackingStoreException {
        Set<Object> keySet = this.prefs.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void putSpi(String str, String str2) {
        this.prefs.setProperty(str, str2);
        this.updated.add(str);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void removeNodeSpi() throws BackingStoreException {
        this.prefsFile.delete();
        if (!this.dir.delete()) {
            throw new BackingStoreException("Cannot remove " + toString());
        }
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void removeSpi(String str) {
        this.prefs.remove(str);
        this.updated.remove(str);
        this.removed.add(str);
    }

    @Override // java.util.prefs.AbstractPreferences
    protected void syncSpi() throws BackingStoreException {
        flushSpi();
    }
}
