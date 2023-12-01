package com.blued.android.module.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonEdittextView.class */
public class CommonEdittextView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f10969a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeFrameLayout f10970c;
    private ShapeFrameLayout d;
    private TextView e;
    private LinearLayout f;
    private ClearEditText g;

    public CommonEdittextView(Context context) {
        super(context);
        this.b = context;
        a(null);
    }

    public CommonEdittextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a(attributeSet);
    }

    public CommonEdittextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        a(attributeSet);
    }

    public void a() {
        this.f.setPadding(0, 0, 0, 0);
    }

    public void a(AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.view_commont_edittext, this);
        this.f10969a = inflate;
        this.f = (LinearLayout) inflate.findViewById(R.id.root_view);
        this.f10970c = (ShapeFrameLayout) this.f10969a.findViewById(R.id.sfl_areacode);
        this.d = (ShapeFrameLayout) this.f10969a.findViewById(R.id.sfl_input);
        ShapeHelper.b(this.f10970c, R.color.syc_x);
        ShapeHelper.b(this.d, R.color.syc_x);
        this.e = (TextView) this.f10969a.findViewById(R.id.tv_areacode);
        this.g = (ClearEditText) this.f10969a.findViewById(R.id.edittext);
        if (attributeSet != null) {
            TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.CommonEdittextView);
            int resourceId = obtainAttributes.getResourceId(R.styleable.CommonEdittextView_hint_text, -1);
            if (resourceId > 0) {
                setHintText(resourceId);
            }
            setIfShowAreaCode(obtainAttributes.getBoolean(R.styleable.CommonEdittextView_show_areacode, false));
            obtainAttributes.recycle();
        }
    }

    public TextView getAreaCodeText() {
        return this.e;
    }

    public ClearEditText getEditText() {
        return this.g;
    }

    public Editable getText() {
        return this.g.getText();
    }

    public void setAreaCodeClickListener(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setAreaCodeText(String str) {
        this.e.setText(str);
    }

    public void setHintText(int i) {
        this.g.setHint(i);
    }

    public void setIfShowAreaCode(boolean z) {
        if (z) {
            this.f10970c.setVisibility(0);
            this.e.setVisibility(0);
            return;
        }
        this.f10970c.setVisibility(8);
        this.e.setVisibility(8);
    }
}
