package com.mcxiaoke.packer.support.walle;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/support/walle/Support.class */
public class Support {
    public static ByteBuffer a(File file, int i) throws IOException {
        return PayloadReader.a(file, i);
    }
}
