package com.mcxiaoke.packer.helper;

import android.content.Context;
import com.mcxiaoke.packer.common.PackerCommon;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/helper/PackerNg.class */
public final class PackerNg {
    public static String a(Context context) {
        try {
            return b(context);
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(Context context) throws IOException {
        String a2;
        synchronized (PackerNg.class) {
            try {
                a2 = PackerCommon.a(new File(context.getApplicationInfo().sourceDir));
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }
}
