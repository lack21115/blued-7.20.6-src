package com.soft.blued.ui.search.state;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction.class */
public abstract class SearchGlobalAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction$DoSearch.class */
    public static final class DoSearch extends SearchGlobalAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f33171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoSearch(String keywords) {
            super(null);
            Intrinsics.e(keywords, "keywords");
            this.f33171a = keywords;
        }

        public final String a() {
            return this.f33171a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoSearch) && Intrinsics.a((Object) this.f33171a, (Object) ((DoSearch) obj).f33171a);
        }

        public int hashCode() {
            return this.f33171a.hashCode();
        }

        public String toString() {
            return "DoSearch(keywords=" + this.f33171a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction$GetRecentRecord.class */
    public static final class GetRecentRecord extends SearchGlobalAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetRecentRecord f33172a = new GetRecentRecord();

        private GetRecentRecord() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction$GetShortcut.class */
    public static final class GetShortcut extends SearchGlobalAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f33173a;
        private final IRequestHost b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetShortcut(String keywords, IRequestHost iRequestHost) {
            super(null);
            Intrinsics.e(keywords, "keywords");
            this.f33173a = keywords;
            this.b = iRequestHost;
        }

        public final String a() {
            return this.f33173a;
        }

        public final IRequestHost b() {
            return this.b;
        }
    }

    private SearchGlobalAction() {
    }

    public /* synthetic */ SearchGlobalAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
