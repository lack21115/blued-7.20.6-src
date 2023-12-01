package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSaleRelationTagView.class */
public class YYSaleRelationTagView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18467a;
    private ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18468c;
    private int d;

    public YYSaleRelationTagView(Context context) {
        super(context);
        this.d = 0;
        a();
    }

    public YYSaleRelationTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        a();
    }

    public YYSaleRelationTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_sale_relation_tag, (ViewGroup) this, true);
        this.f18467a = (TextView) findViewById(R.id.tv_tag_value);
        this.f18468c = (TextView) findViewById(R.id.tv_tag_name);
        this.b = (ImageView) findViewById(R.id.iv_tag_img);
    }

    public int getTagValue() {
        return this.d;
    }

    public void setTagImage(int i) {
        this.b.setImageResource(i);
    }

    public void setTagName(String str) {
        this.f18468c.setText(str);
    }

    public void setTagValue(String str) {
        this.d = StringUtils.a(str, 0);
        this.f18467a.setText(str);
    }
}
