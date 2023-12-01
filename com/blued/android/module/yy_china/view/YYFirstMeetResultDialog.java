package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.svgaplayer.SVGADynamicEntity;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyFirstMeetSuccesBinding;
import com.blued.android.module.yy_china.databinding.ItemYyFirstMeetItemBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYFirstMeetGiftsListItemMode;
import com.blued.android.module.yy_china.model.YYFirstMeetImMessMode;
import com.blued.android.module.yy_china.model.YYFirstUserInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYCommonStringUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYFirstMeetResultDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFirstMeetResultDialog.class */
public final class YYFirstMeetResultDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogYyFirstMeetSuccesBinding f18152a;
    private List<YYFirstMeetGiftsListItemMode> b;

    /* renamed from: c  reason: collision with root package name */
    private YYFirstUserInfoMode f18153c;
    private YYFirstMeetImMessMode d;
    private BaseYYStudioFragment e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFirstMeetResultDialog$Ad.class */
    public final class Ad extends BaseMultiItemQuickAdapter<YYFirstMeetGiftsListItemMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYFirstMeetResultDialog f18154a;
        private final BaseFullScreenDialog b;

        /* renamed from: c  reason: collision with root package name */
        private BaseYYStudioFragment f18155c;
        private YYFirstUserInfoMode d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(YYFirstMeetResultDialog this$0, BaseFullScreenDialog fra) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fra, "fra");
            this.f18154a = this$0;
            this.b = fra;
            addItemType(0, R.layout.item_yy_first_meet_succes_item);
            addItemType(2, R.layout.item_yy_first_meet_item);
        }

        private final String a(String str) {
            switch (str.hashCode()) {
                case -1783740371:
                    return !str.equals("speech_ripple") ? "" : "发言波纹";
                case -1068284038:
                    return !str.equals("mounts") ? "" : "坐骑";
                case -1067908108:
                    return !str.equals("room_card") ? "" : "房间卡";
                case -1004661078:
                    return !str.equals("personal_profile") ? "" : "资料卡";
                case -682595428:
                    return !str.equals("pendant") ? "" : "头像框";
                case 93494179:
                    return !str.equals("badge") ? "" : "勋章";
                case 110371416:
                    return !str.equals("title") ? "" : "称号";
                case 954925063:
                    return !str.equals("message") ? "" : "聊天气泡";
                case 1717227163:
                    return !str.equals("enter_effects") ? "" : "进场特效";
                case 2031120687:
                    return !str.equals("goods_coupon") ? "" : "礼物";
                default:
                    return "";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(final Ad this$0, YYFirstMeetGiftsListItemMode item, View view) {
            String str;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            final ActivityFragmentActive a2 = this$0.b.a();
            BluedUIHttpResponse<BluedEntityA<YYUserInfo>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(a2) { // from class: com.blued.android.module.yy_china.view.YYFirstMeetResultDialog$Ad$bindAll$2$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYUserInfo> user) {
                    Intrinsics.e(user, "user");
                    YYUserInfo singleData = user.getSingleData();
                    if (singleData == null) {
                        return;
                    }
                    YYFirstMeetResultDialog.Ad ad = YYFirstMeetResultDialog.Ad.this;
                    YYMedalListDialog yYMedalListDialog = new YYMedalListDialog();
                    BaseYYStudioFragment b = ad.b();
                    Intrinsics.a(b);
                    yYMedalListDialog.a(singleData, b);
                    FragmentManager childFragmentManager = ad.a().getChildFragmentManager();
                    Intrinsics.c(childFragmentManager, "fra.childFragmentManager");
                    yYMedalListDialog.show(childFragmentManager, "YYMedalListDialog");
                }
            };
            YYRoomModel b = YYRoomInfoManager.e().b();
            String str2 = "";
            if (b != null && (str = b.room_id) != null) {
                str2 = str;
            }
            YYRoomHttpUtils.a(bluedUIHttpResponse, str2, YYRoomInfoManager.e().k(), this$0.b.a());
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 == null) {
                return;
            }
            EventTrackYY.c(ChatRoomProtos.Event.YY_FIRST_MEET_SUCCESS_POP_MEDAL_GO_CLICK, b2.room_id, b2.uid, item.getGift_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ad this$0, YYFirstMeetGiftsListItemMode item, YYFirstMeetResultDialog this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$1, "this$1");
            BaseYYStudioFragment baseYYStudioFragment = this$0.f18155c;
            if (baseYYStudioFragment != null) {
                baseYYStudioFragment.a(true, "", item.getGift_id(), "");
            }
            this$1.dismissAllowingStateLoss();
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            EventTrackYY.c(ChatRoomProtos.Event.YY_FIRST_MEET_SUCCESS_POP_GIFT_GO_CLICK, b.room_id, b.uid, item.getGift_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Ad this$0, YYFirstMeetGiftsListItemMode item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
            Context context = this$0.b.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(YYRoomInfoManager.e().c(6));
            sb.append("?room_id=");
            YYRoomModel b = YYRoomInfoManager.e().b();
            sb.append((Object) (b == null ? null : b.room_id));
            String sb2 = sb.toString();
            String str = sb2;
            if (sb2 == null) {
                str = "";
            }
            c2.a(context, str, 0, true);
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 == null) {
                return;
            }
            EventTrackYY.c(ChatRoomProtos.Event.YY_FIRST_MEET_SUCCESS_POP_FRAME_GO_CLICK, b2.room_id, b2.uid, item.getGift_id());
        }

        private final void b(BaseViewHolder baseViewHolder, YYFirstMeetGiftsListItemMode yYFirstMeetGiftsListItemMode) {
            String avatar;
            ItemYyFirstMeetItemBinding a2 = ItemYyFirstMeetItemBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.b.setText("感谢你送我礼物，完成和我的“第一次”遇见");
            BaseFullScreenDialog baseFullScreenDialog = this.b;
            ActivityFragmentActive a3 = baseFullScreenDialog == null ? null : baseFullScreenDialog.a();
            YYFirstUserInfoMode yYFirstUserInfoMode = this.d;
            String str = "";
            if (yYFirstUserInfoMode != null && (avatar = yYFirstUserInfoMode.getAvatar()) != null) {
                str = avatar;
            }
            ImageLoader.a(a3, str).c().a(a2.f16714a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x00aa, code lost:
            if (r0 == null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00f3, code lost:
            if (r0 == null) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void c(com.chad.library.adapter.base.BaseViewHolder r8, final com.blued.android.module.yy_china.model.YYFirstMeetGiftsListItemMode r9) {
            /*
                Method dump skipped, instructions count: 475
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.view.YYFirstMeetResultDialog.Ad.c(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.YYFirstMeetGiftsListItemMode):void");
        }

        public final BaseFullScreenDialog a() {
            return this.b;
        }

        public final void a(BaseYYStudioFragment baseYYStudioFragment) {
            this.f18155c = baseYYStudioFragment;
        }

        public final void a(YYFirstUserInfoMode yYFirstUserInfoMode) {
            this.d = yYFirstUserInfoMode;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYFirstMeetGiftsListItemMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                c(helper, item);
            } else if (itemType == 2) {
                b(helper, item);
            }
        }

        public final BaseYYStudioFragment b() {
            return this.f18155c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFirstMeetResultDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogYyFirstMeetSuccesBinding g() {
        DialogYyFirstMeetSuccesBinding dialogYyFirstMeetSuccesBinding = this.f18152a;
        Intrinsics.a(dialogYyFirstMeetSuccesBinding);
        return dialogYyFirstMeetSuccesBinding;
    }

    private final void h() {
        g().d.setLayoutManager(new LinearLayoutManager(getContext()));
        Ad ad = new Ad(this, this);
        ad.a(this.f18153c);
        ad.a(this.e);
        g().d.setAdapter(ad);
        g().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYFirstMeetResultDialog$IgFklUcr-FfdrSGLR5-mXlDqyIE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYFirstMeetResultDialog.a(YYFirstMeetResultDialog.this, view);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new YYFirstMeetGiftsListItemMode(",", "", "", "", "", "", 2));
        List<YYFirstMeetGiftsListItemMode> list = this.b;
        ArrayList arrayList2 = list;
        if (list == null) {
            arrayList2 = new ArrayList();
        }
        arrayList.addAll(arrayList2);
        ad.setNewData(arrayList);
        i();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_FIRST_MEET_SUCCESS_POP_SHOW, b.room_id, b.uid);
    }

    private final void i() {
        String source_avatar;
        ActivityFragmentActive a2 = a();
        YYFirstMeetImMessMode yYFirstMeetImMessMode = this.d;
        String str = "";
        if (yYFirstMeetImMessMode != null && (source_avatar = yYFirstMeetImMessMode.getSource_avatar()) != null) {
            str = source_avatar;
        }
        ImageLoader.a(a2, str).c().a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYFirstMeetResultDialog$showAni$1
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                String target_avatar;
                Intrinsics.e(resource, "resource");
                final Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                ActivityFragmentActive a3 = YYFirstMeetResultDialog.this.a();
                YYFirstMeetImMessMode f = YYFirstMeetResultDialog.this.f();
                String str2 = "";
                if (f != null && (target_avatar = f.getTarget_avatar()) != null) {
                    str2 = target_avatar;
                }
                ImageWrapper c2 = ImageLoader.a(a3, str2).c();
                final YYFirstMeetResultDialog yYFirstMeetResultDialog = YYFirstMeetResultDialog.this;
                c2.a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.YYFirstMeetResultDialog$showAni$1$onResourceReady$1
                    @Override // com.bumptech.glide.request.target.Target
                    /* renamed from: a */
                    public void onResourceReady(Drawable resource2, Transition<? super Drawable> transition2) {
                        DialogYyFirstMeetSuccesBinding g;
                        String source_name;
                        Intrinsics.e(resource2, "resource");
                        Bitmap traBit = ((BitmapDrawable) resource2).getBitmap();
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        Bitmap sourceBit = Bitmap.this;
                        Intrinsics.c(sourceBit, "sourceBit");
                        sVGADynamicEntity.a(sourceBit, "headleft");
                        Intrinsics.c(traBit, "traBit");
                        sVGADynamicEntity.a(traBit, "headrightt");
                        TextPaint textPaint = new TextPaint();
                        textPaint.setColor(ContextCompat.getColor(AppInfo.d(), R.color.white));
                        textPaint.setTextSize(24.0f);
                        StringBuilder sb = new StringBuilder();
                        sb.append("恭喜");
                        YYFirstMeetImMessMode f2 = yYFirstMeetResultDialog.f();
                        String str3 = "";
                        if (f2 != null && (source_name = f2.getSource_name()) != null) {
                            str3 = source_name;
                        }
                        sb.append((Object) YYCommonStringUtils.a(str3, textPaint, AppInfo.d().getResources().getDimensionPixelSize(R.dimen.dp_60)));
                        sb.append("和房主完成第一次遇见");
                        sVGADynamicEntity.a(sb.toString(), textPaint, Layout.Alignment.ALIGN_CENTER, "mainword");
                        TextPaint textPaint2 = new TextPaint();
                        textPaint2.setColor(ContextCompat.getColor(AppInfo.d(), R.color.white));
                        textPaint2.setTextSize(18.0f);
                        sVGADynamicEntity.a("免费获得1弯豆礼物券等丰厚大礼~", textPaint2, Layout.Alignment.ALIGN_CENTER, "secondword");
                        SVGAPlayer.Builder a4 = new SVGAPlayer.Builder("https://web.bldimg.com/cblued/static/headrightt2.1guuig3laoq12d.svga").a(SVGAImageView.FillMode.Clear).a((Integer) 1);
                        g = yYFirstMeetResultDialog.g();
                        SVGAImageView sVGAImageView = g.e;
                        Intrinsics.c(sVGAImageView, "bind.svga");
                        a4.a(sVGAImageView, sVGADynamicEntity);
                    }
                });
            }
        });
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.e = baseYYStudioFragment;
    }

    public final void a(YYFirstMeetImMessMode yYFirstMeetImMessMode) {
        this.d = yYFirstMeetImMessMode;
    }

    public final void a(YYFirstUserInfoMode yYFirstUserInfoMode) {
        this.f18153c = yYFirstUserInfoMode;
    }

    public final void a(List<YYFirstMeetGiftsListItemMode> list) {
        this.b = list;
    }

    public final YYFirstMeetImMessMode f() {
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_first_meet_succes, viewGroup, true);
        this.f18152a = DialogYyFirstMeetSuccesBinding.a(inflate);
        h();
        return inflate;
    }
}
