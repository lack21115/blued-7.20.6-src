package com.blued.android.module.yy_china.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogPrePayBackBinding;
import com.blued.android.module.yy_china.databinding.ItemYyPrepayBackBinding;
import com.blued.android.module.yy_china.model.GiftListDTOModel;
import com.blued.android.module.yy_china.model.YYPerFirstGiftModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPeyPayBackGiftView.class */
public final class YYPeyPayBackGiftView extends CommonDialogFragment implements View.OnClickListener {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private final YYPerFirstGiftModel f18361c;
    private final View.OnClickListener d;
    private final BaseFragment e;
    private DialogPrePayBackBinding f;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPeyPayBackGiftView$Ad.class */
    public static final class Ad extends BaseQuickAdapter<GiftListDTOModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final BaseFragment f18362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(BaseFragment fragment) {
            super(R.layout.item_yy_prepay_back);
            Intrinsics.e(fragment, "fragment");
            this.f18362a = fragment;
        }

        public final BaseFragment a() {
            return this.f18362a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, GiftListDTOModel item) {
            View view;
            View rootView;
            Intrinsics.e(item, "item");
            if (baseViewHolder == null || (view = baseViewHolder.itemView) == null || (rootView = view.getRootView()) == null) {
                return;
            }
            ItemYyPrepayBackBinding a2 = ItemYyPrepayBackBinding.a(rootView);
            Intrinsics.c(a2, "bind(it)");
            ImageLoader.a(a().getFragmentActive(), item.getPic()).g().g(-1).a(a2.f16782a);
            a2.b.setText(item.getName());
            TextView textView = a2.f16783c;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String format = String.format("%s天", Arrays.copyOf(new Object[]{Long.valueOf(item.getDuration())}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPeyPayBackGiftView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, YYPerFirstGiftModel bean, View.OnClickListener clickRecharge, BaseFragment fragment) {
            Intrinsics.e(context, "context");
            Intrinsics.e(bean, "bean");
            Intrinsics.e(clickRecharge, "clickRecharge");
            Intrinsics.e(fragment, "fragment");
            YYPeyPayBackGiftView yYPeyPayBackGiftView = new YYPeyPayBackGiftView(bean, clickRecharge, fragment);
            yYPeyPayBackGiftView.setCancelable(false);
            yYPeyPayBackGiftView.show(((FragmentActivity) context).getSupportFragmentManager(), yYPeyPayBackGiftView.getClass().getName());
        }
    }

    public YYPeyPayBackGiftView(YYPerFirstGiftModel bean, View.OnClickListener clickRecharge, BaseFragment fragment) {
        Intrinsics.e(bean, "bean");
        Intrinsics.e(clickRecharge, "clickRecharge");
        Intrinsics.e(fragment, "fragment");
        this.f18361c = bean;
        this.d = clickRecharge;
        this.e = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPeyPayBackGiftView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
        Intrinsics.e(view, "view");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        DialogPrePayBackBinding a2 = DialogPrePayBackBinding.a(view);
        this.f = a2;
        if (a2 == null) {
            return;
        }
        ShapeTextView shapeTextView = a2.e;
        YYPeyPayBackGiftView yYPeyPayBackGiftView = this;
        shapeTextView.setOnClickListener(yYPeyPayBackGiftView);
        if (h() != null && h().getTips() != null) {
            a2.d.setText(h().getTips());
        }
        if (h() != null && h().getGift_list() != null && i() != null) {
            Ad ad = new Ad(i());
            a2.b.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            a2.b.setAdapter(ad);
            ad.setNewData(h().getGift_list());
        }
        a2.f16376c.setOnClickListener(yYPeyPayBackGiftView);
        a2.f16375a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPeyPayBackGiftView$tFjwWVaPUqKd0KBfyrV7YVdUMdQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPeyPayBackGiftView.a(YYPeyPayBackGiftView.this, view2);
            }
        });
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_pre_pay_back;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public boolean g() {
        return false;
    }

    public final YYPerFirstGiftModel h() {
        return this.f18361c;
    }

    public final BaseFragment i() {
        return this.e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Tracker.onClick(view);
        Intrinsics.a(view);
        if (view.getId() != R.id.tv_pre_pay || this.e == null || (onClickListener = this.d) == null) {
            return;
        }
        onClickListener.onClick(view);
        dismissAllowingStateLoss();
    }
}
