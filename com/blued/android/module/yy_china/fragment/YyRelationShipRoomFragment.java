package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRelationShipItemPagerAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyRelationItemBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationshipRoomTaskBottomBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationshipRoomTaskTitleBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRelationshipRoomUsersItemBinding;
import com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomTask;
import com.blued.android.module.yy_china.model.YYRelationShipRoomTaskExtraMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomTaskItemMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUser;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.presenter.YYRelationShipPresenter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.YYTextSpanComputer;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYRelationShipToInviteDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YyRelationShipRoomFragment.class */
public final class YyRelationShipRoomFragment extends MvpFragment<YYRelationShipPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private FragmentYyRelationItemBinding f17497a;
    private final UserAdapter b = new UserAdapter(this);

    /* renamed from: c  reason: collision with root package name */
    private final TaskAdapter f17498c = new TaskAdapter(this);
    private YYRelationShipItemPagerAdapter d;
    private YYRelationShipRoomTaskExtraMode e;
    private YYRelationShipRoomUserCardInfoMode f;
    private YYRelationShipRoomMode g;
    private View.OnClickListener k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YyRelationShipRoomFragment$TaskAdapter.class */
    public final class TaskAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomTask, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YyRelationShipRoomFragment f17499a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskAdapter(YyRelationShipRoomFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17499a = this$0;
            addItemType(0, R.layout.item_yy_relationship_room_task_item);
            addItemType(1, R.layout.item_yy_relationship_room_task_title);
            addItemType(2, R.layout.item_yy_relationship_room_task_bottom);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View view) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
            if (r0 == null) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void a(com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment r5, android.view.View r6) {
            /*
                Method dump skipped, instructions count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment.TaskAdapter.a(com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment, android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipRoomTask item, final YyRelationShipRoomFragment this$0, View view) {
            Intrinsics.e(item, "$item");
            Intrinsics.e(this$0, "this$0");
            String task_id = item.getTask_id();
            YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this$0.f;
            String id = yYRelationShipRoomUserCardInfoMode == null ? null : yYRelationShipRoomUserCardInfoMode.getId();
            final ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            YYRoomHttpUtils.u(task_id, id, new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment$TaskAdapter$bindData$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(fragmentActive);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode2 = YyRelationShipRoomFragment.this.f;
                    if (yYRelationShipRoomUserCardInfoMode2 == null) {
                        return;
                    }
                    YyRelationShipRoomFragment yyRelationShipRoomFragment = YyRelationShipRoomFragment.this;
                    yyRelationShipRoomFragment.b(yYRelationShipRoomUserCardInfoMode2);
                    yyRelationShipRoomFragment.w();
                }
            }, this$0.getFragmentActive());
        }

        private final void b(BaseViewHolder baseViewHolder, YYRelationShipRoomTask yYRelationShipRoomTask) {
            ItemYyRelationshipRoomTaskBottomBinding a2 = ItemYyRelationshipRoomTaskBottomBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            a2.f16799a.setText(yYRelationShipRoomTask.getTitle());
        }

        private final void c(BaseViewHolder baseViewHolder, YYRelationShipRoomTask yYRelationShipRoomTask) {
            ItemYyRelationshipRoomTaskTitleBinding a2 = ItemYyRelationshipRoomTaskTitleBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            YYRelationShipRoomTaskExtraMode yYRelationShipRoomTaskExtraMode = this.f17499a.e;
            if (yYRelationShipRoomTaskExtraMode == null) {
                return;
            }
            a2.b.setText(yYRelationShipRoomTaskExtraMode.getTitle());
            a2.f16802a.setText(yYRelationShipRoomTaskExtraMode.getRemark1());
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0075, code lost:
            if (r13 == null) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void d(com.chad.library.adapter.base.BaseViewHolder r8, final com.blued.android.module.yy_china.model.YYRelationShipRoomTask r9) {
            /*
                Method dump skipped, instructions count: 784
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment.TaskAdapter.d(com.chad.library.adapter.base.BaseViewHolder, com.blued.android.module.yy_china.model.YYRelationShipRoomTask):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomTask item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            int itemType = item.getItemType();
            if (itemType == 0) {
                d(helper, item);
            } else if (itemType == 1) {
                c(helper, item);
            } else if (itemType == 2) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YyRelationShipRoomFragment$UserAdapter.class */
    public final class UserAdapter extends BaseMultiItemQuickAdapter<YYRelationShipRoomUser, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YyRelationShipRoomFragment f17501a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserAdapter(YyRelationShipRoomFragment this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.f17501a = this$0;
            addItemType(0, R.layout.item_yy_relationship_room_users_item);
            addItemType(1, R.layout.item_yy_relationship_room_users_title);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YyRelationShipRoomFragment this$0, YYRelationShipRoomUser item, View view) {
            String id;
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            YYRelationShipToInviteDialog yYRelationShipToInviteDialog = new YYRelationShipToInviteDialog();
            yYRelationShipToInviteDialog.a(this$0.b());
            yYRelationShipToInviteDialog.a(item);
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            yYRelationShipToInviteDialog.show(childFragmentManager, "YYRelationShipToInviteDialog");
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_RELATION_USER_INVITE_CLICK;
            String str = b.room_id;
            String str2 = b.uid;
            String uid = item.getUid();
            YYRelationShipRoomMode b2 = this$0.b();
            String str3 = "";
            if (b2 != null && (id = b2.getId()) != null) {
                str3 = id;
            }
            EventTrackYY.g(event, str, str2, uid, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYRelationShipRoomUser item, View view) {
            Intrinsics.e(item, "$item");
            YYUserInfo yYUserInfo = new YYUserInfo();
            yYUserInfo.setUid(item.getUid());
            yYUserInfo.setName(item.getName());
            yYUserInfo.setAvatar(item.getAvatar());
            LiveEventBus.get("open_user").post(yYUserInfo);
        }

        private final void b(BaseViewHolder baseViewHolder, final YYRelationShipRoomUser yYRelationShipRoomUser) {
            YYRelationShipRoomUiInfo resource_options;
            ItemYyRelationshipRoomUsersItemBinding a2 = ItemYyRelationshipRoomUsersItemBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            if (!YYRoomInfoManager.e().J() || YYRoomInfoManager.e().g(yYRelationShipRoomUser.getUid())) {
                a2.b.a(this.f17501a.getFragmentActive(), yYRelationShipRoomUser.getAvatar(), yYRelationShipRoomUser.getAvatar_frame());
            } else {
                a2.b.setEmptyHead(R.drawable.icon_user_mask_without_text);
            }
            a2.d.setText(YYRoomInfoManager.e().a(yYRelationShipRoomUser.getUid(), yYRelationShipRoomUser.getName()));
            YYTextSpanComputer.Builder builder = new YYTextSpanComputer.Builder();
            boolean z = YYRoomInfoManager.e().J() && !YYRoomInfoManager.e().g(yYRelationShipRoomUser.getUid());
            if (yYRelationShipRoomUser.getAnchor_level() > 0 && !z) {
                Context context = this.f17501a.getContext();
                Intrinsics.a(context);
                Drawable drawable = context.getResources().getDrawable(YYRoomInfoManager.e().b(yYRelationShipRoomUser.getAnchor_level()));
                drawable.setBounds(0, 0, AppMethods.a(32), AppMethods.a(16));
                Intrinsics.c(drawable, "drawable");
                builder.a(drawable).a(" ");
            }
            a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YyRelationShipRoomFragment$UserAdapter$3nuKfS1QYjsCS-1MTOUq-dhGeNY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YyRelationShipRoomFragment.UserAdapter.a(YYRelationShipRoomUser.this, view);
                }
            });
            if (yYRelationShipRoomUser.getHonor_level() > 0) {
                Context context2 = this.f17501a.getContext();
                Intrinsics.a(context2);
                Drawable drawable2 = context2.getResources().getDrawable(YYRoomInfoManager.e().a(yYRelationShipRoomUser.getHonor_level()));
                drawable2.setBounds(0, 0, AppMethods.a(38), AppMethods.a(16));
                Intrinsics.c(drawable2, "drawable");
                builder.a(drawable2).a(" ");
            }
            a2.f16805c.setText(builder.c().a());
            ShapeTextView shapeTextView = a2.f16804a;
            YYRelationShipRoomMode b = this.f17501a.b();
            String str = null;
            if (b != null && (resource_options = b.getResource_options()) != null) {
                str = resource_options.getTheme_color_6();
            }
            shapeTextView.setTextColor(Color.parseColor(str));
            ShapeTextView shapeTextView2 = a2.f16804a;
            final YyRelationShipRoomFragment yyRelationShipRoomFragment = this.f17501a;
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YyRelationShipRoomFragment$UserAdapter$VCB5k6KiXYM8KalU-_K_SH6KNIE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YyRelationShipRoomFragment.UserAdapter.a(YyRelationShipRoomFragment.this, yYRelationShipRoomUser, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, YYRelationShipRoomUser item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YyRelationShipRoomFragment this$0, View view) {
        AppBarLayout appBarLayout;
        Intrinsics.e(this$0, "this$0");
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this$0.f17497a;
        if (fragmentYyRelationItemBinding == null || (appBarLayout = fragmentYyRelationItemBinding.f16541a) == null) {
            return;
        }
        appBarLayout.setExpanded(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode) {
        if (yYRelationShipRoomUserCardInfoMode == null) {
            FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this.f17497a;
            ShapeFrameLayout shapeFrameLayout = fragmentYyRelationItemBinding == null ? null : fragmentYyRelationItemBinding.h;
            if (shapeFrameLayout != null) {
                shapeFrameLayout.setVisibility(8);
            }
            FragmentYyRelationItemBinding fragmentYyRelationItemBinding2 = this.f17497a;
            ShapeFrameLayout shapeFrameLayout2 = fragmentYyRelationItemBinding2 == null ? null : fragmentYyRelationItemBinding2.i;
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setVisibility(0);
            }
            x();
            return;
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding3 = this.f17497a;
        ShapeFrameLayout shapeFrameLayout3 = fragmentYyRelationItemBinding3 == null ? null : fragmentYyRelationItemBinding3.i;
        if (shapeFrameLayout3 != null) {
            shapeFrameLayout3.setVisibility(8);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding4 = this.f17497a;
        ShapeFrameLayout shapeFrameLayout4 = fragmentYyRelationItemBinding4 == null ? null : fragmentYyRelationItemBinding4.h;
        if (shapeFrameLayout4 != null) {
            shapeFrameLayout4.setVisibility(0);
        }
        b(yYRelationShipRoomUserCardInfoMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final ArrayList<YYRelationShipRoomUserCardInfoMode> arrayList) {
        ShapeFrameLayout shapeFrameLayout;
        ShapeTextView shapeTextView;
        ViewPager viewPager;
        arrayList.add(null);
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this.f17497a;
        ViewPager viewPager2 = fragmentYyRelationItemBinding == null ? null : fragmentYyRelationItemBinding.k;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(1);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        YYRelationShipItemPagerAdapter yYRelationShipItemPagerAdapter = new YYRelationShipItemPagerAdapter(childFragmentManager);
        this.d = yYRelationShipItemPagerAdapter;
        if (yYRelationShipItemPagerAdapter != null) {
            yYRelationShipItemPagerAdapter.a(this.k);
        }
        YYRelationShipItemPagerAdapter yYRelationShipItemPagerAdapter2 = this.d;
        if (yYRelationShipItemPagerAdapter2 != null) {
            yYRelationShipItemPagerAdapter2.b(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YyRelationShipRoomFragment$JNnJv4tSHD1iUqKU78hCv6axYlI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YyRelationShipRoomFragment.a(YyRelationShipRoomFragment.this, view);
                }
            });
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding2 = this.f17497a;
        ViewPager viewPager3 = fragmentYyRelationItemBinding2 == null ? null : fragmentYyRelationItemBinding2.k;
        if (viewPager3 != null) {
            viewPager3.setAdapter(this.d);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding3 = this.f17497a;
        ViewPager viewPager4 = fragmentYyRelationItemBinding3 == null ? null : fragmentYyRelationItemBinding3.k;
        if (viewPager4 != null) {
            viewPager4.setOffscreenPageLimit(2);
        }
        YYRelationShipItemPagerAdapter yYRelationShipItemPagerAdapter3 = this.d;
        if (yYRelationShipItemPagerAdapter3 != null) {
            yYRelationShipItemPagerAdapter3.a(this.g);
        }
        YYRelationShipItemPagerAdapter yYRelationShipItemPagerAdapter4 = this.d;
        if (yYRelationShipItemPagerAdapter4 != null) {
            yYRelationShipItemPagerAdapter4.b(arrayList);
        }
        final int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.dp_15);
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding4 = this.f17497a;
        ViewGroup.LayoutParams layoutParams = (fragmentYyRelationItemBinding4 == null || (shapeFrameLayout = fragmentYyRelationItemBinding4.e) == null) ? null : shapeFrameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = arrayList.size() * dimensionPixelOffset;
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding5 = this.f17497a;
        ShapeFrameLayout shapeFrameLayout2 = fragmentYyRelationItemBinding5 == null ? null : fragmentYyRelationItemBinding5.e;
        if (shapeFrameLayout2 != null) {
            shapeFrameLayout2.setLayoutParams(layoutParams);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding6 = this.f17497a;
        ViewGroup.LayoutParams layoutParams2 = (fragmentYyRelationItemBinding6 == null || (shapeTextView = fragmentYyRelationItemBinding6.l) == null) ? null : shapeTextView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.leftMargin = 0;
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding7 = this.f17497a;
        ShapeTextView shapeTextView2 = fragmentYyRelationItemBinding7 == null ? null : fragmentYyRelationItemBinding7.l;
        if (shapeTextView2 != null) {
            shapeTextView2.setLayoutParams(layoutParams3);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding8 = this.f17497a;
        if (fragmentYyRelationItemBinding8 != null && (viewPager = fragmentYyRelationItemBinding8.k) != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment$initTabs$2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                    FragmentYyRelationItemBinding fragmentYyRelationItemBinding9;
                    ShapeTextView shapeTextView3;
                    FragmentYyRelationItemBinding fragmentYyRelationItemBinding10;
                    fragmentYyRelationItemBinding9 = YyRelationShipRoomFragment.this.f17497a;
                    ViewGroup.LayoutParams layoutParams4 = (fragmentYyRelationItemBinding9 == null || (shapeTextView3 = fragmentYyRelationItemBinding9.l) == null) ? null : shapeTextView3.getLayoutParams();
                    if (layoutParams4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    }
                    FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) layoutParams4;
                    int i3 = dimensionPixelOffset;
                    layoutParams5.leftMargin = (int) ((i * i3) + (i3 * f));
                    fragmentYyRelationItemBinding10 = YyRelationShipRoomFragment.this.f17497a;
                    ShapeTextView shapeTextView4 = fragmentYyRelationItemBinding10 == null ? null : fragmentYyRelationItemBinding10.l;
                    if (shapeTextView4 == null) {
                        return;
                    }
                    shapeTextView4.setLayoutParams(layoutParams5);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    if (arrayList.size() > i) {
                        YyRelationShipRoomFragment.this.a(arrayList.get(i));
                    }
                }
            });
        }
        a(arrayList.get(0));
        if (arrayList.size() == 1) {
            FragmentYyRelationItemBinding fragmentYyRelationItemBinding9 = this.f17497a;
            ShapeFrameLayout shapeFrameLayout3 = fragmentYyRelationItemBinding9 == null ? null : fragmentYyRelationItemBinding9.e;
            if (shapeFrameLayout3 == null) {
                return;
            }
            shapeFrameLayout3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode) {
        this.f = yYRelationShipRoomUserCardInfoMode;
        String data_id = yYRelationShipRoomUserCardInfoMode.getData_id();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.X(data_id, new BluedUIHttpResponse<BluedEntity<YYRelationShipRoomTaskItemMode, YYRelationShipRoomTaskExtraMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment$loadtask$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYRelationShipRoomTaskItemMode, YYRelationShipRoomTaskExtraMode> bluedEntity) {
                YYRelationShipRoomTaskExtraMode yYRelationShipRoomTaskExtraMode;
                YyRelationShipRoomFragment.TaskAdapter taskAdapter;
                List<YYRelationShipRoomTaskItemMode> list;
                if (bluedEntity == null || (yYRelationShipRoomTaskExtraMode = bluedEntity.extra) == null) {
                    return;
                }
                YyRelationShipRoomFragment yyRelationShipRoomFragment = YyRelationShipRoomFragment.this;
                yyRelationShipRoomFragment.e = yYRelationShipRoomTaskExtraMode;
                ArrayList<YYRelationShipRoomTask> task = yYRelationShipRoomTaskExtraMode.getTask();
                if (task != null) {
                    for (YYRelationShipRoomTask yYRelationShipRoomTask : task) {
                        if (bluedEntity != null && (list = bluedEntity.data) != null) {
                            for (YYRelationShipRoomTaskItemMode yYRelationShipRoomTaskItemMode : list) {
                                if (StringUtils.a(yYRelationShipRoomTask.getTask_id(), yYRelationShipRoomTaskItemMode.getTask_id())) {
                                    yYRelationShipRoomTask.setItemExtra(yYRelationShipRoomTaskItemMode);
                                }
                            }
                        }
                    }
                }
                ArrayList<YYRelationShipRoomTask> task2 = yYRelationShipRoomTaskExtraMode.getTask();
                if (task2 == null) {
                    return;
                }
                task2.add(0, new YYRelationShipRoomTask(1, "", "", 0, "", "", null, 0, "", ""));
                task2.add(new YYRelationShipRoomTask(2, "", yYRelationShipRoomTaskExtraMode.getRemark2(), 0, "", "", null, 0, "", ""));
                taskAdapter = yyRelationShipRoomFragment.f17498c;
                taskAdapter.setNewData(task2);
            }
        }, getFragmentActive());
    }

    private final void d() {
        FragmentYyRelationItemBinding a2 = FragmentYyRelationItemBinding.a(this.i);
        this.f17497a = a2;
        RecyclerView recyclerView = a2 == null ? null : a2.f;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this.f17497a;
        RecyclerView recyclerView2 = fragmentYyRelationItemBinding == null ? null : fragmentYyRelationItemBinding.f;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f17498c);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding2 = this.f17497a;
        RecyclerView recyclerView3 = fragmentYyRelationItemBinding2 == null ? null : fragmentYyRelationItemBinding2.g;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding3 = this.f17497a;
        RecyclerView recyclerView4 = fragmentYyRelationItemBinding3 == null ? null : fragmentYyRelationItemBinding3.g;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(this.b);
        }
        v();
        e();
    }

    private final void e() {
        YYRelationShipRoomMode yYRelationShipRoomMode = this.g;
        String id = yYRelationShipRoomMode == null ? null : yYRelationShipRoomMode.getId();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.W(id, new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomUserCardInfoMode>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomUserCardInfoMode> bluedEntityA) {
                List<YYRelationShipRoomUserCardInfoMode> list;
                ArrayList arrayList = new ArrayList();
                if (bluedEntityA != null && (list = bluedEntityA.data) != null) {
                    int size = list.size();
                    for (int i = 0; i < size && i < 5; i++) {
                        arrayList.add(list.get(i));
                    }
                }
                YyRelationShipRoomFragment.this.a(new ArrayList(arrayList));
            }
        }, getFragmentActive());
    }

    private final void v() {
        YYRelationShipRoomUiInfo resource_options;
        ShapeFrameLayout shapeFrameLayout;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ShapeConstraintLayout shapeConstraintLayout;
        YYRelationShipRoomMode yYRelationShipRoomMode = this.g;
        if (yYRelationShipRoomMode == null || (resource_options = yYRelationShipRoomMode.getResource_options()) == null) {
            return;
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this.f17497a;
        if (fragmentYyRelationItemBinding != null && (shapeConstraintLayout = fragmentYyRelationItemBinding.b) != null) {
            ShapeModel shapeModel = shapeConstraintLayout.getShapeModel();
            shapeModel.t = Color.parseColor(resource_options.getTheme_color_7());
            shapeModel.v = Color.parseColor("#ffffff");
            shapeConstraintLayout.setShapeModel(shapeModel);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding2 = this.f17497a;
        if (fragmentYyRelationItemBinding2 != null && (shapeTextView2 = fragmentYyRelationItemBinding2.f16542c) != null) {
            ShapeModel shapeModel2 = shapeTextView2.getShapeModel();
            shapeModel2.k = Color.parseColor(resource_options.getTheme_color_3());
            shapeTextView2.setShapeModel(shapeModel2);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding3 = this.f17497a;
        if (fragmentYyRelationItemBinding3 != null && (shapeTextView = fragmentYyRelationItemBinding3.l) != null) {
            ShapeModel shapeModel3 = shapeTextView.getShapeModel();
            shapeModel3.k = Color.parseColor(resource_options.getTheme_color_3());
            shapeTextView.setShapeModel(shapeModel3);
        }
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding4 = this.f17497a;
        if (fragmentYyRelationItemBinding4 == null || (shapeFrameLayout = fragmentYyRelationItemBinding4.e) == null) {
            return;
        }
        ShapeModel shapeModel4 = shapeFrameLayout.getShapeModel();
        shapeModel4.k = Color.parseColor(resource_options.get20Color());
        shapeFrameLayout.setShapeModel(shapeModel4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Fragment a2;
        YYRelationShipItemPagerAdapter yYRelationShipItemPagerAdapter = this.d;
        if (yYRelationShipItemPagerAdapter == null || (a2 = yYRelationShipItemPagerAdapter.a()) == null || !(a2 instanceof YyRelationShipRoomItemFragment)) {
            return;
        }
        ((YyRelationShipRoomItemFragment) a2).e();
    }

    private final void x() {
        String str;
        FragmentYyRelationItemBinding fragmentYyRelationItemBinding = this.f17497a;
        String str2 = null;
        LinearLayout linearLayout = fragmentYyRelationItemBinding == null ? null : fragmentYyRelationItemBinding.d;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str3 = "";
        if (b != null && (str = b.room_id) != null) {
            str3 = str;
        }
        YYRelationShipRoomMode yYRelationShipRoomMode = this.g;
        if (yYRelationShipRoomMode != null) {
            str2 = yYRelationShipRoomMode.getId();
        }
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.t(str3, str2, new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomUser>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YyRelationShipRoomFragment$loadUs$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomUser> bluedEntityA) {
                List<YYRelationShipRoomUser> list;
                YyRelationShipRoomFragment.UserAdapter userAdapter;
                FragmentYyRelationItemBinding fragmentYyRelationItemBinding2;
                if (bluedEntityA == null || (list = bluedEntityA.data) == null) {
                    return;
                }
                YyRelationShipRoomFragment yyRelationShipRoomFragment = YyRelationShipRoomFragment.this;
                if (list.size() > 0) {
                    fragmentYyRelationItemBinding2 = yyRelationShipRoomFragment.f17497a;
                    LinearLayout linearLayout2 = fragmentYyRelationItemBinding2 == null ? null : fragmentYyRelationItemBinding2.d;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
                list.add(0, new YYRelationShipRoomUser(1, "", "", 0, 0, "", "", "", ""));
                userAdapter = yyRelationShipRoomFragment.b;
                userAdapter.setNewData(list);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public final void a(YYRelationShipRoomMode yYRelationShipRoomMode) {
        this.g = yYRelationShipRoomMode;
    }

    public final YYRelationShipRoomMode b() {
        return this.g;
    }

    public final View.OnClickListener c() {
        return this.k;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_relation_item;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }
}
