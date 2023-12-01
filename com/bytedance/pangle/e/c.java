package com.bytedance.pangle.e;

import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/c.class */
public final class c implements f.a {
    private static boolean a(String str, String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i) {
        boolean z;
        String str2;
        String a2 = g.a(str, i);
        String c2 = com.bytedance.pangle.d.c.c(str, i);
        String[] split = a2.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(String.valueOf(a2)));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i2 >= length) {
                break;
            }
            z = false;
            if (!a(split[i2], c2 + File.separator + b.a(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i2++;
            z2 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z);
        return z;
    }
}
