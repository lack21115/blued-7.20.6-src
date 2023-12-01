package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.NoScrollViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVirtualImagePackageBinding;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.vm.VirtualImageVM;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImagePackageFragment.class */
public final class VirtualImagePackageFragment extends MVIBaseFragment<VirtualImageVM> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(VirtualImagePackageFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FragmentVirtualImagePackageBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20511c;
    private List<VirtualImageModel.CategoryModel> d;
    private VirtualImageFragment.ImageCallBack e;
    private final List<VirtualImagePackageGoodsFragment> f;
    private GoodsPagerAdapter g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImagePackageFragment$GoodsPagerAdapter.class */
    public static final class GoodsPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final List<VirtualImagePackageGoodsFragment> f20512a;
        private final List<Integer> b;

        /* renamed from: c  reason: collision with root package name */
        private int f20513c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoodsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
            Intrinsics.e(fragmentManager, "fragmentManager");
            this.f20512a = new ArrayList();
            this.b = new ArrayList();
        }

        public final void a(int i) {
            this.f20512a.remove(i);
            this.b.remove(i);
        }

        public final void a(int i, VirtualImagePackageGoodsFragment virtualImagePackageGoodsFragment) {
            Intrinsics.e(virtualImagePackageGoodsFragment, "fragment");
            this.f20512a.add(i, virtualImagePackageGoodsFragment);
            List<Integer> list = this.b;
            int i2 = this.f20513c;
            this.f20513c = i2 + 1;
            list.add(i, Integer.valueOf(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f20512a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) this.f20512a.get(i);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return this.b.get(i).intValue();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.e(obj, "fm");
            if (obj instanceof VirtualImagePackageGoodsFragment) {
                if (this.f20512a.contains(obj)) {
                    return this.f20512a.indexOf(obj);
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }
    }

    public VirtualImagePackageFragment() {
        super((int) R.layout.fragment_virtual_image_package);
        this.f20511c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VirtualImagePackageFragment, FragmentVirtualImagePackageBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImagePackageFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImagePackageFragment;)Lcom/soft/blued/databinding/FragmentVirtualImagePackageBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImagePackageBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImagePackageFragment, FragmentVirtualImagePackageBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImagePackageFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImagePackageFragment;)Lcom/soft/blued/databinding/FragmentVirtualImagePackageBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImagePackageBinding.a(fragment.requireView());
            }
        });
        this.d = new ArrayList();
        this.f = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VirtualImageModel.CategoryModel categoryModel) {
        VirtualImageFragment.ImageCallBack imageCallBack = this.e;
        if (imageCallBack == null) {
            return;
        }
        imageCallBack.a(categoryModel.getZoom_in() == 1 ? 2 : 0);
    }

    private final VirtualImagePackageGoodsFragment b(VirtualImageModel.CategoryModel categoryModel) {
        VirtualImagePackageGoodsFragment virtualImagePackageGoodsFragment = new VirtualImagePackageGoodsFragment();
        virtualImagePackageGoodsFragment.a(b());
        Bundle bundle = new Bundle();
        bundle.putSerializable("data_category", categoryModel);
        virtualImagePackageGoodsFragment.setArguments(bundle);
        return virtualImagePackageGoodsFragment;
    }

    private final FragmentVirtualImagePackageBinding d() {
        return (FragmentVirtualImagePackageBinding) this.f20511c.b(this, b[0]);
    }

    private final void e() {
        FragmentVirtualImagePackageBinding d = d();
        if (d == null) {
            return;
        }
        int size = a().size();
        for (int i = 0; i < size; i++) {
            VirtualImageModel.CategoryModel categoryModel = a().get(i);
            PageTabLayout.Tab a2 = d.f15337a.a(i);
            if (a2 != null) {
                a2.a(categoryModel.getName());
            }
        }
    }

    public final List<VirtualImageModel.CategoryModel> a() {
        return this.d;
    }

    public final void a(VirtualImageFragment.ImageCallBack imageCallBack) {
        this.e = imageCallBack;
    }

    public final void a(List<VirtualImageModel.CategoryModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.d = list;
    }

    public final VirtualImageFragment.ImageCallBack b() {
        return this.e;
    }

    public final void b(List<VirtualImageModel.CategoryModel> list) {
        int i;
        Intrinsics.e(list, "newData");
        this.d = list;
        if (list.isEmpty()) {
            this.h = 0;
        } else if (this.h >= list.size()) {
            this.h = list.size() - 1;
        }
        ArrayList<Number> arrayList = new ArrayList();
        for (IndexedValue indexedValue : CollectionsKt.d(CollectionsKt.i(this.f))) {
            boolean z = false;
            for (VirtualImageModel.CategoryModel categoryModel : list) {
                int id = categoryModel.getId();
                Integer F = ((VirtualImagePackageGoodsFragment) indexedValue.b()).F();
                if (F != null && id == F.intValue()) {
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(Integer.valueOf(indexedValue.a()));
            }
        }
        for (Number number : arrayList) {
            int intValue = number.intValue();
            this.f.remove(intValue);
            GoodsPagerAdapter goodsPagerAdapter = this.g;
            if (goodsPagerAdapter != null) {
                goodsPagerAdapter.a(intValue);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = new ArrayList();
        for (VirtualImagePackageGoodsFragment virtualImagePackageGoodsFragment : this.f) {
            Integer F2 = virtualImagePackageGoodsFragment.F();
            if (F2 != null) {
                arrayList2.add(Integer.valueOf(F2.intValue()));
            }
        }
        int size = list.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            VirtualImageModel.CategoryModel categoryModel2 = list.get(i3);
            int size2 = arrayList2.size();
            int i4 = 0;
            while (true) {
                i = i4;
                if (i >= size2) {
                    i = -1;
                    break;
                } else if (((Number) arrayList2.get(i)).intValue() == categoryModel2.getId()) {
                    break;
                } else {
                    i4 = i + 1;
                }
            }
            if (i == -1) {
                VirtualImagePackageGoodsFragment b2 = b(categoryModel2);
                this.f.add(i3, b2);
                GoodsPagerAdapter goodsPagerAdapter2 = this.g;
                if (goodsPagerAdapter2 != null) {
                    goodsPagerAdapter2.a(i3, b2);
                }
            }
            i2 = i3 + 1;
        }
        GoodsPagerAdapter goodsPagerAdapter3 = this.g;
        if (goodsPagerAdapter3 != null) {
            goodsPagerAdapter3.notifyDataSetChanged();
        }
        for (VirtualImagePackageGoodsFragment virtualImagePackageGoodsFragment2 : this.f) {
            if (CollectionsKt.a(arrayList2, virtualImagePackageGoodsFragment2.F())) {
                Iterator<VirtualImageModel.CategoryModel> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        VirtualImageModel.CategoryModel next = it.next();
                        int id2 = next.getId();
                        Integer F3 = virtualImagePackageGoodsFragment2.F();
                        if (F3 != null && id2 == F3.intValue()) {
                            virtualImagePackageGoodsFragment2.a(next);
                            break;
                        }
                    }
                }
            }
        }
        arrayList2.clear();
        FragmentVirtualImagePackageBinding d = d();
        NoScrollViewPager noScrollViewPager = d == null ? null : d.f15338c;
        if (noScrollViewPager != null) {
            noScrollViewPager.setOffscreenPageLimit(list.size());
        }
        e();
    }

    public final void c() {
        if (!(!this.d.isEmpty()) || this.h >= this.f.size()) {
            return;
        }
        this.f.get(this.h).G();
    }

    public void m() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.g = new GoodsPagerAdapter(childFragmentManager);
        FragmentVirtualImagePackageBinding d = d();
        if (d != null) {
            d.b.setVisibility(a().isEmpty() ? 0 : 8);
            d.f15338c.setAdapter(this.g);
            d.f15338c.a(false);
            d.f15338c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImagePackageFragment$initView$1$1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    List list;
                    List list2;
                    VirtualImagePackageFragment.this.h = i;
                    VirtualImagePackageFragment virtualImagePackageFragment = VirtualImagePackageFragment.this;
                    virtualImagePackageFragment.a(virtualImagePackageFragment.a().get(i));
                    list = VirtualImagePackageFragment.this.f;
                    if (i < list.size()) {
                        list2 = VirtualImagePackageFragment.this.f;
                        ((VirtualImagePackageGoodsFragment) list2.get(i)).G();
                    }
                }
            });
            d.f15337a.setupWithViewPager(d.f15338c);
        }
        b(this.d);
    }

    public void o() {
    }
}
