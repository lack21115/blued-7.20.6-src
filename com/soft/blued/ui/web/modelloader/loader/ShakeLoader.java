package com.soft.blued.ui.web.modelloader.loader;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.modelloader.loader.ModelLoader;
import com.soft.blued.ui.web.modelloader.fetcher.ShakeFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/ShakeLoader.class */
public class ShakeLoader implements ModelLoader<String> {
    FragmentActivity activity;
    BridgeManager bridgeManager;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/loader/ShakeLoader$Factory.class */
    public static class Factory implements ModelLoader.ModelLoaderFactory<String> {
        FragmentActivity activity;
        BridgeManager bridgeManager;

        public Factory(BridgeManager bridgeManager, FragmentActivity fragmentActivity) {
            this.bridgeManager = bridgeManager;
            this.activity = fragmentActivity;
        }

        public ModelLoader<String> build(ModelLoaderRegistry modelLoaderRegistry) {
            return new ShakeLoader(this.bridgeManager, this.activity);
        }
    }

    public ShakeLoader(BridgeManager bridgeManager, FragmentActivity fragmentActivity) {
        this.bridgeManager = bridgeManager;
        this.activity = fragmentActivity;
    }

    public ModelLoader.LoadData buildData(String str) {
        return new ModelLoader.LoadData(str, new ShakeFetcher(this.bridgeManager, this.activity));
    }

    public boolean handles(String str) {
        return TextUtils.equals(str, "shake");
    }
}
