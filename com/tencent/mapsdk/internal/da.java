package com.tencent.mapsdk.internal;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/da.class */
public class da {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/da$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Toast f23699a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f23700c;
        private int d;
        private String e;
        private String f;
        private TextView g;
        private TextView h;
        private TextView i;
        private Context j;

        public a(Context context) {
            this.j = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ViewGroup a(Context context, String str, String str2) {
            this.e = str;
            this.f = str2;
            LinearLayout linearLayout = new LinearLayout(context);
            int a2 = z9.a(context, 5);
            int a3 = z9.a(context, 10);
            linearLayout.setPadding(a3, a2, a3, a2);
            linearLayout.setBackgroundColor(Color.DKGRAY);
            linearLayout.setOrientation(1);
            if (!TextUtils.isEmpty(str)) {
                this.h = new TextView(context);
                int a4 = z9.a(context, 5);
                this.h.setPadding(a4, a4, a4, a4);
                this.h.setText(str);
                this.h.setTextColor(-1);
                this.h.setTextSize(2, 18.0f);
                linearLayout.addView(this.h, new ViewGroup.MarginLayoutParams(-1, -2));
            }
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = new TextView(context);
                this.i = textView;
                textView.setId(R.id.message);
                this.i.setText(str2);
                this.i.setTextColor(-1);
                this.i.setTextSize(2, 16.0f);
                int a5 = z9.a(context, 5);
                this.i.setPadding(a5, a5, a5, a5);
                linearLayout.addView(this.i, new ViewGroup.MarginLayoutParams(-1, -2));
            }
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(21);
            TextView textView2 = new TextView(context);
            int a6 = z9.a(context, 5);
            int a7 = z9.a(context, 10);
            textView2.setTextColor(-1);
            textView2.setBackgroundColor(Color.BLUE);
            textView2.setPadding(a7, a6, a7, a6);
            textView2.setVisibility(8);
            this.g = textView2;
            linearLayout2.addView(textView2, new ViewGroup.MarginLayoutParams(-2, -2));
            linearLayout.addView(linearLayout2, new ViewGroup.MarginLayoutParams(-1, -2));
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(Context context, View view, int i) {
            Toast toast = new Toast(context);
            this.f23699a = toast;
            toast.setView(view);
            this.f23699a.setDuration(i);
            this.b = this.f23699a.getGravity();
            return this;
        }

        public a a(int i) {
            this.b = i;
            Toast toast = this.f23699a;
            if (toast != null) {
                toast.setGravity(i, this.f23700c, this.d);
            }
            return this;
        }

        public a a(int i, int i2) {
            this.f23700c = i;
            this.d = i2;
            Toast toast = this.f23699a;
            if (toast != null) {
                toast.setGravity(this.b, i, i2);
            }
            return this;
        }

        public a a(String str) {
            return a(str, 8388611);
        }

        public a a(String str, int i) {
            TextView textView;
            this.f = str;
            if (str != null && (textView = this.i) != null) {
                textView.setText(str);
                this.i.setGravity(i);
            }
            return this;
        }

        public a a(String str, View.OnClickListener onClickListener) {
            if (this.g != null && !TextUtils.isEmpty(str) && onClickListener != null) {
                this.g.setText(str);
                this.g.setOnClickListener(onClickListener);
                this.g.setVisibility(0);
            }
            return this;
        }

        public a a(boolean z) {
            try {
                Object a2 = e7.a(this.f23699a, "mTN");
                if (a2 != null) {
                    Object a3 = e7.a(a2, "mParams");
                    if (a3 instanceof WindowManager.LayoutParams) {
                        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) a3;
                        if (z) {
                            layoutParams.flags = 136;
                            return this;
                        }
                        layoutParams.flags = 152;
                        return this;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public void a() {
            Toast toast = this.f23699a;
            if (toast != null) {
                toast.cancel();
            }
        }

        public a b(String str) {
            TextView textView;
            this.e = str;
            if (str != null && (textView = this.h) != null) {
                textView.setText(str);
            }
            return this;
        }

        public boolean b() {
            Toast toast = this.f23699a;
            if (toast != null) {
                toast.show();
                return true;
            }
            return false;
        }
    }

    public static a a(Context context) {
        return a(context, " ", 0);
    }

    public static a a(Context context, String str) {
        return a(context, str, 0);
    }

    public static a a(Context context, String str, int i) {
        return a(context, null, str, i);
    }

    public static a a(Context context, String str, String str2, int i) {
        if (context == null) {
            return null;
        }
        a aVar = new a(context);
        return aVar.a(context, aVar.a(context, str, str2), i);
    }
}
