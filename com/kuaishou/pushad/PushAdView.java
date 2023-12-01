package com.kuaishou.pushad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.c.a.a;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.e;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/pushad/PushAdView.class */
public class PushAdView extends KSFrameLayout implements i, c {
    public static String PUSH_VIEW_TAG = "PUSH_VIEW_TAG";
    private static final String TAG = "PushAdView";
    private an mCardLifecycleHandler;
    private AdTemplate mPushAd;
    private PushAdListener mPushAdListener;
    private h mTKLoadController;
    private boolean mTKLoadSuccess;
    private b mViewVisibleHelper;

    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/pushad/PushAdView$PushAdListener.class */
    public interface PushAdListener {
        void onPushAdViewClose();

        void onPushAdViewShow();
    }

    public PushAdView(Context context) {
        super(context);
        this.mTKLoadSuccess = false;
        init(context, null, 0);
    }

    public PushAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, 0);
    }

    public PushAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTKLoadSuccess = false;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        setTag(PUSH_VIEW_TAG);
        this.mViewVisibleHelper = new b(this, 100);
    }

    private void notifyPushAdClose() {
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
            this.mCardLifecycleHandler.rc();
        }
    }

    private void notifyPushAdShow() {
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
            this.mCardLifecycleHandler.ra();
        }
    }

    public void bindView(AdTemplate adTemplate) {
        this.mPushAd = adTemplate;
        h hVar = new h(-1L, getContext()) { // from class: com.kuaishou.pushad.PushAdView.1
            @Override // com.kwad.components.core.webview.a.h
            public void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, l lVar, ViewGroup viewGroup) {
                super.onRegisterWebCardHandler(bVar, cVar, lVar, viewGroup);
                lVar.c(new p(bVar, cVar, this) { // from class: com.kuaishou.pushad.PushAdView.1.1
                    @Override // com.kwad.components.core.webview.jshandler.p
                    public void afterHandleAdClick(int i) {
                        super.afterHandleAdClick(i);
                        if (i == 1) {
                            PushAdView.this.pageClose(null);
                        }
                    }
                });
            }
        };
        this.mTKLoadController = hVar;
        hVar.bind(null, adTemplate, this);
    }

    public void destroy() {
        this.mTKLoadController.unBind();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.a.i
    public String getTkTemplateId() {
        return j.b("ksad-push-card", this.mPushAd);
    }

    @Override // com.kwad.components.core.webview.a.i
    public e getTouchCoordsView() {
        return this;
    }

    public boolean isTKLoadSuccess() {
        return this.mTKLoadSuccess;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onAdClicked(a aVar) {
        com.kwad.sdk.core.d.b.d(TAG, "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((com.kwad.sdk.c.kwai.a.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.sdk.core.g.c
    public void onPageInvisible() {
        com.kwad.sdk.core.d.b.d(TAG, "onPageInvisible: ");
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.re();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public void onPageVisible() {
        com.kwad.sdk.core.d.b.d(TAG, "onPageVisible: ");
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rd();
        }
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterLifecycleLisener(an anVar) {
        this.mCardLifecycleHandler = anVar;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(com.kwad.components.core.webview.a.kwai.p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public boolean onShow() {
        if (!this.mTKLoadSuccess || this.mPushAd == null) {
            return false;
        }
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewShow();
        }
        notifyPushAdShow();
        return true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadFailed() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadFailed");
        this.mTKLoadSuccess = false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onTkLoadSuccess() {
        com.kwad.sdk.core.d.b.d(TAG, "onTkLoadSuccess");
        this.mTKLoadSuccess = true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        this.mViewVisibleHelper.a(this);
        this.mViewVisibleHelper.rD();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        this.mViewVisibleHelper.release();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void pageClose(WebCloseStatus webCloseStatus) {
        PushAdListener pushAdListener = this.mPushAdListener;
        if (pushAdListener != null) {
            pushAdListener.onPushAdViewClose();
        }
        notifyPushAdClose();
    }

    public void setListener(PushAdListener pushAdListener) {
        this.mPushAdListener = pushAdListener;
    }
}
