package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.utils.toast.config.IToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/BlackToastStyle.class */
public class BlackToastStyle implements IToastStyle<TextView> {
    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public /* synthetic */ int a() {
        return IToastStyle.CC.$default$a(this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public /* synthetic */ float b() {
        return IToastStyle.CC.$default$b(this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public /* synthetic */ int b(Context context) {
        return IToastStyle.CC.$default$b(this, context);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public /* synthetic */ float c() {
        return IToastStyle.CC.$default$c(this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public /* synthetic */ int c(Context context) {
        return IToastStyle.CC.$default$c(this, context);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    /* renamed from: d */
    public TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setId(16908299);
        textView.setGravity(e(context));
        textView.setTextColor(f(context));
        textView.setTextSize(0, g(context));
        int h = h(context);
        int i = i(context);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setPaddingRelative(h, i, h, i);
        } else {
            textView.setPadding(h, i, h, i);
        }
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        Drawable j = j(context);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(j);
        } else {
            textView.setBackgroundDrawable(j);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            textView.setZ(k(context));
        }
        return textView;
    }

    protected int e(Context context) {
        return 17;
    }

    protected int f(Context context) {
        return -285212673;
    }

    protected float g(Context context) {
        return StyleUtils.b(context, 14.0f);
    }

    protected int h(Context context) {
        return (int) StyleUtils.a(context, 24.0f);
    }

    protected int i(Context context) {
        return (int) StyleUtils.a(context, 16.0f);
    }

    protected Drawable j(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-2013265920);
        gradientDrawable.setCornerRadius(StyleUtils.a(context, 10.0f));
        return gradientDrawable;
    }

    protected float k(Context context) {
        return StyleUtils.a(context, 3.0f);
    }
}
