package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.activity.base.SobotDialogBaseActivity;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SatisfactionSet;
import com.sobot.chat.api.model.SatisfactionSetBase;
import com.sobot.chat.api.model.SobotCommentParam;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.SobotAntoLineLayout;
import com.sobot.chat.widget.SobotEditTextLayout;
import com.sobot.chat.widget.SobotTenRatingLayout;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotEvaluateActivity.class */
public class SobotEvaluateActivity extends SobotDialogBaseActivity {
    private final String CANCEL_TAG = SobotEvaluateActivity.class.getSimpleName();
    private List<CheckBox> checkBoxList = new ArrayList();
    private int commentType;
    private Activity context;
    private LinearLayout coustom_pop_layout;
    private int current_model;
    private String customName;
    private String evaluateChecklables;
    private Information information;
    private ZhiChiInitModeBase initModel;
    private boolean isBackShowEvaluate;
    private boolean isExitSession;
    private boolean isFinish;
    private boolean isSessionOver;
    private int isSolve;
    private int ratingType;
    private List<SatisfactionSetBase> satisFactionList;
    private SatisfactionSetBase satisfactionSetBase;
    private int score;
    private SobotEditTextLayout setl_submit_content;
    private EditText sobot_add_content;
    private RadioButton sobot_btn_no_robot;
    private RadioButton sobot_btn_ok_robot;
    private Button sobot_close_now;
    private TextView sobot_custom_center_title;
    private LinearLayout sobot_custom_relative;
    private TextView sobot_evaluate_cancel;
    private SobotAntoLineLayout sobot_evaluate_lable_autoline;
    private LinearLayout sobot_hide_layout;
    private LinearLayout sobot_negativeButton;
    private RatingBar sobot_ratingBar;
    private View sobot_ratingBar_split_view;
    private TextView sobot_ratingBar_title;
    private RadioGroup sobot_readiogroup;
    private TextView sobot_robot_center_title;
    private LinearLayout sobot_robot_relative;
    private SobotTenRatingLayout sobot_ten_rating_ll;
    private LinearLayout sobot_ten_root_ll;
    private TextView sobot_ten_very_dissatisfied;
    private TextView sobot_ten_very_satisfaction;
    private TextView sobot_text_other_problem;
    private TextView sobot_tv_evaluate_title;
    private TextView sobot_tv_evaluate_title_hint;

    private String checkBoxIsChecked() {
        String str = "";
        int i = 0;
        while (i < this.checkBoxList.size()) {
            String str2 = str;
            if (this.checkBoxList.get(i).isChecked()) {
                str2 = str + ((Object) this.checkBoxList.get(i).getText()) + ",";
            }
            i++;
            str = str2;
        }
        String str3 = str;
        if (str.length() > 0) {
            str3 = str.substring(0, str.length() - 1);
        }
        return str3 + "";
    }

