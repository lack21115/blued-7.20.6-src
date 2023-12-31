package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiEvent;
import com.soft.blued.ui.user.model.VirtualImageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent.class */
public abstract class VirtualImageEvent implements UiEvent {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent$BeanCount.class */
    public static final class BeanCount extends VirtualImageEvent {

        /* renamed from: a  reason: collision with root package name */
        private long f20629a;

        public BeanCount(long j) {
            super(null);
            this.f20629a = j;
        }

        public final long a() {
            return this.f20629a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BeanCount) && this.f20629a == ((BeanCount) obj).f20629a;
        }

        public int hashCode() {
            return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f20629a);
        }

        public String toString() {
            return "BeanCount(beanCount=" + this.f20629a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent$ErrorEvent.class */
    public static final class ErrorEvent extends VirtualImageEvent {

        /* renamed from: a  reason: collision with root package name */
        public static final ErrorEvent f20630a = new ErrorEvent();

        private ErrorEvent() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent$GoodsEvent.class */
    public static final class GoodsEvent extends VirtualImageEvent {

        /* renamed from: a  reason: collision with root package name */
        private List<VirtualImageModel.ImageGoodsModel> f20631a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoodsEvent(List<VirtualImageModel.ImageGoodsModel> list) {
            super(null);
            Intrinsics.e(list, "goodsList");
            this.f20631a = list;
        }

        public final List<VirtualImageModel.ImageGoodsModel> a() {
            return this.f20631a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GoodsEvent) && Intrinsics.a(this.f20631a, ((GoodsEvent) obj).f20631a);
        }

        public int hashCode() {
            return this.f20631a.hashCode();
        }

        public String toString() {
            return "GoodsEvent(goodsList=" + this.f20631a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent$MarketingPictureEvent.class */
    public static final class MarketingPictureEvent extends VirtualImageEvent {

        /* renamed from: a  reason: collision with root package name */
        private VirtualImageModel.MarketingPicture f20632a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MarketingPictureEvent(VirtualImageModel.MarketingPicture marketingPicture) {
            super(null);
            Intrinsics.e(marketingPicture, "picture");
            this.f20632a = marketingPicture;
        }

        public final VirtualImageModel.MarketingPicture a() {
            return this.f20632a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MarketingPictureEvent) && Intrinsics.a(this.f20632a, ((MarketingPictureEvent) obj).f20632a);
        }

        public int hashCode() {
            return this.f20632a.hashCode();
        }

        public String toString() {
            return "MarketingPictureEvent(picture=" + this.f20632a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageEvent$SaveEvent.class */
    public static final class SaveEvent extends VirtualImageEvent {

        /* renamed from: a  reason: collision with root package name */
        private boolean f20633a;

        public SaveEvent(boolean z) {
            super(null);
            this.f20633a = z;
        }

        public final boolean a() {
            return this.f20633a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SaveEvent) && this.f20633a == ((SaveEvent) obj).f20633a;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public String toString() {
            return "SaveEvent(succeed=" + this.f20633a + ')';
        }
    }

    private VirtualImageEvent() {
    }

    public /* synthetic */ VirtualImageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
