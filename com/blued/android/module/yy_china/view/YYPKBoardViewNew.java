package com.blued.android.module.yy_china.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ItemRoomPkLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYJumpLoadingFragment;
import com.blued.android.module.yy_china.fragment.YYPKEndDialogNew;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.EventRoomPkSvgaExtra;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMatchingRoomModel;
import com.blued.android.module.yy_china.model.YYMsgPkProgressExtra;
import com.blued.android.module.yy_china.model.YYMsgPkRoomNewExtra;
import com.blued.android.module.yy_china.model.YYPkRoomStatusExtra;
import com.blued.android.module.yy_china.model.YYRoomIm99Mode;
import com.blued.android.module.yy_china.model.YYRoomMemberInfoModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYRoomPKTimerEvent;
import com.blued.android.module.yy_china.model.YYRoomPkMVPExtra;
import com.blued.android.module.yy_china.model.YYSeatUserModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.trtc.TRTCSEIMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMicrophoneStatusMsg;
import com.blued.android.module.yy_china.model.trtc.TRTCSendPKMuteMsg;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYPKBoardViewNew;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.protobuf.Any;
import com.igexin.push.config.c;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPKBoardViewNew.class */
public final class YYPKBoardViewNew extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ItemRoomPkLayoutBinding f18353a;
    private YYRoomModel b;

    /* renamed from: c  reason: collision with root package name */
    private BaseYYStudioFragment f18354c;
    private MemberAdapter d;
    private RankAdapter e;
    private RankAdapter f;
    private YYPkInfoDialog g;
    private int h;
    private YYMsgPkRoomNewExtra i;
    private Set<String> j;
    private Set<String> k;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPKBoardViewNew$MemberAdapter.class */
    public final class MemberAdapter extends BaseQuickAdapter<YYRoomMemberInfoModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPKBoardViewNew f18355a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberAdapter(YYPKBoardViewNew this$0) {
            super(R.layout.item_room_pk_member_layout, null);
            Intrinsics.e(this$0, "this$0");
            this.f18355a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYPKBoardViewNew this$0, BaseViewHolder baseViewHolder, YYMemberRoomPkView yYMemberRoomPkView, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.a(baseViewHolder.getAdapterPosition(), yYMemberRoomPkView);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, YYRoomMemberInfoModel yYRoomMemberInfoModel) {
            YYMemberRoomPkView yYMemberRoomPkView = baseViewHolder == null ? null : (YYMemberRoomPkView) baseViewHolder.getView(R.id.ll_member_view);
            ViewGroup.LayoutParams layoutParams = yYMemberRoomPkView == null ? null : yYMemberRoomPkView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (baseViewHolder.getAdapterPosition() == 0) {
                layoutParams2.leftMargin = DensityUtils.a(this.mContext, 4.0f);
            } else {
                layoutParams2.leftMargin = 0;
            }
            BaseYYStudioFragment baseYYStudioFragment = this.f18355a.f18354c;
            yYMemberRoomPkView.a(yYRoomMemberInfoModel, baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive());
            final YYPKBoardViewNew yYPKBoardViewNew = this.f18355a;
            final YYMemberRoomPkView yYMemberRoomPkView2 = yYMemberRoomPkView;
            yYMemberRoomPkView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$MemberAdapter$mUyiD1LntFDOfw1s3qR5MhI9Z-w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYPKBoardViewNew.MemberAdapter.a(YYPKBoardViewNew.this, baseViewHolder, yYMemberRoomPkView2, view);
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPKBoardViewNew$RankAdapter.class */
    public final class RankAdapter extends BaseQuickAdapter<YYSeatUserModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYPKBoardViewNew f18356a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RankAdapter(YYPKBoardViewNew this$0, boolean z) {
            super(R.layout.item_room_pk_rank, new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f18356a = this$0;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYSeatUserModel yYSeatUserModel, YYPKBoardViewNew this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            if (yYSeatUserModel == null || TextUtils.isEmpty(yYSeatUserModel.uid)) {
                BaseYYStudioFragment baseYYStudioFragment = this$0.f18354c;
                if (baseYYStudioFragment == null) {
                    return;
                }
                baseYYStudioFragment.a(true, "", "");
                return;
            }
            BaseYYStudioFragment baseYYStudioFragment2 = this$0.f18354c;
            if (baseYYStudioFragment2 == null) {
                return;
            }
            String str = yYSeatUserModel.uid;
            String str2 = yYSeatUserModel.name;
            String str3 = yYSeatUserModel.avatar;
            YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
            String str4 = yYUserInfo == null ? null : yYUserInfo.chat_anchor;
            String str5 = yYSeatUserModel.uid;
            Intrinsics.c(str5, "item.uid");
            baseYYStudioFragment2.a(str, str2, str3, str4, this$0.a(str5));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final YYSeatUserModel yYSeatUserModel) {
            View view;
            View view2;
            ShapeableImageView shapeableImageView = baseViewHolder == null ? null : (ShapeableImageView) baseViewHolder.getView(R.id.header_img);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_serial_num);
            ShapeTextView shapeTextView2 = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.tv_empty);
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            if (shapeableImageView != null) {
                shapeableImageView.setImageResource(R.drawable.shape_circular_202020);
            }
            if (shapeableImageView != null) {
                final YYPKBoardViewNew yYPKBoardViewNew = this.f18356a;
                shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$RankAdapter$wcpmGLYkPyE_loxCVsJBC3PUvcE
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        YYPKBoardViewNew.RankAdapter.a(YYSeatUserModel.this, yYPKBoardViewNew, view3);
                    }
                });
            }
            if (this.b) {
                if (shapeableImageView != null) {
                    shapeableImageView.setStrokeColor(ContextCompat.getColorStateList(this.mContext, R.color.syc_FF57F0));
                }
                ShapeHelper.b(shapeTextView, R.color.syc_FF57F0);
                if (baseViewHolder != null && (view2 = baseViewHolder.itemView) != null) {
                    view2.setPadding(0, 0, this.mContext.getResources().getDimensionPixelOffset(R.dimen.dp_5), 0);
                }
            } else {
                if (shapeableImageView != null) {
                    shapeableImageView.setStrokeColor(ContextCompat.getColorStateList(this.mContext, R.color.syc_3883FD));
                }
                ShapeHelper.b(shapeTextView, R.color.syc_3883FD);
                if (baseViewHolder != null && (view = baseViewHolder.itemView) != null) {
                    view.setPadding(this.mContext.getResources().getDimensionPixelOffset(R.dimen.dp_5), 0, 0, 0);
                }
            }
            if (yYSeatUserModel == null) {
                return;
            }
            if (TextUtils.isEmpty(yYSeatUserModel.uid)) {
                if (shapeTextView != null) {
                    shapeTextView.setVisibility(8);
                }
                if (shapeTextView2 == null) {
                    return;
                }
                shapeTextView2.setVisibility(0);
                return;
            }
            if (shapeTextView != null) {
                shapeTextView.setText(String.valueOf(baseViewHolder == null ? null : Integer.valueOf(baseViewHolder.getAdapterPosition() + 1)));
            }
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(8);
            }
            if (shapeTextView != null) {
                shapeTextView.setVisibility(0);
            }
            ImageLoader.a((IRequestHost) null, yYSeatUserModel.avatar).b(R.drawable.shape_circular_202020).d(R.drawable.user_bg_round).a(shapeableImageView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYPKBoardViewNew(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYPKBoardViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPKBoardViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ItemRoomPkLayoutBinding a2 = ItemRoomPkLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18353a = a2;
        this.b = YYRoomInfoManager.e().b();
        this.h = AppInfo.l - DensityUtils.a(getContext(), 74.0f);
        this.d = new MemberAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f18353a.u.setLayoutManager(linearLayoutManager);
        this.f18353a.u.setAdapter(this.d);
        MemberAdapter memberAdapter = this.d;
        if (memberAdapter != null) {
            memberAdapter.bindToRecyclerView(this.f18353a.u);
        }
        ViewGroup.LayoutParams layoutParams = this.f18353a.b.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.width = this.h;
        layoutParams2.leftMargin = DensityUtils.a(getContext(), 25.0f);
        layoutParams2.rightMargin = DensityUtils.a(getContext(), 25.0f);
        this.j = new LinkedHashSet();
        this.k = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SVGACallback a(final View view) {
        return new SVGACallback() { // from class: com.blued.android.module.yy_china.view.YYPKBoardViewNew$getAnimationCallback$1
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                ItemRoomPkLayoutBinding itemRoomPkLayoutBinding;
                View view2 = View.this;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                View view3 = View.this;
                if (view3 != null && view3.getId() == R.id.img_first_time) {
                    itemRoomPkLayoutBinding = this.f18353a;
                    itemRoomPkLayoutBinding.e.setVisibility(0);
                }
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        };
    }

    private final void a() {
        this.f18353a.s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$c0bhcB8K4KNeMTj9-taw_nWbJuY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.b(YYPKBoardViewNew.this, view);
            }
        });
        this.f18353a.o.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$q-0QK72FgaJhndwKT09rZaTw0nw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.c(YYPKBoardViewNew.this, view);
            }
        }, c.j, null));
        this.f18353a.q.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$nPGufR2yRS9xvk62zfzkehZmoxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.d(YYPKBoardViewNew.this, view);
            }
        }, c.j, null));
        this.f18353a.f16653a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$YycunDxdTXU0fTAU7S8mc7WL3aI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.e(YYPKBoardViewNew.this, view);
            }
        });
    }

    private final void a(float f, float f2) {
        this.f18353a.x.setText(CommonStringUtils.a(f2));
        this.f18353a.C.setText(CommonStringUtils.a(f));
        if (f == f2) {
            setProgress(50);
        } else {
            setProgress((int) ((f / (f + f2)) * 100));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, View view) {
        MemberAdapter memberAdapter = this.d;
        if (memberAdapter == null) {
            return;
        }
        List<YYRoomMemberInfoModel> data = memberAdapter.getData();
        if (!(data == null || data.isEmpty()) && i <= memberAdapter.getData().size() - 1 && i >= 0) {
            YYRoomMemberInfoModel yYRoomMemberInfoModel = memberAdapter.getData().get(i);
            BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
            if (baseYYStudioFragment == null) {
                return;
            }
            baseYYStudioFragment.a(view, yYRoomMemberInfoModel, yYRoomMemberInfoModel.mic_position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        ToastUtils.a("该邀请已过期", 0);
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKEndDialogNew yYPKEndDialogNew, YYRoomPkMVPExtra yYRoomPkMVPExtra) {
        if (yYPKEndDialogNew != null) {
            yYPKEndDialogNew.dismissAllowingStateLoss();
        }
        if (yYRoomPkMVPExtra == null || yYRoomPkMVPExtra.mvp == null || yYRoomPkMVPExtra.mvp.isEmpty()) {
            return;
        }
        EventRoomPkSvgaExtra eventRoomPkSvgaExtra = new EventRoomPkSvgaExtra();
        eventRoomPkSvgaExtra.svgaName = yYRoomPkMVPExtra.mvp.size() > 1 ? "room_pk_mvp_couple.svga" : "room_pk_mvp_single.svga";
        eventRoomPkSvgaExtra.svgaType = 1;
        eventRoomPkSvgaExtra.users = yYRoomPkMVPExtra.mvp;
        eventRoomPkSvgaExtra.frameWidth = 0;
        eventRoomPkSvgaExtra.frameHeight = 0;
        LiveEventBus.get("play_svga_room_pk").post(eventRoomPkSvgaExtra);
    }

    private final void a(final YYMatchingRoomModel yYMatchingRoomModel) {
        ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_PK_INVITE_POP_SHOW;
        YYRoomModel yYRoomModel = this.b;
        EventTrackYY.q(event, yYRoomModel == null ? null : yYRoomModel.room_id, yYMatchingRoomModel.room_id, yYMatchingRoomModel.uid);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_invite_pk_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_invite_from);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = getResources().getString(R.string.yy_msg_invite_pk_description);
        Intrinsics.c(string, "resources.getString(R.st…sg_invite_pk_description)");
        StringBuilder sb = new StringBuilder();
        sb.append((char) 12300);
        sb.append((Object) yYMatchingRoomModel.name);
        sb.append((char) 12301);
        String format = String.format(string, Arrays.copyOf(new Object[]{sb.toString()}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        final Dialog b = LiveAlterDialog.b(getContext(), inflate, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$gBRkwfThL844YN4F-nMZHxsBlXg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.a(YYPKBoardViewNew.this, yYMatchingRoomModel, view);
            }
        }, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$6d9YttVjdmoO0Q6cpYLyESyexH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYPKBoardViewNew.b(YYPKBoardViewNew.this, yYMatchingRoomModel, view);
            }
        }, false, false);
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$pHTjcqx6mggAjnIBWcGTLFhTFFs
            @Override // java.lang.Runnable
            public final void run() {
                YYPKBoardViewNew.a(Dialog.this);
            }
        }, 30000L);
    }

    private final void a(YYRoomMemberInfoModel yYRoomMemberInfoModel) {
        if (yYRoomMemberInfoModel == null) {
            return;
        }
        this.f18353a.z.setText(yYRoomMemberInfoModel.getName());
        this.f18353a.y.setText(yYRoomMemberInfoModel.pk_level_name);
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYRoomMemberInfoModel.pk_level_img).a(this.f18353a.h);
        this.f18353a.n.b(false);
        this.f18353a.n.b(R.color.transparent, R.color.transparent);
        YYBaseUserHeadView yYBaseUserHeadView = this.f18353a.n;
        YYRoomMemberInfoModel yYRoomMemberInfoModel2 = yYRoomMemberInfoModel;
        BaseYYStudioFragment baseYYStudioFragment2 = this.f18354c;
        yYBaseUserHeadView.a(yYRoomMemberInfoModel2, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
        this.f18353a.n.a();
        if (TextUtils.isEmpty(yYRoomMemberInfoModel.pk_level_img)) {
            this.f18353a.h.setVisibility(8);
        }
    }

    private final void a(final YYRoomPkMVPExtra yYRoomPkMVPExtra, final YYPKEndDialogNew yYPKEndDialogNew) {
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$XpUBQOE5MWLli66JYK-5hq9nLmE
            @Override // java.lang.Runnable
            public final void run() {
                YYPKBoardViewNew.a(YYPKEndDialogNew.this, yYRoomPkMVPExtra);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKBoardViewNew this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.f18353a.m.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = ((int) (this$0.h * (i / 100))) + (i != 0 ? i != 100 ? 0 : -4 : 2);
        this$0.f18353a.m.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKBoardViewNew this$0, BaseYYStudioFragment fragment, YYGlobalMsgModel yYGlobalMsgModel) {
        RankAdapter rankAdapter;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(fragment, "$fragment");
        if (yYGlobalMsgModel == null) {
            return;
        }
        switch (yYGlobalMsgModel.type) {
            case 1:
                YYMatchingRoomModel invite = (YYMatchingRoomModel) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYMatchingRoomModel.class);
                Intrinsics.c(invite, "invite");
                this$0.a(invite);
                return;
            case 2:
            default:
                return;
            case 3:
                YYMsgPkRoomNewExtra yYMsgPkRoomNewExtra = (YYMsgPkRoomNewExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYMsgPkRoomNewExtra.class);
                this$0.i = yYMsgPkRoomNewExtra;
                if (yYMsgPkRoomNewExtra == null) {
                    return;
                }
                for (YYRoomMemberInfoModel yYRoomMemberInfoModel : yYMsgPkRoomNewExtra.seats) {
                    yYRoomMemberInfoModel.is_open_mic = yYRoomMemberInfoModel.mute == 0 ? 1 : 0;
                    yYRoomMemberInfoModel.position_status = yYRoomMemberInfoModel.seat_type;
                    yYRoomMemberInfoModel.chat_anchor = yYRoomMemberInfoModel.role;
                    yYRoomMemberInfoModel.speech_ripple = yYRoomMemberInfoModel.speech_ripple;
                    if (TextUtils.equals(yYRoomMemberInfoModel.chat_anchor, "1")) {
                        String str = yYRoomMemberInfoModel.room_id;
                        YYRoomModel b = YYRoomInfoManager.e().b();
                        if (TextUtils.equals(str, b == null ? null : b.room_id)) {
                            this$0.a(yYRoomMemberInfoModel);
                        } else {
                            this$0.b(yYRoomMemberInfoModel);
                        }
                    }
                }
                MemberAdapter memberAdapter = this$0.d;
                if (memberAdapter != null) {
                    memberAdapter.setNewData(yYMsgPkRoomNewExtra.seats);
                }
                this$0.h();
                return;
            case 4:
                YYMsgPkProgressExtra yYMsgPkProgressExtra = (YYMsgPkProgressExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYMsgPkProgressExtra.class);
                this$0.h();
                if (yYMsgPkProgressExtra == null) {
                    return;
                }
                this$0.a(StringUtils.a(yYMsgPkProgressExtra.left_pk_value, 0.0f), StringUtils.a(yYMsgPkProgressExtra.right_pk_value, 0.0f));
                ArrayList<YYSeatUserModel> arrayList = yYMsgPkProgressExtra.left_rank_list;
                if (!(arrayList == null || arrayList.isEmpty()) && (rankAdapter = this$0.e) != null) {
                    rankAdapter.setNewData(yYMsgPkProgressExtra.left_rank_list);
                }
                this$0.a(true, yYMsgPkProgressExtra.left_rank_list);
                this$0.a(false, yYMsgPkProgressExtra.right_rank_list);
                return;
            case 5:
                YYAudienceModel yYAudienceModel = (YYAudienceModel) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYAudienceModel.class);
                if (yYAudienceModel == null) {
                    return;
                }
                EventRoomPkSvgaExtra eventRoomPkSvgaExtra = new EventRoomPkSvgaExtra();
                String str2 = yYAudienceModel.room_id;
                YYRoomModel yYRoomModel = this$0.b;
                eventRoomPkSvgaExtra.svgaName = TextUtils.equals(str2, yYRoomModel == null ? null : yYRoomModel.room_id) ? "room_pk_red_wins.svga" : "room_pk_blue_wins.svga";
                eventRoomPkSvgaExtra.svgaType = 0;
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(yYAudienceModel);
                eventRoomPkSvgaExtra.users = arrayList2;
                eventRoomPkSvgaExtra.frameWidth = 290;
                eventRoomPkSvgaExtra.frameHeight = 260;
                LiveEventBus.get("play_svga_room_pk").post(eventRoomPkSvgaExtra);
                this$0.f18353a.e.setVisibility(8);
                return;
            case 6:
                YYRoomPkMVPExtra yYRoomPkMVPExtra = (YYRoomPkMVPExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYRoomPkMVPExtra.class);
                if (yYRoomPkMVPExtra == null) {
                    return;
                }
                int i = yYRoomPkMVPExtra.result;
                if (i == 0) {
                    this$0.f18353a.g.setImageResource(R.drawable.icon_room_pk_deuce);
                    this$0.f18353a.j.setImageResource(R.drawable.icon_room_pk_deuce);
                } else if (i == 1) {
                    this$0.f18353a.g.setImageResource(R.drawable.icon_room_pk_win);
                    this$0.f18353a.j.setImageResource(R.drawable.icon_room_pk_lose);
                } else if (i == 2) {
                    this$0.f18353a.g.setImageResource(R.drawable.icon_room_pk_lose);
                    this$0.f18353a.j.setImageResource(R.drawable.icon_room_pk_win);
                }
                this$0.f18353a.g.setVisibility(0);
                this$0.f18353a.j.setVisibility(0);
                YYPKEndDialogNew yYPKEndDialogNew = null;
                if (yYRoomPkMVPExtra.anchor_info != null) {
                    yYPKEndDialogNew = null;
                    if (yYRoomPkMVPExtra.other_anchor_info != null) {
                        yYPKEndDialogNew = new YYPKEndDialogNew(yYRoomPkMVPExtra);
                        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                        Intrinsics.c(parentFragmentManager, "fragment.parentFragmentManager");
                        yYPKEndDialogNew.show(parentFragmentManager, "new_pk_end_dialog");
                    }
                }
                this$0.a(yYRoomPkMVPExtra, yYPKEndDialogNew);
                return;
            case 7:
                this$0.setVisibility(8);
                RecyclerView recyclerView = fragment.j;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                this$0.i();
                return;
            case 8:
                YYRoomModel yYRoomModel2 = this$0.b;
                if (yYRoomModel2 == null) {
                    return;
                }
                this$0.a(yYRoomModel2.pk_has_connected);
                this$0.b(yYRoomModel2.room_pk_mute_all);
                this$0.g();
                return;
            case 9:
                YYPkRoomStatusExtra yYPkRoomStatusExtra = (YYPkRoomStatusExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, (Class<Object>) YYPkRoomStatusExtra.class);
                if (yYPkRoomStatusExtra.type == 9) {
                    this$0.setVisibility(8);
                    RecyclerView recyclerView2 = fragment.j;
                    if (recyclerView2 != null) {
                        recyclerView2.setVisibility(0);
                    }
                    this$0.i();
                    return;
                }
                this$0.h();
                if (yYPkRoomStatusExtra.show_first_kill == 1 && yYPkRoomStatusExtra.type == 1) {
                    this$0.f();
                }
                YYRoomInfoManager.e().a(yYPkRoomStatusExtra.countdown, yYPkRoomStatusExtra.type == 1 ? YYConstants.AnchormanPKStatus.Fighting : YYConstants.AnchormanPKStatus.Punish);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKBoardViewNew this$0, BaseYYStudioFragment fragment, YYRoomPKTimerEvent yYRoomPKTimerEvent) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(fragment, "$fragment");
        this$0.f18353a.B.setText(yYRoomPKTimerEvent.content);
        if (yYRoomPKTimerEvent.timerType == YYConstants.AnchormanPKStatus.Punish) {
            String str = yYRoomPKTimerEvent.content;
            if (str == null || str.length() == 0) {
                this$0.setVisibility(8);
                RecyclerView recyclerView = fragment.j;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                this$0.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKBoardViewNew this$0, YYImModel it) {
        YYMsgPkRoomNewExtra yYMsgPkRoomNewExtra;
        Intrinsics.e(this$0, "this$0");
        Integer valueOf = it == null ? null : Integer.valueOf(it.type);
        if (valueOf != null && valueOf.intValue() == 99) {
            Intrinsics.c(it, "it");
            YYRoomIm99Mode yYRoomIm99Mode = (YYRoomIm99Mode) AppInfo.f().fromJson(it.getMsgExtra(), (Class<Object>) YYRoomIm99Mode.class);
            if (!StringUtils.a("speech_ripple", yYRoomIm99Mode.getType()) || (yYMsgPkRoomNewExtra = this$0.i) == null) {
                return;
            }
            for (YYRoomMemberInfoModel yYRoomMemberInfoModel : yYMsgPkRoomNewExtra.seats) {
                if (StringUtils.a(yYRoomMemberInfoModel.getUid(), it.source_profile.getUid())) {
                    yYRoomMemberInfoModel.speech_ripple = yYRoomIm99Mode.getSpeech_ripple();
                    MemberAdapter memberAdapter = this$0.d;
                    if (memberAdapter == null) {
                        return;
                    }
                    memberAdapter.setNewData(yYMsgPkRoomNewExtra.seats);
                    return;
                }
            }
        } else if (valueOf != null && valueOf.intValue() == 55) {
            Intrinsics.c(it, "it");
            YYMsgPkRoomNewExtra yYMsgPkRoomNewExtra2 = this$0.i;
            if (yYMsgPkRoomNewExtra2 == null) {
                return;
            }
            for (YYRoomMemberInfoModel yYRoomMemberInfoModel2 : yYMsgPkRoomNewExtra2.seats) {
                if (StringUtils.a(yYRoomMemberInfoModel2.getUid(), it.contents)) {
                    yYRoomMemberInfoModel2.avatar_frame = it.getMsgExtra();
                    MemberAdapter memberAdapter2 = this$0.d;
                    if (memberAdapter2 == null) {
                        return;
                    }
                    memberAdapter2.setNewData(yYMsgPkRoomNewExtra2.seats);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPKBoardViewNew this$0, YYMatchingRoomModel invitation, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(invitation, "$invitation");
        YYRoomModel yYRoomModel = this$0.b;
        if (yYRoomModel == null) {
            return;
        }
        String str = yYRoomModel.room_id;
        Intrinsics.c(str, "it.room_id");
        String str2 = invitation.room_id;
        Intrinsics.c(str2, "invitation.room_id");
        String str3 = invitation.uid;
        Intrinsics.c(str3, "invitation.uid");
        this$0.a(str, str2, str3, 0);
    }

    private final void a(String str, String str2, String str3, int i) {
        EventTrackYY.q(i == 1 ? ChatRoomProtos.Event.YY_PK_INVITE_POP_PK_CLICK : ChatRoomProtos.Event.YY_PK_INVITE_POP_REJECT_CLICK, str, str2, str3);
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Any>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Any>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYPKBoardViewNew$sendAcceptPkNew$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Any> bluedEntityA) {
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.f18354c;
        YYRoomHttpUtils.b(str, str2, str3, i, bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        this.f18353a.i.setImageResource(z ? R.drawable.icon_room_pk_mic_open : R.drawable.icon_room_pk_mic_mute);
    }

    private final void a(boolean z, ArrayList<YYSeatUserModel> arrayList) {
        if (arrayList == null) {
            setEmptyRankList(z ? this.e : this.f);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 3) {
            arrayList2.addAll(arrayList.subList(0, 3));
        } else {
            arrayList2.addAll(arrayList);
            int size = arrayList.size();
            while (size < 3) {
                size++;
                YYSeatUserModel yYSeatUserModel = new YYSeatUserModel();
                yYSeatUserModel.uid = null;
                arrayList2.add(yYSeatUserModel);
            }
        }
        if (z) {
            RankAdapter rankAdapter = this.e;
            if (rankAdapter == null) {
                return;
            }
            rankAdapter.setNewData(arrayList2);
            return;
        }
        RankAdapter rankAdapter2 = this.f;
        if (rankAdapter2 == null) {
            return;
        }
        rankAdapter2.setNewData(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(String str) {
        List<YYRoomMemberInfoModel> list;
        YYMsgPkRoomNewExtra yYMsgPkRoomNewExtra = this.i;
        if (yYMsgPkRoomNewExtra == null || (list = yYMsgPkRoomNewExtra.seats) == null) {
            return false;
        }
        for (YYRoomMemberInfoModel yYRoomMemberInfoModel : list) {
            if (TextUtils.equals(yYRoomMemberInfoModel.getUid(), str)) {
                return true;
            }
        }
        return false;
    }

    private final void b() {
        if (YYRoomInfoManager.e().F()) {
            YYRoomModel yYRoomModel = this.b;
            int i = 0;
            if (yYRoomModel != null && yYRoomModel.pk_has_connected) {
                i = 1;
            }
            final int i2 = i ^ 1;
            YYRoomModel yYRoomModel2 = this.b;
            String str = yYRoomModel2 == null ? null : yYRoomModel2.room_id;
            BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
            final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
            BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYPKBoardViewNew$setMuteOther$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    YYRoomModel yYRoomModel3;
                    YYRoomModel yYRoomModel4;
                    if (i2 == 1) {
                        TRTCSendPKMuteMsg tRTCSendPKMuteMsg = new TRTCSendPKMuteMsg();
                        tRTCSendPKMuteMsg.cmdID = 1;
                        tRTCSendPKMuteMsg.roomId = YYRoomInfoManager.e().D();
                        yYRoomModel4 = this.b;
                        tRTCSendPKMuteMsg.userSig = yYRoomModel4 == null ? null : yYRoomModel4.user_sig;
                        AudioChannelManager.j().a(tRTCSendPKMuteMsg);
                    } else {
                        TRTCSEIMsg tRTCSEIMsg = new TRTCSEIMsg();
                        tRTCSEIMsg.cmdID = 2;
                        AudioChannelManager.j().a(tRTCSEIMsg);
                    }
                    YYPKBoardViewNew yYPKBoardViewNew = this;
                    yYRoomModel3 = yYPKBoardViewNew.b;
                    Boolean valueOf = yYRoomModel3 == null ? null : Boolean.valueOf(yYRoomModel3.pk_has_connected);
                    Intrinsics.a(valueOf);
                    yYPKBoardViewNew.a(valueOf.booleanValue());
                }
            };
            BaseYYStudioFragment baseYYStudioFragment2 = this.f18354c;
            YYRoomHttpUtils.e(str, String.valueOf(i2), (BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
        }
    }

    private final void b(final BaseYYStudioFragment baseYYStudioFragment) {
        BaseYYStudioFragment baseYYStudioFragment2 = baseYYStudioFragment;
        LiveEventBus.get("show_anchorman_pk_time", YYRoomPKTimerEvent.class).observe(baseYYStudioFragment2, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$WBRs3OdDE33aX9QCdY9ERxx69ug
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYPKBoardViewNew.a(YYPKBoardViewNew.this, baseYYStudioFragment, (YYRoomPKTimerEvent) obj);
            }
        });
        LiveEventBus.get("EVENT_NOTI_HEARD", YYImModel.class).observe(baseYYStudioFragment2, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$IYRSvGdKgJbj9lc_tBSTHm09fjA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYPKBoardViewNew.a(YYPKBoardViewNew.this, (YYImModel) obj);
            }
        });
        LiveEventBus.get("room_pk_message", YYGlobalMsgModel.class).observe(baseYYStudioFragment2, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$e8MSGGyUrIWqWWUzQzoTL85Fw_o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYPKBoardViewNew.a(YYPKBoardViewNew.this, baseYYStudioFragment, (YYGlobalMsgModel) obj);
            }
        });
    }

    private final void b(YYRoomMemberInfoModel yYRoomMemberInfoModel) {
        if (yYRoomMemberInfoModel == null) {
            return;
        }
        this.f18353a.E.setText(yYRoomMemberInfoModel.getName());
        this.f18353a.D.setText(yYRoomMemberInfoModel.pk_level_name);
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), yYRoomMemberInfoModel.pk_level_img).a(this.f18353a.k);
        this.f18353a.s.b(false);
        this.f18353a.s.b(R.color.transparent, R.color.transparent);
        YYBaseUserHeadView yYBaseUserHeadView = this.f18353a.s;
        YYRoomMemberInfoModel yYRoomMemberInfoModel2 = yYRoomMemberInfoModel;
        BaseYYStudioFragment baseYYStudioFragment2 = this.f18354c;
        yYBaseUserHeadView.a(yYRoomMemberInfoModel2, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
        this.f18353a.s.a();
        if (TextUtils.isEmpty(yYRoomMemberInfoModel.pk_level_img)) {
            this.f18353a.k.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPKBoardViewNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (YYRoomInfoManager.e().y()) {
            return;
        }
        YYJumpLoadingFragment.a(this$0.getContext());
        YYRoomInfoManager e = YYRoomInfoManager.e();
        BaseYYStudioFragment baseYYStudioFragment = this$0.f18354c;
        e.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getActivity(), YYRoomInfoManager.e().D(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPKBoardViewNew this$0, YYMatchingRoomModel invitation, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(invitation, "$invitation");
        YYRoomModel yYRoomModel = this$0.b;
        if (yYRoomModel == null) {
            return;
        }
        String str = yYRoomModel.room_id;
        Intrinsics.c(str, "it.room_id");
        String str2 = invitation.room_id;
        Intrinsics.c(str2, "invitation.room_id");
        String str3 = invitation.uid;
        Intrinsics.c(str3, "invitation.uid");
        this$0.a(str, str2, str3, 1);
    }

    private final void b(boolean z) {
        this.f18353a.f16654c.setImageResource(z ? R.drawable.icon_room_pk_mic_mute : R.drawable.icon_room_pk_mic_open);
    }

    private final void c() {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        if (yYRoomModel != null && yYRoomModel.pk_has_connected) {
            if (yYRoomModel.room_pk_mute_all) {
                yYRoomModel.room_pk_mute_all = false;
            } else {
                b();
                yYRoomModel.room_pk_mute_all = true;
            }
        } else if (yYRoomModel.room_pk_mute_all) {
            b();
            yYRoomModel.room_pk_mute_all = false;
        } else {
            yYRoomModel.room_pk_mute_all = true;
        }
        b(yYRoomModel.room_pk_mute_all);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPKBoardViewNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    private final void d() {
        final YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        String str = yYRoomModel.room_id;
        String str2 = yYRoomModel.room_pk_mute_all ? "0" : "1";
        BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
        final ActivityFragmentActive fragmentActive = baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(this, fragmentActive) { // from class: com.blued.android.module.yy_china.view.YYPKBoardViewNew$openOrCloseMic$1$1
            final /* synthetic */ YYPKBoardViewNew b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYRoomModel yYRoomModel2;
                TRTCSendPKMicrophoneStatusMsg tRTCSendPKMicrophoneStatusMsg = new TRTCSendPKMicrophoneStatusMsg();
                tRTCSendPKMicrophoneStatusMsg.cmdID = 8;
                tRTCSendPKMicrophoneStatusMsg.status = !YYRoomModel.this.room_pk_mute_all ? 1 : 0;
                yYRoomModel2 = this.b.b;
                tRTCSendPKMicrophoneStatusMsg.userSig = yYRoomModel2 == null ? null : yYRoomModel2.user_sig;
                tRTCSendPKMicrophoneStatusMsg.roomId = YYRoomInfoManager.e().D();
                tRTCSendPKMicrophoneStatusMsg.userId = YYRoomInfoManager.e().E();
                AudioChannelManager.j().a(tRTCSendPKMicrophoneStatusMsg);
            }
        };
        BaseYYStudioFragment baseYYStudioFragment2 = this.f18354c;
        YYRoomHttpUtils.f(str, str2, (BluedUIHttpResponse) bluedUIHttpResponse, baseYYStudioFragment2 == null ? null : baseYYStudioFragment2.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYPKBoardViewNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.b();
    }

    private final void e() {
        this.e = new RankAdapter(this, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f18353a.v.setLayoutManager(linearLayoutManager);
        this.f18353a.v.setAdapter(this.e);
        this.f = new RankAdapter(this, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(0);
        linearLayoutManager2.setStackFromEnd(true);
        linearLayoutManager2.setReverseLayout(true);
        this.f18353a.t.setLayoutManager(linearLayoutManager2);
        this.f18353a.t.setAdapter(this.f);
        RankAdapter rankAdapter = this.e;
        List<YYSeatUserModel> data = rankAdapter == null ? null : rankAdapter.getData();
        if (data == null || data.isEmpty()) {
            setEmptyRankList(this.e);
        }
        RankAdapter rankAdapter2 = this.f;
        List<YYSeatUserModel> data2 = rankAdapter2 == null ? null : rankAdapter2.getData();
        boolean z = true;
        if (data2 != null) {
            z = data2.isEmpty();
        }
        if (z) {
            setEmptyRankList(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(YYPKBoardViewNew this$0, View view) {
        FragmentManager childFragmentManager;
        YYPkInfoDialog yYPkInfoDialog;
        Intrinsics.e(this$0, "this$0");
        this$0.g = new YYPkInfoDialog();
        BaseYYStudioFragment baseYYStudioFragment = this$0.f18354c;
        if (baseYYStudioFragment == null || (childFragmentManager = baseYYStudioFragment.getChildFragmentManager()) == null || (yYPkInfoDialog = this$0.g) == null) {
            return;
        }
        yYPkInfoDialog.show(childFragmentManager, "qa_dialog");
    }

    private final void f() {
        this.f18353a.f.setVisibility(0);
        SVGAParser.a(SVGAParser.f15958a.b(), "svga_first_time.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.view.YYPKBoardViewNew$playAnimation$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                ItemRoomPkLayoutBinding itemRoomPkLayoutBinding;
                ItemRoomPkLayoutBinding itemRoomPkLayoutBinding2;
                ItemRoomPkLayoutBinding itemRoomPkLayoutBinding3;
                ItemRoomPkLayoutBinding itemRoomPkLayoutBinding4;
                SVGACallback a2;
                Intrinsics.e(videoItem, "videoItem");
                itemRoomPkLayoutBinding = YYPKBoardViewNew.this.f18353a;
                itemRoomPkLayoutBinding.f.setVideoItem(videoItem);
                itemRoomPkLayoutBinding2 = YYPKBoardViewNew.this.f18353a;
                itemRoomPkLayoutBinding2.f.a();
                itemRoomPkLayoutBinding3 = YYPKBoardViewNew.this.f18353a;
                SVGAImageView sVGAImageView = itemRoomPkLayoutBinding3.f;
                YYPKBoardViewNew yYPKBoardViewNew = YYPKBoardViewNew.this;
                itemRoomPkLayoutBinding4 = yYPKBoardViewNew.f18353a;
                a2 = yYPKBoardViewNew.a(itemRoomPkLayoutBinding4.f);
                sVGAImageView.setCallback(a2);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    private final void g() {
        YYMsgPkRoomNewExtra yYMsgPkRoomNewExtra = this.i;
        if (yYMsgPkRoomNewExtra == null) {
            return;
        }
        for (YYRoomMemberInfoModel yYRoomMemberInfoModel : yYMsgPkRoomNewExtra.seats) {
            yYRoomMemberInfoModel.is_open_mic = yYRoomMemberInfoModel.mute == 0 ? 1 : 0;
            YYRoomModel yYRoomModel = this.b;
            if ((yYRoomModel == null || yYRoomModel.pk_has_connected) ? false : true) {
                String str = yYRoomMemberInfoModel.room_id;
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (!TextUtils.equals(str, b == null ? null : b.room_id)) {
                    yYRoomMemberInfoModel.is_open_mic = 0;
                }
            }
            yYRoomMemberInfoModel.position_status = yYRoomMemberInfoModel.seat_type;
            yYRoomMemberInfoModel.chat_anchor = yYRoomMemberInfoModel.role;
            if (TextUtils.equals(yYRoomMemberInfoModel.chat_anchor, "1")) {
                String str2 = yYRoomMemberInfoModel.room_id;
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                if (TextUtils.equals(str2, b2 == null ? null : b2.room_id)) {
                    a(yYRoomMemberInfoModel);
                } else {
                    b(yYRoomMemberInfoModel);
                }
            }
        }
        MemberAdapter memberAdapter = this.d;
        if (memberAdapter == null) {
            return;
        }
        memberAdapter.setNewData(yYMsgPkRoomNewExtra.seats);
    }

    private final void h() {
        if (getVisibility() != 0) {
            setVisibility(0);
            BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
            RecyclerView recyclerView = baseYYStudioFragment == null ? null : baseYYStudioFragment.j;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
        }
    }

    private final void i() {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel != null) {
            yYRoomModel.room_pk_mute_all = false;
        }
        YYRoomModel yYRoomModel2 = this.b;
        if (yYRoomModel2 != null) {
            yYRoomModel2.pk_has_connected = false;
        }
        MemberAdapter memberAdapter = this.d;
        if (memberAdapter != null) {
            memberAdapter.setNewData(null);
        }
        setEmptyRankList(this.e);
        setEmptyRankList(this.f);
        YYRoomInfoManager.e().f("");
        YYRoomInfoManager.e().e("");
        AudioChannelManager.j().l();
        if (YYRoomInfoManager.e().y()) {
            TRTCSEIMsg tRTCSEIMsg = new TRTCSEIMsg();
            tRTCSEIMsg.cmdID = 2;
            AudioChannelManager.j().a(tRTCSEIMsg);
        }
        j();
    }

    private final void j() {
        Logger.e("YYPKBoardViewNew", "reset");
        setProgress(50);
        this.f18353a.C.setText("0");
        this.f18353a.x.setText("0");
        this.f18353a.g.setVisibility(8);
        this.f18353a.j.setVisibility(8);
    }

    private final void setEmptyRankList(RankAdapter rankAdapter) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < 4) {
            i++;
            YYSeatUserModel yYSeatUserModel = new YYSeatUserModel();
            yYSeatUserModel.uid = null;
            arrayList.add(yYSeatUserModel);
        }
        if (rankAdapter == null) {
            return;
        }
        rankAdapter.setNewData(arrayList);
    }

    private final void setProgress(final int i) {
        this.f18353a.b.post(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPKBoardViewNew$VumXmXehXexfkBjGTk8iV4w42vM
            @Override // java.lang.Runnable
            public final void run() {
                YYPKBoardViewNew.a(YYPKBoardViewNew.this, i);
            }
        });
    }

    public final void a(int i, String str, String str2, YYImModel yYImModel) {
        MemberAdapter memberAdapter = this.d;
        View viewByPosition = memberAdapter == null ? null : memberAdapter.getViewByPosition(i, R.id.ll_member_view);
        if (viewByPosition != null && (viewByPosition instanceof YYMemberRoomPkView)) {
            YYMemberRoomPkView yYMemberRoomPkView = (YYMemberRoomPkView) viewByPosition;
            BaseYYStudioFragment baseYYStudioFragment = this.f18354c;
            yYMemberRoomPkView.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), str, str2, yYImModel);
        }
    }

    public final void a(BaseYYStudioFragment frag) {
        Intrinsics.e(frag, "frag");
        this.f18354c = frag;
        a(0.0f, 0.0f);
        e();
        a();
        b(frag);
        if (YYRoomInfoManager.e().y()) {
            this.f18353a.o.setVisibility(0);
            this.f18353a.q.setVisibility(0);
            return;
        }
        this.f18353a.o.setVisibility(8);
        this.f18353a.q.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.Set<java.lang.String> r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYPKBoardViewNew.a(java.util.Set, boolean):void");
    }

    public final Set<String> getSeats() {
        return this.j;
    }

    public final Set<String> getSeatsPk() {
        return this.k;
    }

    public final void setSeats(Set<String> set) {
        Intrinsics.e(set, "<set-?>");
        this.j = set;
    }

    public final void setSeatsPk(Set<String> set) {
        Intrinsics.e(set, "<set-?>");
        this.k = set;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        YYRoomModel yYRoomModel;
        super.setVisibility(i);
        if (i == 0 || (yYRoomModel = this.b) == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }
}
