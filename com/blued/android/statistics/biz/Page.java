package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.PageManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.page.PageDurationProtos;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Page.class */
public class Page {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Page$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Page a = new Page();

        private InstanceHolder() {
        }
    }

    private Page() {
    }

    public static Page a() {
        return InstanceHolder.a;
    }

    private void a(PageDurationProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        PageManager.a().a((PageManager) builder.build());
    }

    public void a(String str, String str2, long j) {
        a(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.DURATION).setName(Utils.b(str)).setPageCode(Utils.b(str2)).setTakes((int) j));
    }

    public void a(String str, String str2, String str3) {
        a(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.PATH).setName(Utils.b(str)).setPageCode(Utils.b(str2)).setPath(Utils.b(str3)));
    }
}
