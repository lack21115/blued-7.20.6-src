package com.soft.blued.ui.search.state;

import com.blued.android.module.common.base.mvi.UiEvent;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalEvent.class */
public abstract class SearchGlobalEvent implements UiEvent {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalEvent$ShortcutEvent.class */
    public static final class ShortcutEvent extends SearchGlobalEvent {

        /* renamed from: a  reason: collision with root package name */
        private final List<SearchGlobalInfo.SearchShortcutModel> f33174a;

        public ShortcutEvent(List<SearchGlobalInfo.SearchShortcutModel> list) {
            super(null);
            this.f33174a = list;
        }

        public final List<SearchGlobalInfo.SearchShortcutModel> a() {
            return this.f33174a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShortcutEvent) && Intrinsics.a(this.f33174a, ((ShortcutEvent) obj).f33174a);
        }

        public int hashCode() {
            List<SearchGlobalInfo.SearchShortcutModel> list = this.f33174a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "ShortcutEvent(shortcutList=" + this.f33174a + ')';
        }
    }

    private SearchGlobalEvent() {
    }

    public /* synthetic */ SearchGlobalEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
