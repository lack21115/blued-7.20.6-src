package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.FansClubAdapter;
import com.blued.android.module.yy_china.databinding.DialogFansClubHostViewBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClubGroupInfoModel;
import com.blued.android.module.yy_china.model.YYClubHostModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansClubHostViewDialog.class */
public final class YYFansClubHostViewDialog extends YYBaseFansDialog {
    private BaseFragment a;
    private final YYUserInfo b;
    private DialogFansClubHostViewBinding c;
    private FansClubAdapter d;
    private int e;
    private int f;
    private String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansClubHostViewDialog(BaseFragment fragment, YYUserInfo us) {
        super(fragment, us);
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(us, "us");
        this.a = fragment;
        this.b = us;
        this.e = 1;
        this.g = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYFansClubHostViewDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_FANS_EDIT_CLICK, b.room_id, b.uid, this$0.f);
        }
        YYModifyClubNameDialog yYModifyClubNameDialog = new YYModifyClubNameDialog(this$0.g, this$0.f);
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYModifyClubNameDialog.show(parentFragmentManager, "show_fix_club_name");
    }

    private final void l() {
        TextView textView;
        SmartRefreshLayout smartRefreshLayout;
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding = this.c;
        if (dialogFansClubHostViewBinding != null && (smartRefreshLayout = dialogFansClubHostViewBinding.e) != null) {
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYFansClubHostViewDialog$initView$1
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYFansClubHostViewDialog.this.p();
                }

                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYFansClubHostViewDialog.this.e = 1;
                    YYFansClubHostViewDialog.this.p();
                }
            });
        }
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding2 = this.c;
        if (dialogFansClubHostViewBinding2 != null && (textView = dialogFansClubHostViewBinding2.j) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYFansClubHostViewDialog$nMS3uUilMIJENSaOKI5sVZcwjWw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYFansClubHostViewDialog.a(YYFansClubHostViewDialog.this, view);
                }
            });
        }
        m();
        n();
    }

    private final void m() {
        YYUserInfo g = g();
        ImageWrapper b = ImageLoader.a(a(), g.getAvatar()).b(R.drawable.user_bg_round);
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding = this.c;
        b.a(dialogFansClubHostViewBinding == null ? null : dialogFansClubHostViewBinding.b);
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding2 = this.c;
        TextView textView = dialogFansClubHostViewBinding2 == null ? null : dialogFansClubHostViewBinding2.i;
        if (textView == null) {
            return;
        }
        textView.setText(Intrinsics.a(g.getName(), (Object) "的粉丝团"));
    }

    private final void n() {
        List data;
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        this.d = new FansClubAdapter(fragmentActive);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding = this.c;
        Integer num = null;
        RecyclerView recyclerView = dialogFansClubHostViewBinding == null ? null : dialogFansClubHostViewBinding.h;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding2 = this.c;
        RecyclerView recyclerView2 = dialogFansClubHostViewBinding2 == null ? null : dialogFansClubHostViewBinding2.h;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.d);
        }
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding3 = this.c;
        TextView textView = dialogFansClubHostViewBinding3 == null ? null : dialogFansClubHostViewBinding3.l;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = getString(R.string.yy_fans_member_list);
            Intrinsics.c(string, "getString(R.string.yy_fans_member_list)");
            FansClubAdapter fansClubAdapter = this.d;
            if (fansClubAdapter != null && (data = fansClubAdapter.getData()) != null) {
                num = Integer.valueOf(data.size());
            }
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(num)}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
        }
        FansClubAdapter fansClubAdapter2 = this.d;
        if (fansClubAdapter2 == null) {
            return;
        }
        fansClubAdapter2.setEmptyView(i());
    }

    private final void o() {
        YYUserInfo g = g();
        String uid = g == null ? null : g.getUid();
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.n(uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYClubHostModel>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYFansClubHostViewDialog$getClubInfoByHost$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYClubHostModel> bluedEntityA) {
                DialogFansClubHostViewBinding dialogFansClubHostViewBinding;
                DialogFansClubHostViewBinding dialogFansClubHostViewBinding2;
                DialogFansClubHostViewBinding dialogFansClubHostViewBinding3;
                DialogFansClubHostViewBinding dialogFansClubHostViewBinding4;
                DialogFansClubHostViewBinding dialogFansClubHostViewBinding5;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYClubHostModel singleData = bluedEntityA.getSingleData();
                String str = null;
                if (singleData != null) {
                    YYFansClubHostViewDialog yYFansClubHostViewDialog = YYFansClubHostViewDialog.this;
                    yYFansClubHostViewDialog.f = StringUtils.a(singleData.fans_count, 0);
                    dialogFansClubHostViewBinding = yYFansClubHostViewDialog.c;
                    TextView textView = dialogFansClubHostViewBinding == null ? null : dialogFansClubHostViewBinding.k;
                    if (textView != null) {
                        textView.setText(singleData.fans_count);
                    }
                    dialogFansClubHostViewBinding2 = yYFansClubHostViewDialog.c;
                    TextView textView2 = dialogFansClubHostViewBinding2 == null ? null : dialogFansClubHostViewBinding2.l;
                    if (textView2 != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                        String string = yYFansClubHostViewDialog.getString(R.string.yy_fans_member_list);
                        Intrinsics.c(string, "getString(R.string.yy_fans_member_list)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{singleData.fans_count}, 1));
                        Intrinsics.c(format, "format(format, *args)");
                        textView2.setText(format);
                    }
                    dialogFansClubHostViewBinding3 = yYFansClubHostViewDialog.c;
                    TextView textView3 = dialogFansClubHostViewBinding3 == null ? null : dialogFansClubHostViewBinding3.j;
                    if (textView3 != null) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
                        String string2 = yYFansClubHostViewDialog.getString(R.string.yy_club_name);
                        Intrinsics.c(string2, "getString(R.string.yy_club_name)");
                        YYClubGroupInfoModel yYClubGroupInfoModel = singleData.group_info;
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{yYClubGroupInfoModel == null ? null : yYClubGroupInfoModel.name}, 1));
                        Intrinsics.c(format2, "format(format, *args)");
                        textView3.setText(format2);
                    }
                    YYClubGroupInfoModel yYClubGroupInfoModel2 = singleData.group_info;
                    yYFansClubHostViewDialog.g = String.valueOf(yYClubGroupInfoModel2 == null ? null : yYClubGroupInfoModel2.name);
                    if (StringUtils.a(singleData.fans_count, 0) >= 50) {
                        dialogFansClubHostViewBinding5 = yYFansClubHostViewDialog.c;
                        TextView textView4 = dialogFansClubHostViewBinding5 == null ? null : dialogFansClubHostViewBinding5.j;
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                    } else {
                        dialogFansClubHostViewBinding4 = yYFansClubHostViewDialog.c;
                        TextView textView5 = dialogFansClubHostViewBinding4 == null ? null : dialogFansClubHostViewBinding4.j;
                        if (textView5 != null) {
                            textView5.setVisibility(8);
                        }
                    }
                }
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FANS_PANEL_SHOW;
                YYRoomModel h = YYFansClubHostViewDialog.this.h();
                String str2 = h == null ? null : h.room_id;
                YYRoomModel h2 = YYFansClubHostViewDialog.this.h();
                String str3 = h2 == null ? null : h2.uid;
                YYUserInfo g2 = YYFansClubHostViewDialog.this.g();
                if (g2 != null) {
                    str = g2.getUid();
                }
                EventTrackYY.a(event, str2, str3, str, ChatRoomProtos.UserType.ANCHOR);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        YYUserInfo g = g();
        YYRoomHttpUtils.j(g == null ? null : g.getUid(), String.valueOf(this.e), (BluedUIHttpResponse) new YYFansClubHostViewDialog$getMemberList$1(this, a()), a());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public BaseFragment f() {
        return this.a;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public YYUserInfo g() {
        return this.b;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View j() {
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding = this.c;
        return dialogFansClubHostViewBinding == null ? null : dialogFansClubHostViewBinding.c;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View k() {
        DialogFansClubHostViewBinding dialogFansClubHostViewBinding = this.c;
        if (dialogFansClubHostViewBinding == null) {
            return null;
        }
        return dialogFansClubHostViewBinding.a;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog, com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o();
        p();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_fans_club_host_view, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…st_view, container, true)");
        this.c = DialogFansClubHostViewBinding.a(inflate);
        l();
        return inflate;
    }
}
