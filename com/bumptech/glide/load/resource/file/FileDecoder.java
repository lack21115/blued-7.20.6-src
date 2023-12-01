package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/file/FileDecoder.class */
public class FileDecoder implements ResourceDecoder<File, File> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<File> a(File file, int i, int i2, Options options) {
        return new FileResource(file);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(File file, Options options) {
        return true;
    }
}
