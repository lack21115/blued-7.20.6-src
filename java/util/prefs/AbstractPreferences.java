package java.util.prefs;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import libcore.io.Base64;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/util/prefs/AbstractPreferences.class */
public abstract class AbstractPreferences extends Preferences {
    private Map<String, AbstractPreferences> cachedNode;
    private boolean isRemoved;
    protected final Object lock;
    protected boolean newNode;
    private List<EventListener> nodeChangeListeners;
    private String nodeName;
    private AbstractPreferences parentPref;
    private List<EventListener> preferenceChangeListeners;
    private AbstractPreferences root;
    boolean userNode;
    private static final List<EventObject> events = new LinkedList();
    private static final EventDispatcher dispatcher = new EventDispatcher("Preference Event Dispatcher");

    /* loaded from: source-2895416-dex2jar.jar:java/util/prefs/AbstractPreferences$EventDispatcher.class */
    private static class EventDispatcher extends Thread {
        EventDispatcher(String str) {
            super(str);
        }

        private void dispatchNodeAdd(NodeChangeEvent nodeChangeEvent, List<EventListener> list) {
            synchronized (list) {
                Iterator<EventListener> it = list.iterator();
                while (it.hasNext()) {
                    ((NodeChangeListener) it.next()).childAdded(nodeChangeEvent);
                }
            }
        }

        private void dispatchNodeRemove(NodeChangeEvent nodeChangeEvent, List<EventListener> list) {
            synchronized (list) {
                Iterator<EventListener> it = list.iterator();
                while (it.hasNext()) {
                    ((NodeChangeListener) it.next()).childRemoved(nodeChangeEvent);
                }
            }
        }

        private void dispatchPrefChange(PreferenceChangeEvent preferenceChangeEvent, List<EventListener> list) {
            synchronized (list) {
                Iterator<EventListener> it = list.iterator();
                while (it.hasNext()) {
                    ((PreferenceChangeListener) it.next()).preferenceChange(preferenceChangeEvent);
                }
            }
        }

