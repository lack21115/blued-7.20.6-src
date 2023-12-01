package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRelationShipItemUIPagerAdapter;
import com.blued.android.module.yy_china.databinding.FragYyRelationshipInfoItemBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomLevelInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYRelationShipMyAllDialog;
import com.blued.android.module.yy_china.view.ban.transformer.MedalTransformer;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YyRelationShipRoomItemFragment.class */
public final class YyRelationShipRoomItemFragment extends MvpFragment<MvpPresenter> {
    private FragYyRelationshipInfoItemBinding a;
    private YYRelationShipRoomUserCardInfoMode b;
    private YYRelationShipRoomMode c;
    private int d = 1;
    private View.OnClickListener e;
    private View.OnClickListener f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YyRelationShipRoomItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding = this$0.a;
        Group group = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.f;
        if (group == null) {
            return;
        }
        group.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YyRelationShipRoomItemFragment this$0, YYRelationShipRoomUserInfoMode it, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        YYRoomInfoManager e = YYRoomInfoManager.e();
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
        }
        e.a((BaseFragmentActivity) activity, it.getRoom_id(), "");
    }

    private final void a(ArrayList<YYRelationShipRoomLevelInfoMode> arrayList, int i) {
        ViewPager viewPager;
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding = this.a;
        ViewPager viewPager2 = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.J;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(3);
        }
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding2 = this.a;
        if (fragYyRelationshipInfoItemBinding2 != null && (viewPager = fragYyRelationshipInfoItemBinding2.J) != null) {
            viewPager.setPageTransformer(true, new MedalTransformer());
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter yYRelationShipItemUIPagerAdapter = new YYRelationShipItemUIPagerAdapter(childFragmentManager);
        yYRelationShipItemUIPagerAdapter.a(arrayList, i);
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding3 = this.a;
        ViewPager viewPager3 = fragYyRelationshipInfoItemBinding3 == null ? null : fragYyRelationshipInfoItemBinding3.J;
        if (viewPager3 != null) {
            viewPager3.setAdapter(yYRelationShipItemUIPagerAdapter);
        }
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding4 = this.a;
        ViewPager viewPager4 = fragYyRelationshipInfoItemBinding4 == null ? null : fragYyRelationshipInfoItemBinding4.J;
        if (viewPager4 != null) {
            viewPager4.setCurrentItem(i - 1);
        }
        yYRelationShipItemUIPagerAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YyRelationShipRoomItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding = this$0.a;
        Group group = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.f;
        if (group == null) {
            return;
        }
        group.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YyRelationShipRoomItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding = this$0.a;
        Group group = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.f;
        if (group == null) {
            return;
        }
        group.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YyRelationShipRoomItemFragment this$0, View view) {
        String id;
        Intrinsics.e(this$0, "this$0");
        YYRelationShipMyAllDialog yYRelationShipMyAllDialog = new YYRelationShipMyAllDialog();
        YYRelationShipRoomMode yYRelationShipRoomMode = this$0.c;
        String str = null;
        if (yYRelationShipRoomMode != null && (id = yYRelationShipRoomMode.getId()) != null) {
            str = id;
        }
        yYRelationShipMyAllDialog.a(str);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYRelationShipMyAllDialog.show(childFragmentManager, "YYRelationShipMyAllDialog");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_RELATION_ALL_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r0 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment.e(com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final YyRelationShipRoomItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this$0.b;
        String id = yYRelationShipRoomUserCardInfoMode == null ? null : yYRelationShipRoomUserCardInfoMode.getId();
        final ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
        YYRoomHttpUtils.v(id, "1", new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment$initData$7$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding;
                fragYyRelationshipInfoItemBinding = YyRelationShipRoomItemFragment.this.a;
                TextView textView = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.c;
                if (textView != null) {
                    textView.setText("隐藏关系");
                }
                YYRelationShipRoomUserCardInfoMode b = YyRelationShipRoomItemFragment.this.b();
                if (b != null) {
                    b.set_hidden(0);
                }
                ToastUtils.a("关系已显示");
                YyRelationShipRoomItemFragment.this.w();
            }
        }, this$0.getFragmentActive());
        FragYyRelationshipInfoItemBinding fragYyRelationshipInfoItemBinding = this$0.a;
        LinearLayout linearLayout = fragYyRelationshipInfoItemBinding == null ? null : fragYyRelationshipInfoItemBinding.v;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment.g(com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c7, code lost:
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment.h(com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(YyRelationShipRoomItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.f;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(null);
    }

    private final void v() {
        this.a = FragYyRelationshipInfoItemBinding.a(this.i);
        x();
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0511, code lost:
        if (r0 == null) goto L233;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w() {
        /*
            Method dump skipped, instructions count: 2382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment.w():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:165:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void x() {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment.x():void");
    }

    public final void a(int i) {
        this.d = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.c = yYRelationShipRoomMode;
    }

    public final void a(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode) {
        this.b = yYRelationShipRoomUserCardInfoMode;
    }

    public final YYRelationShipRoomUserCardInfoMode b() {
        return this.b;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public final YYRelationShipRoomMode c() {
        return this.c;
    }

    public final View.OnClickListener d() {
        return this.e;
    }

    public final void e() {
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this.b;
        String id = yYRelationShipRoomUserCardInfoMode == null ? null : yYRelationShipRoomUserCardInfoMode.getId();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.Y(id, new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomUserCardInfoMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment$loadInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
                r0 = r0.a;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode> r10) {
                /*
                    Method dump skipped, instructions count: 207
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomItemFragment$loadInfo$1.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.frag_yy_relationship_info_item;
    }
}
