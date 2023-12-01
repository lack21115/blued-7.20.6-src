package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRoomPagerAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyChatRoomListBinding;
import com.blued.android.module.yy_china.fragment.YYCodeOfConductKoDialogFragment;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.listener.OnClickHintFragmentLister;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYChatRoomGuideListMode;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.model.YYMatchRoomModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import com.blued.android.module.yy_china.presenter.YYChatRoomsListViewModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYHomeRoomGuideView;
import com.blued.android.module.yy_china.view.YYHomeTabView;
import com.blued.android.module.yy_china.view.YYNewUserGiftDialog;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapePath;
import com.google.android.material.shape.TriangleEdgeTreatment;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment.class */
public final class YYChatRoomsListFragment extends MVVMBaseFragment<YYChatRoomsListViewModel> implements View.OnClickListener, OnCLickRoomItemToGoRoomListener, OnClickHintFragmentLister, BGABanner.Adapter<View, Object> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f17121c;
    private final String d;
    private GuideHandler e;
    private YYRoomExtraModel f;
    private List<? extends HomeTopicModel> g;
    private YYLiveState h;
    private boolean i;
    private int j;
    private boolean k;
    private TextView l;
    private boolean m;
    private YYRoomPagerAdapter n;
    private boolean o;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(YYChatRoomsListFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyChatRoomListBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17120a = new Companion(null);
    private static String p = "";

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return YYChatRoomsListFragment.p;
        }

        public final void a(Context context, String fromSource) {
            Intrinsics.e(context, "context");
            Intrinsics.e(fromSource, "fromSource");
            a(context, fromSource, "0");
        }

        public final void a(Context context, String fromSource, String typeId) {
            Intrinsics.e(context, "context");
            Intrinsics.e(fromSource, "fromSource");
            Intrinsics.e(typeId, "typeId");
            a(context, fromSource, typeId, "");
        }

        public final void a(Context context, String fromSource, String typeId, String details) {
            Intrinsics.e(context, "context");
            Intrinsics.e(fromSource, "fromSource");
            Intrinsics.e(typeId, "typeId");
            Intrinsics.e(details, "details");
            a(context, fromSource, typeId, details, "");
        }

        public final void a(Context context, String fromSource, String typeId, String details, String room_id) {
            Intrinsics.e(context, "context");
            Intrinsics.e(fromSource, "fromSource");
            Intrinsics.e(typeId, "typeId");
            Intrinsics.e(details, "details");
            Intrinsics.e(room_id, "room_id");
            a(details);
            Bundle bundle = new Bundle();
            bundle.putString("from_source", fromSource);
            bundle.putString("type_id", typeId);
            bundle.putString(TTLiveConstants.ROOMID_KEY, room_id);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, YYHomeRoomsFragment.class, bundle);
        }

        public final void a(String str) {
            Intrinsics.e(str, "<set-?>");
            YYChatRoomsListFragment.p = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment$GuideHandler.class */
    public static final class GuideHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<YYChatRoomsListFragment> f17122a;

        public GuideHandler(YYChatRoomsListFragment yYChatRoomsListFragment) {
            this.f17122a = new WeakReference<>(yYChatRoomsListFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ActivityFragmentActive fragmentActive;
            YYChatRoomsListFragment yYChatRoomsListFragment;
            YYChatRoomsListViewModel a2;
            FragmentYyChatRoomListBinding v;
            Intrinsics.e(msg, "msg");
            super.handleMessage(msg);
            if (this.f17122a.get() == null) {
                removeMessages(msg.what);
                return;
            }
            int i = msg.what;
            if (i == 1) {
                removeMessages(1);
                YYChatRoomsListFragment yYChatRoomsListFragment2 = this.f17122a.get();
                if (yYChatRoomsListFragment2 == null || (fragmentActive = yYChatRoomsListFragment2.getFragmentActive()) == null || (yYChatRoomsListFragment = this.f17122a.get()) == null || (a2 = yYChatRoomsListFragment.a()) == null) {
                    return;
                }
                a2.c(fragmentActive);
            } else if (i == 2) {
                YYChatRoomsListFragment yYChatRoomsListFragment3 = this.f17122a.get();
                if (yYChatRoomsListFragment3 == null) {
                    return;
                }
                yYChatRoomsListFragment3.s();
            } else if (i != 3) {
            } else {
                YYChatRoomsListFragment yYChatRoomsListFragment4 = this.f17122a.get();
                FrameLayout frameLayout = null;
                if (yYChatRoomsListFragment4 != null && (v = yYChatRoomsListFragment4.v()) != null) {
                    frameLayout = v.d;
                }
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setClickable(false);
            }
        }
    }

    public YYChatRoomsListFragment() {
        super(R.layout.fragment_yy_chat_room_list);
        this.f17121c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYChatRoomsListFragment, FragmentYyChatRoomListBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyChatRoomListBinding invoke(YYChatRoomsListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyChatRoomListBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYChatRoomsListFragment, FragmentYyChatRoomListBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyChatRoomListBinding invoke(YYChatRoomsListFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyChatRoomListBinding.a(fragment.requireView());
            }
        });
        this.d = "YYChatRoomsListFragment";
        this.e = new GuideHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a(int i) {
        return getResources().getDimensionPixelOffset(i);
    }

    private final int a(List<? extends HomeTopicModel> list, String str) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(String.valueOf(list.get(i2).getLabel_id()), str)) {
                i = i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYChatRoomsListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        Logger.e(this$0.d, "EVENT_REFRESH_OR_LOADMORE_FINISH ... ");
        this$0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        if ((yYChatRoomGuideListMode == null ? null : yYChatRoomGuideListMode.data) == null || yYChatRoomGuideListMode.data.isEmpty() || YYRoomInfoManager.e().b() != null) {
            return;
        }
        YYHomeRoomGuideView.a(this, yYChatRoomGuideListMode.data, yYChatRoomGuideListMode.isNew);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYLiveState yYLiveState) {
        this.i = yYLiveState.cover_white_list;
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
    public final void a(YYRoomExtraModel yYRoomExtraModel) {
        this.f = yYRoomExtraModel;
        if (TextUtils.equals(yYRoomExtraModel.is_chatroom_wlist, "1")) {
            if (yYRoomExtraModel.last_room != null) {
                FragmentYyChatRoomListBinding v = v();
                ShapeLinearLayout shapeLinearLayout = v == null ? null : v.j;
                if (shapeLinearLayout != null) {
                    shapeLinearLayout.setVisibility(8);
                }
                this.k = false;
            } else {
                FragmentYyChatRoomListBinding v2 = v();
                ShapeLinearLayout shapeLinearLayout2 = v2 == null ? null : v2.j;
                if (shapeLinearLayout2 != null) {
                    shapeLinearLayout2.setVisibility(0);
                }
                this.k = true;
            }
            EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_CREATE_SHOW, "", "", "", j().e());
        } else {
            FragmentYyChatRoomListBinding v3 = v();
            ShapeLinearLayout shapeLinearLayout3 = v3 == null ? null : v3.j;
            if (shapeLinearLayout3 != null) {
                shapeLinearLayout3.setVisibility(8);
            }
        }
        if (!TextUtils.equals(yYRoomExtraModel.has_redPacket, "1")) {
            FragmentYyChatRoomListBinding v4 = v();
            LinearLayout linearLayout = v4 == null ? null : v4.e;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_REDBAG_SHOW);
        FragmentYyChatRoomListBinding v5 = v();
        LinearLayout linearLayout2 = v5 == null ? null : v5.e;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(0);
    }

    private final void a(String str, int i) {
        Intrinsics.a((Object) str);
        YYCreateRoomFragment.f17181a.a(this, str, this.i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, YYBannerModel banner, YYChatRoomsListFragment this$0, View view) {
        Intrinsics.e(banner, "$banner");
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<String> list = banner.click_url;
        if (list != null) {
            IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
            Object[] array = list.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c2.a((String[]) array);
        }
        EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_BANNER_CLICK, banner.ads_id);
        YYRoomInfoManager.e().c().a(this$0.getContext(), str, 9);
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
            EventTrackYY.f(ChatRoomProtos.Event.CHAT_ROOM_CREATE_CONFIRM_CLICK, str, str2, str4, j().e());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            YYChatRoomsListViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive, activity, str2, str4, str, str5, str3, z, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends HomeTopicModel> list) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        LogUtils.d("cache", "setRoomTypes ... ");
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (noDataAndLoadFailView = v.f) != null) {
            noDataAndLoadFailView.d();
        }
        ArrayList arrayList = new ArrayList();
        HomeTopicModel homeTopicModel = new HomeTopicModel();
        homeTopicModel.setLabel_name("关注");
        homeTopicModel.setLabel_id(-1);
        arrayList.add(homeTopicModel);
        arrayList.addAll(list);
        c(arrayList);
    }

    private final void a(final List<? extends HomeTopicModel> list, int i) {
        ViewPager viewPager;
        String a2;
        YYHomeTabView yYHomeTabView;
        ViewPager viewPager2;
        if (this.n == null) {
            this.n = new YYRoomPagerAdapter(getChildFragmentManager(), j().e(), this);
            FragmentYyChatRoomListBinding v = v();
            ViewPager viewPager3 = v == null ? null : v.i;
            if (viewPager3 != null) {
                viewPager3.setAdapter(this.n);
            }
            FragmentYyChatRoomListBinding v2 = v();
            if (v2 != null && (viewPager2 = v2.i) != null) {
                viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$initRoomPager$1
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i2) {
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i2, float f, int i3) {
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:59:0x0129, code lost:
                        r0 = r5.e;
                     */
                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onPageSelected(int r7) {
                        /*
                            Method dump skipped, instructions count: 360
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$initRoomPager$1.onPageSelected(int):void");
                    }
                });
            }
            FragmentYyChatRoomListBinding v3 = v();
            if (v3 != null && (yYHomeTabView = v3.k) != null) {
                yYHomeTabView.a(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$initRoomPager$2
                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
                        r0 = r5.f17126a.e;
                     */
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
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
                            com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.this
                            boolean r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.f(r0)
                            if (r0 == 0) goto L34
                            r0 = r5
                            com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.this
                            android.widget.TextView r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.d(r0)
                            if (r0 == 0) goto L34
                            r0 = r5
                            com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.this
                            com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$GuideHandler r0 = com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.e(r0)
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
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$initRoomPager$2.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
                    }
                });
            }
        } else {
            Observable<Object> observable = LiveEventBus.get("refresh_or_loadmore");
            FragmentYyChatRoomListBinding v4 = v();
            if (v4 != null && (viewPager = v4.i) != null) {
                int currentItem = viewPager.getCurrentItem();
                YYRoomPagerAdapter yYRoomPagerAdapter = this.n;
                if (yYRoomPagerAdapter != null) {
                    a2 = yYRoomPagerAdapter.a(currentItem);
                    observable.post(a2);
                }
            }
            a2 = null;
            observable.post(a2);
        }
        YYRoomPagerAdapter yYRoomPagerAdapter2 = this.n;
        if (yYRoomPagerAdapter2 != null) {
            yYRoomPagerAdapter2.a(this.f);
        }
        YYRoomPagerAdapter yYRoomPagerAdapter3 = this.n;
        if (yYRoomPagerAdapter3 != null) {
            yYRoomPagerAdapter3.b(list);
        }
        FragmentYyChatRoomListBinding v5 = v();
        ViewPager viewPager4 = v5 == null ? null : v5.i;
        if (viewPager4 != null) {
            viewPager4.setCurrentItem(i);
        }
        if (i == 0) {
            FragmentYyChatRoomListBinding v6 = v();
            ShapeTextView shapeTextView = v6 == null ? null : v6.m;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(8);
            }
            FragmentYyChatRoomListBinding v7 = v();
            ShapeLinearLayout shapeLinearLayout = v7 == null ? null : v7.j;
            if (shapeLinearLayout == null) {
                return;
            }
            shapeLinearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYChatRoomsListFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.x();
    }

    private final void b(YYLiveState yYLiveState) {
        this.h = yYLiveState;
        YYCodeOfConductKoDialogFragment.Companion companion = YYCodeOfConductKoDialogFragment.f17160a;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends YYBannerModel> list) {
        BGABanner bGABanner;
        BGABanner bGABanner2;
        BGABanner bGABanner3;
        if (!(!list.isEmpty())) {
            FragmentYyChatRoomListBinding v = v();
            BGABanner bGABanner4 = v == null ? null : v.b;
            if (bGABanner4 == null) {
                return;
            }
            bGABanner4.setVisibility(8);
            return;
        }
        FragmentYyChatRoomListBinding v2 = v();
        BGABanner bGABanner5 = v2 == null ? null : v2.b;
        if (bGABanner5 != null) {
            bGABanner5.setVisibility(0);
        }
        if (list.size() > 1) {
            FragmentYyChatRoomListBinding v3 = v();
            if (v3 != null && (bGABanner3 = v3.b) != null) {
                bGABanner3.setAutoPlayAble(true);
            }
        } else {
            FragmentYyChatRoomListBinding v4 = v();
            if (v4 != null && (bGABanner = v4.b) != null) {
                bGABanner.setAutoPlayAble(false);
            }
        }
        FragmentYyChatRoomListBinding v5 = v();
        if (v5 == null || (bGABanner2 = v5.b) == null) {
            return;
        }
        bGABanner2.a(R.layout.item_more_adpics, list, (List<String>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
    }

    private final void c(List<? extends HomeTopicModel> list) {
        YYHomeTabView yYHomeTabView;
        YYHomeTabView yYHomeTabView2;
        int a2 = a(list, j().d());
        this.g = list;
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (yYHomeTabView2 = v.k) != null) {
            FragmentYyChatRoomListBinding v2 = v();
            ViewPager viewPager = v2 == null ? null : v2.i;
            Intrinsics.a(viewPager);
            Intrinsics.c(viewPager, "vb?.roomViewPager!!");
            yYHomeTabView2.a(viewPager);
        }
        FragmentYyChatRoomListBinding v3 = v();
        if (v3 != null && (yYHomeTabView = v3.k) != null) {
            yYHomeTabView.setData(list);
        }
        Intrinsics.a(list);
        a(list, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0.getCount() <= 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(boolean r4) {
        /*
            r3 = this;
            r0 = r3
            com.blued.android.module.yy_china.adapter.YYRoomPagerAdapter r0 = r0.n
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L14
            r0 = r5
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r5
            int r0 = r0.getCount()
            if (r0 > 0) goto L4f
        L14:
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyChatRoomListBinding r0 = r0.v()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L20
            goto L30
        L20:
            r0 = r5
            com.blued.android.module.common.view.NoDataAndLoadFailView r0 = r0.f
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L2c
            goto L30
        L2c:
            r0 = r5
            r0.a()
        L30:
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyChatRoomListBinding r0 = r0.v()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L3e
            r0 = 0
            r5 = r0
            goto L43
        L3e:
            r0 = r5
            com.blued.android.module.common.view.NoDataAndLoadFailView r0 = r0.f
            r5 = r0
        L43:
            r0 = r5
            if (r0 != 0) goto L4a
            goto L4f
        L4a:
            r0 = r5
            r1 = 0
            r0.setVisibility(r1)
        L4f:
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyChatRoomListBinding r0 = r0.v()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L5b
            goto L6c
        L5b:
            r0 = r5
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.g
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L67
            goto L6c
        L67:
            r0 = r5
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.j()
        L6c:
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyChatRoomListBinding r0 = r0.v()
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L76
            return
        L76:
            r0 = r5
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.g
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L80
            return
        L80:
            r0 = r5
            r1 = 0
            com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = r0.l(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment.c(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (noDataAndLoadFailView = v.f) != null) {
            noDataAndLoadFailView.a();
        }
        FragmentYyChatRoomListBinding v2 = v();
        NoDataAndLoadFailView noDataAndLoadFailView2 = v2 == null ? null : v2.f;
        if (noDataAndLoadFailView2 != null) {
            noDataAndLoadFailView2.setVisibility(0);
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(YYChatRoomsListFragment this$0) {
        RelativeLayout relativeLayout;
        Intrinsics.e(this$0, "this$0");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this$0.a(R.dimen.dp_170), this$0.a(R.dimen.dp_35));
        layoutParams.topMargin = this$0.a(R.dimen.dp_8);
        layoutParams.leftMargin = 10;
        FragmentYyChatRoomListBinding v = this$0.v();
        RelativeLayout relativeLayout2 = v == null ? null : v.h;
        if (relativeLayout2 != null) {
            relativeLayout2.setClipChildren(false);
        }
        FragmentYyChatRoomListBinding v2 = this$0.v();
        if (v2 != null && (relativeLayout = v2.h) != null) {
            relativeLayout.addView(this$0.l, layoutParams);
        }
        GuideHandler guideHandler = this$0.e;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(2, 5000L);
        }
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_OPEN_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentYyChatRoomListBinding v() {
        return (FragmentYyChatRoomListBinding) this.f17121c.b(this, b[0]);
    }

    private final void w() {
        BGABanner bGABanner;
        BGABanner bGABanner2;
        BGABanner bGABanner3;
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (bGABanner3 = v.b) != null) {
            bGABanner3.setAdapter(this);
        }
        FragmentYyChatRoomListBinding v2 = v();
        if (v2 != null && (bGABanner2 = v2.b) != null) {
            bGABanner2.setAutoPlayAble(false);
        }
        FragmentYyChatRoomListBinding v3 = v();
        if (v3 == null || (bGABanner = v3.b) == null) {
            return;
        }
        bGABanner.setmIsNeedShowIndicator(false);
    }

    private final void x() {
        if (YYRoomInfoManager.e().c().l()) {
            AppMethods.a((CharSequence) getString(R.string.yy_living_toast));
        } else if (AudioChannelManager.j().n()) {
            AppMethods.a((CharSequence) getString(R.string.yy_in_room_toast));
        } else {
            PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$createNewRoom$1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    YYChatRoomsListViewModel j;
                    j = YYChatRoomsListFragment.this.j();
                    ActivityFragmentActive fragmentActive = YYChatRoomsListFragment.this.getFragmentActive();
                    Intrinsics.c(fragmentActive, "fragmentActive");
                    j.b(fragmentActive);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    Intrinsics.e(perms, "perms");
                    AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                }
            });
        }
    }

    private final void y() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (smartRefreshLayout2 = v.g) != null) {
            smartRefreshLayout2.j();
        }
        FragmentYyChatRoomListBinding v2 = v();
        if (v2 == null || (smartRefreshLayout = v2.g) == null) {
            return;
        }
        smartRefreshLayout.h();
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGABanner.Adapter
    public void a(BGABanner bGABanner, View view, Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.model.YYBannerModel");
        }
        final YYBannerModel yYBannerModel = (YYBannerModel) obj;
        final String str = yYBannerModel.target_url;
        List<String> list = yYBannerModel.show_url;
        ImageView imageView = view == null ? null : (ImageView) view.findViewById(R.id.img_ad);
        ImageView imageView2 = view == null ? null : (ImageView) view.findViewById(R.id.img_ad_icon);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageLoader.a(getFragmentActive(), yYBannerModel.ads_pics).b(R.drawable.defaultpicture).a(imageView);
        if (!yYBannerModel.isShowUrlVisited && list != null) {
            IYYRoomInfoCallback c2 = YYRoomInfoManager.e().c();
            Object[] array = list.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c2.a((String[]) array);
            yYBannerModel.isShowUrlVisited = true;
            EventTrackYY.b(ChatRoomProtos.Event.CHAT_ROOM_BANNER_SHOW, yYBannerModel.ads_id);
        }
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomsListFragment$qopqKBZV61w7e0NdO6eYRmr-amg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYChatRoomsListFragment.a(String.this, yYBannerModel, this, view2);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void a(String str, String str2) {
        YYRoomInfoManager.e().a((BaseFragmentActivity) getActivity(), str, str2);
        this.j = -10000;
        GuideHandler guideHandler = this.e;
        if (guideHandler == null || guideHandler == null) {
            return;
        }
        guideHandler.removeMessages(1);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        w();
        FragmentYyChatRoomListBinding v = v();
        if (v == null) {
            return;
        }
        ShapeTextView shapeTextView = v.m;
        YYChatRoomsListFragment yYChatRoomsListFragment = this;
        shapeTextView.setOnClickListener(yYChatRoomsListFragment);
        v.l.setOnClickListener(yYChatRoomsListFragment);
        v.n.setOnClickListener(yYChatRoomsListFragment);
        v.g.l(false);
        v.e.setOnClickListener(yYChatRoomsListFragment);
        v.g.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$initView$1$1
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                String str;
                YYChatRoomsListViewModel j;
                Intrinsics.e(refreshLayout, "refreshLayout");
                str = YYChatRoomsListFragment.this.d;
                Logger.e(str, "onRefresh ... ");
                j = YYChatRoomsListFragment.this.j();
                ActivityFragmentActive fragmentActive = YYChatRoomsListFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                j.a(fragmentActive);
            }
        });
        v.f.setBackgroundColorRes(R.color.transparent);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_ENTER_CLICK, "", "", "", j().e());
        YYChatRoomsListFragment yYChatRoomsListFragment = this;
        LiveEventBus.get("refresh_or_loadmore_finish", String.class).observe(yYChatRoomsListFragment, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomsListFragment$Vb6YY2KdhvTRmOA76VfZiKG8JL0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYChatRoomsListFragment.a(YYChatRoomsListFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("create_entertainment_room", String.class).observe(yYChatRoomsListFragment, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomsListFragment$F9JjtsJVpDvojltuDthnZ-hVlRQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYChatRoomsListFragment.b(YYChatRoomsListFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        YYChatRoomsListFragment yYChatRoomsListFragment = this;
        LifecycleExtKt.a(yYChatRoomsListFragment, j().l(), new YYChatRoomsListFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().g(), new YYChatRoomsListFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().f(), new YYChatRoomsListFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().h(), new YYChatRoomsListFragment$liveDataObserver$4(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().k(), new YYChatRoomsListFragment$liveDataObserver$5(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().o(), new YYChatRoomsListFragment$liveDataObserver$6(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().m(), new YYChatRoomsListFragment$liveDataObserver$7(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().p(), new YYChatRoomsListFragment$liveDataObserver$8(this));
        LifecycleExtKt.a(yYChatRoomsListFragment, j().n(), new YYChatRoomsListFragment$liveDataObserver$9(this));
        GuideHandler guideHandler = this.e;
        if (guideHandler != null) {
            guideHandler.sendEmptyMessageDelayed(1, 10000L);
        }
        YYNewUserGiftDialog.f18336a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            return;
        }
        if (i == 100) {
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("auth_upload_state", false);
                Log.i(this.d, Intrinsics.a("success:", (Object) Boolean.valueOf(booleanExtra)));
                if (booleanExtra) {
                    YYApplyFinishFragment.a(getContext(), 0);
                }
            }
        } else if (i == 10001 && intent != null) {
            FragmentYyChatRoomListBinding v = v();
            FrameLayout frameLayout = v == null ? null : v.d;
            if (frameLayout != null) {
                frameLayout.setClickable(true);
            }
            GuideHandler guideHandler = this.e;
            if (guideHandler != null) {
                guideHandler.sendEmptyMessageDelayed(3, 2000L);
            }
            String stringExtra = intent.getStringExtra("roomname");
            String stringExtra2 = intent.getStringExtra("imgBackground");
            a(String.valueOf(stringExtra), String.valueOf(intent.getStringExtra("typeId")), String.valueOf(stringExtra2), String.valueOf(intent.getStringExtra("labelId")), intent.getStringExtra("imgCover"), intent.getBooleanExtra("is_fans_notice", false), intent.getIntExtra("is_veiled", 0));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.ctt_left;
        if (valueOf != null && valueOf.intValue() == i) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        int i2 = R.id.tv_create_room_bottom;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (ClickUtils.a(R.id.tv_create_room_bottom, 2000L)) {
                return;
            }
            x();
            GuideHandler guideHandler = this.e;
            if (guideHandler == null || guideHandler == null) {
                return;
            }
            guideHandler.removeCallbacksAndMessages(null);
            return;
        }
        int i3 = R.id.tv_match_room;
        boolean z = true;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.tv_match_room_bottom;
            if (valueOf == null || valueOf.intValue() != i4) {
                z = false;
            }
        }
        if (!z) {
            int i5 = R.id.ll_red_envelope;
            if (valueOf == null || valueOf.intValue() != i5 || ClickUtils.a(R.id.tv_match_room, 2000L)) {
                return;
            }
            EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_REDBAG_CLICK);
            YYRedEnvRoomsFragment.b.a(getContext());
        } else if (ClickUtils.a(R.id.tv_match_room, 2000L)) {
        } else {
            YYChatRoomsListViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.d(fragmentActive);
            GuideHandler guideHandler2 = this.e;
            if (guideHandler2 == null || guideHandler2 == null) {
                return;
            }
            guideHandler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        YYRoomPagerAdapter yYRoomPagerAdapter = this.n;
        if (yYRoomPagerAdapter != null && yYRoomPagerAdapter != null) {
            yYRoomPagerAdapter.b();
        }
        GuideHandler guideHandler = this.e;
        if (guideHandler != null) {
            if (guideHandler != null) {
                guideHandler.removeCallbacksAndMessages(null);
            }
            this.e = null;
        }
        p = "";
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        FragmentYyChatRoomListBinding v = v();
        if (v == null || (smartRefreshLayout = v.g) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void p() {
        GuideHandler guideHandler;
        int i = this.j;
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        this.j = i + 1;
        LogUtils.d(this.d, Intrinsics.a("seeRoomsUpGuideNum: ", (Object) Integer.valueOf(i2)));
        if (i2 != 50 || (guideHandler = this.e) == null) {
            return;
        }
        guideHandler.sendEmptyMessage(1);
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void q() {
        SmartRefreshLayout smartRefreshLayout;
        if (this.m) {
            return;
        }
        this.m = true;
        ShapeAppearanceModel.Builder builder = ShapeAppearanceModel.builder();
        builder.setAllCorners(new RoundedCornerTreatment());
        builder.setAllCornerSizes(a(R.dimen.dp_7));
        final float a2 = a(R.dimen.dp_7);
        builder.setTopEdge(new TriangleEdgeTreatment(a2) { // from class: com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment$addMyGuide$shapeAppearanceModel3$1$1
            @Override // com.google.android.material.shape.TriangleEdgeTreatment, com.google.android.material.shape.EdgeTreatment
            public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
                int a3;
                Intrinsics.e(shapePath, "shapePath");
                a3 = YYChatRoomsListFragment.this.a(R.dimen.dp_15);
                super.getEdgePath(f, a3, f3, shapePath);
            }
        });
        ShapeAppearanceModel build = builder.build();
        Intrinsics.c(build, "builder().apply {\n      …     })\n        }.build()");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        materialShapeDrawable.setTint(ContextCompat.getColor(requireContext(), R.color.syc_474D55));
        materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        TextView textView = new TextView(getContext());
        this.l = textView;
        if (textView != null) {
            textView.setTextSize(14.0f);
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setGravity(17);
        }
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(R.color.syc_FAFAFA));
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setBackgroundDrawable(materialShapeDrawable);
        }
        TextView textView5 = this.l;
        if (textView5 != null) {
            textView5.setText("你关注的房主正在开播");
        }
        FragmentYyChatRoomListBinding v = v();
        if (v == null || (smartRefreshLayout = v.g) == null) {
            return;
        }
        smartRefreshLayout.post(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYChatRoomsListFragment$ngNCZ0CAHwnpZrk5FvpMhF2TLF0
            @Override // java.lang.Runnable
            public final void run() {
                YYChatRoomsListFragment.h(YYChatRoomsListFragment.this);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener
    public void r() {
    }

    public final void s() {
        RelativeLayout relativeLayout;
        TextView textView = this.l;
        if (textView == null) {
            return;
        }
        FragmentYyChatRoomListBinding v = v();
        if (v != null && (relativeLayout = v.h) != null) {
            relativeLayout.removeView(textView);
        }
        this.l = null;
    }

    @Override // com.blued.android.module.yy_china.listener.OnClickHintFragmentLister
    public void t() {
        YYLiveState yYLiveState = this.h;
        if (yYLiveState == null) {
            YYChatRoomsListViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.b(fragmentActive);
            return;
        }
        Intrinsics.a(yYLiveState);
        yYLiveState.is_read_norms = 1;
        YYLiveState yYLiveState2 = this.h;
        Intrinsics.a(yYLiveState2);
        a(yYLiveState2);
        this.h = null;
    }
}
