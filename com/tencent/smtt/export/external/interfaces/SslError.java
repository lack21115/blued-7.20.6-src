package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/SslError.class */
public interface SslError {
    boolean addError(int i);

    SslCertificate getCertificate();

    int getPrimaryError();

    String getUrl();

    boolean hasError(int i);
}
