package com.sobot.chat.widget.dialog;

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
import android.widget.TextView;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotBackDialog.class */
public class SobotBackDialog extends Dialog {
    private LinearLayout coustom_pop_layout;
    private View.OnClickListener itemsOnClick;
    private final int screenHeight;
    private Button sobot_btn_cancle_conversation;
    private Button sobot_btn_temporary_leave;
    private TextView sobot_tv_will_end_conversation;

    public SobotBackDialog(Activity activity, View.OnClickListener onClickListener) {
        super(activity, ResourceUtils.getIdByName(activity, "style", "sobot_noAnimDialogStyle"));
        this.itemsOnClick = onClickListener;
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

    private void initView() {
        Button button = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_cancle_conversation"));
        this.sobot_btn_cancle_conversation = button;
        button.setText(ResourceUtils.getResString(getContext(), "sobot_cancle_conversation"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_temporary_leave"));
        this.sobot_btn_temporary_leave = button2;
        button2.setText(ResourceUtils.getResString(getContext(), "sobot_temporary_leave"));
        this.coustom_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(getContext(), "id", "pop_layout"));
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_tv_will_end_conversation"));
        this.sobot_tv_will_end_conversation = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_will_end_conversation"));
        this.sobot_btn_cancle_conversation.setOnClickListener(this.itemsOnClick);
        this.sobot_btn_temporary_leave.setOnClickListener(this.itemsOnClick);
    }

    private void setParams(Context context, WindowManager.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        layoutParams.width = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", "sobot_back_popup"));
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
