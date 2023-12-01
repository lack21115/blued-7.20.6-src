package com.kwai.filedownloader.kwai;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import com.kwai.filedownloader.e.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/c.class */
public final class c implements com.kwai.filedownloader.kwai.b {
    protected URLConnection aGo;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/c$a.class */
    public static final class a {
        private Proxy aGp;
        private Integer aGq;
        private Integer aGr;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/kwai/c$b.class */
    public static final class b implements c.b {
        private final a aGs;

        public b() {
            this(null);
        }

        private b(a aVar) {
            this.aGs = null;
        }

        @Override // com.kwai.filedownloader.e.c.b
        public final com.kwai.filedownloader.kwai.b q(String str) {
            return new c(str, this.aGs);
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    private c(URL url, a aVar) {
        this.aGo = (aVar == null || aVar.aGp == null) ? url.openConnection() : url.openConnection(aVar.aGp);
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.aGo);
        } catch (Throwable th) {
        }
        if (aVar != null) {
            if (aVar.aGq != null) {
                this.aGo.setReadTimeout(aVar.aGq.intValue());
            }
            if (aVar.aGr != null) {
                this.aGo.setConnectTimeout(aVar.aGr.intValue());
            }
        }
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> V() {
        return this.aGo.getRequestProperties();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final Map<String, List<String>> W() {
        return this.aGo.getHeaderFields();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void X() {
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void addHeader(String str, String str2) {
        this.aGo.addRequestProperty(str, str2);
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final void execute() {
        this.aGo.connect();
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final InputStream getInputStream() {
        return ((h) ServiceProvider.get(h.class)).wrapInputStream(this.aGo.getInputStream());
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final int getResponseCode() {
        URLConnection uRLConnection = this.aGo;
        if (uRLConnection instanceof HttpURLConnection) {
            try {
                return ((HttpURLConnection) uRLConnection).getResponseCode();
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
        return 0;
    }

    @Override // com.kwai.filedownloader.kwai.b
    public final String o(String str) {
        return this.aGo.getHeaderField(str);
    }
}
