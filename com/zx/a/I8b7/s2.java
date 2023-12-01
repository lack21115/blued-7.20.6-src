package com.zx.a.I8b7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/s2.class */
public class s2 extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f28505a;
    public View.OnClickListener b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f28506c;

    public s2(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Context context = getContext();
        getWindow().setGravity(80);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, n.a(context, 30.0f), 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable.setCornerRadius(n.a(context, 8.0f));
        linearLayout.setBackground(gradientDrawable);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(n.a(context, 16.0f), 0, n.a(context, 16.0f), 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#FF111111"));
        textView.setTextSize(2, 18.0f);
        textView.setText("是否允许\"" + d3.a(context) + "\"获取此设备的反欺诈匿名可变ID?");
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        textView2.setLayoutParams(layoutParams2);
        int a2 = n.a(context, 12.0f);
        textView2.setPadding(a2, a2, a2, a2);
        textView2.setTextColor(Color.parseColor("#FF111111"));
        textView2.setTextSize(2, 18.0f);
        textView2.setText("了解更多");
        linearLayout2.addView(textView);
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
        TextView textView3 = new TextView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        textView3.setLayoutParams(layoutParams3);
        layoutParams3.gravity = 1;
        textView3.setTextColor(Color.parseColor("#FF111111"));
        textView3.setTextSize(2, 18.0f);
        int a3 = n.a(context, 10.0f);
        textView3.setPadding(a3, a3, a3, a3);
        textView3.setText("允许");
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        textView4.setLayoutParams(layoutParams4);
        layoutParams4.gravity = 1;
        int a4 = n.a(context, 12.0f);
        layoutParams4.setMargins(0, a4, 0, a4);
        textView4.setTextColor(Color.parseColor("#FF111111"));
        textView4.setTextSize(2, 18.0f);
        int a5 = n.a(context, 10.0f);
        textView4.setPadding(a5, a5, a5, a5);
        textView4.setText("拒绝");
        linearLayout.addView(textView3);
        linearLayout.addView(textView4);
        setContentView(linearLayout);
        textView4.setOnClickListener(this.f28505a);
        textView3.setOnClickListener(this.b);
        textView2.setOnClickListener(this.f28506c);
        setCancelable(false);
    }
}
