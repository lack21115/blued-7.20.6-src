package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNoDataView.class */
public class YYNoDataView extends FrameLayout {
    private ImageView a;
    private TextView b;
    private FrameLayout c;

    public YYNoDataView(Context context) {
        super(context);
        a();
    }

    public YYNoDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYNoDataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_nodata, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.img_nodata);
        this.b = (TextView) findViewById(R.id.tv_nodata);
        this.c = (FrameLayout) findViewById(R.id.fl_root_view);
    }

    public void setNoDataColor(int i) {
        this.b.setTextColor(getContext().getResources().getColor(i));
    }

    public void setNoDataImg(int i) {
        this.a.setImageResource(i);
    }

    public void setNoDataStr(int i) {
        this.b.setText(getContext().getResources().getString(i));
    }

    public void setRootViewBackground(int i) {
        this.c.setBackgroundColor(BluedSkinUtils.a(getContext(), i));
    }
}
