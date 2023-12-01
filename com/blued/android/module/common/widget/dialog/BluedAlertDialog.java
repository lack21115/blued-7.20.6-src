package com.blued.android.module.common.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog.class */
public class BluedAlertDialog extends Dialog {
    private static final int[] c = {R.drawable.selector_blued_dialog_blue_solid_btn_bg, R.drawable.selector_blued_dialog_blue_hollow_btn_bg, R.drawable.selector_blued_dialog_gary_hollow_btn_bg, 0};
    private static final int[][] d = {new int[]{-16842919}, new int[]{com.android.internal.R.attr.state_pressed}};
    private static final int[][] e = {new int[]{-1, -1}, new int[]{-13264385, -12094209}, new int[]{-5921102, -8814195}, new int[]{-5921102, -5921102}};
    private CharSequence A;
    private CharSequence B;
    private CharSequence C;
    private CharSequence D;
    private int E;
    private int F;
    private int G;
    private int H;
    private DialogInterface.OnClickListener I;
    private DialogInterface.OnClickListener J;
    private DialogInterface.OnCancelListener K;
    private DialogInterface.OnDismissListener L;
    private RecyclerView.Adapter M;
    private DialogInterface.OnClickListener N;
    private int O;
    private int P;
    private int Q;
    private int[] R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int a;
    private List<String> b;
    private Context f;
    private CardView g;
    private LinearLayout h;
    private ImageView i;
    private ImageView j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private View n;
    private LinearLayout o;
    private TextView p;
    private View q;
    private TextView r;
    private LinearLayout s;
    private TextView t;
    private TextView u;
    private RecyclerView v;
    private FrameLayout w;
    private View x;
    private int y;
    private boolean z;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$Builder.class */
    public static class Builder {
        private final BluedAlertDialog a;
        private int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;

        public Builder(Context context) {
            this.a = new BluedAlertDialog(context);
        }

        public Builder a(int i) {
            this.a.a = i;
            this.e = true;
            return this;
        }

        public Builder a(int i, DialogInterface.OnClickListener onClickListener) {
            if (i == 0) {
                return this;
            }
            a(this.a.f.getString(i), onClickListener);
            return this;
        }

        public Builder a(DialogInterface.OnDismissListener onDismissListener) {
            this.a.L = onDismissListener;
            return this;
        }

        public Builder a(View view) {
            this.a.x = view;
            return this;
        }

        public Builder a(CharSequence charSequence) {
            if (charSequence != null) {
                if (TextUtils.isEmpty(charSequence.toString())) {
                    return this;
                }
                this.a.A = charSequence.toString();
            }
            return this;
        }

        public Builder a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (charSequence == null) {
                return this;
            }
            this.a.C = charSequence;
            this.a.I = onClickListener;
            return this;
        }

        public Builder a(boolean z) {
            this.a.z = z;
            this.d = true;
            return this;
        }

        public BluedAlertDialog a() {
            if (!this.e && this.c) {
                this.a.a = 1;
            }
            if (!this.f) {
                this.b = 1;
            }
            if (!this.d && this.c) {
                this.a.z = true;
            }
            if (this.a.a != 1) {
                this.a.T = true;
                if (!this.g) {
                    this.a.U = true;
                }
                BluedAlertDialog bluedAlertDialog = this.a;
                bluedAlertDialog.O = DensityUtils.a(bluedAlertDialog.f, 10.0f);
            } else {
                this.a.T = false;
                if (!this.g) {
                    this.a.U = false;
                }
                this.a.Q = BluedAlertDialog.c[this.b];
                this.a.R = BluedAlertDialog.e[this.b];
                BluedAlertDialog bluedAlertDialog2 = this.a;
                bluedAlertDialog2.P = DensityUtils.a(bluedAlertDialog2.f, 20.0f);
                if (this.b == 3) {
                    BluedAlertDialog bluedAlertDialog3 = this.a;
                    bluedAlertDialog3.S = DensityUtils.a(bluedAlertDialog3.f, 25.0f);
                }
            }
            if (!this.g && this.a.z) {
                BluedAlertDialog bluedAlertDialog4 = this.a;
                bluedAlertDialog4.O = DensityUtils.a(bluedAlertDialog4.f, 0.0f);
            }
            return this.a;
        }

        public Builder b() {
            this.a.V = true;
            return this;
        }

        public Builder b(int i) {
            this.b = i;
            this.f = true;
            return this;
        }

        public Builder b(int i, DialogInterface.OnClickListener onClickListener) {
            if (i == 0) {
                return this;
            }
            b(this.a.f.getString(i), onClickListener);
            return this;
        }

        public Builder b(CharSequence charSequence) {
            if (charSequence == null) {
                return this;
            }
            this.a.B = charSequence;
            return this;
        }

