package com.blued.android.module.yy_china.view;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/NewSongMessHandler.class */
public final class NewSongMessHandler extends Handler {
    private final WeakReference<KtvNewSongMessageView> a;

    public NewSongMessHandler(KtvNewSongMessageView view) {
        Intrinsics.e(view, "view");
        this.a = new WeakReference<>(view);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.e(msg, "msg");
        super.handleMessage(msg);
        KtvNewSongMessageView ktvNewSongMessageView = this.a.get();
        if (ktvNewSongMessageView == null) {
            return;
        }
        ktvNewSongMessageView.c();
    }
}
