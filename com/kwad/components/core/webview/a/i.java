package com.kwad.components.core.webview.a;

import android.widget.FrameLayout;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/i.class */
public interface i {
    FrameLayout getTKContainer();

    String getTkTemplateId();

    com.kwad.sdk.widget.e getTouchCoordsView();

    void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar);

    void onCloseTKDialogClick();

    void onGetContainerLimited(u.a aVar);

    void onRegisterLifecycleLisener(an anVar);

    void onRegisterVideoMuteStateListener(o oVar);

    void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar);

    void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar);

    void onSkipClick(com.kwad.components.core.webview.a.a.u uVar);

    void onTkLoadFailed();

    void onTkLoadSuccess();

    void onUpdateMuteStatus(m mVar);

    void pageClose(WebCloseStatus webCloseStatus);
}
