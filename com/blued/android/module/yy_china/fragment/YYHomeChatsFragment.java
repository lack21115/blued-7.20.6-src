package com.blued.android.module.yy_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.BluedMarqueeTextView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGADrawable;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRoomChatsPagerAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyHomeChatsBinding;
import com.blued.android.module.yy_china.fragment.YYCodeOfConductKoDialogFragment;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.listener.OnClickHintFragmentLister;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.model.YYChatRoomGuideListMode;
import com.blued.android.module.yy_china.model.YYHomeChatsMode;
import com.blued.android.module.yy_china.model.YYHomeChatsRightBownMode;
import com.blued.android.module.yy_china.model.YYHomeChatsRightMode;
import com.blued.android.module.yy_china.model.YYHomeChatsRightTopMode;
import com.blued.android.module.yy_china.model.YYHomeChatsViewModel;
import com.blued.android.module.yy_china.model.YYLastRoomModel;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYMatchRoomModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataInfoMode;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.HomeRotationView;
import com.blued.android.module.yy_china.view.YYHomeCradAniView;
import com.blued.android.module.yy_china.view.YYHomeRoomGuideView;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import com.blued.android.module.yy_china.view.YYNewUserGiftDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapePath;
import com.google.android.material.shape.TriangleEdgeTreatment;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment.class */
public final class YYHomeChatsFragment extends MVVMBaseFragment<YYHomeChatsViewModel> implements View.OnClickListener, OnCLickRoomItemToGoRoomListener, OnClickHintFragmentLister {
    static final /* synthetic */ KProperty<Object>[] a = {Reflection.a(new PropertyReference1Impl(YYHomeChatsFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyHomeChatsBinding;", 0))};
    private GuideHandler b;
    private YYRoomExtraModel c;
    private List<HomeThemeModel> d;
    private YYLiveState e;
    private boolean f;
    private int g;
    private int h;
    private YYHomeChatsMode i;
    private YYRoomChatsPagerAdapter j;
    private boolean k;
    private final ViewBindingProperty l;
    private int m;
    private boolean n;
    private TextView o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$GuideHandler.class */
    public static final class GuideHandler extends Handler {
        private final WeakReference<YYHomeChatsFragment> a;

        public GuideHandler(YYHomeChatsFragment yYHomeChatsFragment) {
            this.a = new WeakReference<>(yYHomeChatsFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ActivityFragmentActive fragmentActive;
            YYHomeChatsViewModel a;
            FragmentYyHomeChatsBinding u;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (this.a.get() == null) {
                removeMessages(msg.what);
                return;
            }
            boolean z = false;
            switch (msg.what) {
                case 1:
                    removeMessages(1);
                    YYHomeChatsFragment yYHomeChatsFragment = this.a.get();
                    if (yYHomeChatsFragment == null || (fragmentActive = yYHomeChatsFragment.getFragmentActive()) == null) {
                        return;
                    }
                    YYHomeChatsFragment yYHomeChatsFragment2 = this.a.get();
                    if (yYHomeChatsFragment2 != null) {
                        yYHomeChatsFragment2.m = -10000;
                    }
                    YYHomeChatsFragment yYHomeChatsFragment3 = this.a.get();
                    if (yYHomeChatsFragment3 == null || (a = yYHomeChatsFragment3.a()) == null) {
                        return;
                    }
                    a.e(fragmentActive);
                    return;
                case 2:
                    YYHomeChatsFragment yYHomeChatsFragment4 = this.a.get();
                    if (yYHomeChatsFragment4 == null) {
                        return;
                    }
                    yYHomeChatsFragment4.s();
                    return;
                case 3:
                    YYHomeChatsFragment yYHomeChatsFragment5 = this.a.get();
                    FrameLayout frameLayout = null;
                    if (yYHomeChatsFragment5 != null && (u = yYHomeChatsFragment5.u()) != null) {
                        frameLayout = u.f;
                    }
                    if (frameLayout == null) {
                        return;
                    }
                    frameLayout.setClickable(false);
                    return;
                case 4:
                    YYHomeChatsFragment yYHomeChatsFragment6 = this.a.get();
                    if (yYHomeChatsFragment6 == null) {
                        return;
                    }
                    boolean z2 = false;
                    if (msg.arg1 == 1) {
                        z2 = true;
                    }
                    yYHomeChatsFragment6.b(z2);
                    return;
                case 5:
                    YYHomeChatsFragment yYHomeChatsFragment7 = this.a.get();
                    if (yYHomeChatsFragment7 == null) {
                        return;
                    }
                    if (msg.arg1 == 1) {
                        z = true;
                    }
                    yYHomeChatsFragment7.c(z);
                    return;
                case 6:
                    YYHomeChatsFragment yYHomeChatsFragment8 = this.a.get();
                    if (yYHomeChatsFragment8 == null) {
                        return;
                    }
                    yYHomeChatsFragment8.v();
                    return;
                case 7:
                    YYHomeChatsFragment yYHomeChatsFragment9 = this.a.get();
                    if (yYHomeChatsFragment9 == null) {
                        return;
                    }
                    yYHomeChatsFragment9.w();
                    return;
                default:
                    return;
            }
        }
    }

    public YYHomeChatsFragment() {
        super(R.layout.fragment_yy_home_chats);
        this.b = new GuideHandler(this);
        this.l = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYHomeChatsFragment, FragmentYyHomeChatsBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeChatsBinding invoke(YYHomeChatsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeChatsBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYHomeChatsFragment, FragmentYyHomeChatsBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeChatsBinding invoke(YYHomeChatsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeChatsBinding.a(fragment.requireView());
            }
        });
    }

    private final int a(List<HomeThemeModel> list, String str) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(String.valueOf(list.get(i2).getId()), str)) {
                i = i2;
            }
        }
        return i;
    }

