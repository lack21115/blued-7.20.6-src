package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/EndCardView.class */
public class EndCardView extends BaseEndCardView {
    private a e;
    private int f;
    private int g;
    private ImageView h;
    private RoundImageView i;
    private ImageView j;
    private TextView k;
    private final View.OnClickListener l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.EndCardView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/EndCardView$2.class */
    public final class AnonymousClass2 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f6109a;

        AnonymousClass2(i iVar) {
            this.f6109a = iVar;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
            if (EndCardView.this.e != null) {
                EndCardView.this.e.b();
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, final Bitmap bitmap) {
            if (TextUtils.equals(str, this.f6109a.u())) {
                EndCardView.this.h.setImageBitmap(bitmap);
                EndCardView.this.post(new Runnable() { // from class: com.anythink.basead.ui.EndCardView.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int[] a2 = u.a(EndCardView.this.getWidth(), EndCardView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                        ViewGroup.LayoutParams layoutParams = EndCardView.this.h.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = a2[0];
                            layoutParams.height = a2[1];
                            EndCardView.this.h.setLayoutParams(layoutParams);
                        }
                        if (EndCardView.this.e != null) {
                            EndCardView.this.e.b();
                        }
                    }
                });
                EndCardView.this.i.setImageBitmap(com.anythink.core.common.k.b.a(EndCardView.this.getContext(), bitmap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.EndCardView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/EndCardView$3.class */
    public final class AnonymousClass3 implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6111a;
        final /* synthetic */ int b;

        AnonymousClass3(String str, int i) {
            this.f6111a = str;
            this.b = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.f6111a)) {
                float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                int i = this.b;
                int i2 = (int) (i * width);
                ViewGroup.LayoutParams layoutParams = EndCardView.this.j.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = i;
                EndCardView.this.j.setLayoutParams(layoutParams);
                EndCardView.this.j.setScaleType(ImageView.ScaleType.FIT_XY);
                EndCardView.this.j.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/EndCardView$a.class */
    public interface a {
        void a();

        void b();
    }

    public EndCardView(Context context, i iVar, j jVar) {
        super(context, iVar, jVar);
        this.l = new View.OnClickListener() { // from class: com.anythink.basead.ui.EndCardView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (EndCardView.this.d != null) {
                    if (EndCardView.this.d.x() == 0) {
                        if (EndCardView.this.e != null) {
                            EndCardView.this.e.a();
                        }
                    } else if (EndCardView.this.k == null || !EndCardView.this.k.isShown() || view != EndCardView.this.k || EndCardView.this.e == null) {
                    } else {
                        EndCardView.this.e.a();
                    }
                }
            }
        };
    }

    private void a(i iVar) {
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, iVar.u()), this.f, this.g, new AnonymousClass2(iVar));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        ScanningAnimTextView scanningAnimTextView = new ScanningAnimTextView(getContext());
        this.k = scanningAnimTextView;
        scanningAnimTextView.setText(h.a(getContext(), "myoffer_cta_learn_more", "string"));
        this.k.setTextColor(Color.parseColor("#ffffffff"));
        this.k.setTextSize(14.0f);
        this.k.setGravity(17);
        this.k.setBackgroundResource(h.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.f7952c));
        this.k.setOnClickListener(this.l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(getContext(), 48.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = h.a(getContext(), 96.0f);
        layoutParams.leftMargin = h.a(getContext(), 24.0f);
        layoutParams.rightMargin = h.a(getContext(), 24.0f);
        addView(this.k, layoutParams);
    }

    private void b(i iVar) {
        this.j = new RoundImageView(getContext());
        int a2 = h.a(getContext(), 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        addView(this.j, layoutParams);
        String v = iVar.v();
        if (TextUtils.isEmpty(v)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, v), layoutParams2.width, layoutParams2.height, new AnonymousClass3(v, a2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseEndCardView
    public final void a() {
    }

    public View getLearnMoreButton() {
        return this.k;
    }

    public void init(boolean z, boolean z2, a aVar) {
        setId(h.a(getContext(), "myoffer_end_card_id", "id"));
        this.e = aVar;
        RoundImageView roundImageView = new RoundImageView(getContext());
        this.i = roundImageView;
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h = new RoundImageView(getContext());
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f, this.g);
        layoutParams2.addRule(13);
        addView(this.i, layoutParams);
        addView(this.h, layoutParams2);
        if (z) {
            i iVar = this.b;
            this.j = new RoundImageView(getContext());
            int a2 = h.a(getContext(), 12.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, a2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            addView(this.j, layoutParams3);
            String v = iVar.v();
            if (!TextUtils.isEmpty(v)) {
                ViewGroup.LayoutParams layoutParams4 = this.j.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, v), layoutParams4.width, layoutParams4.height, new AnonymousClass3(v, a2));
            }
        }
        if (z2) {
            ScanningAnimTextView scanningAnimTextView = new ScanningAnimTextView(getContext());
            this.k = scanningAnimTextView;
            scanningAnimTextView.setText(h.a(getContext(), "myoffer_cta_learn_more", "string"));
            this.k.setTextColor(Color.parseColor("#ffffffff"));
            this.k.setTextSize(14.0f);
            this.k.setGravity(17);
            this.k.setBackgroundResource(h.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.f7952c));
            this.k.setOnClickListener(this.l);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, h.a(getContext(), 48.0f));
            layoutParams5.addRule(12);
            layoutParams5.bottomMargin = h.a(getContext(), 96.0f);
            layoutParams5.leftMargin = h.a(getContext(), 24.0f);
            layoutParams5.rightMargin = h.a(getContext(), 24.0f);
            addView(this.k, layoutParams5);
        }
        setOnClickListener(this.l);
    }

    public void load() {
        i iVar = this.b;
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, iVar.u()), this.f, this.g, new AnonymousClass2(iVar));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setSize(int i, int i2) {
        this.f = i;
        this.g = i2;
    }
}
