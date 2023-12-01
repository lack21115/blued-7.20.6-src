package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePocketPropsBinding;
import com.blued.android.module.live_china.fragment.LivePocketPropFragment;
import com.blued.android.module.live_china.fragment.LivePropsDesDialogFragment;
import com.blued.android.module.live_china.model.LivePocketExtraModel;
import com.blued.android.module.live_china.model.LivePocketModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.SpacesItemDecoration;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketPropFragment.class */
public final class LivePocketPropFragment extends BaseFragment {
    public static final Companion a = new Companion(null);
    private DialogLivePocketPropsBinding b;
    private LivePocketModel d;
    private List<LivePocketModel> c = new ArrayList();
    private final int e = 4;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketPropFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketPropFragment$LivePocketPropAdapter.class */
    public final class LivePocketPropAdapter extends CommonRecycleAdapter<LivePocketModel> {
        final /* synthetic */ LivePocketPropFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LivePocketPropAdapter(LivePocketPropFragment this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LivePocketPropAdapter this$0, LivePocketPropFragment this$1, LivePocketModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            Intrinsics.e(item, "$item");
            List<LivePocketModel> dataList = this$0.getDataList();
            if (dataList != null) {
                this$1.a(item);
                for (LivePocketModel livePocketModel : dataList) {
                    livePocketModel.setSelected(false);
                }
                item.setSelected(true);
                this$0.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean a(LivePocketPropFragment this$0, LivePocketModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            LivePropsDesDialogFragment.Companion companion = LivePropsDesDialogFragment.a;
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            companion.a(childFragmentManager, item);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LivePocketModel item, int i, CommonRecycleAdapter.CommonAdapterHolder helper) {
            String format;
            Intrinsics.e(item, "item");
            Intrinsics.e(helper, "helper");
            ViewGroup.LayoutParams layoutParams = helper.a(R.id.view_root).getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (item.getLine_num() == 0) {
                marginLayoutParams.topMargin = DensityUtils.a(this.a.getContext(), 12.0f);
            } else {
                marginLayoutParams.topMargin = DensityUtils.a(this.a.getContext(), 6.0f);
            }
            ImageLoader.a(this.a.getFragmentActive(), item.getImage()).a((ImageView) helper.a(R.id.iv_icon));
            ((TextView) helper.a(R.id.tv_name)).setText(item.getName());
            helper.b(R.id.tv_num, item.getCount() > 1 ? 0 : 8).a(R.id.tv_num, item.getCount() > 1000000 ? "100W+" : item.getCount() == 1000000 ? "100W" : String.valueOf(item.getCount()));
            if (item.getExpire_time() == -1) {
                helper.b(R.id.tv_time, 0);
                helper.a(R.id.tv_time, AppInfo.d().getString(R.string.live_pocket_forver));
                helper.a(R.id.tv_time, AppInfo.d().getResources().getColor(R.color.syc_dark_66FFFFFF));
            } else {
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.c.get();
                if (TextUtils.equals(simpleDateFormat == null ? null : simpleDateFormat.format(new Date(item.getExpire_time() * 1000)), "23:59:59")) {
                    SimpleDateFormat simpleDateFormat2 = TimeAndDateUtils.m.get();
                    format = simpleDateFormat2 == null ? null : simpleDateFormat2.format(new Date(item.getExpire_time() * 1000));
                } else {
                    SimpleDateFormat simpleDateFormat3 = TimeAndDateUtils.l.get();
                    format = simpleDateFormat3 == null ? null : simpleDateFormat3.format(new Date(item.getExpire_time() * 1000));
                }
                String str = format;
                if (format == null) {
                    str = "";
                }
                helper.b(R.id.tv_time, 0);
                int i2 = R.id.tv_time;
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String string = AppInfo.d().getString(R.string.live_pocket_exp_over);
                Intrinsics.c(string, "getAppContext().getStrin…ing.live_pocket_exp_over)");
                String format2 = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.c(format2, "format(format, *args)");
                helper.a(i2, format2);
                helper.a(R.id.tv_time, AppInfo.d().getResources().getColor(R.color.syc_ff6533));
            }
            if (item.getSelected()) {
                helper.b(R.id.view_select_1, 0);
                helper.b(R.id.view_select_2, 0);
                helper.b(R.id.view_unselect, 8);
                this.a.a(item);
            } else {
                helper.b(R.id.view_select_1, 8);
                helper.b(R.id.view_select_2, 8);
                helper.b(R.id.view_unselect, 0);
            }
            View a = helper.a(R.id.view_root);
            if (a != null) {
                final LivePocketPropFragment livePocketPropFragment = this.a;
                a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketPropFragment$LivePocketPropAdapter$26-zl86uPyyzITAVRapmfhJzmAU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LivePocketPropFragment.LivePocketPropAdapter.a(LivePocketPropFragment.LivePocketPropAdapter.this, livePocketPropFragment, item, view);
                    }
                });
            }
            View a2 = helper.a(R.id.view_root);
            if (a2 == null) {
                return;
            }
            final LivePocketPropFragment livePocketPropFragment2 = this.a;
            a2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketPropFragment$LivePocketPropAdapter$7ps31drj6LZo67pqdPRq11mR-2k
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean a3;
                    a3 = LivePocketPropFragment.LivePocketPropAdapter.a(LivePocketPropFragment.this, item, view);
                    return a3;
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_pocket_props_item;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePocketPropFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    private final void b() {
        String str;
        LivePocketModel livePocketModel = this.d;
        String str2 = "";
        if (livePocketModel != null) {
            Intrinsics.a(livePocketModel);
            str2 = String.valueOf(livePocketModel.getPocket_goods_id());
            LivePocketModel livePocketModel2 = this.d;
            Intrinsics.a(livePocketModel2);
            str = String.valueOf(livePocketModel2.getType());
        } else {
            str = "";
        }
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.c(str2, str, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LivePocketPropFragment$userProp$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA == null || TextUtils.isEmpty(bluedEntityA.message)) {
                    AppMethods.a((CharSequence) AppInfo.d().getString(R.string.live_pocket_use_success));
                } else {
                    AppMethods.a((CharSequence) bluedEntityA.message);
                }
                if (LivePocketPropFragment.this.getParentFragment() instanceof LivePocketDialogFragment) {
                    LivePocketDialogFragment parentFragment = LivePocketPropFragment.this.getParentFragment();
                    if (parentFragment == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LivePocketDialogFragment");
                    }
                    parentFragment.g();
                }
            }
        });
    }

    public final void a() {
        ShapeTextView shapeTextView;
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        if ((arguments == null ? null : arguments.getSerializable("model")) instanceof LivePocketExtraModel) {
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 == null ? null : arguments2.getSerializable("model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LivePocketExtraModel");
            }
            List<LivePocketModel> in_use = ((LivePocketExtraModel) serializable).getIn_use();
            if (in_use != null) {
                this.c.addAll(in_use);
            }
        }
        List<LivePocketModel> list = this.c;
        if (list == null || list.size() == 0) {
            DialogLivePocketPropsBinding dialogLivePocketPropsBinding = this.b;
            LinearLayout linearLayout = dialogLivePocketPropsBinding == null ? null : dialogLivePocketPropsBinding.a;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            DialogLivePocketPropsBinding dialogLivePocketPropsBinding2 = this.b;
            LinearLayout linearLayout2 = dialogLivePocketPropsBinding2 == null ? null : dialogLivePocketPropsBinding2.b;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (LivePocketModel livePocketModel : this.c) {
            if (arrayList2.size() == this.e || arrayList2.size() == 0) {
                arrayList2 = new ArrayList();
                arrayList2.add(livePocketModel);
                arrayList.add(arrayList2);
            } else {
                arrayList2.add(livePocketModel);
            }
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                List list2 = (List) arrayList.get(i2);
                int size2 = list2.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < size2) {
                        LivePocketModel livePocketModel2 = (LivePocketModel) list2.get(i4);
                        livePocketModel2.setColumn_num(i4);
                        livePocketModel2.setLine_num(i2);
                        if (i == 0) {
                            livePocketModel2.setSelected(true);
                        }
                        i++;
                        i3 = i4 + 1;
                    }
                }
            }
        }
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding3 = this.b;
        LinearLayout linearLayout3 = dialogLivePocketPropsBinding3 == null ? null : dialogLivePocketPropsBinding3.a;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding4 = this.b;
        LinearLayout linearLayout4 = dialogLivePocketPropsBinding4 == null ? null : dialogLivePocketPropsBinding4.b;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(0);
        }
        LivePocketPropAdapter livePocketPropAdapter = new LivePocketPropAdapter(this);
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding5 = this.b;
        RecyclerView recyclerView2 = dialogLivePocketPropsBinding5 == null ? null : dialogLivePocketPropsBinding5.c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(livePocketPropAdapter);
        }
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), this.e);
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding6 = this.b;
        if (dialogLivePocketPropsBinding6 != null && (recyclerView = dialogLivePocketPropsBinding6.c) != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), 3.0f), 0, DensityUtils.a(getContext(), 3.0f), 0);
        spacesItemDecoration.a(true, true, true, true);
        spacesItemDecoration.a(5);
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding7 = this.b;
        Intrinsics.a(dialogLivePocketPropsBinding7);
        dialogLivePocketPropsBinding7.c.addItemDecoration(spacesItemDecoration);
        livePocketPropAdapter.setDataAndNotify(this.c);
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding8 = this.b;
        if (dialogLivePocketPropsBinding8 == null || (shapeTextView = dialogLivePocketPropsBinding8.d) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketPropFragment$SvMLb2rD6cOYjUWA612Imr7ES8U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePocketPropFragment.a(LivePocketPropFragment.this, view);
            }
        });
    }

    public final void a(LivePocketModel livePocketModel) {
        this.d = livePocketModel;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout root;
        FrameLayout root2;
        Intrinsics.e(inflater, "inflater");
        DialogLivePocketPropsBinding a2 = DialogLivePocketPropsBinding.a(getLayoutInflater(), viewGroup, false);
        this.b = a2;
        if (((a2 == null || (root = a2.getRoot()) == null) ? null : root.getParent()) != null) {
            DialogLivePocketPropsBinding dialogLivePocketPropsBinding = this.b;
            ViewParent parent = (dialogLivePocketPropsBinding == null || (root2 = dialogLivePocketPropsBinding.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            DialogLivePocketPropsBinding dialogLivePocketPropsBinding2 = this.b;
            viewGroup2.removeView(dialogLivePocketPropsBinding2 == null ? null : dialogLivePocketPropsBinding2.getRoot());
        }
        a();
        DialogLivePocketPropsBinding dialogLivePocketPropsBinding3 = this.b;
        return dialogLivePocketPropsBinding3 == null ? null : dialogLivePocketPropsBinding3.getRoot();
    }
}
