package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogConfigureTimeLayoutBinding;
import com.blued.android.module.yy_china.databinding.ItemRoomPkTimeBinding;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfigureTimeDialog.class */
public final class YYConfigureTimeDialog extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private DialogConfigureTimeLayoutBinding b;
    private YYVoteTimeModel c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfigureTimeDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final YYConfigureTimeDialog a(YYVoteTimeModel yYVoteTimeModel) {
            YYConfigureTimeDialog yYConfigureTimeDialog = new YYConfigureTimeDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("time_model", yYVoteTimeModel);
            yYConfigureTimeDialog.setArguments(bundle);
            return yYConfigureTimeDialog;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfigureTimeDialog$TimeAdapter.class */
    public static final class TimeAdapter extends BaseQuickAdapter<YYVoteTimeModel, BaseViewHolder> {
        private Context a;
        private YYVoteTimeModel b;

        public TimeAdapter(Context context, YYVoteTimeModel yYVoteTimeModel) {
            super(R.layout.item_room_pk_time, new ArrayList());
            this.a = context;
            this.b = yYVoteTimeModel;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYVoteTimeModel yYVoteTimeModel) {
            Drawable drawable;
            Intrinsics.a(baseViewHolder);
            ItemRoomPkTimeBinding a = ItemRoomPkTimeBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a, "bind(helper!!.itemView)");
            a.a.setText(yYVoteTimeModel == null ? null : yYVoteTimeModel.timeStr);
            Integer valueOf = yYVoteTimeModel == null ? null : Integer.valueOf(yYVoteTimeModel.timeMill);
            YYVoteTimeModel yYVoteTimeModel2 = this.b;
            if (!Intrinsics.a(valueOf, yYVoteTimeModel2 == null ? null : Integer.valueOf(yYVoteTimeModel2.timeMill))) {
                ShapeHelper.a(a.a, (Drawable) null);
                ShapeHelper.b(a.a, R.color.syc_272727);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_j);
                ShapeHelper.a((ShapeHelper.ShapeView) a.a, 100.0f);
                return;
            }
            ShapeHelper.b(a.a, R.color.transparent);
            ShapeTextView shapeTextView = a.a;
            Context context = this.a;
            if (context == null) {
                drawable = null;
            } else {
                Resources resources = context.getResources();
                drawable = resources == null ? null : resources.getDrawable(R.drawable.shape_mb_272727);
            }
            ShapeHelper.a(shapeTextView, drawable);
            ShapeHelper.a((ShapeHelper.ShapeView) a.a, R.color.syc_dark_b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfigureTimeDialog this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYVoteTimeModel");
        }
        this$0.c = (YYVoteTimeModel) obj;
        baseQuickAdapter.notifyDataSetChanged();
        this$0.a(this$0.c, i);
        this$0.dismiss();
    }

    private final void a(YYVoteTimeModel yYVoteTimeModel, int i) {
        getParentFragmentManager().setFragmentResult("option_time", BundleKt.bundleOf(new Pair[]{TuplesKt.a("bundle_time", yYVoteTimeModel)}));
    }

    private final List<YYVoteTimeModel> h() {
        String[] stringArray = getResources().getStringArray(R.array.yy_room_pk_times);
        Intrinsics.c(stringArray, "resources.getStringArray(R.array.yy_room_pk_times)");
        ArrayList arrayList = new ArrayList();
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            YYVoteTimeModel yYVoteTimeModel = new YYVoteTimeModel();
            yYVoteTimeModel.timeStr = Intrinsics.a(stringArray[i2], (Object) "分钟");
            String str = stringArray[i2];
            Intrinsics.c(str, "times[i]");
            yYVoteTimeModel.timeMill = Integer.parseInt(str);
            if (i2 == 0) {
                yYVoteTimeModel.isCheck = true;
            }
            arrayList.add(yYVoteTimeModel);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable("time_model");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYVoteTimeModel");
        }
        this.c = (YYVoteTimeModel) serializable;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_configure_time_layout, (ViewGroup) null);
        this.b = DialogConfigureTimeLayoutBinding.a(inflate);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        DialogConfigureTimeLayoutBinding dialogConfigureTimeLayoutBinding = this.b;
        RecyclerView recyclerView = dialogConfigureTimeLayoutBinding == null ? null : dialogConfigureTimeLayoutBinding.a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView.Adapter timeAdapter = new TimeAdapter(getContext(), this.c);
        DialogConfigureTimeLayoutBinding dialogConfigureTimeLayoutBinding2 = this.b;
        RecyclerView recyclerView2 = dialogConfigureTimeLayoutBinding2 == null ? null : dialogConfigureTimeLayoutBinding2.a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(timeAdapter);
        }
        timeAdapter.setNewData(h());
        timeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfigureTimeDialog$NSzWa_42WpXP9TUBSqWPnyvssjk
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                YYConfigureTimeDialog.a(YYConfigureTimeDialog.this, baseQuickAdapter, view2, i);
            }
        });
    }
}
