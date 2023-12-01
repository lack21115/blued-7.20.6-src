package com.bytedance.pangle.plugin;

import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.f.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/plugin/a.class */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final File f7836a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, File file) {
        this.f7836a = file;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        e a2 = com.bytedance.pangle.f.a.d.a(this.f7836a);
        if (a2 == null) {
            String str = this.b;
            ZeusPluginStateListener.postStateChange(str, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.f7836a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a2.f7796a);
        if (plugin != null) {
            boolean install = plugin.install(this.f7836a, a2);
            if (install) {
                ZeusPluginStateListener.postStateChange(a2.f7796a, 6, new Object[0]);
                return install;
            }
            ZeusPluginStateListener.postStateChange(a2.f7796a, 7, "Internal error.");
            return install;
        }
        String str2 = this.b;
        ZeusPluginStateListener.postStateChange(str2, 7, " plugin == null !!! pluginPkg = " + this.b);
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a2.f7796a);
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
