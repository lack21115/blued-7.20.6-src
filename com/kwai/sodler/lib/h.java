package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/h.class */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        new StringBuilder("Install plugin so libs, destDir = ").append(file2);
        HashSet hashSet = new HashSet();
        if (!file2.exists() || (list = file2.list()) == null || list.length <= 0) {
            File file3 = new File(file2.getParentFile(), this.aJN.JT());
            q.S(file3);
            for (String str : com.kwai.sodler.lib.d.c.h(file, file3)) {
                new StringBuilder("extractSoLib, soName = ").append(str);
                File a2 = com.kwai.sodler.lib.d.c.a(file3, str, file2);
                if (a2 != null) {
                    hashSet.add(a2);
                }
            }
            q.M(file3);
            return hashSet;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.length) {
                return hashSet;
            }
            String str2 = list[i2];
            hashSet.add(new File(file2.getAbsolutePath() + File.separator + str2));
            i = i2 + 1;
        }
    }

    private File ae(File file) {
        File file2 = new File(file.getParentFile(), this.aJN.JS());
        q.S(file2);
        return file2;
    }

    private void e(Set<File> set) {
        if (this.aKr == null || this.aKr.aKZ.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> hashMap = this.aKr.aKZ;
        for (File file : set) {
            String W = ad.W(file);
            String str = hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(W, str)) {
                f(set);
                throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + W + ",except " + str), 4008);
            }
        }
    }

    private static void f(Set<File> set) {
        for (File file : set) {
            q.M(file);
        }
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void as(Context context, String str) {
        super.as(context, str);
        File file = new File(str);
        try {
            this.aKl = ae(file);
            try {
                try {
                    e(a(context, file, this.aKl));
                    ClassLoader classLoader = (this.aKr == null || this.aKr.aLc == null) ? getClass().getClassLoader() : this.aKr.aLc;
                    synchronized (Runtime.getRuntime()) {
                        com.kwai.sodler.lib.ext.d.c(classLoader, this.aKl);
                    }
                } catch (PluginError.LoadError e) {
                    q.M(file);
                    throw e;
                }
            } catch (IOException e2) {
                throw new PluginError.LoadError(e2, 4004);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }
}
