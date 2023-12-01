package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction.class */
public abstract class VirtualImageAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetBeanCount.class */
    public static final class GetBeanCount extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetBeanCount f34315a = new GetBeanCount();

        private GetBeanCount() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetGuestImage.class */
    public static final class GetGuestImage extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f34316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetGuestImage(String uid) {
            super(null);
            Intrinsics.e(uid, "uid");
            this.f34316a = uid;
        }

        public final String a() {
            return this.f34316a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetGuestImage) && Intrinsics.a((Object) this.f34316a, (Object) ((GetGuestImage) obj).f34316a);
        }

        public int hashCode() {
            return this.f34316a.hashCode();
        }

        public String toString() {
            return "GetGuestImage(uid=" + this.f34316a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetImageCategory.class */
    public static final class GetImageCategory extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetImageCategory f34317a = new GetImageCategory();

        private GetImageCategory() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetMarketingPicture.class */
    public static final class GetMarketingPicture extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetMarketingPicture f34318a = new GetMarketingPicture();

        private GetMarketingPicture() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$Save.class */
    public static final class Save extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f34319a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Save(String goodsJson) {
            super(null);
            Intrinsics.e(goodsJson, "goodsJson");
            this.f34319a = goodsJson;
        }

        public final String a() {
            return this.f34319a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Save) && Intrinsics.a((Object) this.f34319a, (Object) ((Save) obj).f34319a);
        }

        public int hashCode() {
            return this.f34319a.hashCode();
        }

        public String toString() {
            return "Save(goodsJson=" + this.f34319a + ')';
        }
    }

    private VirtualImageAction() {
    }

    public /* synthetic */ VirtualImageAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
