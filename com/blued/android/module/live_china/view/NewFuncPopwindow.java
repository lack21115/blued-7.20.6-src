package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.view.HoleRelativeLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/NewFuncPopwindow.class */
public class NewFuncPopwindow extends PopupWindow {
    private Context a;
    private TextView b;
    private ImageView c;
    private int d;
    private int e;
    private HoleRelativeLayout f;
    private Window g;
    private HoleRelativeLayout.RoundRect h;
    private View i;
    private int j;
    private int k;
    private CountDownTimer l;
    private FuncDismissListener m;
    private int n;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/NewFuncPopwindow$FuncDismissListener.class */
    public interface FuncDismissListener {
        void a();
    }

    public NewFuncPopwindow(Context context, int i, int i2) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.j = (int) (AppInfo.l * 0.6d);
        this.k = 0;
        this.n = 0;
        this.a = context;
        if (i > 0) {
            this.j = i;
        }
        if (i2 > 0) {
            this.k = i2;
        }
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.pop_new_function_layout, (ViewGroup) null);
        this.b = (TextView) inflate.findViewById(R.id.pop_guest_text);
        this.c = (ImageView) inflate.findViewById(R.id.pop_guest_image);
        setContentView(inflate);
        int i = this.j;
        if (i > 0) {
            setWidth(i);
        }
        int i2 = this.k;
        if (i2 > 0) {
            setHeight(i2);
        }
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
    }

    public void a(float f) {
        Logger.d("NewFuncPopwindow", "backgroundAlpha ... bgAlpha = " + f);
        if (this.f == null) {
            this.g = ((Activity) this.a).getWindow();
            this.f = new HoleRelativeLayout(this.a);
            if (this.h == null) {
                HoleRelativeLayout.RoundRect roundRect = new HoleRelativeLayout.RoundRect();
                this.h = roundRect;
                roundRect.d = 50.0f;
                this.h.c = 60.0f;
                this.h.a = this.d;
                this.h.b = this.e;
            }
            this.f.a(this.h);
            this.g.addContentView(this.f, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (f < 1.0f) {
            this.f.setBgColor(this.a.getResources().getColor(R.color.syc_62000000));
            return;
        }
        HoleRelativeLayout holeRelativeLayout = this.f;
        if (holeRelativeLayout == null || holeRelativeLayout.getParent() == null || !(this.f.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f.getParent()).removeView(this.f);
    }

    public void a(int i) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.c.setImageResource(i);
        }
    }

    public void a(long j) {
        this.l = new CountDownTimer(j, 1000L) { // from class: com.blued.android.module.live_china.view.NewFuncPopwindow.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                Logger.d("NewFuncPopwindow", "onFinish ... ");
                NewFuncPopwindow.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
            }
        };
    }

    public void a(View view, int i, int i2) {
        Context context = this.a;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !((Activity) this.a).isDestroyed()) {
            this.d = i;
            this.e = i2;
            Logger.d("NewFuncPopwindow", "show ... offsetX: " + i + " ; offsetY: " + i2);
            getContentView().measure(0, 0);
            int measuredHeight = getContentView().getMeasuredHeight();
            int measuredWidth = getContentView().getMeasuredWidth();
            Logger.d("NewFuncPopwindow", "show ... width: " + measuredWidth + " ; height：" + measuredHeight);
            int i3 = measuredWidth + i;
            StringBuilder sb = new StringBuilder();
            sb.append("show ... totalLength: ");
            sb.append(i3);
            Logger.d("NewFuncPopwindow", sb.toString());
            int i4 = i;
            if (i3 > AppInfo.l) {
                i4 = i - (i3 - AppInfo.l);
                Logger.d("NewFuncPopwindow", "show ... (moveX + width) > 屏幕宽度 --> screen width: " + AppInfo.l);
            }
            int a = (i2 - measuredHeight) - DensityUtils.a(this.a, 7.0f);
            Logger.d("NewFuncPopwindow", "show ... moveX: " + i4 + " ; moveY：" + a);
            showAtLocation(view, 0, i4 - this.n, a);
        }
    }

    public void a(HoleRelativeLayout.RoundRect roundRect) {
        this.h = roundRect;
    }

    public void a(FuncDismissListener funcDismissListener) {
        this.m = funcDismissListener;
    }

    public void b(int i) {
        this.n = i;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Logger.d("NewFuncPopwindow", "dismiss ... ");
        a(1.0f);
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        FuncDismissListener funcDismissListener = this.m;
        if (funcDismissListener != null) {
            funcDismissListener.a();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        Logger.d("NewFuncPopwindow", "showAtLocation ... ");
        a(0.3f);
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }
}
