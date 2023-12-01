package com.blued.android.module.yy_china.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRedEnvelopeLayoutBinding;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYMsgRedEnvExtra;
import com.blued.android.module.yy_china.model.YYRedEnvGoodsModel;
import com.blued.android.module.yy_china.model.YYRedEnvOpenedError;
import com.blued.android.module.yy_china.model.YYRedEnvOpenedExtra;
import com.blued.android.module.yy_china.model.YYRedEnvOpenedModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvelopeFragment.class */
public final class YYRedEnvelopeFragment extends BaseFullScreenDialog {
    private FragmentYyRedEnvelopeLayoutBinding a;
    private PrizeAdapter b;
    private OpenHongbaoListener c;
    private CountDownTimer d;
    private YYMsgRedEnvExtra e;
    private int f;
    private ChatRoomProtos.Event g;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvelopeFragment$OpenHongbaoListener.class */
    public interface OpenHongbaoListener {
        void a(YYRedEnvOpenedModel yYRedEnvOpenedModel);
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvelopeFragment$PrizeAdapter.class */
    public final class PrizeAdapter extends BaseQuickAdapter<YYRedEnvGoodsModel, BaseViewHolder> {
        final /* synthetic */ YYRedEnvelopeFragment a;
        private int b;
        private int c;
        private int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrizeAdapter(YYRedEnvelopeFragment this$0) {
            super(R.layout.item_red_envelope_prize);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            this.c = DensityUtils.a(this.a.getContext(), 5.0f);
            this.d = DensityUtils.a(this.a.getContext(), 15.0f);
        }

