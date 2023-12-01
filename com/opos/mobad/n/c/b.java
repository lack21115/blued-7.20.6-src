package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.mobad.api.R;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/b.class */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f26597a;
    private TextView[] b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView[] f26598c;
    private com.opos.mobad.c.b.c d;
    private boolean e;
    private int f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/b$a.class */
    public static class a extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private ImageView[] f26601a;

        public a(ImageView[] imageViewArr) {
            this.f26601a = imageViewArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i >= 0) {
                ImageView[] imageViewArr = this.f26601a;
                if (i < imageViewArr.length) {
                    viewGroup.removeView(imageViewArr[i]);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f26601a.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i >= 0) {
                ImageView[] imageViewArr = this.f26601a;
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

    public b(Context context, int i) {
        super(context, null);
        this.e = false;
        this.f = 3000;
        this.g = i;
        this.d = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), new Runnable() { // from class: com.opos.mobad.n.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.e) {
                    b.this.f26597a.setCurrentItem(b.this.f26597a.getCurrentItem() + 1);
                }
                b.this.d.a(b.this.f);
            }
        });
        this.b = new TextView[i];
        this.f26598c = new ImageView[this.g + 2];
        b(i);
    }

    private void b(int i) {
        ViewPager viewPager = new ViewPager(getContext());
        this.f26597a = viewPager;
        addView(viewPager, new FrameLayout.LayoutParams(-1, -1));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i + 2) {
                c(i);
                this.f26597a.setAdapter(new a(this.f26598c));
                this.f26597a.setCurrentItem(1, false);
                this.f26597a.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.opos.mobad.n.c.b.2

                    /* renamed from: a  reason: collision with root package name */
                    int f26600a = 0;

                    private void a(int i4) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= b.this.b.length) {
                                return;
                            }
                            b.this.b[i6].setSelected(i6 == i4);
                            i5 = i6 + 1;
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i4) {
                        ViewPager viewPager2;
                        int i5;
                        com.opos.cmn.an.f.a.b("viewPager", "onPageScrollStateChanged " + i4);
                        if (i4 == 1 || i4 == 2) {
                            b.this.e = true;
                        } else if (i4 == 0) {
                            int i6 = this.f26600a;
                            if (i6 != 0) {
                                if (i6 == b.this.g + 1) {
                                    viewPager2 = b.this.f26597a;
                                    i5 = 1;
                                }
                                b.this.e = false;
                            }
                            viewPager2 = b.this.f26597a;
                            i5 = b.this.g;
                            viewPager2.setCurrentItem(i5, false);
                            b.this.e = false;
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i4, float f, int i5) {
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
                        if (r5 == (r4.b.g + 1)) goto L13;
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
                            r0.f26600a = r1
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
                            java.lang.String r0 = "viewPager"
                            r1 = r7
                            java.lang.String r1 = r1.toString()
                            com.opos.cmn.an.f.a.b(r0, r1)
                            r0 = r5
                            if (r0 == 0) goto L4e
                            r0 = r5
                            r1 = r4
                            com.opos.mobad.n.c.b r1 = com.opos.mobad.n.c.b.this
                            int r1 = com.opos.mobad.n.c.b.e(r1)
                            if (r0 != r1) goto L35
                            goto L4e
                        L35:
                            r0 = r5
                            r1 = 1
                            if (r0 == r1) goto L49
                            r0 = r5
                            r6 = r0
                            r0 = r5
                            r1 = r4
                            com.opos.mobad.n.c.b r1 = com.opos.mobad.n.c.b.this
                            int r1 = com.opos.mobad.n.c.b.e(r1)
                            r2 = 1
                            int r1 = r1 + r2
                            if (r0 != r1) goto L56
                        L49:
                            r0 = 0
                            r5 = r0
                            goto L5a
                        L4e:
                            r0 = r4
                            com.opos.mobad.n.c.b r0 = com.opos.mobad.n.c.b.this
                            int r0 = com.opos.mobad.n.c.b.e(r0)
                            r6 = r0
                        L56:
                            r0 = r6
                            r1 = 1
                            int r0 = r0 - r1
                            r5 = r0
                        L5a:
                            r0 = r4
                            r1 = r5
                            r0.a(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.c.b.AnonymousClass2.onPageSelected(int):void");
                    }
                });
                return;
            }
            this.f26598c[i3] = new ImageView(getContext());
            this.f26598c[i3].setScaleType(ImageView.ScaleType.FIT_XY);
            i2 = i3 + 1;
        }
    }

    private void c(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 1.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int a4 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 32.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
                layoutParams.gravity = 81;
                addView(linearLayout, layoutParams);
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a4, a4);
            this.b[i3] = new TextView(getContext());
            this.b[i3].setBackground(getResources().getDrawable(R.drawable.opos_mobad_drawable_view_pager_selector));
            this.b[i3].setSelected(true);
            if (i3 == 0) {
                layoutParams2.leftMargin = a2;
                this.b[i3].setSelected(true);
            } else {
                layoutParams2.leftMargin = a3;
                this.b[i3].setSelected(false);
            }
            if (i3 == i - 1) {
                layoutParams2.rightMargin = a2;
            }
            linearLayout.addView(this.b[i3], layoutParams2);
            i2 = i3 + 1;
        }
    }

    public void a(int i) {
        this.f = i;
        this.d.a(i);
    }

    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        ImageView[] imageViewArr = this.f26598c;
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
        int i = this.g;
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
                if (i3 == 0 && this.f26598c[this.g + 1].getDrawable() == null) {
                    this.f26598c[this.g + 1].setImageBitmap(bitmap);
                }
                if (i3 == this.g && this.f26598c[0].getDrawable() == null) {
                    this.f26598c[0].setImageBitmap(bitmap);
                }
                int i4 = i3 + 1;
                if (this.f26598c[i4].getDrawable() == null) {
                    this.f26598c[i4].setImageBitmap(bitmap);
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.a();
    }
}
