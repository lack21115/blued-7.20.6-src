package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePopUpDialog.class */
public class LivePopUpDialog {
    private static String B = "";
    private int A;
    private View a;
    private View b;
    private Context c;
    private MyPopupWindow d;
    private LayoutInflater e;
    private FrameLayout f;
    private String h;
    private String i;
    private String j;
    private String k;
    private View.OnClickListener l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private EditText u;
    private EditText v;
    private LinearLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;
    private String g = " / ";
    private TextWatcher C = new TextWatcher() { // from class: com.blued.android.module.live_china.view.LivePopUpDialog.1
        private int b;
        private int c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                LivePopUpDialog.this.u.removeTextChangedListener(LivePopUpDialog.this.C);
                this.b = LivePopUpDialog.this.u.getSelectionStart();
                this.c = LivePopUpDialog.this.u.getSelectionEnd();
                while (editable.length() > LivePopUpDialog.this.A) {
                    editable.delete(this.b - 1, this.c);
                    this.b--;
                    this.c--;
                }
                int length = editable.length();
                LivePopUpDialog.this.r.setText(length + BridgeUtil.SPLIT_MARK + LivePopUpDialog.this.A);
                LivePopUpDialog.this.u.setSelection(this.b);
                LivePopUpDialog.this.u.addTextChangedListener(LivePopUpDialog.this.C);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePopUpDialog$MyPopupWindow.class */
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
                LivePopUpDialog.this.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    public LivePopUpDialog(Context context, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View view) {
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.c = context;
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = onClickListener;
        this.b = view;
        c();
    }

    private void a(int i) {
        this.n.setVisibility(i);
        this.m.setVisibility(i);
    }

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        LivePopUpDialog livePopUpDialog = new LivePopUpDialog(context, "", str, context.getResources().getString(R.string.Live_applyHost_IKnow), "", null, null);
        livePopUpDialog.a(8);
        livePopUpDialog.b(0);
        livePopUpDialog.o.setTextColor(context.getResources().getColor(R.color.white));
        livePopUpDialog.y.setBackground(context.getResources().getDrawable(R.drawable.shape_live_warning));
        livePopUpDialog.c(8);
        livePopUpDialog.d(0);
        livePopUpDialog.e(8);
        livePopUpDialog.a(false);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) livePopUpDialog.s.getLayoutParams();
        layoutParams.setMargins(DensityUtils.a(context, 14.0f), 0, DensityUtils.a(context, 14.0f), 0);
        livePopUpDialog.s.setLayoutParams(layoutParams);
        livePopUpDialog.s.setBackgroundColor(context.getResources().getColor(R.color.white));
        livePopUpDialog.q.setTextColor(context.getResources().getColor(R.color.white));
        livePopUpDialog.a.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) livePopUpDialog.y.getLayoutParams();
        layoutParams2.width = DensityUtils.a(context, 333.0f);
        livePopUpDialog.y.setLayoutParams(layoutParams2);
        livePopUpDialog.o.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        livePopUpDialog.a.setBackgroundColor(context.getResources().getColor(R.color.sub_transparent));
        livePopUpDialog.a();
    }

    private void a(boolean z) {
        this.d.setOutsideTouchable(z);
        this.a.setOnClickListener(null);
    }

    private void b(int i) {
        this.o.setVisibility(i);
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.e = from;
        View inflate = from.inflate(R.layout.item_pop_dialog, (ViewGroup) null);
        this.f = (FrameLayout) inflate.findViewById(R.id.ll_main);
        this.a = inflate.findViewById(R.id.tv_bg);
        EditText editText = (EditText) inflate.findViewById(R.id.et_message);
        this.u = editText;
        editText.addTextChangedListener(this.C);
        this.v = (EditText) inflate.findViewById(R.id.et_pw);
        this.w = (LinearLayout) inflate.findViewById(R.id.ll_edit);
        this.y = (LinearLayout) inflate.findViewById(R.id.ll_content);
        this.z = (LinearLayout) inflate.findViewById(R.id.ll_message);
        this.r = (TextView) inflate.findViewById(R.id.tv_input_count);
        this.s = (TextView) inflate.findViewById(R.id.tv_buttons_top_line);
        this.x = (LinearLayout) inflate.findViewById(R.id.ll_bottom_buttons);
        this.t = (TextView) inflate.findViewById(R.id.tv_button_cut);
        this.a.setBackgroundColor(View.MEASURED_STATE_MASK);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePopUpDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LivePopUpDialog.this.b();
            }
        });
        if (this.b != null) {
            inflate.findViewById(R.id.ll_content).setVisibility(8);
            ((LinearLayout.LayoutParams) this.b.getLayoutParams()).gravity = 17;
            this.f.addView(this.b);
        } else {
            this.b = inflate.findViewById(R.id.ll_content);
            this.m = (TextView) inflate.findViewById(R.id.tv_title);
            this.n = (TextView) inflate.findViewById(R.id.tv_title_cutline);
            if (TextUtils.isEmpty(this.h)) {
                this.m.setVisibility(8);
                this.n.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.m.setText(this.h);
                this.n.setVisibility(0);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.tv_message);
            this.o = textView;
            textView.setText(this.i);
            this.p = (TextView) inflate.findViewById(R.id.tv_cancel);
            if (!TextUtils.isEmpty(this.k)) {
                this.p.setText(this.k);
            }
            this.q = (TextView) inflate.findViewById(R.id.tv_ok);
            if (!TextUtils.isEmpty(this.j)) {
                this.q.setText(this.j);
            }
            this.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePopUpDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (LivePopUpDialog.this.l != null) {
                        LivePopUpDialog.this.l.onClick(view);
                    }
                    LivePopUpDialog.this.b();
                }
            });
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePopUpDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LivePopUpDialog.this.b();
                }
            });
        }
        this.b.setBackgroundColor(this.c.getResources().getColor(R.color.window_bg_color));
        this.b.setVisibility(8);
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.d = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.c.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.d.setTouchable(true);
        this.d.setOutsideTouchable(true);
        this.d.setFocusable(true);
        this.d.update();
    }

    private void c(int i) {
        this.w.setVisibility(i);
    }

    private void d(int i) {
        this.s.setVisibility(i);
        this.x.setVisibility(i);
    }

    private void e(int i) {
        this.p.setVisibility(i);
        this.t.setVisibility(i);
    }

    public void a() {
        this.a.clearAnimation();
        this.b.clearAnimation();
        if (this.d.isShowing()) {
            this.d.a();
        }
        this.d.showAtLocation(this.b, 81, 0, 0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.setVisibility(0);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_in));
    }

    public void b() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.setVisibility(8);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.LivePopUpDialog.5
            @Override // java.lang.Runnable
            public void run() {
                LivePopUpDialog.this.d.a();
            }
        }, 320L);
    }
}
