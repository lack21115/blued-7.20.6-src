package com.blued.android.module.live_china.utils;

import android.os.CountDownTimer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils.class */
public final class LiveCountDownTimeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f14158a = new Companion(null);
    private static final Lazy<LiveCountDownTimeUtils> d = LazyKt.a(new Function0<LiveCountDownTimeUtils>() { // from class: com.blued.android.module.live_china.utils.LiveCountDownTimeUtils$Companion$INSTANCE$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveCountDownTimeUtils invoke() {
            return new LiveCountDownTimeUtils();
        }
    });
    private LiveCountDownTime b;

    /* renamed from: c  reason: collision with root package name */
    private long f14159c = 1000;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveCountDownTimeUtils a() {
            return (LiveCountDownTimeUtils) LiveCountDownTimeUtils.d.getValue();
        }

        public final LiveCountDownTimeUtils b() {
            return a();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$CountDownFinishListener.class */
    public interface CountDownFinishListener {
        void a();

        void a(long j);
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCountDownTimeUtils$LiveCountDownTime.class */
    public final class LiveCountDownTime extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownFinishListener f14161a;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CountDownFinishListener countDownFinishListener = this.f14161a;
            if (countDownFinishListener == null) {
                return;
            }
            countDownFinishListener.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CountDownFinishListener countDownFinishListener = this.f14161a;
            if (countDownFinishListener == null) {
                return;
            }
            countDownFinishListener.a(j);
        }
    }

    public final void a() {
        LiveCountDownTime liveCountDownTime = this.b;
        if (liveCountDownTime == null) {
            return;
        }
        liveCountDownTime.cancel();
    }
}
