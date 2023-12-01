package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/a.class */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private n f12903a;
    private o b;

    /* renamed from: c  reason: collision with root package name */
    private TextView[] f12904c;
    private ImageView[] d;
    private com.opos.mobad.c.b.c e;
    private boolean f;
    private int g;
    private int h;
    private final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/a$a.class */
    public static class C0539a extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private ImageView[] f12908a;

        public C0539a(ImageView[] imageViewArr) {
            this.f12908a = imageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0) {
                ImageView[] imageViewArr = this.f12908a;
                if (i < imageViewArr.length) {
                    viewGroup.removeView(imageViewArr[i]);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f12908a.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i >= 0) {
                ImageView[] imageViewArr = this.f12908a;
                if (i < imageViewArr.length) {
                    ImageView imageView = imageViewArr[i];
                    viewGroup.addView(imageView);
                    return imageView;
                }
                return null;
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public a(Context context, int i, boolean z, int i2) {
        super(context, null);
        this.f = false;
        this.g = 5000;
        this.h = 0;
        this.i = i;
        this.h = i2;
        this.e = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), new Runnable() { // from class: com.opos.mobad.n.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.f) {
                    a.this.f12903a.setCurrentItem(a.this.f12903a.getCurrentItem() + 1);
                    if (a.this.b != null && a.this.h > 0) {
                        a.this.b.a(a.this.h);
                    }
                }
                a.this.e.a(a.this.g + a.this.h);
            }
        });
        this.f12904c = new TextView[i];
        this.d = new ImageView[this.i + 2];
        a(i, z);
    }

    public static a a(Context context, int i, boolean z) {
        return new a(context, i, z, 0);
    }

    private void a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            o oVar = new o(this.f12903a.getContext(), new AccelerateInterpolator());
            this.b = oVar;
            declaredField.set(this.f12903a, oVar);
            this.b.a(this.h);
        } catch (Exception e) {
            this.b = null;
        }
    }

    private void a(int i, final boolean z) {
        this.f12903a = new n(getContext());
        if (this.h > 0) {
            a();
        }
        addView(this.f12903a, new FrameLayout.LayoutParams(-1, -1));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i + 2) {
                break;
            }
            this.d[i3] = new ImageView(getContext());
            this.d[i3].setScaleType(ImageView.ScaleType.FIT_XY);
            i2 = i3 + 1;
        }
        if (z) {
            b(i);
        }
        this.f12903a.setAdapter(new C0539a(this.d));
        this.f12903a.setCurrentItem(1, false);
        this.f12903a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.n.c.a.2

            /* renamed from: a  reason: collision with root package name */
            int f12906a = 0;

            private void a(int i4) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= a.this.f12904c.length) {
                        return;
                    }
                    if (a.this.f12904c[i6] != null) {
                        a.this.f12904c[i6].setSelected(i6 == i4);
                    }
                    i5 = i6 + 1;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
                n nVar;
                int i5;
                com.opos.cmn.an.f.a.b("CarouselVerticalViewPager", "onPageScrollStateChanged " + i4);
                if (i4 == 1 || i4 == 2) {
                    a.this.f = true;
                } else if (i4 == 0) {
                    int i6 = this.f12906a;
                    if (i6 != 0) {
                        if (i6 == a.this.i + 1) {
                            nVar = a.this.f12903a;
                            i5 = 1;
                        }
                        a.this.f = false;
                    }
                    nVar = a.this.f12903a;
                    i5 = a.this.i;
                    nVar.setCurrentItem(i5, false);
                    a.this.f = false;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f, int i5) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
                if (r5 == (r4.f12907c.i + 1)) goto L16;
             */
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPageSelected(int r5) {
                /*
                    r4 = this;
                    r0 = r4
                    r1 = r5
                    r0.f12906a = r1
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    r1.<init>()
                    r7 = r0
                    r0 = r7
                    java.lang.String r1 = "onPageSelected position = "
                    java.lang.StringBuilder r0 = r0.append(r1)
                    r0 = r7
                    r1 = r5
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = "CarouselVerticalViewPager"
                    r1 = r7
                    java.lang.String r1 = r1.toString()
                    com.opos.cmn.an.f.a.b(r0, r1)
                    r0 = r4
                    boolean r0 = r5
                    if (r0 != 0) goto L2b
                    return
                L2b:
                    r0 = r5
                    if (r0 == 0) goto L56
                    r0 = r5
                    r1 = r4
                    com.opos.mobad.n.c.a r1 = com.opos.mobad.n.c.a.this
                    int r1 = com.opos.mobad.n.c.a.g(r1)
                    if (r0 != r1) goto L3d
                    goto L56
                L3d:
                    r0 = r5
                    r1 = 1
                    if (r0 == r1) goto L51
                    r0 = r5
                    r6 = r0
                    r0 = r5
                    r1 = r4
                    com.opos.mobad.n.c.a r1 = com.opos.mobad.n.c.a.this
                    int r1 = com.opos.mobad.n.c.a.g(r1)
                    r2 = 1
                    int r1 = r1 + r2
                    if (r0 != r1) goto L5e
                L51:
                    r0 = 0
                    r5 = r0
                    goto L62
                L56:
                    r0 = r4
                    com.opos.mobad.n.c.a r0 = com.opos.mobad.n.c.a.this
                    int r0 = com.opos.mobad.n.c.a.g(r0)
                    r6 = r0
                L5e:
                    r0 = r6
                    r1 = 1
                    int r0 = r0 - r1
                    r5 = r0
                L62:
                    r0 = r4
                    r1 = r5
                    r0.a(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.c.a.AnonymousClass2.onPageSelected(int):void");
            }
        });
    }

    public static a b(Context context, int i, boolean z) {
        return new a(context, i, z, 300);
    }

    private void b(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
                layoutParams.gravity = 21;
                addView(linearLayout, layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a3, a3);
            this.f12904c[i3] = new TextView(getContext());
            this.f12904c[i3].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.f12904c[i3].setSelected(true);
            if (i3 == 0) {
                this.f12904c[i3].setSelected(true);
            } else {
                layoutParams2.topMargin = a2;
                this.f12904c[i3].setSelected(false);
            }
            linearLayout.addView(this.f12904c[i3], layoutParams2);
            i2 = i3 + 1;
        }
    }

    public void a(int i) {
        this.g = i;
        this.e.a(i);
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        ImageView[] imageViewArr = this.d;
        int length = imageViewArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            ImageView imageView = imageViewArr[i2];
            imageView.setOnClickListener(gVar);
            imageView.setOnTouchListener(gVar);
            i = i2 + 1;
        }
    }

    public void a(List<Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        int i = this.i;
        List<Bitmap> list2 = list;
        if (size > i) {
            list2 = list.subList(0, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list2.size()) {
                return;
            }
            Bitmap bitmap = list2.get(i3);
            if (bitmap != null) {
                if (i3 == 0 && this.d[this.i + 1].getDrawable() == null) {
                    this.d[this.i + 1].setImageBitmap(bitmap);
                }
                if (i3 == this.i && this.d[0].getDrawable() == null) {
                    this.d[0].setImageBitmap(bitmap);
                }
                int i4 = i3 + 1;
                if (this.d[i4].getDrawable() == null) {
                    this.d[i4].setImageBitmap(bitmap);
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.a();
    }
}
