package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.FlowLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserJobFragment.class */
public class ModifyUserJobFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33485a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33486c;
    private FlowLayout d;
    private LayoutInflater e;
    private ArrayList<String> f = new ArrayList<>();
    private List<UserTag> g = new ArrayList();

    public static void a(BaseFragment baseFragment, ArrayList<String> arrayList, int i) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choosedList", arrayList);
        TerminalActivity.a(baseFragment, ModifyUserJobFragment.class, bundle, i);
    }

    private void d() {
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getStringArrayList("choosedList") == null) {
            return;
        }
        this.f.addAll(arguments.getStringArrayList("choosedList"));
    }

    private void e() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.job_industry));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
        commonTopTitleNoTrans.setRightText(R.string.done);
        commonTopTitleNoTrans.setRightTextColor(2131102254);
    }

    private void f() {
        this.e = LayoutInflater.from(this.f33485a);
        this.f33486c = DialogUtils.a(getActivity());
        this.d = (FlowLayout) this.b.findViewById(R.id.user_job_flow_layout);
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return arrayList;
            }
            if (this.g.get(i2).checked == 1) {
                arrayList.add(this.g.get(i2).name);
            }
            i = i2 + 1;
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
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    public void a(final List<UserTag> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d.removeAllViews();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.d.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserJobFragment.1
                    @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
                    public void onItemClick(View view, int i3) {
                        Logger.a("drb", "mFlowLayout onItemClick");
                        UserTag userTag = (UserTag) list.get(i3);
                        if (userTag.checked == 0) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 >= list.size()) {
                                    break;
                                }
                                ((UserTag) list.get(i5)).checked = 0;
                                TextView textView = (TextView) ModifyUserJobFragment.this.d.getChildAt(i5).findViewById(2131372684);
                                textView.setBackgroundResource(R.drawable.user_job_text_bg);
                                textView.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.this.f33485a, 2131102254));
                                i4 = i5 + 1;
                            }
                            userTag.checked = 1;
                            TextView textView2 = (TextView) view.findViewById(2131372684);
                            textView2.setBackground(BluedSkinUtils.b(ModifyUserJobFragment.this.f33485a, R.drawable.user_job_text_select_bg));
                            textView2.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.this.f33485a, 2131101780));
                        } else {
                            userTag.checked = 0;
                            TextView textView3 = (TextView) view.findViewById(2131372684);
                            textView3.setBackground(BluedSkinUtils.b(ModifyUserJobFragment.this.f33485a, R.drawable.user_job_text_bg));
                            textView3.setTextColor(BluedSkinUtils.a(ModifyUserJobFragment.this.f33485a, 2131102254));
                        }
                        Log.v("drb", "userTag.checked = " + userTag.checked);
                    }
                });
                return;
            }
            View inflate = this.e.inflate(R.layout.user_job_text_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(2131372684);
            textView.setText(list.get(i2).name);
            Log.v("drb", "name:" + list.get(i2).name);
            if (list.get(i2).checked == 0) {
                textView.setBackground(BluedSkinUtils.b(this.f33485a, R.drawable.user_job_text_bg));
                textView.setTextColor(BluedSkinUtils.a(this.f33485a, 2131102254));
            } else {
                textView.setBackground(BluedSkinUtils.b(this.f33485a, R.drawable.user_job_text_select_bg));
                textView.setTextColor(BluedSkinUtils.a(this.f33485a, 2131101780));
            }
            this.d.addView(inflate);
            i = i2 + 1;
        }
    }

    public void b() {
        this.f.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            if (this.g.get(i2).checked == 1) {
                this.f.add(this.g.get(i2).id);
            }
            i = i2 + 1;
        }
    }

    public void c() {
        FindHttpUtils.a(this.f33485a, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserJobFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                ModifyUserJobFragment.this.g = bluedEntityA.data.get(0).work;
                ModifyUserJobFragment modifyUserJobFragment = ModifyUserJobFragment.this;
                modifyUserJobFragment.a(modifyUserJobFragment.f, ModifyUserJobFragment.this.g);
                ModifyUserJobFragment modifyUserJobFragment2 = ModifyUserJobFragment.this;
                modifyUserJobFragment2.a(modifyUserJobFragment2.g);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(ModifyUserJobFragment.this.f33486c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserJobFragment.this.f33486c);
            }
        }, getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131363126) {
        } else {
            b();
            Intent intent = new Intent();
            intent.putExtra("choosed_job_list", this.f);
            intent.putExtra("choosed_job_list_name", a());
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33485a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_job_for_modify, viewGroup, false);
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
