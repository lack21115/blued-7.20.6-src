package com.blued.community.ui.event.vm;

import android.os.Bundle;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventMemberViewModel.class */
public final class EventMemberViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f19590a = new ArrayList();
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f19591c = "";
    private int d;
    private boolean e;

    public final void a(int i) {
        this.d = i;
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("event_id", "");
        Intrinsics.c(string, "arguments.getString(Even…nts.DataKey.EVENT_ID, \"\")");
        a(string);
        String string2 = bundle.getString("event_uid", "");
        Intrinsics.c(string2, "arguments.getString(Even…nts.DataKey.EVENT_UID,\"\")");
        b(string2);
        a(bundle.getInt("event_quota_num", 0));
        c(bundle.getBoolean("event_is_free", false));
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f19591c = str;
    }

    public final void c(boolean z) {
        this.e = z;
    }
}