    private final void a(int i) {
        if (YYRoomInfoManager.e().b() != null) {
            GuideHandler guideHandler = this.b;
            if (guideHandler == null) {
                return;
            }
            guideHandler.sendEmptyMessageDelayed(i, 2000L);
            return;
        }
        GuideHandler guideHandler2 = this.b;
        if (guideHandler2 == null) {
            return;
        }
        guideHandler2.sendEmptyMessageDelayed(i, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TAB_ADD_CLICK);
        LiveEventBus.get("create_entertainment_room").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeChatsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_CREATE_CLICK);
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeChatsFragment this$0, YYRoomExtraModel extra, View view) {
        String string;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(extra, "$extra");
        if (ClickUtils.a(R.id.img_entertainment, 2000L)) {
            return;
        }
        if (!YYRoomInfoManager.e().c().l()) {
            if (extra.last_room == null) {
                LiveEventBus.get("create_entertainment_room").post("");
            } else {
                YYLastRoomModel yYLastRoomModel = extra.last_room;
                this$0.a(yYLastRoomModel == null ? null : yYLastRoomModel.room_id, this$0.j().e());
            }
            EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TAB_ADD_CLICK);
            return;
        }
        FragmentYyHomeChatsBinding u = this$0.u();
        if (u == null) {
            string = null;
        } else {
            ImageView imageView = u.h;
            if (imageView == null) {
                string = null;
            } else {
                Context context = imageView.getContext();
                string = context == null ? null : context.getString(R.string.yy_living_toast);
            }
        }
        AppMethods.a((CharSequence) string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeChatsFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        if ((yYChatRoomGuideListMode == null ? null : yYChatRoomGuideListMode.data) == null || yYChatRoomGuideListMode.data.isEmpty() || YYRoomInfoManager.e().b() != null) {
            return;
        }
        YYHomeRoomGuideView.a(this, yYChatRoomGuideListMode.data, yYChatRoomGuideListMode.isNew);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYHomeChatsMode yYHomeChatsMode) {
        HomeRotationView homeRotationView;
        ImageView imageView;
        HomeRotationView homeRotationView2;
        ImageView imageView2;
        FragmentYyHomeChatsBinding u = u();
        FrameLayout frameLayout = u == null ? null : u.i;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        this.i = yYHomeChatsMode;
        if (yYHomeChatsMode == null) {
            return;
        }
        ArrayList<YyHomeChatItemDataInfoMode> room_info = yYHomeChatsMode.getLeft().getRoom_info();
        if ((room_info == null ? 0 : room_info.size()) == 0) {
            FragmentYyHomeChatsBinding u2 = u();
            if (u2 != null && (imageView2 = u2.l) != null) {
                imageView2.setImageResource(R.drawable.bg_yy_home_top_1_null);
            }
            FragmentYyHomeChatsBinding u3 = u();
            if (u3 != null && (homeRotationView2 = u3.s) != null) {
                homeRotationView2.a(new ArrayList(), this);
            }
        } else {
            FragmentYyHomeChatsBinding u4 = u();
            if (u4 != null && (imageView = u4.l) != null) {
                imageView.setImageResource(R.drawable.bg_yy_home_top_1);
            }
            ArrayList<YyHomeChatItemDataInfoMode> room_info2 = yYHomeChatsMode.getLeft().getRoom_info();
            FragmentYyHomeChatsBinding u5 = u();
            if (u5 != null && (homeRotationView = u5.s) != null) {
                homeRotationView.a(room_info2, this);
            }
        }
        yYHomeChatsMode.getRight().getTop();
        FragmentYyHomeChatsBinding u6 = u();
        FrameLayout frameLayout2 = u6 == null ? null : u6.j;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.arg1 = 1;
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            guideHandler.sendMessage(obtain);
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TOP_PLAZA_SHOW);
        a(6);
        YYHomeChatsRightBownMode down = yYHomeChatsMode.getRight().getDown();
        FragmentYyHomeChatsBinding u7 = u();
        FrameLayout frameLayout3 = u7 == null ? null : u7.k;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 5;
        obtain2.arg1 = 1;
        GuideHandler guideHandler2 = this.b;
        if (guideHandler2 != null) {
            guideHandler2.sendMessage(obtain2);
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TOP_TOPIC_SHOW, String.valueOf(down.getPosition()));
        a(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeChatsRightBownMode it, View view) {
        Intrinsics.e(it, "$it");
        YYRoomInfoManager.e().c().a(view.getContext(), it.getLink(), 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeChatsRightTopMode it, View view) {
        Intrinsics.e(it, "$it");
        YYRoomInfoManager.e().c().a(view.getContext(), it.getLink(), 0, true);
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TOP_PLAZA_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYLiveState yYLiveState) {
        this.f = yYLiveState.cover_white_list;
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) getString(R.string.yy_living_toast));
        } else if (AudioChannelManager.j().n()) {
            AppMethods.a((CharSequence) getString(R.string.yy_in_room_toast));
        } else if (yYLiveState.is_read_norms == 0) {
            b(yYLiveState);
        } else if (yYLiveState.is_invalid_prohibit == 1) {
            AppMethods.a((CharSequence) getString(R.string.yy_chat_invalid_prohibit_toast));
        } else if (yYLiveState.chatroom_audited == 1) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, j().e(), ChatRoomProtos.UserType.APPLY_SUCCESS_USER);
            a(j().d(), yYLiveState.anchor_level);
        } else if (yYLiveState.chatroom_audited == 0) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, j().e(), ChatRoomProtos.UserType.APPLYING_USER);
            YYApplyFinishFragment.a(getContext(), yYLiveState.chatroom_audited);
        } else {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CLICK, j().e(), ChatRoomProtos.UserType.COMMON_USER);
            YYApplyFragment.a(getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYMatchRoomModel yYMatchRoomModel) {
        if (yYMatchRoomModel == null) {
            return;
        }
        YYRoomInfoManager.e().a((BaseFragmentActivity) getActivity(), yYMatchRoomModel.getRoom_id(), "hall_random");
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_RANDOM_SUCCESS, yYMatchRoomModel.getRoom_id(), yYMatchRoomModel.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final YYRoomExtraModel yYRoomExtraModel) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        ViewPager viewPager;
        TextView textView2;
        ImageView imageView3;
        ImageView imageView4;
        this.c = yYRoomExtraModel;
        if (yYRoomExtraModel.is_hall_anchor == 1) {
            FragmentYyHomeChatsBinding u = u();
            ImageView imageView5 = u == null ? null : u.h;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TAB_ADD_SHOW);
            FragmentYyHomeChatsBinding u2 = u();
            if (u2 != null && (imageView4 = u2.h) != null) {
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$iMZeArEijkHdDTJcGCVEz2zi4P8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYHomeChatsFragment.a(YYHomeChatsFragment.this, yYRoomExtraModel, view);
                    }
                });
            }
            FragmentYyHomeChatsBinding u3 = u();
            if (u3 != null && (imageView3 = u3.h) != null) {
                imageView3.setImageResource(yYRoomExtraModel.last_room == null ? R.drawable.icon_yy_entertainment_create : R.drawable.icon_yy_entertainment_reenter);
            }
        } else {
            FragmentYyHomeChatsBinding u4 = u();
            ImageView imageView6 = u4 == null ? null : u4.h;
            if (imageView6 != null) {
                imageView6.setVisibility(0);
            }
            EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TAB_ADD_SHOW);
            FragmentYyHomeChatsBinding u5 = u();
            if (u5 != null && (imageView2 = u5.h) != null) {
                imageView2.setImageResource(R.drawable.icon_yy_entertainment_create);
            }
            FragmentYyHomeChatsBinding u6 = u();
            if (u6 != null && (imageView = u6.h) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$DzlAqWozHhA7qnLfia5CkUTJ9Ew
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYHomeChatsFragment.a(view);
                    }
                });
            }
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_RANDOM_SHOW);
        if (TextUtils.equals(yYRoomExtraModel.is_chatroom_wlist, "1")) {
            if (yYRoomExtraModel.last_room != null) {
                FragmentYyHomeChatsBinding u7 = u();
                TextView textView3 = u7 == null ? null : u7.v;
                if (textView3 != null) {
                    textView3.setText("我的房间");
                }
                FragmentYyHomeChatsBinding u8 = u();
                if (u8 != null && (textView2 = u8.v) != null) {
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$Yq-3qnNg2C5AYlvYz52NCI3YAsg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYHomeChatsFragment.b(YYHomeChatsFragment.this, yYRoomExtraModel, view);
                        }
                    });
                }
                this.n = true;
            } else {
                FragmentYyHomeChatsBinding u9 = u();
                TextView textView4 = u9 == null ? null : u9.v;
                if (textView4 != null) {
                    textView4.setText("创建房间");
                }
                FragmentYyHomeChatsBinding u10 = u();
                if (u10 != null && (textView = u10.v) != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$G4kiy2kKohJWw2PMHyZqFz8LCqo
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYHomeChatsFragment.a(YYHomeChatsFragment.this, view);
                        }
                    });
                }
                EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_CREATE_SHOW);
                this.n = true;
            }
            FragmentYyHomeChatsBinding u11 = u();
            if ((u11 == null || (viewPager = u11.r) == null || viewPager.getCurrentItem() != 0) ? false : true) {
                FragmentYyHomeChatsBinding u12 = u();
                ShapeLinearLayout shapeLinearLayout = u12 == null ? null : u12.t;
                if (shapeLinearLayout != null) {
                    shapeLinearLayout.setVisibility(8);
                }
            } else {
                FragmentYyHomeChatsBinding u13 = u();
                ShapeLinearLayout shapeLinearLayout2 = u13 == null ? null : u13.t;
                if (shapeLinearLayout2 != null) {
                    shapeLinearLayout2.setVisibility(0);
                }
            }
            EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_CREATE_SHOW, "", "", "", j().e());
        } else {
            FragmentYyHomeChatsBinding u14 = u();
            ShapeLinearLayout shapeLinearLayout3 = u14 == null ? null : u14.t;
            if (shapeLinearLayout3 != null) {
                shapeLinearLayout3.setVisibility(8);
            }
        }
        if (!TextUtils.equals(yYRoomExtraModel.has_redPacket, "1")) {
            FragmentYyHomeChatsBinding u15 = u();
            LinearLayout linearLayout = u15 == null ? null : u15.o;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_REDBAG_SHOW);
        FragmentYyHomeChatsBinding u16 = u();
        LinearLayout linearLayout2 = u16 == null ? null : u16.o;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(0);
    }

    private final void a(String str, int i) {
        Intrinsics.a((Object) str);
        YYCreateRoomFragment.a.a(this, str, this.f, i);
    }

    private final void a(String str, final int i, final SVGAImageView sVGAImageView) {
        SVGAParser b = SVGAParser.a.b();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (StringsKt.b(lowerCase, "png", false, 2, (Object) null)) {
            ImageLoader.a(getFragmentActive(), str).d(i).f().a(sVGAImageView);
        } else {
            SVGAParser.a(b, new URL(str), new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$playSvgaAnimation$1
                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.e(videoItem, "videoItem");
                    SVGAImageView sVGAImageView2 = SVGAImageView.this;
                    if (sVGAImageView2 != null) {
                        sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem));
                    }
                    SVGAImageView sVGAImageView3 = SVGAImageView.this;
                    if (sVGAImageView3 == null) {
                        return;
                    }
                    sVGAImageView3.a();
                }

                @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                    SVGAImageView sVGAImageView2 = SVGAImageView.this;
                    if (sVGAImageView2 == null) {
                        return;
                    }
                    sVGAImageView2.setImageResource(i);
                }
            }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        }
    }

    private final void a(String str, String str2, String str3, String str4, String str5, boolean z, int i) {
        if (ClickUtils.a(R.id.tv_create)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            ToastUtils.b("请选择房间类型");
        } else if (TextUtils.isEmpty(str)) {
            ToastUtils.b("房间名不能为空");
        } else {
            EventTrackYY.f(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CONFIRM_CLICK, str, i == 1 ? str2 : "8", str4, j().e());
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            YYHomeChatsViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive, activity, str2, str4, str, str5, str3, z, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<HomeThemeModel> list) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        LogUtils.d("cache", "setRoomTypes ... ");
        FragmentYyHomeChatsBinding u = u();
        if (u != null && (noDataAndLoadFailView = u.q) != null) {
            noDataAndLoadFailView.d();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HomeThemeModel(-1, "关注", "", "", null, 16, null));
        arrayList.addAll(list);
        b(arrayList);
    }

    private final void a(final List<HomeThemeModel> list, int i) {
        YYHomeThemeTabView yYHomeThemeTabView;
        ViewPager viewPager;
        if (this.j == null) {
            this.j = new YYRoomChatsPagerAdapter(getChildFragmentManager(), j().e(), this);
            FragmentYyHomeChatsBinding u = u();
            ViewPager viewPager2 = u == null ? null : u.r;
            if (viewPager2 != null) {
                viewPager2.setAdapter(this.j);
            }
            FragmentYyHomeChatsBinding u2 = u();
            if (u2 != null && (viewPager = u2.r) != null) {
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$initRoomPager$1
                    public void onPageScrollStateChanged(int i2) {
                    }

                    public void onPageScrolled(int i2, float f, int i3) {
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:59:0x0129, code lost:
                        r0 = r5.b;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onPageSelected(int r7) {
                        /*
                            Method dump skipped, instructions count: 360
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$initRoomPager$1.onPageSelected(int):void");
                    }
                });
            }
            FragmentYyHomeChatsBinding u3 = u();
            if (u3 != null && (yYHomeThemeTabView = u3.u) != null) {
                yYHomeThemeTabView.a(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$initRoomPager$2
                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
                        r0 = r5.a.b;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
                        /*
                            r5 = this;
                            r0 = r6
                            java.lang.String r1 = "recyclerView"
                            kotlin.jvm.internal.Intrinsics.e(r0, r1)
                            r0 = r5
                            r1 = r6
                            r2 = r7
                            r3 = r8
                            super.onScrolled(r1, r2, r3)
                            r0 = r5
                            com.blued.android.module.yy_china.fragment.YYHomeChatsFragment r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.this
                            boolean r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.f(r0)
                            if (r0 == 0) goto L34
                            r0 = r5
                            com.blued.android.module.yy_china.fragment.YYHomeChatsFragment r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.this
                            android.widget.TextView r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.d(r0)
                            if (r0 == 0) goto L34
                            r0 = r5
                            com.blued.android.module.yy_china.fragment.YYHomeChatsFragment r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.this
                            com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$GuideHandler r0 = com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.e(r0)
                            r6 = r0
                            r0 = r6
                            if (r0 != 0) goto L2e
                            return
                        L2e:
                            r0 = r6
                            r1 = 2
                            boolean r0 = r0.sendEmptyMessage(r1)
                        L34:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$initRoomPager$2.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
                    }
                });
            }
        }
        YYRoomChatsPagerAdapter yYRoomChatsPagerAdapter = this.j;
        if (yYRoomChatsPagerAdapter != null) {
            yYRoomChatsPagerAdapter.a(this.c);
        }
        YYRoomChatsPagerAdapter yYRoomChatsPagerAdapter2 = this.j;
        if (yYRoomChatsPagerAdapter2 != null) {
            yYRoomChatsPagerAdapter2.b(list);
        }
        FragmentYyHomeChatsBinding u4 = u();
        ViewPager viewPager3 = u4 == null ? null : u4.r;
        if (viewPager3 != null) {
            viewPager3.setCurrentItem(i);
        }
        if (i == 0) {
            FragmentYyHomeChatsBinding u5 = u();
            ShapeTextView shapeTextView = u5 == null ? null : u5.y;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            FragmentYyHomeChatsBinding u6 = u();
            ShapeLinearLayout shapeLinearLayout = u6 == null ? null : u6.t;
            if (shapeLinearLayout == null) {
                return;
            }
            shapeLinearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYHomeChatsFragment this$0, YYRoomExtraModel extra, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(extra, "$extra");
        YYLastRoomModel yYLastRoomModel = extra.last_room;
        this$0.a(yYLastRoomModel == null ? null : yYLastRoomModel.room_id, this$0.j().e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYHomeChatsRightBownMode it, View view) {
        Intrinsics.e(it, "$it");
        YYRoomInfoManager.e().c().a(view.getContext(), it.getLink(), 0, true);
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_TOP_TOPIC_CLICK, String.valueOf(it.getPosition()));
    }

    private final void b(YYLiveState yYLiveState) {
        this.e = yYLiveState;
        YYCodeOfConductKoDialogFragment.Companion companion = YYCodeOfConductKoDialogFragment.a;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager).a(this);
    }

    private final void b(List<HomeThemeModel> list) {
        YYHomeThemeTabView yYHomeThemeTabView;
        YYHomeThemeTabView yYHomeThemeTabView2;
        int a2 = a(list, j().d());
        this.d = list;
        FragmentYyHomeChatsBinding u = u();
        if (u != null && (yYHomeThemeTabView2 = u.u) != null) {
            FragmentYyHomeChatsBinding u2 = u();
            ViewPager viewPager = u2 == null ? null : u2.r;
            Intrinsics.a(viewPager);
            Intrinsics.c(viewPager, "vb?.roomViewPager!!");
            yYHomeThemeTabView2.a(viewPager);
        }
        FragmentYyHomeChatsBinding u3 = u();
        if (u3 != null && (yYHomeThemeTabView = u3.u) != null) {
            YYHomeThemeTabView.a(yYHomeThemeTabView, list, false, 0, 0, 12, null);
        }
        Intrinsics.a(list);
        a(list, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        YYHomeChatsRightMode right;
        final YYHomeChatsRightTopMode top;
        FrameLayout frameLayout;
        BluedMarqueeTextView bluedMarqueeTextView;
        YYHomeChatsMode yYHomeChatsMode = this.i;
        if (yYHomeChatsMode == null || (right = yYHomeChatsMode.getRight()) == null || (top = right.getTop()) == null) {
            return;
        }
        FragmentYyHomeChatsBinding u = u();
        FrameLayout frameLayout2 = u == null ? null : u.j;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        FragmentYyHomeChatsBinding u2 = u();
        TextView textView = u2 == null ? null : u2.A;
        if (textView != null) {
            textView.setText(top.getTitle());
        }
        ArrayList<String> sub_title = top.getSub_title();
        if (sub_title != null) {
            if (sub_title.size() <= this.g) {
                this.g = 0;
            }
            FragmentYyHomeChatsBinding u3 = u();
            if (u3 != null && (bluedMarqueeTextView = u3.B) != null) {
                bluedMarqueeTextView.setText(sub_title.get(this.g));
            }
        }
        if (z) {
            String background_image = top.getBackground_image();
            int i = R.drawable.bg_yy_home_top_2;
            FragmentYyHomeChatsBinding u4 = u();
            a(background_image, i, u4 == null ? null : u4.m);
        }
        this.g++;
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(4, top.getFrequency_seconds() * 1000);
        }
        FragmentYyHomeChatsBinding u5 = u();
        if (u5 == null || (frameLayout = u5.j) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$STI2nNLaq4PU8GeooBpP92-4QfU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHomeChatsFragment.a(YYHomeChatsRightTopMode.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z) {
        YYHomeChatsRightMode right;
        final YYHomeChatsRightBownMode down;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        BluedMarqueeTextView bluedMarqueeTextView;
        YYHomeChatsMode yYHomeChatsMode = this.i;
        if (yYHomeChatsMode == null || (right = yYHomeChatsMode.getRight()) == null || (down = right.getDown()) == null) {
            return;
        }
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            guideHandler.removeMessages(5);
        }
        FragmentYyHomeChatsBinding u = u();
        FrameLayout frameLayout3 = u == null ? null : u.k;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        FragmentYyHomeChatsBinding u2 = u();
        TextView textView = u2 == null ? null : u2.w;
        if (textView != null) {
            textView.setText(down.getTitle());
        }
        if (down.getSub_title().size() <= this.h) {
            this.h = 0;
        }
        ArrayList<String> sub_title = down.getSub_title();
        FragmentYyHomeChatsBinding u3 = u();
        if (u3 != null && (bluedMarqueeTextView = u3.x) != null) {
            bluedMarqueeTextView.setText(sub_title.get(this.h));
        }
        if (z) {
            String background_image = down.getBackground_image();
            int i = R.drawable.bg_yy_home_top_3;
            FragmentYyHomeChatsBinding u4 = u();
            a(background_image, i, u4 == null ? null : u4.n);
        }
        this.h++;
        FragmentYyHomeChatsBinding u5 = u();
        if (u5 != null && (frameLayout2 = u5.k) != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$zjY6J2OeWV8VOQfChfug4eAnMG4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeChatsFragment.a(YYHomeChatsRightBownMode.this, view);
                }
            });
        }
        GuideHandler guideHandler2 = this.b;
        if (guideHandler2 != null) {
            guideHandler2.sendEmptyMessageDelayed(5, down.getFrequency_seconds() * 1000);
        }
        FragmentYyHomeChatsBinding u6 = u();
        if (u6 == null || (frameLayout = u6.k) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$BcxNtbF924Ro1Kh64PLLm_55sew
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHomeChatsFragment.b(YYHomeChatsRightBownMode.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        YYRoomChatsPagerAdapter yYRoomChatsPagerAdapter = this.j;
        if (yYRoomChatsPagerAdapter != null) {
            Intrinsics.a(yYRoomChatsPagerAdapter);
            if (yYRoomChatsPagerAdapter.getCount() > 0) {
                return;
            }
        }
        FragmentYyHomeChatsBinding u = u();
        if (u != null && (noDataAndLoadFailView = u.q) != null) {
            noDataAndLoadFailView.a();
        }
        FragmentYyHomeChatsBinding u2 = u();
        NoDataAndLoadFailView noDataAndLoadFailView2 = u2 == null ? null : u2.q;
        if (noDataAndLoadFailView2 == null) {
            return;
        }
        noDataAndLoadFailView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        FragmentYyHomeChatsBinding u = u();
        if (u != null && (noDataAndLoadFailView = u.q) != null) {
            noDataAndLoadFailView.a();
        }
        FragmentYyHomeChatsBinding u2 = u();
        NoDataAndLoadFailView noDataAndLoadFailView2 = u2 == null ? null : u2.q;
        if (noDataAndLoadFailView2 == null) {
            return;
        }
        noDataAndLoadFailView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YYHomeChatsFragment this$0) {
        ViewPager viewPager;
        ConstraintLayout constraintLayout;
        Intrinsics.e(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(AppInfo.d().getResources().getDimensionPixelOffset(R.dimen.dp_170), AppInfo.d().getResources().getDimensionPixelOffset(R.dimen.dp_35));
        ((ConstraintLayout.LayoutParams) layoutParams).topMargin = new int[2][1];
        ((ConstraintLayout.LayoutParams) layoutParams).leftMargin = 10;
        FragmentYyHomeChatsBinding u = this$0.u();
        Integer valueOf = (u == null || (viewPager = u.r) == null) ? null : Integer.valueOf(viewPager.getId());
        Intrinsics.a(valueOf);
        ((ConstraintLayout.LayoutParams) layoutParams).topToTop = valueOf.intValue();
        ((ConstraintLayout.LayoutParams) layoutParams).leftToLeft = 0;
        FragmentYyHomeChatsBinding u2 = this$0.u();
        ConstraintLayout constraintLayout2 = u2 == null ? null : u2.e;
        if (constraintLayout2 != null) {
            constraintLayout2.setClipChildren(false);
        }
        FragmentYyHomeChatsBinding u3 = this$0.u();
        if (u3 != null && (constraintLayout = u3.e) != null) {
            constraintLayout.addView(this$0.o, layoutParams);
        }
        GuideHandler guideHandler = this$0.b;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(2, 5000L);
        }
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_OPEN_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentYyHomeChatsBinding u() {
        return (FragmentYyHomeChatsBinding) this.l.b(this, a[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        FragmentYyHomeChatsBinding u = u();
        YYHomeCradAniView yYHomeCradAniView = u == null ? null : u.a;
        if (yYHomeCradAniView == null) {
            return;
        }
        yYHomeCradAniView.setMWidth(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        FragmentYyHomeChatsBinding u = u();
        YYHomeCradAniView yYHomeCradAniView = u == null ? null : u.b;
        if (yYHomeCradAniView == null) {
            return;
        }
        yYHomeCradAniView.setMWidth(0);
    }

    private final void x() {
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) getString(R.string.yy_living_toast));
        } else if (AudioChannelManager.j().n()) {
            AppMethods.a((CharSequence) getString(R.string.yy_in_room_toast));
        } else {
            PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$createNewRoom$1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    YYHomeChatsViewModel j;
                    j = YYHomeChatsFragment.this.j();
                    ActivityFragmentActive fragmentActive = YYHomeChatsFragment.this.getFragmentActive();
                    Intrinsics.c(fragmentActive, "fragmentActive");
                    j.d(fragmentActive);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    Intrinsics.e(perms, "perms");
                    AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                }
            });
        }
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void a(String str, String str2) {
        YYRoomInfoManager.e().a((BaseFragmentActivity) getActivity(), str, str2);
        this.m = -10000;
        GuideHandler guideHandler = this.b;
        if (guideHandler == null) {
            return;
        }
        guideHandler.removeMessages(1);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentYyHomeChatsBinding u = u();
        if (u == null) {
            return;
        }
        ShapeTextView shapeTextView = u.y;
        YYHomeChatsFragment yYHomeChatsFragment = this;
        shapeTextView.setOnClickListener(yYHomeChatsFragment);
        u.v.setOnClickListener(yYHomeChatsFragment);
        u.z.setOnClickListener(yYHomeChatsFragment);
        u.o.setOnClickListener(yYHomeChatsFragment);
        u.q.setNoDataStr(R.string.yy_no_data_room);
        u.q.setNoDataImg(R.drawable.icon_no_live_posted);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        super.k();
        EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_ENTER_CLICK, "", "", "", j().e());
        LiveEventBus.get("create_entertainment_room", String.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$gdwBxlvxkdq6WKiSHVvzaoB4KOQ
            public final void onChanged(Object obj) {
                YYHomeChatsFragment.a(YYHomeChatsFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.a(lifecycleOwner, j().g(), new YYHomeChatsFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(lifecycleOwner, j().f(), new YYHomeChatsFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(lifecycleOwner, j().h(), new YYHomeChatsFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(lifecycleOwner, j().k(), new YYHomeChatsFragment$liveDataObserver$4(this));
        LifecycleExtKt.a(lifecycleOwner, j().n(), new YYHomeChatsFragment$liveDataObserver$5(this));
        LifecycleExtKt.a(lifecycleOwner, j().l(), new YYHomeChatsFragment$liveDataObserver$6(this));
        LifecycleExtKt.a(lifecycleOwner, j().o(), new YYHomeChatsFragment$liveDataObserver$7(this));
        LifecycleExtKt.a(lifecycleOwner, j().m(), new YYHomeChatsFragment$liveDataObserver$8(this));
        LifecycleExtKt.a(lifecycleOwner, j().p(), new YYHomeChatsFragment$liveDataObserver$9(this));
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(1, 20000L);
        }
        YYNewUserGiftDialog.a.a(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            return;
        }
        if (i == 100 && intent != null && intent.getBooleanExtra("auth_upload_state", false)) {
            YYApplyFinishFragment.a(getContext(), 0);
        }
        if (i != 10001 || intent == null) {
            return;
        }
        FragmentYyHomeChatsBinding u = u();
        FrameLayout frameLayout = u == null ? null : u.f;
        if (frameLayout != null) {
            frameLayout.setClickable(true);
        }
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(3, 2000L);
        }
        String stringExtra = intent.getStringExtra("roomname");
        String stringExtra2 = intent.getStringExtra("imgBackground");
        a(String.valueOf(stringExtra), String.valueOf(intent.getStringExtra("typeId")), String.valueOf(stringExtra2), String.valueOf(intent.getStringExtra("labelId")), intent.getStringExtra("imgCover"), intent.getBooleanExtra("is_fans_notice", false), intent.getIntExtra("is_veiled", 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment.onClick(android.view.View):void");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        YYRoomChatsPagerAdapter yYRoomChatsPagerAdapter = this.j;
        if (yYRoomChatsPagerAdapter != null && yYRoomChatsPagerAdapter != null) {
            yYRoomChatsPagerAdapter.b();
        }
        GuideHandler guideHandler = this.b;
        if (guideHandler != null) {
            if (guideHandler != null) {
                guideHandler.removeCallbacksAndMessages(null);
            }
            this.b = null;
        }
        YYChatRoomsListFragment.a.a("");
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        HomeRotationView homeRotationView;
        super.onPause();
        FragmentYyHomeChatsBinding u = u();
        if (u == null || (homeRotationView = u.s) == null) {
            return;
        }
        homeRotationView.b();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        HomeRotationView homeRotationView;
        super.onResume();
        j().a(getFragmentActive());
        j().b(getFragmentActive());
        FragmentYyHomeChatsBinding u = u();
        if (u == null || (homeRotationView = u.s) == null) {
            return;
        }
        homeRotationView.a();
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void p() {
        GuideHandler guideHandler;
        int i = this.m;
        if (i < 0) {
            return;
        }
        this.m = i + 1;
        if (i + 1 != 50 || (guideHandler = this.b) == null) {
            return;
        }
        guideHandler.sendEmptyMessage(1);
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void q() {
        ViewPager viewPager;
        if (this.p) {
            return;
        }
        this.p = true;
        ShapeAppearanceModel.Builder builder = ShapeAppearanceModel.builder();
        builder.setAllCorners(new RoundedCornerTreatment());
        builder.setAllCornerSizes(getResources().getDimensionPixelOffset(R.dimen.dp_7));
        final float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_7);
        builder.setTopEdge(new TriangleEdgeTreatment(dimensionPixelOffset) { // from class: com.blued.android.module.yy_china.fragment.YYHomeChatsFragment$addMyGuide$shapeAppearanceModel3$1$1
            public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
                Intrinsics.e(shapePath, "shapePath");
                super.getEdgePath(f, YYHomeChatsFragment.this.getResources().getDimensionPixelOffset(R.dimen.dp_15), f3, shapePath);
            }
        });
        ShapeAppearanceModel build = builder.build();
        Intrinsics.c(build, "builder().apply {\n      …     })\n        }.build()");
        Drawable materialShapeDrawable = new MaterialShapeDrawable(build);
        materialShapeDrawable.setTint(ContextCompat.getColor(requireContext(), R.color.syc_474D55));
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        TextView textView = new TextView(getContext());
        this.o = textView;
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setGravity(17);
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(R.color.syc_FAFAFA));
        }
        TextView textView4 = this.o;
        if (textView4 != null) {
            textView4.setBackgroundDrawable(materialShapeDrawable);
        }
        TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setText("你关注的房主正在开播");
        }
        FragmentYyHomeChatsBinding u = u();
        if (u == null || (viewPager = u.r) == null) {
            return;
        }
        viewPager.post(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeChatsFragment$DwK743IWw72KzZuDj9jfSa6V_lw
            @Override // java.lang.Runnable
            public final void run() {
                YYHomeChatsFragment.i(YYHomeChatsFragment.this);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void r() {
        j().c(getFragmentActive());
    }

    public final void s() {
        ConstraintLayout constraintLayout;
        TextView textView = this.o;
        if (textView == null) {
            return;
        }
        FragmentYyHomeChatsBinding u = u();
        if (u != null && (constraintLayout = u.e) != null) {
            constraintLayout.removeView(textView);
        }
        this.o = null;
    }

    @Override // com.blued.android.module.yy_china.listener.OnClickHintFragmentLister
    public void t() {
        YYLiveState yYLiveState = this.e;
        if (yYLiveState == null) {
            YYHomeChatsViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.d(fragmentActive);
            return;
        }
        Intrinsics.a(yYLiveState);
        yYLiveState.is_read_norms = 1;
        YYLiveState yYLiveState2 = this.e;
        Intrinsics.a(yYLiveState2);
        a(yYLiveState2);
        this.e = null;
    }
}