        private EventObject getEventObject() throws InterruptedException {
            EventObject eventObject;
            synchronized (AbstractPreferences.events) {
                if (AbstractPreferences.events.isEmpty()) {
                    AbstractPreferences.events.wait();
                }
                eventObject = (EventObject) AbstractPreferences.events.get(0);
                AbstractPreferences.events.remove(0);
            }
            return eventObject;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    EventObject eventObject = getEventObject();
                    AbstractPreferences abstractPreferences = (AbstractPreferences) eventObject.getSource();
                    if (eventObject instanceof NodeAddEvent) {
                        dispatchNodeAdd((NodeChangeEvent) eventObject, abstractPreferences.nodeChangeListeners);
                    } else if (eventObject instanceof NodeRemoveEvent) {
                        dispatchNodeRemove((NodeChangeEvent) eventObject, abstractPreferences.nodeChangeListeners);
                    } else if (eventObject instanceof PreferenceChangeEvent) {
                        dispatchPrefChange((PreferenceChangeEvent) eventObject, abstractPreferences.preferenceChangeListeners);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/prefs/AbstractPreferences$NodeAddEvent.class */
    public static class NodeAddEvent extends NodeChangeEvent {
        private static final long serialVersionUID = 1;

        public NodeAddEvent(Preferences preferences, Preferences preferences2) {
            super(preferences, preferences2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/prefs/AbstractPreferences$NodeRemoveEvent.class */
    public static class NodeRemoveEvent extends NodeChangeEvent {
        private static final long serialVersionUID = 1;

        public NodeRemoveEvent(Preferences preferences, Preferences preferences2) {
            super(preferences, preferences2);
        }
    }

    static {
        dispatcher.setDaemon(true);
        dispatcher.start();
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: java.util.prefs.AbstractPreferences.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Preferences userRoot = Preferences.userRoot();
                Preferences systemRoot = Preferences.systemRoot();
                try {
                    userRoot.flush();
                } catch (BackingStoreException e) {
                }
                try {
                    systemRoot.flush();
                } catch (BackingStoreException e2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractPreferences(AbstractPreferences abstractPreferences, String str) {
        if (((abstractPreferences == null) ^ (str.length() != 0 ? false : true)) || str.indexOf(BridgeUtil.SPLIT_MARK) >= 0) {
            throw new IllegalArgumentException();
        }
        this.root = abstractPreferences == null ? this : abstractPreferences.root;
        this.nodeChangeListeners = new LinkedList();
        this.preferenceChangeListeners = new LinkedList();
        this.isRemoved = false;
        this.cachedNode = new HashMap();
        this.nodeName = str;
        this.parentPref = abstractPreferences;
        this.lock = new Object();
        this.userNode = this.root.userNode;
    }

    private void checkState() {
        if (isRemoved()) {
            throw new IllegalStateException("This node has been removed");
        }
    }

    private AbstractPreferences getNodeFromBackend(boolean z, AbstractPreferences abstractPreferences, String str) throws BackingStoreException {
        if (str.length() > 80) {
            throw new IllegalArgumentException("Name '" + str + "' too long");
        }
        if (z) {
            AbstractPreferences childSpi = abstractPreferences.childSpi(str);
            abstractPreferences.cachedNode.put(str, childSpi);
            if (childSpi.newNode && abstractPreferences.nodeChangeListeners.size() > 0) {
                abstractPreferences.notifyChildAdded(childSpi);
            }
            return childSpi;
        }
        return abstractPreferences.getChild(str);
    }

    private AbstractPreferences nodeImpl(String str, boolean z) throws BackingStoreException {
        AbstractPreferences abstractPreferences;
        String[] split = str.split(BridgeUtil.SPLIT_MARK);
        AbstractPreferences abstractPreferences2 = this;
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str2 = split[i];
            synchronized (abstractPreferences2.lock) {
                AbstractPreferences abstractPreferences3 = abstractPreferences2.cachedNode.get(str2);
                abstractPreferences = abstractPreferences3;
                if (abstractPreferences3 == null) {
                    abstractPreferences = getNodeFromBackend(z, abstractPreferences2, str2);
                }
            }
            if (abstractPreferences == null) {
                return abstractPreferences;
            }
            i++;
            abstractPreferences2 = abstractPreferences;
        }
        return abstractPreferences2;
    }

    private void notifyChildAdded(Preferences preferences) {
        NodeAddEvent nodeAddEvent = new NodeAddEvent(this, preferences);
        synchronized (events) {
            events.add(nodeAddEvent);
            events.notifyAll();
        }
    }

    private void notifyChildRemoved(Preferences preferences) {
        NodeRemoveEvent nodeRemoveEvent = new NodeRemoveEvent(this, preferences);
        synchronized (events) {
            events.add(nodeRemoveEvent);
            events.notifyAll();
        }
    }

    private void notifyPreferenceChange(String str, String str2) {
        PreferenceChangeEvent preferenceChangeEvent = new PreferenceChangeEvent(this, str, str2);
        synchronized (events) {
            events.add(preferenceChangeEvent);
            events.notifyAll();
        }
    }

    private void removeNodeImpl() throws BackingStoreException {
        synchronized (this.lock) {
            checkState();
            String[] childrenNamesSpi = childrenNamesSpi();
            int length = childrenNamesSpi.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = childrenNamesSpi[i2];
                if (this.cachedNode.get(str) == null) {
                    this.cachedNode.put(str, childSpi(str));
                }
                i = i2 + 1;
            }
            Collection<AbstractPreferences> values = this.cachedNode.values();
            AbstractPreferences[] abstractPreferencesArr = (AbstractPreferences[]) values.toArray(new AbstractPreferences[values.size()]);
            int length2 = abstractPreferencesArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                abstractPreferencesArr[i4].removeNodeImpl();
                i3 = i4 + 1;
            }
            removeNodeSpi();
            this.isRemoved = true;
            this.parentPref.cachedNode.remove(this.nodeName);
        }
        if (this.parentPref.nodeChangeListeners.size() > 0) {
            this.parentPref.notifyChildRemoved(this);
        }
    }

    private void validateName(String str) {
        if (str.endsWith(BridgeUtil.SPLIT_MARK) && str.length() > 1) {
            throw new IllegalArgumentException("Name cannot end with '/'");
        }
        if (str.indexOf("//") >= 0) {
            throw new IllegalArgumentException("Name cannot contain consecutive '/' characters");
        }
    }

    @Override // java.util.prefs.Preferences
    public String absolutePath() {
        return this.parentPref == null ? BridgeUtil.SPLIT_MARK : this.parentPref == this.root ? BridgeUtil.SPLIT_MARK + this.nodeName : this.parentPref.absolutePath() + BridgeUtil.SPLIT_MARK + this.nodeName;
    }

    @Override // java.util.prefs.Preferences
    public void addNodeChangeListener(NodeChangeListener nodeChangeListener) {
        if (nodeChangeListener == null) {
            throw new NullPointerException("ncl == null");
        }
        checkState();
        synchronized (this.nodeChangeListeners) {
            this.nodeChangeListeners.add(nodeChangeListener);
        }
    }

    @Override // java.util.prefs.Preferences
    public void addPreferenceChangeListener(PreferenceChangeListener preferenceChangeListener) {
        if (preferenceChangeListener == null) {
            throw new NullPointerException("pcl == null");
        }
        checkState();
        synchronized (this.preferenceChangeListeners) {
            this.preferenceChangeListeners.add(preferenceChangeListener);
        }
    }

    protected final AbstractPreferences[] cachedChildren() {
        return (AbstractPreferences[]) this.cachedNode.values().toArray(new AbstractPreferences[this.cachedNode.size()]);
    }

    protected abstract AbstractPreferences childSpi(String str);

    @Override // java.util.prefs.Preferences
    public String[] childrenNames() throws BackingStoreException {
        String[] strArr;
        synchronized (this.lock) {
            checkState();
            TreeSet treeSet = new TreeSet(this.cachedNode.keySet());
            String[] childrenNamesSpi = childrenNamesSpi();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < childrenNamesSpi.length) {
                    treeSet.add(childrenNamesSpi[i2]);
                    i = i2 + 1;
                } else {
                    strArr = (String[]) treeSet.toArray(new String[treeSet.size()]);
                }
            }
        }
        return strArr;
    }

    protected abstract String[] childrenNamesSpi() throws BackingStoreException;

    @Override // java.util.prefs.Preferences
    public void clear() throws BackingStoreException {
        synchronized (this.lock) {
            String[] keys = keys();
            int length = keys.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    remove(keys[i2]);
                    i = i2 + 1;
                }
            }
        }
    }

