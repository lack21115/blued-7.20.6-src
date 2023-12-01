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

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotFreeAccountTipDialog.class */
public class SobotFreeAccountTipDialog extends Dialog {
    private LinearLayout coustom_pop_layout;
    private View.OnClickListener itemsOnClick;
    private final int screenHeight;
    private Button sobot_btn_ok;
    private TextView sobot_tv_tip;

    public SobotFreeAccountTipDialog(Activity activity, View.OnClickListener onClickListener) {
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
        Button button = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_btn_ok"));
        this.sobot_btn_ok = button;
        button.setText(ResourceUtils.getResString(getContext(), "sobot_btn_submit"));
        this.coustom_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(getContext(), "id", "pop_layout"));
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(getContext(), "id", "sobot_tv_tip"));
        this.sobot_tv_tip = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_chat_free_account_tip"));
        this.sobot_btn_ok.setOnClickListener(this.itemsOnClick);
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
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", "sobot_free_account_tip_popup"));
        initView();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || motionEvent.getX() < -10.0f || motionEvent.getY() < -10.0f) {
            return true;
        }
        motionEvent.getY();
        this.coustom_pop_layout.getHeight();
        return true;
    }
}
