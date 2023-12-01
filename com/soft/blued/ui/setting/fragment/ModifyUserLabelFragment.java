package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.BrowserContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
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
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.setting.View.UserLabelToolBarView;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserLabelFragment.class */
public class ModifyUserLabelFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33489a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33490c;
    private CustomViewPager d;
    private UserLabelToolBarView e;
    private LabelPagerAdapter h;
    private int j;
    private UserLabelAdapterNew k;
    private UserLabelAdapterNew l;
    private UserLabelAdapterNew m;
    private UserLabelAdapterNew n;
    private List<String> f = new ArrayList();
    private List<View> g = new ArrayList();
    private ArrayList<String> i = new ArrayList<>();
    private ViewPager.OnPageChangeListener o = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.6
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ModifyUserLabelFragment.this.e.setToolBtnSelect(i);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserLabelFragment$LabelPagerAdapter.class */
    public class LabelPagerAdapter extends PagerAdapter {
        LabelPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ModifyUserLabelFragment.this.f.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            while (ModifyUserLabelFragment.this.g.size() < ModifyUserLabelFragment.this.f.size()) {
                ModifyUserLabelFragment.this.g.add(LayoutInflater.from(ModifyUserLabelFragment.this.f33489a).inflate(R.layout.user_label_pager, viewGroup, false));
            }
            View view = (View) ModifyUserLabelFragment.this.g.get(i);
            PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.user_label_recycler_view);
            RecyclerView refreshableView = pullToRefreshRecyclerView.getRefreshableView();
            pullToRefreshRecyclerView.setRefreshEnabled(false);
            refreshableView.setLayoutManager(new GridLayoutManager(ModifyUserLabelFragment.this.f33489a, 1));
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && refreshableView.getAdapter() == null) {
                            refreshableView.setAdapter(ModifyUserLabelFragment.this.n);
                        }
                    } else if (refreshableView.getAdapter() == null) {
                        refreshableView.setAdapter(ModifyUserLabelFragment.this.m);
                    }
                } else if (refreshableView.getAdapter() == null) {
                    refreshableView.setAdapter(ModifyUserLabelFragment.this.l);
                }
            } else if (refreshableView.getAdapter() == null) {
                refreshableView.setAdapter(ModifyUserLabelFragment.this.k);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView((View) ModifyUserLabelFragment.this.g.get(i));
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public static void a(BaseFragment baseFragment, int i, ArrayList<String> arrayList, int i2) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("choosedList", arrayList);
        bundle.putInt(BrowserContract.Bookmarks.POSITION, i);
        TerminalActivity.a(baseFragment, ModifyUserLabelFragment.class, bundle, i2);
    }

    private void c() {
        Bundle arguments = getArguments();
        if (arguments.getStringArrayList("choosedList") != null) {
            this.i.addAll(arguments.getStringArrayList("choosedList"));
        }
        this.j = arguments.getInt(BrowserContract.Bookmarks.POSITION);
        String[] stringArray = this.f33489a.getResources().getStringArray(R.array.user_label_title);
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.f.add(stringArray[i2]);
            i = i2 + 1;
        }
    }

    private void d() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.my_label));
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
        commonTopTitleNoTrans.setRightText(R.string.done);
        commonTopTitleNoTrans.f();
        commonTopTitleNoTrans.setCenterTextColor(2131102254);
        commonTopTitleNoTrans.setRightTextColor(2131102254);
    }

    private void e() {
        this.f33490c = DialogUtils.a(getActivity());
        this.e = (UserLabelToolBarView) this.b.findViewById(R.id.user_label_tool_bar_view);
        CustomViewPager customViewPager = (CustomViewPager) this.b.findViewById(2131373209);
        this.d = customViewPager;
        customViewPager.setOnPageChangeListener(this.o);
        LabelPagerAdapter labelPagerAdapter = new LabelPagerAdapter();
        this.h = labelPagerAdapter;
        this.d.setAdapter(labelPagerAdapter);
        this.d.setCurrentItem(this.j);
        this.e.setOnToolBarItemClickListener(new UserLabelToolBarView.OnToolBarItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.1
            @Override // com.soft.blued.ui.setting.View.UserLabelToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                ModifyUserLabelFragment.this.d.setCurrentItem(i);
            }
        });
        this.k = new UserLabelAdapterNew(this.f33489a);
        this.l = new UserLabelAdapterNew(this.f33489a);
        this.m = new UserLabelAdapterNew(this.f33489a);
        this.n = new UserLabelAdapterNew(this.f33489a);
        this.k.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.2
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (userTag.tagList.get(i).chooseable) {
                    if (userTag.tagList.get(i).checked != 1) {
                        userTag.tagList.get(i).checked = 1;
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= userTag.tagList.size()) {
                                break;
                            }
                            if (i3 != i) {
                                userTag.tagList.get(i3).checked = 0;
                            }
                            i2 = i3 + 1;
                        }
                    } else {
                        userTag.tagList.get(i).checked = 0;
                    }
                    ModifyUserLabelFragment.this.k.notifyDataSetChanged();
                }
            }
        });
        this.l.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.3
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (userTag.tagList.get(i).chooseable) {
                    if (userTag.tagList.get(i).checked == 1) {
                        userTag.tagList.get(i).checked = 0;
                    } else {
                        ModifyUserLabelFragment modifyUserLabelFragment = ModifyUserLabelFragment.this;
                        int a2 = modifyUserLabelFragment.a(modifyUserLabelFragment.l);
                        if (a2 < 5) {
                            userTag.tagList.get(i).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyUserLabelFragment.this.a(userTag.tagList.get(i), userTag.tagList);
                    ModifyUserLabelFragment.this.l.notifyDataSetChanged();
                }
            }
        });
        this.m.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.4
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (userTag.tagList.get(i).chooseable) {
                    if (userTag.tagList.get(i).checked == 1) {
                        userTag.tagList.get(i).checked = 0;
                    } else {
                        ModifyUserLabelFragment modifyUserLabelFragment = ModifyUserLabelFragment.this;
                        int a2 = modifyUserLabelFragment.a(modifyUserLabelFragment.m);
                        if (a2 < 5) {
                            userTag.tagList.get(i).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyUserLabelFragment.this.m.notifyDataSetChanged();
                }
            }
        });
        this.n.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.5
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (userTag.tagList.get(i).chooseable) {
                    if (userTag.tagList.get(i).checked == 1) {
                        userTag.tagList.get(i).checked = 0;
                    } else {
                        ModifyUserLabelFragment modifyUserLabelFragment = ModifyUserLabelFragment.this;
                        int a2 = modifyUserLabelFragment.a(modifyUserLabelFragment.n);
                        if (a2 < 5) {
                            userTag.tagList.get(i).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyUserLabelFragment.this.n.notifyDataSetChanged();
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
                            if (userTag.tagList.get(i5).checked == 1) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object] */
    public ArrayList<String> a(int i) {
        List arrayList = new ArrayList();
        if (i == 0) {
            arrayList = this.k.getData();
        } else if (i == 1) {
            arrayList = this.l.getData();
        } else if (i == 2) {
            arrayList = this.m.getData();
        } else if (i == 3) {
            arrayList = this.n.getData();
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                return arrayList2;
            }
            UserTag userTag = (UserTag) arrayList.get(i3);
            if (userTag != null && userTag.tagList != null) {
                for (UserTag userTag2 : userTag.tagList) {
                    if (userTag2.checked == 1) {
                        arrayList2.add(userTag2.name);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    public void a() {
        FindHttpUtils.a(this.f33489a, new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLabelFragment.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                List<UserTag> list = bluedEntityA.data.get(0).sports;
                List<UserTag> list2 = bluedEntityA.data.get(0).art;
                List<UserTag> list3 = bluedEntityA.data.get(0).leisure;
                List<UserTag> list4 = bluedEntityA.data.get(0).food;
                List<UserTag> list5 = bluedEntityA.data.get(0).fashion;
                List<UserTag> list6 = bluedEntityA.data.get(0).collection;
                List<UserTag> list7 = bluedEntityA.data.get(0).pets;
                List<UserTag> list8 = bluedEntityA.data.get(0).technology;
                List<UserTag> list9 = bluedEntityA.data.get(0).books;
                List<UserTag> list10 = bluedEntityA.data.get(0).movies;
                List<UserTag> list11 = bluedEntityA.data.get(0).music;
                List<UserTag> list12 = bluedEntityA.data.get(0).type;
                List<UserTag> list13 = bluedEntityA.data.get(0).character;
                ModifyUserLabelFragment modifyUserLabelFragment = ModifyUserLabelFragment.this;
                modifyUserLabelFragment.a(modifyUserLabelFragment.i, list12);
                ModifyUserLabelFragment modifyUserLabelFragment2 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment2.a(modifyUserLabelFragment2.i, list13);
                ModifyUserLabelFragment modifyUserLabelFragment3 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment3.a(modifyUserLabelFragment3.i, list);
                ModifyUserLabelFragment modifyUserLabelFragment4 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment4.a(modifyUserLabelFragment4.i, list2);
                ModifyUserLabelFragment modifyUserLabelFragment5 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment5.a(modifyUserLabelFragment5.i, list3);
                ModifyUserLabelFragment modifyUserLabelFragment6 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment6.a(modifyUserLabelFragment6.i, list4);
                ModifyUserLabelFragment modifyUserLabelFragment7 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment7.a(modifyUserLabelFragment7.i, list5);
                ModifyUserLabelFragment modifyUserLabelFragment8 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment8.a(modifyUserLabelFragment8.i, list6);
                ModifyUserLabelFragment modifyUserLabelFragment9 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment9.a(modifyUserLabelFragment9.i, list7);
                ModifyUserLabelFragment modifyUserLabelFragment10 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment10.a(modifyUserLabelFragment10.i, list8);
                ModifyUserLabelFragment modifyUserLabelFragment11 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment11.a(modifyUserLabelFragment11.i, list9);
                ModifyUserLabelFragment modifyUserLabelFragment12 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment12.a(modifyUserLabelFragment12.i, list10);
                ModifyUserLabelFragment modifyUserLabelFragment13 = ModifyUserLabelFragment.this;
                modifyUserLabelFragment13.a(modifyUserLabelFragment13.i, list11);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.sports), 1));
                arrayList.add(new UserTag(list));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.art), 1));
                arrayList.add(new UserTag(list2));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.leisure), 1));
                arrayList.add(new UserTag(list3));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.food), 1));
                arrayList.add(new UserTag(list4));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.fashion), 1));
                arrayList.add(new UserTag(list5));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.collection), 1));
                arrayList.add(new UserTag(list6));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.pets), 1));
                arrayList.add(new UserTag(list7));
                arrayList.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.technology), 1));
                arrayList.add(new UserTag(list8));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.books), 1));
                arrayList2.add(new UserTag(list9));
                arrayList2.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.movies), 1));
                arrayList2.add(new UserTag(list10));
                arrayList2.add(new UserTag(ModifyUserLabelFragment.this.f33489a.getResources().getString(R.string.music), 1));
                arrayList2.add(new UserTag(list11));
                ModifyUserLabelFragment.this.k.addData((UserLabelAdapterNew) new UserTag(list12));
                ModifyUserLabelFragment.this.l.addData((UserLabelAdapterNew) new UserTag(list13));
                ModifyUserLabelFragment.this.m.addData((Collection) arrayList);
                ModifyUserLabelFragment.this.n.addData((Collection) arrayList2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(ModifyUserLabelFragment.this.f33490c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserLabelFragment.this.f33490c);
            }
        }, getFragmentActive());
    }

    public void a(UserTag userTag, List<UserTag> list) {
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
                    if (i4 < list.size()) {
                        if (userTag.exclude_id[i2].equals(list.get(i4).id)) {
                            list.get(i4).chooseable = false;
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            }
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= userTag.exclude_id.length) {
                    return;
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < list.size()) {
                        if (userTag.exclude_id[i6].equals(list.get(i8).id)) {
                            list.get(i8).chooseable = true;
                        }
                        i7 = i8 + 1;
                    }
                }
                i5 = i6 + 1;
            }
        }
    }

    public void a(ArrayList<String> arrayList, List<UserTag> list) {
        if (list == null) {
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
        if (arrayList == null || arrayList.size() <= 0) {
            return;
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
                        a(userTag, list);
                    }
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    public void b() {
        int i;
        this.i.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.k.getData().size()) {
                break;
            }
            UserTag userTag = (UserTag) this.k.getData().get(i3);
            if (userTag != null && userTag.tagList != null) {
                for (UserTag userTag2 : userTag.tagList) {
                    if (userTag2.checked == 1) {
                        this.i.add(userTag2.id);
                    }
                }
            }
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.l.getData().size()) {
                break;
            }
            UserTag userTag3 = (UserTag) this.l.getData().get(i5);
            if (userTag3 != null && userTag3.tagList != null) {
                for (UserTag userTag4 : userTag3.tagList) {
                    if (userTag4.checked == 1) {
                        this.i.add(userTag4.id);
                    }
                }
            }
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.m.getData().size()) {
                break;
            }
            UserTag userTag5 = (UserTag) this.m.getData().get(i7);
            if (userTag5 != null && userTag5.tagList != null) {
                for (UserTag userTag6 : userTag5.tagList) {
                    if (userTag6.checked == 1) {
                        this.i.add(userTag6.id);
                    }
                }
            }
            i6 = i7 + 1;
        }
        for (i = 0; i < this.n.getData().size(); i++) {
            UserTag userTag7 = (UserTag) this.n.getData().get(i);
            if (userTag7 != null && userTag7.tagList != null) {
                for (UserTag userTag8 : userTag7.tagList) {
                    if (userTag8.checked == 1) {
                        this.i.add(userTag8.id);
                    }
                }
            }
        }
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
            intent.putExtra("choosed_label_list", this.i);
            intent.putExtra("choosed_shape_list_name", a(0));
            intent.putExtra("choosed_personality_list_name", a(1));
            intent.putExtra("choosed_hobby_list_name", a(2));
            intent.putExtra("choosed_douban_list_name", a(3));
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33489a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_label_for_modify, viewGroup, false);
            c();
            e();
            d();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
