package com.soft.blued.ui.web.modelloader.loader;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import com.soft.blued.ui.web.modelloader.fetcher.PageInfoFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/PageInfoLoader.class */
public class PageInfoLoader implements ModelLoader<String> {
    BridgeManager bridgeManager;
    Lifecycle lifecycle;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/PageInfoLoader$Factory.class */
    public static class Factory implements ModelLoader.ModelLoaderFactory<String> {
        BridgeManager bridgeManager;
        Lifecycle lifecycle;

        public Factory(BridgeManager bridgeManager, Lifecycle lifecycle) {
            this.lifecycle = lifecycle;
            this.bridgeManager = bridgeManager;
        }

        @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader.ModelLoaderFactory
        public ModelLoader<String> build(ModelLoaderRegistry modelLoaderRegistry) {
            return new PageInfoLoader(this.bridgeManager, this.lifecycle);
        }
    }

    public PageInfoLoader(BridgeManager bridgeManager, Lifecycle lifecycle) {
        this.bridgeManager = bridgeManager;
        this.lifecycle = lifecycle;
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public ModelLoader.LoadData buildData(String str) {
        return new ModelLoader.LoadData(str, new PageInfoFetcher(this.bridgeManager, this.lifecycle));
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public boolean handles(String str) {
        return TextUtils.equals(str, LoaderConstants.PAGE_INFO);
    }
}
