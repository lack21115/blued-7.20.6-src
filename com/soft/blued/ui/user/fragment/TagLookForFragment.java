package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.face.AVConfig;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.find.fragment.RecommendUsersOnRegisterFragment;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/TagLookForFragment.class */
public class TagLookForFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f20306a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f20307c;
    private boolean g;
    private boolean h;
    private boolean i;
    private GridView j;
    private GridView k;
    private GridView l;
    private UserTagAdapter m;
    private UserTagAdapter n;
    private UserTagAdapter o;
    private TextView p;
    private TextView q;
    private int u;
    private int v;
    private int w;
    private List<UserTag> d = new ArrayList();
    private List<UserTag> e = new ArrayList();
    private List<UserTag> f = new ArrayList();
    private String r = "";
    private ArrayList<String> s = new ArrayList<>();
    private ArrayList<String> t = new ArrayList<>();

    public static void a(Context context, boolean z, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("hidden_back", z);
        bundle.putStringArrayList("choosedIAmList", arrayList);
        TerminalActivity.d(context, TagLookForFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (a(this.f, this.o, i)) {
            this.i = true;
        }
    }

    private void a(Map<String, String> map) {
        UserHttpUtils.a((Context) getActivity(), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.user.fragment.TagLookForFragment.2

            /* renamed from: a  reason: collision with root package name */
            String f20309a;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                UserInfo.getInstance().setLoginUserInfo((BluedLoginResult) bluedEntityA.data.get(0));
                UserAccountsVDao.a().b(this.f20309a);
                Bundle bundle = new Bundle();
                bundle.putString("from_tag_page", "from_tag_register");
                HomeArgumentHelper.a(TagLookForFragment.this.getActivity(), (Bundle) null, bundle);
                if (TagLookForFragment.this.getActivity() != null) {
                    TagLookForFragment.this.getActivity().finish();
                }
            }

            public void onSuccess(String str) {
                super.onSuccess(str);
                this.f20309a = str;
            }

            public boolean onUIFailure(int i, String str) {
                TagLookForFragment.this.g();
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(TagLookForFragment.this.f20307c);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(TagLookForFragment.this.f20307c);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, (IRequestHost) getFragmentActive());
    }

    private boolean a(List<UserTag> list) {
        for (UserTag userTag : list) {
            if (userTag.checked == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (a(this.e, this.n, i)) {
            this.h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (a(this.d, this.m, i)) {
            this.g = true;
        }
    }

    public void a() {
    }

    public boolean a(List<UserTag> list, UserTagAdapter userTagAdapter, int i) {
        boolean z = false;
        if (list.get(i).chooseable) {
            if (list.get(i).checked == 1) {
                list.get(i).checked = 0;
            } else {
                c();
                int i2 = list == this.d ? this.v : list == this.e ? this.w : this.u;
                if (i2 < 5) {
                    list.get(i).checked = 1;
                } else {
                    z = false;
                    if (i2 == 5) {
                        AppMethods.d((int) R.string.max_tags_5);
                        z = false;
                    }
                    userTagAdapter.notifyDataSetChanged();
                }
            }
            z = true;
            userTagAdapter.notifyDataSetChanged();
        }
        a();
        return z;
    }

    public void b() {
        a();
        this.q = (TextView) this.b.findViewById(2131372754);
        this.p = (TextView) this.b.findViewById(R.id.tv_chara);
        this.f20307c = DialogUtils.a(getActivity());
        GridView gridView = (GridView) this.b.findViewById(R.id.gv_bodytype);
        this.j = gridView;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$TagLookForFragment$sPzKJNyCRgmgf6x1rk0UK0n4AOA
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                TagLookForFragment.this.c(adapterView, view, i, j);
            }
        });
        GridView gridView2 = (GridView) this.b.findViewById(R.id.gv_characteristic);
        this.k = gridView2;
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$TagLookForFragment$vUgPaDqGXK-dTPb0dXxr1W0REps
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                TagLookForFragment.this.b(adapterView, view, i, j);
            }
        });
        GridView gridView3 = (GridView) this.b.findViewById(R.id.gv_want);
        this.l = gridView3;
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$TagLookForFragment$_cXuLdxFbxCCjJOc9eWgOaircHM
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                TagLookForFragment.this.a(adapterView, view, i, j);
            }
        });
        this.p.setVisibility(0);
        this.k.setVisibility(0);
    }

    public void c() {
        int i;
        this.v = 0;
        this.w = 0;
        this.u = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.size()) {
                break;
            }
            if (this.d.get(i3).checked == 1) {
                this.v++;
            }
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.e.size()) {
                break;
            }
            if (this.e.get(i5).checked == 1) {
                this.w++;
            }
            i4 = i5 + 1;
        }
        for (i = 0; i < this.f.size(); i++) {
            if (this.f.get(i).checked == 1) {
                this.u++;
            }
        }
    }

    public void d() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
        findViewById.setRightText((int) R.string.done);
        findViewById.setCenterText("");
        findViewById.f();
        findViewById.setRightTextColor(2131102254);
        findViewById.setTitleBackgroundDrawable(2131101780);
        this.q.setText(AVConfig.a().b().tags_favorite_tips);
    }

    public void e() {
        FindHttpUtils.a(this.f20306a, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserTagAll>>() { // from class: com.soft.blued.ui.user.fragment.TagLookForFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                TagLookForFragment.this.d = ((UserTagAll) bluedEntityA.data.get(0)).love_type;
                TagLookForFragment.this.e = ((UserTagAll) bluedEntityA.data.get(0)).love_character;
                TagLookForFragment.this.f = ((UserTagAll) bluedEntityA.data.get(0)).i_want;
                TagLookForFragment.this.m = new UserTagAdapter(TagLookForFragment.this.f20306a, TagLookForFragment.this.d);
                TagLookForFragment.this.n = new UserTagAdapter(TagLookForFragment.this.f20306a, TagLookForFragment.this.e);
                TagLookForFragment.this.o = new UserTagAdapter(TagLookForFragment.this.f20306a, TagLookForFragment.this.f);
                TagLookForFragment.this.j.setAdapter((ListAdapter) TagLookForFragment.this.m);
                TagLookForFragment.this.k.setAdapter((ListAdapter) TagLookForFragment.this.n);
                TagLookForFragment.this.l.setAdapter((ListAdapter) TagLookForFragment.this.o);
            }

            public void onUIFinish() {
                DialogUtils.b(TagLookForFragment.this.f20307c);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(TagLookForFragment.this.f20307c);
            }
        }, (IRequestHost) getFragmentActive());
    }

    public void f() {
        ArrayList<String> arrayList = this.s;
        if (arrayList == null) {
            this.s = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (this.t != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.t.size()) {
                    break;
                }
                this.s.add(this.t.get(i2));
                i = i2 + 1;
            }
        }
        if (this.d != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.d.size()) {
                    break;
                }
                if (this.d.get(i4).checked == 1) {
                    this.s.add(this.d.get(i4).id);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.r);
                    sb.append(StringUtils.d(this.r) ? "" : ",");
                    sb.append(this.d.get(i4).name);
                    this.r = sb.toString();
                }
                i3 = i4 + 1;
            }
        }
        if (this.f != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.f.size()) {
                    break;
                }
                if (this.f.get(i6).checked == 1) {
                    this.s.add(this.f.get(i6).id);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.r);
                    sb2.append(StringUtils.d(this.r) ? "" : ",");
                    sb2.append(this.f.get(i6).name);
                    this.r = sb2.toString();
                }
                i5 = i6 + 1;
            }
        }
        if (this.e != null) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= this.e.size()) {
                    break;
                }
                if (this.e.get(i8).checked == 1) {
                    this.s.add(this.e.get(i8).id);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.r);
                    sb3.append(StringUtils.d(this.r) ? "" : ",");
                    sb3.append(this.e.get(i8).name);
                    this.r = sb3.toString();
                }
                i7 = i8 + 1;
            }
        }
        if (this.s.size() == 0) {
            this.s.add("");
        }
    }

    public void g() {
        CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.set_tags_failed), getResources().getString(R.string.tags_set), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.TagLookForFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ModifyUserInfoFragment.a(TagLookForFragment.this.f20306a, 601, false);
            }
        }, getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.TagLookForFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                TagLookForFragment.this.getActivity().finish();
                RecommendUsersOnRegisterFragment.a(TagLookForFragment.this.f20306a);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            f();
            if (this.s != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.s.size()) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb.append(this.s.get(i2));
                    stringBuffer.append(sb.toString());
                    i = i2 + 1;
                }
            }
            if (!this.g) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.DEFAULT);
            } else if (a(this.d)) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
            }
            if (!this.h) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.DEFAULT);
            } else if (a(this.e)) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
            }
            if (!this.i) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.DEFAULT);
            } else if (a(this.f)) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LIKE_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.WANT, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
            }
            if (StringUtils.d(stringBuffer.toString())) {
                Bundle bundle = new Bundle();
                bundle.putString("from_tag_page", "from_tag_register");
                HomeArgumentHelper.a(getActivity(), (Bundle) null, bundle);
                return;
            }
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put("tags", stringBuffer.toString());
            a(a2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20306a = getActivity();
        if (this.b == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_tag_iwant, viewGroup, false);
            if (getArguments() != null) {
                this.s = getArguments().getStringArrayList("CHOOSED_LIST");
                this.t = getArguments().getStringArrayList("choosedIAmList");
            }
            b();
            d();
            e();
        }
        return this.b;
    }
}