    private boolean checkInput() {
        int i = this.current_model;
        if (i != 302) {
            if (i == 301) {
            }
            return true;
        } else if (this.satisfactionSetBase != null) {
            SobotCommentParam commentParam = getCommentParam();
            if (!TextUtils.isEmpty(this.satisfactionSetBase.getLabelName()) && this.satisfactionSetBase.getIsTagMust() && TextUtils.isEmpty(commentParam.getProblem())) {
                ToastUtil.showToast(this.context, getResString("sobot_the_label_is_required"));
                return false;
            } else if (this.satisfactionSetBase.getIsInputMust() && TextUtils.isEmpty(commentParam.getSuggest().trim())) {
                ToastUtil.showToast(this.context, getResString("sobot_suggestions_are_required"));
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private void checkLable(String[] strArr) {
        if (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.evaluateChecklables) || this.sobot_evaluate_lable_autoline == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            CheckBox checkBox = (CheckBox) this.sobot_evaluate_lable_autoline.getChildAt(i2);
            if (checkBox != null) {
                if (this.evaluateChecklables.contains(strArr[i2])) {
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
            }
            i = i2 + 1;
        }
    }

    private void comment() {
        ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(this.context).getZhiChiApi();
        final SobotCommentParam commentParam = getCommentParam();
        zhiChiApi.comment(this.CANCEL_TAG, this.initModel.getCid(), this.initModel.getPartnerid(), commentParam, new StringResultCallBack<CommonModel>() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.8
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                try {
                    ToastUtil.showToast(SobotEvaluateActivity.this.getContext(), str);
                } catch (Exception e) {
                }
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(CommonModel commonModel) {
                Intent intent = new Intent();
                intent.setAction(ZhiChiConstants.dcrc_comment_state);
                intent.putExtra("commentState", true);
                intent.putExtra("isFinish", SobotEvaluateActivity.this.isFinish);
                intent.putExtra("isExitSession", SobotEvaluateActivity.this.isExitSession);
                intent.putExtra("commentType", SobotEvaluateActivity.this.commentType);
                if (!TextUtils.isEmpty(commentParam.getScore())) {
                    intent.putExtra(WBConstants.GAME_PARAMS_SCORE, Integer.parseInt(commentParam.getScore()));
                }
                intent.putExtra("isResolved", commentParam.getIsresolve());
                CommonUtils.sendLocalBroadcast(SobotEvaluateActivity.this.context, intent);
                SobotEvaluateActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] convertStrToArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    private void createChildLableView(SobotAntoLineLayout sobotAntoLineLayout, String[] strArr) {
        if (sobotAntoLineLayout == null) {
            return;
        }
        sobotAntoLineLayout.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            View inflate = getLayoutInflater().inflate(ResourceUtils.getResLayoutId(getContext(), "sobot_layout_evaluate_item"), (ViewGroup) null);
            CheckBox checkBox = (CheckBox) inflate.findViewById(ResourceUtils.getResId(getContext(), "sobot_evaluate_cb_lable"));
            checkBox.setMinWidth((ScreenUtil.getScreenSize(this.context)[0] - ScreenUtils.dip2px(getContext(), 50.0f)) / 2);
            checkBox.setText(strArr[i2]);
            sobotAntoLineLayout.addView(inflate);
            this.checkBoxList.add(checkBox);
            i = i2 + 1;
        }
    }

    private SobotCommentParam getCommentParam() {
        int selectContent;
        SobotCommentParam sobotCommentParam = new SobotCommentParam();
        String str = this.current_model == 301 ? "0" : "1";
        if (this.ratingType == 0) {
            sobotCommentParam.setScoreFlag(0);
            selectContent = (int) Math.ceil(this.sobot_ratingBar.getRating());
        } else {
            sobotCommentParam.setScoreFlag(1);
            selectContent = this.sobot_ten_rating_ll.getSelectContent();
        }
        String checkBoxIsChecked = checkBoxIsChecked();
        String obj = this.sobot_add_content.getText().toString();
        sobotCommentParam.setType(str);
        sobotCommentParam.setProblem(checkBoxIsChecked);
        sobotCommentParam.setSuggest(obj);
        sobotCommentParam.setIsresolve(getResovled());
        sobotCommentParam.setCommentType(this.commentType);
        if (this.current_model == 301) {
            sobotCommentParam.setRobotFlag(this.initModel.getRobotid());
            return sobotCommentParam;
        }
        sobotCommentParam.setScore(selectContent + "");
        return sobotCommentParam;
    }

    private int getResovled() {
        SatisfactionSetBase satisfactionSetBase;
        int i = this.current_model;
        if (i == 301) {
            return this.sobot_btn_ok_robot.isChecked() ? 0 : 1;
        } else if (i == 302 && (satisfactionSetBase = this.satisfactionSetBase) != null && satisfactionSetBase.getIsQuestionFlag()) {
            return this.sobot_btn_ok_robot.isChecked() ? 0 : 1;
        } else {
            return -1;
        }
    }

    private SatisfactionSetBase getSatisFaction(int i, List<SatisfactionSetBase> list) {
        if (list == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return null;
            }
            String score = list.get(i3).getScore();
            if (score.equals(i + "")) {
                return list.get(i3);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomLayoutViewVisible(int i, List<SatisfactionSetBase> list) {
        this.satisfactionSetBase = getSatisFaction(i, list);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.checkBoxList.size()) {
                break;
            }
            this.checkBoxList.get(i3).setChecked(false);
            i2 = i3 + 1;
        }
        SatisfactionSetBase satisfactionSetBase = this.satisfactionSetBase;
        if (satisfactionSetBase == null) {
            if (this.information.isHideManualEvaluationLabels()) {
                this.sobot_ratingBar_title.setVisibility(8);
                return;
            } else {
                this.sobot_ratingBar_title.setVisibility(0);
                return;
            }
        }
        this.sobot_ratingBar_title.setText(satisfactionSetBase.getScoreExplain());
        this.sobot_ratingBar_title.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_color_evaluate_ratingBar_des_tv")));
        if (TextUtils.isEmpty(this.satisfactionSetBase.getInputLanguage())) {
            this.sobot_add_content.setHint(String.format(ChatUtils.getResString(this.context, "sobot_edittext_hint"), new Object[0]));
        } else if (this.satisfactionSetBase.getIsInputMust()) {
            EditText editText = this.sobot_add_content;
            editText.setHint(getResString("sobot_required") + this.satisfactionSetBase.getInputLanguage().replace("<br/>", "\n"));
        } else {
            this.sobot_add_content.setHint(this.satisfactionSetBase.getInputLanguage().replace("<br/>", "\n"));
        }
        if (TextUtils.isEmpty(this.satisfactionSetBase.getLabelName())) {
            setLableViewVisible(null);
        } else {
            setLableViewVisible(convertStrToArray(this.satisfactionSetBase.getLabelName()));
        }
        if (this.information.isHideManualEvaluationLabels()) {
            this.sobot_ratingBar_title.setVisibility(8);
        } else {
            this.sobot_ratingBar_title.setVisibility(0);
        }
        if (i != 5) {
            this.setl_submit_content.setVisibility(0);
            return;
        }
        this.setl_submit_content.setVisibility(0);
        this.sobot_ratingBar_title.setText(this.satisfactionSetBase.getScoreExplain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLableViewVisible(String[] strArr) {
        SatisfactionSetBase satisfactionSetBase;
        if (strArr == null) {
            this.sobot_hide_layout.setVisibility(8);
            return;
        }
        if (this.current_model == 301 && this.initModel != null) {
            if (this.information.isHideRototEvaluationLabels()) {
                this.sobot_hide_layout.setVisibility(8);
            } else {
                this.sobot_hide_layout.setVisibility(0);
            }
        }
        if (this.current_model == 302 && this.initModel != null) {
            if (this.information.isHideManualEvaluationLabels()) {
                this.sobot_hide_layout.setVisibility(8);
            } else {
                this.sobot_hide_layout.setVisibility(0);
            }
        }
        if (this.current_model == 302 && (satisfactionSetBase = this.satisfactionSetBase) != null) {
            if (TextUtils.isEmpty(satisfactionSetBase.getTagTips())) {
                this.sobot_text_other_problem.setVisibility(8);
            } else {
                this.sobot_text_other_problem.setVisibility(0);
                if (this.satisfactionSetBase.getIsTagMust()) {
                    this.sobot_text_other_problem.setText(this.satisfactionSetBase.getTagTips());
                } else {
                    this.sobot_text_other_problem.setText(this.satisfactionSetBase.getTagTips());
                }
            }
        }
        createChildLableView(this.sobot_evaluate_lable_autoline, strArr);
        checkLable(strArr);
    }

    private void setViewGone() {
        this.sobot_hide_layout.setVisibility(8);
        this.setl_submit_content.setVisibility(8);
        this.sobot_evaluate_lable_autoline.removeAllViews();
        if (this.current_model == 301) {
            this.sobot_tv_evaluate_title.setText(getResString("sobot_robot_customer_service_evaluation"));
            TextView textView = this.sobot_robot_center_title;
            textView.setText(this.initModel.getRobotName() + ChatUtils.getResString(this.context, "sobot_question"));
            this.sobot_robot_relative.setVisibility(0);
            this.sobot_custom_relative.setVisibility(8);
            return;
        }
        if (!SharedPreferencesUtil.getBooleanData(this.context, ZhiChiConstant.SOBOT_CHAT_EVALUATION_COMPLETED_EXIT, false) || this.isSessionOver) {
            this.sobot_tv_evaluate_title_hint.setVisibility(8);
        } else {
            this.sobot_tv_evaluate_title_hint.setText(getResString("sobot_evaluation_completed_exit"));
            this.sobot_tv_evaluate_title_hint.setVisibility(0);
        }
        this.sobot_tv_evaluate_title.setText(getResString("sobot_please_evaluate_this_service"));
        TextView textView2 = this.sobot_robot_center_title;
        textView2.setText(this.customName + " " + ChatUtils.getResString(this.context, "sobot_question"));
        TextView textView3 = this.sobot_custom_center_title;
        textView3.setText(this.customName + " " + ChatUtils.getResString(this.context, "sobot_please_evaluate"));
        this.sobot_robot_relative.setVisibility(8);
        this.sobot_custom_relative.setVisibility(0);
    }

    private void setViewListener() {
        this.sobot_ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.3
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                Tracker.onRatingChanged(ratingBar, f, z);
                if (SobotEvaluateActivity.this.satisfactionSetBase != null) {
                    SobotEvaluateActivity.this.sobot_close_now.setVisibility(0);
                }
                int ceil = (int) Math.ceil(SobotEvaluateActivity.this.sobot_ratingBar.getRating());
                if (ceil == 0) {
                    SobotEvaluateActivity.this.sobot_ratingBar.setRating(1.0f);
                }
                if (ceil <= 0 || ceil > 5) {
                    return;
                }
                SobotEvaluateActivity.this.sobot_close_now.setSelected(true);
                SobotEvaluateActivity sobotEvaluateActivity = SobotEvaluateActivity.this;
                sobotEvaluateActivity.setCustomLayoutViewVisible(ceil, sobotEvaluateActivity.satisFactionList);
            }
        });
        this.sobot_readiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Tracker.onCheckedChanged(radioGroup, i);
                if (SobotEvaluateActivity.this.current_model != 301 || SobotEvaluateActivity.this.initModel == null) {
                    return;
                }
                if (i == SobotEvaluateActivity.this.getResId("sobot_btn_ok_robot")) {
                    SobotEvaluateActivity.this.sobot_hide_layout.setVisibility(8);
                    SobotEvaluateActivity.this.setl_submit_content.setVisibility(8);
                } else if (i == SobotEvaluateActivity.this.getResId("sobot_btn_no_robot")) {
                    SobotEvaluateActivity.this.sobot_hide_layout.setVisibility(0);
                    SobotEvaluateActivity.this.setl_submit_content.setVisibility(0);
                    String[] convertStrToArray = SobotEvaluateActivity.convertStrToArray(SobotEvaluateActivity.this.initModel.getRobotCommentTitle());
                    if (convertStrToArray == null || convertStrToArray.length <= 0) {
                        SobotEvaluateActivity.this.sobot_hide_layout.setVisibility(8);
                    } else {
                        SobotEvaluateActivity.this.setLableViewVisible(convertStrToArray);
                    }
                }
            }
        });
        this.sobot_close_now.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotEvaluateActivity.this.subMitEvaluate();
            }
        });
        this.sobot_evaluate_cancel.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotEvaluateActivity.this.finish();
                Intent intent = new Intent();
                intent.setAction(ZhiChiConstants.sobot_close_now);
                intent.putExtra("isBackShowEvaluate", SobotEvaluateActivity.this.isBackShowEvaluate);
                CommonUtils.sendLocalBroadcast(SobotEvaluateActivity.this.context.getApplicationContext(), intent);
            }
        });
        SobotTenRatingLayout sobotTenRatingLayout = this.sobot_ten_rating_ll;
        if (sobotTenRatingLayout != null) {
            sobotTenRatingLayout.setOnClickItemListener(new SobotTenRatingLayout.OnClickItemListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.7
                @Override // com.sobot.chat.widget.SobotTenRatingLayout.OnClickItemListener
                public void onClickItem(int i) {
                    if (SobotEvaluateActivity.this.satisfactionSetBase != null) {
                        SobotEvaluateActivity.this.sobot_close_now.setVisibility(0);
                    }
                    SobotEvaluateActivity.this.sobot_close_now.setSelected(true);
                    SobotEvaluateActivity sobotEvaluateActivity = SobotEvaluateActivity.this;
                    sobotEvaluateActivity.setCustomLayoutViewVisible(i, sobotEvaluateActivity.satisFactionList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subMitEvaluate() {
        if (checkInput()) {
            comment();
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        if (motionEvent.getAction() != 0) {
            if (getWindow().superDispatchTouchEvent(motionEvent)) {
                return true;
            }
            return onTouchEvent(motionEvent);
        }
        View currentFocus = getCurrentFocus();
        if (isShouldHideInput(currentFocus, motionEvent) && (inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return ResourceUtils.getResLayoutId(this, "sobot_layout_evaluate");
    }

    @Override // com.sobot.chat.activity.base.SobotDialogBaseActivity
    public Activity getContext() {
        return this;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        if (this.current_model == 302) {
            ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(this.context).getZhiChiApi();
            this.sobot_close_now.setVisibility(8);
            zhiChiApi.satisfactionMessage(this.CANCEL_TAG, this.initModel.getPartnerid(), new ResultCallBack<SatisfactionSet>() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.2
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(SatisfactionSet satisfactionSet) {
                    SobotEvaluateActivity.this.sobot_close_now.setVisibility(0);
                    if (satisfactionSet == null || !"1".equals(satisfactionSet.getCode()) || satisfactionSet.getData() == null || satisfactionSet.getData().size() == 0) {
                        return;
                    }
                    SobotEvaluateActivity.this.satisFactionList = satisfactionSet.getData();
                    if (SobotEvaluateActivity.this.commentType == 1) {
                        if (SobotEvaluateActivity.this.satisFactionList.get(0) == null) {
                            return;
                        }
                        if (((SatisfactionSetBase) SobotEvaluateActivity.this.satisFactionList.get(0)).getScoreFlag() == 0) {
                            SobotEvaluateActivity sobotEvaluateActivity = SobotEvaluateActivity.this;
                            sobotEvaluateActivity.score = ((SatisfactionSetBase) sobotEvaluateActivity.satisFactionList.get(0)).getDefaultType() == 0 ? 5 : 0;
                            SobotEvaluateActivity.this.sobot_ten_root_ll.setVisibility(8);
                            SobotEvaluateActivity.this.sobot_ratingBar.setVisibility(0);
                            SobotEvaluateActivity.this.ratingType = 0;
                        } else {
                            SobotEvaluateActivity.this.sobot_ten_root_ll.setVisibility(0);
                            SobotEvaluateActivity.this.sobot_ratingBar.setVisibility(8);
                            SobotEvaluateActivity.this.ratingType = 1;
                            if (((SatisfactionSetBase) SobotEvaluateActivity.this.satisFactionList.get(0)).getDefaultType() == 2) {
                                SobotEvaluateActivity.this.score = 0;
                            } else if (((SatisfactionSetBase) SobotEvaluateActivity.this.satisFactionList.get(0)).getDefaultType() == 1) {
                                SobotEvaluateActivity.this.score = 5;
                            } else {
                                SobotEvaluateActivity.this.score = 10;
                            }
                        }
                    } else if (SobotEvaluateActivity.this.satisFactionList.get(0) == null) {
                        return;
                    } else {
                        if (((SatisfactionSetBase) SobotEvaluateActivity.this.satisFactionList.get(0)).getScoreFlag() == 0) {
                            SobotEvaluateActivity.this.sobot_ten_root_ll.setVisibility(8);
                            SobotEvaluateActivity.this.sobot_ratingBar.setVisibility(0);
                            SobotEvaluateActivity.this.ratingType = 0;
                        } else {
                            SobotEvaluateActivity.this.sobot_ten_root_ll.setVisibility(0);
                            SobotEvaluateActivity.this.sobot_ratingBar.setVisibility(8);
                            SobotEvaluateActivity.this.ratingType = 1;
                        }
                    }
                    if (SobotEvaluateActivity.this.ratingType == 0) {
                        if (SobotEvaluateActivity.this.score == -1) {
                            SobotEvaluateActivity.this.score = 5;
                        }
                        SobotEvaluateActivity.this.sobot_ratingBar.setRating(SobotEvaluateActivity.this.score);
                    } else {
                        if (SobotEvaluateActivity.this.score == -1) {
                            SobotEvaluateActivity.this.score = 10;
                        }
                        SobotEvaluateActivity.this.sobot_ten_rating_ll.init(SobotEvaluateActivity.this.score, true);
                    }
                    if (SobotEvaluateActivity.this.isSolve == 0) {
                        SobotEvaluateActivity.this.sobot_btn_ok_robot.setChecked(true);
                        SobotEvaluateActivity.this.sobot_btn_no_robot.setChecked(false);
                    } else {
                        SobotEvaluateActivity.this.sobot_btn_ok_robot.setChecked(false);
                        SobotEvaluateActivity.this.sobot_btn_no_robot.setChecked(true);
                    }
                    SobotEvaluateActivity sobotEvaluateActivity2 = SobotEvaluateActivity.this;
                    sobotEvaluateActivity2.setCustomLayoutViewVisible(sobotEvaluateActivity2.score, SobotEvaluateActivity.this.satisFactionList);
                    if (SobotEvaluateActivity.this.ratingType != 0) {
                        SobotEvaluateActivity.this.sobot_close_now.setVisibility(0);
                        if (SobotEvaluateActivity.this.satisfactionSetBase != null) {
                            SobotEvaluateActivity.this.sobot_ratingBar_title.setText(SobotEvaluateActivity.this.satisfactionSetBase.getScoreExplain());
                        }
                        SobotEvaluateActivity.this.sobot_ratingBar_title.setTextColor(ContextCompat.getColor(SobotEvaluateActivity.this.getContext(), ResourceUtils.getResColorId(SobotEvaluateActivity.this.getContext(), "sobot_color_evaluate_ratingBar_des_tv")));
                    } else if (SobotEvaluateActivity.this.score == 0) {
                        SobotEvaluateActivity.this.sobot_close_now.setVisibility(8);
                        SobotEvaluateActivity.this.sobot_ratingBar_title.setText(ResourceUtils.getResString(SobotEvaluateActivity.this.getContext(), "sobot_evaluate_zero_score_des"));
                        SobotEvaluateActivity.this.sobot_ratingBar_title.setTextColor(ContextCompat.getColor(SobotEvaluateActivity.this.getContext(), ResourceUtils.getResColorId(SobotEvaluateActivity.this.getContext(), "sobot_common_gray3")));
                    } else {
                        SobotEvaluateActivity.this.sobot_close_now.setVisibility(0);
                        if (SobotEvaluateActivity.this.satisfactionSetBase != null) {
                            SobotEvaluateActivity.this.sobot_ratingBar_title.setText(SobotEvaluateActivity.this.satisfactionSetBase.getScoreExplain());
                        }
                        SobotEvaluateActivity.this.sobot_ratingBar_title.setTextColor(ContextCompat.getColor(SobotEvaluateActivity.this.getContext(), ResourceUtils.getResColorId(SobotEvaluateActivity.this.getContext(), "sobot_color_evaluate_ratingBar_des_tv")));
                    }
                    if (((SatisfactionSetBase) SobotEvaluateActivity.this.satisFactionList.get(0)).getIsQuestionFlag()) {
                        SobotEvaluateActivity.this.sobot_robot_relative.setVisibility(0);
                        SobotEvaluateActivity.this.sobot_ratingBar_split_view.setVisibility(0);
                        return;
                    }
                    SobotEvaluateActivity.this.sobot_robot_relative.setVisibility(8);
                    SobotEvaluateActivity.this.sobot_ratingBar_split_view.setVisibility(8);
                }
            });
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        this.information = (Information) SharedPreferencesUtil.getObject(getContext(), ZhiChiConstant.sobot_last_current_info);
        this.context = getContext();
        this.score = getIntent().getIntExtra(WBConstants.GAME_PARAMS_SCORE, 0);
        this.evaluateChecklables = getIntent().getStringExtra("evaluateChecklables");
        this.isFinish = getIntent().getBooleanExtra("isFinish", false);
        this.isSessionOver = getIntent().getBooleanExtra("isSessionOver", false);
        this.isExitSession = getIntent().getBooleanExtra("isExitSession", false);
        this.isBackShowEvaluate = getIntent().getBooleanExtra("isBackShowEvaluate", false);
        this.initModel = (ZhiChiInitModeBase) getIntent().getSerializableExtra("initModel");
        this.current_model = getIntent().getIntExtra("current_model", 0);
        this.commentType = getIntent().getIntExtra("commentType", 0);
        this.customName = getIntent().getStringExtra("customName");
        this.isSolve = getIntent().getIntExtra("isSolve", 0);
        Button button = (Button) findViewById(getResId(ZhiChiConstants.sobot_close_now));
        this.sobot_close_now = button;
        button.setText(ResourceUtils.getResString(this.context, "sobot_btn_submit_text"));
        this.sobot_readiogroup = (RadioGroup) findViewById(getResId("sobot_readiogroup"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_evaluate_title"));
        this.sobot_tv_evaluate_title = textView;
        textView.setText(ResourceUtils.getResString(this.context, "sobot_robot_customer_service_evaluation"));
        TextView textView2 = (TextView) findViewById(getResId("sobot_robot_center_title"));
        this.sobot_robot_center_title = textView2;
        textView2.setText(ResourceUtils.getResString(this.context, "sobot_question"));
        this.sobot_text_other_problem = (TextView) findViewById(getResId("sobot_text_other_problem"));
        TextView textView3 = (TextView) findViewById(getResId("sobot_custom_center_title"));
        this.sobot_custom_center_title = textView3;
        textView3.setText(ResourceUtils.getResString(this.context, "sobot_please_evaluate"));
        TextView textView4 = (TextView) findViewById(getResId("sobot_ratingBar_title"));
        this.sobot_ratingBar_title = textView4;
        textView4.setText(ResourceUtils.getResString(this.context, "sobot_great_satisfaction"));
        this.sobot_tv_evaluate_title_hint = (TextView) findViewById(getResId("sobot_tv_evaluate_title_hint"));
        TextView textView5 = (TextView) findViewById(getResId("sobot_evaluate_cancel"));
        this.sobot_evaluate_cancel = textView5;
        textView5.setText(ResourceUtils.getResString(this.context, "sobot_temporarily_not_evaluation"));
        this.sobot_ratingBar_split_view = findViewById(ResourceUtils.getIdByName(this.context, "id", "sobot_ratingBar_split_view"));
        LinearLayout linearLayout = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        this.sobot_negativeButton = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.dialog.SobotEvaluateActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotEvaluateActivity.this.finish();
            }
        });
        Information information = this.information;
        if (information == null || !information.isCanBackWithNotEvaluation()) {
            this.sobot_evaluate_cancel.setVisibility(8);
        } else {
            this.sobot_evaluate_cancel.setVisibility(0);
        }
        this.sobot_ratingBar = (RatingBar) findViewById(getResId("sobot_ratingBar"));
        this.sobot_ten_root_ll = (LinearLayout) findViewById(getResId("sobot_ten_root_ll"));
        this.sobot_ten_rating_ll = (SobotTenRatingLayout) findViewById(getResId("sobot_ten_rating_ll"));
        this.sobot_ten_very_dissatisfied = (TextView) findViewById(getResId("sobot_ten_very_dissatisfied"));
        this.sobot_ten_very_satisfaction = (TextView) findViewById(getResId("sobot_ten_very_satisfaction"));
        this.sobot_ten_very_dissatisfied.setText(ResourceUtils.getResString(this.context, "sobot_very_dissatisfied"));
        this.sobot_ten_very_satisfaction.setText(ResourceUtils.getResString(this.context, "sobot_great_satisfaction"));
        this.sobot_evaluate_lable_autoline = (SobotAntoLineLayout) findViewById(getResId("sobot_evaluate_lable_autoline"));
        EditText editText = (EditText) findViewById(getResId("sobot_add_content"));
        this.sobot_add_content = editText;
        editText.setHint(ResourceUtils.getResString(this.context, "sobot_edittext_hint"));
        RadioButton radioButton = (RadioButton) findViewById(getResId("sobot_btn_ok_robot"));
        this.sobot_btn_ok_robot = radioButton;
        radioButton.setText(ResourceUtils.getResString(this.context, "sobot_evaluate_yes"));
        this.sobot_btn_ok_robot.setChecked(true);
        RadioButton radioButton2 = (RadioButton) findViewById(getResId("sobot_btn_no_robot"));
        this.sobot_btn_no_robot = radioButton2;
        radioButton2.setText(ResourceUtils.getResString(this.context, "sobot_evaluate_no"));
        this.sobot_robot_relative = (LinearLayout) findViewById(getResId("sobot_robot_relative"));
        this.sobot_custom_relative = (LinearLayout) findViewById(getResId("sobot_custom_relative"));
        this.sobot_hide_layout = (LinearLayout) findViewById(getResId("sobot_hide_layout"));
        this.setl_submit_content = (SobotEditTextLayout) findViewById(getResId("setl_submit_content"));
        setViewGone();
        setViewListener();
        if (ScreenUtils.isFullScreen(this.context)) {
            getWindow().setLayout(-1, -1);
        }
        displayInNotch(this.setl_submit_content);
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        HttpUtils.getInstance().cancelTag(this.CANCEL_TAG);
        super.onDetachedFromWindow();
    }
}