    @Override // java.util.prefs.Preferences
    public void exportNode(OutputStream outputStream) throws IOException, BackingStoreException {
        if (outputStream == null) {
            throw new NullPointerException("ostream == null");
        }
        checkState();
        XMLParser.exportPrefs(this, outputStream, false);
    }

    @Override // java.util.prefs.Preferences
    public void exportSubtree(OutputStream outputStream) throws IOException, BackingStoreException {
        if (outputStream == null) {
            throw new NullPointerException("ostream == null");
        }
        checkState();
        XMLParser.exportPrefs(this, outputStream, true);
    }

    @Override // java.util.prefs.Preferences
    public void flush() throws BackingStoreException {
        synchronized (this.lock) {
            flushSpi();
        }
        AbstractPreferences[] cachedChildren = cachedChildren();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cachedChildren.length) {
                return;
            }
            cachedChildren[i2].flush();
            i = i2 + 1;
        }
    }

    protected abstract void flushSpi() throws BackingStoreException;

    @Override // java.util.prefs.Preferences
    public String get(String str, String str2) {
        String str3;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this.lock) {
            checkState();
            try {
                str3 = getSpi(str);
            } catch (Exception e) {
                str3 = null;
            }
        }
        return str3 == null ? str2 : str3;
    }

    @Override // java.util.prefs.Preferences
    public boolean getBoolean(String str, boolean z) {
        String str2 = get(str, null);
        if (str2 != null) {
            if ("true".equalsIgnoreCase(str2)) {
                return true;
            }
            if ("false".equalsIgnoreCase(str2)) {
                return false;
            }
        }
        return z;
    }

    @Override // java.util.prefs.Preferences
    public byte[] getByteArray(String str, byte[] bArr) {
        String str2 = get(str, null);
        if (str2 != null) {
            if (str2.length() == 0) {
                return EmptyArray.BYTE;
            }
            try {
                byte[] bytes = str2.getBytes(StandardCharsets.US_ASCII);
                if (bytes.length % 4 == 0) {
                    return Base64.decode(bytes);
                }
            } catch (Exception e) {
                return bArr;
            }
        }
        return bArr;
    }

    protected AbstractPreferences getChild(String str) throws BackingStoreException {
        AbstractPreferences abstractPreferences;
        synchronized (this.lock) {
            checkState();
            String[] childrenNames = childrenNames();
            int length = childrenNames.length;
            int i = 0;
            while (true) {
                int i2 = i;
                abstractPreferences = null;
                if (i2 >= length) {
                    break;
                } else if (childrenNames[i2].equals(str)) {
                    abstractPreferences = childSpi(str);
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return abstractPreferences;
    }

    @Override // java.util.prefs.Preferences
    public double getDouble(String str, double d) {
        String str2 = get(str, null);
        if (str2 == null) {
            return d;
        }
        try {
            return Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            return d;
        }
    }

    @Override // java.util.prefs.Preferences
    public float getFloat(String str, float f) {
        String str2 = get(str, null);
        if (str2 == null) {
            return f;
        }
        try {
            return Float.parseFloat(str2);
        } catch (NumberFormatException e) {
            return f;
        }
    }

    @Override // java.util.prefs.Preferences
    public int getInt(String str, int i) {
        String str2 = get(str, null);
        if (str2 == null) {
            return i;
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    @Override // java.util.prefs.Preferences
    public long getLong(String str, long j) {
        String str2 = get(str, null);
        if (str2 == null) {
            return j;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    protected abstract String getSpi(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRemoved() {
        boolean z;
        synchronized (this.lock) {
            z = this.isRemoved;
        }
        return z;
    }

    @Override // java.util.prefs.Preferences
    public boolean isUserNode() {
        return this.root == Preferences.userRoot();
    }

    @Override // java.util.prefs.Preferences
    public String[] keys() throws BackingStoreException {
        String[] keysSpi;
        synchronized (this.lock) {
            checkState();
            keysSpi = keysSpi();
        }
        return keysSpi;
    }

    protected abstract String[] keysSpi() throws BackingStoreException;

    @Override // java.util.prefs.Preferences
    public String name() {
        return this.nodeName;
    }

    @Override // java.util.prefs.Preferences
    public Preferences node(String str) {
        AbstractPreferences abstractPreferences;
        synchronized (this.lock) {
            checkState();
            validateName(str);
            if (str.isEmpty()) {
                return this;
            }
            if (BridgeUtil.SPLIT_MARK.equals(str)) {
                return this.root;
            }
            if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
                abstractPreferences = this.root;
                str = str.substring(1);
            } else {
                abstractPreferences = this;
            }
            try {
                return abstractPreferences.nodeImpl(str, true);
            } catch (BackingStoreException e) {
                return null;
            }
        }
    }

    @Override // java.util.prefs.Preferences
    public boolean nodeExists(String str) throws BackingStoreException {
        AbstractPreferences abstractPreferences;
        boolean z = true;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        synchronized (this.lock) {
            if (isRemoved()) {
                if (str.isEmpty()) {
                    return false;
                }
                throw new IllegalStateException("This node has been removed");
            }
            validateName(str);
            if (str.isEmpty() || BridgeUtil.SPLIT_MARK.equals(str)) {
                return true;
            }
            if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
                abstractPreferences = this.root;
                str = str.substring(1);
            } else {
                abstractPreferences = this;
            }
            try {
                if (abstractPreferences.nodeImpl(str, false) == null) {
                    z = false;
                }
                return z;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    }

    @Override // java.util.prefs.Preferences
    public Preferences parent() {
        checkState();
        return this.parentPref;
    }

    @Override // java.util.prefs.Preferences
    public void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        if (str2 == null) {
            throw new NullPointerException("value == null");
        }
        if (str.length() > 80 || str2.length() > 8192) {
            throw new IllegalArgumentException();
        }
        synchronized (this.lock) {
            checkState();
            putSpi(str, str2);
        }
        notifyPreferenceChange(str, str2);
    }

    @Override // java.util.prefs.Preferences
    public void putBoolean(String str, boolean z) {
        put(str, String.valueOf(z));
    }

    @Override // java.util.prefs.Preferences
    public void putByteArray(String str, byte[] bArr) {
        put(str, Base64.encode(bArr));
    }

    @Override // java.util.prefs.Preferences
    public void putDouble(String str, double d) {
        put(str, Double.toString(d));
    }

    @Override // java.util.prefs.Preferences
    public void putFloat(String str, float f) {
        put(str, Float.toString(f));
    }

    @Override // java.util.prefs.Preferences
    public void putInt(String str, int i) {
        put(str, Integer.toString(i));
    }

    @Override // java.util.prefs.Preferences
    public void putLong(String str, long j) {
        put(str, Long.toString(j));
    }

    protected abstract void putSpi(String str, String str2);

    @Override // java.util.prefs.Preferences
    public void remove(String str) {
        synchronized (this.lock) {
            checkState();
            removeSpi(str);
        }
        notifyPreferenceChange(str, null);
    }

    @Override // java.util.prefs.Preferences
    public void removeNode() throws BackingStoreException {
        if (this.root == this) {
            throw new UnsupportedOperationException("Cannot remove root node");
        }
        synchronized (this.parentPref.lock) {
            removeNodeImpl();
        }
    }

    @Override // java.util.prefs.Preferences
    public void removeNodeChangeListener(NodeChangeListener nodeChangeListener) {
        checkState();
        synchronized (this.nodeChangeListeners) {
            int indexOf = this.nodeChangeListeners.indexOf(nodeChangeListener);
            if (indexOf == -1) {
                throw new IllegalArgumentException();
            }
            this.nodeChangeListeners.remove(indexOf);
        }
    }

    protected abstract void removeNodeSpi() throws BackingStoreException;

    @Override // java.util.prefs.Preferences
    public void removePreferenceChangeListener(PreferenceChangeListener preferenceChangeListener) {
        checkState();
        synchronized (this.preferenceChangeListeners) {
            int indexOf = this.preferenceChangeListeners.indexOf(preferenceChangeListener);
            if (indexOf == -1) {
                throw new IllegalArgumentException();
            }
            this.preferenceChangeListeners.remove(indexOf);
        }
    }

    protected abstract void removeSpi(String str);

    @Override // java.util.prefs.Preferences
    public void sync() throws BackingStoreException {
        synchronized (this.lock) {
            checkState();
            syncSpi();
        }
        AbstractPreferences[] cachedChildren = cachedChildren();
        int length = cachedChildren.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            cachedChildren[i2].sync();
            i = i2 + 1;
        }
    }

    protected abstract void syncSpi() throws BackingStoreException;

    @Override // java.util.prefs.Preferences
    public String toString() {
        return (isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath();
    }
}
