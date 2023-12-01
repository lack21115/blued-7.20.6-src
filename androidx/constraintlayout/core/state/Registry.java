package androidx.constraintlayout.core.state;

import java.util.HashMap;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Registry.class */
public class Registry {

    /* renamed from: a  reason: collision with root package name */
    private static final Registry f2045a = new Registry();
    private HashMap<String, RegistryCallback> b = new HashMap<>();

    public static Registry getInstance() {
        return f2045a;
    }

    public String currentContent(String str) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            return registryCallback.currentMotionScene();
        }
        return null;
    }

    public String currentLayoutInformation(String str) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            return registryCallback.currentLayoutInformation();
        }
        return null;
    }

    public long getLastModified(String str) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            return registryCallback.getLastModified();
        }
        return Long.MAX_VALUE;
    }

    public Set<String> getLayoutList() {
        return this.b.keySet();
    }

    public void register(String str, RegistryCallback registryCallback) {
        this.b.put(str, registryCallback);
    }

    public void setDrawDebug(String str, int i) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            registryCallback.setDrawDebug(i);
        }
    }

    public void setLayoutInformationMode(String str, int i) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            registryCallback.setLayoutInformationMode(i);
        }
    }

    public void unregister(String str, RegistryCallback registryCallback) {
        this.b.remove(str);
    }

    public void updateContent(String str, String str2) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            registryCallback.onNewMotionScene(str2);
        }
    }

    public void updateDimensions(String str, int i, int i2) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            registryCallback.onDimensions(i, i2);
        }
    }

    public void updateProgress(String str, float f) {
        RegistryCallback registryCallback = this.b.get(str);
        if (registryCallback != null) {
            registryCallback.onProgress(f);
        }
    }
}
