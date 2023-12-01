package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentPageExhibitionBinding;
import com.blued.android.module.yy_china.model.YYCarExhibitionModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateExhibitionFragment.class */
public final class YYDecorateExhibitionFragment extends BaseLazyFragment {

    /* renamed from: a  reason: collision with root package name */
    private String f17220a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f17221c;
    private FragmentPageExhibitionBinding d;
    private ReceiveCarAdapter e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDecorateExhibitionFragment$ReceiveCarAdapter.class */
    public final class ReceiveCarAdapter extends BaseQuickAdapter<YYCarExhibitionModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYDecorateExhibitionFragment f17222a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveCarAdapter(YYDecorateExhibitionFragment this$0) {
            super(R.layout.item_receive_car_layout);
            Intrinsics.e(this$0, "this$0");
            this.f17222a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYCarExhibitionModel yYCarExhibitionModel) {
            ShapeableImageView shapeableImageView = baseViewHolder == null ? null : (ShapeableImageView) baseViewHolder.getView(R.id.img_sender_portrait);
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_car_model);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_receive_count);
            if (yYCarExhibitionModel == null) {
                return;
            }
            YYDecorateExhibitionFragment yYDecorateExhibitionFragment = this.f17222a;
            ImageLoader.a(yYDecorateExhibitionFragment.getFragmentActive(), yYCarExhibitionModel.getSource_avatar()).b(R.drawable.user_bg_round).a(shapeableImageView);
            ImageLoader.a(yYDecorateExhibitionFragment.getFragmentActive(), yYCarExhibitionModel.getImage()).a(imageView);
            if (textView == null) {
                return;
            }
            textView.setText(yYCarExhibitionModel.getNum());
        }
    }

    public YYDecorateExhibitionFragment(String userId, String userName) {
        Intrinsics.e(userId, "userId");
        Intrinsics.e(userName, "userName");
        this.f17220a = userId;
        this.b = userName;
        this.f17221c = 1;
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void b() {
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2 = fragmentPageExhibitionBinding;
        if (fragmentPageExhibitionBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding2 = null;
        }
        fragmentPageExhibitionBinding2.e.c(true);
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding3 = this.d;
        if (fragmentPageExhibitionBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding3 = null;
        }
        fragmentPageExhibitionBinding3.e.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYDecorateExhibitionFragment$initRefreshLayout$1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYDecorateExhibitionFragment.this.c();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYDecorateExhibitionFragment.this.f17221c = 1;
                YYDecorateExhibitionFragment.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        YYRoomHttpUtils.m(this.f17220a, this.f17221c, new YYDecorateExhibitionFragment$loadCarList$1(this, getFragmentActive()), getFragmentActive());
    }

    private final void d() {
        String str;
        if (this.b.length() > 5) {
            str = ((Object) this.b.subSequence(0, 5)) + "...";
        } else {
            str = this.b;
        }
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2 = fragmentPageExhibitionBinding;
        if (fragmentPageExhibitionBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding2 = null;
        }
        fragmentPageExhibitionBinding2.g.setText(Intrinsics.a(str, (Object) "的定制展馆"));
        this.e = new ReceiveCarAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding3 = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding4 = fragmentPageExhibitionBinding3;
        if (fragmentPageExhibitionBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding4 = null;
        }
        fragmentPageExhibitionBinding4.f.setLayoutManager(gridLayoutManager);
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding5 = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding6 = fragmentPageExhibitionBinding5;
        if (fragmentPageExhibitionBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding6 = null;
        }
        RecyclerView recyclerView = fragmentPageExhibitionBinding6.f;
        ReceiveCarAdapter receiveCarAdapter = this.e;
        if (receiveCarAdapter == null) {
            Intrinsics.c("receiveCarAdapter");
            receiveCarAdapter = null;
        }
        recyclerView.setAdapter(receiveCarAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2 = fragmentPageExhibitionBinding;
        if (fragmentPageExhibitionBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding2 = null;
        }
        fragmentPageExhibitionBinding2.e.j();
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding3 = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding4 = fragmentPageExhibitionBinding3;
        if (fragmentPageExhibitionBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding4 = null;
        }
        fragmentPageExhibitionBinding4.e.h();
        ReceiveCarAdapter receiveCarAdapter = this.e;
        ReceiveCarAdapter receiveCarAdapter2 = receiveCarAdapter;
        if (receiveCarAdapter == null) {
            Intrinsics.c("receiveCarAdapter");
            receiveCarAdapter2 = null;
        }
        if (receiveCarAdapter2.getData().size() <= 0) {
            FragmentPageExhibitionBinding fragmentPageExhibitionBinding5 = this.d;
            FragmentPageExhibitionBinding fragmentPageExhibitionBinding6 = fragmentPageExhibitionBinding5;
            if (fragmentPageExhibitionBinding5 == null) {
                Intrinsics.c("mBinding");
                fragmentPageExhibitionBinding6 = null;
            }
            fragmentPageExhibitionBinding6.d.setVisibility(0);
            FragmentPageExhibitionBinding fragmentPageExhibitionBinding7 = this.d;
            if (fragmentPageExhibitionBinding7 == null) {
                Intrinsics.c("mBinding");
                fragmentPageExhibitionBinding7 = null;
            }
            fragmentPageExhibitionBinding7.e.setVisibility(8);
            return;
        }
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding8 = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding9 = fragmentPageExhibitionBinding8;
        if (fragmentPageExhibitionBinding8 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding9 = null;
        }
        fragmentPageExhibitionBinding9.d.setVisibility(8);
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding10 = this.d;
        if (fragmentPageExhibitionBinding10 == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding10 = null;
        }
        fragmentPageExhibitionBinding10.e.setVisibility(0);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment
    public void a() {
        super.a();
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2 = fragmentPageExhibitionBinding;
        if (fragmentPageExhibitionBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding2 = null;
        }
        fragmentPageExhibitionBinding2.e.i();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        LogUtils.d("YYDecorateExhibitionFragment onCreateView ...");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_page_exhibition, (ViewGroup) null);
        FragmentPageExhibitionBinding a2 = FragmentPageExhibitionBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.d = a2;
        b();
        d();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LogUtils.d("YYDecorateExhibitionFragment onViewCreated ...");
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding = this.d;
        FragmentPageExhibitionBinding fragmentPageExhibitionBinding2 = fragmentPageExhibitionBinding;
        if (fragmentPageExhibitionBinding == null) {
            Intrinsics.c("mBinding");
            fragmentPageExhibitionBinding2 = null;
        }
        fragmentPageExhibitionBinding2.f16481a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDecorateExhibitionFragment$sfw8lmGOWEYldycwvNBohX5RSd0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYDecorateExhibitionFragment.a(view2);
            }
        });
    }
}
