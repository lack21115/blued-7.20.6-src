package com.sobot.chat.widget;

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
import android.widget.Button;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ClearHistoryDialog.class */
public class ClearHistoryDialog extends Dialog implements View.OnClickListener {
    private DialogOnClickListener listener;
    private final int screenHeight;
    private Button sobot_btn_cancel;
    private Button sobot_btn_take_photo;
    private LinearLayout sobot_pop_layout;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ClearHistoryDialog$DialogOnClickListener.class */
    public interface DialogOnClickListener {
        void onSure();
    }

    public ClearHistoryDialog(Activity activity) {
        super(activity, ResourceUtils.getIdByName(activity, "style", "sobot_clearHistoryDialogStyle"));
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

    private void initData() {
    }

    private void initView() {
        Button button = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_take_photo"));
        this.sobot_btn_take_photo = button;
        button.setText(ResourceUtils.getResString(getContext(), "sobot_save_pic"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_cancel"));
        this.sobot_btn_cancel = button2;
        button2.setText(ResourceUtils.getResString(getContext(), "sobot_btn_cancle"));
        this.sobot_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_pop_layout"));
        this.sobot_btn_take_photo.setText(ResourceUtils.getResString(getContext(), "sobot_clear_history_message"));
        this.sobot_btn_take_photo.setTextColor(getContext().getResources().getColor(ResourceUtils.getIdByName(getContext(), "color", "sobot_text_delete_hismsg_color")));
        this.sobot_btn_take_photo.setOnClickListener(this);
        this.sobot_btn_cancel.setOnClickListener(this);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DialogOnClickListener dialogOnClickListener;
        Tracker.onClick(view);
        dismiss();
        if (view != this.sobot_btn_take_photo || (dialogOnClickListener = this.listener) == null) {
            return;
        }
        dialogOnClickListener.onSure();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", "sobot_clear_history_dialog"));
        initView();
        initData();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (motionEvent.getX() < -10.0f || motionEvent.getY() < -10.0f || motionEvent.getY() <= (this.screenHeight - this.sobot_pop_layout.getHeight()) - 20) {
                dismiss();
                return true;
            }
            return true;
        }
        return true;
    }

    public void setOnClickListener(DialogOnClickListener dialogOnClickListener) {
        this.listener = dialogOnClickListener;
    }
}
