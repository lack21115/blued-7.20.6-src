package com.blued.android.module.live_china.manager;

import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGiftBagRedDotControlManager.class */
public final class LiveGiftBagRedDotControlManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13644a = new Companion(null);
    private final HashMap<String, String> b = new HashMap<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGiftBagRedDotControlManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGiftBagRedDotControlManager a() {
            return LiveRedDotControlManagerHelper.f13645a.a();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGiftBagRedDotControlManager$LiveRedDotControlManagerHelper.class */
    public static final class LiveRedDotControlManagerHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final LiveRedDotControlManagerHelper f13645a = new LiveRedDotControlManagerHelper();
        private static final LiveGiftBagRedDotControlManager b = new LiveGiftBagRedDotControlManager();

        private LiveRedDotControlManagerHelper() {
        }

        public final LiveGiftBagRedDotControlManager a() {
            return b;
        }
    }

    public final void a(String word) {
        Intrinsics.e(word, "word");
        this.b.put(word, word);
    }

    public final void b(String str) {
        TypeIntrinsics.i(this.b).remove(str);
        if (this.b.size() <= 0) {
            LiveEventBus.get("live_show_gift_bag_red_dot", Boolean.TYPE).post(false);
        }
    }
}