        public Builder b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            if (charSequence == null) {
                return this;
            }
            this.a.D = charSequence;
            this.a.J = onClickListener;
            return this;
        }

        public Builder b(boolean z) {
            this.g = true;
            this.a.U = z;
            return this;
        }

        public Builder c(int i) {
            if (i == 0) {
                return this;
            }
            this.c = true;
            this.a.y = i;
            return this;
        }

        public Builder d(int i) {
            return i == 0 ? this : a(this.a.f.getString(i));
        }

        public Builder e(int i) {
            return i == 0 ? this : b(this.a.f.getString(i));
        }

        public Builder f(int i) {
            if (i == 0) {
                return this;
            }
            this.a.E = i;
            return this;
        }

        public Builder g(int i) {
            if (i == 0) {
                return this;
            }
            this.a.F = i;
            return this;
        }

        public Builder h(int i) {
            if (i == 0) {
                return this;
            }
            this.a.H = i;
            return this;
        }

        public Builder i(int i) {
            if (i == 0) {
                return this;
            }
            this.a.G = i;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$DIALOG_DETAILED_BUTTON_TYPE.class */
    public interface DIALOG_DETAILED_BUTTON_TYPE {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$DIALOG_TYPE.class */
    public interface DIALOG_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$DialogDetailedButtonTypeDef.class */
    public @interface DialogDetailedButtonTypeDef {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$DialogTypeDef.class */
    public @interface DialogTypeDef {
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$SimpleAdapter.class */
    public static class SimpleAdapter extends RecyclerView.Adapter<SimpleHolder> {
        private List<String> a;
        private DialogInterface.OnClickListener b;

        public SimpleAdapter(List<String> list, DialogInterface.OnClickListener onClickListener) {
            this.a = list;
            this.b = onClickListener;
        }

        /* renamed from: a */
        public SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SimpleHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_blued_alert_dialog, (ViewGroup) null));
        }

        /* renamed from: a */
        public void onBindViewHolder(SimpleHolder simpleHolder, int i) {
            simpleHolder.a.setText(this.a.get(i));
            simpleHolder.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.SimpleAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    DialogInterface.OnClickListener unused = SimpleAdapter.this.b;
                }
            });
        }

        public int getItemCount() {
            List<String> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/BluedAlertDialog$SimpleHolder.class */
    public static class SimpleHolder extends RecyclerView.ViewHolder {
        private TextView a;

        public SimpleHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_item);
        }
    }

    private BluedAlertDialog(Context context) {
        super(context);
        this.T = true;
        this.U = false;
        this.V = false;
        this.f = context;
    }

    private void A() {
        int i = this.S;
        if (i != 0) {
            this.u.setHeight(i);
        }
    }

    private void a(int i, int i2) {
        this.h.setPadding(0, i, 0, i2);
    }

    private void k() {
        this.g = findViewById(R.id.ll_root);
        this.h = (LinearLayout) findViewById(R.id.ll_dialog);
        this.i = (ImageView) findViewById(R.id.iv_pic);
        this.j = (ImageView) findViewById(R.id.iv_close);
        this.k = (LinearLayout) findViewById(R.id.ll_content);
        this.l = (TextView) findViewById(R.id.tv_title);
        this.m = (TextView) findViewById(R.id.tv_content);
        this.l.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.m.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.n = findViewById(R.id.line_top_view);
        this.o = (LinearLayout) findViewById(R.id.ll_button_ordinary);
        this.p = (TextView) findViewById(R.id.tv_negative_ordinary);
        this.q = findViewById(R.id.line_center_view);
        this.r = (TextView) findViewById(R.id.tv_positive_ordinary);
        this.s = (LinearLayout) findViewById(R.id.ll_button_detailed);
        this.t = (TextView) findViewById(R.id.tv_positive_detailed);
        this.u = (TextView) findViewById(R.id.tv_negative_detailed);
        this.v = findViewById(R.id.dialog_list_view);
        this.w = (FrameLayout) findViewById(R.id.ll_custom);
        l();
    }

    private void l() {
        setCancelable(this.U);
        m();
        n();
        o();
        p();
        q();
        int i = this.a;
        if (i == 0) {
            this.v.setVisibility(8);
            this.h.setVisibility(0);
            r();
            t();
            u();
            v();
        } else if (i == 1) {
            this.v.setVisibility(8);
            this.h.setVisibility(0);
            s();
            w();
            x();
            y();
            z();
            A();
        } else if (i == 2) {
            this.v.setVisibility(0);
            this.h.setVisibility(8);
            RecyclerView.Adapter adapter = this.M;
            if (adapter != null) {
                this.v.setAdapter(adapter);
            } else {
                this.v.setAdapter(new SimpleAdapter(this.b, this.N));
            }
        } else if (i == 3) {
            if (this.x == null) {
                return;
            }
            this.v.setVisibility(8);
            this.h.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.w.setVisibility(0);
            this.w.addView(this.x);
            r();
            t();
            u();
            v();
        }
        a(this.O, this.P);
    }

    private void m() {
        ImageView imageView = this.i;
        if (imageView == null) {
            return;
        }
        int i = this.y;
        if (i == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setImageResource(i);
        this.i.setVisibility(0);
    }

    private void n() {
        if (!this.z) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedAlertDialog.this.cancel();
            }
        });
    }

    private void o() {
        if (this.A == null) {
            this.l.setVisibility(8);
            return;
        }
        this.l.setVisibility(0);
        this.l.setText(this.A);
    }

    private void p() {
        if (this.B == null) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.m.setText(this.B);
    }

    private void q() {
        if (this.V) {
            int color = this.f.getResources().getColor(R.color.white);
            this.g.setCardBackgroundColor(color);
            this.h.setBackgroundColor(color);
            this.k.setBackgroundColor(color);
            this.p.setBackgroundColor(color);
            this.r.setBackgroundColor(color);
            this.l.setTextColor(this.f.getResources().getColor(R.color.syc_dark_h));
            this.m.setTextColor(this.f.getResources().getColor(R.color.syc_dark_j));
            int color2 = this.f.getResources().getColor(R.color.syc_dark_o);
            this.n.setBackgroundColor(color2);
            this.q.setBackgroundColor(color2);
        }
    }

    private void r() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.s.setVisibility(8);
    }

    private void s() {
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.s.setVisibility(0);
    }

    private void t() {
        if (this.C == null) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        int i = this.G;
        if (i != 0) {
            this.r.setTextColor(i);
        } else {
            int i2 = this.E;
            if (i2 != 0) {
                this.r.setTextColor(BluedSkinUtils.a(this.f, i2));
            }
        }
        this.r.setText(this.C);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedAlertDialog.this.I != null) {
                    BluedAlertDialog.this.I.onClick(BluedAlertDialog.this, -1);
                }
                BluedAlertDialog.this.dismiss();
            }
        });
    }

    private void u() {
        if (this.D == null) {
            this.p.setVisibility(8);
            return;
        }
        this.p.setVisibility(0);
        this.p.setText(this.D);
        int i = this.H;
        if (i != 0) {
            this.p.setTextColor(i);
        } else {
            int i2 = this.F;
            if (i2 != 0) {
                this.p.setTextColor(BluedSkinUtils.a(this.f, i2));
            }
        }
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedAlertDialog.this.J != null) {
                    BluedAlertDialog.this.J.onClick(BluedAlertDialog.this, -2);
                }
                BluedAlertDialog.this.dismiss();
            }
        });
    }

    private void v() {
        if (this.C == null || this.D == null) {
            this.q.setVisibility(8);
            if (this.C != null && this.G == 0 && this.E == 0) {
                this.r.setTextColor(BluedSkinUtils.a(this.f, R.color.syc_h));
            }
            if (this.D != null && this.H == 0 && this.F == 0) {
                this.p.setTextColor(BluedSkinUtils.a(this.f, R.color.syc_h));
            }
        }
    }

    private void w() {
        if (this.C == null) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        this.t.setText(this.C);
        int i = this.G;
        if (i != 0) {
            this.t.setTextColor(i);
        } else {
            int i2 = this.E;
            if (i2 != 0) {
                this.t.setTextColor(BluedSkinUtils.a(this.f, i2));
            }
        }
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedAlertDialog.this.I != null) {
                    BluedAlertDialog.this.I.onClick(BluedAlertDialog.this, -1);
                }
                BluedAlertDialog.this.dismiss();
            }
        });
    }

    private void x() {
        if (this.D == null) {
            this.u.setVisibility(8);
            return;
        }
        this.u.setVisibility(0);
        this.u.setText(this.D);
        int i = this.H;
        if (i != 0) {
            this.u.setTextColor(i);
        } else {
            int i2 = this.F;
            if (i2 != 0) {
                this.u.setTextColor(BluedSkinUtils.a(this.f, i2));
            }
        }
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.BluedAlertDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (BluedAlertDialog.this.J != null) {
                    BluedAlertDialog.this.J.onClick(BluedAlertDialog.this, -2);
                }
                BluedAlertDialog.this.dismiss();
            }
        });
    }

    private void y() {
        this.u.setBackgroundResource(this.Q);
    }

    private void z() {
        this.u.setTextColor(new ColorStateList(d, this.R));
    }

    public ViewGroup a() {
        return this.w;
    }

    public void a(float f) {
        ImageView imageView;
        if (this.y == 0 || (imageView = this.i) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = DensityUtils.a(this.f, f);
        this.i.setLayoutParams(layoutParams);
    }

    public void a(int i) {
        ImageView imageView;
        if (!this.z || (imageView = this.j) == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void a(boolean z) {
        this.z = z;
        n();
    }

    public TextView b() {
        return this.l;
    }

    public TextView c() {
        return this.m;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        DialogInterface.OnCancelListener onCancelListener = this.K;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    public TextView d() {
        return this.u;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.L;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public TextView e() {
        return this.p;
    }

    public TextView f() {
        return this.r;
    }

    public View g() {
        return this.j;
    }

    public TextView h() {
        return this.m;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.dialog_blued_alert);
        k();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(com.android.internal.R.color.transparent);
        }
    }
}
