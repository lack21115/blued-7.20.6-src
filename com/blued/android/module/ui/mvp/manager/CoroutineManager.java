package com.blued.android.module.ui.mvp.manager;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/CoroutineManager.class */
public final class CoroutineManager {
    public static final Companion a = new Companion(null);
    private static final Lazy<CoroutineManager> c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<CoroutineManager>() { // from class: com.blued.android.module.ui.mvp.manager.CoroutineManager$Companion$coroutineManager$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final CoroutineManager invoke() {
            return new CoroutineManager();
        }
    });
    private final ConcurrentHashMap<String, Job> b = new ConcurrentHashMap<>();

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/manager/CoroutineManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
