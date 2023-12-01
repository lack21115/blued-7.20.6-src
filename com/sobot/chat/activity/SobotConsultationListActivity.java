package com.sobot.chat.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.activity.base.SobotBaseActivity;
import com.sobot.chat.adapter.SobotMsgCenterAdapter;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.handler.SobotMsgCenterHandler;
import com.sobot.chat.listener.SobotFunctionType;
import com.sobot.chat.receiver.SobotMsgCenterReceiver;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotCompareNewMsgTime;
import com.sobot.chat.utils.SobotOption;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.callback.StringResultCallBack;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotConsultationListActivity.class */
public class SobotConsultationListActivity extends SobotBaseActivity implements SobotMsgCenterHandler.SobotMsgCenterCallBack {
    private static final int REFRESH_DATA = 1;
    private SobotMsgCenterAdapter adapter;
    private String currentUid;
    private LocalBroadcastManager localBroadcastManager;
    private SobotCompareNewMsgTime mCompareNewMsgTime;
    private SobotMessageReceiver receiver;
    private ListView sobot_ll_msg_center;
    private List<SobotMsgCenterModel> datas = new ArrayList();
    private SHandler mHandler = new SHandler(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sobot.chat.activity.SobotConsultationListActivity$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotConsultationListActivity$2.class */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            new AlertDialog.Builder(SobotConsultationListActivity.this).setPositiveButton(ResourceUtils.getResString(SobotConsultationListActivity.this, "sobot_delete_dialogue"), new DialogInterface.OnClickListener() { // from class: com.sobot.chat.activity.SobotConsultationListActivity.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) SobotConsultationListActivity.this.adapter.getItem(i);
                    dialogInterface.dismiss();
                    SobotMsgManager.getInstance(SobotConsultationListActivity.this.getApplicationContext()).getZhiChiApi().removeMerchant(SobotConsultationListActivity.this, SharedPreferencesUtil.getStringData(SobotConsultationListActivity.this.getApplicationContext(), ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, ""), SobotConsultationListActivity.this.currentUid, sobotMsgCenterModel, new StringResultCallBack<SobotMsgCenterModel>() { // from class: com.sobot.chat.activity.SobotConsultationListActivity.2.1.1
                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onFailure(Exception exc, String str) {
                        }

                        @Override // com.sobot.network.http.callback.StringResultCallBack
                        public void onSuccess(SobotMsgCenterModel sobotMsgCenterModel2) {
                            if (sobotMsgCenterModel2 == null || sobotMsgCenterModel2.getInfo() == null || SobotConsultationListActivity.this.datas == null) {
                                return;
                            }
                            SobotConsultationListActivity.this.datas.remove(sobotMsgCenterModel2);
                            Collections.sort(SobotConsultationListActivity.this.datas, SobotConsultationListActivity.this.mCompareNewMsgTime);
                            SobotConsultationListActivity.this.sendDatasOnUi(SobotConsultationListActivity.this.datas);
                        }
                    });
                }
            }).create().show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotConsultationListActivity$SHandler.class */
    public static class SHandler extends Handler {
        WeakReference<Activity> mActivityReference;

