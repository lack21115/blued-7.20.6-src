package com.kwad.components.offline.api.core.api;

import java.io.File;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/IZipper.class */
public interface IZipper {
    boolean unZip(InputStream inputStream, String str);

    boolean zip(File file, File file2);

    void zipFile(File file);
}
