package com.sobot.chat.widget.dialog.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/base/SobotActionSheet.class */
public abstract class SobotActionSheet extends Dialog {
    protected DialogOnClickListener listener;
    private final int screenHeight;
    protected View sobot_container;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/base/SobotActionSheet$DialogOnClickListener.class */
    public interface DialogOnClickListener {
        void onSure();
    }

    public SobotActionSheet(Activity activity) {
        this(activity, ResourceUtils.getIdByName(activity, "style", "sobot_clearHistoryDialogStyle"));
    }

    public SobotActionSheet(Activity activity, int i) {
        super(activity, i);
        this.screenHeight = getScreenHeight(activity);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 81;
            setParams(activity, attributes);
            window.setAttributes(attributes);
        }
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void setParams(Context context, WindowManager.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        Rect rect = new Rect();
        if (getWindow() != null) {
            getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            layoutParams.width = displayMetrics.widthPixels;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        KeyboardUtil.hideKeyboard(getCurrentFocus());
        super.dismiss();
    }

    protected abstract View getDialogContainer();

    protected abstract String getLayoutStrName();

    public int getResDrawableId(String str) {
        return ResourceUtils.getIdByName(getContext(), i.f5112c, str);
    }

    public int getResId(String str) {
        return ResourceUtils.getIdByName(getContext(), "id", str);
    }

    public int getResLayoutId(String str) {
        return ResourceUtils.getIdByName(getContext(), "layout", str);
    }

    public String getResString(String str) {
        return ResourceUtils.getResString(getContext(), str);
    }

    public int getResStringId(String str) {
        return ResourceUtils.getIdByName(getContext(), "string", str);
    }

    protected abstract void initData();

    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", getLayoutStrName()));
        initView();
        View dialogContainer = getDialogContainer();
        this.sobot_container = dialogContainer;
        dialogContainer.measure(0, 0);
        initData();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (motionEvent.getAction() == 0) {
            if (motionEvent.getX() >= -10.0f && motionEvent.getY() >= -10.0f) {
                double y = motionEvent.getY();
                int i = this.screenHeight;
                if (y > (i - (this.sobot_container != null ? view.getHeight() : i * 0.7d)) - 20.0d) {
                    return true;
                }
            }
            dismiss();
            return true;
        }
        return true;
    }

    public void setOnClickListener(DialogOnClickListener dialogOnClickListener) {
        this.listener = dialogOnClickListener;
    }
}
