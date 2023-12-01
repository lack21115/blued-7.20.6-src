package com.blued.android.module.live_china.fragment;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.SpellChecker;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding;
import com.blued.android.module.live_china.fitem.FitemConstellationTab;
import com.blued.android.module.live_china.fitem.FitemConstellationUser;
import com.blued.android.module.live_china.fragment.LiveConstellationHonourDialogFragment;
import com.blued.android.module.live_china.fragment.LiveConstellationInfoDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.ConstellationHttpDataModel;
import com.blued.android.module.live_china.model.ConstellationItemDataModel;
import com.blued.android.module.live_china.model.ConstellationTabDataModel;
import com.blued.android.module.live_china.model.GiftConstellationBuyInfoModel;
import com.blued.android.module.live_china.model.LiveBunchLightModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveImgModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationDialogFragment.class */
public final class LiveConstellationDialogFragment extends BaseDialogFragment implements OnClickCallback {
    public static final Companion a = new Companion(null);
    private boolean c;
    private ConstellationHttpDataModel d;
    private FreedomAdapter f;
    private LinearLayoutManager g;
    private FitemConstellationTab h;
    private boolean i;
    private int k;
    private FreedomAdapter m;
    private ValueAnimator o;
    private TextView s;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveConstellationBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveConstellationBinding invoke() {
            return DialogLiveConstellationBinding.a(LayoutInflater.from(LiveConstellationDialogFragment.this.requireContext()));
        }
    });
    private final ArrayList<FitemConstellationTab> e = new ArrayList<>();
    private int j = -2;
    private final ArrayList<FitemConstellationUser> l = new ArrayList<>();
    private int n = 1;
    private final DecelerateInterpolator p = new DecelerateInterpolator(1.5f);
    private final OvershootInterpolator q = new OvershootInterpolator(1.4f);
    private final AccelerateInterpolator r = new AccelerateInterpolator(1.5f);
    private final String t = "https://web.bldimg.com/image-manager/1688543781_46784.webp";
    private final Observer<Integer> u = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$D6lOdlSxKCTm1255FGLPeyeETa4
        public final void onChanged(Object obj) {
            LiveConstellationDialogFragment.a(LiveConstellationDialogFragment.this, (Integer) obj);
        }
    };
    private final Observer<Pair<?, ?>> v = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$qjGzKuiwxiccQs2tHtYqtAomKdw
        public final void onChanged(Object obj) {
            LiveConstellationDialogFragment.a(LiveConstellationDialogFragment.this, (Pair) obj);
        }
    };

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveConstellationDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveConstellationDialogFragment liveConstellationDialogFragment = new LiveConstellationDialogFragment();
            liveConstellationDialogFragment.show(manager, LiveConstellationDialogFragment.class.getSimpleName());
            return liveConstellationDialogFragment;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$response$1] */
    private final LiveConstellationDialogFragment$response$1 a(final LiveGiftModel liveGiftModel) {
        final ActivityFragmentActive a2 = a();
        return new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$response$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                int i;
                LiveZanExtraModel liveZanExtraModel;
                if (bluedEntity != null && (liveZanExtraModel = bluedEntity.extra) != null) {
                    LiveGiftModel liveGiftModel2 = liveGiftModel;
                    PayRemaining singleData = bluedEntity.getSingleData();
                    if (singleData != null) {
                        liveGiftModel2.animation = singleData.animation;
                    }
                    List<LiveImgModel> list = liveZanExtraModel.lantern_image;
                    if (!(list == null || list.isEmpty())) {
                        LiveBunchLightModel liveBunchLightModel = new LiveBunchLightModel();
                        ArrayList<String> arrayList = new ArrayList<>();
                        List<LiveImgModel> list2 = liveZanExtraModel.lantern_image;
                        Intrinsics.c(list2, "it.lantern_image");
                        for (LiveImgModel liveImgModel : list2) {
                            arrayList.add(liveImgModel.getImg());
                        }
                        liveBunchLightModel.setImage(arrayList);
                        liveBunchLightModel.setPlay_times(liveZanExtraModel.lantern_play_times);
                        liveGiftModel2.bunchLightModel = liveBunchLightModel;
                    }
                    if (!TextUtils.isEmpty(liveZanExtraModel.random_name)) {
                        liveGiftModel2.random_name = liveZanExtraModel.random_name;
                        liveGiftModel2.random_static = liveZanExtraModel.random_static;
                        if (!TextUtils.isEmpty(liveZanExtraModel.random_mp4)) {
                            liveGiftModel2.images_gif = "";
                            liveGiftModel2.images_apng2 = "";
                            liveGiftModel2.images_mp4 = liveZanExtraModel.random_mp4;
                        }
                    }
                    if (!liveZanExtraModel.behalf_bind_status) {
                        LiveMsgSendManager.a().a(liveGiftModel2);
                    }
                }
                LiveProtos.Event event = LiveProtos.Event.LIVE_STAR_TAB_ONE_TOP_SUCCESS;
                String e = LiveRoomManager.a().e();
                String g = LiveRoomManager.a().g();
                i = LiveConstellationDialogFragment.this.j;
                EventTrackLive.b(event, e, g, String.valueOf(i));
            }
        };
    }

    private final void a(int i) {
        a(i, false);
    }

    private final void a(final int i, int i2) {
        ConstellationHttpDataModel constellationHttpDataModel;
        if (this.j == i2 && (constellationHttpDataModel = this.d) != null) {
            Intrinsics.a(constellationHttpDataModel);
            if (constellationHttpDataModel.getSeason() == i) {
                return;
            }
        }
        d().A.b();
        String valueOf = i < 0 ? "" : String.valueOf(i);
        String valueOf2 = i2 >= 0 ? String.valueOf(i2) : "";
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.h(valueOf, valueOf2, new BluedUIHttpResponse<BluedEntity<ConstellationItemDataModel, ConstellationItemDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$getDataToSpokesman$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i3, String str) {
                DialogLiveConstellationBinding d;
                DialogLiveConstellationBinding d2;
                DialogLiveConstellationBinding d3;
                DialogLiveConstellationBinding d4;
                DialogLiveConstellationBinding d5;
                d = LiveConstellationDialogFragment.this.d();
                d.L.setText(LiveConstellationDialogFragment.this.getString(R.string.live_constellation_empty));
                d2 = LiveConstellationDialogFragment.this.d();
                if (d2.g.getVisibility() != 8) {
                    d5 = LiveConstellationDialogFragment.this.d();
                    View view = d5.g;
                    Intrinsics.c(view, "vb.groupTable");
                    BluedViewExKt.a(view);
                }
                d3 = LiveConstellationDialogFragment.this.d();
                if (d3.e.getVisibility() != 0) {
                    d4 = LiveConstellationDialogFragment.this.d();
                    View view2 = d4.e;
                    Intrinsics.c(view2, "vb.groupEmpty");
                    BluedViewExKt.b(view2);
                }
                return super.onUIFailure(i3, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveConstellationBinding d;
                super.onUIFinish();
                d = LiveConstellationDialogFragment.this.d();
                d.A.c();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<ConstellationItemDataModel, ConstellationItemDataModel> entity) {
                ConstellationHttpDataModel constellationHttpDataModel2;
                Intrinsics.e(entity, "entity");
                constellationHttpDataModel2 = LiveConstellationDialogFragment.this.d;
                if (constellationHttpDataModel2 != null) {
                    constellationHttpDataModel2.setSeason(i);
                }
                LiveConstellationDialogFragment.this.a(entity.data, entity.extra);
            }
        }, a());
    }

    private final void a(final int i, boolean z) {
        if (z || this.j != i) {
            d().A.b();
            String valueOf = i < 0 ? "" : String.valueOf(i);
            final ActivityFragmentActive a2 = a();
            LiveRoomHttpUtils.w(valueOf, new BluedUIHttpResponse<BluedEntity<ConstellationHttpDataModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$getDataToConstellation$1
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str) {
                    DialogLiveConstellationBinding d;
                    DialogLiveConstellationBinding d2;
                    DialogLiveConstellationBinding d3;
                    DialogLiveConstellationBinding d4;
                    DialogLiveConstellationBinding d5;
                    d = LiveConstellationDialogFragment.this.d();
                    d.L.setText(LiveConstellationDialogFragment.this.getString(R.string.live_constellation_empty));
                    d2 = LiveConstellationDialogFragment.this.d();
                    if (d2.g.getVisibility() != 8) {
                        d5 = LiveConstellationDialogFragment.this.d();
                        View view = d5.g;
                        Intrinsics.c(view, "vb.groupTable");
                        BluedViewExKt.a(view);
                    }
                    d3 = LiveConstellationDialogFragment.this.d();
                    if (d3.e.getVisibility() != 0) {
                        d4 = LiveConstellationDialogFragment.this.d();
                        View view2 = d4.e;
                        Intrinsics.c(view2, "vb.groupEmpty");
                        BluedViewExKt.b(view2);
                    }
                    return super.onUIFailure(i2, str);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    DialogLiveConstellationBinding d;
                    super.onUIFinish();
                    d = LiveConstellationDialogFragment.this.d();
                    d.A.c();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<ConstellationHttpDataModel, ?> entity) {
                    Intrinsics.e(entity, "entity");
                    ConstellationHttpDataModel singleData = entity.getSingleData();
                    if (singleData == null) {
                        return;
                    }
                    LiveConstellationDialogFragment liveConstellationDialogFragment = LiveConstellationDialogFragment.this;
                    int i2 = i;
                    int i3 = i2;
                    if (i2 == -1) {
                        i3 = singleData.getConstellation_id();
                    }
                    liveConstellationDialogFragment.j = i3;
                    liveConstellationDialogFragment.a(singleData);
                }
            }, a());
        }
    }

    private final void a(long j, long j2) {
        if (j == LiveRoomManager.a().f() && j2 == LiveRoomInfo.a().g()) {
            a(this.j, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
    }

    private final void a(TextView textView, boolean z) {
        if (this.d == null || textView.getTag() == null || !(textView.getTag() instanceof Integer)) {
            return;
        }
        Object tag = textView.getTag();
        TextView textView2 = this.s;
        if (Intrinsics.a(tag, textView2 == null ? null : textView2.getTag())) {
            return;
        }
        TextView textView3 = this.s;
        if (textView3 != null) {
            textView3.setTypeface(null, 0);
        }
        textView.setTypeface(null, 1);
        this.s = textView;
        d().Z.animate().translationX(textView.getLeft()).setDuration(500L).setInterpolator(this.q).start();
        if (z) {
            Object tag2 = textView.getTag();
            if (tag2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            a(((Integer) tag2).intValue(), this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        this$0.d().y.getLayoutParams().height = intValue;
        this$0.d().y.setLayoutParams(this$0.d().y.getLayoutParams());
        this$0.n = intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, Pair pair) {
        Intrinsics.e(this$0, "this$0");
        Object obj = pair.first;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) obj).longValue();
        Object obj2 = pair.second;
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        this$0.a(longValue, ((Long) obj2).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        TextView textView = this$0.d().T;
        Intrinsics.c(textView, "vb.tvStage1");
        this$0.a(textView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, ConstellationHttpDataModel data, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        LiveConstellationInfoDialogFragment.Companion companion = LiveConstellationInfoDialogFragment.a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, data.getLink());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, GiftConstellationBuyInfoModel data, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(data, "$data");
        this$0.a(data.getGoods_id(), Integer.parseInt(data.getCount()), data.getGoods_name(), data.getImage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.d().A.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ConstellationHttpDataModel constellationHttpDataModel) {
        this.d = constellationHttpDataModel;
        b(constellationHttpDataModel);
        c(constellationHttpDataModel);
        d(constellationHttpDataModel);
        a(constellationHttpDataModel.getList());
        a(constellationHttpDataModel.getCur_anchor());
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_TAB_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(constellationHttpDataModel.getConstellation_id()));
    }

    private final void a(ConstellationItemDataModel constellationItemDataModel) {
        String string;
        ConstellationHttpDataModel constellationHttpDataModel = this.d;
        if (constellationHttpDataModel != null) {
            Intrinsics.a(constellationHttpDataModel);
            if (constellationHttpDataModel.getStatus() == 1) {
                if (constellationItemDataModel == null || constellationItemDataModel.getAnchor() < 0) {
                    a(false);
                    return;
                }
                String anchor_avatar = constellationItemDataModel.getAnchor_avatar();
                if (anchor_avatar == null || anchor_avatar.length() == 0) {
                    constellationItemDataModel.setAnchor_avatar(this.t);
                }
                String anchor_name = constellationItemDataModel.getAnchor_name();
                if (anchor_name == null || anchor_name.length() == 0) {
                    String string2 = getString(R.string.live_constellation_empty);
                    Intrinsics.c(string2, "getString(R.string.live_constellation_empty)");
                    constellationItemDataModel.setAnchor_name(string2);
                }
                String avatar = constellationItemDataModel.getAvatar();
                if (avatar == null || avatar.length() == 0) {
                    constellationItemDataModel.setAvatar(this.t);
                }
                String name = constellationItemDataModel.getName();
                if (name == null || name.length() == 0) {
                    String string3 = getString(R.string.live_constellation_empty);
                    Intrinsics.c(string3, "getString(R.string.live_constellation_empty)");
                    constellationItemDataModel.setName(string3);
                }
                d().S.setText(constellationItemDataModel.getRank() < 0 ? "50+" : String.valueOf(constellationItemDataModel.getRank()));
                ImageLoader.a(a(), constellationItemDataModel.getAnchor_avatar()).a(0.5f, -1).c(300).a(d().v);
                d().R.setText(constellationItemDataModel.getAnchor_name());
                d().Q.setVisibility(constellationItemDataModel.is_king() == 1 ? 0 : 8);
                ImageLoader.a(a(), constellationItemDataModel.getAvatar()).a(0.5f, -1).c(300).a(d().m);
                d().J.setText(LiveCloakingUtil.a(constellationItemDataModel.getName(), constellationItemDataModel.is_hide()));
                TextView textView = d().I;
                int i = 8;
                if (constellationItemDataModel.is_king() == 1) {
                    i = 0;
                }
                textView.setVisibility(i);
                d().K.setText(String.valueOf(constellationItemDataModel.getScore()));
                if (constellationItemDataModel.getRanking() == 1) {
                    d().H.setGravity(constellationItemDataModel.getBonus() <= 0 ? 1 : 5);
                    TextView textView2 = d().H;
                    if (constellationItemDataModel.getBonus() <= 0) {
                        string = getResources().getString(R.string.live_constellation_not_award_bean);
                    } else if (constellationItemDataModel.getKing_percent() > 0.0f) {
                        Resources resources = getResources();
                        int i2 = R.string.live_constellation_award_bean_extra;
                        int bonus = constellationItemDataModel.getBonus();
                        StringBuilder sb = new StringBuilder();
                        sb.append(constellationItemDataModel.getPercent());
                        sb.append('%');
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(constellationItemDataModel.getKing_percent());
                        sb3.append('%');
                        string = resources.getString(i2, String.valueOf(bonus), sb2, sb3.toString());
                    } else {
                        Resources resources2 = getResources();
                        int i3 = R.string.live_constellation_award_bean;
                        int bonus2 = constellationItemDataModel.getBonus();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(constellationItemDataModel.getPercent());
                        sb4.append('%');
                        string = resources2.getString(i3, String.valueOf(bonus2), sb4.toString());
                    }
                    textView2.setText(string);
                    TextView textView3 = d().H;
                    Intrinsics.c(textView3, "vb.tvAwardInfo");
                    BluedViewExKt.b(textView3);
                } else {
                    TextView textView4 = d().H;
                    Intrinsics.c(textView4, "vb.tvAwardInfo");
                    BluedViewExKt.a(textView4);
                }
                a(true);
                return;
            }
        }
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final GiftConstellationBuyInfoModel giftConstellationBuyInfoModel) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getString(R.string.live_constellation_onekey_summit_dialog_title, new Object[]{giftConstellationBuyInfoModel.getBeans(), giftConstellationBuyInfoModel.getCount(), giftConstellationBuyInfoModel.getGoods_name()});
        Intrinsics.c(string, "getString(\n             ….goods_name\n            )");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        Intrinsics.c(format, "format(format, *args)");
        CommonAlertDialog.a(requireContext(), format, (String) null, "确定", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$9CiraARguMJk2nUmKtUACdwVVGA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveConstellationDialogFragment.a(LiveConstellationDialogFragment.this, giftConstellationBuyInfoModel, dialogInterface, i);
            }
        }, "取消", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$-BcGdealaoThDxKexdmMPedrCrE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveConstellationDialogFragment.a(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    private final void a(String str, int i, String str2, String str3) {
        d().A.b();
        String g = LiveRoomManager.a().g();
        String e = LiveRoomManager.a().e();
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.goods_id = str;
        liveGiftModel.name = str2;
        liveGiftModel.count = i;
        liveGiftModel.hit_count = i;
        liveGiftModel.displayCount = i;
        liveGiftModel.images_static = str3;
        LiveRoomHttpUtils.a(g, e, liveGiftModel, "", "", LiveRoomPreferences.b(""), false, i, false, null, null, 0, a(liveGiftModel), a());
    }

    private final void a(ArrayList<ConstellationItemDataModel> arrayList) {
        ArrayList<ConstellationItemDataModel> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$SPSjn2qQuaHxtHNWur794iLxRHs
                @Override // java.lang.Runnable
                public final void run() {
                    LiveConstellationDialogFragment.i(LiveConstellationDialogFragment.this);
                }
            });
            return;
        }
        if (d().e.getVisibility() != 8) {
            View view = d().e;
            Intrinsics.c(view, "vb.groupEmpty");
            BluedViewExKt.a(view);
        }
        if (d().g.getVisibility() != 0) {
            View view2 = d().g;
            Intrinsics.c(view2, "vb.groupTable");
            BluedViewExKt.b(view2);
        }
        this.l.clear();
        if (arrayList != null) {
            for (ConstellationItemDataModel constellationItemDataModel : arrayList) {
                this.l.add(new FitemConstellationUser(constellationItemDataModel));
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<ConstellationItemDataModel> list, ConstellationItemDataModel constellationItemDataModel) {
        ArrayList<ConstellationItemDataModel> list2;
        ConstellationHttpDataModel constellationHttpDataModel = this.d;
        if (constellationHttpDataModel == null) {
            return;
        }
        ArrayList<ConstellationItemDataModel> list3 = constellationHttpDataModel.getList();
        if (list3 != null) {
            list3.clear();
        }
        if (constellationHttpDataModel.getList() == null) {
            constellationHttpDataModel.setList(new ArrayList<>());
        }
        if (list != null && (list2 = constellationHttpDataModel.getList()) != null) {
            list2.addAll(list);
        }
        a(constellationHttpDataModel.getList());
        constellationHttpDataModel.setCur_anchor(constellationItemDataModel);
        a(constellationHttpDataModel.getCur_anchor());
    }

    private final void a(boolean z) {
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.n, z ? DensityUtils.a(requireContext(), 70.0f) : 1);
        this.o = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(z ? 400L : 220L);
        }
        ValueAnimator valueAnimator2 = this.o;
        if (valueAnimator2 != null) {
            valueAnimator2.setInterpolator(z ? this.q : this.p);
        }
        ValueAnimator valueAnimator3 = this.o;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$QDDJu-cD8hPn42GZE6gLPTG1tyc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    LiveConstellationDialogFragment.a(LiveConstellationDialogFragment.this, valueAnimator4);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.o;
        if (valueAnimator4 == null) {
            return;
        }
        valueAnimator4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i, boolean z) {
        ConstellationTabDataModel e;
        LinearLayoutManager linearLayoutManager;
        FitemConstellationTab fitemConstellationTab = this.h;
        if (fitemConstellationTab != null) {
            fitemConstellationTab.a(false);
        }
        this.h = null;
        FitemConstellationTab fitemConstellationTab2 = (FitemConstellationTab) CollectionsKt.c((List<? extends Object>) this.e, i);
        if (fitemConstellationTab2 != null) {
            fitemConstellationTab2.a(true);
        }
        if (this.i && (linearLayoutManager = this.g) != null) {
            Intrinsics.a(linearLayoutManager);
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() % this.e.size();
            int g = this.e.get(findFirstVisibleItemPosition).g();
            int i2 = this.k;
            int width = ((i * i2) - ((d().C.getWidth() - this.k) / 2)) - ((findFirstVisibleItemPosition * i2) - g);
            int size = this.e.size() * this.k;
            int i3 = width + size;
            if (Math.abs(i3) >= Math.abs(width)) {
                int i4 = width - size;
                i3 = width;
                if (Math.abs(i4) < Math.abs(width)) {
                    i3 = i4;
                }
            }
            if (Math.abs(i3) > 2) {
                d().C.smoothScrollBy(i3, 0, this.p, (int) SpellChecker.WORD_ITERATOR_INTERVAL);
            }
        }
        if (z && fitemConstellationTab2 != null && (e = fitemConstellationTab2.e()) != null) {
            a(e.getId());
        }
        this.h = fitemConstellationTab2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveConstellationDialogFragment this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveConstellationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        TextView textView = this$0.d().U;
        Intrinsics.c(textView, "vb.tvStage2");
        this$0.a(textView, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x015c, code lost:
        if (r0.getUid() == (-1)) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0264, code lost:
        if (r0.getUid() == (-1)) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x050e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(final com.blued.android.module.live_china.model.ConstellationHttpDataModel r9) {
        /*
            Method dump skipped, instructions count: 1317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment.b(com.blued.android.module.live_china.model.ConstellationHttpDataModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveConstellationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        TextView textView = this$0.d().V;
        Intrinsics.c(textView, "vb.tvStage3");
        this$0.a(textView, true);
    }

    private final void c(ConstellationHttpDataModel constellationHttpDataModel) {
        if (this.e.isEmpty()) {
            ArrayList<ConstellationTabDataModel> all_constellations = constellationHttpDataModel.getAll_constellations();
            if (all_constellations == null || all_constellations.isEmpty()) {
                return;
            }
            ArrayList<ConstellationTabDataModel> all_constellations2 = constellationHttpDataModel.getAll_constellations();
            if (all_constellations2 != null) {
                for (ConstellationTabDataModel constellationTabDataModel : all_constellations2) {
                    this.e.add(new FitemConstellationTab(constellationTabDataModel));
                }
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveConstellationBinding d() {
        return (DialogLiveConstellationBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveConstellationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    private final void d(ConstellationHttpDataModel constellationHttpDataModel) {
        d().X.setText(constellationHttpDataModel.getSpokesman_title());
        d().W.setText(constellationHttpDataModel.getSpokesman_time());
        int season = constellationHttpDataModel.getSeason();
        TextView textView = season != 2 ? season != 3 ? d().T : d().V : d().U;
        Intrinsics.c(textView, "when (data.season) {\n   …vb.tvStage1\n            }");
        a(textView, false);
    }

    private final void e() {
        i();
        this.k = DensityUtils.a(requireContext(), 88.0f);
        d().F.getPaint().setFakeBoldText(true);
        d().N.getPaint().setFakeBoldText(true);
        d().S.getPaint().setFakeBoldText(true);
        d().R.getPaint().setFakeBoldText(true);
        d().J.getPaint().setFakeBoldText(true);
        d().X.getPaint().setFakeBoldText(true);
        d().T.setTag(1);
        d().T.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$I1nslKbPcFIESY8vYR7EKCXKpDw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.a(LiveConstellationDialogFragment.this, view);
            }
        });
        d().U.setTag(2);
        d().U.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$YHunMX3pkIw4yiedf6glRPv063A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.b(LiveConstellationDialogFragment.this, view);
            }
        });
        d().V.setTag(3);
        d().V.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$8vt9gNxJb67Q4dzrtERLdS8Hfd0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.c(LiveConstellationDialogFragment.this, view);
            }
        });
        d().w.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$E5TCqnwNNVYzl8nxsg5Y4WMe8G4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.d(LiveConstellationDialogFragment.this, view);
            }
        });
        d().r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$R8e5QqWlSwzOnP4vw46xhf5MEHc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.e(LiveConstellationDialogFragment.this, view);
            }
        });
        d().G.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$93NAuT15h2h2Z9HrJLjcR-BUEy4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.f(LiveConstellationDialogFragment.this, view);
            }
        });
        d().k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$lOqcgYWXZQ8dzJjM4U2TNEfxxjg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationDialogFragment.g(LiveConstellationDialogFragment.this, view);
            }
        });
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveConstellationDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveConstellationHonourDialogFragment.Companion companion = LiveConstellationHonourDialogFragment.a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager);
    }

    private final void f() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get(LiveEventBusUtil.Y, Integer.TYPE).observe(lifecycleOwner, this.u);
        LiveEventBus.get(LiveEventBusUtil.Z, Pair.class).observe(lifecycleOwner, this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment r5, android.view.View r6) {
        /*
            r0 = r5
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r5
            com.blued.android.module.live_china.model.ConstellationHttpDataModel r0 = r0.d
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L13
            goto L1e
        L13:
            r0 = r6
            java.lang.String r0 = r0.getLink()
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L21
        L1e:
            java.lang.String r0 = ""
            r6 = r0
        L21:
            com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$Companion r0 = com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment.a
            r7 = r0
            r0 = r5
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "childFragmentManager"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r7
            r1 = r8
            r2 = r6
            r3 = r5
            int r3 = r3.j
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment r0 = r0.a(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment.f(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment, android.view.View):void");
    }

    private final void g() {
        LiveEventBus.get(LiveEventBusUtil.Y, Integer.TYPE).removeObserver(this.u);
        LiveEventBus.get(LiveEventBusUtil.Z, Pair.class).removeObserver(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment r5, android.view.View r6) {
        /*
            r0 = r5
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r5
            com.blued.android.module.live_china.model.ConstellationHttpDataModel r0 = r0.d
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L13
            goto L1e
        L13:
            r0 = r6
            java.lang.String r0 = r0.getLink()
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L21
        L1e:
            java.lang.String r0 = ""
            r6 = r0
        L21:
            com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment$Companion r0 = com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment.a
            r7 = r0
            r0 = r5
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "childFragmentManager"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r7
            r1 = r8
            r2 = r6
            r3 = r5
            int r3 = r3.j
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.blued.android.module.live_china.fragment.LiveConstellationAwardDialogFragment r0 = r0.a(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment.g(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment, android.view.View):void");
    }

    private final void h() {
        d().C.addOnScrollListener(new LiveConstellationDialogFragment$initTabListScrollListener$1(this));
    }

    private final void i() {
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_23899.webp").c(300).a(d().s);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_85222.webp").c(300).a(d().r);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688543781_46784.webp").c().c(300).a(d().h);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_81257.webp").c().c(300).a(d().i);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688543781_46784.webp").c(300).a(d().t);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_46381.webp").c(300).a(d().u);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_40227.webp").c(300).a(d().j);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688106136_25323.webp").c(300).a(d().q);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_28699.webp").c(300).a(d().w);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688031072_19388.webp").c(300).a(d().k);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688627396_17038.webp").c(300).a(d().p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (r0.getStatus() == 3) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment r4) {
        /*
            r0 = r4
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            com.blued.android.module.live_china.model.ConstellationHttpDataModel r0 = r0.d
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L43
            r0 = r5
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r5
            int r0 = r0.getStatus()
            if (r0 == 0) goto L2c
            r0 = r4
            com.blued.android.module.live_china.model.ConstellationHttpDataModel r0 = r0.d
            r5 = r0
            r0 = r5
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r5
            int r0 = r0.getStatus()
            r1 = 3
            if (r0 != r1) goto L43
        L2c:
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            android.widget.TextView r0 = r0.L
            r1 = r4
            int r2 = com.blued.android.module.live_china.R.string.live_constellation_data_empty
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L57
        L43:
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            android.widget.TextView r0 = r0.L
            r1 = r4
            int r2 = com.blued.android.module.live_china.R.string.live_constellation_empty
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L57:
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            androidx.constraintlayout.widget.Group r0 = r0.g
            int r0 = r0.getVisibility()
            r1 = 8
            if (r0 == r1) goto L7c
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            androidx.constraintlayout.widget.Group r0 = r0.g
            r5 = r0
            r0 = r5
            java.lang.String r1 = "vb.groupTable"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r5
            android.view.View r0 = (android.view.View) r0
            com.blued.android.module.live_china.view.BluedViewExKt.a(r0)
        L7c:
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            androidx.constraintlayout.widget.Group r0 = r0.e
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L9f
            r0 = r4
            com.blued.android.module.live_china.databinding.DialogLiveConstellationBinding r0 = r0.d()
            androidx.constraintlayout.widget.Group r0 = r0.e
            r4 = r0
            r0 = r4
            java.lang.String r1 = "vb.groupEmpty"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r4
            android.view.View r0 = (android.view.View) r0
            com.blued.android.module.live_china.view.BluedViewExKt.b(r0)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment.i(com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment):void");
    }

    private final void j() {
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_TAB_ONE_TOP_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(this.j));
        d().A.b();
        String g = LiveRoomManager.a().g();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.c(g, 1, new BluedUIHttpResponse<BluedEntityA<GiftConstellationBuyInfoModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment$getDataToOnekeySummit$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftConstellationBuyInfoModel> bluedEntityA) {
                GiftConstellationBuyInfoModel singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                LiveConstellationDialogFragment.this.a(singleData);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogLiveConstellationBinding d;
                super.onUIFinish();
                d = LiveConstellationDialogFragment.this.d();
                d.A.c();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LiveConstellationDialogFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.e(this$0, "this$0");
        DialogLiveConstellationBinding d = this$0.d();
        ViewPropertyAnimator viewPropertyAnimator = null;
        if (d != null && (recyclerView = d.C) != null) {
            viewPropertyAnimator = recyclerView.animate();
        }
        viewPropertyAnimator.alpha(1.0f).setDuration(300L).setStartDelay(200L).start();
        int size = this$0.e.size();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= size) {
                return;
            }
            FitemConstellationTab fitemConstellationTab = (FitemConstellationTab) CollectionsKt.c((List<? extends Object>) this$0.e, i2);
            if (fitemConstellationTab != null && fitemConstellationTab.h() == this$0.j) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$hQMqxipdrlaw5OwNEGprMf8CQnY
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveConstellationDialogFragment.b(LiveConstellationDialogFragment.this, i2);
                    }
                }, 450L);
                return;
            }
            i = i2 + 1;
        }
    }

    private final void k() {
        RecyclerView recyclerView;
        if (this.f == null) {
            DialogLiveConstellationBinding d = d();
            RecyclerView recyclerView2 = d == null ? null : d.C;
            if (recyclerView2 != null) {
                recyclerView2.setAlpha(0.05f);
            }
            this.f = new FreedomAdapter(requireContext(), a(), this.e, this);
            boolean z = false;
            this.g = new LinearLayoutManager(requireContext(), 0, false);
            if (this.e.size() * this.k > d().B.getWidth() + (this.k * 2.5f)) {
                z = true;
            }
            this.i = z;
            FreedomAdapter freedomAdapter = this.f;
            if (freedomAdapter != null) {
                freedomAdapter.c = z;
            }
            DialogLiveConstellationBinding d2 = d();
            RecyclerView recyclerView3 = d2 == null ? null : d2.C;
            if (recyclerView3 != null) {
                recyclerView3.setLayoutManager(this.g);
            }
            DialogLiveConstellationBinding d3 = d();
            RecyclerView recyclerView4 = d3 == null ? null : d3.C;
            if (recyclerView4 != null) {
                recyclerView4.setItemAnimator(new DefaultItemAnimator());
            }
            DialogLiveConstellationBinding d4 = d();
            RecyclerView recyclerView5 = d4 == null ? null : d4.C;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(this.f);
            }
            View view = d().C;
            Intrinsics.c(view, "vb.rvTabList");
            BluedViewExKt.b(view);
            if (this.i) {
                d().C.scrollToPosition(1073741823);
            }
            DialogLiveConstellationBinding d5 = d();
            if (d5 == null || (recyclerView = d5.C) == null) {
                return;
            }
            recyclerView.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationDialogFragment$lxtsBbXnBcjfOQI1lwgFLTwojfQ
                @Override // java.lang.Runnable
                public final void run() {
                    LiveConstellationDialogFragment.j(LiveConstellationDialogFragment.this);
                }
            });
        }
    }

    private final void l() {
        FreedomAdapter freedomAdapter = this.m;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.m = new FreedomAdapter(requireContext(), a(), this.l);
        DialogLiveConstellationBinding d = d();
        RecyclerView recyclerView = d == null ? null : d.D;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        }
        DialogLiveConstellationBinding d2 = d();
        RecyclerView recyclerView2 = d2 == null ? null : d2.D;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        DialogLiveConstellationBinding d3 = d();
        RecyclerView recyclerView3 = d3 == null ? null : d3.D;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.m);
        }
        View view = d().D;
        Intrinsics.c(view, "vb.rvUserList");
        BluedViewExKt.b(view);
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        b(i, true);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(requireContext(), 623.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
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

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        g();
        super.onDestroy();
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        f();
        e();
        a(-1);
    }
}
