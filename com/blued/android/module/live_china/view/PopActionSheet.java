package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopActionSheet.class */
public class PopActionSheet implements View.OnClickListener {
    private MyPopupWindow a;
    private View b;
    private Context c;
    private LayoutInflater d;
    private View e;
    private View f;
    private LinearLayout g;
    private View h;
    private PopSheetClickListner i;
    private int j;
    private List<ActionItem> k = new ArrayList();
    private boolean l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopActionSheet$ActionItem.class */
    public class ActionItem {
        public String a;
        public int b;

        public ActionItem() {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopActionSheet$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopActionSheet.this.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopActionSheet$PopSheetClickListner.class */
    public interface PopSheetClickListner {
        void onClick(int i, String str);
    }

    public PopActionSheet(Context context, String[] strArr, int[] iArr, boolean z, PopSheetClickListner popSheetClickListner) {
        this.c = context;
        this.l = z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                this.i = popSheetClickListner;
                f();
                return;
            }
            ActionItem actionItem = new ActionItem();
            actionItem.a = strArr[i2];
            if (i2 < iArr.length) {
                actionItem.b = iArr[i2];
            } else {
                actionItem.b = 0;
            }
            this.k.add(actionItem);
            i = i2 + 1;
        }
    }

    public static void a(Context context, View view, String[] strArr, int[] iArr, int i, boolean z, PopSheetClickListner popSheetClickListner) {
        PopActionSheet popActionSheet = new PopActionSheet(context, strArr, iArr, z, popSheetClickListner);
        popActionSheet.e = view;
        popActionSheet.a(i);
        popActionSheet.a();
    }

    public static void a(Context context, String[] strArr, int[] iArr, int i, PopSheetClickListner popSheetClickListner) {
        PopActionSheet popActionSheet = new PopActionSheet(context, strArr, iArr, true, popSheetClickListner);
        popActionSheet.a(i);
        popActionSheet.a();
    }

    private void f() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.sheet_pop_center, (ViewGroup) null);
        this.f = inflate;
        this.g = (LinearLayout) inflate.findViewById(R.id.ll_main);
        View findViewById = this.f.findViewById(R.id.btn_cancel);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.f.findViewById(R.id.tv_bg);
        this.b = findViewById2;
        findViewById2.setOnClickListener(this);
        g();
        View view = this.e;
        if (view == null) {
            view = this.f;
        }
        MyPopupWindow myPopupWindow = new MyPopupWindow(view, -1, -1, true);
        this.a = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.c.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.a.setTouchable(true);
        this.a.setOutsideTouchable(true);
        this.a.setFocusable(true);
        this.a.update();
    }

    private void g() {
        List<ActionItem> list = this.k;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.k.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            View inflate = this.d.inflate(R.layout.item_sheet_pop_center, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_text);
            textView.setText(this.k.get(i).a);
            if (this.k.get(i).b != 0) {
                textView.setTextColor(this.c.getResources().getColor(this.k.get(i).b));
            }
            inflate.setId(i);
            if (i != 0 || this.l) {
                inflate.setOnClickListener(this);
            } else {
                textView.setBackground(null);
                inflate.setOnClickListener(null);
            }
            this.g.addView(inflate, 0);
            size = i;
        }
    }

    public void a() {
        this.b.clearAnimation();
        this.f.clearAnimation();
        if (this.a.isShowing()) {
            this.a.a();
        }
        if (this.j > 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.width = this.j;
            this.g.setLayoutParams(layoutParams);
        }
        this.a.showAtLocation(this.f, 17, 0, 0);
        this.f.setVisibility(0);
        d();
    }

    public void a(int i) {
        this.j = i;
    }

    public void b() {
        c();
        this.g.setVisibility(8);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopActionSheet.1
            @Override // java.lang.Runnable
            public void run() {
                PopActionSheet.this.a.a();
            }
        }, 320L);
    }

    public void c() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.g.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
    }

    public void d() {
        this.g.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
    }

    public MyPopupWindow e() {
        return this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.btn_cancel || view.getId() == R.id.tv_bg) {
            b();
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return;
            }
            if (view.getId() == i2) {
                this.i.onClick(i2, this.k.get(i2).a);
                b();
                return;
            }
            i = i2 + 1;
        }
    }
}
