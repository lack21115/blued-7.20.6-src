package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyMakeFriendsFragment.class */
public class ModifyMakeFriendsFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19735a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private PullToRefreshRecyclerView f19736c;
    private UserLabelAdapterNew d;
    private Dialog e;
    private List<UserTag> f = new ArrayList();
    private ArrayList<String> g = new ArrayList<>();

    public static void a(BaseFragment baseFragment, ArrayList<String> arrayList, int i) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choosedList", arrayList);
        TerminalActivity.a(baseFragment, ModifyMakeFriendsFragment.class, bundle, i);
    }

    private void d() {
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getStringArrayList("choosedList") == null) {
            return;
        }
        this.g.addAll(arguments.getStringArrayList("choosedList"));
    }

    private void e() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.making_friends));
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
        findViewById.setRightText((int) R.string.done);
        findViewById.f();
        findViewById.setRightTextColor(2131102254);
    }

    private void f() {
        this.e = DialogUtils.a(getActivity());
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.gv_lookfor_want);
        this.f19736c = findViewById;
        RecyclerView recyclerView = (RecyclerView) findViewById.getRefreshableView();
        this.f19736c.setRefreshEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this.f19735a, 1));
        UserLabelAdapterNew userLabelAdapterNew = new UserLabelAdapterNew(this.f19735a);
        this.d = userLabelAdapterNew;
        recyclerView.setAdapter(userLabelAdapterNew);
        this.d.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyMakeFriendsFragment.1
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (((UserTag) userTag.tagList.get(i)).chooseable) {
                    if (((UserTag) userTag.tagList.get(i)).checked == 1) {
                        ((UserTag) userTag.tagList.get(i)).checked = 0;
                    } else {
                        ModifyMakeFriendsFragment modifyMakeFriendsFragment = ModifyMakeFriendsFragment.this;
                        int a2 = modifyMakeFriendsFragment.a(modifyMakeFriendsFragment.d);
                        if (a2 < 5) {
                            ((UserTag) userTag.tagList.get(i)).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyMakeFriendsFragment.this.d.notifyDataSetChanged();
                }
            }
        });
    }

    public int a(UserLabelAdapterNew userLabelAdapterNew) {
        List<T> data = userLabelAdapterNew.getData();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= data.size()) {
                return i3;
            }
            UserTag userTag = (UserTag) data.get(i);
            int i4 = i3;
            if (userTag != null) {
                i4 = i3;
                if (userTag.tagList != null) {
                    int i5 = 0;
                    while (true) {
                        i4 = i3;
                        if (i5 < userTag.tagList.size()) {
                            int i6 = i3;
                            if (((UserTag) userTag.tagList.get(i5)).checked == 1) {
                                i6 = i3 + 1;
                            }
                            i5++;
                            i3 = i6;
                        }
                    }
                }
            }
            i++;
            i2 = i4;
        }
    }

    public void a() {
        this.g.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.getData().size()) {
                return;
            }
            UserTag userTag = (UserTag) this.d.getData().get(i2);
            if (userTag != null && userTag.tagList != null) {
                for (UserTag userTag2 : userTag.tagList) {
                    if (userTag2.checked == 1) {
                        this.g.add(userTag2.id);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public void a(ArrayList<String> arrayList, List<UserTag> list) {
        if (arrayList == null || arrayList.size() <= 0 || list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            list.get(i2).checked = 0;
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList.size()) {
                return;
            }
            String str = arrayList.get(i4);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < list.size()) {
                    UserTag userTag = list.get(i6);
                    if (userTag != null && TextUtils.equals(userTag.id, str)) {
                        userTag.checked = 1;
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    public ArrayList<String> b() {
        List<T> data = this.d.getData();
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= data.size()) {
                return arrayList;
            }
            UserTag userTag = (UserTag) data.get(i2);
            if (userTag != null && userTag.tagList != null) {
                for (UserTag userTag2 : userTag.tagList) {
                    if (userTag2.checked == 1) {
                        arrayList.add(userTag2.name);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public void c() {
        FindHttpUtils.a(this.f19735a, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyMakeFriendsFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                ModifyMakeFriendsFragment.this.f = ((UserTagAll) bluedEntityA.data.get(0)).i_want;
                ModifyMakeFriendsFragment modifyMakeFriendsFragment = ModifyMakeFriendsFragment.this;
                modifyMakeFriendsFragment.a(modifyMakeFriendsFragment.g, ModifyMakeFriendsFragment.this.f);
                ModifyMakeFriendsFragment.this.d.addData((UserLabelAdapterNew) new UserTag(ModifyMakeFriendsFragment.this.f));
            }

            public void onUIFinish() {
                DialogUtils.b(ModifyMakeFriendsFragment.this.e);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyMakeFriendsFragment.this.e);
            }
        }, (IRequestHost) getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            a();
            Intent intent = new Intent();
            intent.putExtra("choosed_make_friends_list", this.g);
            intent.putExtra("CHOOSED_MAKE_FRIENDS_LIST_NAME", b());
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19735a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_makefriends_for_modify, viewGroup, false);
            d();
            f();
            e();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
