package com.kwad.components.offline.api.core;

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

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/IOfflineHostApi.class */
public interface IOfflineHostApi {
    IAsync async();

    ICache cache();

    ICrash crash();

    IDownloader downloader();

    IEncrypt encrypt();

    IEnvironment env();

    IIdc idc();

    IImageLoader imageLoader();

    ILive live();

    IOfflineCompoLogcat log();

    ILoggerReporter loggerReporter();

    INet net();

    IVibratorUtil vibratorUtil();

    IVideo video();

    IWebView webview();

    IZipper zipper();
}
