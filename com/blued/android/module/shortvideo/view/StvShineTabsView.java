package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/StvShineTabsView.class */
public class StvShineTabsView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View f15915a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f15916c;
    private RelativeLayout d;
    private RelativeLayout e;
    private RelativeLayout f;
    private TextView g;
    private TextView h;
    private TextView i;

    public StvShineTabsView(Context context) {
        super(context);
        c();
    }

    public StvShineTabsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public StvShineTabsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.stv_shine_tabs_v, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.stv_channel_album_tab);
        this.d = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.stv_channel_shortvideo_tab);
        this.e = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) inflate.findViewById(R.id.stv_channel_camera_tab);
        this.f = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        this.g = (TextView) inflate.findViewById(R.id.stv_channel_local);
        this.h = (TextView) inflate.findViewById(R.id.stv_channel_shortvideo);
        this.i = (TextView) inflate.findViewById(R.id.stv_channel_camera);
        this.f15915a = inflate.findViewById(R.id.stv_channel_local_icon);
        this.b = inflate.findViewById(R.id.stv_channel_shortvideo_icon);
        this.f15916c = inflate.findViewById(R.id.stv_channel_camera_icon);
        addView(inflate);
    }

    private void d() {
        this.g.setSelected(true);
        this.f15915a.setVisibility(0);
        this.h.setSelected(false);
        this.b.setVisibility(4);
        this.i.setSelected(false);
        this.f15916c.setVisibility(4);
    }

    private void e() {
        this.g.setSelected(false);
        this.f15915a.setVisibility(4);
        this.h.setSelected(true);
        this.b.setVisibility(0);
        this.i.setSelected(false);
        this.f15916c.setVisibility(4);
    }

    private void f() {
        this.g.setSelected(false);
        this.f15915a.setVisibility(4);
        this.h.setSelected(false);
        this.b.setVisibility(4);
        this.i.setSelected(true);
        this.f15916c.setVisibility(0);
    }

    public void a() {
        if (getVisibility() == 4) {
            setVisibility(0);
        }
    }

    public void a(int i, int i2, int i3) {
        if (i == 3) {
            f();
            this.e.setVisibility(8);
            this.d.setVisibility(8);
        } else if (i == 6) {
            e();
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
        } else if (i >= 60) {
            e();
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            this.f.setVisibility(8);
        } else if (i == 1 || i == 7) {
            if (i3 == 1) {
                e();
            } else if (i3 == 2) {
                d();
            }
            this.f.setVisibility(8);
            this.d.setVisibility(0);
        } else {
            if (i3 == 1) {
                e();
            } else if (i3 == 5) {
                f();
            }
            this.d.setVisibility(8);
            this.f.setVisibility(0);
        }
    }

    public void b() {
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        StvViewUtils.a(view);
        int id = view.getId();
        if (id == R.id.stv_channel_album_tab) {
            ObserverMgr.a().a(EventType.VALUE.SHINE_TABS_LOCATION_FILE);
        } else if (id == R.id.stv_channel_shortvideo_tab) {
            ObserverMgr.a().a(EventType.VALUE.SHINE_TABS_SHINE);
        } else if (id == R.id.stv_channel_camera_tab) {
            ObserverMgr.a().a(EventType.VALUE.SHINE_TABS_CAMERA);
        }
    }
}
