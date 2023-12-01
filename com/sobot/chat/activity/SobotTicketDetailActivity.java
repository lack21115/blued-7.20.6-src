package com.sobot.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.adapter.SobotTicketDetailAdapter;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.StUserDealTicketInfo;
import com.sobot.chat.api.model.ZhiChiUploadAppFileModelResult;
import com.sobot.chat.utils.CustomToast;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.StringUtils;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.dialog.SobotReplyActivity;
import com.sobot.chat.widget.dialog.SobotTicketEvaluateActivity;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotTicketDetailActivity.class */
public class SobotTicketDetailActivity extends SobotBaseActivity implements View.OnClickListener {
    public static final String INTENT_KEY_COMPANYID = "intent_key_companyid";
    public static final String INTENT_KEY_TICKET_INFO = "intent_key_ticket_info";
    public static final String INTENT_KEY_UID = "intent_key_uid";
    private static final int REQUEST_REPLY_CODE = 4097;
    private int infoFlag;
    private Information information;
    private SobotTicketDetailAdapter mAdapter;
    private SobotUserTicketEvaluate mEvaluate;
    private ListView mListView;
    private SobotUserTicketInfo mTicketInfo;
    private String replyTempContent;
    private LinearLayout sobot_evaluate_ll;
    private TextView sobot_evaluate_tv;
    private LinearLayout sobot_reply_ll;
    private TextView sobot_reply_tv;
    private String mUid = "";
    private String mCompanyId = "";
    private List<Object> mList = new ArrayList();
    private ArrayList<ZhiChiUploadAppFileModelResult> pic_list = new ArrayList<>();

