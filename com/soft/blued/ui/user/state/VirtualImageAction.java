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
        public static final GetBeanCount f20624a = new GetBeanCount();

        private GetBeanCount() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetGuestImage.class */
    public static final class GetGuestImage extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f20625a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetGuestImage(String str) {
            super(null);
            Intrinsics.e(str, "uid");
            this.f20625a = str;
        }

        public final String a() {
            return this.f20625a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetGuestImage) && Intrinsics.a(this.f20625a, ((GetGuestImage) obj).f20625a);
        }

        public int hashCode() {
            return this.f20625a.hashCode();
        }

        public String toString() {
            return "GetGuestImage(uid=" + this.f20625a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetImageCategory.class */
    public static final class GetImageCategory extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetImageCategory f20626a = new GetImageCategory();

        private GetImageCategory() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$GetMarketingPicture.class */
    public static final class GetMarketingPicture extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetMarketingPicture f20627a = new GetMarketingPicture();

        private GetMarketingPicture() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VirtualImageAction$Save.class */
    public static final class Save extends VirtualImageAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f20628a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Save(String str) {
            super(null);
            Intrinsics.e(str, "goodsJson");
            this.f20628a = str;
        }

        public final String a() {
            return this.f20628a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Save) && Intrinsics.a(this.f20628a, ((Save) obj).f20628a);
        }

        public int hashCode() {
            return this.f20628a.hashCode();
        }

        public String toString() {
            return "Save(goodsJson=" + this.f20628a + ')';
        }
    }

    private VirtualImageAction() {
    }

    public /* synthetic */ VirtualImageAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
