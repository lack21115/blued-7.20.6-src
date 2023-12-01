package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotPermissionDialog.class */
public class SobotPermissionDialog extends Dialog implements View.OnClickListener {
    private LinearLayout coustom_pop_layout;
    private final int screenHeight;
    private Button sobot_btn_cancle_conversation;
    private Button sobot_btn_temporary_leave;
    private String title;
    private TextView titleView;
    private ClickViewListener viewListenern;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotPermissionDialog$ClickViewListener.class */
    public interface ClickViewListener {
        void clickLeftView(Context context, SobotPermissionDialog sobotPermissionDialog);

        void clickRightView(Context context, SobotPermissionDialog sobotPermissionDialog);
    }

    public SobotPermissionDialog(Activity activity, ClickViewListener clickViewListener) {
        super(activity, ResourceUtils.getIdByName(activity, "style", "sobot_noAnimDialogStyle"));
        this.viewListenern = clickViewListener;
        this.screenHeight = ScreenUtils.getScreenHeight(activity);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (SobotApi.getSwitchMarkStatus(4) && SobotApi.getSwitchMarkStatus(1)) {
                attributes.flags = 8;
            }
            setParams(activity, attributes);
            window.setAttributes(attributes);
        }
    }

    public SobotPermissionDialog(Activity activity, String str, ClickViewListener clickViewListener) {
        this(activity, clickViewListener);
        this.title = str;
    }

    private void initView() {
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_dialog_title"));
        this.titleView = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_no_permission_text"));
        if (!TextUtils.isEmpty(this.title)) {
            this.titleView.setText(this.title);
        }
        Button button = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_left"));
        this.sobot_btn_cancle_conversation = button;
        button.setText(ResourceUtils.getResString(getContext(), "sobot_btn_cancle"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_right"));
        this.sobot_btn_temporary_leave = button2;
        button2.setText(ResourceUtils.getResString(getContext(), "sobot_go_setting"));
        this.coustom_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(getContext(), "id", "pop_layout"));
        this.sobot_btn_cancle_conversation.setOnClickListener(this);
        this.sobot_btn_temporary_leave.setOnClickListener(this);
    }

    private void setParams(Context context, WindowManager.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        layoutParams.width = displayMetrics.widthPixels;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickViewListener clickViewListener;
        ClickViewListener clickViewListener2;
        Tracker.onClick(view);
        if (view == this.sobot_btn_cancle_conversation && (clickViewListener2 = this.viewListenern) != null) {
            clickViewListener2.clickLeftView(getContext(), this);
        }
        if (view != this.sobot_btn_temporary_leave || (clickViewListener = this.viewListenern) == null) {
            return;
        }
        clickViewListener.clickRightView(getContext(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", "sobot_permission_popup"));
        initView();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (motionEvent.getX() < -10.0f || motionEvent.getY() < -10.0f || motionEvent.getY() <= (this.screenHeight - this.coustom_pop_layout.getHeight()) - 20) {
                dismiss();
                return true;
            }
            return true;
        }
        return true;
    }
}
