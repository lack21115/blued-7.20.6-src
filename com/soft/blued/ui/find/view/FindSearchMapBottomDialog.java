package com.soft.blued.ui.find.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog.class */
public class FindSearchMapBottomDialog extends Dialog {
    private CharSequence A;
    private CharSequence B;
    private CharSequence C;
    private CharSequence D;
    private CharSequence E;
    private CharSequence F;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private Drawable K;
    private DialogInterface.OnClickListener L;
    private ConfirmBtnListener M;
    private DialogInterface.OnClickListener N;
    private DialogInterface.OnDismissListener O;
    private DismissListener P;

    /* renamed from: a  reason: collision with root package name */
    private int f30685a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private CardView f30686c;
    private ConstraintLayout d;
    private ConstraintLayout e;
    private ShapeConstraintLayout f;
    private ShapeConstraintLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ToggleButton s;
    private ToggleButton t;
    private CheckBox u;
    private ImageView v;
    private CharSequence w;
    private CharSequence x;
    private CharSequence y;
    private CharSequence z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final FindSearchMapBottomDialog f30690a;

        public Builder(Context context) {
            this.f30690a = new FindSearchMapBottomDialog(context);
        }

        public Builder a(int i) {
            this.f30690a.f30685a = i;
            return this;
        }

        public Builder a(Drawable drawable) {
            if (drawable == null) {
                return this;
            }
            this.f30690a.K = drawable;
            return this;
        }

        public Builder a(DismissListener dismissListener) {
            this.f30690a.P = dismissListener;
            return this;
        }

        public Builder a(Boolean bool) {
            if (bool == null) {
                this.f30690a.setCanceledOnTouchOutside(false);
                return this;
            }
            this.f30690a.setCanceledOnTouchOutside(bool.booleanValue());
            return this;
        }

        public Builder a(CharSequence charSequence) {
            if (charSequence != null) {
                if (StringUtils.d(charSequence.toString())) {
                    return this;
                }
                this.f30690a.w = charSequence.toString();
            }
            return this;
        }

