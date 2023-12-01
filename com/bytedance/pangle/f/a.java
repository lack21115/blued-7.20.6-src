package com.bytedance.pangle.f;

import com.bytedance.pangle.c;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a.class */
public class a extends c.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f21395a;

    public static a b() {
        if (f21395a == null) {
            synchronized (a.class) {
                try {
                    if (f21395a == null) {
                        f21395a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21395a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
