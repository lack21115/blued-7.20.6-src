package com.blued.community.ui.send.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.media.selector.utils.ViewUtils;
import com.blued.community.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/view/AlbumTabsView.class */
public class AlbumTabsView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f20081a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f20082c;
    private RelativeLayout d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private ITabsClickListener h;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/view/AlbumTabsView$ITabsClickListener.class */
    public interface ITabsClickListener {
        void C();

        void D();

        void E();
    }

    public AlbumTabsView(Context context) {
        super(context);
        a();
    }

    public AlbumTabsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public AlbumTabsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.album_tabs_v, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.album_tab);
        this.f20082c = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.shortvideo_tab);
        this.d = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.e = (RelativeLayout) inflate.findViewById(R.id.camera_tab);
        this.f = (TextView) inflate.findViewById(R.id.album);
        this.g = (TextView) inflate.findViewById(R.id.shortvideo);
        this.f20081a = inflate.findViewById(R.id.album_icon);
        this.b = inflate.findViewById(R.id.shortvideo_icon);
        addView(inflate);
    }

    private void b() {
        this.f.setSelected(true);
        this.f20081a.setVisibility(0);
        this.g.setSelected(false);
        this.b.setVisibility(4);
    }

    private void c() {
        this.g.setSelected(true);
        this.b.setVisibility(0);
        this.f.setSelected(false);
        this.f20081a.setVisibility(4);
    }

    public void a(ITabsClickListener iTabsClickListener, boolean z, int i) {
        this.h = iTabsClickListener;
        if (i == 1) {
            c();
        } else if (i == 2) {
            b();
        }
        if (!z) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        ViewUtils.a(view);
        if (this.h == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.album_tab) {
            this.h.C();
        } else if (id == R.id.shortvideo_tab) {
            this.h.D();
        } else if (id == R.id.camera_tab) {
            this.h.E();
        }
    }
}
