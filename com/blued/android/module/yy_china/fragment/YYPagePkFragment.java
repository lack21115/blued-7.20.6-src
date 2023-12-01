package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.YyChatRoomTagShapeUtils;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.fragment.YYPagePkFragment;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEventMatching;
import com.blued.android.module.yy_china.model.YYInvitationPkModel;
import com.blued.android.module.yy_china.model.YYPKConfigureModel;
import com.blued.android.module.yy_china.model.YYRecommendPkModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.PkRotationView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPagePkFragment.class */
public class YYPagePkFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17374a = new Companion(null);
    private PkRotationView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17375c;
    private ShapeTextView d;
    private RecyclerView e;
    private LinearLayout f;
    private ShapeTextView g;
    private ToggleButton h;
    private TextView i;
    private TextView j;
    private RoomAdapter k;
    private YYRoomModel l;
    private YYConfigureTimeDialog m;
    private YYSearchDialogFragment n;
    private YYVoteTimeModel o;
    private YYRecommendPkModel p;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPagePkFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPagePkFragment$RoomAdapter.class */
    public final class RoomAdapter extends BaseMultiItemQuickAdapter<YYRecommendPkModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPagePkFragment f17376a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f17377c;
        private BluedEntityA<YYPKConfigureModel> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoomAdapter(YYPagePkFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17376a = this$0;
            this.f17377c = 1;
            addItemType(this.b, R.layout.item_yy_pk_room);
            addItemType(this.f17377c, R.layout.item_yy_pk_room_info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYPagePkFragment this$0, YYRecommendPkModel yYRecommendPkModel, View view) {
            Intrinsics.e(this$0, "this$0");
            YYRoomModel b = YYRoomInfoManager.e().b();
            this$0.b(b == null ? null : b.room_id, yYRecommendPkModel == null ? null : yYRecommendPkModel.room_id, yYRecommendPkModel == null ? null : yYRecommendPkModel.uid);
        }

        private final void b(BaseViewHolder baseViewHolder) {
            YYPagePkFragment yYPagePkFragment = this.f17376a;
            View view = baseViewHolder == null ? null : baseViewHolder.itemView;
            Intrinsics.a(view);
            Intrinsics.c(view, "helper?.itemView!!");
            yYPagePkFragment.a(view);
            YYPagePkFragment yYPagePkFragment2 = this.f17376a;
            View view2 = baseViewHolder.itemView;
            Intrinsics.c(view2, "helper.itemView");
            yYPagePkFragment2.c(view2);
            BluedEntityA<YYPKConfigureModel> bluedEntityA = this.d;
            if (bluedEntityA == null) {
                return;
            }
            this.f17376a.a(bluedEntityA);
        }

        private final void b(BaseViewHolder baseViewHolder, final YYRecommendPkModel yYRecommendPkModel) {
            String str;
            SVGAImageView sVGAImageView = baseViewHolder == null ? null : (SVGAImageView) baseViewHolder.getView(R.id.iv_apng);
            ShapeableImageView shapeableImageView = baseViewHolder == null ? null : (ShapeableImageView) baseViewHolder.getView(R.id.room_pic);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_room_name);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_host_name);
            TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_count);
            TextView textView4 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_room_category);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.btn_invite_pk);
            ShapeLinearLayout shapeLinearLayout = baseViewHolder == null ? null : (ShapeLinearLayout) baseViewHolder.getView(R.id.ll_live_type);
            if (sVGAImageView != null) {
                sVGAImageView.setMIsNeedOnDetachedFromWindow(true);
                new SVGAPlayer.Builder(ImgURLMap.f10885a.a("yy_home_small_white")).a(sVGAImageView);
            }
            if (yYRecommendPkModel != null && (str = yYRecommendPkModel.user_avatar) != null) {
                ImageLoader.a(this.f17376a.getFragmentActive(), str).b(R.drawable.user_header_square).a(shapeableImageView);
            }
            if (textView != null) {
                textView.setText(yYRecommendPkModel == null ? null : yYRecommendPkModel.room_name);
            }
            if (textView3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(yYRecommendPkModel == null ? null : Integer.valueOf(yYRecommendPkModel.room_member_count));
                sb.append((char) 20154);
                textView3.setText(sb.toString());
            }
            if (textView2 != null) {
                textView2.setText(yYRecommendPkModel == null ? null : yYRecommendPkModel.user_name);
            }
            if (textView4 != null) {
                textView4.setText(yYRecommendPkModel == null ? null : yYRecommendPkModel.room_type_name);
            }
            if (shapeLinearLayout != null) {
                ShapeLinearLayout shapeLinearLayout2 = shapeLinearLayout;
                ShapeHelper.a(shapeLinearLayout2, shapeLinearLayout.getResources().getDimension(R.dimen.dp_10));
                YyChatRoomTagShapeUtils yyChatRoomTagShapeUtils = YyChatRoomTagShapeUtils.f10915a;
                String str2 = yYRecommendPkModel == null ? null : yYRecommendPkModel.room_type_id;
                Intrinsics.a((Object) str2);
                yyChatRoomTagShapeUtils.a(shapeLinearLayout2, str2);
            }
            if (shapeTextView == null) {
                return;
            }
            final YYPagePkFragment yYPagePkFragment = this.f17376a;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$RoomAdapter$2GkBtHZ1GDW7YgMwSEA0dyOViFs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYPagePkFragment.RoomAdapter.a(YYPagePkFragment.this, yYRecommendPkModel, view);
                }
            });
        }

        public final void a(BluedEntityA<YYPKConfigureModel> bluedEntityA) {
            this.d = bluedEntityA;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onViewRecycled(BaseViewHolder holder) {
            Intrinsics.e(holder, "holder");
            super.onViewRecycled(holder);
            SVGAImageView sVGAImageView = (SVGAImageView) holder.getView(R.id.iv_apng);
            if (sVGAImageView == null) {
                return;
            }
            sVGAImageView.a(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYRecommendPkModel yYRecommendPkModel) {
            Integer valueOf = yYRecommendPkModel == null ? null : Integer.valueOf(yYRecommendPkModel.getItemType());
            int i = this.f17377c;
            if (valueOf != null && valueOf.intValue() == i) {
                b(baseViewHolder);
                return;
            }
            int i2 = this.b;
            if (valueOf != null && valueOf.intValue() == i2) {
                b(baseViewHolder, yYRecommendPkModel);
            }
        }
    }

    private final void a(int i, boolean z) {
        if (this.o == null) {
            this.o = new YYVoteTimeModel();
        }
        YYVoteTimeModel yYVoteTimeModel = this.o;
        if (yYVoteTimeModel != null) {
            yYVoteTimeModel.timeStr = i + "分钟";
        }
        YYVoteTimeModel yYVoteTimeModel2 = this.o;
        if (yYVoteTimeModel2 != null) {
            yYVoteTimeModel2.timeMill = i;
        }
        YYVoteTimeModel yYVoteTimeModel3 = this.o;
        if (yYVoteTimeModel3 == null) {
            return;
        }
        yYVoteTimeModel3.isCheck = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BluedEntityA<YYPKConfigureModel> bluedEntityA) {
        YYPKConfigureModel singleData;
        PkRotationView pkRotationView;
        if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
            return;
        }
        boolean z = true;
        a(singleData.lasted, true);
        TextView textView = this.i;
        if (textView != null) {
            YYVoteTimeModel h = h();
            textView.setText(h == null ? null : h.timeStr);
        }
        int i = singleData.recommended;
        if (i == 0 || i != 1) {
            z = false;
        }
        ToggleButton d = d();
        if (d != null) {
            d.setChecked(z);
        }
        List<String> list = singleData.imgs;
        if (list == null || (pkRotationView = this.b) == null) {
            return;
        }
        pkRotationView.a(list, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static final void a(YYPagePkFragment yYPagePkFragment, CompoundButton compoundButton, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPagePkFragment this$0, String requestKey, Bundle result) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(requestKey, "requestKey");
        Intrinsics.e(result, "result");
        this$0.a(requestKey, result);
    }

    private final void a(String str, Bundle bundle) {
        Logger.e("YYPagePkFragment", Intrinsics.a("onFragmentResult: ", (Object) str));
        if (Intrinsics.a((Object) str, (Object) "search_name")) {
            Serializable serializable = bundle.getSerializable("host_name");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYRecommendPkModel");
            }
            YYRecommendPkModel yYRecommendPkModel = (YYRecommendPkModel) serializable;
            this.p = yYRecommendPkModel;
            TextView textView = this.j;
            if (textView == null) {
                return;
            }
            textView.setText(yYRecommendPkModel == null ? null : yYRecommendPkModel.user_name);
        } else if (Intrinsics.a((Object) str, (Object) "option_time")) {
            Serializable serializable2 = bundle.getSerializable("bundle_time");
            if (serializable2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYVoteTimeModel");
            }
            YYVoteTimeModel yYVoteTimeModel = (YYVoteTimeModel) serializable2;
            this.o = yYVoteTimeModel;
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setText(yYVoteTimeModel == null ? null : yYVoteTimeModel.timeStr);
            }
            YYVoteTimeModel yYVoteTimeModel2 = this.o;
            if (yYVoteTimeModel2 == null) {
                return;
            }
            a(yYVoteTimeModel2.timeMill, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        ShapeTextView shapeTextView = this.g;
        if (shapeTextView != null) {
            shapeTextView.setClickable(z);
        }
        if (z) {
            ShapeHelper.a(this.g, R.color.syc_00E0AB, R.color.syc_3883FD);
        } else {
            ShapeHelper.a(this.g, R.color.color_adadad, R.color.syc_7C7C7C);
        }
    }

    private final void b(View view) {
        this.e = (RecyclerView) view.findViewById(R.id.rv_room_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.k = getContext() == null ? null : new RoomAdapter(this);
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.e;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPagePkFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPagePkFragment this$0, String requestKey, Bundle result) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(requestKey, "requestKey");
        Intrinsics.e(result, "result");
        this$0.a(requestKey, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(View view) {
        ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.btn_pk_enable);
        this.h = toggleButton;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$59py8hwh0CDZJlDOy29tV5p0LAM
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    YYPagePkFragment.a(YYPagePkFragment.this, compoundButton, z);
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.id.btn_set_time);
        this.i = textView;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$IzeFAkVkSj9LzqWfaj9ggYt5KDM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPagePkFragment.b(YYPagePkFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPagePkFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PK_CREATE_MATCH_CLICK;
        YYRoomModel yYRoomModel = this$0.l;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.l;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
        this$0.m();
    }

    private final void d(View view) {
        this.f = (LinearLayout) view.findViewById(R.id.ll_search);
        this.g = (ShapeTextView) view.findViewById(R.id.btn_invite);
        this.j = (TextView) view.findViewById(R.id.host_name);
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$0R158DFAMeV21ruFFZeErBju58s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYPagePkFragment.d(YYPagePkFragment.this, view2);
                }
            });
        }
        ShapeTextView shapeTextView = this.g;
        if (shapeTextView != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$U_X2mftSQsPEAzxwC2d8zPn0XtE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYPagePkFragment.e(YYPagePkFragment.this, view2);
                }
            });
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.addTextChangedListener(new ITextWatcher() { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$initSearch$3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (editable != null) {
                        StringsKt.b(editable);
                    }
                    YYPagePkFragment yYPagePkFragment = YYPagePkFragment.this;
                    Integer valueOf = editable == null ? null : Integer.valueOf(editable.length());
                    Intrinsics.a(valueOf);
                    yYPagePkFragment.a(valueOf.intValue() > 0);
                }
            });
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYPagePkFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYSearchDialogFragment yYSearchDialogFragment = new YYSearchDialogFragment();
        this$0.n = yYSearchDialogFragment;
        if (yYSearchDialogFragment == null) {
            return;
        }
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYSearchDialogFragment.show(childFragmentManager, "search_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYPagePkFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PK_CREATE_INVITE_CLICK;
        YYRoomModel yYRoomModel = this$0.l;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this$0.l;
        String str2 = yYRoomModel2 == null ? null : yYRoomModel2.uid;
        YYRecommendPkModel yYRecommendPkModel = this$0.p;
        EventTrackYY.l(event, str, str2, yYRecommendPkModel == null ? null : yYRecommendPkModel.uid);
        YYRoomModel yYRoomModel3 = this$0.l;
        String str3 = yYRoomModel3 == null ? null : yYRoomModel3.room_id;
        YYRecommendPkModel yYRecommendPkModel2 = this$0.p;
        String str4 = yYRecommendPkModel2 == null ? null : yYRecommendPkModel2.room_id;
        YYRecommendPkModel yYRecommendPkModel3 = this$0.p;
        this$0.a(str3, str4, yYRecommendPkModel3 == null ? null : yYRecommendPkModel3.uid);
    }

    private final void n() {
        if (this.m == null) {
            a(5, true);
        }
        YYConfigureTimeDialog a2 = YYConfigureTimeDialog.f17171a.a(this.o);
        this.m = a2;
        if (a2 == null) {
            return;
        }
        a2.show(getChildFragmentManager(), "time_dialog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ShapeTextView a() {
        return this.d;
    }

    public void a(int i, int i2) {
        YYRoomModel yYRoomModel = this.l;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.a(str, i, i2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$setConfigure$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                TextView e = YYPagePkFragment.this.e();
                if (e == null) {
                    return;
                }
                e.setText("");
            }
        }, getFragmentActive());
    }

    public void a(View view) {
        Intrinsics.e(view, "view");
        this.b = (PkRotationView) view.findViewById(R.id.living_room_list);
        this.f17375c = (TextView) view.findViewById(R.id.tv_living_count);
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_match);
        this.d = shapeTextView;
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$pxjhkTn6IQsydJb95GCo8ux8OKw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPagePkFragment.c(YYPagePkFragment.this, view2);
            }
        });
    }

    public void a(YYConstants.MatchingFromSource type) {
        Intrinsics.e(type, "type");
        try {
            YYEventMatching yYEventMatching = new YYEventMatching();
            yYEventMatching.matchType = type;
            LiveEventBus.get("show_matching_pk").post(yYEventMatching);
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseDialogFragment");
            }
            ((BaseDialogFragment) parentFragment).dismiss();
        } catch (Exception e) {
        }
    }

    public void a(String str, String str2, String str3) {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.a(str, str2, str3, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$sendInvitationPK$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYPagePkFragment.this.a(YYConstants.MatchingFromSource.invitation);
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout b() {
        return this.f;
    }

    public void b(String str, String str2, String str3) {
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PK_CREATE_USER_INVITE_CLICK;
        YYRoomModel yYRoomModel = this.l;
        String str4 = null;
        String str5 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.l;
        if (yYRoomModel2 != null) {
            str4 = yYRoomModel2.uid;
        }
        EventTrackYY.l(event, str5, str4, str3);
        a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ShapeTextView c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ToggleButton d() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView e() {
        return this.j;
    }

    public final RoomAdapter f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final YYRoomModel g() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final YYVoteTimeModel h() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final YYRecommendPkModel i() {
        return this.p;
    }

    public void j() {
        YYRoomModel yYRoomModel = this.l;
        YYRoomHttpUtils.e(yYRoomModel == null ? null : yYRoomModel.room_id, (BluedUIHttpResponse) k(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BluedUIHttpResponse<BluedEntityA<YYPKConfigureModel>> k() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        return new BluedUIHttpResponse<BluedEntityA<YYPKConfigureModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$getConfigHttpResponse$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYPKConfigureModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                YYPagePkFragment yYPagePkFragment = YYPagePkFragment.this;
                YYRecommendPkModel yYRecommendPkModel = new YYRecommendPkModel();
                yYRecommendPkModel.type = 1;
                ArrayList arrayList = new ArrayList();
                arrayList.add(yYRecommendPkModel);
                YYPagePkFragment.RoomAdapter f = yYPagePkFragment.f();
                if (f != null) {
                    f.setNewData(arrayList);
                }
                YYPagePkFragment.RoomAdapter f2 = yYPagePkFragment.f();
                if (f2 != null) {
                    f2.a(bluedEntityA);
                }
                yYPagePkFragment.l();
            }
        };
    }

    public void l() {
        YYRoomModel yYRoomModel = this.l;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.b(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRecommendPkModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$getRecommendList$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRecommendPkModel> bluedEntityA) {
                YYPagePkFragment.RoomAdapter f = YYPagePkFragment.this.f();
                if (f == null) {
                    return;
                }
                List<YYRecommendPkModel> list = bluedEntityA == null ? null : bluedEntityA.data;
                Intrinsics.a(list);
                f.addData((Collection) list);
            }
        }, getFragmentActive());
    }

    public void m() {
        YYRoomModel yYRoomModel = this.l;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.T(str, new BluedUIHttpResponse<BluedEntityA<YYInvitationPkModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragment$autoMatching$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYInvitationPkModel> bluedEntityA) {
                YYPagePkFragment.this.a(YYConstants.MatchingFromSource.random);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = YYRoomInfoManager.e().b();
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_PK_CREATE_PK_PAGE_SHOW;
        YYRoomModel yYRoomModel = this.l;
        String str = null;
        String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.l;
        if (yYRoomModel2 != null) {
            str = yYRoomModel2.uid;
        }
        EventTrackYY.d(event, str2, str);
        YYPagePkFragment yYPagePkFragment = this;
        getChildFragmentManager().setFragmentResultListener("search_name", yYPagePkFragment, new FragmentResultListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$cH48MWkZSXSsfvdKLkiah1tAKUQ
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str3, Bundle bundle2) {
                YYPagePkFragment.a(YYPagePkFragment.this, str3, bundle2);
            }
        });
        getChildFragmentManager().setFragmentResultListener("option_time", yYPagePkFragment, new FragmentResultListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragment$l52Mc39oEiPIldS0AXjcfEFBIpw
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str3, Bundle bundle2) {
                YYPagePkFragment.b(YYPagePkFragment.this, str3, bundle2);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View view = getLayoutInflater().inflate(R.layout.fragment_page_pk_layout, (ViewGroup) null);
        Intrinsics.c(view, "view");
        d(view);
        Intrinsics.c(view, "view");
        b(view);
        return view;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        YYConfigureTimeDialog yYConfigureTimeDialog = this.m;
        if (yYConfigureTimeDialog != null) {
            yYConfigureTimeDialog.dismiss();
        }
        YYSearchDialogFragment yYSearchDialogFragment = this.n;
        if (yYSearchDialogFragment != null) {
            yYSearchDialogFragment.dismiss();
        }
        PkRotationView pkRotationView = this.b;
        if (pkRotationView == null) {
            return;
        }
        pkRotationView.a();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        j();
    }
}
