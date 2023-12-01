package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.widget.refresh.BluedLoadMoreView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLivePlanetRecordBinding;
import com.blued.android.module.live_china.model.LivePlanetRecordExtra;
import com.blued.android.module.live_china.model.LivePlanetRecordGiftModel;
import com.blued.android.module.live_china.model.LivePlanetRecordModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRecordDialogFragment.class */
public final class LivePlanetRecordDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13135a = new Companion(null);
    private MyAdapter d;
    private int f;
    private boolean g;
    private final Lazy b = LazyKt.a(new Function0<FragmentLivePlanetRecordBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRecordDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLivePlanetRecordBinding invoke() {
            return FragmentLivePlanetRecordBinding.a(LayoutInflater.from(LivePlanetRecordDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private List<LivePlanetRecordModel> f13136c = new ArrayList();
    private String e = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRecordDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePlanetRecordDialogFragment a(Fragment fragment, String tip) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(tip, "tip");
            LivePlanetRecordDialogFragment livePlanetRecordDialogFragment = new LivePlanetRecordDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tip", tip);
            livePlanetRecordDialogFragment.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetRecordDialogFragment.show(childFragmentManager, LivePlanetRecordDialogFragment.class.getSimpleName());
            return livePlanetRecordDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRecordDialogFragment$GiftAdapter.class */
    public static final class GiftAdapter extends CommonRecycleAdapter<LivePlanetRecordGiftModel> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftAdapter(Context context) {
            super(context);
            Intrinsics.e(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(LivePlanetRecordGiftModel livePlanetRecordGiftModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (commonAdapterHolder != null) {
                commonAdapterHolder.a(R.id.tv_name, livePlanetRecordGiftModel == null ? null : livePlanetRecordGiftModel.getGoods_name());
            }
            if (commonAdapterHolder != null) {
                commonAdapterHolder.b(R.id.iv_pic, livePlanetRecordGiftModel == null ? null : livePlanetRecordGiftModel.getGoods_image());
            }
            if (livePlanetRecordGiftModel != null && livePlanetRecordGiftModel.getGoods_count() > 999) {
                if (commonAdapterHolder == null) {
                    return;
                }
                commonAdapterHolder.a(R.id.tv_num, "x999+");
            } else if (commonAdapterHolder == null) {
            } else {
                int i2 = R.id.tv_num;
                Intrinsics.a(livePlanetRecordGiftModel);
                commonAdapterHolder.a(i2, Intrinsics.a("x", (Object) Integer.valueOf(livePlanetRecordGiftModel.getGoods_count())));
            }
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_planet_record_gift_item;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRecordDialogFragment$MyAdapter.class */
    public static final class MyAdapter extends BaseMultiItemQuickAdapter<LivePlanetRecordModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private Context f13137a;
        private List<LivePlanetRecordModel> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, List<LivePlanetRecordModel> models) {
            super(models);
            Intrinsics.e(models, "models");
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.f13137a = context;
            arrayList.clear();
            this.b.addAll(models);
            addItemType(0, R.layout.live_planet_record_item);
            addItemType(1, R.layout.live_planet_record_top);
            addItemType(2, R.layout.live_planet_record_item_end);
        }

        private final void a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ref.BooleanRef reslut, LivePlanetRecordModel livePlanetRecordModel, MyAdapter this$0, BaseViewHolder baseViewHolder, View view) {
            Intrinsics.e(reslut, "$reslut");
            Intrinsics.e(this$0, "this$0");
            if (reslut.f42538a) {
                Intrinsics.a(livePlanetRecordModel);
                livePlanetRecordModel.setExpand(!livePlanetRecordModel.getExpand());
                this$0.a(livePlanetRecordModel.getExpand(), baseViewHolder);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LivePlanetRecordModel livePlanetRecordModel) {
            if (baseViewHolder != null) {
                int itemViewType = baseViewHolder.getItemViewType();
                if (itemViewType == 0) {
                    c(baseViewHolder, livePlanetRecordModel);
                } else if (itemViewType == 1) {
                    b(baseViewHolder, livePlanetRecordModel);
                } else if (itemViewType != 2) {
                } else {
                    a();
                }
            }
        }

        public final void a(boolean z, BaseViewHolder baseViewHolder) {
            ImageView imageView;
            ImageView imageView2;
            if (z) {
                if (baseViewHolder != null && (imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_arrow)) != null) {
                    imageView2.setImageResource(R.drawable.live_planet_tra_up);
                }
                View view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.fl_gift);
                if (view == null) {
                    return;
                }
                view.setVisibility(0);
                return;
            }
            if (baseViewHolder != null && (imageView = (ImageView) baseViewHolder.getView(R.id.iv_arrow)) != null) {
                imageView.setImageResource(R.drawable.live_planet_tra_down);
            }
            View view2 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.fl_gift);
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
        }

        public final void b(BaseViewHolder baseViewHolder, LivePlanetRecordModel livePlanetRecordModel) {
            TextView textView;
            TextView textView2;
            TextView textView3;
            TextView textView4;
            if (baseViewHolder != null && (textView4 = (TextView) baseViewHolder.getView(R.id.tv_time)) != null) {
                textView4.setText(livePlanetRecordModel == null ? null : livePlanetRecordModel.getCreate_time());
            }
            if (baseViewHolder != null && (textView3 = (TextView) baseViewHolder.getView(R.id.tv_name)) != null) {
                textView3.setText(livePlanetRecordModel == null ? null : livePlanetRecordModel.getDraw_planet_name());
            }
            if (baseViewHolder != null && (textView2 = (TextView) baseViewHolder.getView(R.id.tv_select)) != null) {
                textView2.setText(livePlanetRecordModel == null ? null : livePlanetRecordModel.getPlanet_name());
            }
            if (baseViewHolder == null || (textView = (TextView) baseViewHolder.getView(R.id.tv_num)) == null) {
                return;
            }
            textView.setText(livePlanetRecordModel == null ? null : livePlanetRecordModel.getDraw_beans());
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x01fc  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x02ba  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x02dd  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x031b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x031c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void c(final com.chad.library.adapter.base.BaseViewHolder r9, final com.blued.android.module.live_china.model.LivePlanetRecordModel r10) {
            /*
                Method dump skipped, instructions count: 814
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LivePlanetRecordDialogFragment.MyAdapter.c(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.live_china.model.LivePlanetRecordModel):void");
        }

        public final Context getContext() {
            return this.f13137a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetRecordDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetRecordDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.i().f11965c.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLivePlanetRecordBinding i() {
        return (FragmentLivePlanetRecordBinding) this.b.getValue();
    }

    private final void j() {
        i().f11965c.l(false);
        BluedLoadMoreView bluedLoadMoreView = new BluedLoadMoreView(getContext());
        bluedLoadMoreView.setBackgroundColorRes(R.color.transparent);
        i().f11965c.a(bluedLoadMoreView);
        i().f11965c.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRecordDialogFragment$initView$1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                super.onLoadMore(refreshLayout);
                LivePlanetRecordDialogFragment.this.b(false);
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                super.onRefresh(refreshLayout);
                LivePlanetRecordDialogFragment.this.b(true);
            }
        });
        i().d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.d = new MyAdapter(getContext(), this.f13136c);
        i().d.setAdapter(this.d);
        i().f11964a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRecordDialogFragment$ay0IUMataml5uTA4BjroH0tN3U0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetRecordDialogFragment.a(LivePlanetRecordDialogFragment.this, view);
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRecordDialogFragment$KMfmmO7Fov_0eANIXa02Hd7VIEc
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetRecordDialogFragment.b(LivePlanetRecordDialogFragment.this);
            }
        }, 300L);
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.e = str;
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void b(boolean z) {
        if (z) {
            this.f = 1;
        } else {
            this.f++;
        }
        if (this.f < 1) {
            this.f = 1;
        }
        int i = this.f;
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.i(i, new BluedUIHttpResponse<BluedEntity<LivePlanetRecordModel, LivePlanetRecordExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePlanetRecordDialogFragment$getRecord$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                LivePlanetRecordDialogFragment livePlanetRecordDialogFragment = LivePlanetRecordDialogFragment.this;
                livePlanetRecordDialogFragment.a(livePlanetRecordDialogFragment.e() - 1);
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                FragmentLivePlanetRecordBinding i2;
                FragmentLivePlanetRecordBinding i3;
                FragmentLivePlanetRecordBinding i4;
                super.onUIFinish();
                i2 = LivePlanetRecordDialogFragment.this.i();
                i2.f11965c.j();
                i3 = LivePlanetRecordDialogFragment.this.i();
                i3.f11965c.h();
                i4 = LivePlanetRecordDialogFragment.this.i();
                i4.f11965c.l(LivePlanetRecordDialogFragment.this.f());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LivePlanetRecordModel, LivePlanetRecordExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                boolean z2 = true;
                if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                    if (LivePlanetRecordDialogFragment.this.e() == 1) {
                        LivePlanetRecordDialogFragment.this.d().clear();
                        List<LivePlanetRecordModel> d = LivePlanetRecordDialogFragment.this.d();
                        List<LivePlanetRecordModel> list = bluedEntity.data;
                        Intrinsics.c(list, "bluedEntity!!.data");
                        d.addAll(list);
                    } else {
                        List<LivePlanetRecordModel> d2 = LivePlanetRecordDialogFragment.this.d();
                        List<LivePlanetRecordModel> list2 = bluedEntity.data;
                        Intrinsics.c(list2, "bluedEntity!!.data");
                        d2.addAll(list2);
                    }
                }
                if (bluedEntity.extra != null) {
                    LivePlanetRecordDialogFragment livePlanetRecordDialogFragment = LivePlanetRecordDialogFragment.this;
                    if (bluedEntity.extra.getHas_more() != 1) {
                        z2 = false;
                    }
                    livePlanetRecordDialogFragment.a(z2);
                }
                LivePlanetRecordDialogFragment.this.g();
            }
        }, a());
    }

    public final List<LivePlanetRecordModel> d() {
        return this.f13136c;
    }

    public final int e() {
        return this.f;
    }

    public final boolean f() {
        return this.g;
    }

    public final void g() {
        List<LivePlanetRecordModel> list = this.f13136c;
        if (list == null || list.size() <= 0) {
            i().b.setVisibility(0);
            i().d.setVisibility(8);
            return;
        }
        if (this.f == 1) {
            LivePlanetRecordModel livePlanetRecordModel = new LivePlanetRecordModel();
            livePlanetRecordModel.setType(1);
            String string = getString(R.string.live_planet_record_select);
            Intrinsics.c(string, "getString(R.string.live_planet_record_select)");
            livePlanetRecordModel.setPlanet_name(string);
            String string2 = getString(R.string.live_planet_record_area);
            Intrinsics.c(string2, "getString(R.string.live_planet_record_area)");
            livePlanetRecordModel.setDraw_planet_name(string2);
            String string3 = getString(R.string.live_planet_record_result);
            Intrinsics.c(string3, "getString(R.string.live_planet_record_result)");
            livePlanetRecordModel.setDraw_beans(string3);
            String string4 = getString(R.string.live_planet_record_time);
            Intrinsics.c(string4, "getString(R.string.live_planet_record_time)");
            livePlanetRecordModel.setCreate_time(string4);
            this.f13136c.add(0, livePlanetRecordModel);
        }
        if (!this.g) {
            LivePlanetRecordModel livePlanetRecordModel2 = new LivePlanetRecordModel();
            livePlanetRecordModel2.setType(2);
            this.f13136c.add(livePlanetRecordModel2);
        }
        i().b.setVisibility(8);
        i().d.setVisibility(0);
        if (this.g) {
            i().d.setPadding(0, 0, 0, 0);
        } else {
            i().d.setPadding(0, 0, 0, AppMethods.b(99));
        }
        MyAdapter myAdapter = this.d;
        if (myAdapter == null) {
            return;
        }
        myAdapter.setNewData(this.f13136c);
    }

    public final void h() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing()) {
                dismissAllowingStateLoss();
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 520.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(i().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(i().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("tip", "");
            Intrinsics.c(string, "it.getString(\"tip\", \"\")");
            a(string);
        }
        j();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
