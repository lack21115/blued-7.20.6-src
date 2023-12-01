package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyRelationshipRankBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationRankBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationRankTopBinding;
import com.blued.android.module.yy_china.fragment.YYRelationShipRankItemFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomLevelInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomRank;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserLeveLInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.presenter.YYRelationShipRankItemPresenter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRelationShipRankItemFragment.class */
public final class YYRelationShipRankItemFragment extends MvpFragment<YYRelationShipRankItemPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private FragmentYyRelationshipRankBinding f17428a;
    private final RelationShipRankAdapter b = new RelationShipRankAdapter(this);

    /* renamed from: c  reason: collision with root package name */
    private YYRelationShipRoomMode f17429c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRelationShipRankItemFragment$RelationShipRankAdapter.class */
    public final class RelationShipRankAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomRank, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRelationShipRankItemFragment f17430a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RelationShipRankAdapter(YYRelationShipRankItemFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17430a = this$0;
            addItemType(2, R.layout.item_yy_relation_rank_bottom);
            addItemType(1, R.layout.item_yy_relation_rank_top);
            addItemType(0, R.layout.item_yy_relation_rank);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getUid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getTarge_uid_profile().getRoom_id());
        }

        private final void b(BaseViewHolder baseViewHolder, YYRelationShipRoomRank yYRelationShipRoomRank) {
            ItemYyRelationRankTopBinding a2 = ItemYyRelationRankTopBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.p.setVisibility(4);
            a2.q.setVisibility(4);
            a2.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$HQUxA7OtSVmfMvDJ8ug8KXMvbbU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.a(view);
                }
            });
            a2.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$AG0V7dOIgi6vzgr9m6RtTrPPNsc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.b(view);
                }
            });
            a2.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$WIctC_hvrTZNNz4U6-s22I3CcHk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.c(view);
                }
            });
            a2.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$qD7PFAMoA5Nub4NsD_kKgxQKMRk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.d(view);
                }
            });
            a2.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$6pjV1o_CIMs9fEQV-x-j0dsewQo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.e(view);
                }
            });
            a2.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$qz1ckJVmTgppU5fAQJcry4oqIFE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.f(view);
                }
            });
            a2.j.setVisibility(8);
            a2.k.setVisibility(8);
            a2.l.setVisibility(8);
            a2.m.setVisibility(8);
            a2.n.setVisibility(8);
            a2.o.setVisibility(8);
            if (yYRelationShipRoomRank.getList().size() > 0) {
                YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = yYRelationShipRoomRank.getList().get(0);
                Intrinsics.c(yYRelationShipRoomUserCardInfoMode, "item.list[0]");
                final YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode2 = yYRelationShipRoomUserCardInfoMode;
                if (yYRelationShipRoomUserCardInfoMode2.is_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode2.getUid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.d);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode2.getUid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.d);
                }
                if (yYRelationShipRoomUserCardInfoMode2.getTarget_uid_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode2.getTarge_uid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.e);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode2.getTarge_uid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.e);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode2.getUid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode2.is_hidden() != 1) {
                    ShapeableImageView shapeableImageView = a2.d;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment = this.f17430a;
                    shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$FPVZlAnCwCMrDNg3Aptw73e1A4A
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.a(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode2, view);
                        }
                    });
                    a2.j.setVisibility(0);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode2.getTarge_uid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode2.getTarget_uid_hidden() != 1) {
                    ShapeableImageView shapeableImageView2 = a2.e;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment2 = this.f17430a;
                    shapeableImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$0sdDqrZ-7wpGboKquMc8eGEvLok
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.b(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode2, view);
                        }
                    });
                    a2.k.setVisibility(0);
                }
                a2.s.setText(CommonStringUtils.d(StringUtils.a(yYRelationShipRoomUserCardInfoMode2.getScore(), 0.0d)));
                YYRelationShipRoomUserLeveLInfoMode level_info = yYRelationShipRoomUserCardInfoMode2.getLevel_info();
                if (level_info != null) {
                    TextView textView = a2.r;
                    textView.setText("LV." + level_info.getCurrent_level() + ' ' + level_info.getLevel_name() + " x" + yYRelationShipRoomUserCardInfoMode2.getDay() + (char) 22825);
                }
            }
            if (yYRelationShipRoomRank.getList().size() > 1) {
                a2.p.setVisibility(0);
                YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode3 = yYRelationShipRoomRank.getList().get(1);
                Intrinsics.c(yYRelationShipRoomUserCardInfoMode3, "item.list[1]");
                final YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode4 = yYRelationShipRoomUserCardInfoMode3;
                if (yYRelationShipRoomUserCardInfoMode4.is_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode4.getUid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.f);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode4.getUid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.f);
                }
                if (yYRelationShipRoomUserCardInfoMode4.getTarget_uid_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode4.getTarge_uid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.g);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode4.getTarge_uid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.g);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode4.getUid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode4.is_hidden() != 1) {
                    ShapeableImageView shapeableImageView3 = a2.f;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment3 = this.f17430a;
                    shapeableImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$MzGnKgCUP0qQu2SygDYpNnWVbdc
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.c(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode4, view);
                        }
                    });
                    a2.l.setVisibility(0);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode4.getTarge_uid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode4.getTarget_uid_hidden() != 1) {
                    ShapeableImageView shapeableImageView4 = a2.g;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment4 = this.f17430a;
                    shapeableImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$pCjI8G-epcvyJLcaBhZGlMkX_sY
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.d(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode4, view);
                        }
                    });
                    a2.m.setVisibility(0);
                }
                a2.u.setText(CommonStringUtils.d(StringUtils.a(yYRelationShipRoomUserCardInfoMode4.getScore(), 0.0d)));
                YYRelationShipRoomUserLeveLInfoMode level_info2 = yYRelationShipRoomUserCardInfoMode4.getLevel_info();
                if (level_info2 != null) {
                    TextView textView2 = a2.t;
                    textView2.setText("LV." + level_info2.getCurrent_level() + ' ' + level_info2.getLevel_name() + " x" + yYRelationShipRoomUserCardInfoMode4.getDay() + (char) 22825);
                }
            }
            if (yYRelationShipRoomRank.getList().size() > 2) {
                a2.q.setVisibility(0);
                YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode5 = yYRelationShipRoomRank.getList().get(2);
                Intrinsics.c(yYRelationShipRoomUserCardInfoMode5, "item.list[2]");
                final YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode6 = yYRelationShipRoomUserCardInfoMode5;
                if (yYRelationShipRoomUserCardInfoMode6.is_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode6.getUid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.h);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode6.getUid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.h);
                }
                if (yYRelationShipRoomUserCardInfoMode6.getTarget_uid_hidden() == 1) {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode6.getTarge_uid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.i);
                } else {
                    ImageLoader.a(this.f17430a.getFragmentActive(), yYRelationShipRoomUserCardInfoMode6.getTarge_uid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.i);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode6.getUid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode6.is_hidden() != 1) {
                    ShapeableImageView shapeableImageView5 = a2.h;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment5 = this.f17430a;
                    shapeableImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$sis2nymyWito30E09CTEkbXVIWs
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.e(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode6, view);
                        }
                    });
                    a2.n.setVisibility(0);
                }
                if (!StringUtils.a("0", yYRelationShipRoomUserCardInfoMode6.getTarge_uid_profile().getRoom_id()) && yYRelationShipRoomUserCardInfoMode6.getTarget_uid_hidden() != 1) {
                    ShapeableImageView shapeableImageView6 = a2.i;
                    final YYRelationShipRankItemFragment yYRelationShipRankItemFragment6 = this.f17430a;
                    shapeableImageView6.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$VYTVKhISmJSo6fqpORe1KNkgI-s
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            YYRelationShipRankItemFragment.RelationShipRankAdapter.f(YYRelationShipRankItemFragment.this, yYRelationShipRoomUserCardInfoMode6, view);
                        }
                    });
                    a2.o.setVisibility(0);
                }
                a2.x.setText(CommonStringUtils.d(StringUtils.a(yYRelationShipRoomUserCardInfoMode6.getScore(), 0.0d)));
                YYRelationShipRoomUserLeveLInfoMode level_info3 = yYRelationShipRoomUserCardInfoMode6.getLevel_info();
                if (level_info3 == null) {
                    return;
                }
                TextView textView3 = a2.w;
                textView3.setText("LV." + level_info3.getCurrent_level() + ' ' + level_info3.getLevel_name() + " x" + yYRelationShipRoomUserCardInfoMode6.getDay() + (char) 22825);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getUid_profile().getRoom_id());
        }

        private final void c(BaseViewHolder baseViewHolder, YYRelationShipRoomRank yYRelationShipRoomRank) {
            ArrayList<YYRelationShipRoomLevelInfoMode> level_info;
            YYRelationShipRoomLevelInfoMode yYRelationShipRoomLevelInfoMode;
            ItemYyRelationRankBinding a2 = ItemYyRelationRankBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.f16788a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$qH2LdHeJNo4-pSjk5XtpIhXNT0o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.g(view);
                }
            });
            a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$kQ8VOPtFTnL5r3ppZXNU5G3V0zY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter.h(view);
                }
            });
            a2.f16789c.setVisibility(8);
            a2.d.setVisibility(8);
            final YYRelationShipRoomUserCardInfoMode da = yYRelationShipRoomRank.getDa();
            if (da == null) {
                return;
            }
            final YYRelationShipRankItemFragment yYRelationShipRankItemFragment = this.f17430a;
            if (da.is_hidden() == 1) {
                ImageLoader.a(yYRelationShipRankItemFragment.getFragmentActive(), da.getUid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.f16788a);
            } else {
                ImageLoader.a(yYRelationShipRankItemFragment.getFragmentActive(), da.getUid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.f16788a);
            }
            if (da.getTarget_uid_hidden() == 1) {
                ImageLoader.a(yYRelationShipRankItemFragment.getFragmentActive(), da.getTarge_uid_profile().getAvatar()).a(100).c().b(R.drawable.user_bg_round).a(a2.b);
            } else {
                ImageLoader.a(yYRelationShipRankItemFragment.getFragmentActive(), da.getTarge_uid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(a2.b);
            }
            a2.f16789c.setVisibility(8);
            a2.d.setVisibility(8);
            if (!StringUtils.a("0", da.getUid_profile().getRoom_id()) && da.is_hidden() != 1) {
                a2.f16788a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$_Drv7X95EyNDc0K-3CjsA-ixlME
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYRelationShipRankItemFragment.RelationShipRankAdapter.g(YYRelationShipRankItemFragment.this, da, view);
                    }
                });
                a2.f16789c.setVisibility(0);
            }
            if (!StringUtils.a("0", da.getTarge_uid_profile().getRoom_id()) && da.getTarget_uid_hidden() != 1) {
                a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRelationShipRankItemFragment$RelationShipRankAdapter$xbrO9T0HGB6fqiof3lU9HG3lqM4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYRelationShipRankItemFragment.RelationShipRankAdapter.h(YYRelationShipRankItemFragment.this, da, view);
                    }
                });
                a2.d.setVisibility(0);
            }
            a2.i.setText(CommonStringUtils.d(StringUtils.a(da.getScore(), 0.0d)));
            YYRelationShipRoomUserLeveLInfoMode level_info2 = da.getLevel_info();
            if (level_info2 != null) {
                TextView textView = a2.g;
                textView.setText("Lv." + level_info2.getCurrent_level() + ' ');
                TextView textView2 = a2.h;
                StringBuilder sb = new StringBuilder();
                YYRelationShipRoomMode b = yYRelationShipRankItemFragment.b();
                String str = null;
                if (b != null && (level_info = b.getLevel_info()) != null && (yYRelationShipRoomLevelInfoMode = level_info.get(level_info2.getCurrent_level())) != null) {
                    str = yYRelationShipRoomLevelInfoMode.getAlias();
                }
                sb.append((Object) str);
                sb.append(" x");
                sb.append(da.getDay());
                sb.append((char) 22825);
                textView2.setText(sb.toString());
            }
            a2.e.setText(String.valueOf(getData().indexOf(yYRelationShipRoomRank) + 3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getTarge_uid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getUid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getTarge_uid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getUid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(YYRelationShipRankItemFragment this$0, YYRelationShipRoomUserCardInfoMode mode, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(mode, "$mode");
            this$0.c(mode.getTarge_uid_profile().getRoom_id());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomRank item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                c(helper, item);
            } else if (itemType != 1) {
            } else {
                b(helper, item);
            }
        }
    }

    private final void b(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding = this.f17428a;
        if (fragmentYyRelationshipRankBinding != null && (smartRefreshLayout2 = fragmentYyRelationshipRankBinding.d) != null) {
            smartRefreshLayout2.j();
        }
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding2 = this.f17428a;
        if (fragmentYyRelationshipRankBinding2 != null && (smartRefreshLayout = fragmentYyRelationshipRankBinding2.d) != null) {
            smartRefreshLayout.h();
        }
        LinearLayout linearLayout = null;
        if (this.b.getData().size() > 0) {
            FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding3 = this.f17428a;
            LinearLayout linearLayout2 = fragmentYyRelationshipRankBinding3 == null ? null : fragmentYyRelationshipRankBinding3.b;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } else if (!z) {
            FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding4 = this.f17428a;
            LinearLayout linearLayout3 = fragmentYyRelationshipRankBinding4 == null ? null : fragmentYyRelationshipRankBinding4.b;
            if (linearLayout3 == null) {
                return;
            }
            linearLayout3.setVisibility(0);
        } else {
            FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding5 = this.f17428a;
            if (fragmentYyRelationshipRankBinding5 != null) {
                linearLayout = fragmentYyRelationshipRankBinding5.b;
            }
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    private final void c() {
        YYRelationShipRoomUiInfo resource_options;
        String icon_empty_data;
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyRelationshipRankBinding a2 = FragmentYyRelationshipRankBinding.a(this.i);
        this.f17428a = a2;
        RecyclerView recyclerView = a2 == null ? null : a2.f16544c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding = this.f17428a;
        RecyclerView recyclerView2 = fragmentYyRelationshipRankBinding == null ? null : fragmentYyRelationshipRankBinding.f16544c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.b);
        }
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding2 = this.f17428a;
        if (fragmentYyRelationshipRankBinding2 != null && (smartRefreshLayout = fragmentYyRelationshipRankBinding2.d) != null) {
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYRelationShipRankItemFragment$initView$1
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYRelationShipRankItemFragment.this.j().f();
                }

                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYRelationShipRankItemFragment.this.j().e();
                }
            });
        }
        ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRelationShipRoomMode yYRelationShipRoomMode = this.f17429c;
        String str = "";
        if (yYRelationShipRoomMode != null && (resource_options = yYRelationShipRoomMode.getResource_options()) != null && (icon_empty_data = resource_options.getIcon_empty_data()) != null) {
            str = icon_empty_data;
        }
        ImageWrapper a3 = ImageLoader.a(fragmentActive, str);
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding3 = this.f17428a;
        a3.a(fragmentYyRelationshipRankBinding3 == null ? null : fragmentYyRelationshipRankBinding3.f16543a);
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding4 = this.f17428a;
        TextView textView = fragmentYyRelationshipRankBinding4 == null ? null : fragmentYyRelationshipRankBinding4.e;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("暂无「");
            YYRelationShipRoomMode yYRelationShipRoomMode2 = this.f17429c;
            sb.append((Object) (yYRelationShipRoomMode2 == null ? null : yYRelationShipRoomMode2.getRelation_name()));
            sb.append((char) 12301);
            textView.setText(sb.toString());
        }
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding5 = this.f17428a;
        TextView textView2 = fragmentYyRelationshipRankBinding5 == null ? null : fragmentYyRelationshipRankBinding5.f;
        if (textView2 == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("快去配对自己的「");
        YYRelationShipRoomMode yYRelationShipRoomMode3 = this.f17429c;
        sb2.append((Object) (yYRelationShipRoomMode3 == null ? null : yYRelationShipRoomMode3.getRelation_name()));
        sb2.append("」吧～");
        textView2.setText(sb2.toString());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        c();
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.f17429c = yYRelationShipRoomMode;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List<?> list) {
        super.a(str, list);
        if (Intrinsics.a((Object) str, (Object) j().m())) {
            MvpUtils.a(list, YYRelationShipRoomRank.class, new MvpUtils.DataListHandler<YYRelationShipRoomRank>() { // from class: com.blued.android.module.yy_china.fragment.YYRelationShipRankItemFragment$showDataToUI$1
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<YYRelationShipRoomRank> list2) {
                    YYRelationShipRankItemFragment.RelationShipRankAdapter relationShipRankAdapter;
                    Intrinsics.e(list2, "list");
                    relationShipRankAdapter = YYRelationShipRankItemFragment.this.b;
                    relationShipRankAdapter.setNewData(list2);
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

    public final YYRelationShipRoomMode b() {
        return this.f17429c;
    }

    public final void c(String roomId) {
        Intrinsics.e(roomId, "roomId");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (StringUtils.a(b == null ? null : b.room_id, roomId)) {
            return;
        }
        YYRoomInfoManager e = YYRoomInfoManager.e();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
        }
        e.a((BaseFragmentActivity) activity, roomId, "");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_relationship_rank;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding = this.f17428a;
        if (fragmentYyRelationshipRankBinding == null || (smartRefreshLayout = fragmentYyRelationshipRankBinding.d) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        super.o();
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding = this.f17428a;
        if (fragmentYyRelationshipRankBinding == null || (smartRefreshLayout = fragmentYyRelationshipRankBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        SmartRefreshLayout smartRefreshLayout;
        super.p();
        FragmentYyRelationshipRankBinding fragmentYyRelationshipRankBinding = this.f17428a;
        if (fragmentYyRelationshipRankBinding == null || (smartRefreshLayout = fragmentYyRelationshipRankBinding.d) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }
}
