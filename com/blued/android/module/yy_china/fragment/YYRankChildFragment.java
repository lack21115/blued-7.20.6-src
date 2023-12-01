package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRankAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyRankChildLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRankExtraModel;
import com.blued.android.module.yy_china.model.YYRankModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankChildFragment.class */
public final class YYRankChildFragment extends BaseLazyFragment {
    public static final Companion a = new Companion(null);
    private FragmentYyRankChildLayoutBinding b;
    private YYRankAdapter c;
    private int d;
    private int e;
    private int f = 1;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRankChildFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("show_gift_list").post("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends YYRankModel> list) {
        YYRankAdapter yYRankAdapter = this.c;
        if (yYRankAdapter == null) {
            return;
        }
        yYRankAdapter.setNewData(list);
    }

    private final void b() {
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding = this.b;
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2 = fragmentYyRankChildLayoutBinding;
        if (fragmentYyRankChildLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding2 = null;
        }
        fragmentYyRankChildLayoutBinding2.g.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYRankChildFragment$onInitView$1
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYRankChildFragment.this.a();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                YYRankChildFragment.this.f = 1;
                YYRankChildFragment.this.a();
            }
        });
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = this.b;
        if (fragmentYyRankChildLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding3 = null;
        }
        fragmentYyRankChildLayoutBinding3.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRankChildFragment$fIumjJ4iF0BsHdqpj7sZn6C_ajQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRankChildFragment.a(view);
            }
        });
        c();
    }

    private final void c() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding = this.b;
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2 = fragmentYyRankChildLayoutBinding;
        if (fragmentYyRankChildLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding2 = null;
        }
        fragmentYyRankChildLayoutBinding2.f.setLayoutManager(linearLayoutManager);
        this.c = new YYRankAdapter(getFragmentActive());
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = this.b;
        if (fragmentYyRankChildLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding3 = null;
        }
        fragmentYyRankChildLayoutBinding3.f.setAdapter(this.c);
    }

    private final void d() {
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo != null) {
            ImageWrapper a2 = ImageLoader.a(getFragmentActive(), yYUserInfo.getAvatar());
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding = this.b;
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2 = fragmentYyRankChildLayoutBinding;
            if (fragmentYyRankChildLayoutBinding == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankChildLayoutBinding2 = null;
            }
            a2.a((ImageView) fragmentYyRankChildLayoutBinding2.a);
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = this.b;
            if (fragmentYyRankChildLayoutBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankChildLayoutBinding3 = null;
            }
            fragmentYyRankChildLayoutBinding3.i.setText(yYUserInfo.getName());
        }
    }

    private final void e() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.b(YYRoomInfoManager.e().b().room_id, this.e, this.f, (BluedUIHttpResponse) g(), (IRequestHost) getFragmentActive());
    }

    private final void f() {
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.c(YYRoomInfoManager.e().b().room_id, this.e, this.f, g(), getFragmentActive());
    }

    private final BluedUIHttpResponse<BluedEntity<YYRankModel, YYRankExtraModel>> g() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        return new BluedUIHttpResponse<BluedEntity<YYRankModel, YYRankExtraModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYRankChildFragment$getHttpCallback$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2;
                super.onUIFinish(z);
                Logger.e("YYRankChildFragment", "onFinish");
                fragmentYyRankChildLayoutBinding = YYRankChildFragment.this.b;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = fragmentYyRankChildLayoutBinding;
                if (fragmentYyRankChildLayoutBinding == null) {
                    Intrinsics.c("mBinding");
                    fragmentYyRankChildLayoutBinding3 = null;
                }
                fragmentYyRankChildLayoutBinding3.g.g();
                fragmentYyRankChildLayoutBinding2 = YYRankChildFragment.this.b;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding4 = fragmentYyRankChildLayoutBinding2;
                if (fragmentYyRankChildLayoutBinding4 == null) {
                    Intrinsics.c("mBinding");
                    fragmentYyRankChildLayoutBinding4 = null;
                }
                fragmentYyRankChildLayoutBinding4.g.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRankModel, YYRankExtraModel> bluedEntity) {
                int i;
                int i2;
                YYRankAdapter yYRankAdapter;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding;
                int i3;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding4;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding5;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding6;
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    i = YYRankChildFragment.this.f;
                    if (i == 1) {
                        YYRankChildFragment.this.h();
                        return;
                    }
                    return;
                }
                i2 = YYRankChildFragment.this.f;
                if (i2 == 1) {
                    ArrayList arrayList = new ArrayList();
                    YYRankModel yYRankModel = new YYRankModel();
                    yYRankModel.type = 1;
                    yYRankModel.topList = new ArrayList();
                    int size = bluedEntity.data.size();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= size || i5 > 2) {
                            break;
                        }
                        yYRankModel.topList.add(bluedEntity.data.get(i5));
                        i4 = i5 + 1;
                    }
                    arrayList.add(yYRankModel);
                    if (bluedEntity.data.size() > 3) {
                        arrayList.addAll(bluedEntity.data.subList(3, bluedEntity.data.size()));
                    }
                    YYRankChildFragment.this.a(arrayList);
                    if (bluedEntity.extra != null) {
                        int a2 = StringUtils.a(bluedEntity.extra.getSort(), 0);
                        if (1 <= a2 && a2 < 101) {
                            fragmentYyRankChildLayoutBinding6 = YYRankChildFragment.this.b;
                            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding7 = fragmentYyRankChildLayoutBinding6;
                            if (fragmentYyRankChildLayoutBinding6 == null) {
                                Intrinsics.c("mBinding");
                                fragmentYyRankChildLayoutBinding7 = null;
                            }
                            fragmentYyRankChildLayoutBinding7.h.setText(String.valueOf(a2));
                        } else if (a2 > 100) {
                            fragmentYyRankChildLayoutBinding4 = YYRankChildFragment.this.b;
                            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding8 = fragmentYyRankChildLayoutBinding4;
                            if (fragmentYyRankChildLayoutBinding4 == null) {
                                Intrinsics.c("mBinding");
                                fragmentYyRankChildLayoutBinding8 = null;
                            }
                            fragmentYyRankChildLayoutBinding8.h.setText("100+");
                        } else {
                            fragmentYyRankChildLayoutBinding3 = YYRankChildFragment.this.b;
                            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding9 = fragmentYyRankChildLayoutBinding3;
                            if (fragmentYyRankChildLayoutBinding3 == null) {
                                Intrinsics.c("mBinding");
                                fragmentYyRankChildLayoutBinding9 = null;
                            }
                            fragmentYyRankChildLayoutBinding9.h.setText("暂未上榜");
                        }
                        fragmentYyRankChildLayoutBinding5 = YYRankChildFragment.this.b;
                        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding10 = fragmentYyRankChildLayoutBinding5;
                        if (fragmentYyRankChildLayoutBinding5 == null) {
                            Intrinsics.c("mBinding");
                            fragmentYyRankChildLayoutBinding10 = null;
                        }
                        fragmentYyRankChildLayoutBinding10.l.setText(bluedEntity.extra.getScore());
                    }
                } else {
                    yYRankAdapter = YYRankChildFragment.this.c;
                    if (yYRankAdapter != null) {
                        yYRankAdapter.addData(bluedEntity.data);
                    }
                }
                if (!bluedEntity.hasMore()) {
                    fragmentYyRankChildLayoutBinding = YYRankChildFragment.this.b;
                    FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding11 = fragmentYyRankChildLayoutBinding;
                    if (fragmentYyRankChildLayoutBinding11 == null) {
                        Intrinsics.c("mBinding");
                        fragmentYyRankChildLayoutBinding11 = null;
                    }
                    fragmentYyRankChildLayoutBinding11.g.b(false);
                    return;
                }
                YYRankChildFragment yYRankChildFragment = YYRankChildFragment.this;
                i3 = yYRankChildFragment.f;
                yYRankChildFragment.f = i3 + 1;
                fragmentYyRankChildLayoutBinding2 = YYRankChildFragment.this.b;
                FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding12 = fragmentYyRankChildLayoutBinding2;
                if (fragmentYyRankChildLayoutBinding12 == null) {
                    Intrinsics.c("mBinding");
                    fragmentYyRankChildLayoutBinding12 = null;
                }
                fragmentYyRankChildLayoutBinding12.g.b(true);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding = this.b;
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2 = fragmentYyRankChildLayoutBinding;
        if (fragmentYyRankChildLayoutBinding == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding2 = null;
        }
        fragmentYyRankChildLayoutBinding2.d.setVisibility(8);
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = this.b;
        if (fragmentYyRankChildLayoutBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentYyRankChildLayoutBinding3 = null;
        }
        fragmentYyRankChildLayoutBinding3.e.setVisibility(0);
    }

    private final void i() {
        int i = this.e;
        FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding = null;
        if (i == 0) {
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding2 = this.b;
            if (fragmentYyRankChildLayoutBinding2 == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankChildLayoutBinding2 = null;
            }
            fragmentYyRankChildLayoutBinding2.k.setText(this.d == 0 ? "注：根据本场在该主播开播的聊天室内收到的礼物弯豆数计榜" : "注：根据本场在该主播开播的聊天室内赠送的礼物弯豆数计榜");
        } else if (i == 1) {
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding3 = this.b;
            if (fragmentYyRankChildLayoutBinding3 == null) {
                Intrinsics.c("mBinding");
                fragmentYyRankChildLayoutBinding3 = null;
            }
            fragmentYyRankChildLayoutBinding3.k.setText(this.d == 0 ? "注：根据自然天内在该主播开播的聊天室内收到的礼物弯豆数计榜" : "注：根据自然天内在该主播开播的聊天室内赠送的礼物弯豆数计榜");
        } else if (i != 2) {
        } else {
            FragmentYyRankChildLayoutBinding fragmentYyRankChildLayoutBinding4 = this.b;
            if (fragmentYyRankChildLayoutBinding4 == null) {
                Intrinsics.c("mBinding");
            } else {
                fragmentYyRankChildLayoutBinding = fragmentYyRankChildLayoutBinding4;
            }
            fragmentYyRankChildLayoutBinding.k.setText(this.d == 0 ? "注：根据自然周内在该主播开播的聊天室内收到的礼物弯豆数计榜" : "注：根据自然周内在该主播开播的聊天室内赠送的礼物弯豆数计榜");
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseLazyFragment
    public void a() {
        super.a();
        if (this.d == 0) {
            f();
        } else {
            e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = arguments.getInt("rank_type", 0);
        this.e = arguments.getInt("position", 0);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_yy_rank_child_layout, (ViewGroup) null);
        FragmentYyRankChildLayoutBinding a2 = FragmentYyRankChildLayoutBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.b = a2;
        b();
        d();
        i();
        return inflate;
    }
}
