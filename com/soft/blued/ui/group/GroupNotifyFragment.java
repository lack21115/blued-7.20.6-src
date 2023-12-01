package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.adapter.GroupNotifyAdapter;
import com.soft.blued.ui.group.model.BluedMyGroupNotify;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.utils.Logger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupNotifyFragment.class */
public class GroupNotifyFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f30829a = new ArrayList();
    private CommonTopTitleNoTrans d;
    private RenrenPullToRefreshListView e;
    private NoDataAndLoadFailView f;
    private ListView g;
    private List<BluedMyGroupNotify> h;
    private GroupNotifyAdapter l;
    private View m;
    private Context n;
    private Dialog o;
    private int p;
    private short q;
    private String r;

    /* renamed from: c  reason: collision with root package name */
    private String f30830c = GroupNotifyFragment.class.getSimpleName();
    private int i = 1;
    private int j = 20;
    private boolean k = true;
    public BluedUIHttpResponse b = new BluedUIHttpResponse<BluedEntityA<BluedMyGroupNotify>>() { // from class: com.soft.blued.ui.group.GroupNotifyFragment.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<BluedMyGroupNotify> parseData(String str) {
            Logger.a(GroupNotifyFragment.this.f30830c, "onSuccess, content:", str);
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedMyGroupNotify> bluedEntityA) {
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.hasData()) {
                        if (bluedEntityA.extra.hasmore == 1) {
                            GroupNotifyFragment.this.k = true;
                            GroupNotifyFragment.this.e.o();
                        } else {
                            GroupNotifyFragment.this.k = false;
                            GroupNotifyFragment.this.e.p();
                        }
                        if (GroupNotifyFragment.this.i == 1) {
                            GroupNotifyFragment.this.h.clear();
                            GroupNotifyFragment.this.r = bluedEntityA.data.get(0).getIid();
                        }
                        File file = new File(GroupNotifyFragment.this.getActivity().getFilesDir(), "groupnofyalread");
                        JSONArray jSONArray = null;
                        try {
                            if (file.exists()) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                                StringBuffer stringBuffer = new StringBuffer();
                                while (bufferedInputStream.available() != 0) {
                                    stringBuffer.append((char) bufferedInputStream.read());
                                }
                                bufferedInputStream.close();
                                fileInputStream.close();
                                try {
                                    jSONArray = new JSONArray(stringBuffer.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    jSONArray = null;
                                }
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            jSONArray = null;
                        }
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= bluedEntityA.data.size()) {
                                GroupNotifyFragment.this.l.notifyDataSetChanged();
                                return;
                            }
                            BluedMyGroupNotify bluedMyGroupNotify = bluedEntityA.data.get(i2);
                            String timestamp = bluedEntityA.data.get(i2).getTimestamp();
                            if (jSONArray != null && jSONArray.length() > 0) {
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= jSONArray.length()) {
                                        break;
                                    }
                                    if (timestamp.equals(jSONArray.get(i4).toString())) {
                                        bluedMyGroupNotify.setIs_read("1");
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                            GroupNotifyFragment.this.h.add(bluedMyGroupNotify);
                            i = i2 + 1;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    AppMethods.a((CharSequence) GroupNotifyFragment.this.n.getResources().getString(2131887272));
                    return;
                }
            }
            if (GroupNotifyFragment.this.i == 1) {
                GroupNotifyFragment.this.h.clear();
                GroupNotifyFragment.this.l.notifyDataSetChanged();
                GroupNotifyFragment.this.e.setVisibility(8);
                GroupNotifyFragment.this.d.a();
                GroupNotifyFragment.this.f.a();
            }
            if (GroupNotifyFragment.this.i != 1) {
                GroupNotifyFragment.i(GroupNotifyFragment.this);
            }
            GroupNotifyFragment.this.e.p();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            Logger.a(GroupNotifyFragment.this.f30830c, "onFailure, error:", th);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            Logger.a(GroupNotifyFragment.this.f30830c, "onUIFinish");
            GroupNotifyFragment.this.e.j();
            GroupNotifyFragment.this.e.q();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupNotifyFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
            GroupNotifyFragment.this.i = 1;
            GroupNotifyFragment.this.a(false);
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            GroupNotifyFragment.b(GroupNotifyFragment.this);
            GroupNotifyFragment.this.a(false);
        }
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = (int) arguments.getLong("passby_session_id");
            this.q = arguments.getShort("passby_session_type");
            ChatManager.getInstance().ignoredNoReadNum(this.q, this.p);
            ChatManager.getInstance().deleteLocalChatting(this.q, this.p);
            DateTodayManager.f32404a.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int i;
        if (z) {
            this.i = 1;
        }
        if (this.i == 1) {
            this.k = true;
        }
        if (!this.k && (i = this.i) != 1) {
            this.i = i - 1;
            AppMethods.a((CharSequence) getResources().getString(2131887275));
            return;
        }
        GroupHttpUtils.a(this.n, this.b, UserInfo.getInstance().getLoginUserInfo().getUid(), this.i + "", this.j + "", getFragmentActive());
    }

    static /* synthetic */ int b(GroupNotifyFragment groupNotifyFragment) {
        int i = groupNotifyFragment.i;
        groupNotifyFragment.i = i + 1;
        return i;
    }

    private void b() {
        this.o = DialogUtils.a(this.n);
        this.h = new ArrayList();
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.m.findViewById(R.id.my_groupnotify_pullrefresh);
        this.e = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        this.e.setOnPullDownListener(new MyPullDownListener());
        ListView listView = (ListView) this.e.getRefreshableView();
        this.g = listView;
        listView.setDivider(null);
        this.g.setSelector(new ColorDrawable(0));
        this.e.postDelayed(new Runnable() { // from class: com.soft.blued.ui.group.GroupNotifyFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GroupNotifyFragment.this.e.k();
            }
        }, 100L);
        this.f = (NoDataAndLoadFailView) this.m.findViewById(R.id.ll_nodata_chats);
        GroupNotifyAdapter groupNotifyAdapter = new GroupNotifyAdapter(this.n, this.h, getFragmentActive());
        this.l = groupNotifyAdapter;
        this.g.setAdapter((ListAdapter) groupNotifyAdapter);
    }

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.m.findViewById(2131370749);
        this.d = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.d.setCenterText(getString(R.string.group_notification));
        this.d.setLeftClickListener(this);
        this.d.setRightClickListener(this);
        this.d.setRightText(getString(R.string.group_notify_clean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf(this.q), this.p);
        GroupHttpUtils.j(getActivity(), new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupNotifyFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupNotifyFragment.this.o);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupNotifyFragment.this.o);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                try {
                    GroupNotifyFragment.this.e.setVisibility(8);
                    GroupNotifyFragment.this.f.a();
                    GroupNotifyFragment.this.d.a();
                    GroupNotifyFragment.this.r = "";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    private void e() {
        GroupHttpUtils.i(this.n, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupNotifyFragment.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.r, getFragmentActive());
    }

    private void f() {
        File file = new File(getActivity().getFilesDir(), "groupnofyalread");
        try {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.h.size()) {
                    break;
                }
                jSONArray.put(this.h.get(i2).getTimestamp());
                i = i2 + 1;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jSONArray.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.r)) {
            e();
        }
        getActivity().finish();
    }

    private void g() {
        Context context = this.n;
        CommonAlertDialog.a(context, "", context.getResources().getString(R.string.group_notify_clean_remind), this.n.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.GroupNotifyFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                GroupNotifyFragment.this.d();
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    static /* synthetic */ int i(GroupNotifyFragment groupNotifyFragment) {
        int i = groupNotifyFragment.i;
        groupNotifyFragment.i = i - 1;
        return i;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        f();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            f();
        } else if (id != 2131363126) {
        } else {
            g();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = getActivity();
        View view = this.m;
        if (view == null) {
            this.m = layoutInflater.inflate(R.layout.fragment_group_notify, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.m.getParent()).removeView(this.m);
        }
        return this.m;
    }
}
