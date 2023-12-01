package com.sobot.chat.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.ResultCallBack;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SatisfactionSet;
import com.sobot.chat.api.model.SatisfactionSetBase;
import com.sobot.chat.api.model.SobotEvaluateModel;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.notchlib.utils.ScreenUtil;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import com.sobot.chat.widget.SobotAntoLineLayout;
import com.sobot.chat.widget.SobotTenRatingLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/CusEvaluateMessageHolder.class */
public class CusEvaluateMessageHolder extends MessageHolderBase implements RadioGroup.OnCheckedChangeListener, RatingBar.OnRatingBarChangeListener {
    private List<CheckBox> checkBoxList;
    private int deftaultScore;
    Information information;
    public ZhiChiMessageBase message;
    private int ratingType;
    private List<SatisfactionSetBase> satisFactionList;
    SobotEvaluateModel sobotEvaluateModel;
    RadioButton sobot_btn_no_robot;
    RadioButton sobot_btn_ok_robot;
    TextView sobot_center_title;
    private SobotAntoLineLayout sobot_evaluate_lable_autoline;
    private LinearLayout sobot_hide_layout;
    RatingBar sobot_ratingBar;
    View sobot_ratingBar_split_view;
    TextView sobot_ratingBar_title;
    RadioGroup sobot_readiogroup;
    TextView sobot_submit;
    private SobotTenRatingLayout sobot_ten_rating_ll;
    private LinearLayout sobot_ten_root_ll;
    private TextView sobot_ten_very_dissatisfied;
    private TextView sobot_ten_very_satisfaction;
    TextView sobot_tv_star_title;

