package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyFullServiceSquareBinding;
import com.blued.android.module.yy_china.databinding.ItemFullServiceSquareAchieBinding;
import com.blued.android.module.yy_china.databinding.ItemFullServiceSquareAllgiftBinding;
import com.blued.android.module.yy_china.databinding.ItemFullServiceSquareBinding;
import com.blued.android.module.yy_china.databinding.ItemFullServiceSquareGiftBinding;
import com.blued.android.module.yy_china.fragment.YYFullServiceSquareFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.FullServiceSquareMode;
import com.blued.android.module.yy_china.model.FullServiceSquareResourcesMode;
import com.blued.android.module.yy_china.model.YYJoinRoomJumpInfoMode;
import com.blued.android.module.yy_china.presenter.FullServiceSquarePresenter;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFullServiceSquareFragment.class */
public final class YYFullServiceSquareFragment extends MvpFragment<FullServiceSquarePresenter> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17240a = new Companion(null);
    private FragmentYyFullServiceSquareBinding b;

    /* renamed from: c  reason: collision with root package name */
    private final Ad f17241c = new Ad(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFullServiceSquareFragment$Ad.class */
    public static final class Ad extends BaseMultiItemQuickAdapter<FullServiceSquareMode, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        private final BaseFragment f17242a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(BaseFragment fra) {
            super(new ArrayList());
            Intrinsics.e(fra, "fra");
            this.f17242a = fra;
            addItemType(1, R.layout.item_full_service_square_achie);
            addItemType(2, R.layout.item_full_service_square_gift);
            addItemType(3, R.layout.item_full_service_square_allgift);
            addItemType(4, R.layout.item_full_service_square);
        }

        private final String a(Context context, String str, Paint paint) {
            String str2 = str;
            if (paint != null) {
                str2 = str;
                if (str != null) {
                    str2 = str;
                    if (str.length() > 0) {
                        float measureText = paint.measureText(str);
                        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.dp_80);
                        str2 = str;
                        if (measureText > dimensionPixelOffset) {
                            int length = ((int) (str.length() * (dimensionPixelOffset / measureText))) - 2;
                            str2 = str;
                            if (length > 0) {
                                str2 = str;
                                if (length < str.length()) {
                                    String substring = str.substring(0, length);
                                    Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                    str2 = Intrinsics.a(substring, (Object) "...");
                                }
                            }
                        }
                    }
                }
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(FullServiceSquareMode item, View view) {
            Intrinsics.e(item, "$item");
            FullServiceSquareResourcesMode extra_resources = item.getExtra_resources();
            if (extra_resources != null && extra_resources.getType() == 1) {
                YYRoomInfoManager.e().c().a(view.getContext(), YYRoomInfoManager.e().c(7), 0, true);
            } else {
                YYRoomInfoManager.e().c().a(view.getContext(), YYRoomInfoManager.e().c(8), 0, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(FullServiceSquareMode item, Ad this$0, View view) {
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$0, "this$0");
            if (item.is_voice_online() != 1 || StringUtils.a(item.getRoom_id(), 0) <= 0) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) this$0.f17242a.getActivity(), item.getRoom_id(), "all_square", false, "", YYJoinRoomJumpInfoMode.Companion.a(YYJoinRoomJumpInfoMode.Companion.b(), item.getUid()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(FullServiceSquareResourcesMode e, Ad this$0, View view) {
            Intrinsics.e(e, "$e");
            Intrinsics.e(this$0, "this$0");
            if (e.is_voice_online() != 1 || StringUtils.a(e.getRoom_id(), 0) <= 0) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) this$0.f17242a.getActivity(), e.getRoom_id(), "all_square");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FullServiceSquareMode item, Ad this$0, View view) {
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$0, "this$0");
            if (item.is_voice_online() != 1 || StringUtils.a(item.getRoom_id(), 0) <= 0) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) this$0.f17242a.getActivity(), item.getRoom_id(), "all_square");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FullServiceSquareResourcesMode e, Ad this$0, View view) {
            Intrinsics.e(e, "$e");
            Intrinsics.e(this$0, "this$0");
            if (e.is_voice_online() != 1 || StringUtils.a(e.getRoom_id(), 0) <= 0) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) this$0.f17242a.getActivity(), e.getRoom_id(), "all_square");
        }

        private final void b(BaseViewHolder baseViewHolder, final FullServiceSquareMode fullServiceSquareMode) {
            ItemFullServiceSquareGiftBinding a2 = ItemFullServiceSquareGiftBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            ImageLoader.a(this.f17242a.getFragmentActive(), fullServiceSquareMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a2.f16598c);
            a2.g.setText(fullServiceSquareMode.getName());
            YYLivingStreamView yYLivingStreamView = a2.d;
            ActivityFragmentActive fragmentActive = a().getFragmentActive();
            Intrinsics.c(fragmentActive, "fra.fragmentActive");
            yYLivingStreamView.a(fragmentActive);
            a2.d.setVisibility(fullServiceSquareMode.is_voice_online() == 1 ? 0 : 8);
            FullServiceSquareResourcesMode extra_resources = fullServiceSquareMode.getExtra_resources();
            if (extra_resources != null) {
                ImageLoader.a(a().getFragmentActive(), extra_resources.getBadge()).a(a2.b);
                if (extra_resources.getType() == 1) {
                    a2.f.setText(Html.fromHtml("在聊天室已解锁<font color=#222222>新锐收藏家</font>"));
                } else {
                    a2.f.setText(Html.fromHtml("在聊天室已解锁<font color=#222222>精英收藏家</font>"));
                }
            }
            a2.f16598c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$ghe1jogTbsDSV2GXWppFRteoUec
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.a(FullServiceSquareMode.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(FullServiceSquareMode item, Ad this$0, View view) {
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$0, "this$0");
            if (item.is_voice_online() != 1 || StringUtils.a(item.getRoom_id(), 0) <= 0) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) this$0.f17242a.getActivity(), item.getRoom_id(), "all_square");
        }

        private final void c(BaseViewHolder baseViewHolder, final FullServiceSquareMode fullServiceSquareMode) {
            ItemFullServiceSquareBinding a2 = ItemFullServiceSquareBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            ImageLoader.a(this.f17242a.getFragmentActive(), fullServiceSquareMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a2.d);
            YYLivingStreamView yYLivingStreamView = a2.f;
            ActivityFragmentActive fragmentActive = this.f17242a.getFragmentActive();
            Intrinsics.c(fragmentActive, "fra.fragmentActive");
            yYLivingStreamView.a(fragmentActive);
            a2.f.setVisibility(fullServiceSquareMode.is_voice_online() == 1 ? 0 : 8);
            final FullServiceSquareResourcesMode extra_resources = fullServiceSquareMode.getExtra_resources();
            ImageLoader.a(a().getFragmentActive(), extra_resources.getTarget_avatar()).b(R.drawable.user_bg_round).c().a(a2.e);
            ImageLoader.a(a().getFragmentActive(), extra_resources.getGift_pic()).a(a2.f16596c);
            YYLivingStreamView yYLivingStreamView2 = a2.g;
            ActivityFragmentActive fragmentActive2 = a().getFragmentActive();
            Intrinsics.c(fragmentActive2, "fra.fragmentActive");
            yYLivingStreamView2.a(fragmentActive2);
            a2.g.setVisibility(extra_resources.is_voice_online() == 1 ? 0 : 8);
            TextView textView = a2.h;
            StringBuilder sb = new StringBuilder();
            Context context = a2.f16596c.getContext();
            Intrinsics.c(context, "bind.ivAllgiftGift.context");
            sb.append((Object) a(context, fullServiceSquareMode.getName(), a2.h.getPaint()));
            sb.append("<font color=#222222> 浪漫告白了 </font>");
            Context context2 = a2.f16596c.getContext();
            Intrinsics.c(context2, "bind.ivAllgiftGift.context");
            sb.append((Object) a(context2, extra_resources.getTarget_name(), a2.h.getPaint()));
            textView.setText(Html.fromHtml(sb.toString()));
            a2.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$wn04LG8hSi3_MxW5Ctex3Nto7rg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.a(FullServiceSquareResourcesMode.this, this, view);
                }
            });
            a2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$BhFQp4MsTeiAc9rUoZMzZMloN3M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.b(FullServiceSquareMode.this, this, view);
                }
            });
        }

        private final void d(BaseViewHolder baseViewHolder, final FullServiceSquareMode fullServiceSquareMode) {
            ItemFullServiceSquareAllgiftBinding a2 = ItemFullServiceSquareAllgiftBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            ImageLoader.a(this.f17242a.getFragmentActive(), fullServiceSquareMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a2.d);
            YYLivingStreamView yYLivingStreamView = a2.f;
            ActivityFragmentActive fragmentActive = this.f17242a.getFragmentActive();
            Intrinsics.c(fragmentActive, "fra.fragmentActive");
            yYLivingStreamView.a(fragmentActive);
            a2.f.setVisibility(fullServiceSquareMode.is_voice_online() == 1 ? 0 : 8);
            final FullServiceSquareResourcesMode extra_resources = fullServiceSquareMode.getExtra_resources();
            ImageLoader.a(a().getFragmentActive(), extra_resources.getTarget_avatar()).b(R.drawable.user_bg_round).c().a(a2.e);
            ImageLoader.a(a().getFragmentActive(), extra_resources.getGift_pic()).a(a2.f16594c);
            YYLivingStreamView yYLivingStreamView2 = a2.g;
            ActivityFragmentActive fragmentActive2 = a().getFragmentActive();
            Intrinsics.c(fragmentActive2, "fra.fragmentActive");
            yYLivingStreamView2.a(fragmentActive2);
            a2.g.setVisibility(extra_resources.is_voice_online() == 1 ? 0 : 8);
            TextView textView = a2.h;
            StringBuilder sb = new StringBuilder();
            Context context = a2.f16594c.getContext();
            Intrinsics.c(context, "bind.ivAllgiftGift.context");
            sb.append((Object) a(context, fullServiceSquareMode.getName(), a2.h.getPaint()));
            sb.append("<font color=#222222> 送给 </font>");
            Context context2 = a2.f16594c.getContext();
            Intrinsics.c(context2, "bind.ivAllgiftGift.context");
            sb.append((Object) a(context2, extra_resources.getTarget_name(), a2.h.getPaint()));
            sb.append("<font color=#222222> ");
            sb.append(extra_resources.getGift_name());
            sb.append("</font>");
            textView.setText(Html.fromHtml(sb.toString()));
            a2.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$pYKqnaWMa1puZZhMbMCVCMls76I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.b(FullServiceSquareResourcesMode.this, this, view);
                }
            });
            a2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$8Wxc0FtfKhHCMOeyAXHzIlIyUtU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.c(FullServiceSquareMode.this, this, view);
                }
            });
        }

        private final void e(BaseViewHolder baseViewHolder, final FullServiceSquareMode fullServiceSquareMode) {
            ItemFullServiceSquareAchieBinding a2 = ItemFullServiceSquareAchieBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            ImageLoader.a(this.f17242a.getFragmentActive(), fullServiceSquareMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a2.f16592c);
            a2.f.setText(fullServiceSquareMode.getName());
            YYLivingStreamView yYLivingStreamView = a2.d;
            ActivityFragmentActive fragmentActive = a().getFragmentActive();
            Intrinsics.c(fragmentActive, "fra.fragmentActive");
            yYLivingStreamView.a(fragmentActive);
            a2.d.setVisibility(fullServiceSquareMode.is_voice_online() == 1 ? 0 : 8);
            FullServiceSquareResourcesMode extra_resources = fullServiceSquareMode.getExtra_resources();
            if (extra_resources != null) {
                ImageLoader.a(a().getFragmentActive(), extra_resources.getBadge()).a(a2.b);
                if (extra_resources.getType() == 1) {
                    TextView textView = a2.e;
                    textView.setText(Html.fromHtml("在聊天室荣誉等级升级至<font color=#222222>Lv." + extra_resources.getLevel() + "</font>"));
                } else {
                    TextView textView2 = a2.e;
                    textView2.setText(Html.fromHtml("在聊天室主播等级升级至<font color=#222222>Lv." + extra_resources.getLevel() + "</font>"));
                }
            }
            a2.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$Ad$N3IDQEkSn-WXZ9HWq-cx-15Af7Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.Ad.a(FullServiceSquareMode.this, view);
                }
            });
        }

        public final BaseFragment a() {
            return this.f17242a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, FullServiceSquareMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 1) {
                e(helper, item);
            } else if (itemType == 2) {
                b(helper, item);
            } else if (itemType == 3) {
                d(helper, item);
            } else if (itemType != 4) {
            } else {
                c(helper, item);
            }
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFullServiceSquareFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            TerminalActivity.a(bundle);
            TerminalActivity.b(bundle);
            TerminalActivity.d(context, YYFullServiceSquareFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFullServiceSquareFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomInfoManager.e().c().a(this$0.getContext(), YYRoomInfoManager.e().c(12), 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYFullServiceSquareFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    private final void b(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        NoDataAndLoadFailView noDataAndLoadFailView3;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding = this.b;
        if (fragmentYyFullServiceSquareBinding != null && (smartRefreshLayout2 = fragmentYyFullServiceSquareBinding.d) != null) {
            smartRefreshLayout2.j();
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding2 = this.b;
        if (fragmentYyFullServiceSquareBinding2 != null && (smartRefreshLayout = fragmentYyFullServiceSquareBinding2.d) != null) {
            smartRefreshLayout.h();
        }
        if (this.f17241c.getData().size() > 0) {
            FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding3 = this.b;
            if (fragmentYyFullServiceSquareBinding3 == null || (noDataAndLoadFailView = fragmentYyFullServiceSquareBinding3.b) == null) {
                return;
            }
            noDataAndLoadFailView.d();
            return;
        }
        Log.e("HttpManager", Intrinsics.a("onUIUpdate: ", (Object) Boolean.valueOf(z)));
        if (z) {
            FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding4 = this.b;
            if (fragmentYyFullServiceSquareBinding4 == null || (noDataAndLoadFailView3 = fragmentYyFullServiceSquareBinding4.b) == null) {
                return;
            }
            noDataAndLoadFailView3.a();
            return;
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding5 = this.b;
        if (fragmentYyFullServiceSquareBinding5 == null || (noDataAndLoadFailView2 = fragmentYyFullServiceSquareBinding5.b) == null) {
            return;
        }
        noDataAndLoadFailView2.b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List<?> list) {
        super.a(str, list);
        if (Intrinsics.a((Object) str, (Object) j().m())) {
            MvpUtils.a(list, FullServiceSquareMode.class, new MvpUtils.DataListHandler<FullServiceSquareMode>() { // from class: com.blued.android.module.yy_china.fragment.YYFullServiceSquareFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<FullServiceSquareMode> list2) {
                    YYFullServiceSquareFragment.Ad ad;
                    Intrinsics.e(list2, "list");
                    ad = YYFullServiceSquareFragment.this.f17241c;
                    ad.setNewData(list2);
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        if (Intrinsics.a((Object) str, (Object) "_load_type_refresh_") ? true : Intrinsics.a((Object) str, (Object) "_load_type_loadmore_")) {
            b(z);
        }
    }

    public final void b() {
        SmartRefreshLayout smartRefreshLayout;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        CommonTopTitleNoTrans commonTopTitleNoTrans3;
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        CommonTopTitleNoTrans commonTopTitleNoTrans4;
        LinearLayout titleBackground;
        FragmentYyFullServiceSquareBinding a2 = FragmentYyFullServiceSquareBinding.a(this.i);
        this.b = a2;
        if (a2 != null && (commonTopTitleNoTrans4 = a2.e) != null && (titleBackground = commonTopTitleNoTrans4.getTitleBackground()) != null) {
            titleBackground.setBackgroundResource(R.color.transparent);
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding = this.b;
        if (fragmentYyFullServiceSquareBinding != null && (noDataAndLoadFailView2 = fragmentYyFullServiceSquareBinding.b) != null) {
            noDataAndLoadFailView2.setNoDataStr(R.string.yy_no_data);
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding2 = this.b;
        if (fragmentYyFullServiceSquareBinding2 != null && (noDataAndLoadFailView = fragmentYyFullServiceSquareBinding2.b) != null) {
            noDataAndLoadFailView.setFailImg(R.drawable.icon_no_data_common);
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding3 = this.b;
        RecyclerView recyclerView = fragmentYyFullServiceSquareBinding3 == null ? null : fragmentYyFullServiceSquareBinding3.f16500c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding4 = this.b;
        RecyclerView recyclerView2 = fragmentYyFullServiceSquareBinding4 == null ? null : fragmentYyFullServiceSquareBinding4.f16500c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f17241c);
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding5 = this.b;
        if (fragmentYyFullServiceSquareBinding5 != null && (commonTopTitleNoTrans3 = fragmentYyFullServiceSquareBinding5.e) != null) {
            commonTopTitleNoTrans3.setCenterText("全服广场");
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding6 = this.b;
        if (fragmentYyFullServiceSquareBinding6 != null && (commonTopTitleNoTrans2 = fragmentYyFullServiceSquareBinding6.e) != null) {
            commonTopTitleNoTrans2.setRightClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$HlFVrofT0bOi-uHF3FyEyNrAfXo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.a(YYFullServiceSquareFragment.this, view);
                }
            });
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding7 = this.b;
        if (fragmentYyFullServiceSquareBinding7 != null && (commonTopTitleNoTrans = fragmentYyFullServiceSquareBinding7.e) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFullServiceSquareFragment$IG28tX4t1x41q4pKm26BmdqcvlQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFullServiceSquareFragment.b(YYFullServiceSquareFragment.this, view);
                }
            });
        }
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding8 = this.b;
        if (fragmentYyFullServiceSquareBinding8 == null || (smartRefreshLayout = fragmentYyFullServiceSquareBinding8.d) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYFullServiceSquareFragment$initView$3
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYFullServiceSquareFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYFullServiceSquareFragment.this.j().e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_full_service_square;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding = this.b;
        if (fragmentYyFullServiceSquareBinding == null || (smartRefreshLayout = fragmentYyFullServiceSquareBinding.d) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding = this.b;
        if (fragmentYyFullServiceSquareBinding == null || (smartRefreshLayout = fragmentYyFullServiceSquareBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentYyFullServiceSquareBinding fragmentYyFullServiceSquareBinding = this.b;
        if (fragmentYyFullServiceSquareBinding == null || (smartRefreshLayout = fragmentYyFullServiceSquareBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }
}
