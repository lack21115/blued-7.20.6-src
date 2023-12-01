package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ExpLvlProgressView.class */
public class ExpLvlProgressView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static int f14719c = 9;

    /* renamed from: a  reason: collision with root package name */
    public Context f14720a;
    public View b;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private TextView j;
    private TextView k;
    private CardView l;
    private CardView m;
    private int n;
    private boolean o;
    private int p;

    public ExpLvlProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 1;
        this.o = true;
        this.p = 0;
        a(context);
    }

    public ExpLvlProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 1;
        this.o = true;
        this.p = 0;
        a(context);
    }

    public void a(Context context) {
        this.f14720a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_exp_progress, this);
        this.b = inflate;
        this.d = inflate.findViewById(R.id.exp_left_line);
        this.e = this.b.findViewById(R.id.exp_middle_line);
        this.f = this.b.findViewById(R.id.exp_right_line);
        this.g = this.b.findViewById(R.id.exp_right_trans_line);
        this.h = this.b.findViewById(R.id.left_level_layout);
        this.i = this.b.findViewById(R.id.right_level_layout);
        this.j = (TextView) this.b.findViewById(R.id.left_level_tv);
        this.l = (CardView) this.b.findViewById(R.id.left_level_circle);
        this.k = (TextView) this.b.findViewById(R.id.right_level_tv);
        this.m = (CardView) this.b.findViewById(R.id.right_level_circle);
    }
}
