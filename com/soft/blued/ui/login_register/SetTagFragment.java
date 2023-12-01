package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.databinding.LoginFmSetTagBinding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.utils.LoginHelper;
import com.blued.login.view.TagIndicator;
import com.blued.login.view.TagViewPager;
import com.blued.login.view.ViewPagerAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/SetTagFragment.class */
public final class SetTagFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f31486a = {Reflection.a(new PropertyReference1Impl(SetTagFragment.class, "vb", "getVb()Lcom/blued/login/databinding/LoginFmSetTagBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private UserTagAll f31487c;
    private final ArrayList<TagBean> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/SetTagFragment$ChangeSpeedScroller.class */
    public static final class ChangeSpeedScroller extends Scroller {

        /* renamed from: a  reason: collision with root package name */
        private int f31488a;

        public ChangeSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
            this.f31488a = 250;
        }

        public final void a(int i) {
            this.f31488a = i;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.f31488a);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/SetTagFragment$TagBean.class */
    public static final class TagBean {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private List<? extends UserTag> f31490c;
        private int d;

        /* renamed from: a  reason: collision with root package name */
        private String f31489a = "";
        private ArrayList<UserTag> e = new ArrayList<>();

        public final String a() {
            return this.f31489a;
        }

        public final void a(int i) {
            this.b = i;
        }

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            this.f31489a = str;
        }

        public final void a(List<? extends UserTag> list) {
            this.f31490c = list;
        }

        public final int b() {
            return this.b;
        }

        public final void b(int i) {
            this.d = i;
        }

        public final List<UserTag> c() {
            return this.f31490c;
        }

        public final int d() {
            return this.d;
        }

        public final ArrayList<UserTag> e() {
            return this.e;
        }
    }

    public SetTagFragment() {
        super(2131560735);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<SetTagFragment, LoginFmSetTagBinding>() { // from class: com.soft.blued.ui.login_register.SetTagFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LoginFmSetTagBinding invoke(SetTagFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LoginFmSetTagBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SetTagFragment, LoginFmSetTagBinding>() { // from class: com.soft.blued.ui.login_register.SetTagFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final LoginFmSetTagBinding invoke(SetTagFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return LoginFmSetTagBinding.a(fragment.requireView());
            }
        });
        this.d = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        dialogInterface.dismiss();
    }

    private final void a(final TagBean tagBean, FlowLayout flowLayout) {
        final List<UserTag> c2 = tagBean.c();
        if (c2 == null) {
            return;
        }
        flowLayout.removeAllViews();
        int size = c2.size();
        for (int i = 0; i < size; i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(2131560737, (ViewGroup) null);
            Intrinsics.c(inflate, "from(context)\n          …gin_role_text_view, null)");
            TextView textView = (TextView) inflate.findViewById(2131372684);
            textView.setText(c2.get(i).name);
            if (c2.get(i).checked == 0) {
                textView.setBackground(BluedSkinUtils.b(getContext(), 2131235766));
                textView.setTextColor(BluedSkinUtils.a(getContext(), 2131102254));
            } else {
                textView.setBackground(BluedSkinUtils.b(getContext(), 2131235767));
                textView.setTextColor(BluedSkinUtils.a(getContext(), 2131101780));
            }
            flowLayout.addView(inflate);
        }
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$SetTagFragment$LPZDE87Dh_pdOsW4yIkx_D2q3oA
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                SetTagFragment.a(List.this, tagBean, this, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SetTagFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SetTagFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_SKIP_CLICK, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
        if (this$0.u()) {
            this$0.s();
        } else {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        BluedPreferences.eV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List it, TagBean item, SetTagFragment this$0, View view, int i) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        UserTag userTag = (UserTag) it.get(i);
        TextView textView = (TextView) view.findViewById(2131372684);
        if (userTag.checked != 0) {
            userTag.checked = 0;
            textView.setBackgroundResource(2131235766);
            textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), 2131102254));
            item.e().remove(userTag);
        } else if (item.e().size() == item.b()) {
            ToastUtils.a(this$0.getString(2131890422));
        } else {
            userTag.checked = 1;
            textView.setBackground(BluedSkinUtils.b(this$0.getContext(), 2131235767));
            textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), 2131101780));
            item.e().add(userTag);
            if (item.e().size() == item.b()) {
                if (this$0.t()) {
                    this$0.v();
                } else if (item.d() == this$0.d.size() - 1) {
                    ToastUtils.a(this$0.getString(2131890423));
                } else {
                    LoginFmSetTagBinding q = this$0.q();
                    TagViewPager tagViewPager = q == null ? null : q.d;
                    if (tagViewPager == null) {
                        return;
                    }
                    tagViewPager.setCurrentItem(item.d() + 1);
                }
            }
        }
    }

    private final void a(Map<String, String> map) {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        UserHttpUtils.a(getActivity(), new BluedUIHttpResponse<BluedEntityA<BluedLoginResult>>(fragmentActive) { // from class: com.soft.blued.ui.login_register.SetTagFragment$modifyUserProfile$1
            private String b;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedLoginResult> bluedEntityA) {
                if ((bluedEntityA == null ? null : bluedEntityA.data) == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                UserInfo.getInstance().setLoginUserInfo(bluedEntityA.data.get(0));
                UserAccountsVDao.a().b(this.b);
                BluedPreferences.eV();
                FragmentActivity activity = SetTagFragment.this.getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onSuccess(String content) {
                Intrinsics.e(content, "content");
                super.onSuccess(content);
                this.b = content;
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), map, getFragmentActive());
    }

    private final LoginFmSetTagBinding q() {
        return (LoginFmSetTagBinding) this.b.b(this, f31486a[0]);
    }

    private final void r() {
        TagViewPager tagViewPager;
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            LoginFmSetTagBinding q = q();
            ChangeSpeedScroller changeSpeedScroller = new ChangeSpeedScroller((q == null || (tagViewPager = q.d) == null) ? null : tagViewPager.getContext(), new AccelerateInterpolator());
            changeSpeedScroller.a(500);
            LoginFmSetTagBinding q2 = q();
            declaredField.set(q2 == null ? null : q2.d, changeSpeedScroller);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private final void s() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.f(2131101766).g(2131102263).a(getString(2131890473)).b(getString(2131890472)).a((View) null).a(getString(2131890442), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$SetTagFragment$Qj4mSvHpkTPp1Jl3EK1fsey6Rok
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SetTagFragment.a(dialogInterface, i);
            }
        }).b(getString(2131890475), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$SetTagFragment$jBywVQ_dJhxVN9TiXTBp0v1MPmA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SetTagFragment.a(SetTagFragment.this, dialogInterface, i);
            }
        }).a(false).b(true).a((DialogInterface.OnDismissListener) null).a(0).b(0);
        BluedAlertDialog a2 = builder.a();
        a2.setCanceledOnTouchOutside(true);
        a2.show();
    }

    private final boolean t() {
        for (TagBean tagBean : this.d) {
            if (tagBean.e().size() != tagBean.b()) {
                return false;
            }
        }
        return true;
    }

    private final boolean u() {
        Iterator<TagBean> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().e().size() > 0) {
                return true;
            }
        }
        return false;
    }

    private final void v() {
        StringBuilder sb = new StringBuilder();
        Iterator<TagBean> it = this.d.iterator();
        while (it.hasNext()) {
            TagBean next = it.next();
            if (next.e().size() != next.b()) {
                return;
            }
            Iterator<UserTag> it2 = next.e().iterator();
            while (it2.hasNext()) {
                sb.append(Intrinsics.a(it2.next().id, (Object) ","));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "stringBuilder.toString()");
        if (sb2.length() == 0) {
            return;
        }
        String substring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Map<String, String> ajaxParams = BluedHttpTools.a();
        Intrinsics.c(ajaxParams, "ajaxParams");
        ajaxParams.put("tags", substring);
        a(ajaxParams);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        TextView textView;
        TagViewPager tagViewPager;
        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_MY_BODY_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("login_data_tag")) {
            Serializable serializable = arguments.getSerializable("login_data_tag");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.user.model.UserTagAll");
            }
            this.f31487c = (UserTagAll) serializable;
            ArrayList<TagBean> arrayList = this.d;
            TagBean tagBean = new TagBean();
            String string = getString(R.string.i_bodytype);
            Intrinsics.c(string, "getString(R.string.i_bodytype)");
            tagBean.a(string);
            tagBean.a(1);
            UserTagAll userTagAll = this.f31487c;
            UserTagAll userTagAll2 = userTagAll;
            if (userTagAll == null) {
                Intrinsics.c("tagData");
                userTagAll2 = null;
            }
            tagBean.a(userTagAll2.type);
            tagBean.b(0);
            arrayList.add(tagBean);
            ArrayList<TagBean> arrayList2 = this.d;
            TagBean tagBean2 = new TagBean();
            String string2 = getString(R.string.my_tags);
            Intrinsics.c(string2, "getString(R.string.my_tags)");
            tagBean2.a(string2);
            tagBean2.a(2);
            UserTagAll userTagAll3 = this.f31487c;
            UserTagAll userTagAll4 = userTagAll3;
            if (userTagAll3 == null) {
                Intrinsics.c("tagData");
                userTagAll4 = null;
            }
            tagBean2.a(userTagAll4.character);
            tagBean2.b(1);
            arrayList2.add(tagBean2);
            ArrayList<TagBean> arrayList3 = this.d;
            TagBean tagBean3 = new TagBean();
            String string3 = getString(R.string.my_making_friends);
            Intrinsics.c(string3, "getString(R.string.my_making_friends)");
            tagBean3.a(string3);
            tagBean3.a(1);
            UserTagAll userTagAll5 = this.f31487c;
            UserTagAll userTagAll6 = userTagAll5;
            if (userTagAll5 == null) {
                Intrinsics.c("tagData");
                userTagAll6 = null;
            }
            tagBean3.a(userTagAll6.i_want);
            tagBean3.b(2);
            arrayList3.add(tagBean3);
            ArrayList<TagBean> arrayList4 = this.d;
            TagBean tagBean4 = new TagBean();
            String string4 = getString(R.string.he_bodytype);
            Intrinsics.c(string4, "getString(R.string.he_bodytype)");
            tagBean4.a(string4);
            tagBean4.a(1);
            UserTagAll userTagAll7 = this.f31487c;
            UserTagAll userTagAll8 = userTagAll7;
            if (userTagAll7 == null) {
                Intrinsics.c("tagData");
                userTagAll8 = null;
            }
            tagBean4.a(userTagAll8.love_type);
            tagBean4.b(3);
            arrayList4.add(tagBean4);
            ArrayList<TagBean> arrayList5 = this.d;
            TagBean tagBean5 = new TagBean();
            String string5 = getString(R.string.his_tags);
            Intrinsics.c(string5, "getString(R.string.his_tags)");
            tagBean5.a(string5);
            tagBean5.a(1);
            UserTagAll userTagAll9 = this.f31487c;
            if (userTagAll9 == null) {
                Intrinsics.c("tagData");
                userTagAll9 = null;
            }
            tagBean5.a(userTagAll9.love_character);
            tagBean5.b(4);
            arrayList5.add(tagBean5);
        }
        LoginFmSetTagBinding q = q();
        if (q != null && (tagViewPager = q.d) != null) {
            tagViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.login_register.SetTagFragment$initView$2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    if (i == 0) {
                        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_MY_BODY_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
                    } else if (i == 1) {
                        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_MY_LABEL_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
                    } else if (i == 2) {
                        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_MY_PURPOSE_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
                    } else if (i == 3) {
                        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_HIS_BODY_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
                    } else if (i != 4) {
                    } else {
                        EventTrackLogin.a(LoginAndRegisterProtos.Event.REGISTER_LABEL_HIS_LABEL_SHOW, LoginHelper.f20590a.a(LoginHelper.f20590a.a()));
                    }
                }
            });
        }
        LoginFmSetTagBinding q2 = q();
        if (q2 != null && (textView = q2.f20528c) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.login_register.-$$Lambda$SetTagFragment$9vnMBtePlQiLfvj7-Bu5B7UAgoE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SetTagFragment.a(SetTagFragment.this, view);
                }
            });
        }
        p();
        r();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return true;
    }

    public final void p() {
        TagViewPager tagViewPager;
        ArrayList arrayList = new ArrayList();
        Iterator<TagBean> it = this.d.iterator();
        while (true) {
            tagViewPager = null;
            if (!it.hasNext()) {
                break;
            }
            TagBean item = it.next();
            View inflate = View.inflate(getContext(), 2131561370, null);
            ((TextView) inflate.findViewById(2131372754)).setText(item.a());
            TextView textView = (TextView) inflate.findViewById(2131372765);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = getString(2131890424);
            Intrinsics.c(string, "getString(R.string.login_choose_tag)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(item.b())}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
            FlowLayout flow_layout = (FlowLayout) inflate.findViewById(2131363977);
            Intrinsics.c(item, "item");
            Intrinsics.c(flow_layout, "flow_layout");
            a(item, flow_layout);
            arrayList.add(inflate);
        }
        LoginFmSetTagBinding q = q();
        if (q != null) {
            tagViewPager = q.d;
        }
        if (tagViewPager != null) {
            tagViewPager.setAdapter(new ViewPagerAdapter(arrayList));
        }
        LoginFmSetTagBinding q2 = q();
        if (q2 == null) {
            return;
        }
        TagIndicator tagIndicator = q2.b;
        int size = this.d.size();
        TagViewPager tagViewPager2 = q2.d;
        Intrinsics.c(tagViewPager2, "it.viewPager");
        tagIndicator.a(size, tagViewPager2);
    }
}
