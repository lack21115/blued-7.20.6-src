package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/NoDataAndLoadFailView.class */
public class NoDataAndLoadFailView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f11003a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11004c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private ShapeTextView g;
    private View h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private View.OnClickListener v;
    private View.OnClickListener w;
    private boolean x;

    public NoDataAndLoadFailView(Context context) {
        this(context, null, 0);
    }

    public NoDataAndLoadFailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoDataAndLoadFailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = true;
        this.q = false;
        this.r = false;
        this.s = false;
        this.x = true;
        this.f11003a = context;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.f11003a).inflate(R.layout.item_ll_nodata, this);
        this.b = inflate;
        inflate.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_main);
        this.f11004c = linearLayout;
        linearLayout.setBackgroundColor(BluedSkinUtils.a(this.f11003a, R.color.syc_b));
        this.d = (ImageView) this.b.findViewById(R.id.img_nodata);
        this.e = (TextView) this.b.findViewById(R.id.tv_nodata);
        this.f = (TextView) this.b.findViewById(R.id.tv_nodata_second_line);
        this.g = (ShapeTextView) this.b.findViewById(R.id.tv_reloaded);
        this.k = R.string.common_no_content_for_now;
        this.h = this.b.findViewById(R.id.bottom_line);
        this.m = R.drawable.icon_no_data_load_failed;
        this.n = R.string.common_connecting_failed;
        this.t = R.color.syc_k;
        this.u = R.color.syc_k;
        d();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f11003a.obtainStyledAttributes(attributeSet, R.styleable.NoDataAndLoadFailView);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_view_background, R.color.syc_b);
            this.i = resourceId;
            this.f11004c.setBackgroundResource(resourceId);
            this.j = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_no_data_img_res, R.drawable.icon_no_data_common);
            this.k = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_no_data_txt_res, R.string.common_no_data);
            this.m = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_fail_img_res, R.drawable.icon_no_data_load_failed);
            this.n = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_fail_txt_res, R.string.common_connecting_failed);
            this.o = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_btn_no_data_txt_res, 0);
            this.p = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_btn_no_data_txt_res, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_img_width, DensityUtils.a(this.f11003a, 160.0f));
            int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.NoDataAndLoadFailView_img_height, DensityUtils.a(this.f11003a, 160.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.width = resourceId2;
            layoutParams.height = resourceId3;
            this.d.setLayoutParams(layoutParams);
            d();
            int i = obtainStyledAttributes.getInt(R.styleable.NoDataAndLoadFailView_default_visible, 0);
            if (i == 1) {
                a();
                int i2 = this.o;
                if (i2 > 0) {
                    this.g.setText(i2);
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                }
            } else if (i != 2) {
                d();
            } else {
                b();
                int i3 = this.p;
                if (i3 > 0) {
                    this.g.setText(i3);
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(8);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a() {
        this.b.setVisibility(0);
        if (this.j == 0) {
            this.j = R.drawable.icon_no_data_common;
        }
        this.d.setImageResource(this.j);
        if (this.k == 0) {
            this.k = R.string.common_no_data;
        }
        if (!this.l) {
            this.d.setVisibility(8);
        }
        this.e.setText(this.k);
        this.e.setTextColor(BluedSkinUtils.a(this.f11003a, this.t));
        if (this.r) {
            int i = this.o;
            if (i > 0) {
                this.g.setText(i);
            }
            this.g.setVisibility(0);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.NoDataAndLoadFailView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (NoDataAndLoadFailView.this.v != null) {
                        NoDataAndLoadFailView.this.v.onClick(view);
                    }
                }
            });
        } else {
            this.g.setVisibility(4);
        }
        if (this.s) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void b() {
        this.b.setVisibility(0);
        if (this.m == 0) {
            this.m = R.drawable.icon_no_data_load_failed;
        }
        this.d.setImageResource(this.m);
        if (this.n == 0) {
            this.n = R.string.common_connecting_failed;
        }
        this.e.setText(this.n);
        this.e.setTextColor(BluedSkinUtils.a(this.f11003a, this.u));
        if (this.q) {
            int i = this.p;
            if (i > 0) {
                this.g.setText(i);
            }
            this.g.setVisibility(0);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.NoDataAndLoadFailView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (NoDataAndLoadFailView.this.w != null) {
                        NoDataAndLoadFailView.this.w.onClick(view);
                    }
                }
            });
        } else {
            this.g.setVisibility(4);
        }
        if (this.s) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public boolean c() {
        return this.b.getVisibility() == 0;
    }

    public void d() {
        this.b.setVisibility(8);
    }

    public ShapeTextView getBtn() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.x;
    }

    public void setBackgroundColorRes(int i) {
        this.b.findViewById(R.id.ll_main).setBackgroundColor(BluedSkinUtils.a(this.f11003a, i));
    }

    public void setBottomSpace(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        marginLayoutParams.bottomMargin = i;
        this.h.setLayoutParams(marginLayoutParams);
    }

    public void setBtnStr(int i) {
        this.g.setText(i);
    }

    public void setFailBtnListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.NoDataAndLoadFailView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (NoDataAndLoadFailView.this.w != null) {
                    NoDataAndLoadFailView.this.w.onClick(view);
                }
            }
        });
        this.q = true;
    }

    public void setFailBtnStr(int i) {
        this.p = i;
    }

    public void setFailBtnVisibility(int i) {
        if (i == 0) {
            this.q = true;
        } else {
            this.q = false;
        }
    }

    public void setFailImg(int i) {
        this.m = i;
        this.d.setImageResource(i);
    }

    public void setFailStr(int i) {
        this.n = i;
        this.e.setText(i);
    }

    public void setFailTextColor(int i) {
        this.u = i;
    }

    public void setImageScale(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = (int) (layoutParams.width * f);
        layoutParams.height = (int) (layoutParams.height * f);
        this.d.setLayoutParams(layoutParams);
    }

    public void setNoDataBtnListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.NoDataAndLoadFailView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (NoDataAndLoadFailView.this.v != null) {
                    NoDataAndLoadFailView.this.v.onClick(view);
                }
            }
        });
        this.r = true;
    }

    public void setNoDataBtnStr(int i) {
        this.o = i;
    }

    public void setNoDataBtnVisibility(int i) {
        if (i == 0) {
            this.r = true;
        } else {
            this.r = false;
        }
    }

    public void setNoDataImg(int i) {
        this.j = i;
        this.d.setImageDrawable(BluedSkinUtils.b(this.f11003a, i));
    }

    public void setNoDataImgVisible(int i) {
        this.l = i == 0;
    }

    public void setNoDataSecondLineVisible(int i) {
        if (i == 0) {
            this.s = true;
        } else {
            this.s = false;
        }
    }

    public void setNoDataStr(int i) {
        this.k = i;
        this.e.setText(i);
    }

    public void setNoDataTextColor(int i) {
        this.t = i;
    }

    public void setNoDataTextSize(float f) {
        this.e.setTextSize(f);
    }

    public void setOnTouchEvent(boolean z) {
        this.x = z;
    }

    public void setSecondLineFailStr(CharSequence charSequence) {
        this.f.setVisibility(0);
        this.f.setMovementMethod(LinkMovementMethod.getInstance());
        this.f.setText(charSequence);
    }

    public void setTopSpace(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.topMargin = i;
        this.d.setLayoutParams(layoutParams);
    }
}
