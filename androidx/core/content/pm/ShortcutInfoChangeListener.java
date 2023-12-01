package androidx.core.content.pm;

import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/ShortcutInfoChangeListener.class */
public abstract class ShortcutInfoChangeListener {
    public void onAllShortcutsRemoved() {
    }

    public void onShortcutAdded(List<ShortcutInfoCompat> list) {
    }

    public void onShortcutRemoved(List<String> list) {
    }

    public void onShortcutUpdated(List<ShortcutInfoCompat> list) {
    }

    public void onShortcutUsageReported(List<String> list) {
    }
}
