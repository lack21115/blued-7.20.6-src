package com.blued.android.module.common.web.modelloader.loader;

import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/loader/ModelLoader.class */
public interface ModelLoader<Model> {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/loader/ModelLoader$LoadData.class */
    public static class LoadData {
        public DataFetcher fetcher;
        public String key;

        public LoadData(String str, DataFetcher dataFetcher) {
            this.key = str;
            this.fetcher = dataFetcher;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/loader/ModelLoader$ModelLoaderFactory.class */
    public interface ModelLoaderFactory<Model> {
        ModelLoader<Model> build(ModelLoaderRegistry modelLoaderRegistry);
    }

    LoadData buildData(Model model);

    boolean handles(Model model);
}
