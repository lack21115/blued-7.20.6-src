package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.CoverSlideView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/CoverView.class */
public class CoverView extends EditBottomBaseView implements View.OnTouchListener, ICoverSlideListener, EventObserver {
    private static final String d = CoverView.class.getSimpleName();
    private View e;
    private VideoFrameView f;
    private CoverSlideView g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private ICoverSlideListener m;

    public CoverView(Context context) {
        super(context);
    }

    public CoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cover_v, (ViewGroup) null);
        this.e = inflate;
        this.f = (VideoFrameView) inflate.findViewById(R.id.stv_video_frame_list);
        this.g = (CoverSlideView) this.e.findViewById(R.id.stv_cover_slide_v);
        int i = getResources().getDisplayMetrics().widthPixels;
        this.h = i;
        this.i = i / 7;
    }

    public void a(int i, int i2, int i3) {
        ICoverSlideListener iCoverSlideListener;
        this.k = i;
        this.l = i2;
        if (i == 2 || (iCoverSlideListener = this.m) == null || iCoverSlideListener.getPresenter() == null) {
            return;
        }
        EditPresenter presenter = this.m.getPresenter();
        int a = (this.i + DensityUtils.a(getContext(), 6.0f)) / 2;
        int a2 = this.h - ((this.i + DensityUtils.a(getContext(), 6.0f)) / 2);
        presenter.e(a);
        presenter.f(a2);
        presenter.d(a2 - a);
        VideoFrameView videoFrameView = this.f;
        String z = presenter.z();
        long A = presenter.A();
        int i4 = this.i;
        videoFrameView.a(z, A, i4, i4, 0, 7);
        this.j = this.i + DensityUtils.a(getContext(), 6.0f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.width = this.j;
        layoutParams.height = this.j;
        this.g.setLayoutParams(layoutParams);
        this.g.setLeft(this.m.getPresenter().y());
        this.e.setOnTouchListener(this);
        this.g.a(this.h, this);
    }

    public void a(ICoverSlideListener iCoverSlideListener) {
        this.m = iCoverSlideListener;
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        if (value == EventType.VALUE.CONFIG_COVER) {
            c();
        }
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void b() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.height = this.i + DensityUtils.a(getContext(), 6.0f);
        this.c.setLayoutParams(layoutParams);
        StvViewUtils.a(this.c, 0, 40, 0, 60);
    }

    @Override // com.blued.android.module.shortvideo.contract.ICoverSlideListener
    public void b(int i) {
        ICoverSlideListener iCoverSlideListener = this.m;
        if (iCoverSlideListener != null) {
            iCoverSlideListener.b(i);
        }
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void c() {
        super.c();
        this.m.getPresenter().h(3);
        if (this.k < 60) {
            StatisticsProxy.a().a("sv_page", (Object) "cover");
        }
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void d() {
        super.d();
        this.m.getPresenter().h(0);
        ObserverMgr.a().a(EventType.VALUE.HIDE_COVER);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void e() {
        d();
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected void f() {
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected boolean g() {
        return true;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected View getContentV() {
        return this.e;
    }

    @Override // com.blued.android.module.shortvideo.contract.ICoverSlideListener
    public EditPresenter getPresenter() {
        ICoverSlideListener iCoverSlideListener = this.m;
        if (iCoverSlideListener != null) {
            return iCoverSlideListener.getPresenter();
        }
        return null;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    protected int getTitleId() {
        return R.string.stv_select_cover_title;
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void h() {
        this.g.c();
        ObserverMgr.a().a(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void i() {
        this.g.b();
    }

    public void j() {
        ObserverMgr.a().b(this);
    }

    @Override // com.blued.android.module.shortvideo.view.EditBottomBaseView
    public void k() {
        this.g.a();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        if (motionEvent.getAction() == 0 && rawX <= this.h) {
            int top = this.g.getTop();
            int bottom = this.g.getBottom();
            int i = rawX - (this.j / 2);
            int i2 = i;
            if (i < 0) {
                i2 = 0;
            }
            int i3 = this.j;
            int i4 = i2 + i3;
            int i5 = this.h;
            int i6 = i2;
            int i7 = i4;
            if (i4 > i5) {
                i6 = i5 - i3;
                i7 = i5;
            }
            this.m.getPresenter().c(rawX);
            this.m.getPresenter().g(i6);
            b((int) this.m.getPresenter().v());
            this.g.layout(i6, top, i7, bottom);
            StvLogUtils.a(d + "cover slidev down rawx:" + rawX + " | left:" + i6 + " | currentCoverTime:" + this.m.getPresenter().v(), new Object[0]);
            return false;
        }
        return false;
    }
}
