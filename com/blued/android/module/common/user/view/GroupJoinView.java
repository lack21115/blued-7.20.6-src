package com.blued.android.module.common.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.R;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/view/GroupJoinView.class */
public class GroupJoinView extends LinearLayout {
    public Context a;
    public View b;
    private boolean c;
    private ImageView d;
    private TextView e;
    private ShapeLinearLayout f;

    public GroupJoinView(Context context) {
        super(context);
        this.a = context;
        b();
    }

    public GroupJoinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        b();
    }

    public GroupJoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        b();
    }

    private void b() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.view_group_join, (ViewGroup) null);
        this.b = inflate;
        this.d = (ImageView) inflate.findViewById(R.id.img_icon);
        this.e = (TextView) this.b.findViewById(R.id.tv_text);
        this.f = (ShapeLinearLayout) this.b.findViewById(R.id.ll_main);
        addView(this.b, new RelativeLayout.LayoutParams(-2, -1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = DensityUtil.a(18.0f);
        layoutParams.height = DensityUtil.a(18.0f);
        this.d.setLayoutParams(layoutParams);
    }

    public void a() {
        this.c = false;
        ShapeHelper.b(this.f, R.color.syc_dark_b);
        this.e.setTextColor(BluedSkinUtils.a(this.a, R.color.syc_a));
        this.d.setImageResource(R.drawable.icon_circle_group);
    }

    public void setIconVisibility(int i) {
        this.d.setVisibility(i);
    }

    public void setStrokeColor(int i) {
        ShapeHelper.d(this.f, i);
    }

    public void setText(String str) {
        this.e.setText(str);
    }

    public void setTextSize(float f) {
        this.e.setTextSize(f);
    }
}