        SHandler(Activity activity) {
            this.mActivityReference = new WeakReference<>(activity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SobotConsultationListActivity sobotConsultationListActivity = (SobotConsultationListActivity) this.mActivityReference.get();
            if (sobotConsultationListActivity == null || message.what != 1) {
                return;
            }
            List list = sobotConsultationListActivity.datas;
            SobotMsgCenterAdapter sobotMsgCenterAdapter = sobotConsultationListActivity.adapter;
            ListView listView = sobotConsultationListActivity.sobot_ll_msg_center;
            List list2 = (List) message.obj;
            if (list2 != null) {
                list.clear();
                list.addAll(list2);
                if (sobotMsgCenterAdapter != null) {
                    sobotMsgCenterAdapter.notifyDataSetChanged();
                    return;
                }
                SobotMsgCenterAdapter sobotMsgCenterAdapter2 = new SobotMsgCenterAdapter(sobotConsultationListActivity, list);
                sobotConsultationListActivity.adapter = sobotMsgCenterAdapter2;
                listView.setAdapter((ListAdapter) sobotMsgCenterAdapter2);
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/activity/SobotConsultationListActivity$SobotMessageReceiver.class */
    public class SobotMessageReceiver extends SobotMsgCenterReceiver {
        public SobotMessageReceiver() {
        }

        @Override // com.sobot.chat.receiver.SobotMsgCenterReceiver
        public List<SobotMsgCenterModel> getMsgCenterDatas() {
            return SobotConsultationListActivity.this.datas;
        }

        @Override // com.sobot.chat.receiver.SobotMsgCenterReceiver
        public void onDataChanged(SobotMsgCenterModel sobotMsgCenterModel) {
            SobotConsultationListActivity.this.refershItemData(sobotMsgCenterModel);
        }
    }

    private void initBrocastReceiver() {
        if (this.receiver == null) {
            this.receiver = new SobotMessageReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ZhiChiConstants.receiveMessageBrocast);
        intentFilter.addAction(ZhiChiConstant.SOBOT_ACTION_UPDATE_LAST_MSG);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.localBroadcastManager = localBroadcastManager;
        localBroadcastManager.registerReceiver(this.receiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDatasOnUi(List<SobotMsgCenterModel> list) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        obtainMessage.obj = arrayList;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public int getContentViewResId() {
        return getResLayoutId("sobot_activity_consultation_list");
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initBundleData(Bundle bundle) {
        if (bundle == null) {
            this.currentUid = getIntent().getStringExtra(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID);
        } else {
            this.currentUid = bundle.getString(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID);
        }
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initData() {
        SobotMsgCenterHandler.getMsgCenterAllData(this, this, this.currentUid, this);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity
    public void initView() {
        showLeftMenu(getResDrawableId("sobot_btn_back_selector"), "", true);
        setTitle(getResString("sobot_consultation_list"));
        ListView listView = (ListView) findViewById(getResId("sobot_ll_msg_center"));
        this.sobot_ll_msg_center = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.activity.SobotConsultationListActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                SobotMsgCenterModel sobotMsgCenterModel = (SobotMsgCenterModel) SobotConsultationListActivity.this.datas.get(i);
                Information info = sobotMsgCenterModel.getInfo();
                if (info != null) {
                    info.setPartnerid(SobotConsultationListActivity.this.currentUid);
                    if (SobotOption.sobotConversationListCallback == null || TextUtils.isEmpty(sobotMsgCenterModel.getApp_key())) {
                        SobotApi.startSobotChat(SobotConsultationListActivity.this.getApplicationContext(), info);
                    } else {
                        SobotOption.sobotConversationListCallback.onConversationInit(SobotConsultationListActivity.this.getApplicationContext(), info);
                    }
                }
            }
        });
        this.sobot_ll_msg_center.setOnItemLongClickListener(new AnonymousClass2());
    }

    @Override // com.sobot.chat.handler.SobotMsgCenterHandler.SobotMsgCenterCallBack
    public void onAllDataSuccess(List<SobotMsgCenterModel> list) {
        sendDatasOnUi(list);
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBrocastReceiver();
        this.mCompareNewMsgTime = new SobotCompareNewMsgTime();
    }

    @Override // com.sobot.chat.activity.base.SobotBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        HttpUtils.getInstance().cancelTag(this);
        LocalBroadcastManager localBroadcastManager = this.localBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(this.receiver);
        }
        if (SobotOption.functionClickListener != null) {
            SobotOption.functionClickListener.onClickFunction(getSobotBaseActivity(), SobotFunctionType.ZC_CloseChatList);
        }
        super.onDestroy();
    }

    @Override // com.sobot.chat.handler.SobotMsgCenterHandler.SobotMsgCenterCallBack
    public void onLocalDataSuccess(List<SobotMsgCenterModel> list) {
        sendDatasOnUi(list);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(ZhiChiConstant.SOBOT_CURRENT_IM_PARTNERID, this.currentUid);
        super.onSaveInstanceState(bundle);
    }

    public void refershItemData(SobotMsgCenterModel sobotMsgCenterModel) {
        List<SobotMsgCenterModel> list;
        if (sobotMsgCenterModel == null || sobotMsgCenterModel.getInfo() == null || TextUtils.isEmpty(sobotMsgCenterModel.getLastMsg()) || (list = this.datas) == null) {
            return;
        }
        list.remove(sobotMsgCenterModel);
        this.datas.add(sobotMsgCenterModel);
        Collections.sort(this.datas, this.mCompareNewMsgTime);
        sendDatasOnUi(this.datas);
    }
}
