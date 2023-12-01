package com.kwai.sodler.lib;

import android.content.Context;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/g.class */
public class g extends com.kwai.sodler.lib.a.a {
    public g(String str) {
        super(str);
    }

    private static void ad(File file) {
        if (!file.exists()) {
            a.w("Sodler.simple.package", "Apk file not exist.");
            throw new PluginError.LoadError("Apk file not exist.", 4001);
        } else if (file.getAbsolutePath().trim().startsWith("/data/")) {
        } else {
            a.w("Sodler.simple.package", "Apk file seems to locate in external path (not executable), path = " + file.getAbsolutePath());
        }
    }

    @Override // com.kwai.sodler.lib.a.a
    public void as(Context context, String str) {
        ad(new File(str));
    }
}
