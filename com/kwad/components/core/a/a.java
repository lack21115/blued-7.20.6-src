package com.kwad.components.core.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/a/a.class */
public final class a implements View.OnClickListener {
    private ImageView HA;
    private InterfaceC0509a HB;
    private TextView Hy;
    private ImageView Hz;
    private ViewGroup sn;

    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/a/a$a.class */
    public interface InterfaceC0509a {
        void t(View view);

        void u(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.sn = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.Hy = (TextView) this.sn.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Hz = (ImageView) this.sn.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.sn.findViewById(R.id.ksad_kwad_web_navi_close);
        this.HA = imageView;
        imageView.setOnClickListener(this);
        this.Hz.setOnClickListener(this);
    }

    public final void a(InterfaceC0509a interfaceC0509a) {
        this.HB = interfaceC0509a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.sn == null || (textView = this.Hy) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    public final void am(boolean z) {
        ImageView imageView = this.HA;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final ViewGroup gK() {
        return this.sn;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (this.HB == null) {
            return;
        }
        if (view.equals(this.HA)) {
            this.HB.u(view);
        } else if (view.equals(this.Hz)) {
            this.HB.t(view);
        }
    }
}
