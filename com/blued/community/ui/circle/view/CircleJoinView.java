package com.blued.community.ui.circle.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/view/CircleJoinView.class */
public class CircleJoinView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f19375a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f19376c;
    private ShapeLinearLayout d;
    private int e;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/view/CircleJoinView$Style.class */
    public @interface Style {
    }

    public CircleJoinView(Context context) {
        super(context);
        this.e = 0;
        this.f19375a = context;
        e();
    }

    public CircleJoinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.f19375a = context;
        e();
    }

    public CircleJoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.f19375a = context;
        e();
    }

    private void e() {
        View inflate = LayoutInflater.from(this.f19375a).inflate(R.layout.view_circle_join, this);
        this.b = inflate;
        this.f19376c = (TextView) inflate.findViewById(R.id.tv_text);
        this.d = (ShapeLinearLayout) this.b.findViewById(R.id.ll_main);
    }

    private void f() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_a_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_a));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_b);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_join);
    }

    private void g() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_k_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_k));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_c);
            ShapeHelper.d(this.d, R.color.transparent);
            this.d.getBackground().setAlpha(100);
            this.f19376c.setTextColor(this.f19375a.getResources().getColor(R.color.syc_dark_b));
        }
        this.f19376c.setText(R.string.circle_joined);
    }

    private void h() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_a_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_a));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_b);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_apply_join);
    }

    private void i() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_k_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_k));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_c);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(this.f19375a.getResources().getColor(R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_applied_join);
    }

    private void j() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_k_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_k));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_c);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(this.f19375a.getResources().getColor(R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_denied);
    }

    public void a() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.syc_dark_x);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_x);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_manager_btn);
    }

    public void b() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_a_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_a));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_b);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_join_circle);
    }

    public void c() {
        if (this.e == 0) {
            ShapeHelper.b(this.d, R.color.transparent);
            ShapeHelper.d(this.d, R.color.syc_a_50);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_a));
        } else {
            ShapeHelper.b(this.d, R.color.syc_dark_b);
            ShapeHelper.d(this.d, R.color.transparent);
            this.f19376c.setTextColor(BluedSkinUtils.a(this.f19375a, R.color.syc_dark_h));
        }
        this.f19376c.setText(R.string.circle_view_circle);
    }

    public boolean d() {
        return TextUtils.equals(this.f19376c.getText().toString(), getContext().getString(R.string.circle_view_circle));
    }

    public void setJoinStatus(CircleJoinState circleJoinState) {
        if (circleJoinState == null) {
            return;
        }
        if (circleJoinState.isJoin()) {
            g();
            return;
        }
        int i = circleJoinState.is_applied;
        if (i == 1) {
            i();
        } else if (i == 2) {
            j();
        } else if (circleJoinState.allow_join == 1) {
            f();
        } else {
            h();
        }
    }

    @Deprecated
    public void setJoinStatusWithMember(MyCircleModel myCircleModel) {
        if (myCircleModel == null) {
            return;
        }
        if (myCircleModel.is_member == 1) {
            g();
            return;
        }
        int i = myCircleModel.is_applied;
        if (i == 1) {
            i();
        } else if (i == 2) {
            j();
        } else if (myCircleModel.allow_join == 1) {
            f();
        } else {
            h();
        }
    }

    public void setStyle(int i) {
        this.e = i;
    }
}
