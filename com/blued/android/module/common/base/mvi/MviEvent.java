package com.blued.android.module.common.base.mvi;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent.class */
public abstract class MviEvent implements UiEvent {

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent$DataEmpty.class */
    public static final class DataEmpty extends MviEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final DataEmpty f10682a = new DataEmpty();

        private DataEmpty() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent$LoadData.class */
    public static final class LoadData<M> extends MviEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<M> f10683a;

        public LoadData() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public LoadData(List<? extends M> list) {
            super(null);
            this.f10683a = list;
        }

        public /* synthetic */ LoadData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.b() : list);
        }

        public final List<M> a() {
            return this.f10683a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadData) && Intrinsics.a(this.f10683a, ((LoadData) obj).f10683a);
        }

        public int hashCode() {
            List<M> list = this.f10683a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "LoadData(data=" + this.f10683a + ')';
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent$LoadFinished.class */
    public static final class LoadFinished extends MviEvent {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f10684a;
        private final boolean b;

        public LoadFinished() {
            this(false, false, 3, null);
        }

        public LoadFinished(boolean z, boolean z2) {
            super(null);
            this.f10684a = z;
            this.b = z2;
        }

        public /* synthetic */ LoadFinished(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean a() {
            return this.f10684a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadFinished) {
                LoadFinished loadFinished = (LoadFinished) obj;
                return this.f10684a == loadFinished.f10684a && this.b == loadFinished.b;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public String toString() {
            return "LoadFinished(succeed=" + this.f10684a + ", hasMore=" + this.b + ')';
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent$LoadStarted.class */
    public static final class LoadStarted extends MviEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final LoadStarted f10685a = new LoadStarted();

        private LoadStarted() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/MviEvent$ToastEvent.class */
    public static final class ToastEvent extends MviEvent {

        /* renamed from: a  reason: collision with root package name */
        private final String f10686a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToastEvent(String message) {
            super(null);
            Intrinsics.e(message, "message");
            this.f10686a = message;
        }

        public final String a() {
            return this.f10686a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToastEvent) && Intrinsics.a((Object) this.f10686a, (Object) ((ToastEvent) obj).f10686a);
        }

        public int hashCode() {
            return this.f10686a.hashCode();
        }

        public String toString() {
            return "ToastEvent(message=" + this.f10686a + ')';
        }
    }

    private MviEvent() {
    }

    public /* synthetic */ MviEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
