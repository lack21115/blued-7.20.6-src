package com.kwad.components.offline.api.core.api;

import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/api/IEncrypt.class */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getMD5(String str);

    String getResponseData(String str);
}
