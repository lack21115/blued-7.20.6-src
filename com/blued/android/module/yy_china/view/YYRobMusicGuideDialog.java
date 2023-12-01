package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyRobMusicGuideBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRobMusicGuideDialog.class */
public final class YYRobMusicGuideDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyRobMusicGuideBinding f18437a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRobMusicGuideDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final ViewYyRobMusicGuideBinding f() {
        ViewYyRobMusicGuideBinding viewYyRobMusicGuideBinding = this.f18437a;
        Intrinsics.a(viewYyRobMusicGuideBinding);
        return viewYyRobMusicGuideBinding;
    }

    private final void g() {
        f().f16951a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRobMusicGuideDialog$tvoOVaY7qcFtCZ-KTknbKCCWpl8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRobMusicGuideDialog.a(YYRobMusicGuideDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18437a = ViewYyRobMusicGuideBinding.a(inflater.inflate(R.layout.view_yy_rob_music_guide, viewGroup, true));
        g();
        return f().getRoot();
    }
}
