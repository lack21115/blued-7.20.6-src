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
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotSelectPicDialog.class */
public class SobotSelectPicDialog extends Dialog {
    private Button btn_cancel;
    private Button btn_pick_photo;
    private Button btn_pick_vedio;
    private Button btn_take_photo;
    private Context context;
    private LinearLayout coustom_pop_layout;
    private View.OnClickListener itemsOnClick;
    private View mView;
    private final int screenHeight;

    public SobotSelectPicDialog(Activity activity, View.OnClickListener onClickListener) {
        super(activity, ResourceUtils.getIdByName(activity, "style", "sobot_clearHistoryDialogStyle"));
        this.context = activity;
        this.itemsOnClick = onClickListener;
        this.screenHeight = ScreenUtils.getScreenHeight(activity);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (SobotApi.getSwitchMarkStatus(4) && SobotApi.getSwitchMarkStatus(1)) {
                attributes.gravity = 17;
                attributes.flags = 8;
            } else {
                attributes.gravity = 81;
                setParams(activity, attributes);
            }
            window.setAttributes(attributes);
        }
    }

    private void initView() {
        Button button = (Button) findViewById(ResourceUtils.getIdByName(this.context, "id", "btn_take_photo"));
        this.btn_take_photo = button;
        button.setText(ResourceUtils.getResString(this.context, "sobot_attach_take_pic"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(this.context, "id", "btn_pick_photo"));
        this.btn_pick_photo = button2;
        button2.setText(ResourceUtils.getResString(this.context, "sobot_choice_form_picture"));
        Button button3 = (Button) findViewById(ResourceUtils.getIdByName(this.context, "id", "btn_pick_vedio"));
        this.btn_pick_vedio = button3;
        button3.setText(ResourceUtils.getResString(this.context, "sobot_choice_form_vedio"));
        Button button4 = (Button) findViewById(ResourceUtils.getIdByName(this.context, "id", "btn_cancel"));
        this.btn_cancel = button4;
        button4.setText(ResourceUtils.getResString(this.context, "sobot_btn_cancle"));
        this.coustom_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(this.context, "id", "pop_layout"));
        this.btn_take_photo.setOnClickListener(this.itemsOnClick);
        this.btn_pick_photo.setOnClickListener(this.itemsOnClick);
        this.btn_pick_vedio.setOnClickListener(this.itemsOnClick);
        this.btn_cancel.setOnClickListener(this.itemsOnClick);
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
        setContentView(ResourceUtils.getIdByName(this.context, "layout", "sobot_take_pic_pop"));
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
