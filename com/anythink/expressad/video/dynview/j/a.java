package com.anythink.expressad.video.dynview.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.video.dynview.f.e;
import com.anythink.expressad.video.dynview.g.a;
import com.anythink.expressad.video.dynview.widget.ATRotationView;
import com.anythink.expressad.video.dynview.widget.AnyThinkImageView;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/j/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5539a = "DataEnergizeWrapper";
    private static boolean k = false;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.expressad.video.dynview.i.c.b f5540c;
    private Map<String, Bitmap> d;
    private volatile boolean e;
    private String f = "#FFFFFFFF";
    private String g = "#60000000";
    private String h = "#FF5F5F5F";
    private String i = "#90ECECEC";
    private volatile long j = 0;
    private com.anythink.expressad.video.dynview.i.c.a l = null;
    private boolean m = false;
    private int n = 0;
    public com.anythink.expressad.video.dynview.e.a b = new com.anythink.expressad.video.dynview.e.a() { // from class: com.anythink.expressad.video.dynview.j.a.1
        @Override // com.anythink.expressad.video.dynview.e.a
        public final void a() {
            if (!a.this.m || a.this.f5540c == null) {
                return;
            }
            a.this.f5540c.a(a.this.n * 1000, a.this.l);
            a.this.m = false;
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void b() {
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void c() {
            if (a.this.f5540c != null) {
                a.this.f5540c.c();
                a.this.m = true;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.j.a$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/j/a$5.class */
    public final class AnonymousClass5 extends com.anythink.expressad.widget.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f5550a;

        AnonymousClass5(Map map) {
            this.f5550a = map;
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(View view) {
            if (a.this.e) {
                return;
            }
            a.f(a.this);
            a.a(a.this, this.f5550a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.j.a$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/j/a$6.class */
    public final class AnonymousClass6 implements com.anythink.expressad.video.dynview.i.c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f5551a;
        final /* synthetic */ Map b;

        AnonymousClass6(TextView textView, Map map) {
            this.f5551a = textView;
            this.b = map;
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a() {
            a.a(a.this, this.b);
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a(long j) {
            String str;
            a.this.n = (int) (j / 1000);
            long j2 = a.this.n;
            String f = d.f(this.f5551a.getContext());
            if (f.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
                if (f.contains("TW") || f.contains(com.anythink.expressad.video.dynview.a.a.ae)) {
                    str = j2 + com.anythink.expressad.video.dynview.a.a.G;
                } else {
                    str = j2 + com.anythink.expressad.video.dynview.a.a.F;
                }
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
                str = j2 + com.anythink.expressad.video.dynview.a.a.I;
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.X)) {
                str = com.anythink.expressad.video.dynview.a.a.J + j2 + " Sekunden";
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Y)) {
                str = j2 + com.anythink.expressad.video.dynview.a.a.K;
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Z)) {
                str = com.anythink.expressad.video.dynview.a.a.L + j2 + " secondes";
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.aa)) {
                str = " ثوان" + j2 + com.anythink.expressad.video.dynview.a.a.M;
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.ab)) {
                str = com.anythink.expressad.video.dynview.a.a.N + j2 + " секунд";
            } else {
                str = com.anythink.expressad.video.dynview.a.a.H + j2 + " s";
            }
            this.f5551a.setText(str);
            a.this.j++;
        }
    }

    private static int a(String str) {
        return i.a(n.a().g(), str, "id");
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmap = createBitmap;
            createBitmap.eraseColor(Color.parseColor(this.i));
            return createBitmap;
        } catch (Exception e) {
            if (com.anythink.expressad.a.f4103a) {
                e.printStackTrace();
            }
            return bitmap;
        }
    }

    private void a(final ImageView imageView, String str, final int i) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.j.a.10
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                if (bitmap == null || bitmap.isRecycled()) {
                    int a2 = i.a(imageView.getContext(), "anythink_icon_play_bg", i.f5112c);
                    imageView.setBackgroundColor(Color.parseColor(a.this.h));
                    imageView.setImageResource(a2);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    return;
                }
                int i2 = i;
                if (i2 != 501 && i2 != 802) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
                ImageView imageView2 = imageView;
                com.anythink.expressad.video.dynview.i.b.a();
                imageView2.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 0));
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                try {
                    int a2 = i.a(imageView.getContext(), "anythink_icon_play_bg", i.f5112c);
                    imageView.setBackgroundColor(Color.parseColor(a.this.h));
                    imageView.setImageResource(a2);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                } catch (Exception e) {
                    o.a(a.f5539a, e.getMessage());
                }
            }
        });
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = this.d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        Map<String, Bitmap> map2 = this.d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    static /* synthetic */ void a(a aVar, com.anythink.expressad.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = aVar.d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        Map<String, Bitmap> map2 = aVar.d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    aVar.b();
                }
            } catch (Exception e) {
                o.d(f5539a, e.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a((com.anythink.expressad.foundation.d.c) list.get(i));
            }
            aVar.b();
        } else if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a((com.anythink.expressad.foundation.d.c) list.get(i), i);
            }
            aVar.b();
        }
    }

    private void a(String str, Context context, View view, int i, Map map) {
        FrameLayout.LayoutParams layoutParams;
        String a2 = x.a(str, "cltp");
        long parseLong = !TextUtils.isEmpty(a2) ? Long.parseLong(a2) : 0L;
        if (parseLong != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                k = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            k = false;
            TextView textView = (TextView) view.findViewById(a("anythink_choice_one_countdown_tv"));
            textView.setTextSize(11.0f);
            textView.setTextColor(Color.parseColor(this.f));
            String str2 = this.g;
            if (textView != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor(str2));
                gradientDrawable.setCornerRadius(t.b(textView.getContext(), 12.0f));
                gradientDrawable.setStroke(t.b(textView.getContext(), 1.0f), Color.parseColor(str2));
                textView.setBackgroundDrawable(gradientDrawable);
            }
            if (i == 2 && (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                int d = t.d(context);
                int b = t.b(context, 10.0f);
                layoutParams.setMargins(b, b, d, b);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setOnClickListener(new AnonymousClass5(map));
                this.l = new AnonymousClass6(textView, map);
                com.anythink.expressad.video.dynview.i.c.b a3 = new com.anythink.expressad.video.dynview.i.c.b().a(parseLong * 1000).a().a(this.l);
                this.f5540c = a3;
                a3.b();
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(final String str, final ImageView imageView, final com.anythink.expressad.video.dynview.c cVar, final View view) {
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.j.a.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                ImageView imageView2;
                if (bitmap == null || bitmap.isRecycled() || (imageView2 = imageView) == null) {
                    return;
                }
                imageView2.setImageBitmap(bitmap);
                if (a.this.d != null) {
                    a.this.d.put(p.a(str), bitmap);
                    a.a(a.this, cVar, view);
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
            }
        });
        if (a() != null) {
            b(cVar, view);
        }
    }

    private void a(Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    b();
                }
            } catch (Exception e) {
                o.d(f5539a, e.getMessage());
            }
        }
    }

    private void a(Map map, List<com.anythink.expressad.foundation.d.c> list, int i) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a(list.get(i));
            }
            b();
        } else if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a(list.get(i), i);
            }
            b();
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private void b() {
        com.anythink.expressad.video.dynview.i.a.a.a().b();
        com.anythink.expressad.video.dynview.i.c.b bVar = this.f5540c;
        if (bVar != null) {
            bVar.c();
            this.f5540c = null;
        }
        com.anythink.expressad.video.dynview.b.a.a().f5512a = null;
        if (this.b != null) {
            this.b = null;
        }
        Map<String, Bitmap> map = this.d;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.d.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.d.clear();
        }
    }

    private static void b(com.anythink.expressad.video.dynview.c cVar, View view) {
        a.C0090a a2 = com.anythink.expressad.video.dynview.g.a.a();
        a2.a(cVar.e()).a();
        if (cVar.e() != 2) {
            a2.a(cVar.d()).b(cVar.c());
        } else if (cVar.d() > cVar.c()) {
            a2.a(cVar.d()).b(cVar.c());
        } else {
            a2.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackgroundDrawable(a2.b());
        }
    }

    static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    aVar.b();
                }
            } catch (Exception e) {
                o.d(f5539a, e.getMessage());
            }
        }
    }

    private void b(Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    b();
                }
            } catch (Exception e) {
                o.d(f5539a, e.getMessage());
            }
        }
    }

    static /* synthetic */ boolean f(a aVar) {
        aVar.e = true;
        return true;
    }

    public final void a(com.anythink.expressad.video.dynview.c cVar, View view, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(a("anythink_iv_adbanner_bg"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.i));
            }
            ImageView imageView2 = (ImageView) view.findViewById(a("anythink_iv_adbanner"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.i));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e) {
            o.a(f5539a, e.getMessage());
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
        }
    }

    public final void a(com.anythink.expressad.video.dynview.c cVar, View view, final Map map, e eVar) {
        com.anythink.expressad.foundation.d.c cVar2;
        com.anythink.expressad.foundation.d.c cVar3;
        FrameLayout.LayoutParams layoutParams;
        if (this.d == null) {
            this.d = new HashMap();
        }
        final List<com.anythink.expressad.foundation.d.c> g = cVar.g();
        if (view == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_ROOTVIEW);
            return;
        }
        Context context = view.getContext();
        if (context == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
            return;
        }
        if (g == null || g.size() <= 1) {
            cVar2 = null;
            cVar3 = null;
        } else {
            cVar2 = g.get(0);
            cVar3 = g.get(1);
        }
        if (cVar2 == null && eVar != null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
        } else if (cVar3 == null && eVar != null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
        } else {
            k = false;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a("anythink_top_item_rl"));
            AnyThinkImageView anyThinkImageView = (AnyThinkImageView) view.findViewById(a("anythink_top_iv"));
            ATRotationView aTRotationView = (ATRotationView) view.findViewById(a("anythink_top_ration"));
            view.findViewById(a("anythink_top_icon_iv"));
            TextView textView = (TextView) view.findViewById(a("anythink_top_title_tv"));
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(a("anythink_bottom_item_rl"));
            ATRotationView aTRotationView2 = (ATRotationView) view.findViewById(a("anythink_bottom_ration"));
            AnyThinkImageView anyThinkImageView2 = (AnyThinkImageView) view.findViewById(a("anythink_bottom_iv"));
            RoundImageView roundImageView = (RoundImageView) view.findViewById(a("anythink_bottom_icon_iv"));
            TextView textView2 = (TextView) view.findViewById(a("anythink_bottom_title_tv"));
            view.findViewById(a("anythink_reward_choice_one_like_iv"));
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.dynview.j.a.3
                    @Override // com.anythink.expressad.widget.a
                    public final void a(View view2) {
                        if (a.this.e) {
                            return;
                        }
                        a.f(a.this);
                        a.a(a.this, map, g, 0);
                    }
                });
            }
            if (anyThinkImageView != null) {
                anyThinkImageView.setCustomBorder(20, 20, 0, 0, 10, -16777216);
                a(cVar2.be(), anyThinkImageView, cVar, view);
                if (aTRotationView != null) {
                    if (!cVar2.aD()) {
                        aTRotationView.setWidthRatio(1.0f);
                        aTRotationView.setHeightRatio(1.0f);
                        aTRotationView.setAutoscroll(false);
                    } else if (TextUtils.isEmpty(cVar2.bd())) {
                        aTRotationView.setWidthRatio(1.0f);
                        aTRotationView.setHeightRatio(1.0f);
                        aTRotationView.setAutoscroll(false);
                    } else {
                        ImageView imageView = new ImageView(cVar.a());
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, t.b(cVar.a(), 200.0f)));
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        aTRotationView.addView(imageView);
                        a(cVar2.bd(), imageView);
                        aTRotationView.setWidthRatio(0.45f);
                        aTRotationView.setHeightRatio(0.9f);
                        aTRotationView.setAutoscroll(true);
                    }
                }
            }
            RoundImageView roundImageView2 = (RoundImageView) view.findViewById(a("anythink_top_icon_iv"));
            if (roundImageView2 != null) {
                roundImageView2.setType(0);
                a(cVar2.bd(), roundImageView2);
            }
            if (textView != null) {
                if (TextUtils.isEmpty(cVar2.bb())) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(cVar2.bb());
                }
            }
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.dynview.j.a.4
                    @Override // com.anythink.expressad.widget.a
                    public final void a(View view2) {
                        if (a.this.e) {
                            return;
                        }
                        a.f(a.this);
                        a.a(a.this, map, g, 1);
                    }
                });
            }
            if (anyThinkImageView2 != null) {
                anyThinkImageView2.setCustomBorder(20, 20, 0, 0, 10, -16777216);
                a(cVar3.be(), anyThinkImageView2, cVar, view);
                if (aTRotationView2 != null) {
                    if (!cVar3.aD()) {
                        aTRotationView2.setWidthRatio(1.0f);
                        aTRotationView2.setHeightRatio(1.0f);
                        aTRotationView2.setAutoscroll(false);
                    } else if (TextUtils.isEmpty(cVar3.bd())) {
                        aTRotationView2.setWidthRatio(1.0f);
                        aTRotationView2.setHeightRatio(1.0f);
                        aTRotationView2.setAutoscroll(false);
                    } else {
                        ImageView imageView2 = new ImageView(cVar.a());
                        imageView2.setLayoutParams(new FrameLayout.LayoutParams(-1, t.b(cVar.a(), 200.0f)));
                        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        aTRotationView2.addView(imageView2);
                        a(cVar3.bd(), imageView2);
                        aTRotationView2.setWidthRatio(0.45f);
                        aTRotationView2.setHeightRatio(0.9f);
                        aTRotationView2.setAutoscroll(true);
                    }
                }
            }
            if (roundImageView != null) {
                roundImageView.setType(0);
                a(cVar3.bd(), roundImageView);
            }
            if (textView2 != null) {
                textView2.setText(cVar3.bb());
            }
            String ar2 = cVar2.ar();
            int e = cVar.e();
            String a2 = x.a(ar2, "cltp");
            long parseLong = !TextUtils.isEmpty(a2) ? Long.parseLong(a2) : 0L;
            if (parseLong != 0) {
                if (map != null && map.containsKey("is_dy_success")) {
                    k = ((Boolean) map.get("is_dy_success")).booleanValue();
                }
                k = false;
                TextView textView3 = (TextView) view.findViewById(a("anythink_choice_one_countdown_tv"));
                textView3.setTextSize(11.0f);
                textView3.setTextColor(Color.parseColor(this.f));
                String str = this.g;
                if (textView3 != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor(str));
                    gradientDrawable.setCornerRadius(t.b(textView3.getContext(), 12.0f));
                    gradientDrawable.setStroke(t.b(textView3.getContext(), 1.0f), Color.parseColor(str));
                    textView3.setBackgroundDrawable(gradientDrawable);
                }
                if (e == 2 && (layoutParams = (FrameLayout.LayoutParams) textView3.getLayoutParams()) != null) {
                    int d = t.d(context);
                    int b = t.b(context, 10.0f);
                    layoutParams.setMargins(b, b, d, b);
                }
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    textView3.setOnClickListener(new AnonymousClass5(map));
                    this.l = new AnonymousClass6(textView3, map);
                    com.anythink.expressad.video.dynview.i.c.b a3 = new com.anythink.expressad.video.dynview.i.c.b().a(parseLong * 1000).a().a(this.l);
                    this.f5540c = a3;
                    a3.b();
                }
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        }
    }

    public final void b(com.anythink.expressad.video.dynview.c cVar, View view, Map map, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            k = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        k = false;
        ImageView imageView = (ImageView) view.findViewById(a("anythink_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a("anythink_reward_title_tv"));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a("anythink_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a("anythink_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a("anythink_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a("anythink_reward_desc_tv"));
        List<View> arrayList = new ArrayList<>();
        List<com.anythink.expressad.foundation.d.c> g = cVar.g();
        if (g == null || g.size() <= 0) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        com.anythink.expressad.foundation.d.c cVar2 = g.get(0);
        if (cVar2 == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            ((RoundImageView) imageView).setBorderRadius(10);
            a(cVar2.bd(), imageView);
        }
        if (textView != null) {
            textView.setText(cVar2.bb());
        }
        if (textView3 != null) {
            textView3.setText(cVar2.bc());
        }
        if (linearLayout != null) {
            double aX = cVar2.aX();
            double d = aX;
            if (aX <= 0.0d) {
                d = 5.0d;
            }
            ((AnyThinkLevelLayoutView) linearLayout).setRatingAndUser(d, cVar2.aY());
        }
        if (textView2 != null) {
            textView2.setText(cVar2.cU);
        }
        int h = cVar.h();
        if (h == 102 || h == 202 || h == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (h == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, cVar2.be(), h);
        } else if (h == 904 && cVar.k()) {
            arrayList.add(view);
        }
        eVar.a(view, arrayList);
    }

    public final void c(com.anythink.expressad.video.dynview.c cVar, View view, final Map map, e eVar) {
        try {
            if (this.d == null) {
                this.d = new HashMap();
            }
            final List<com.anythink.expressad.foundation.d.c> g = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                k = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            k = false;
            ListView listView = (ListView) view.findViewById(a("anythink_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a("anythink_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a("anythink_order_view_iv_close"));
            com.anythink.expressad.video.dynview.ordercamp.a.a aVar = new com.anythink.expressad.video.dynview.ordercamp.a.a(g);
            if (cVar.e() == 1) {
                if (listView != null) {
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.7
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                            Tracker.onItemClick(adapterView, view2, i, j);
                            a.a(a.this, map, g, i);
                        }
                    });
                }
            } else if (gridView != null) {
                int d = (int) cVar.d();
                int size = d / g.size();
                int i = size / 9;
                int i2 = i / 2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams.width = d - (i * 2);
                gridView.setLayoutParams(layoutParams);
                gridView.setColumnWidth((size - i) - (i2 / 2));
                gridView.setHorizontalSpacing(i2);
                gridView.setStretchMode(0);
                gridView.setNumColumns(g.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.8
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view2, int i3, long j) {
                        Tracker.onItemClick(adapterView, view2, i3, j);
                        a.a(a.this, map, g, i3);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Tracker.onClick(view2);
                        a.b(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception e) {
            if (eVar != null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            }
        }
    }
}
