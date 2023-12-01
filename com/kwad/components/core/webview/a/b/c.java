package com.kwad.components.core.webview.a.b;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.b.g;
import com.kwad.sdk.utils.bd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/b/c.class */
public class c extends a {
    private FrameLayout PE;
    private String Vt;
    private p Vx;
    private an Vy;
    private com.kwad.components.core.webview.a.d.d Vz = new com.kwad.components.core.webview.a.d.d() { // from class: com.kwad.components.core.webview.a.b.c.2
        @Override // com.kwad.components.core.webview.a.d.d
        public final void fZ() {
            if (c.this.Vy != null) {
                c.this.Vy.qZ();
                c.this.Vy.ra();
            }
        }

        @Override // com.kwad.components.core.webview.a.d.d
        public final void gg() {
            if (c.this.Vy != null) {
                c.this.Vy.rb();
                c.this.Vy.rc();
            }
        }
    };
    private d mTkDialogFragment;

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        if (this.Vr.Vw != null) {
            this.Vr.Vw.ga();
        }
        com.kwad.components.core.webview.a.c.a.rn().aS(getTkTemplateId());
        if (this.Vr.Vu != null) {
            this.Vr.Vu.callbackPageStatus(false, "render failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.webview.a.b.a
    public final void a(b bVar) {
        super.a(bVar);
        this.Vt = this.Vr.Vt;
        this.mTkDialogFragment = this.Vr.mTkDialogFragment;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.a(this.Vz);
        }
        if (this.Vr.Vu != null) {
            this.mTKLoadController.setTKBridgeHandler(new g() { // from class: com.kwad.components.core.webview.a.b.c.1
                @Override // com.kwad.sdk.core.webview.b.g
                public final void callTKBridge(String str) {
                    c.this.Vr.Vu.callTKBridge(str);
                }
            });
            this.Vr.Vu.a(this.mTKLoadController);
            this.mTKLoadController.addCustomEnv("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public FrameLayout getTKContainer() {
        return this.PE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public String getTkTemplateId() {
        return this.Vr.mStyleTemplate != null ? this.Vr.mStyleTemplate.templateId : j.b(this.Vt, this.Vr.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
        super.onCloseTKDialogClick();
        if (this.Vr.Vv) {
            if (this.Vr.Pv != null) {
                this.Vr.Pv.J(true);
                return;
            }
            return;
        }
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        if (this.Vr.Pv != null) {
            this.Vr.Pv.gh();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.PE = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterLifecycleLisener(an anVar) {
        this.Vy = anVar;
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, i iVar) {
        this.Vx = pVar;
        long j = this.Vr.mPlayedDuration;
        if (this.Vx == null || j <= 0) {
            return;
        }
        z zVar = new z();
        zVar.nZ = (int) ((((float) j) / 1000.0f) + 0.5f);
        this.Vx.a(zVar);
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
        super.onSkipClick(uVar);
        d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        if (this.Vr.Pv != null) {
            this.Vr.Pv.J(true);
        }
    }

    public void onTkLoadFailed() {
        d dVar = this.mTkDialogFragment;
        if (dVar == null) {
            rk();
            return;
        }
        if (dVar.isShowing()) {
            this.mTkDialogFragment.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.a.b.c.3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.this.mTkDialogFragment.e(this);
                    c.this.rk();
                }
            });
        } else {
            rk();
        }
        this.mTkDialogFragment.dismiss();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadSuccess() {
        if (this.Vr.Vu != null) {
            this.Vr.Vu.callbackPageStatus(true, null);
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.i
    public void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        if (this.Vr.Vu != null) {
            this.Vr.Vu.callbackDialogDismiss();
        }
    }
}
