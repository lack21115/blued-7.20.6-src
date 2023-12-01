package com.blued.android.module.live.base.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.blued.android.module.common.view.LifecycleDialog;
import com.blued.android.module.res_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveAlterDialog.class */
public class LiveAlterDialog {

    /* renamed from: com.blued.android.module.live.base.utils.LiveAlterDialog$5  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveAlterDialog$5.class */
    class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ LifecycleDialog a;
        final /* synthetic */ View.OnClickListener b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.cancel();
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.a.cancel();
        }
    }

    /* renamed from: com.blued.android.module.live.base.utils.LiveAlterDialog$6  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveAlterDialog$6.class */
    class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ LifecycleDialog a;
        final /* synthetic */ View.OnClickListener b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.cancel();
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public static Dialog a(Context context, int i, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2, boolean z, boolean z2) {
        View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        final LifecycleDialog lifecycleDialog = new LifecycleDialog(context);
        lifecycleDialog.setContentView(inflate);
        lifecycleDialog.setCanceledOnTouchOutside(z2);
        Window window = lifecycleDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.clearFlags(131072);
        lifecycleDialog.show();
        if (inflate.findViewById(R.id.tv_ok) != null) {
            inflate.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    View.OnClickListener onClickListener3 = View.OnClickListener.this;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view);
                    }
                    lifecycleDialog.cancel();
                }
            });
        }
        if (inflate.findViewById(R.id.close) != null) {
            inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    View.OnClickListener onClickListener3 = View.OnClickListener.this;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view);
                    }
                    lifecycleDialog.cancel();
                }
            });
        }
        return lifecycleDialog;
    }

    public static Dialog a(Context context, View view, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2, boolean z, boolean z2) {
        View view2 = view;
        if (view == null) {
            view2 = new View(context);
        }
        final LifecycleDialog lifecycleDialog = new LifecycleDialog(context);
        lifecycleDialog.setContentView(view2);
        lifecycleDialog.setCanceledOnTouchOutside(z2);
        Window window = lifecycleDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.clearFlags(131072);
        lifecycleDialog.show();
        if (view2.findViewById(R.id.tv_ok) != null) {
            view2.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    View.OnClickListener onClickListener3 = View.OnClickListener.this;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view3);
                    }
                    lifecycleDialog.cancel();
                }
            });
        }
        if (view2.findViewById(R.id.close) != null) {
            view2.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    View.OnClickListener onClickListener3 = View.OnClickListener.this;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view3);
                    }
                    lifecycleDialog.cancel();
                }
            });
        }
        return lifecycleDialog;
    }

    public static Dialog b(Context context, View view, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2, boolean z, boolean z2) {
        View view2 = view;
        if (view == null) {
            view2 = new View(context);
        }
        final LifecycleDialog lifecycleDialog = new LifecycleDialog(context);
        lifecycleDialog.setContentView(view2);
        lifecycleDialog.setCanceledOnTouchOutside(z2);
        Window window = lifecycleDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.clearFlags(131072);
        lifecycleDialog.show();
        if (view2.findViewById(R.id.tv_ok) != null) {
            view2.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    LifecycleDialog.this.cancel();
                    View.OnClickListener onClickListener3 = onClickListener2;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view3);
                    }
                }
            });
        }
        if (view2.findViewById(R.id.close) != null) {
            view2.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.utils.LiveAlterDialog.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    LifecycleDialog.this.cancel();
                    View.OnClickListener onClickListener3 = onClickListener;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view3);
                    }
                }
            });
        }
        return lifecycleDialog;
    }
}
