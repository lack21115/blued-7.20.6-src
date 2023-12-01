package com.mcxiaoke.packer.support.walle;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/mcxiaoke/packer/support/walle/PayloadReader.class */
final class PayloadReader {
    private PayloadReader() {
    }

    public static ByteBuffer a(File file, int i) throws IOException {
        Map<Integer, ByteBuffer> a2 = a(file);
        if (a2 == null) {
            return null;
        }
        return a2.get(Integer.valueOf(i));
    }

    private static Map<Integer, ByteBuffer> a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            fileChannel = null;
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
            fileChannel = null;
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            fileChannel = channel;
            Map<Integer, ByteBuffer> a2 = ApkUtil.a(ApkUtil.c(channel).a());
            V2Utils.a(channel);
            V2Utils.a(randomAccessFile);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            V2Utils.a(fileChannel);
            V2Utils.a(randomAccessFile);
            throw th;
        }
    }
}
