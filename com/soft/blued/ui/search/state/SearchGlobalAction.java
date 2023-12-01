package com.soft.blued.ui.search.state;

import android.provider.SearchIndexablesContract;
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
        private final String f19480a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoSearch(String str) {
            super(null);
            Intrinsics.e(str, SearchIndexablesContract.RawData.COLUMN_KEYWORDS);
            this.f19480a = str;
        }

        public final String a() {
            return this.f19480a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoSearch) && Intrinsics.a(this.f19480a, ((DoSearch) obj).f19480a);
        }

        public int hashCode() {
            return this.f19480a.hashCode();
        }

        public String toString() {
            return "DoSearch(keywords=" + this.f19480a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction$GetRecentRecord.class */
    public static final class GetRecentRecord extends SearchGlobalAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetRecentRecord f19481a = new GetRecentRecord();

        private GetRecentRecord() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalAction$GetShortcut.class */
    public static final class GetShortcut extends SearchGlobalAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f19482a;
        private final IRequestHost b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetShortcut(String str, IRequestHost iRequestHost) {
            super(null);
            Intrinsics.e(str, SearchIndexablesContract.RawData.COLUMN_KEYWORDS);
            this.f19482a = str;
            this.b = iRequestHost;
        }

        public final String a() {
            return this.f19482a;
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