        public Builder a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.F = charSequence;
            this.f30690a.L = onClickListener;
            return this;
        }

        public Builder a(CharSequence charSequence, ConfirmBtnListener confirmBtnListener) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.G = charSequence;
            this.f30690a.M = confirmBtnListener;
            return this;
        }

        public FindSearchMapBottomDialog a() {
            return this.f30690a;
        }

        public Builder b(Boolean bool) {
            if (bool == null) {
                return this;
            }
            this.f30690a.I = bool.booleanValue();
            return this;
        }

        public Builder b(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.x = charSequence;
            return this;
        }

        public Builder b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.H = charSequence;
            this.f30690a.N = onClickListener;
            return this;
        }

        public Builder c(Boolean bool) {
            if (bool == null) {
                return this;
            }
            this.f30690a.J = bool.booleanValue();
            return this;
        }

        public Builder c(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.y = charSequence;
            return this;
        }

        public Builder d(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.z = charSequence;
            return this;
        }

        public Builder e(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.A = charSequence;
            return this;
        }

        public Builder f(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.B = charSequence;
            return this;
        }

        public Builder g(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.C = charSequence;
            return this;
        }

        public Builder h(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.D = charSequence;
            return this;
        }

        public Builder i(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.f30690a.E = charSequence;
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog$ConfirmBtnListener.class */
    public interface ConfirmBtnListener {
        void a(Dialog dialog, boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog$DIALOG_TYPE.class */
    public interface DIALOG_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog$DialogTypeDef.class */
    public @interface DialogTypeDef {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FindSearchMapBottomDialog$DismissListener.class */
    public interface DismissListener {
        void a(Dialog dialog, boolean z);
    }

    public FindSearchMapBottomDialog(Context context) {
        super(context);
        this.b = context;
    }

    private void a() {
        this.f30686c = (CardView) findViewById(2131362728);
        this.d = (ConstraintLayout) findViewById(R.id.cl_dialog_center);
        this.h = (TextView) findViewById(R.id.tv_shadow_title);
        this.i = (TextView) findViewById(R.id.tv_shadow_subtitle);
        this.f = (ShapeConstraintLayout) findViewById(R.id.cl_shadow_card);
        this.j = (TextView) findViewById(2131371285);
        this.k = (TextView) findViewById(2131371868);
        this.s = (ToggleButton) findViewById(R.id.tglbtn_setting_shadow);
        this.g = (ShapeConstraintLayout) findViewById(R.id.open_location_card);
        this.l = (TextView) findViewById(R.id.tv_open_location_card_title);
        this.m = (TextView) findViewById(R.id.tv_open_location_card_subtitle);
        this.t = (ToggleButton) findViewById(R.id.tglbtn_open_location);
        this.n = (TextView) findViewById(R.id.tv_pay_vip_title);
        this.o = (TextView) findViewById(R.id.tv_pay_vip_subtitle);
        this.p = (TextView) findViewById(2131371051);
        this.q = (TextView) findViewById(2131371164);
        this.r = (TextView) findViewById(R.id.tv_open_header_location);
        this.u = (CheckBox) findViewById(R.id.cb_no_remind);
        this.v = (ImageView) findViewById(R.id.iv_dialog_top);
        this.e = (ConstraintLayout) findViewById(R.id.cl_content_view);
        b();
    }

    private void a(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
        this.h.setVisibility(z ? 0 : 8);
        this.i.setVisibility(z ? 0 : 8);
        this.j.setVisibility(z ? 0 : 8);
        this.k.setVisibility(z ? 0 : 8);
        ToggleButton toggleButton = this.s;
        int i = 8;
        if (z) {
            i = 0;
        }
        toggleButton.setVisibility(i);
        if (z) {
            this.s.setChecked(this.I);
        }
        if (this.I) {
            this.p.setVisibility(0);
            this.p.getBackground().setAlpha(20);
        }
    }

    private void a(boolean z, boolean z2) {
        this.n.setVisibility(z ? 0 : 8);
        this.o.setVisibility(z ? 0 : 8);
        this.u.setVisibility(z2 ? 0 : 8);
    }

    private void b() {
        int i = this.f30685a;
        if (i == 0) {
            this.e.setPadding(0, 220, 0, 100);
            c();
            i();
        } else if (i == 1) {
            this.e.setPadding(0, 220, 0, 100);
            d();
            i();
        } else if (i == 2) {
            this.e.setPadding(0, 220, 0, 100);
            e();
            i();
            j();
        } else if (i == 3) {
            this.e.setPadding(0, 220, 0, 100);
            f();
            i();
        } else if (i != 4) {
        } else {
            this.e.setPadding(0, 50, 0, 100);
            g();
            h();
            i();
        }
    }

    private void b(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        this.l.setVisibility(z ? 0 : 8);
        this.m.setVisibility(z ? 0 : 8);
        this.t.setVisibility(z ? 0 : 8);
    }

    private void c() {
        this.v.setVisibility(0);
        this.d.setVisibility(0);
        this.q.setVisibility(0);
        this.p.setVisibility(8);
        this.r.setVisibility(8);
        this.v.setImageDrawable(this.K);
        this.n.setText(this.w);
        this.o.setText(this.x);
        this.u.setText(this.E);
        this.q.setText(this.G);
        a(true, true);
        a(false);
        b(false);
    }

    private void d() {
        this.v.setVisibility(0);
        this.d.setVisibility(0);
        this.q.setVisibility(0);
        this.p.setVisibility(8);
        this.r.setVisibility(8);
        this.v.setImageDrawable(this.K);
        this.l.setText(this.C);
        this.m.setText(this.D);
        this.q.setText(this.G);
        this.t.setChecked(this.J);
        b(true);
        a(false, false);
        a(false);
    }

    private void e() {
        this.v.setVisibility(0);
        this.d.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        this.p.setVisibility(8);
        this.v.setImageDrawable(this.K);
        this.n.setText(this.w);
        this.o.setText(this.x);
        this.q.setText(this.G);
        this.r.getBackground().setAlpha(10);
        this.r.setText(this.H);
        b(false);
        a(true, false);
        a(false);
    }

    private void f() {
        this.v.setVisibility(0);
        this.d.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(8);
        this.p.setVisibility(8);
        this.v.setImageDrawable(this.K);
        this.n.setText(this.w);
        this.o.setText(this.x);
        this.q.setText(this.G);
        b(false);
        a(true, false);
        a(false);
    }

    private void g() {
        this.v.setVisibility(8);
        this.d.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(8);
        b(false);
        a(false, false);
        a(true);
        this.h.setText(this.y);
        this.i.setText(this.z);
        this.j.setText(this.A);
        this.k.setText(this.B);
    }

    private void h() {
        if (this.F != null) {
            this.p.setVisibility(0);
            this.p.setText(this.F);
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.FindSearchMapBottomDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (FindSearchMapBottomDialog.this.L != null) {
                        FindSearchMapBottomDialog.this.L.onClick(FindSearchMapBottomDialog.this, -1);
                    }
                    FindSearchMapBottomDialog.this.dismiss();
                }
            });
        }
    }

    private void i() {
        if (this.G != null) {
            this.q.setVisibility(0);
            this.q.setText(this.G);
            this.q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.FindSearchMapBottomDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (FindSearchMapBottomDialog.this.M != null) {
                        int i = FindSearchMapBottomDialog.this.f30685a;
                        if (i == 0) {
                            ConfirmBtnListener confirmBtnListener = FindSearchMapBottomDialog.this.M;
                            FindSearchMapBottomDialog findSearchMapBottomDialog = FindSearchMapBottomDialog.this;
                            confirmBtnListener.a(findSearchMapBottomDialog, findSearchMapBottomDialog.u.isChecked());
                        } else if (i == 1) {
                            ConfirmBtnListener confirmBtnListener2 = FindSearchMapBottomDialog.this.M;
                            FindSearchMapBottomDialog findSearchMapBottomDialog2 = FindSearchMapBottomDialog.this;
                            confirmBtnListener2.a(findSearchMapBottomDialog2, findSearchMapBottomDialog2.t.isChecked());
                        } else if (i == 2 || i == 3) {
                            FindSearchMapBottomDialog.this.M.a(FindSearchMapBottomDialog.this, false);
                        } else if (i == 4) {
                            ConfirmBtnListener confirmBtnListener3 = FindSearchMapBottomDialog.this.M;
                            FindSearchMapBottomDialog findSearchMapBottomDialog3 = FindSearchMapBottomDialog.this;
                            confirmBtnListener3.a(findSearchMapBottomDialog3, findSearchMapBottomDialog3.s.isChecked());
                        }
                    }
                    FindSearchMapBottomDialog.this.dismiss();
                }
            });
        }
    }

    private void j() {
        if (this.H != null) {
            this.r.setVisibility(0);
            this.r.setText(this.H);
            this.r.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.FindSearchMapBottomDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (FindSearchMapBottomDialog.this.N != null) {
                        FindSearchMapBottomDialog.this.N.onClick(FindSearchMapBottomDialog.this, -1);
                    }
                    FindSearchMapBottomDialog.this.dismiss();
                }
            });
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.O;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        DismissListener dismissListener = this.P;
        if (dismissListener != null) {
            dismissListener.a(this, this.u.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.find_search_map_bottom_dialog);
        Window window = getWindow();
        window.setGravity(80);
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        a();
    }
}