    public static Intent newIntent(Context context, String str, String str2, SobotUserTicketInfo sobotUserTicketInfo) {
        Intent intent = new Intent(context, SobotTicketDetailActivity.class);
        intent.putExtra("intent_key_uid", str2);
        intent.putExtra("intent_key_companyid", str);
        intent.putExtra(INTENT_KEY_TICKET_INFO, sobotUserTicketInfo);
        return intent;
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_ticket_detail");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (getIntent() != null) {
            this.mUid = getIntent().getStringExtra("intent_key_uid");
            this.mCompanyId = getIntent().getStringExtra("intent_key_companyid");
            SobotUserTicketInfo sobotUserTicketInfo = (SobotUserTicketInfo) getIntent().getSerializableExtra(INTENT_KEY_TICKET_INFO);
            this.mTicketInfo = sobotUserTicketInfo;
            if (sobotUserTicketInfo != null) {
                this.infoFlag = sobotUserTicketInfo.getFlag();
            }
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        this.information = (Information) SharedPreferencesUtil.getObject(this, ZhiChiConstant.sobot_last_current_info);
        this.sobot_evaluate_ll.setVisibility(8);
        this.sobot_reply_ll.setVisibility(8);
        if (this.mTicketInfo == null) {
            return;
        }
        this.zhiChiApi.getUserDealTicketInfoList(this, this.mUid, this.mCompanyId, this.mTicketInfo.getTicketId(), new StringResultCallBack<List<StUserDealTicketInfo>>() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.3
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                ToastUtil.showToast(SobotTicketDetailActivity.this, str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<StUserDealTicketInfo> list) {
                ZhiChiApi zhiChiApi = SobotTicketDetailActivity.this.zhiChiApi;
                SobotTicketDetailActivity sobotTicketDetailActivity = SobotTicketDetailActivity.this;
                zhiChiApi.updateUserTicketReplyInfo(sobotTicketDetailActivity, sobotTicketDetailActivity.mCompanyId, SobotTicketDetailActivity.this.information.getPartnerid(), SobotTicketDetailActivity.this.mTicketInfo.getTicketId());
                if (list == null || list.size() <= 0) {
                    return;
                }
                SobotTicketDetailActivity.this.mList.clear();
                Iterator<StUserDealTicketInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StUserDealTicketInfo next = it.next();
                    if (next.getFlag() == 1) {
                        SobotTicketDetailActivity.this.mTicketInfo.setFileList(next.getFileList());
                        SobotTicketDetailActivity.this.mTicketInfo.setContent(next.getContent());
                        if (StringUtils.isEmpty(SobotTicketDetailActivity.this.mTicketInfo.getTimeStr())) {
                            SobotTicketDetailActivity.this.mTicketInfo.setTimeStr(next.getTimeStr());
                        }
                    }
                }
                SobotTicketDetailActivity.this.mList.add(SobotTicketDetailActivity.this.mTicketInfo);
                SobotTicketDetailActivity.this.mList.addAll(list);
                Iterator<StUserDealTicketInfo> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    StUserDealTicketInfo next2 = it2.next();
                    if (next2.getFlag() == 3 && SobotTicketDetailActivity.this.mTicketInfo.getFlag() != 3) {
                        SobotTicketDetailActivity.this.mTicketInfo.setFlag(3);
                    }
                    if (SobotTicketDetailActivity.this.mTicketInfo.getFlag() != 3 && SobotTicketDetailActivity.this.mTicketInfo.getFlag() < next2.getFlag()) {
                        SobotTicketDetailActivity.this.mTicketInfo.setFlag(next2.getFlag());
                    }
                    if (next2.getFlag() == 3 && next2.getEvaluate() != null) {
                        SobotTicketDetailActivity.this.mList.add(next2.getEvaluate());
                        SobotTicketDetailActivity.this.mEvaluate = next2.getEvaluate();
                        if (!SobotTicketDetailActivity.this.mEvaluate.isOpen()) {
                            SobotTicketDetailActivity.this.sobot_evaluate_ll.setVisibility(8);
                        } else if (!SobotTicketDetailActivity.this.mEvaluate.isEvalution()) {
                            SobotTicketDetailActivity.this.sobot_evaluate_ll.setVisibility(0);
                            break;
                        } else {
                            SobotTicketDetailActivity.this.sobot_evaluate_ll.setVisibility(8);
                        }
                    }
                }
                if (SobotTicketDetailActivity.this.mAdapter == null) {
                    SobotTicketDetailActivity sobotTicketDetailActivity2 = SobotTicketDetailActivity.this;
                    SobotTicketDetailActivity sobotTicketDetailActivity3 = SobotTicketDetailActivity.this;
                    sobotTicketDetailActivity2.mAdapter = new SobotTicketDetailAdapter(sobotTicketDetailActivity3, sobotTicketDetailActivity3, sobotTicketDetailActivity3.mList);
                    SobotTicketDetailActivity.this.mListView.setAdapter((ListAdapter) SobotTicketDetailActivity.this.mAdapter);
                } else {
                    SobotTicketDetailActivity.this.mAdapter.notifyDataSetChanged();
                }
                if (SobotApi.getSwitchMarkStatus(2) || SobotTicketDetailActivity.this.mTicketInfo.getFlag() != 3) {
                    SobotTicketDetailActivity.this.sobot_reply_ll.setVisibility(0);
                } else {
                    SobotTicketDetailActivity.this.sobot_reply_ll.setVisibility(8);
                }
            }
        });
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        getLeftMenu().setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                List list = (List) SharedPreferencesUtil.getObject(SobotTicketDetailActivity.this, "showBackEvaluateTicketIds");
                if (SobotTicketDetailActivity.this.information == null || !SobotTicketDetailActivity.this.information.isShowLeaveDetailBackEvaluate() || SobotTicketDetailActivity.this.sobot_evaluate_ll.getVisibility() != 0) {
                    SobotTicketDetailActivity.this.finish();
                } else if (list != null && list.contains(SobotTicketDetailActivity.this.mTicketInfo.getTicketId())) {
                    SobotTicketDetailActivity.this.finish();
                } else {
                    ArrayList arrayList = list;
                    if (list == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(SobotTicketDetailActivity.this.mTicketInfo.getTicketId());
                    SharedPreferencesUtil.saveObject(SobotTicketDetailActivity.this, "showBackEvaluateTicketIds", arrayList);
                    Intent intent = new Intent(SobotTicketDetailActivity.this, SobotTicketEvaluateActivity.class);
                    intent.putExtra("sobotUserTicketEvaluate", SobotTicketDetailActivity.this.mEvaluate);
                    SobotTicketDetailActivity.this.startActivityForResult(intent, 1111);
                }
            }
        });
        setTitle(getResString("sobot_message_details"));
        this.mListView = (ListView) findViewById(getResId("sobot_listview"));
        this.sobot_evaluate_ll = (LinearLayout) findViewById(getResId("sobot_evaluate_ll"));
        this.sobot_reply_ll = (LinearLayout) findViewById(getResId("sobot_reply_ll"));
        TextView textView = (TextView) findViewById(getResId("sobot_evaluate_tv"));
        this.sobot_evaluate_tv = textView;
        textView.setText(ResourceUtils.getResString(this, "sobot_str_bottom_satisfaction"));
        TextView textView2 = (TextView) findViewById(getResId("sobot_reply_tv"));
        this.sobot_reply_tv = textView2;
        textView2.setText(ResourceUtils.getResString(this, "sobot_reply"));
        this.sobot_reply_ll.setOnClickListener(this);
        this.sobot_evaluate_ll.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (view != SobotTicketDetailActivity.this.sobot_evaluate_ll || SobotTicketDetailActivity.this.mEvaluate == null) {
                    return;
                }
                Intent intent = new Intent(SobotTicketDetailActivity.this, SobotTicketEvaluateActivity.class);
                intent.putExtra("sobotUserTicketEvaluate", SobotTicketDetailActivity.this.mEvaluate);
                SobotTicketDetailActivity.this.startActivityForResult(intent, 1109);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 4097) {
                if (intent != null) {
                    z = intent.getBooleanExtra("isTemp", false);
                    this.replyTempContent = intent.getStringExtra("replyTempContent");
                    this.pic_list = (ArrayList) intent.getSerializableExtra("picTempList");
                } else {
                    z = false;
                }
                if (!z) {
                    initData();
                }
            }
            if (i == 1109) {
                submitEvaluate(intent.getIntExtra(WBConstants.GAME_PARAMS_SCORE, 0), intent.getStringExtra("content"));
            }
            if (i == 1111) {
                final int intExtra = intent.getIntExtra(WBConstants.GAME_PARAMS_SCORE, 0);
                final String stringExtra = intent.getStringExtra("content");
                this.zhiChiApi.addTicketSatisfactionScoreInfo(this, this.mUid, this.mCompanyId, this.mTicketInfo.getTicketId(), intExtra, stringExtra, new StringResultCallBack<String>() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.5
                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onFailure(Exception exc, String str) {
                        ToastUtil.showToast(SobotTicketDetailActivity.this.getApplicationContext(), str);
                    }

                    @Override // com.sobot.network.http.callback.StringResultCallBack
                    public void onSuccess(String str) {
                        SobotTicketDetailActivity.this.sobot_evaluate_ll.setVisibility(8);
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= SobotTicketDetailActivity.this.mList.size()) {
                                break;
                            }
                            if (SobotTicketDetailActivity.this.mList.get(i4) instanceof StUserDealTicketInfo) {
                                StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) SobotTicketDetailActivity.this.mList.get(i4);
                                if (stUserDealTicketInfo.getFlag() == 3 && stUserDealTicketInfo.getEvaluate() != null) {
                                    SobotUserTicketEvaluate evaluate = stUserDealTicketInfo.getEvaluate();
                                    evaluate.setScore(intExtra);
                                    evaluate.setRemark(stringExtra);
                                    evaluate.setEvalution(true);
                                    SobotTicketDetailActivity.this.mAdapter.notifyDataSetChanged();
                                    break;
                                }
                            }
                            i3 = i4 + 1;
                        }
                        SobotTicketDetailActivity.this.removeTicketId();
                        SobotTicketDetailActivity sobotTicketDetailActivity = SobotTicketDetailActivity.this;
                        ToastUtil.showCustomToastWithListenr(sobotTicketDetailActivity, ResourceUtils.getResString(sobotTicketDetailActivity, "sobot_leavemsg_success_tip"), 1000L, new ToastUtil.OnAfterShowListener() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.5.1
                            @Override // com.sobot.chat.utils.ToastUtil.OnAfterShowListener
                            public void doAfter() {
                                SobotTicketDetailActivity.this.finish();
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        List list = (List) SharedPreferencesUtil.getObject(this, "showBackEvaluateTicketIds");
        Information information = this.information;
        if (information == null || !information.isShowLeaveDetailBackEvaluate() || this.sobot_evaluate_ll.getVisibility() != 0 || (list != null && list.contains(this.mTicketInfo.getTicketId()))) {
            SobotUserTicketInfo sobotUserTicketInfo = this.mTicketInfo;
            if (sobotUserTicketInfo != null && this.infoFlag != sobotUserTicketInfo.getFlag()) {
                setResult(-1);
            }
            super.onBackPressed();
            return;
        }
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(this.mTicketInfo.getTicketId());
        SharedPreferencesUtil.saveObject(this, "showBackEvaluateTicketIds", arrayList);
        Intent intent = new Intent(this, SobotTicketEvaluateActivity.class);
        intent.putExtra("sobotUserTicketEvaluate", this.mEvaluate);
        startActivityForResult(intent, 1111);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_reply_ll) {
            Intent intent = new Intent(this, SobotReplyActivity.class);
            intent.putExtra("uid", this.mUid);
            intent.putExtra("companyId", this.mCompanyId);
            intent.putExtra("ticketInfo", this.mTicketInfo);
            intent.putExtra("picTempList", this.pic_list);
            intent.putExtra("replyTempContent", this.replyTempContent);
            startActivityForResult(intent, 4097);
        }
    }

    public void removeTicketId() {
        List list = (List) SharedPreferencesUtil.getObject(this, "showBackEvaluateTicketIds");
        SobotUserTicketInfo sobotUserTicketInfo = this.mTicketInfo;
        if (sobotUserTicketInfo != null && list != null) {
            list.remove(sobotUserTicketInfo.getTicketId());
        }
        SharedPreferencesUtil.saveObject(this, "showBackEvaluateTicketIds", list);
    }

    public void submitEvaluate(final int i, final String str) {
        this.zhiChiApi.addTicketSatisfactionScoreInfo(this, this.mUid, this.mCompanyId, this.mTicketInfo.getTicketId(), i, str, new StringResultCallBack<String>() { // from class: com.sobot.chat.activity.SobotTicketDetailActivity.4
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str2) {
                ToastUtil.showToast(SobotTicketDetailActivity.this.getApplicationContext(), str2);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(String str2) {
                SobotTicketDetailActivity sobotTicketDetailActivity = SobotTicketDetailActivity.this;
                CustomToast.makeText(sobotTicketDetailActivity, ResourceUtils.getResString(sobotTicketDetailActivity, "sobot_leavemsg_success_tip"), 1000, ResourceUtils.getDrawableId(SobotTicketDetailActivity.this, "sobot_iv_login_right")).show();
                SobotTicketDetailActivity.this.sobot_evaluate_ll.setVisibility(8);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= SobotTicketDetailActivity.this.mList.size()) {
                        break;
                    }
                    if (SobotTicketDetailActivity.this.mList.get(i3) instanceof StUserDealTicketInfo) {
                        StUserDealTicketInfo stUserDealTicketInfo = (StUserDealTicketInfo) SobotTicketDetailActivity.this.mList.get(i3);
                        if (stUserDealTicketInfo.getFlag() == 3 && stUserDealTicketInfo.getEvaluate() != null) {
                            SobotUserTicketEvaluate evaluate = stUserDealTicketInfo.getEvaluate();
                            evaluate.setScore(i);
                            evaluate.setRemark(str);
                            evaluate.setEvalution(true);
                            SobotTicketDetailActivity.this.mAdapter.notifyDataSetChanged();
                            break;
                        }
                    }
                    i2 = i3 + 1;
                }
                SobotTicketDetailActivity.this.removeTicketId();
            }
        });
    }
}
