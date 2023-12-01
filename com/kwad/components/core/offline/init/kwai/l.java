package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.bq;
import java.io.File;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/kwai/l.class */
final class l implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return bq.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return bq.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        bq.zipFile(file);
    }
}
