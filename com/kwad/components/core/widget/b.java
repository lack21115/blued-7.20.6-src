package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/b.class */
public abstract class b<T extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.g.c {
    public a VS;
    private long VT;
    private com.kwad.sdk.core.g.b ca;
    public AdInfo mAdInfo;
    public T mAdTemplate;
    public Context mContext;
    protected boolean mN;
    private bh mTimerHelper;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/widget/b$a.class */
    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.uH() && com.kwad.sdk.core.config.d.uG() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0544a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void eM() {
                    if (b.this.mAdTemplate.mPvReported && b.this.mN) {
                        long EZ = b.this.getTimerHelper().EZ();
                        b.this.VT += EZ;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                        b.this.mN = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void k(View view) {
                    if (!b.this.mAdTemplate.mPvReported && b.this.VS != null) {
                        b.this.mN = true;
                        b.this.bC();
                        b.this.getTimerHelper().startTiming();
                    }
                    if (!b.this.mN) {
                        b.this.getTimerHelper().startTiming();
                    }
                    b.this.mN = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void onViewAttached() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0544a
                public final void onViewDetached() {
                    if (b.this.mAdTemplate.mPvReported && b.this.mN) {
                        long EZ = b.this.getTimerHelper().EZ();
                        b.this.VT += EZ;
                        com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, EZ, (JSONObject) null);
                        b.this.mN = false;
                    }
                }
            });
            aVar.rt();
            return;
        }
        View b = b(viewGroup);
        View view = b;
        if (b == null) {
            view = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(view);
        }
        view.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                b.this.bC();
            }
        });
        view.setNeedCheckingShow(true);
    }

    private static c b(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof c) {
                return (c) childAt;
            }
            i = i2 + 1;
        }
    }

    public static void c(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
            i = i2 + 1;
        }
    }

    private void initView() {
        k.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bk();
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(this, 70);
        a((ViewGroup) this);
    }

    public final void aL(int i) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, getTouchCoords());
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    protected void bC() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.VS) != null) {
            aVar.onAdShow();
        }
        i iVar = new i();
        y.a aVar2 = new y.a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        FeedType feedType = fromInt;
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedType = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        aVar2.templateId = String.valueOf(feedType.getType());
        iVar.a(aVar2);
        iVar.q(getHeight(), getWidth());
        com.kwad.components.core.r.b.pK().a(this.mAdTemplate, null, iVar);
    }

    public void bindView(T t) {
        this.mAdTemplate = t;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(t);
    }

    protected abstract void bk();

    public void bn() {
    }

    public final void c(i iVar) {
        iVar.c(getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar, (JSONObject) null);
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void eh() {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public long getStayTime() {
        return this.VT + getTimerHelper().getTime();
    }

    public bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    public void onPageInvisible() {
    }

    public void onPageVisible() {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        this.mViewVisibleHelper.a(this);
        this.mViewVisibleHelper.a(this.ca);
        this.mViewVisibleHelper.rD();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        this.mViewVisibleHelper.b(this);
        this.mViewVisibleHelper.rE();
        bn();
    }

    public final void ru() {
        com.kwad.sdk.core.report.a.ao(this.mAdTemplate);
        a aVar = this.VS;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.VS = aVar;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.g.b bVar) {
        this.ca = bVar;
    }
}
