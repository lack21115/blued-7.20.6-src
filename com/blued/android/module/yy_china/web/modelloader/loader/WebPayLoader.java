package com.blued.android.module.yy_china.web.modelloader.loader;

import android.text.TextUtils;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import com.blued.android.module.yy_china.web.modelloader.fetcher.WebPayFetcher;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/web/modelloader/loader/WebPayLoader.class */
public class WebPayLoader implements ModelLoader<String> {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/web/modelloader/loader/WebPayLoader$Factory.class */
    public static class Factory implements ModelLoader.ModelLoaderFactory<String> {
        @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader.ModelLoaderFactory
        public ModelLoader<String> build(ModelLoaderRegistry modelLoaderRegistry) {
            return new WebPayLoader();
        }
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public ModelLoader.LoadData buildData(String str) {
        return new ModelLoader.LoadData(str, new WebPayFetcher());
    }

    @Override // com.blued.android.module.common.web.modelloader.loader.ModelLoader
    public boolean handles(String str) {
        return TextUtils.equals(str, LoaderConstants.YY_BUY_GIFT);
    }
}
