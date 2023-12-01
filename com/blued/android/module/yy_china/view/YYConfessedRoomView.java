package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewConfessedRoomBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.ConfessedIMMode;
import com.blued.android.module.yy_china.model.ConfessedUserMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedRoomView.class */
public final class YYConfessedRoomView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewConfessedRoomBinding f18104a;
    private long b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYConfessedRoomView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYConfessedRoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYConfessedRoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewConfessedRoomBinding a2 = ViewConfessedRoomBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18104a = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseYYStudioFragment re, View view) {
        Intrinsics.e(re, "$re");
        YYConfessedListDialog yYConfessedListDialog = new YYConfessedListDialog();
        yYConfessedListDialog.a("room_display");
        FragmentManager childFragmentManager = re.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "re.childFragmentManager");
        yYConfessedListDialog.show(childFragmentManager, "YYConfessedListDialog");
    }

    public final void a(final BaseYYStudioFragment re, ConfessedIMMode da) {
        Intrinsics.e(re, "re");
        Intrinsics.e(da, "da");
        ImageLoader.a(re.getFragmentActive(), ImgURLMap.f10885a.a("yy_confessed_room_view_url_title")).a(this.f18104a.f16846a);
        ConfessedUserMode confession_user = da.getConfession_info().getConfession_user();
        if (confession_user != null) {
            ImageLoader.a(re.getFragmentActive(), confession_user.getAvatar()).b(R.drawable.user_bg_round).c().a(getBinding().b);
        }
        ConfessedUserMode being_confession_user_to = da.getConfession_info().getBeing_confession_user_to();
        if (being_confession_user_to != null) {
            ImageLoader.a(re.getFragmentActive(), being_confession_user_to.getAvatar()).b(R.drawable.user_bg_round).c().a(getBinding().d);
        }
        this.b = da.getConfession_info().getPosition_end_time();
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRoomView$R6rhADfWLbaGtHRQQPjrBo97Pgs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRoomView.a(BaseYYStudioFragment.this, view);
            }
        });
    }

    public final boolean a() {
        long currentTimeMillis = this.b - (System.currentTimeMillis() / 1000);
        if (currentTimeMillis <= 0) {
            setVisibility(8);
            return false;
        }
        TextView textView = this.f18104a.f;
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis);
        sb.append('s');
        textView.setText(sb.toString());
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (currentTimeMillis > 9999) {
            this.f18104a.f.setTextSize(9.0f);
            return true;
        }
        this.f18104a.f.setTextSize(11.0f);
        return true;
    }

    public final ViewConfessedRoomBinding getBinding() {
        return this.f18104a;
    }

    public final long getEnd_time() {
        return this.b;
    }

    public final void setBinding(ViewConfessedRoomBinding viewConfessedRoomBinding) {
        Intrinsics.e(viewConfessedRoomBinding, "<set-?>");
        this.f18104a = viewConfessedRoomBinding;
    }

    public final void setEnd_time(long j) {
        this.b = j;
    }
}