    public CusEvaluateMessageHolder(Context context, View view) {
        super(context, view);
        this.checkBoxList = new ArrayList();
        this.deftaultScore = 0;
        this.sobot_center_title = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_center_title"));
        this.sobot_readiogroup = (RadioGroup) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_readiogroup"));
        RadioButton radioButton = (RadioButton) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_btn_ok_robot"));
        this.sobot_btn_ok_robot = radioButton;
        radioButton.setText(ResourceUtils.getResString(context, "sobot_evaluate_yes"));
        RadioButton radioButton2 = (RadioButton) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_btn_no_robot"));
        this.sobot_btn_no_robot = radioButton2;
        radioButton2.setText(ResourceUtils.getResString(context, "sobot_evaluate_no"));
        TextView textView = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_star_title"));
        this.sobot_tv_star_title = textView;
        textView.setText(ResourceUtils.getResString(context, "sobot_please_evaluate"));
        this.sobot_ratingBar = (RatingBar) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ratingBar"));
        this.sobot_ten_root_ll = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ten_root_ll"));
        this.sobot_ten_very_dissatisfied = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ten_very_dissatisfied"));
        this.sobot_ten_very_satisfaction = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ten_very_satisfaction"));
        this.sobot_ten_very_dissatisfied.setText(ResourceUtils.getResString(context, "sobot_very_dissatisfied"));
        this.sobot_ten_very_satisfaction.setText(ResourceUtils.getResString(context, "sobot_great_satisfaction"));
        this.sobot_ten_rating_ll = (SobotTenRatingLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ten_rating_ll"));
        TextView textView2 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_submit"));
        this.sobot_submit = textView2;
        textView2.setText(ResourceUtils.getResString(context, "sobot_btn_submit_text"));
        this.sobot_ratingBar_split_view = view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ratingBar_split_view"));
        this.sobot_btn_ok_robot.setSelected(true);
        TextView textView3 = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_ratingBar_title"));
        this.sobot_ratingBar_title = textView3;
        textView3.setText(ResourceUtils.getResString(context, "sobot_great_satisfaction"));
        this.sobot_hide_layout = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_hide_layout"));
        this.sobot_evaluate_lable_autoline = (SobotAntoLineLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_evaluate_lable_autoline"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String checkBoxIsChecked() {
        String str = new String();
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

    private void checkQuestionFlag() {
        SobotEvaluateModel sobotEvaluateModel = this.sobotEvaluateModel;
        if (sobotEvaluateModel == null) {
            return;
        }
        if (ChatUtils.isQuestionFlag(sobotEvaluateModel)) {
            this.sobot_center_title.setVisibility(0);
            this.sobot_readiogroup.setVisibility(0);
            this.sobot_ratingBar_split_view.setVisibility(0);
            return;
        }
        this.sobot_center_title.setVisibility(8);
        this.sobot_readiogroup.setVisibility(8);
        this.sobot_ratingBar_split_view.setVisibility(8);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(ResourceUtils.getResLayoutId(this.mContext, "sobot_layout_evaluate_item"), (ViewGroup) null);
            CheckBox checkBox = (CheckBox) inflate.findViewById(ResourceUtils.getResId(this.mContext, "sobot_evaluate_cb_lable"));
            checkBox.setMinWidth((ScreenUtil.getScreenSize(this.mContext)[0] - ScreenUtils.dip2px(this.mContext, 116.0f)) / 2);
            checkBox.setText(strArr[i2]);
            sobotAntoLineLayout.addView(inflate);
            this.checkBoxList.add(checkBox);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
        if (r4.message.getSobotEvaluateModel().getScore() == 5) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doEvaluate(boolean r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            android.content.Context r0 = r0.mContext
            if (r0 == 0) goto Lac
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Lac
            r0 = r9
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            if (r0 == 0) goto Lac
            r0 = r4
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.sobotEvaluateModel
            int r0 = r0.getIsResolved()
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            boolean r0 = com.sobot.chat.utils.ChatUtils.isQuestionFlag(r0)
            if (r0 == 0) goto L65
            r0 = r4
            android.widget.RadioButton r0 = r0.sobot_btn_ok_robot
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L42
        L3d:
            r0 = 0
            r7 = r0
            goto L65
        L42:
            r0 = r4
            android.widget.RadioButton r0 = r0.sobot_btn_no_robot
            boolean r0 = r0.isChecked()
            if (r0 == 0) goto L51
            r0 = 1
            r7 = r0
            goto L65
        L51:
            r0 = r8
            r7 = r0
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            int r0 = r0.getScore()
            r1 = 5
            if (r0 != r1) goto L65
            goto L3d
        L65:
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            r1 = r7
            r0.setIsResolved(r1)
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            r1 = r6
            r0.setScore(r1)
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            r1 = r4
            int r1 = r1.ratingType
            r0.setScoreFlag(r1)
            r0 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r0 = r0.message
            com.sobot.chat.api.model.SobotEvaluateModel r0 = r0.getSobotEvaluateModel()
            r1 = r4
            java.lang.String r1 = r1.checkBoxIsChecked()
            r0.setProblem(r1)
            r0 = r4
            com.sobot.chat.adapter.SobotMsgAdapter$SobotMsgCallBack r0 = r0.msgCallBack
            if (r0 == 0) goto Lac
            r0 = r4
            com.sobot.chat.adapter.SobotMsgAdapter$SobotMsgCallBack r0 = r0.msgCallBack
            r1 = r5
            r2 = r4
            com.sobot.chat.api.model.ZhiChiMessageBase r2 = r2.message
            r0.doEvaluate(r1, r2)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.viewHolder.CusEvaluateMessageHolder.doEvaluate(boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SatisfactionSetBase getSatisFaction(int i, List<SatisfactionSetBase> list) {
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

    private void setEvaluatedLayout() {
        if (this.sobot_readiogroup.getVisibility() == 0) {
            if (this.sobotEvaluateModel.getIsResolved() == -1) {
                this.sobot_btn_ok_robot.setChecked(false);
                this.sobot_btn_no_robot.setChecked(false);
                this.sobot_btn_ok_robot.setVisibility(0);
                this.sobot_btn_no_robot.setVisibility(0);
            } else if (this.sobotEvaluateModel.getIsResolved() == 0) {
                this.sobot_btn_ok_robot.setChecked(true);
                this.sobot_btn_no_robot.setChecked(false);
                this.sobot_btn_ok_robot.setVisibility(0);
                this.sobot_btn_no_robot.setVisibility(8);
            } else {
                this.sobot_btn_ok_robot.setChecked(false);
                this.sobot_btn_no_robot.setChecked(true);
                this.sobot_btn_ok_robot.setVisibility(8);
                this.sobot_btn_no_robot.setVisibility(0);
            }
        }
        this.sobot_ratingBar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLableViewVisible(String[] strArr) {
        if (strArr == null) {
            this.sobot_hide_layout.setVisibility(8);
            return;
        }
        if (this.information.isHideManualEvaluationLabels()) {
            this.sobot_hide_layout.setVisibility(8);
        } else {
            this.sobot_hide_layout.setVisibility(0);
        }
        createChildLableView(this.sobot_evaluate_lable_autoline, strArr);
    }

    private void setNotEvaluatedLayout() {
        if (this.sobotEvaluateModel == null) {
            return;
        }
        if (this.sobot_readiogroup.getVisibility() == 0) {
            if (this.sobotEvaluateModel.getIsResolved() == -1) {
                this.sobot_btn_ok_robot.setChecked(false);
                this.sobot_btn_no_robot.setChecked(false);
                this.sobot_btn_ok_robot.setVisibility(0);
                this.sobot_btn_no_robot.setVisibility(0);
            } else if (this.sobotEvaluateModel.getIsResolved() == 0) {
                this.sobot_btn_ok_robot.setChecked(true);
                this.sobot_btn_no_robot.setChecked(false);
                this.sobot_btn_ok_robot.setVisibility(0);
                this.sobot_btn_no_robot.setVisibility(0);
            } else {
                this.sobot_btn_ok_robot.setChecked(false);
                this.sobot_btn_no_robot.setChecked(true);
                this.sobot_btn_ok_robot.setVisibility(0);
                this.sobot_btn_no_robot.setVisibility(0);
            }
        }
        this.sobot_ratingBar.setEnabled(true);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(final Context context, ZhiChiMessageBase zhiChiMessageBase) {
        Information information = (Information) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_info);
        this.information = information;
        if (information.isHideManualEvaluationLabels()) {
            this.sobot_ratingBar_title.setVisibility(8);
        } else {
            this.sobot_ratingBar_title.setVisibility(0);
        }
        this.sobot_submit.setVisibility(8);
        this.message = zhiChiMessageBase;
        this.sobotEvaluateModel = zhiChiMessageBase.getSobotEvaluateModel();
        List<SatisfactionSetBase> list = this.satisFactionList;
        if (list == null || list.size() == 0) {
            SobotMsgManager.getInstance(context).getZhiChiApi().satisfactionMessage(this, ((ZhiChiInitModeBase) SharedPreferencesUtil.getObject(context, ZhiChiConstant.sobot_last_current_initModel)).getPartnerid(), new ResultCallBack<SatisfactionSet>() { // from class: com.sobot.chat.viewHolder.CusEvaluateMessageHolder.1
                @Override // com.sobot.chat.api.ResultCallBack
                public void onFailure(Exception exc, String str) {
                    CusEvaluateMessageHolder.this.sobot_submit.setVisibility(8);
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onLoading(long j, long j2, boolean z) {
                }

                @Override // com.sobot.chat.api.ResultCallBack
                public void onSuccess(SatisfactionSet satisfactionSet) {
                    CusEvaluateMessageHolder.this.sobot_submit.setVisibility(0);
                    if (satisfactionSet == null || !"1".equals(satisfactionSet.getCode()) || satisfactionSet.getData() == null || satisfactionSet.getData().size() == 0) {
                        return;
                    }
                    CusEvaluateMessageHolder.this.satisFactionList = satisfactionSet.getData();
                    int i = 5;
                    if (((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(0)).getScoreFlag() == 0) {
                        if (CusEvaluateMessageHolder.this.satisFactionList.get(0) != null) {
                            if (((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(0)).getDefaultType() != 0) {
                                i = 0;
                            }
                            CusEvaluateMessageHolder.this.deftaultScore = i;
                        } else {
                            i = 0;
                        }
                        CusEvaluateMessageHolder.this.sobotEvaluateModel.setScore(CusEvaluateMessageHolder.this.deftaultScore);
                        CusEvaluateMessageHolder.this.sobot_ratingBar.setRating(CusEvaluateMessageHolder.this.deftaultScore);
                        CusEvaluateMessageHolder.this.sobot_ten_root_ll.setVisibility(8);
                        CusEvaluateMessageHolder.this.sobot_ratingBar.setVisibility(0);
                        CusEvaluateMessageHolder.this.ratingType = 0;
                    } else {
                        CusEvaluateMessageHolder.this.sobot_ten_root_ll.setVisibility(0);
                        CusEvaluateMessageHolder.this.sobot_ratingBar.setVisibility(8);
                        CusEvaluateMessageHolder.this.ratingType = 1;
                        if (((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(0)).getDefaultType() == 2) {
                            i = 0;
                        } else if (((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(0)).getDefaultType() != 1) {
                            i = 10;
                        }
                        CusEvaluateMessageHolder.this.deftaultScore = i;
                        CusEvaluateMessageHolder.this.sobotEvaluateModel.setScore(CusEvaluateMessageHolder.this.deftaultScore);
                        CusEvaluateMessageHolder.this.sobot_ten_rating_ll.removeAllViews();
                        CusEvaluateMessageHolder.this.sobot_ten_rating_ll.init(i, false);
                    }
                    if (CusEvaluateMessageHolder.this.ratingType != 0) {
                        if (CusEvaluateMessageHolder.this.information.isHideManualEvaluationLabels()) {
                            CusEvaluateMessageHolder.this.sobot_hide_layout.setVisibility(8);
                        } else {
                            CusEvaluateMessageHolder.this.sobot_hide_layout.setVisibility(0);
                        }
                        CusEvaluateMessageHolder.this.sobot_submit.setVisibility(0);
                        CusEvaluateMessageHolder.this.sobot_ratingBar_title.setText(((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(CusEvaluateMessageHolder.this.deftaultScore)).getScoreExplain());
                        TextView textView = CusEvaluateMessageHolder.this.sobot_ratingBar_title;
                        Context context2 = context;
                        textView.setTextColor(ContextCompat.getColor(context2, ResourceUtils.getResColorId(context2, "sobot_color_evaluate_ratingBar_des_tv")));
                    } else if (i == 0) {
                        CusEvaluateMessageHolder.this.sobot_hide_layout.setVisibility(8);
                        CusEvaluateMessageHolder.this.sobot_submit.setVisibility(8);
                        CusEvaluateMessageHolder.this.sobot_ratingBar_title.setText(ResourceUtils.getResString(context, "sobot_evaluate_zero_score_des"));
                        TextView textView2 = CusEvaluateMessageHolder.this.sobot_ratingBar_title;
                        Context context3 = context;
                        textView2.setTextColor(ContextCompat.getColor(context3, ResourceUtils.getResColorId(context3, "sobot_common_gray3")));
                    } else {
                        if (CusEvaluateMessageHolder.this.information.isHideManualEvaluationLabels()) {
                            CusEvaluateMessageHolder.this.sobot_hide_layout.setVisibility(8);
                        } else {
                            CusEvaluateMessageHolder.this.sobot_hide_layout.setVisibility(0);
                        }
                        CusEvaluateMessageHolder.this.sobot_submit.setVisibility(0);
                        CusEvaluateMessageHolder.this.sobot_ratingBar_title.setText(((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(4)).getScoreExplain());
                        TextView textView3 = CusEvaluateMessageHolder.this.sobot_ratingBar_title;
                        Context context4 = context;
                        textView3.setTextColor(ContextCompat.getColor(context4, ResourceUtils.getResColorId(context4, "sobot_color_evaluate_ratingBar_des_tv")));
                    }
                    CusEvaluateMessageHolder cusEvaluateMessageHolder = CusEvaluateMessageHolder.this;
                    SatisfactionSetBase satisFaction = cusEvaluateMessageHolder.getSatisFaction(i, cusEvaluateMessageHolder.satisFactionList);
                    if (satisFaction == null || TextUtils.isEmpty(satisFaction.getLabelName())) {
                        CusEvaluateMessageHolder.this.setLableViewVisible(null);
                        return;
                    }
                    CusEvaluateMessageHolder.this.setLableViewVisible(CusEvaluateMessageHolder.convertStrToArray(satisFaction.getLabelName()));
                }
            });
        }
        TextView textView = this.sobot_center_title;
        textView.setText(zhiChiMessageBase.getSenderName() + " " + ChatUtils.getResString(context, "sobot_question"));
        TextView textView2 = this.sobot_tv_star_title;
        textView2.setText(zhiChiMessageBase.getSenderName() + " " + ChatUtils.getResString(context, "sobot_please_evaluate"));
        checkQuestionFlag();
        refreshItem();
        this.sobot_readiogroup.setOnCheckedChangeListener(this);
        this.sobot_ratingBar.setOnRatingBarChangeListener(this);
        this.sobot_submit.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.viewHolder.CusEvaluateMessageHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (CusEvaluateMessageHolder.this.ratingType == 0) {
                    if (CusEvaluateMessageHolder.this.satisFactionList != null && CusEvaluateMessageHolder.this.satisFactionList.size() == 5 && ((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(4)).getIsInputMust()) {
                        CusEvaluateMessageHolder cusEvaluateMessageHolder = CusEvaluateMessageHolder.this;
                        cusEvaluateMessageHolder.doEvaluate(false, cusEvaluateMessageHolder.deftaultScore);
                        return;
                    } else if (TextUtils.isEmpty(CusEvaluateMessageHolder.this.checkBoxIsChecked()) && CusEvaluateMessageHolder.this.satisFactionList != null && CusEvaluateMessageHolder.this.satisFactionList.size() == 5 && ((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(4)).getIsTagMust() && !TextUtils.isEmpty(((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(4)).getLabelName()) && !CusEvaluateMessageHolder.this.information.isHideManualEvaluationLabels()) {
                        ToastUtil.showToast(CusEvaluateMessageHolder.this.mContext, ResourceUtils.getResString(CusEvaluateMessageHolder.this.mContext, "sobot_the_label_is_required"));
                        return;
                    }
                } else if (CusEvaluateMessageHolder.this.satisFactionList != null && CusEvaluateMessageHolder.this.satisFactionList.size() == 11 && ((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(CusEvaluateMessageHolder.this.deftaultScore)).getIsInputMust()) {
                    CusEvaluateMessageHolder cusEvaluateMessageHolder2 = CusEvaluateMessageHolder.this;
                    cusEvaluateMessageHolder2.doEvaluate(false, cusEvaluateMessageHolder2.deftaultScore);
                    return;
                } else if (TextUtils.isEmpty(CusEvaluateMessageHolder.this.checkBoxIsChecked()) && CusEvaluateMessageHolder.this.satisFactionList != null && CusEvaluateMessageHolder.this.satisFactionList.size() == 11 && ((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(CusEvaluateMessageHolder.this.deftaultScore)).getIsTagMust() && !TextUtils.isEmpty(((SatisfactionSetBase) CusEvaluateMessageHolder.this.satisFactionList.get(CusEvaluateMessageHolder.this.deftaultScore)).getLabelName()) && !CusEvaluateMessageHolder.this.information.isHideManualEvaluationLabels()) {
                    ToastUtil.showToast(CusEvaluateMessageHolder.this.mContext, ResourceUtils.getResString(CusEvaluateMessageHolder.this.mContext, "sobot_the_label_is_required"));
                    return;
                }
                CusEvaluateMessageHolder cusEvaluateMessageHolder3 = CusEvaluateMessageHolder.this;
                cusEvaluateMessageHolder3.doEvaluate(true, cusEvaluateMessageHolder3.deftaultScore);
            }
        });
        this.sobot_ten_rating_ll.setOnClickItemListener(new SobotTenRatingLayout.OnClickItemListener() { // from class: com.sobot.chat.viewHolder.CusEvaluateMessageHolder.3
            @Override // com.sobot.chat.widget.SobotTenRatingLayout.OnClickItemListener
            public void onClickItem(int i) {
                if (CusEvaluateMessageHolder.this.sobotEvaluateModel == null || CusEvaluateMessageHolder.this.sobotEvaluateModel.getEvaluateStatus() != 0 || i <= 0 || CusEvaluateMessageHolder.this.deftaultScore == i) {
                    return;
                }
                CusEvaluateMessageHolder.this.sobotEvaluateModel.setScore(i);
                CusEvaluateMessageHolder.this.doEvaluate(false, i);
            }
        });
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Tracker.onCheckedChanged(radioGroup, i);
        if (this.sobotEvaluateModel == null) {
            return;
        }
        if (i == this.sobot_btn_ok_robot.getId()) {
            this.sobotEvaluateModel.setIsResolved(0);
            this.sobot_btn_ok_robot.setChecked(true);
            this.sobot_btn_no_robot.setChecked(false);
            this.sobot_btn_ok_robot.setSelected(true);
            this.sobot_btn_no_robot.setSelected(false);
        }
        if (i == this.sobot_btn_no_robot.getId()) {
            this.sobotEvaluateModel.setIsResolved(1);
            this.sobot_btn_ok_robot.setChecked(false);
            this.sobot_btn_no_robot.setChecked(true);
            this.sobot_btn_ok_robot.setSelected(false);
            this.sobot_btn_no_robot.setSelected(true);
        }
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        Tracker.onRatingChanged(ratingBar, f, z);
        LogUtils.i(this.sobotEvaluateModel.getScore() + "-----" + this.deftaultScore + "=====" + f);
        SobotEvaluateModel sobotEvaluateModel = this.sobotEvaluateModel;
        if (sobotEvaluateModel == null || sobotEvaluateModel.getEvaluateStatus() != 0 || f <= 0.0f) {
            return;
        }
        double d = f;
        if (this.deftaultScore != ((int) Math.ceil(d))) {
            int ceil = (int) Math.ceil(d);
            this.sobotEvaluateModel.setScore(ceil);
            this.sobot_ratingBar.setOnRatingBarChangeListener(null);
            this.sobot_ratingBar.setRating(this.deftaultScore);
            this.sobot_ratingBar.setOnRatingBarChangeListener(this);
            doEvaluate(false, ceil);
        }
    }

    public void refreshItem() {
        SobotEvaluateModel sobotEvaluateModel = this.sobotEvaluateModel;
        if (sobotEvaluateModel == null) {
            return;
        }
        if (sobotEvaluateModel.getEvaluateStatus() == 0) {
            setNotEvaluatedLayout();
            if (this.satisFactionList != null) {
                this.sobot_submit.setVisibility(0);
            }
        } else if (1 == this.sobotEvaluateModel.getEvaluateStatus()) {
            setEvaluatedLayout();
            this.sobot_submit.setVisibility(8);
        }
    }
}
