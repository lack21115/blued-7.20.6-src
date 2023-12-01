package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
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
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/TagForModifyFragment.class */
public class TagForModifyFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33986a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33987c;
    private List<UserTag> d = new ArrayList();
    private List<UserTag> e = new ArrayList();
    private List<UserTag> f = new ArrayList();
    private List<UserTag> g = new ArrayList();
    private List<UserTag> h = new ArrayList();
    private ArrayList<String> i = new ArrayList<>();
    private int j;
    private GridView k;
    private GridView l;
    private GridView m;
    private GridView n;
    private GridView o;
    private UserTagAdapter p;
    private UserTagAdapter q;
    private UserTagAdapter r;
    private UserTagAdapter s;
    private UserTagAdapter t;
    private boolean u;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/TagForModifyFragment$FROM_PAGE.class */
    public interface FROM_PAGE {
    }

    public static void a(BaseFragment baseFragment, ArrayList<String> arrayList, int i) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choosedList", arrayList);
        TerminalActivity.a(baseFragment, TagForModifyFragment.class, bundle, i);
    }

    private void a(Map<String, String> map) {
        UserHttpUtils.a(getActivity(), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.7

            /* renamed from: a  reason: collision with root package name */
            String f33994a = "";

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                UserInfo.getInstance().setLoginUserInfo(bluedEntityA.data.get(0));
                AppMethods.a((CharSequence) TagForModifyFragment.this.getResources().getString(R.string.modify_user_info_success));
                UserAccountsVDao.a().b(this.f33994a);
                TagForModifyFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String str) {
                super.onSuccess(str);
                this.f33994a = str;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                TagForModifyFragment.this.g();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(TagForModifyFragment.this.f33987c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(TagForModifyFragment.this.f33987c);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, getFragmentActive());
    }

    public void a() {
        this.f33987c = DialogUtils.a(getActivity());
        GridView gridView = (GridView) this.b.findViewById(R.id.gv_iam_bodytype);
        this.k = gridView;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                if (((UserTag) TagForModifyFragment.this.d.get(i)).chooseable) {
                    if (((UserTag) TagForModifyFragment.this.d.get(i)).checked == 1) {
                        ((UserTag) TagForModifyFragment.this.d.get(i)).checked = 0;
                    } else if (TagForModifyFragment.this.b() < 5) {
                        ((UserTag) TagForModifyFragment.this.d.get(i)).checked = 1;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= TagForModifyFragment.this.d.size()) {
                                break;
                            }
                            if (i3 != i) {
                                ((UserTag) TagForModifyFragment.this.d.get(i3)).checked = 0;
                            }
                            i2 = i3 + 1;
                        }
                    } else {
                        AppMethods.d((int) R.string.max_tags_5);
                    }
                    TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                    tagForModifyFragment.a((UserTag) tagForModifyFragment.d.get(i));
                    TagForModifyFragment.this.p.notifyDataSetChanged();
                }
            }
        });
        GridView gridView2 = (GridView) this.b.findViewById(R.id.gv_iam_characteristic);
        this.l = gridView2;
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                tagForModifyFragment.a(tagForModifyFragment.e, TagForModifyFragment.this.q, i);
            }
        });
        GridView gridView3 = (GridView) this.b.findViewById(R.id.gv_lookfor_bodytype);
        this.m = gridView3;
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                tagForModifyFragment.b(tagForModifyFragment.f, TagForModifyFragment.this.r, i);
            }
        });
        GridView gridView4 = (GridView) this.b.findViewById(R.id.gv_lookfor_want);
        this.n = gridView4;
        gridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                tagForModifyFragment.b(tagForModifyFragment.g, TagForModifyFragment.this.s, i);
            }
        });
        GridView gridView5 = (GridView) this.b.findViewById(R.id.gv_lookfor_characteristic);
        this.o = gridView5;
        gridView5.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Tracker.onItemClick(adapterView, view, i, j);
                TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                tagForModifyFragment.b(tagForModifyFragment.h, TagForModifyFragment.this.t, i);
            }
        });
        TextView textView = (TextView) this.b.findViewById(R.id.tv_am);
        if ("CN".equals(BlueAppLocal.b())) {
            textView.setText(getResources().getString(R.string.i_am) + "  (" + getResources().getString(R.string.max_tags_5) + ")");
        }
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_lookfor);
        textView2.setText(getResources().getString(R.string.i_look_for) + "  (" + getResources().getString(R.string.max_tags_5) + ")");
    }

    public void a(UserTag userTag) {
        if (userTag.exclude_id == null || userTag.exclude_id.length == 0) {
            return;
        }
        if (userTag.checked == 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= userTag.exclude_id.length) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.d.size()) {
                        break;
                    }
                    if (userTag.exclude_id[i2].equals(this.d.get(i4).id)) {
                        this.d.get(i4).chooseable = false;
                    }
                    i3 = i4 + 1;
                }
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 < this.e.size()) {
                        if (userTag.exclude_id[i2].equals(this.e.get(i6).id)) {
                            this.e.get(i6).chooseable = false;
                        }
                        i5 = i6 + 1;
                    }
                }
                i = i2 + 1;
            }
        } else {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= userTag.exclude_id.length) {
                    return;
                }
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= this.d.size()) {
                        break;
                    }
                    if (userTag.exclude_id[i8].equals(this.d.get(i10).id)) {
                        this.d.get(i10).chooseable = true;
                    }
                    i9 = i10 + 1;
                }
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 < this.e.size()) {
                        if (userTag.exclude_id[i8].equals(this.e.get(i12).id)) {
                            this.e.get(i12).chooseable = true;
                        }
                        i11 = i12 + 1;
                    }
                }
                i7 = i8 + 1;
            }
        }
    }

    public void a(ArrayList<String> arrayList, List<UserTag> list) {
        if (arrayList == null || arrayList.size() <= 0) {
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
                    if (list.get(i6).id.equals(str)) {
                        list.get(i6).checked = 1;
                        a(list.get(i6));
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    public void a(List<UserTag> list, UserTagAdapter userTagAdapter, int i) {
        if (list.get(i).chooseable) {
            if (list.get(i).checked == 1) {
                list.get(i).checked = 0;
            } else {
                int b = b();
                if (b < 5) {
                    list.get(i).checked = 1;
                } else if (b == 5) {
                    AppMethods.d((int) R.string.max_tags_5);
                }
            }
            a(list.get(i));
            userTagAdapter.notifyDataSetChanged();
        }
    }

    public int b() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            i = 0;
            i2 = i5;
            if (i3 >= this.d.size()) {
                break;
            }
            int i6 = i5;
            if (this.d.get(i3).checked == 1) {
                i6 = i5 + 1;
            }
            i3++;
            i4 = i6;
        }
        while (i < this.e.size()) {
            int i7 = i2;
            if (this.e.get(i).checked == 1) {
                i7 = i2 + 1;
            }
            i++;
            i2 = i7;
        }
        return i2;
    }

    public void b(List<UserTag> list, UserTagAdapter userTagAdapter, int i) {
        if (list.get(i).checked == 1) {
            list.get(i).checked = 0;
        } else {
            int c2 = c();
            if (c2 < 5) {
                list.get(i).checked = 1;
            } else if (c2 == 5) {
                AppMethods.d((int) R.string.max_tags_5);
            }
        }
        userTagAdapter.notifyDataSetChanged();
    }

    public int c() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = i5;
            if (i4 >= this.f.size()) {
                break;
            }
            int i6 = i;
            if (this.f.get(i4).checked == 1) {
                i6 = i + 1;
            }
            i4++;
            i5 = i6;
        }
        int i7 = 0;
        while (true) {
            i2 = 0;
            i3 = i;
            if (i7 >= this.g.size()) {
                break;
            }
            int i8 = i;
            if (this.g.get(i7).checked == 1) {
                i8 = i + 1;
            }
            i7++;
            i = i8;
        }
        while (i2 < this.h.size()) {
            int i9 = i3;
            if (this.h.get(i2).checked == 1) {
                i9 = i3 + 1;
            }
            i2++;
            i3 = i9;
        }
        return i3;
    }

    public void d() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.my_tags));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
        commonTopTitleNoTrans.setRightText(R.string.done);
        commonTopTitleNoTrans.setRightTextColor(2131102254);
    }

    public void e() {
        FindHttpUtils.a(this.f33986a, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                TagForModifyFragment.this.d = bluedEntityA.data.get(0).type;
                TagForModifyFragment.this.e = bluedEntityA.data.get(0).character;
                TagForModifyFragment.this.f = bluedEntityA.data.get(0).love_type;
                TagForModifyFragment.this.g = bluedEntityA.data.get(0).i_want;
                TagForModifyFragment.this.h = bluedEntityA.data.get(0).love_character;
                TagForModifyFragment tagForModifyFragment = TagForModifyFragment.this;
                tagForModifyFragment.a(tagForModifyFragment.i, TagForModifyFragment.this.d);
                TagForModifyFragment tagForModifyFragment2 = TagForModifyFragment.this;
                tagForModifyFragment2.a(tagForModifyFragment2.i, TagForModifyFragment.this.e);
                TagForModifyFragment tagForModifyFragment3 = TagForModifyFragment.this;
                tagForModifyFragment3.a(tagForModifyFragment3.i, TagForModifyFragment.this.f);
                TagForModifyFragment tagForModifyFragment4 = TagForModifyFragment.this;
                tagForModifyFragment4.a(tagForModifyFragment4.i, TagForModifyFragment.this.g);
                TagForModifyFragment tagForModifyFragment5 = TagForModifyFragment.this;
                tagForModifyFragment5.a(tagForModifyFragment5.i, TagForModifyFragment.this.h);
                TagForModifyFragment.this.p = new UserTagAdapter(TagForModifyFragment.this.f33986a, TagForModifyFragment.this.d);
                TagForModifyFragment.this.q = new UserTagAdapter(TagForModifyFragment.this.f33986a, TagForModifyFragment.this.e);
                TagForModifyFragment.this.r = new UserTagAdapter(TagForModifyFragment.this.f33986a, TagForModifyFragment.this.f);
                TagForModifyFragment.this.s = new UserTagAdapter(TagForModifyFragment.this.f33986a, TagForModifyFragment.this.g);
                TagForModifyFragment.this.t = new UserTagAdapter(TagForModifyFragment.this.f33986a, TagForModifyFragment.this.h);
                TagForModifyFragment.this.k.setAdapter((ListAdapter) TagForModifyFragment.this.p);
                TagForModifyFragment.this.l.setAdapter((ListAdapter) TagForModifyFragment.this.q);
                TagForModifyFragment.this.m.setAdapter((ListAdapter) TagForModifyFragment.this.r);
                TagForModifyFragment.this.n.setAdapter((ListAdapter) TagForModifyFragment.this.s);
                TagForModifyFragment.this.o.setAdapter((ListAdapter) TagForModifyFragment.this.t);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(TagForModifyFragment.this.f33987c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(TagForModifyFragment.this.f33987c);
            }
        }, getFragmentActive());
    }

    public void f() {
        int i;
        this.i.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.size()) {
                break;
            }
            if (this.d.get(i3).checked == 1) {
                this.i.add(this.d.get(i3).id);
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
                this.i.add(this.e.get(i5).id);
            }
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.f.size()) {
                break;
            }
            if (this.f.get(i7).checked == 1) {
                this.i.add(this.f.get(i7).id);
            }
            i6 = i7 + 1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= this.g.size()) {
                break;
            }
            if (this.g.get(i9).checked == 1) {
                this.i.add(this.g.get(i9).id);
            }
            i8 = i9 + 1;
        }
        for (i = 0; i < this.h.size(); i++) {
            if (this.h.get(i).checked == 1) {
                this.i.add(this.h.get(i).id);
            }
        }
    }

    public void g() {
        CommonAlertDialog.a(getActivity(), (String) null, getResources().getString(R.string.set_tags_failed), getResources().getString(R.string.tags_set), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                ModifyUserInfoFragment.a(TagForModifyFragment.this.f33986a, 601, false);
            }
        }, getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.TagForModifyFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                TagForModifyFragment.this.getActivity().finish();
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().finish();
        return false;
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
            if (this.i != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.i.size()) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringUtils.d(stringBuffer.toString()) ? "" : ",");
                    sb.append(this.i.get(i2));
                    stringBuffer.append(sb.toString());
                    i = i2 + 1;
                }
            }
            if (this.u) {
                Map<String, String> a2 = BluedHttpTools.a();
                a2.put("tags", stringBuffer.toString());
                a(a2);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("CHOOSED_TAG_LIST", this.i);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33986a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_tag_for_modify, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.u = arguments.getBoolean("ifNeedPostOnRightClick");
                if (arguments.getStringArrayList("choosedList") != null) {
                    this.i.addAll(arguments.getStringArrayList("choosedList"));
                }
                this.j = arguments.getInt("from");
            }
            a();
            d();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
