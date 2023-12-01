package com.blued.community.ui.send.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.community.R;
import com.blued.community.databinding.FragmentCollectionAddPostBinding;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.observer.IAddPost;
import com.blued.community.ui.send.observer.OnAddPostTitleListener;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.das.client.feed.FeedProtos;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/CollectionAddPostFragment.class */
public final class CollectionAddPostFragment extends MVVMBaseFragment<EmptyViewModel> {
    private final ViewBindingProperty c;
    private final Lazy d;
    private MyAdapter e;
    private final OnAddPostTitleListener f;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(CollectionAddPostFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentCollectionAddPostBinding;", 0))};
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/CollectionAddPostFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, CollectionAddPostFragment.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/CollectionAddPostFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {
        private final Context a;
        private final OnAddPostTitleListener b;
        private IAddPost c;
        private final List<Integer> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, OnAddPostTitleListener addPostTitleListener, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(addPostTitleListener, "addPostTitleListener");
            Intrinsics.e(fm, "fm");
            this.a = context;
            this.b = addPostTitleListener;
            this.d = CollectionsKt.b(Integer.valueOf(R.string.feed_feeds), Integer.valueOf(R.string.event_events));
        }

        public final IAddPost a() {
            return this.c;
        }

        public final Context getContext() {
            return this.a;
        }

        public int getCount() {
            return this.d.size();
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                FeedAddPostFragment feedAddPostFragment = new FeedAddPostFragment();
                feedAddPostFragment.C();
                feedAddPostFragment.a(this.b);
                return feedAddPostFragment;
            }
            EventAddPostFragment eventAddPostFragment = new EventAddPostFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("event_from_page", (Serializable) FeedProtos.SourcePage.ONE_CITY);
            eventAddPostFragment.setArguments(bundle);
            eventAddPostFragment.a(this.b);
            return eventAddPostFragment;
        }

        public CharSequence getPageTitle(int i) {
            Context context = this.a;
            return context == null ? null : context.getString(this.d.get(i).intValue());
        }

