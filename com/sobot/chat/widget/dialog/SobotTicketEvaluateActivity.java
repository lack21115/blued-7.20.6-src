package com.sobot.chat.widget.dialog;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.SobotEditTextLayout;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotTicketEvaluateActivity.class */
public class SobotTicketEvaluateActivity extends SobotDialogBaseActivity {
    private SobotUserTicketEvaluate mEvaluate;
    private SobotEditTextLayout setl_submit_content;
    private EditText sobot_add_content;
    private Button sobot_close_now;
    private LinearLayout sobot_negativeButton;
    private RatingBar sobot_ratingBar;
    private TextView sobot_ratingBar_title;
    private TextView sobot_tv_evaluate_title;

    private void setViewListener() {
        if (((Information) SharedPreferencesUtil.getObject(getContext(), ZhiChiConstant.sobot_last_current_info)).isHideManualEvaluationLabels()) {
            this.sobot_ratingBar_title.setVisibility(8);
        } else {
            this.sobot_ratingBar_title.setVisibility(0);
        }
        this.sobot_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateActivity.2
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                List<SobotUserTicketEvaluate.TicketScoreInfooListBean> ticketScoreInfooList;
                Tracker.onRatingChanged(ratingBar, f, z);
                int ceil = (int) Math.ceil(SobotTicketEvaluateActivity.this.sobot_ratingBar.getRating());
                if (ceil <= 0 || ceil > 5 || (ticketScoreInfooList = SobotTicketEvaluateActivity.this.mEvaluate.getTicketScoreInfooList()) == null || ticketScoreInfooList.size() < ceil) {
                    return;
                }
                SobotTicketEvaluateActivity.this.sobot_ratingBar_title.setText(ticketScoreInfooList.get(5 - ceil).getScoreExplain());
            }
        });
        this.sobot_ratingBar.setRating(5.0f);
        this.sobot_close_now.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int ceil = (int) Math.ceil(SobotTicketEvaluateActivity.this.sobot_ratingBar.getRating());
                KeyboardUtil.hideKeyboard(SobotTicketEvaluateActivity.this.sobot_add_content);
                Intent intent = new Intent();
                intent.putExtra(WBConstants.GAME_PARAMS_SCORE, ceil);
                intent.putExtra("content", SobotTicketEvaluateActivity.this.sobot_add_content.getText().toString());
                SobotTicketEvaluateActivity.this.setResult(-1, intent);
                SobotTicketEvaluateActivity.this.finish();
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_layout_ticket_evaluate");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        EditText editText = (EditText) findViewById(getResId("sobot_add_content"));
        this.sobot_add_content = editText;
        editText.setHint(ResourceUtils.getResString(this, "sobot_edittext_hint"));
        Button button = (Button) findViewById(getResId(ZhiChiConstants.sobot_close_now));
        this.sobot_close_now = button;
        button.setText(ResourceUtils.getResString(this, "sobot_btn_submit_text"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_evaluate_title"));
        this.sobot_tv_evaluate_title = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_please_comment"));
        this.sobot_ratingBar = (RatingBar) findViewById(getResId("sobot_ratingBar"));
        this.setl_submit_content = (SobotEditTextLayout) findViewById(getResId("setl_submit_content"));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        this.sobot_negativeButton = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotTicketEvaluateActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotTicketEvaluateActivity.this.finish();
            }
        });
        this.sobot_ratingBar_title = (TextView) findViewById(getResId("sobot_ratingBar_title"));
        SobotUserTicketEvaluate sobotUserTicketEvaluate = (SobotUserTicketEvaluate) getIntent().getSerializableExtra("sobotUserTicketEvaluate");
        this.mEvaluate = sobotUserTicketEvaluate;
        if (sobotUserTicketEvaluate != null) {
            if (sobotUserTicketEvaluate.isOpen()) {
                this.sobot_add_content.setVisibility(this.mEvaluate.isTxtFlag() ? 0 : 8);
            }
            setViewListener();
        }
    }
}
