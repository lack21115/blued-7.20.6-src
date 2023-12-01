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
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.setting.View.UserLikeToolBarView;
import com.soft.blued.ui.setting.adapter.UserLabelAdapterNew;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserLikeFragment.class */
public class ModifyUserLikeFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19808a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f19809c;
    private CustomViewPager d;
    private UserLikeToolBarView e;
    private LabelPagerAdapter h;
    private int j;
    private UserLabelAdapterNew k;
    private UserLabelAdapterNew l;
    private List<String> f = new ArrayList();
    private List<View> g = new ArrayList();
    private ArrayList<String> i = new ArrayList<>();
    private ViewPager.OnPageChangeListener m = new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLikeFragment.4
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ModifyUserLikeFragment.this.e.setToolBtnSelect(i);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyUserLikeFragment$LabelPagerAdapter.class */
    public class LabelPagerAdapter extends PagerAdapter {
        LabelPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ModifyUserLikeFragment.this.f.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            while (ModifyUserLikeFragment.this.g.size() < ModifyUserLikeFragment.this.f.size()) {
                ModifyUserLikeFragment.this.g.add(LayoutInflater.from(ModifyUserLikeFragment.this.f19808a).inflate(R.layout.user_label_pager, viewGroup, false));
            }
            View view = (View) ModifyUserLikeFragment.this.g.get(i);
            PullToRefreshRecyclerView findViewById = view.findViewById(R.id.user_label_recycler_view);
            RecyclerView recyclerView = (RecyclerView) findViewById.getRefreshableView();
            recyclerView.setLayoutManager(new GridLayoutManager(ModifyUserLikeFragment.this.f19808a, 1));
            findViewById.setRefreshEnabled(false);
            if (i != 0) {
                if (i == 1 && recyclerView.getAdapter() == null) {
                    recyclerView.setAdapter(ModifyUserLikeFragment.this.l);
                }
            } else if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(ModifyUserLikeFragment.this.k);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView((View) ModifyUserLikeFragment.this.g.get(i));
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
        TerminalActivity.a(baseFragment, ModifyUserLikeFragment.class, bundle, i2);
    }

    private void c() {
        Bundle arguments = getArguments();
        if (arguments.getStringArrayList("choosedList") != null) {
            this.i.addAll(arguments.getStringArrayList("choosedList"));
        }
        this.j = arguments.getInt(BrowserContract.Bookmarks.POSITION);
        String[] stringArray = this.f19808a.getResources().getStringArray(R.array.user_like_title);
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
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.favorite_types));
        findViewById.setLeftClickListener(this);
        findViewById.setRightClickListener(this);
        findViewById.setRightText((int) R.string.done);
        findViewById.setRightTextColor(2131102254);
    }

    private void e() {
        this.f19809c = DialogUtils.a(getActivity());
        this.e = (UserLikeToolBarView) this.b.findViewById(R.id.user_like_tool_bar_view);
        CustomViewPager customViewPager = (CustomViewPager) this.b.findViewById(R.id.view_pager);
        this.d = customViewPager;
        customViewPager.setOnPageChangeListener(this.m);
        LabelPagerAdapter labelPagerAdapter = new LabelPagerAdapter();
        this.h = labelPagerAdapter;
        this.d.setAdapter(labelPagerAdapter);
        this.d.setCurrentItem(this.j);
        this.e.setOnToolBarItemClickListener(new UserLikeToolBarView.OnToolBarItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLikeFragment.1
            @Override // com.soft.blued.ui.setting.View.UserLikeToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                ModifyUserLikeFragment.this.d.setCurrentItem(i);
            }
        });
        this.k = new UserLabelAdapterNew(this.f19808a);
        this.l = new UserLabelAdapterNew(this.f19808a);
        this.k.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLikeFragment.2
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (((UserTag) userTag.tagList.get(i)).chooseable) {
                    if (((UserTag) userTag.tagList.get(i)).checked == 1) {
                        ((UserTag) userTag.tagList.get(i)).checked = 0;
                    } else {
                        ModifyUserLikeFragment modifyUserLikeFragment = ModifyUserLikeFragment.this;
                        int a2 = modifyUserLikeFragment.a(modifyUserLikeFragment.k);
                        if (a2 < 5) {
                            ((UserTag) userTag.tagList.get(i)).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyUserLikeFragment.this.k.notifyDataSetChanged();
                }
            }
        });
        this.l.a(new UserLabelAdapterNew.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLikeFragment.3
            @Override // com.soft.blued.ui.setting.adapter.UserLabelAdapterNew.OnItemClickListener
            public void a(UserTag userTag, int i) {
                if (((UserTag) userTag.tagList.get(i)).chooseable) {
                    if (((UserTag) userTag.tagList.get(i)).checked == 1) {
                        ((UserTag) userTag.tagList.get(i)).checked = 0;
                    } else {
                        ModifyUserLikeFragment modifyUserLikeFragment = ModifyUserLikeFragment.this;
                        int a2 = modifyUserLikeFragment.a(modifyUserLikeFragment.l);
                        if (a2 < 5) {
                            ((UserTag) userTag.tagList.get(i)).checked = 1;
                        } else if (a2 == 5) {
                            AppMethods.d((int) R.string.max_tags_5);
                        }
                    }
                    ModifyUserLikeFragment.this.l.notifyDataSetChanged();
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

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayList<String> a(int i) {
        List arrayList = new ArrayList();
        if (i == 0) {
            arrayList = this.k.getData();
        } else if (i == 1) {
            arrayList = this.l.getData();
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
        FindHttpUtils.a(this.f19808a, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<UserTagAll>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.ModifyUserLikeFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserTagAll> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                List<UserTag> list = ((UserTagAll) bluedEntityA.data.get(0)).love_type;
                List<UserTag> list2 = ((UserTagAll) bluedEntityA.data.get(0)).love_character;
                ModifyUserLikeFragment modifyUserLikeFragment = ModifyUserLikeFragment.this;
                modifyUserLikeFragment.a(modifyUserLikeFragment.i, list);
                ModifyUserLikeFragment modifyUserLikeFragment2 = ModifyUserLikeFragment.this;
                modifyUserLikeFragment2.a(modifyUserLikeFragment2.i, list2);
                ModifyUserLikeFragment.this.k.addData((UserLabelAdapterNew) new UserTag(list));
                ModifyUserLikeFragment.this.l.addData((UserLabelAdapterNew) new UserTag(list2));
            }

            public void onUIFinish() {
                DialogUtils.b(ModifyUserLikeFragment.this.f19809c);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(ModifyUserLikeFragment.this.f19809c);
            }
        }, (IRequestHost) getFragmentActive());
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
        for (i = 0; i < this.l.getData().size(); i++) {
            UserTag userTag3 = (UserTag) this.l.getData().get(i);
            if (userTag3 != null && userTag3.tagList != null) {
                for (UserTag userTag4 : userTag3.tagList) {
                    if (userTag4.checked == 1) {
                        this.i.add(userTag4.id);
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
            intent.putExtra("choosed_like_list", this.i);
            intent.putExtra("choosed_like_shape_list_name", a(0));
            intent.putExtra("choosed_like_personality_list_name", a(1));
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19808a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_user_like_for_modify, viewGroup, false);
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
