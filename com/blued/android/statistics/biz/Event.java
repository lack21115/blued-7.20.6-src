package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.EventManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.event.CustomEventProtos;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Event.class */
public class Event {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/biz/Event$InstanceHolder.class */
    public static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final Event f18689a = new Event();

        private InstanceHolder() {
        }
    }

    private Event() {
    }

    public static Event a() {
        return InstanceHolder.f18689a;
    }

    private void a(CustomEventProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        EventManager.a().a((EventManager) builder.build());
    }

    public void a(String str, long j, int i, String str2) {
        b(str, j, i, str2);
    }

    public void b(String str, long j, int i, String str2) {
        a(CustomEventProtos.Request.newBuilder().setTakes((int) j).setName(Utils.b(str)).setCode(i).setDescription(Utils.b(str2)));
    }
}
