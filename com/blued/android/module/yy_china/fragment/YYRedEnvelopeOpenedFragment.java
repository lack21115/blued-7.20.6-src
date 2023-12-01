package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRedEnvelopeOpenedBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgRedEnvExtra;
import com.blued.android.module.yy_china.model.YYPrizeLogModel;
import com.blued.android.module.yy_china.model.YYRedEnvOpenedModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvelopeOpenedFragment.class */
public final class YYRedEnvelopeOpenedFragment extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private FragmentYyRedEnvelopeOpenedBinding f17413a;
    private DrawerAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private YYRedEnvOpenedModel f17414c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvelopeOpenedFragment$DrawerAdapter.class */
    public final class DrawerAdapter extends BaseQuickAdapter<YYPrizeLogModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRedEnvelopeOpenedFragment f17415a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DrawerAdapter(YYRedEnvelopeOpenedFragment this$0) {
            super(R.layout.item_red_envelope_drawer, new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17415a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYPrizeLogModel yYPrizeLogModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_prize_img);
            ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_drawer_img);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_open_time);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_drawer_name);
            if (yYPrizeLogModel == null) {
                return;
            }
            YYRedEnvelopeOpenedFragment yYRedEnvelopeOpenedFragment = this.f17415a;
            ImageLoader.a(yYRedEnvelopeOpenedFragment.a(), yYPrizeLogModel.goods_image).b(R.drawable.gift_default_icon).a(imageView);
            ImageLoader.a(yYRedEnvelopeOpenedFragment.a(), yYPrizeLogModel.avatar).b(R.drawable.user_bg_round).a(imageView2);
            if (textView != null) {
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.f10914c.get();
                Intrinsics.a(simpleDateFormat);
                textView.setText(simpleDateFormat.format(Long.valueOf(StringUtils.a(yYPrizeLogModel.time, 0L) * 1000)));
            }
            if (textView2 == null) {
                return;
            }
            textView2.setText(yYPrizeLogModel.name);
        }
    }

    public YYRedEnvelopeOpenedFragment(YYRedEnvOpenedModel yYRedEnvOpenedModel) {
        this.f17414c = yYRedEnvOpenedModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedEnvelopeOpenedFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYRedEnvOpenedModel yYRedEnvOpenedModel) {
        RecyclerView recyclerView;
        if (yYRedEnvOpenedModel == null) {
            return;
        }
        List<YYPrizeLogModel> list = yYRedEnvOpenedModel.receive_list;
        if (list != null) {
            int size = list.size();
            if (size > 3) {
                FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding = this.f17413a;
                ViewGroup.LayoutParams layoutParams = (fragmentYyRedEnvelopeOpenedBinding == null || (recyclerView = fragmentYyRedEnvelopeOpenedBinding.e) == null) ? null : recyclerView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = DensityUtils.a(getContext(), 220.0f);
                }
                FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding2 = this.f17413a;
                RecyclerView recyclerView2 = fragmentYyRedEnvelopeOpenedBinding2 == null ? null : fragmentYyRedEnvelopeOpenedBinding2.e;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutParams(layoutParams);
                }
            }
            DrawerAdapter drawerAdapter = this.b;
            if (drawerAdapter != null) {
                drawerAdapter.setNewData(list);
            }
            FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding3 = this.f17413a;
            TextView textView = fragmentYyRedEnvelopeOpenedBinding3 == null ? null : fragmentYyRedEnvelopeOpenedBinding3.h;
            if (textView != null) {
                textView.setVisibility(size <= 0 ? 4 : 0);
            }
        }
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding4 = this.f17413a;
        TextView textView2 = fragmentYyRedEnvelopeOpenedBinding4 == null ? null : fragmentYyRedEnvelopeOpenedBinding4.h;
        if (textView2 != null) {
            textView2.setText(Intrinsics.a("已领取 ", (Object) yYRedEnvOpenedModel.receive_prograss));
        }
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding5 = this.f17413a;
        TextView textView3 = fragmentYyRedEnvelopeOpenedBinding5 == null ? null : fragmentYyRedEnvelopeOpenedBinding5.f;
        if (textView3 != null) {
            textView3.setText(yYRedEnvOpenedModel.receive_message);
        }
        if (TextUtils.isEmpty(yYRedEnvOpenedModel.receive_image)) {
            FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding6 = this.f17413a;
            ImageView imageView = fragmentYyRedEnvelopeOpenedBinding6 == null ? null : fragmentYyRedEnvelopeOpenedBinding6.d;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding7 = this.f17413a;
        ImageView imageView2 = fragmentYyRedEnvelopeOpenedBinding7 == null ? null : fragmentYyRedEnvelopeOpenedBinding7.d;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageWrapper b = ImageLoader.a(a(), yYRedEnvOpenedModel.receive_image).b(R.drawable.gift_default_icon);
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding8 = this.f17413a;
        b.a(fragmentYyRedEnvelopeOpenedBinding8 == null ? null : fragmentYyRedEnvelopeOpenedBinding8.d);
    }

    private final boolean a(YYRoomModel yYRoomModel) {
        if (TextUtils.equals(yYRoomModel == null ? null : yYRoomModel.relationship, "1")) {
            return true;
        }
        return TextUtils.equals(yYRoomModel == null ? null : yYRoomModel.relationship, "3");
    }

    private final void f() {
        ImageView imageView;
        this.b = new DrawerAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding = this.f17413a;
        RecyclerView recyclerView = fragmentYyRedEnvelopeOpenedBinding == null ? null : fragmentYyRedEnvelopeOpenedBinding.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding2 = this.f17413a;
        RecyclerView recyclerView2 = fragmentYyRedEnvelopeOpenedBinding2 == null ? null : fragmentYyRedEnvelopeOpenedBinding2.e;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        FragmentYyRedEnvelopeOpenedBinding fragmentYyRedEnvelopeOpenedBinding3 = this.f17413a;
        if (fragmentYyRedEnvelopeOpenedBinding3 == null || (imageView = fragmentYyRedEnvelopeOpenedBinding3.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvelopeOpenedFragment$23BO1NXHi6thN_Q8bR5udW46d60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRedEnvelopeOpenedFragment.a(YYRedEnvelopeOpenedFragment.this, view);
            }
        });
    }

    private final void g() {
        String str = (a(YYRoomInfoManager.e().b()) || YYRoomInfoManager.e().y()) ? "0" : "1";
        YYRoomModel b = YYRoomInfoManager.e().b();
        YYMsgRedEnvExtra yYMsgRedEnvExtra = b == null ? null : b.redEnvelope;
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        String str2 = b2 == null ? null : b2.room_id;
        String str3 = yYMsgRedEnvExtra == null ? null : yYMsgRedEnvExtra.hongbao_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.c(str2, str3, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRedEnvOpenedModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYRedEnvelopeOpenedFragment$openRedEnvelope$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRedEnvOpenedModel> bluedEntityA) {
                YYRedEnvOpenedModel yYRedEnvOpenedModel;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYRedEnvelopeOpenedFragment.this.f17414c = bluedEntityA.getSingleData();
                YYRedEnvelopeOpenedFragment yYRedEnvelopeOpenedFragment = YYRedEnvelopeOpenedFragment.this;
                yYRedEnvOpenedModel = yYRedEnvelopeOpenedFragment.f17414c;
                yYRedEnvelopeOpenedFragment.a(yYRedEnvOpenedModel);
            }
        }, a());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_red_envelope_opened, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_opened, container, true)");
        this.f17413a = FragmentYyRedEnvelopeOpenedBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        YYRedEnvOpenedModel yYRedEnvOpenedModel = this.f17414c;
        if (yYRedEnvOpenedModel == null) {
            g();
        } else {
            a(yYRedEnvOpenedModel);
        }
    }
}