        public final void a(int i) {
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYRedEnvGoodsModel yYRedEnvGoodsModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.tv_prize_img);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_value);
            TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_prize_count);
            LinearLayout linearLayout = baseViewHolder == null ? null : (LinearLayout) baseViewHolder.getView(R.id.ll_item_root);
            if (this.b > 0) {
                ViewGroup.LayoutParams layoutParams = linearLayout == null ? null : linearLayout.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
                RecyclerView.LayoutParams layoutParams2 = layoutParams;
                layoutParams2.width = -2;
                layoutParams2.leftMargin = this.c;
                layoutParams2.rightMargin = this.c;
                if (textView != null) {
                    textView.setMaxWidth(this.b);
                }
                if (linearLayout != null) {
                    int i = this.d;
                    linearLayout.setPadding(0, i, 0, i);
                }
            } else {
                Integer valueOf = baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition());
                Intrinsics.a(valueOf);
                if (valueOf.intValue() >= 3) {
                    if (linearLayout != null) {
                        linearLayout.setPadding(0, 0, 0, this.d);
                    }
                } else if (linearLayout != null) {
                    int i2 = this.d;
                    linearLayout.setPadding(0, i2, 0, i2);
                }
            }
            if (yYRedEnvGoodsModel == null) {
                return;
            }
            ImageLoader.a(this.a.a(), yYRedEnvGoodsModel.icon).a(imageView);
            if (textView != null) {
                textView.setText(yYRedEnvGoodsModel.name);
            }
            if (textView2 != null) {
                textView2.setText(Intrinsics.a(yYRedEnvGoodsModel.beans, (Object) "弯豆"));
            }
            if (textView3 == null) {
                return;
            }
            textView3.setText(Intrinsics.a("x", (Object) yYRedEnvGoodsModel.num));
        }
    }

    public YYRedEnvelopeFragment(YYMsgRedEnvExtra yYMsgRedEnvExtra, OpenHongbaoListener openHongbaoListener) {
        this.c = openHongbaoListener;
        this.e = yYMsgRedEnvExtra;
    }

    private final void a(final long j) {
        final String string = getResources().getString(R.string.countdown_hongbao_string);
        Intrinsics.c(string, "resources.getString(R.st…countdown_hongbao_string)");
        CountDownTimer countDownTimer = new CountDownTimer(j, this, string) { // from class: com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$startTimer$1
            final /* synthetic */ long a;
            final /* synthetic */ YYRedEnvelopeFragment b;
            final /* synthetic */ String c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, 1000L);
                this.a = j;
                this.b = this;
                this.c = string;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding;
                fragmentYyRedEnvelopeLayoutBinding = this.b.a;
                TextView textView = fragmentYyRedEnvelopeLayoutBinding == null ? null : fragmentYyRedEnvelopeLayoutBinding.i;
                if (textView == null) {
                    return;
                }
                textView.setText("时间到，可以开始抢红包啦");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding;
                SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
                Intrinsics.a(simpleDateFormat);
                String format = simpleDateFormat.format(Long.valueOf(j2));
                fragmentYyRedEnvelopeLayoutBinding = this.b.a;
                TextView textView = fragmentYyRedEnvelopeLayoutBinding == null ? null : fragmentYyRedEnvelopeLayoutBinding.i;
                if (textView == null) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                String format2 = String.format(this.c, Arrays.copyOf(new Object[]{format}, 1));
                Intrinsics.c(format2, "format(format, *args)");
                textView.setText(format2);
            }
        };
        this.d = countDownTimer;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedEnvelopeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    private final boolean a(YYRoomModel yYRoomModel) {
        if (TextUtils.equals(yYRoomModel == null ? null : yYRoomModel.relationship, "1")) {
            return true;
        }
        return TextUtils.equals(yYRoomModel == null ? null : yYRoomModel.relationship, "3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRedEnvelopeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRedEnvelopeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(R.id.tv_get_prize)) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.r(this$0.g, b.room_id, b.uid, String.valueOf(this$0.f));
        }
        this$0.h();
    }

    private final void f() {
        ShapeTextView shapeTextView;
        ImageView imageView;
        RecyclerView recyclerView;
        View view;
        FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding = this.a;
        if (fragmentYyRedEnvelopeLayoutBinding != null && (view = fragmentYyRedEnvelopeLayoutBinding.a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvelopeFragment$Hco3vTq_C_x1UUBtxCXaIobhTVA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRedEnvelopeFragment.a(YYRedEnvelopeFragment.this, view2);
                }
            });
        }
        this.b = new PrizeAdapter(this);
        YYMsgRedEnvExtra yYMsgRedEnvExtra = this.e;
        if (yYMsgRedEnvExtra != null) {
            if (yYMsgRedEnvExtra.gift_list.size() >= 3) {
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding2 = this.a;
                ViewGroup.LayoutParams layoutParams = (fragmentYyRedEnvelopeLayoutBinding2 == null || (recyclerView = fragmentYyRedEnvelopeLayoutBinding2.g) == null) ? null : recyclerView.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                ((FrameLayout.LayoutParams) layoutParams).width = -1;
                PrizeAdapter prizeAdapter = this.b;
                if (prizeAdapter != null) {
                    prizeAdapter.a(0);
                }
                RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding3 = this.a;
                RecyclerView recyclerView2 = fragmentYyRedEnvelopeLayoutBinding3 == null ? null : fragmentYyRedEnvelopeLayoutBinding3.g;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(gridLayoutManager);
                }
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding4 = this.a;
                RecyclerView recyclerView3 = fragmentYyRedEnvelopeLayoutBinding4 == null ? null : fragmentYyRedEnvelopeLayoutBinding4.g;
                if (recyclerView3 != null) {
                    recyclerView3.setAdapter(this.b);
                }
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$initView$2$1
                    public int getSpanSize(int i) {
                        return i >= 3 ? 3 : 1;
                    }
                });
            } else {
                RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(0);
                PrizeAdapter prizeAdapter2 = this.b;
                if (prizeAdapter2 != null) {
                    prizeAdapter2.a(DensityUtils.a(getContext(), 100.0f));
                }
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding5 = this.a;
                RecyclerView recyclerView4 = fragmentYyRedEnvelopeLayoutBinding5 == null ? null : fragmentYyRedEnvelopeLayoutBinding5.g;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(linearLayoutManager);
                }
                FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding6 = this.a;
                RecyclerView recyclerView5 = fragmentYyRedEnvelopeLayoutBinding6 == null ? null : fragmentYyRedEnvelopeLayoutBinding6.g;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(this.b);
                }
            }
            for (YYRedEnvGoodsModel yYRedEnvGoodsModel : yYMsgRedEnvExtra.gift_list) {
                this.f += StringUtils.a(yYRedEnvGoodsModel.beans, 0) * StringUtils.a(yYRedEnvGoodsModel.num, 0);
            }
        }
        FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding7 = this.a;
        if (fragmentYyRedEnvelopeLayoutBinding7 != null && (imageView = fragmentYyRedEnvelopeLayoutBinding7.b) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvelopeFragment$s1doWcQ-QMHiokUwYAOC9-ndM6g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYRedEnvelopeFragment.b(YYRedEnvelopeFragment.this, view2);
                }
            });
        }
        i();
        FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding8 = this.a;
        if (fragmentYyRedEnvelopeLayoutBinding8 == null || (shapeTextView = fragmentYyRedEnvelopeLayoutBinding8.h) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvelopeFragment$bKcuNh9YnmK8wbZc8Vgo9sqZG5Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYRedEnvelopeFragment.c(YYRedEnvelopeFragment.this, view2);
            }
        });
    }

    private final void g() {
        YYMsgRedEnvExtra yYMsgRedEnvExtra = this.e;
        if (yYMsgRedEnvExtra == null) {
            return;
        }
        YYAudienceModel yYAudienceModel = yYMsgRedEnvExtra.user_info;
        if (yYAudienceModel != null) {
            ImageWrapper a = ImageLoader.a(a(), yYAudienceModel.getAvatar());
            FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding = this.a;
            a.a(fragmentYyRedEnvelopeLayoutBinding == null ? null : fragmentYyRedEnvelopeLayoutBinding.c);
            FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding2 = this.a;
            TextView textView = fragmentYyRedEnvelopeLayoutBinding2 == null ? null : fragmentYyRedEnvelopeLayoutBinding2.j;
            if (textView != null) {
                textView.setText(yYAudienceModel.getName());
            }
        }
        long a2 = StringUtils.a(yYMsgRedEnvExtra.countdown_time, 0L);
        if (a2 <= 0) {
            FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding3 = this.a;
            TextView textView2 = fragmentYyRedEnvelopeLayoutBinding3 == null ? null : fragmentYyRedEnvelopeLayoutBinding3.i;
            if (textView2 != null) {
                textView2.setText("时间到，可以开始抢红包啦");
            }
        } else {
            FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding4 = this.a;
            TextView textView3 = fragmentYyRedEnvelopeLayoutBinding4 == null ? null : fragmentYyRedEnvelopeLayoutBinding4.i;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            a(a2);
        }
        PrizeAdapter prizeAdapter = this.b;
        if (prizeAdapter == null) {
            return;
        }
        prizeAdapter.setNewData(yYMsgRedEnvExtra.gift_list);
    }

    private final void h() {
        String str = (a(YYRoomInfoManager.e().b()) || YYRoomInfoManager.e().y()) ? "0" : "1";
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str2 = null;
        String str3 = b == null ? null : b.room_id;
        YYMsgRedEnvExtra yYMsgRedEnvExtra = this.e;
        if (yYMsgRedEnvExtra != null) {
            str2 = yYMsgRedEnvExtra.hongbao_id;
        }
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.c(str3, str2, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYRedEnvOpenedModel, YYRedEnvOpenedExtra>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$openRedEnvelope$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str4, String str5) {
                YYRedEnvOpenedExtra yYRedEnvOpenedExtra;
                YYRedEnvOpenedError yYRedEnvOpenedError = (YYRedEnvOpenedError) AppInfo.f().fromJson(str5, YYRedEnvOpenedError.class);
                if (yYRedEnvOpenedError != null && (yYRedEnvOpenedExtra = yYRedEnvOpenedError.extra) != null) {
                    YYRedEnvelopeFragment yYRedEnvelopeFragment = YYRedEnvelopeFragment.this;
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 != null) {
                        b2.relationship = yYRedEnvOpenedExtra.is_followed;
                    }
                    YYObserverManager a2 = YYObserverManager.a();
                    YYRoomModel b3 = YYRoomInfoManager.e().b();
                    a2.a(b3 == null ? null : b3.uid, yYRedEnvOpenedExtra.is_followed);
                    yYRedEnvelopeFragment.i();
                }
                return super.onUIFailure(i, str4, str5);
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
                r0 = r0.c;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.yy_china.model.YYRedEnvOpenedModel, com.blued.android.module.yy_china.model.YYRedEnvOpenedExtra> r5) {
                /*
                    r4 = this;
                    r0 = r5
                    if (r0 != 0) goto L5
                    return
                L5:
                    r0 = r4
                    com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment r0 = com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment.this
                    r7 = r0
                    r0 = r5
                    S extends com.blued.android.framework.http.parser.BluedEntityBaseExtra r0 = r0.extra
                    com.blued.android.module.yy_china.model.YYRedEnvOpenedExtra r0 = (com.blued.android.module.yy_china.model.YYRedEnvOpenedExtra) r0
                    r8 = r0
                    r0 = r8
                    if (r0 != 0) goto L1b
                    goto L57
                L1b:
                    com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.b()
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L29
                    goto L32
                L29:
                    r0 = r6
                    r1 = r8
                    java.lang.String r1 = r1.is_followed
                    r0.relationship = r1
                L32:
                    com.blued.android.module.yy_china.manager.YYObserverManager r0 = com.blued.android.module.yy_china.manager.YYObserverManager.a()
                    r9 = r0
                    com.blued.android.module.yy_china.manager.YYRoomInfoManager r0 = com.blued.android.module.yy_china.manager.YYRoomInfoManager.e()
                    com.blued.android.module.yy_china.model.YYRoomModel r0 = r0.b()
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L47
                    r0 = 0
                    r6 = r0
                    goto L4c
                L47:
                    r0 = r6
                    java.lang.String r0 = r0.uid
                    r6 = r0
                L4c:
                    r0 = r9
                    r1 = r6
                    r2 = r8
                    java.lang.String r2 = r2.is_followed
                    r0.a(r1, r2)
                L57:
                    r0 = r5
                    java.lang.Object r0 = r0.getSingleData()
                    com.blued.android.module.yy_china.model.YYRedEnvOpenedModel r0 = (com.blued.android.module.yy_china.model.YYRedEnvOpenedModel) r0
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L64
                    return
                L64:
                    r0 = r7
                    com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment.a(r0)
                    r0 = r7
                    r0.dismissAllowingStateLoss()
                    r0 = r7
                    com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$OpenHongbaoListener r0 = com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment.b(r0)
                    if (r0 == 0) goto L84
                    r0 = r7
                    com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$OpenHongbaoListener r0 = com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment.b(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L7d
                    return
                L7d:
                    r0 = r6
                    r1 = r5
                    r0.a(r1)
                L84:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYRedEnvelopeFragment$openRedEnvelope$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        CharSequence charSequence;
        if (a(YYRoomInfoManager.e().b()) || YYRoomInfoManager.e().y()) {
            this.g = ChatRoomProtos.Event.YY_ROOM_REDBAG_GET_CLICK;
            charSequence = "领取";
        } else {
            this.g = ChatRoomProtos.Event.YY_ROOM_REDBAG_FOLLOW_GET_CLICK;
            charSequence = "关注房主并领取";
        }
        FragmentYyRedEnvelopeLayoutBinding fragmentYyRedEnvelopeLayoutBinding = this.a;
        ShapeTextView shapeTextView = fragmentYyRedEnvelopeLayoutBinding == null ? null : fragmentYyRedEnvelopeLayoutBinding.h;
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_red_envelope_layout, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_layout, container, true)");
        this.a = FragmentYyRedEnvelopeLayoutBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        super.onDismiss(dialog);
        j();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        g();
    }
}
