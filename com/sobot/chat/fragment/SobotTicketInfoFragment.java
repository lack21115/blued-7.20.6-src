package com.sobot.chat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.core.b;
import com.sobot.chat.activity.SobotTicketDetailActivity;
import com.sobot.chat.adapter.SobotTicketInfoAdapter;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.presenter.StPostMsgPresenter;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/fragment/SobotTicketInfoFragment.class */
public class SobotTicketInfoFragment extends SobotBaseFragment {
    private static final int REQUEST_CODE = 1;
    private SobotTicketInfoAdapter mAdapter;
    private TextView mEmptyView;
    private ListView mListView;
    private View mRootView;
    private String mUid = "";
    private String mCustomerId = "";
    private String mCompanyId = "";
    private List<SobotUserTicketInfo> mList = new ArrayList();

    public static SobotTicketInfoFragment newInstance(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION, bundle);
        SobotTicketInfoFragment sobotTicketInfoFragment = new SobotTicketInfoFragment();
        sobotTicketInfoFragment.setArguments(bundle2);
        return sobotTicketInfoFragment;
    }

    public void initData() {
        if (b.l.equals(this.mCustomerId)) {
            this.mCustomerId = "";
        }
        if (!isAdded() || TextUtils.isEmpty(this.mCompanyId) || TextUtils.isEmpty(this.mUid)) {
            return;
        }
        this.zhiChiApi.getUserTicketInfoList(this, this.mUid, this.mCompanyId, this.mCustomerId, new StringResultCallBack<List<SobotUserTicketInfo>>() { // from class: com.sobot.chat.fragment.SobotTicketInfoFragment.2
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                LogUtils.i(str);
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<SobotUserTicketInfo> list) {
                if (list == null || list.size() <= 0) {
                    SobotTicketInfoFragment.this.mEmptyView.setVisibility(0);
                    SobotTicketInfoFragment.this.mListView.setVisibility(8);
                    return;
                }
                SobotTicketInfoFragment.this.mListView.setVisibility(0);
                SobotTicketInfoFragment.this.mEmptyView.setVisibility(8);
                SobotTicketInfoFragment.this.mList.clear();
                SobotTicketInfoFragment.this.mList.addAll(list);
                SobotTicketInfoFragment.this.mAdapter = new SobotTicketInfoAdapter(SobotTicketInfoFragment.this.getActivity(), SobotTicketInfoFragment.this.getContext(), SobotTicketInfoFragment.this.mList);
                SobotTicketInfoFragment.this.mListView.setAdapter((ListAdapter) SobotTicketInfoFragment.this.mAdapter);
            }
        });
    }

    protected void initView(View view) {
        this.mListView = (ListView) view.findViewById(getResId("sobot_listview"));
        TextView textView = (TextView) view.findViewById(getResId("sobot_empty"));
        this.mEmptyView = textView;
        textView.setText(ResourceUtils.getResString(getSobotActivity(), "sobot_empty_data"));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.fragment.SobotTicketInfoFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                Tracker.onItemClick(adapterView, view2, i, j);
                SobotUserTicketInfo sobotUserTicketInfo = (SobotUserTicketInfo) SobotTicketInfoFragment.this.mAdapter.getItem(i);
                SobotTicketInfoFragment.this.startActivityForResult(SobotTicketDetailActivity.newIntent(SobotTicketInfoFragment.this.getContext(), SobotTicketInfoFragment.this.mCompanyId, SobotTicketInfoFragment.this.mUid, sobotUserTicketInfo), 1);
                sobotUserTicketInfo.setNewFlag(false);
                SobotTicketInfoFragment.this.mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        initData();
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            initData();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sobot.chat.fragment.SobotBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        if (getArguments() == null || (bundle2 = getArguments().getBundle(ZhiChiConstant.SOBOT_BUNDLE_INFORMATION)) == null) {
            return;
        }
        this.mUid = bundle2.getString("intent_key_uid");
        this.mCustomerId = bundle2.getString(StPostMsgPresenter.INTENT_KEY_CUSTOMERID);
        this.mCompanyId = bundle2.getString("intent_key_companyid");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getResLayoutId("sobot_fragment_ticket_info"), viewGroup, false);
        this.mRootView = inflate;
        initView(inflate);
        return this.mRootView;
    }
}
