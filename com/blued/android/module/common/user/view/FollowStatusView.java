package com.blued.android.module.common.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/view/FollowStatusView.class */
public class FollowStatusView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f10857a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f10858c;
    private TextView d;
    private ShapeLinearLayout e;

    public FollowStatusView(Context context) {
        super(context);
        this.f10857a = context;
        a();
    }

    public FollowStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10857a = context;
        a();
    }

    public FollowStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10857a = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.f10857a);
        this.f10858c = from;
        View inflate = from.inflate(R.layout.view_follow_status, this);
        this.b = inflate;
        this.d = (TextView) inflate.findViewById(R.id.tv_text);
        this.e = (ShapeLinearLayout) this.b.findViewById(R.id.ll_main);
        if (isInEditMode()) {
            return;
        }
        ShapeHelper.b(this.e, R.color.syc_b);
    }

    private void b() {
        ShapeHelper.d(this.e, R.color.syc_a_50);
        this.d.setTextColor(BluedSkinUtils.a(this.f10857a, R.color.syc_a));
        this.d.setText(R.string.attention);
    }

    private void c() {
        ShapeHelper.d(this.e, R.color.syc_a_50);
        this.d.setTextColor(BluedSkinUtils.a(this.f10857a, R.color.syc_a));
        this.d.setText(R.string.being_followed);
    }

    private void d() {
        ShapeHelper.d(this.e, R.color.syc_k_50);
        this.d.setTextColor(BluedSkinUtils.a(this.f10857a, R.color.syc_k));
        this.d.setText(R.string.followed);
    }

    private void e() {
        ShapeHelper.d(this.e, R.color.syc_k_50);
        this.d.setTextColor(BluedSkinUtils.a(this.f10857a, R.color.syc_k));
        this.d.setText(R.string.follow_eachother);
    }

    public void setRelationShip(String str) {
        if ("1".equalsIgnoreCase(str)) {
            d();
        } else if ("3".equalsIgnoreCase(str)) {
            e();
        } else if ("2".equalsIgnoreCase(str)) {
            c();
        } else {
            b();
        }
    }

    public void setRelationShipForPhoto(String str) {
        if ("1".equalsIgnoreCase(str)) {
            d();
        } else if ("3".equalsIgnoreCase(str)) {
            e();
        } else if ("2".equalsIgnoreCase(str)) {
            c();
        } else {
            b();
        }
    }

    public void setSolidColor(int i) {
        ShapeHelper.b(this.e, i);
    }

    public void setText(int i) {
        this.d.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }
}
