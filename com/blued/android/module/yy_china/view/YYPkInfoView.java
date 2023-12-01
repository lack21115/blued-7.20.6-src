package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPkInfoView.class */
public final class YYPkInfoView extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f18366a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPkInfoView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean f() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        ImageView imageView;
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_room_pk_info, viewGroup, true);
        this.f18366a = inflate;
        if (inflate != null && (imageView = (ImageView) inflate.findViewById(R.id.iv_back)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPkInfoView$keOHtw8iyxLTyasf3wSTcDThdlI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYPkInfoView.a(YYPkInfoView.this, view);
                }
            });
        }
        return this.f18366a;
    }
}
