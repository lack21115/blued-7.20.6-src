package com.blued.android.module.common.web;

import android.text.TextUtils;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/ModelLoaderRegistry.class */
public class ModelLoaderRegistry {
    private List<Entry<?>> entries = new ArrayList();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/ModelLoaderRegistry$Entry.class */
    static class Entry<Model> {
        ModelLoader.ModelLoaderFactory<Model> factory;
        String key;

        public Entry(String str, ModelLoader.ModelLoaderFactory<Model> modelLoaderFactory) {
            this.key = str;
            this.factory = modelLoaderFactory;
        }

        boolean handles(String str) {
            return TextUtils.equals(this.key, str);
        }
    }

    public <Model> void add(String str, ModelLoader.ModelLoaderFactory<Model> modelLoaderFactory) {
        synchronized (this) {
            this.entries.add(new Entry<>(str, modelLoaderFactory));
        }
    }

    public ModelLoader.LoadData getLoadData(String str) {
        for (Entry<?> entry : this.entries) {
            if (entry.handles(str)) {
                return entry.factory.build(this).buildData(str);
            }
        }
        return null;
    }

    public <Model> ModelLoader<Model> getModelLoader(String str) {
        for (Entry<?> entry : this.entries) {
            if (entry.handles(str)) {
                return (ModelLoader<Model>) entry.factory.build(this);
            }
        }
        return null;
    }
}
