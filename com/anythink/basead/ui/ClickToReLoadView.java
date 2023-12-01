package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ClickToReLoadView.class */
public class ClickToReLoadView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f6097a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private a f6098c;
    private int d;

    /* renamed from: com.anythink.basead.ui.ClickToReLoadView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ClickToReLoadView$1.class */
    final class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        long f6099a;

        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f6099a > 1000) {
                this.f6099a = currentTimeMillis;
                if (ClickToReLoadView.this.f6098c != null) {
                    ClickToReLoadView.this.f6098c.a();
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/ClickToReLoadView$a.class */
    public interface a {
        void a();
    }

    public ClickToReLoadView(Context context) {
        super(context);
        setOrientation(1);
        setGravity(17);
        this.d = h.a(context, 10.0f);
        ImageView imageView = new ImageView(context);
        this.f6097a = imageView;
        imageView.setImageResource(h.a(context, "myoffer_webview_reload_icon", i.f7952c));
        int a2 = h.a(context, 30.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.d;
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setText(getResources().getText(h.a(context, "myoffer_webview_reload", "string")));
        this.b.setTextColor(getResources().getColor(h.a(context, "color_reload_button", "color")));
        this.b.setBackgroundResource(h.a(context, "myoffer_webview_bg_reload_button", i.f7952c));
        int a3 = h.a(context, 9.0f);
        int a4 = h.a(context, 5.0f);
        this.b.setPadding(a3, a4, a3, a4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.d;
        addView(this.f6097a, layoutParams);
        addView(this.b, layoutParams2);
        this.b.setOnClickListener(new AnonymousClass1());
    }

    private void a() {
        this.b.setOnClickListener(new AnonymousClass1());
    }

    private void a(Context context) {
        setOrientation(1);
        setGravity(17);
        this.d = h.a(context, 10.0f);
        ImageView imageView = new ImageView(context);
        this.f6097a = imageView;
        imageView.setImageResource(h.a(context, "myoffer_webview_reload_icon", i.f7952c));
        int a2 = h.a(context, 30.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.d;
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setText(getResources().getText(h.a(context, "myoffer_webview_reload", "string")));
        this.b.setTextColor(getResources().getColor(h.a(context, "color_reload_button", "color")));
        this.b.setBackgroundResource(h.a(context, "myoffer_webview_bg_reload_button", i.f7952c));
        int a3 = h.a(context, 9.0f);
        int a4 = h.a(context, 5.0f);
        this.b.setPadding(a3, a4, a3, a4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.d;
        addView(this.f6097a, layoutParams);
        addView(this.b, layoutParams2);
    }

    private void b() {
        try {
            this.f6097a.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
                this.b.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getHeight() < h.a(getContext(), 100.0f)) {
            try {
                this.f6097a.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                    this.b.setLayoutParams(layoutParams);
                }
            } catch (Throwable th) {
            }
        }
    }

    public void setListener(a aVar) {
        this.f6098c = aVar;
    }
}
