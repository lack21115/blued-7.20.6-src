package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.File;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/init/kwai/g.class */
public final class g implements IOfflineHostApi {
    private IWebView KA;
    private IVibratorUtil KB;
    private IIdc KC;
    private IAsync Kn;
    private IEnvironment Ko;
    private IZipper Kp;
    private INet Kq;
    private IEncrypt Kr;
    private IOfflineCompoLogcat Ks;
    private ICrash Kt;
    private ILoggerReporter Ku;
    private IDownloader Kv;
    private IImageLoader Kw;
    private IVideo Kx;
    private ILive Ky;
    private ICache Kz;

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.Kn == null) {
            this.Kn = new a();
        }
        return this.Kn;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.Kz == null) {
            this.Kz = new b();
        }
        return this.Kz;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.Kt == null) {
            this.Kt = new ICrash() { // from class: com.kwad.components.core.offline.init.kwai.g.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.b.gatherException(th);
                }
            };
        }
        return this.Kt;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.Kv == null) {
            this.Kv = new IDownloader() { // from class: com.kwad.components.core.offline.init.kwai.g.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.c(str, file);
                }
            };
        }
        return this.Kv;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.Kr == null) {
            this.Kr = new c();
        }
        return this.Kr;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.Ko == null) {
            this.Ko = new d();
        }
        return this.Ko;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.KC == null) {
            this.KC = new j();
        }
        return this.KC;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.Kw == null) {
            this.Kw = new e();
        }
        return this.Kw;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.Ky == null) {
            this.Ky = new com.kwad.components.core.offline.init.a.a();
        }
        return this.Ky;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.Ks == null) {
            this.Ks = new h();
        }
        return this.Ks;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.Ku == null) {
            this.Ku = new ILoggerReporter() { // from class: com.kwad.components.core.offline.init.kwai.g.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(String str, BusinessType businessType, String str2, JSONObject jSONObject) {
                    KSLoggerReporter.a(str, businessType, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.aEG, str2, jSONObject);
                }
            };
        }
        return this.Ku;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.Kq == null) {
            this.Kq = new f();
        }
        return this.Kq;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.KB == null) {
            this.KB = new k();
        }
        return this.KB;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.Kx == null) {
            this.Kx = new com.kwad.components.core.offline.init.b.e();
        }
        return this.Kx;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.KA == null) {
            this.KA = new com.kwad.components.core.offline.init.c.b();
        }
        return this.KA;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.Kp == null) {
            this.Kp = new l();
        }
        return this.Kp;
    }
}
