package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.face.AVConfig;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/TagAmFragment.class */
public class TagAmFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33983a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33984c;
    private boolean f;
    private boolean g;
    private GridView h;
    private GridView i;
    private UserTagAdapter j;
    private UserTagAdapter k;
    private TextView n;
    private List<UserTag> d = new ArrayList();
    private List<UserTag> e = new ArrayList();
    private String l = "";
    private ArrayList<String> m = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (this.e.get(i).chooseable) {
            this.g = true;
            if (this.e.get(i).checked == 1) {
                this.e.get(i).checked = 0;
            } else {
                int c2 = c();
                if (c2 < 5) {
                    this.e.get(i).checked = 1;
                } else if (c2 == 5) {
                    AppMethods.d((int) R.string.max_tags_5);
                }
            }
            a(this.e.get(i));
            this.k.notifyDataSetChanged();
            b();
        }
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
        if (this.d.get(i).chooseable) {
            this.f = true;
            if (this.d.get(i).checked != 1) {
                this.d.get(i).checked = 1;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.d.size()) {
                        break;
                    }
                    if (i3 != i) {
                        this.d.get(i3).checked = 0;
                    }
                    i2 = i3 + 1;
                }
            } else {
                this.d.get(i).checked = 0;
            }
            a(this.d.get(i));
            this.j.notifyDataSetChanged();
            b();
        }
    }

    public void a() {
        this.n = (TextView) this.b.findViewById(2131372754);
        b();
        this.f33984c = DialogUtils.a(getActivity());
        GridView gridView = (GridView) this.b.findViewById(R.id.gv_bodytype);
        this.h = gridView;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$TagAmFragment$BnFCxsIAXGcvo-BlIdzVheCpMLc
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                TagAmFragment.this.b(adapterView, view, i, j);
            }
        });
        GridView gridView2 = (GridView) this.b.findViewById(R.id.gv_characteristic);
        this.i = gridView2;
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$TagAmFragment$tyHn9uWEmr_Jph0fOXbH9qEpk50
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                TagAmFragment.this.a(adapterView, view, i, j);
            }
        });
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

    public void b() {
    }

    public int c() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.e.size()) {
                return i3;
            }
            int i4 = i3;
            if (this.e.get(i).checked == 1) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    public void d() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.d();
        commonTopTitleNoTrans.f();
        commonTopTitleNoTrans.setRightClickListener(this);
        commonTopTitleNoTrans.setCenterText("");
        commonTopTitleNoTrans.setRightText(getResources().getString(2131891049));
        commonTopTitleNoTrans.setRightTextColor(2131102254);
        this.n.setText(AVConfig.a().b().tags_mine_tips);
    }

    public void e() {
        FindHttpUtils.a(this.f33983a, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>() { // from class: com.soft.blued.ui.user.fragment.TagAmFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                TagAmFragment.this.d = bluedEntityA.data.get(0).type;
                TagAmFragment.this.e = bluedEntityA.data.get(0).character;
                TagAmFragment.this.j = new UserTagAdapter(TagAmFragment.this.f33983a, TagAmFragment.this.d);
                TagAmFragment.this.k = new UserTagAdapter(TagAmFragment.this.f33983a, TagAmFragment.this.e);
                TagAmFragment.this.h.setAdapter((ListAdapter) TagAmFragment.this.j);
                TagAmFragment.this.i.setAdapter((ListAdapter) TagAmFragment.this.k);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(TagAmFragment.this.f33984c);
                TagAmFragment.this.b();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(TagAmFragment.this.f33984c);
            }
        }, getFragmentActive());
    }

    public void f() {
        ArrayList<String> arrayList = this.m;
        if (arrayList == null) {
            this.m = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (this.d != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d.size()) {
                    break;
                }
                if (this.d.get(i2).checked == 1) {
                    this.m.add(this.d.get(i2).id);
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.l);
                    sb.append(StringUtils.d(this.l) ? "" : ",");
                    sb.append(this.d.get(i2).name);
                    this.l = sb.toString();
                }
                i = i2 + 1;
            }
        }
        if (this.e != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.e.size()) {
                    break;
                }
                if (this.e.get(i4).checked == 1) {
                    this.m.add(this.e.get(i4).id);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.l);
                    sb2.append(StringUtils.d(this.l) ? "" : ",");
                    sb2.append(this.e.get(i4).name);
                    this.l = sb2.toString();
                }
                i3 = i4 + 1;
            }
        }
        if (this.m.size() == 0) {
            this.m.add("");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            f();
            if (!this.f) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.DEFAULT);
            } else if (a(this.d)) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.BODY, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
            }
            if (!this.g) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.DEFAULT);
            } else if (a(this.e)) {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_HAVE);
            } else {
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.PERSONAL_LABEL_NEXT_BTN_CLICK, LoginAndRegisterProtos.LabelType.FEATURE, LoginAndRegisterProtos.LabelStatus.INITIATIVE_NO);
            }
            TagLookForFragment.a(this.f33983a, true, this.m);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33983a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_tag_iam, viewGroup, false);
            a();
            d();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
