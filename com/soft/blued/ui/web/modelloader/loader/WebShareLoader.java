package com.soft.blued.ui.web.modelloader.loader;

import android.text.TextUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import com.soft.blued.ui.web.modelloader.fetcher.WebShareFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/WebShareLoader.class */
public class WebShareLoader implements ModelLoader<String> {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/WebShareLoader$Factory.class */
    public static class Factory implements ModelLoader.ModelLoaderFactory<String> {
        @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader.ModelLoaderFactory
        public ModelLoader<String> build(ModelLoaderRegistry modelLoaderRegistry) {
            return new WebShareLoader();
        }
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public ModelLoader.LoadData buildData(String str) {
        return new ModelLoader.LoadData(str, new WebShareFetcher());
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public boolean handles(String str) {
        return TextUtils.equals(str, LoaderConstants.OPEN_SHARE);
    }
}