        public void setPrimaryItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            this.c = (IAddPost) object;
            super.setPrimaryItem(container, i, object);
        }
    }

    public CollectionAddPostFragment() {
        super(R.layout.fragment_collection_add_post);
        this.c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<CollectionAddPostFragment, FragmentCollectionAddPostBinding>() { // from class: com.blued.community.ui.send.fragment.CollectionAddPostFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCollectionAddPostBinding invoke(CollectionAddPostFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCollectionAddPostBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<CollectionAddPostFragment, FragmentCollectionAddPostBinding>() { // from class: com.blued.community.ui.send.fragment.CollectionAddPostFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentCollectionAddPostBinding invoke(CollectionAddPostFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentCollectionAddPostBinding.a(fragment.requireView());
            }
        });
        this.d = LazyKt.a(new Function0<SelectAlbumViewModel>() { // from class: com.blued.community.ui.send.fragment.CollectionAddPostFragment$mAlbumViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final SelectAlbumViewModel invoke() {
                ViewModelStore viewModelStore = CollectionAddPostFragment.this.requireActivity().getViewModelStore();
                Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
                Application application = CollectionAddPostFragment.this.requireActivity().getApplication();
                Intrinsics.c(application, "requireActivity().application");
                return (SelectAlbumViewModel) new ViewModelProvider(viewModelStore, new ViewModelProvider.AndroidViewModelFactory(application)).get(SelectAlbumViewModel.class);
            }
        });
        this.f = new OnAddPostTitleListener() { // from class: com.blued.community.ui.send.fragment.CollectionAddPostFragment$titleChangeListener$1
            @Override // com.blued.community.ui.send.observer.OnAddPostTitleListener
            public void a() {
                CollectionAddPostFragment.this.r();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CollectionAddPostFragment this$0, View view) {
        IAddPost a2;
        Intrinsics.e(this$0, "this$0");
        MyAdapter myAdapter = this$0.e;
        if (myAdapter == null || (a2 = myAdapter.a()) == null) {
            return;
        }
        a2.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CollectionAddPostFragment this$0, View view) {
        IAddPost a2;
        Intrinsics.e(this$0, "this$0");
        MyAdapter myAdapter = this$0.e;
        if (myAdapter == null || (a2 = myAdapter.a()) == null) {
            return;
        }
        a2.y();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        TabPageIndicatorWithDot tabPageIndicatorWithDot2;
        ShapeTextView shapeTextView;
        ImageView imageView;
        CustomViewPager customViewPager;
        TabPageIndicatorWithDot tabPageIndicatorWithDot3;
        TabPageIndicatorWithDot tabPageIndicatorWithDot4;
        TabPageIndicatorWithDot tabPageIndicatorWithDot5;
        Context context = getContext();
        OnAddPostTitleListener onAddPostTitleListener = this.f;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.e = new MyAdapter(context, onAddPostTitleListener, childFragmentManager);
        FragmentCollectionAddPostBinding p = p();
        CustomViewPager customViewPager2 = p == null ? null : p.d;
        if (customViewPager2 != null) {
            customViewPager2.setAdapter((PagerAdapter) this.e);
        }
        FragmentCollectionAddPostBinding p2 = p();
        if (p2 != null && (tabPageIndicatorWithDot5 = p2.e) != null) {
            FragmentCollectionAddPostBinding p3 = p();
            tabPageIndicatorWithDot5.setViewPager(p3 == null ? null : p3.d);
        }
        if (CommunityManager.a.a().s()) {
            FragmentCollectionAddPostBinding p4 = p();
            if (p4 != null && (tabPageIndicatorWithDot4 = p4.e) != null) {
                tabPageIndicatorWithDot4.setRealTextColor(R.color.syc_EAEAEA);
            }
            FragmentCollectionAddPostBinding p5 = p();
            if (p5 != null && (tabPageIndicatorWithDot3 = p5.e) != null) {
                tabPageIndicatorWithDot3.setRealTabTextColorUnfocused(R.color.syc_dark_d0d0d0);
            }
        } else {
            FragmentCollectionAddPostBinding p6 = p();
            if (p6 != null && (tabPageIndicatorWithDot2 = p6.e) != null) {
                tabPageIndicatorWithDot2.setRealTextColor(R.color.syc_h);
            }
            FragmentCollectionAddPostBinding p7 = p();
            if (p7 != null && (tabPageIndicatorWithDot = p7.e) != null) {
                tabPageIndicatorWithDot.setRealTabTextColorUnfocused(R.color.syc_j);
            }
        }
        FragmentCollectionAddPostBinding p8 = p();
        if (p8 != null && (customViewPager = p8.d) != null) {
            customViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.community.ui.send.fragment.CollectionAddPostFragment$initView$1
                public void onPageScrollStateChanged(int i) {
                    SelectPhotoManager.a().d();
                    AlbumDataManager.clear();
                    ChildPhotoManager.a().d();
                    CollectionAddPostFragment.this.q().f().setValue((Object) null);
                    CollectionAddPostFragment.this.q().j().setValue(true);
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    CollectionAddPostFragment.this.r();
                }
            });
        }
        FragmentCollectionAddPostBinding p9 = p();
        if (p9 != null && (imageView = p9.a) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$CollectionAddPostFragment$lroJ-nlDgS2OcH-c9AtCGD8rqt4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionAddPostFragment.a(CollectionAddPostFragment.this, view);
                }
            });
        }
        FragmentCollectionAddPostBinding p10 = p();
        if (p10 == null || (shapeTextView = p10.c) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$CollectionAddPostFragment$fPiOVlmelX8-ogkmM5_bddxj28w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionAddPostFragment.b(CollectionAddPostFragment.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    public final FragmentCollectionAddPostBinding p() {
        return (FragmentCollectionAddPostBinding) this.c.b(this, b[0]);
    }

    public final SelectAlbumViewModel q() {
        return (SelectAlbumViewModel) this.d.getValue();
    }

    public final void r() {
        IAddPost a2;
        MyAdapter myAdapter = this.e;
        if (myAdapter == null || (a2 = myAdapter.a()) == null) {
            return;
        }
        FragmentCollectionAddPostBinding p = p();
        ShapeTextView shapeTextView = p == null ? null : p.c;
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setAlpha(a2.z() ? 1.0f : 0.3f);
    }
}
