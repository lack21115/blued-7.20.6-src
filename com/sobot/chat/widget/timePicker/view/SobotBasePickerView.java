package com.sobot.chat.widget.timePicker.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.timePicker.listener.SobotOnDismissListener;
import com.sobot.chat.widget.timePicker.utils.SobotPickerViewAnimateUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/view/SobotBasePickerView.class */
public class SobotBasePickerView {
    private boolean cancelable;
    protected View clickView;
    protected ViewGroup contentContainer;
    private Context context;
    public ViewGroup decorView;
    private ViewGroup dialogView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private SobotOnDismissListener onDismissListener;
    private Animation outAnim;
    private ViewGroup rootView;
    private final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2, 80);
    protected int pickerview_timebtn_nor = -16417281;
    protected int pickerview_timebtn_pre = -4007179;
    protected int pickerview_bg_topbar = -657931;
    protected int pickerview_topbar_title = -16777216;
    protected int bgColor_default = -1;
    private int gravity = 80;
    private boolean isAnim = true;
    private View.OnKeyListener onKeyBackListener = new View.OnKeyListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && SobotBasePickerView.this.isShowing()) {
                SobotBasePickerView.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SobotBasePickerView.this.dismiss();
                return false;
            }
            return false;
        }
    };

    public SobotBasePickerView(Context context) {
        this.context = context;
    }

    private void onAttached(View view) {
        this.decorView.addView(view);
        if (this.isAnim) {
            this.contentContainer.startAnimation(this.inAnim);
        }
    }

    public void createDialog() {
        if (this.dialogView != null) {
            Context context = this.context;
            Dialog dialog = new Dialog(context, ResourceUtils.getIdByName(context, "style", "sobot_custom_dialog"));
            this.mDialog = dialog;
            dialog.setCancelable(this.cancelable);
            this.mDialog.setContentView(this.dialogView);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(ResourceUtils.getIdByName(this.context, "style", "sobot_pickerview_dialogAnim"));
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (SobotBasePickerView.this.onDismissListener != null) {
                        SobotBasePickerView.this.onDismissListener.onDismiss(SobotBasePickerView.this);
                    }
                }
            });
        }
    }

    public void dismiss() {
        if (isDialog()) {
            dismissDialog();
        } else if (this.dismissing) {
        } else {
            if (this.isAnim) {
                this.outAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        SobotBasePickerView.this.dismissImmediately();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.contentContainer.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.dismissing = true;
        }
    }

    public void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dismissImmediately() {
        this.decorView.post(new Runnable() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.3
            @Override // java.lang.Runnable
            public void run() {
                SobotBasePickerView.this.decorView.removeView(SobotBasePickerView.this.rootView);
                SobotBasePickerView.this.isShowing = false;
                SobotBasePickerView.this.dismissing = false;
                if (SobotBasePickerView.this.onDismissListener != null) {
                    SobotBasePickerView.this.onDismissListener.onDismiss(SobotBasePickerView.this);
                }
            }
        });
    }

    public View findViewById(int i) {
        return this.contentContainer.findViewById(i);
    }

    public Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, SobotPickerViewAnimateUtil.getAnimationResource(this.context, this.gravity, true));
    }

    public Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, SobotPickerViewAnimateUtil.getAnimationResource(this.context, this.gravity, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initEvents() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews(int i) {
        LayoutInflater from = LayoutInflater.from(this.context);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(ResourceUtils.getIdByName(this.context, "layout", "sobot_layout_basepickerview"), (ViewGroup) null, false);
            this.dialogView = viewGroup;
            viewGroup.setBackgroundColor(0);
            this.contentContainer = (ViewGroup) this.dialogView.findViewById(ResourceUtils.getIdByName(this.context, "id", "content_container"));
            this.params.leftMargin = 30;
            this.params.rightMargin = 30;
            this.contentContainer.setLayoutParams(this.params);
            createDialog();
            this.dialogView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.timePicker.view.SobotBasePickerView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    SobotBasePickerView.this.dismiss();
                }
            });
        } else {
            if (this.decorView == null) {
                this.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView().findViewById(16908290);
            }
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResourceUtils.getIdByName(this.context, "layout", "sobot_layout_basepickerview"), this.decorView, false);
            this.rootView = viewGroup2;
            viewGroup2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (i != 0) {
                this.rootView.setBackgroundColor(i);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.rootView.findViewById(ResourceUtils.getIdByName(this.context, "id", "content_container"));
            this.contentContainer = viewGroup3;
            viewGroup3.setLayoutParams(this.params);
        }
        setKeyBackCancelable(true);
    }

    public boolean isDialog() {
        return false;
    }

    public boolean isShowing() {
        boolean z = false;
        if (isDialog()) {
            return false;
        }
        if (this.rootView.getParent() != null || this.isShowing) {
            z = true;
        }
        return z;
    }

    public void setDialogOutSideCancelable(boolean z) {
        this.cancelable = z;
    }

    public void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup = isDialog() ? this.dialogView : this.rootView;
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.onKeyBackListener);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public SobotBasePickerView setOnDismissListener(SobotOnDismissListener sobotOnDismissListener) {
        this.onDismissListener = sobotOnDismissListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SobotBasePickerView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(ResourceUtils.getIdByName(this.context, "id", "outmost_container"));
            if (z) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
                return this;
            }
            findViewById.setOnTouchListener(null);
        }
        return this;
    }

    public void show() {
        if (isDialog()) {
            showDialog();
        } else if (isShowing()) {
        } else {
            this.isShowing = true;
            onAttached(this.rootView);
            this.rootView.requestFocus();
        }
    }

    public void show(View view) {
        this.clickView = view;
        show();
    }

    public void show(View view, boolean z) {
        this.clickView = view;
        this.isAnim = z;
        show();
    }

    public void show(boolean z) {
        this.isAnim = z;
        show();
    }

    public void showDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }
}
