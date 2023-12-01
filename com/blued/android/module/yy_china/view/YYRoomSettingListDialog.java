package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRoomSettingListBinding;
import com.blued.android.module.yy_china.databinding.ItemYyRoomSettingHostBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.model.RoomSettingManagerMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.view.YYRoomSettingListDialog;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomSettingListDialog.class */
public final class YYRoomSettingListDialog extends BaseFullScreenDialog {
    private DialogRoomSettingListBinding a;
    private String b = "";
    private OnChangeHostManagerListSizeListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomSettingListDialog$Ada.class */
    public final class Ada extends BaseMultiItemQuickAdapter<RoomSettingManagerMode, BaseViewHolder> {
        final /* synthetic */ YYRoomSettingListDialog a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ada(YYRoomSettingListDialog this$0) {
            super(new ArrayList());
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
            addItemType(0, R.layout.item_yy_room_setting_host);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(final YYRoomSettingListDialog this$0, final RoomSettingManagerMode roomSettingManagerMode, final Ada this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            String g = this$0.g();
            String uid = roomSettingManagerMode == null ? null : roomSettingManagerMode.getUid();
            final ActivityFragmentActive a = this$0.a();
            YYRoomHttpUtils.d(g, uid, 0, new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingListDialog$Ada$convert$2$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    List list;
                    List list2;
                    List<? extends RoomSettingManagerMode> mData;
                    list = YYRoomSettingListDialog.Ada.this.mData;
                    list.remove(roomSettingManagerMode);
                    YYRoomSettingListDialog.Ada.this.notifyDataSetChanged();
                    YYRoomSettingListDialog.OnChangeHostManagerListSizeListener h = this$0.h();
                    if (h != null) {
                        mData = YYRoomSettingListDialog.Ada.this.mData;
                        Intrinsics.c(mData, "mData");
                        h.a(mData);
                    }
                    list2 = YYRoomSettingListDialog.Ada.this.mData;
                    if (list2.size() == 0) {
                        this$0.i();
                    }
                }
            }, this$0.a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final RoomSettingManagerMode roomSettingManagerMode) {
            Intrinsics.e(helper, "helper");
            ItemYyRoomSettingHostBinding a = ItemYyRoomSettingHostBinding.a(helper.itemView);
            Intrinsics.c(a, "bind(helper.itemView)");
            if (roomSettingManagerMode != null) {
                ImageLoader.a(this.a.a(), roomSettingManagerMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a.a);
                a.c.setText(roomSettingManagerMode.getName());
            }
            ShapeTextView shapeTextView = a.b;
            final YYRoomSettingListDialog yYRoomSettingListDialog = this.a;
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingListDialog$Ada$Y42KFTDHOIPvElWuQAOUeTnIxlQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRoomSettingListDialog.Ada.a(YYRoomSettingListDialog.this, roomSettingManagerMode, this, view);
                }
            });
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomSettingListDialog$OnChangeHostManagerListSizeListener.class */
    public interface OnChangeHostManagerListSizeListener {
        void a(List<? extends RoomSettingManagerMode> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomSettingListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRoomSettingListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void j() {
        f().c.setLayoutManager(new LinearLayoutManager(getContext()));
        final RecyclerView.Adapter ada = new Ada(this);
        f().c.setAdapter(ada);
        String str = this.b;
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.a(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<RoomSettingManagerMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRoomSettingListDialog$initView$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RoomSettingManagerMode> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                    YYRoomSettingListDialog.this.f().d.setVisibility(0);
                } else {
                    ada.setNewData(bluedEntityA.data);
                }
            }
        }, (IRequestHost) a());
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingListDialog$i9nnvOFpBRHFGsNxQX7UJZvZv-o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingListDialog.a(YYRoomSettingListDialog.this, view);
            }
        });
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRoomSettingListDialog$7dc03W2KvK8_lHmXplATQm-BYwI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomSettingListDialog.b(YYRoomSettingListDialog.this, view);
            }
        });
    }

    public final void a(OnChangeHostManagerListSizeListener onChangeHostManagerListSizeListener) {
        this.c = onChangeHostManagerListSizeListener;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        return true;
    }

    public final DialogRoomSettingListBinding f() {
        DialogRoomSettingListBinding dialogRoomSettingListBinding = this.a;
        Intrinsics.a(dialogRoomSettingListBinding);
        return dialogRoomSettingListBinding;
    }

    public final String g() {
        return this.b;
    }

    public final OnChangeHostManagerListSizeListener h() {
        return this.c;
    }

    public final void i() {
        f().d.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_room_setting_list, viewGroup, true);
        this.a = DialogRoomSettingListBinding.a(inflate);
        j();
        return inflate;
    }
}
