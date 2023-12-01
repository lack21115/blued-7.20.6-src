package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.k.u;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MediaAdView.class */
public class MediaAdView extends BaseMediaAdView {
    public static final String TAG = "anythink_" + MediaAdView.class.getSimpleName();
    RelativeLayout g;
    RelativeLayout h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    final float m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private RoundImageView s;
    private TextView t;

    public MediaAdView(Context context, i iVar, j jVar, boolean z, BaseMediaAdView.a aVar) {
        super(context, iVar, jVar, z, aVar);
        this.m = 1.0f;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public List<View> getClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        arrayList.add(this.q);
        arrayList.add(this.o);
        arrayList.add(this.s);
        arrayList.add(this.t);
        if (this.b != null && this.b.x() == 0) {
            arrayList.add(this.p);
            arrayList.add(this.g);
        }
        return arrayList;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public View getMonitorClickView() {
        return this.o;
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void init(int i, int i2) {
        View findViewById;
        super.init(i, i2);
        View inflate = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_media_ad_view", "layout"), (ViewGroup) null, false);
        if (this.f != null) {
            this.f.removeAllViews();
            this.f.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        }
        this.n = (TextView) findViewById(h.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.o = (TextView) findViewById(h.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.p = (ImageView) findViewById(h.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.q = (ImageView) findViewById(h.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.r = (ImageView) findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        this.s = (RoundImageView) findViewById(h.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.t = (TextView) findViewById(h.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.g = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_media_ad_container", "id"));
        this.h = (RelativeLayout) findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.i = (TextView) findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.j = (TextView) findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.k = (TextView) findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.l = (TextView) findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        String r = this.a.r();
        if (TextUtils.isEmpty(r)) {
            this.n.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = 0;
                this.t.setLayoutParams(layoutParams);
            }
        } else {
            this.n.setText(r);
        }
        String w = this.a.w();
        if (TextUtils.isEmpty(w)) {
            this.o.setText(h.a(getContext(), "myoffer_cta_learn_more", "string"));
        } else {
            this.o.setText(w);
        }
        this.q.setScaleType(ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.u()), i, i2, new b.a() { // from class: com.anythink.basead.ui.MediaAdView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
                Log.e(MediaAdView.TAG, "load: image load fail:".concat(String.valueOf(str2)));
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(MediaAdView.this.a.u(), str)) {
                    MediaAdView.this.q.setImageBitmap(bitmap);
                    MediaAdView.this.post(new Runnable() { // from class: com.anythink.basead.ui.MediaAdView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            int[] a = u.a(MediaAdView.this.getWidth(), MediaAdView.this.getHeight(), bitmap.getWidth() / bitmap.getHeight());
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) MediaAdView.this.q.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.width = a[0];
                                layoutParams2.height = a[1];
                                layoutParams2.addRule(13);
                                MediaAdView.this.q.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                    Bitmap a = com.anythink.core.common.k.b.a(MediaAdView.this.getContext(), bitmap);
                    MediaAdView.this.p.setScaleType(ImageView.ScaleType.FIT_XY);
                    MediaAdView.this.p.setImageBitmap(a);
                }
            }
        });
        if (TextUtils.isEmpty(this.a.v())) {
            this.r.setVisibility(8);
        } else {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.v()), new b.a() { // from class: com.anythink.basead.ui.MediaAdView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    MediaAdView.this.r.setVisibility(8);
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(MediaAdView.this.a.v(), str)) {
                        MediaAdView.this.r.setImageBitmap(bitmap);
                        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                        ViewGroup.LayoutParams layoutParams2 = MediaAdView.this.r.getLayoutParams();
                        int i3 = layoutParams2.height;
                        layoutParams2.width = (int) (i3 * width);
                        layoutParams2.height = i3;
                        MediaAdView.this.r.setLayoutParams(layoutParams2);
                        MediaAdView.this.r.setScaleType(ImageView.ScaleType.FIT_XY);
                        MediaAdView.this.r.setImageBitmap(bitmap);
                        MediaAdView.this.r.setVisibility(0);
                    }
                }
            });
        }
        String s = this.a.s();
        if (TextUtils.isEmpty(s)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(s);
        }
        if (TextUtils.isEmpty(this.a.t())) {
            this.s.setVisibility(8);
        } else {
            this.s.setRadiusInDip(6);
            this.s.setNeedRadiu(true);
            ViewGroup.LayoutParams layoutParams2 = this.s.getLayoutParams();
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.a.t()), layoutParams2.width, layoutParams2.height, new b.a() { // from class: com.anythink.basead.ui.MediaAdView.3
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(MediaAdView.this.a.t(), str)) {
                        MediaAdView.this.s.setImageBitmap(bitmap);
                    }
                }
            });
        }
        if (this.a.K()) {
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
            }
            TextView textView = this.i;
            if (textView != null) {
                textView.setVisibility(0);
                this.i.setText(this.a.F());
                this.i.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.j.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        l.b(n.a().g(), MediaAdView.this.a.H());
                    }
                });
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        l.b(n.a().g(), MediaAdView.this.a.I());
                    }
                });
            }
            TextView textView4 = this.l;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.l.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", "string"), this.a.G()));
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MediaAdView.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
            }
        }
        if (com.anythink.basead.a.e.a(this.a) || (findViewById = findViewById(h.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = h.a(getContext(), 84.0f);
            findViewById.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
