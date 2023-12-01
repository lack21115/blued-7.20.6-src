package com.mcxiaoke.packer.support.walle;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/support/walle/V2Utils.class */
final class V2Utils {
    V2Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }
}
