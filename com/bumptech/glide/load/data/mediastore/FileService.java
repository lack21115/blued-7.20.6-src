package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/mediastore/FileService.class */
class FileService {
    public File a(String str) {
        return new File(str);
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }
}
