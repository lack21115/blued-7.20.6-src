package com.blued.android.module.common.widget.menu;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/VerticalRecyclerView.class */
public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(Context context) {
        this(context, null);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void a() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(BluedSkinUtils.a(getContext(), R.color.syc_o_line));
        gradientDrawable.setSize(AppInfo.l, DensityUtils.a(getContext(), 0.5f));
        dividerItemDecoration.setDrawable(gradientDrawable);
        addItemDecoration(dividerItemDecoration);
    }
}
