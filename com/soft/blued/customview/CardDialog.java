package com.soft.blued.customview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CardDialog.class */
public class CardDialog extends Dialog {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CardDialog$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Context f14677a;

        /* renamed from: c  reason: collision with root package name */
        private CirclePageIndicator f14678c;
        private View d;
        private ViewPager e;
        private int f;
        private int g;
        private int h;
        private DialogInterface.OnClickListener i;
        private DialogInterface.OnClickListener j;
        private CardDialog b = null;
        private Timer k = new Timer();

        public Builder(Context context) {
            this.f14677a = context;
        }

        public Builder a() {
            View inflate = ((LayoutInflater) this.f14677a.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_card, (ViewGroup) null);
            this.d = inflate;
            this.f14678c = (CirclePageIndicator) inflate.findViewById(R.id.cpi_guide_dot);
            this.e = (ViewPager) this.d.findViewById(R.id.vp_binding_content);
            return this;
        }

        public Builder a(int i, int i2) {
            this.g = i;
            this.h = i2;
            return this;
        }

        public Builder a(DialogInterface.OnClickListener onClickListener) {
            this.i = onClickListener;
            return this;
        }

        public void a(int i) {
            this.h = i;
        }

        public Dialog b() {
            return this.b;
        }

        public Builder b(DialogInterface.OnClickListener onClickListener) {
            this.j = onClickListener;
            return this;
        }

        public int c() {
            return this.g;
        }

        public int d() {
            return this.h;
        }

        public Builder e() {
            final ArrayList arrayList = new ArrayList();
            View inflate = LayoutInflater.from(this.f14677a).inflate(R.layout.dialog_page_binding_phone, (ViewGroup) null);
            View inflate2 = LayoutInflater.from(this.f14677a).inflate(R.layout.dialog_page_binding_email, (ViewGroup) null);
            this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.customview.CardDialog.Builder.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    Builder.this.f = i;
                    if (Builder.this.c() == 2) {
                        if (i == 0) {
                            Builder.this.a(0);
                        } else if (i == 1) {
                            Builder.this.a(1);
                        }
                    }
                }
            });
            if (this.g == 2) {
                arrayList.add(inflate);
                arrayList.add(inflate2);
            } else {
                int i = this.h;
                if (i == 0) {
                    arrayList.add(inflate);
                } else if (i == 1) {
                    arrayList.add(inflate2);
                }
            }
            this.e.setAdapter(new PagerAdapter() { // from class: com.soft.blued.customview.CardDialog.Builder.2
                @Override // androidx.viewpager.widget.PagerAdapter
                public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
                    viewGroup.removeView((View) arrayList.get(i2));
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public int getCount() {
                    return arrayList.size();
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public int getItemPosition(Object obj) {
                    return super.getItemPosition(obj);
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public Object instantiateItem(ViewGroup viewGroup, int i2) {
                    viewGroup.addView((View) arrayList.get(i2));
                    return arrayList.get(i2);
                }

                @Override // androidx.viewpager.widget.PagerAdapter
                public boolean isViewFromObject(View view, Object obj) {
                    return view == obj;
                }
            });
            this.k.schedule(new TimerTask() { // from class: com.soft.blued.customview.CardDialog.Builder.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (Builder.this.f == arrayList.size() - 1) {
                        Builder.this.f = -1;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.customview.CardDialog.Builder.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Builder.this.e.setCurrentItem(Builder.this.f + 1);
                        }
                    });
                }
            }, 5000L, 5000L);
            if (arrayList.size() == 1) {
                this.f14678c.setVisibility(8);
                return this;
            }
            this.f14678c.setVisibility(0);
            this.f14678c.setRadius(5.0f);
            this.f14678c.setViewPager(this.e);
            this.f14678c.setInterval(18);
            this.f14678c.setFillColor(2131101291);
            this.f14678c.setPageColor(2131101287);
            this.f14678c.setStrokeColor(2131101287);
            this.f14678c.setStrokeWidth(1.0f);
            return this;
        }

        public CardDialog f() {
            CardDialog cardDialog = new CardDialog(this.f14677a);
            this.b = cardDialog;
            cardDialog.requestWindowFeature(1);
            this.b.setContentView(this.d);
            Window window = this.b.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setBackgroundDrawableResource(2131102388);
            attributes.width = DensityUtils.a(this.f14677a, 240.0f);
            attributes.height = DensityUtils.a(this.f14677a, 300.0f);
            window.setAttributes(attributes);
            if (this.i != null) {
                ((TextView) this.d.findViewById(R.id.tv_button_pos)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.CardDialog.Builder.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        Builder.this.i.onClick(Builder.this.b, -1);
                    }
                });
            }
            if (this.j != null) {
                ((TextView) this.d.findViewById(R.id.tv_button_neg)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.CardDialog.Builder.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        Builder.this.j.onClick(Builder.this.b, -2);
                    }
                });
            }
            return this.b;
        }
    }

    public CardDialog(Context context) {
        super(context);
    }
}
