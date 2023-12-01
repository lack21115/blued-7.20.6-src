package com.soft.blued.ui.web.modelloader.loader;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import com.soft.blued.ui.web.modelloader.fetcher.WebHeadMenuFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/WebHeadMenuLoader.class */
public class WebHeadMenuLoader implements ModelLoader<String> {
    Activity activity;
    BridgeManager bridgeManager;
    View view;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/WebHeadMenuLoader$Factory.class */
    public static class Factory implements ModelLoader.ModelLoaderFactory<String> {
        Activity activity;
        BridgeManager bridgeManager;
        View view;

        public Factory(BridgeManager bridgeManager, View view, Activity activity) {
            this.view = view;
            this.bridgeManager = bridgeManager;
            this.activity = activity;
        }

        public ModelLoader<String> build(ModelLoaderRegistry modelLoaderRegistry) {
            return new WebHeadMenuLoader(this.bridgeManager, this.view, this.activity);
        }
    }

    public WebHeadMenuLoader(BridgeManager bridgeManager, View view, Activity activity) {
        this.view = view;
        this.bridgeManager = bridgeManager;
        this.activity = activity;
    }

    public ModelLoader.LoadData buildData(String str) {
        return new ModelLoader.LoadData(str, new WebHeadMenuFetcher(this.bridgeManager, this.view, this.activity));
    }

    public boolean handles(String str) {
        return TextUtils.equals(str, "setHeadMenu");
    }
}
