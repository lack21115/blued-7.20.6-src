package android.webkit;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/PluginList.class */
public class PluginList {
    private ArrayList<Plugin> mPlugins = new ArrayList<>();

    @Deprecated
    public void addPlugin(Plugin plugin) {
        synchronized (this) {
            if (!this.mPlugins.contains(plugin)) {
                this.mPlugins.add(plugin);
            }
        }
    }

    @Deprecated
    public void clear() {
        synchronized (this) {
            this.mPlugins.clear();
        }
    }

    @Deprecated
    public List getList() {
        ArrayList<Plugin> arrayList;
        synchronized (this) {
            arrayList = this.mPlugins;
        }
        return arrayList;
    }

    @Deprecated
    public void pluginClicked(Context context, int i) {
        synchronized (this) {
            try {
                this.mPlugins.get(i).dispatchClickEvent(context);
            } catch (IndexOutOfBoundsException e) {
            }
        }
    }

    @Deprecated
    public void removePlugin(Plugin plugin) {
        synchronized (this) {
            int indexOf = this.mPlugins.indexOf(plugin);
            if (indexOf != -1) {
                this.mPlugins.remove(indexOf);
            }
        }
    }
}
