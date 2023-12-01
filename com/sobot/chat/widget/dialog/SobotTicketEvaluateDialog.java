package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.SobotEditTextLayout;
import com.sobot.chat.widget.dialog.base.SobotActionSheet;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotTicketEvaluateDialog.class */
public class SobotTicketEvaluateDialog extends SobotActionSheet {
    private LinearLayout coustom_pop_layout;
    private Activity mContext;
    private SobotUserTicketEvaluate mEvaluate;
    private SobotEditTextLayout setl_submit_content;
    private EditText sobot_add_content;
    private Button sobot_close_now;
    private LinearLayout sobot_negativeButton;
    private RatingBar sobot_ratingBar;
    private TextView sobot_ratingBar_title;
    private TextView sobot_tv_evaluate_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotTicketEvaluateDialog$SobotTicketEvaluateCallback.class */
    public interface SobotTicketEvaluateCallback {
        void submitEvaluate(int i, String str);
    }

    public SobotTicketEvaluateDialog(Activity activity) {
        super(activity);
        this.mContext = activity;
    }

    public SobotTicketEvaluateDialog(Activity activity, SobotUserTicketEvaluate sobotUserTicketEvaluate) {
        super(activity);
        this.mEvaluate = sobotUserTicketEvaluate;
        this.mContext = activity;
    }

    private void setViewListener() {
        if (((Information) SharedPreferencesUtil.getObject(getContext(), ZhiChiConstant.sobot_last_current_info)).isHideManualEvaluationLabels()) {
            this.sobot_ratingBar_title.setVisibility(8);
        } else {
            this.sobot_ratingBar_title.setVisibility(0);
        }
        this.sobot_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateDialog.2
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                List<SobotUserTicketEvaluate.TicketScoreInfooListBean> ticketScoreInfooList;
                Tracker.onRatingChanged(ratingBar, f, z);
                int ceil = (int) Math.ceil(SobotTicketEvaluateDialog.this.sobot_ratingBar.getRating());
                if (ceil <= 0 || ceil > 5 || (ticketScoreInfooList = SobotTicketEvaluateDialog.this.mEvaluate.getTicketScoreInfooList()) == null || ticketScoreInfooList.size() < ceil) {
                    return;
                }
                SobotTicketEvaluateDialog.this.sobot_ratingBar_title.setText(ticketScoreInfooList.get(5 - ceil).getScoreExplain());
            }
        });
        this.sobot_ratingBar.setRating(5.0f);
        this.sobot_close_now.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SobotTicketEvaluateDialog.this.mContext instanceof SobotTicketEvaluateCallback) {
                    SobotTicketEvaluateCallback sobotTicketEvaluateCallback = (SobotTicketEvaluateCallback) SobotTicketEvaluateDialog.this.mContext;
                    int ceil = (int) Math.ceil(SobotTicketEvaluateDialog.this.sobot_ratingBar.getRating());
                    KeyboardUtil.hideKeyboard(SobotTicketEvaluateDialog.this.sobot_add_content);
                    sobotTicketEvaluateCallback.submitEvaluate(ceil, SobotTicketEvaluateDialog.this.sobot_add_content.getText().toString());
                    SobotTicketEvaluateDialog.this.dismiss();
                }
            }
        });
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public View getDialogContainer() {
        if (this.coustom_pop_layout == null) {
            this.coustom_pop_layout = (LinearLayout) findViewById(getResId("sobot_evaluate_container"));
        }
        return this.coustom_pop_layout;
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public String getLayoutStrName() {
        return "sobot_layout_ticket_evaluate";
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initData() {
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initView() {
        EditText editText = (EditText) findViewById(getResId("sobot_add_content"));
        this.sobot_add_content = editText;
        editText.setHint(ResourceUtils.getResString(this.mContext, "sobot_edittext_hint"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_evaluate_title"));
        this.sobot_tv_evaluate_title = textView;
        textView.setText(ResourceUtils.getResString(this.mContext, "sobot_please_comment"));
        Button button = (Button) findViewById(getResId(ZhiChiConstants.sobot_close_now));
        this.sobot_close_now = button;
        button.setText(ResourceUtils.getResString(this.mContext, "sobot_btn_submit_text"));
        this.sobot_ratingBar = (RatingBar) findViewById(getResId("sobot_ratingBar"));
        this.setl_submit_content = (SobotEditTextLayout) findViewById(getResId("setl_submit_content"));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        this.sobot_negativeButton = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotTicketEvaluateDialog.this.dismiss();
            }
        });
        this.sobot_ratingBar_title = (TextView) findViewById(getResId("sobot_ratingBar_title"));
        if (this.mEvaluate.isOpen()) {
            this.sobot_add_content.setVisibility(this.mEvaluate.isTxtFlag() ? 0 : 8);
        }
        setViewListener();
    }
}
