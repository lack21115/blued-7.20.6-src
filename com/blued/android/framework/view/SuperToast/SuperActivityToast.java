package com.blued.android.framework.view.SuperToast;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.blued.android.framework.R;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/SuperActivityToast.class */
public class SuperActivityToast extends SuperToast {

    /* renamed from: a  reason: collision with root package name */
    private Context f10191a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f10192c;
    private Style d;
    private boolean e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/SuperActivityToast$OnButtonClickListener.class */
    public interface OnButtonClickListener {
        void a();
    }

    public SuperActivityToast(Context context) {
        super(context, 2);
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
        }
        this.f10191a = context;
        this.d = j();
        this.f10192c = (ViewGroup) ((Activity) context).findViewById(16908290);
    }

    public SuperActivityToast(Context context, Style style) {
        super(context, style, 2);
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
        }
        this.f10191a = context;
        this.d = style;
        this.f10192c = (ViewGroup) ((Activity) context).findViewById(16908290);
    }

    public static void a(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (Build.VERSION.SDK_INT == 28 && g()) {
            bundle.setClassLoader(Style.class.getClassLoader());
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("0x532e412e542e");
        if (parcelableArrayList == null) {
            Log.e(SuperActivityToast.class.getName(), "Cannot recreate SuperActivityToasts onRestoreState(). Was onSaveState() called?");
            return;
        }
        boolean z = true;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Style style = (Style) it.next();
            if (!style.p) {
                new SuperToast(context, style).n();
            } else if (z) {
                new SuperActivityToast(context, style).a().n();
            } else {
                new SuperActivityToast(context, style).n();
            }
            z = false;
        }
    }

    public static void a(Bundle bundle) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<SuperToast> it = Toaster.a().c().iterator();
        while (it.hasNext()) {
            SuperToast next = it.next();
            if (next instanceof SuperActivityToast) {
                next.j().p = true;
            }
            arrayList.add(next.j());
        }
        bundle.putParcelableArrayList("0x532e412e542e", arrayList);
        Toaster.a().b();
    }

    public static boolean g() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2 == null || !str2.toLowerCase().contains("rmx")) {
            return str != null && str.toLowerCase().contains("realme");
        }
        return true;
    }

    public View a(Context context, LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.supertoast_button, (ViewGroup) ((Activity) context).findViewById(16908290), false);
    }

    @Override // com.blued.android.framework.view.SuperToast.SuperToast
    protected View a(Context context, LayoutInflater layoutInflater, int i) {
        if (context instanceof Activity) {
            View a2 = a(context, layoutInflater);
            this.b = a2;
            return a2;
        }
        throw new IllegalArgumentException("SuperActivityToast Context must be an Activity.");
    }

    protected SuperActivityToast a() {
        this.e = true;
        return this;
    }

    public void a(int i, int i2, int i3) {
        if (this.d.e != 3) {
            this.d.j = -1;
            this.d.h = BackgroundUtils.b(i);
            this.d.i = BackgroundUtils.b(i2);
        }
        if ((this.f10191a.getResources().getConfiguration().screenLayout & 15) >= 3) {
            this.d.j = BackgroundUtils.b(i3);
            this.d.g = BadgeDrawable.TOP_START;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.d.x;
    }

    public ViewGroup d() {
        return this.f10192c;
    }

    public void e() {
        Button button = (Button) this.b.findViewById(R.id.button);
        button.setBackgroundResource(BackgroundUtils.a(this.d.e));
        button.setText(this.d.z != null ? this.d.z.toUpperCase() : "");
        button.setTypeface(button.getTypeface(), this.d.A);
        button.setTextColor(this.d.B);
        button.setTextSize(this.d.C);
        if (this.d.e != 3) {
            this.b.findViewById(R.id.divider).setBackgroundColor(this.d.D);
            if (this.d.E > 0) {
                button.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(this.f10191a.getResources(), this.d.E, this.f10191a.getTheme()), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.view.SuperToast.SuperToast
    public void f() {
        super.f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.d.j, this.d.k);
        a(24, 24, 568);
        e();
        layoutParams.width = this.d.j;
        layoutParams.height = this.d.k;
        layoutParams.gravity = this.d.g;
        layoutParams.bottomMargin = this.d.i;
        layoutParams.topMargin = this.d.i;
        layoutParams.leftMargin = this.d.h;
        layoutParams.rightMargin = this.d.h;
        this.b.setLayoutParams(layoutParams);
        if (this.d.y) {
            this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.framework.view.SuperToast.SuperActivityToast.1

                /* renamed from: a  reason: collision with root package name */
                int f10193a;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.f10193a == 0 && motionEvent.getAction() == 0) {
                        SuperActivityToast.this.o();
                    }
                    this.f10193a++;
                    return false;
                }
            });
        } else {
            this.b.setOnTouchListener(null);
        }
    }

    public int getType() {
        return this.d.w;
    }
}
