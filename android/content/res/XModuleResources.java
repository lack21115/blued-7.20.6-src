package android.content.res;

import android.app.AndroidAppHelper;
import android.util.DisplayMetrics;

/* loaded from: source-259656-dex2jar.jar:android/content/res/XModuleResources.class */
public class XModuleResources extends Resources {
    private XModuleResources(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
    }

    public static XModuleResources createInstance(String str, XResources xResources) {
        if (str == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        AssetManager assetManager = new AssetManager();
        assetManager.addAssetPath(str);
        XModuleResources xModuleResources = xResources != null ? new XModuleResources(assetManager, xResources.getDisplayMetrics(), xResources.getConfiguration()) : new XModuleResources(assetManager, null, null);
        AndroidAppHelper.addActiveResource(str, xModuleResources);
        return xModuleResources;
    }

    public XResForwarder fwd(int i) {
        return new XResForwarder(this, i);
    }
}
