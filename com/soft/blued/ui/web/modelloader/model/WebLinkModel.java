package com.soft.blued.ui.web.modelloader.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/WebLinkModel.class */
public final class WebLinkModel {
    private final List<String> black_list;
    private final List<String> white_list;

    public WebLinkModel() {
        this(null, null, 3, null);
    }

    public WebLinkModel(List<String> black_list, List<String> white_list) {
        Intrinsics.e(black_list, "black_list");
        Intrinsics.e(white_list, "white_list");
        this.black_list = black_list;
        this.white_list = white_list;
    }

    public /* synthetic */ WebLinkModel(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.b() : list, (i & 2) != 0 ? CollectionsKt.b() : list2);
    }

    public static /* synthetic */ WebLinkModel copy$default(WebLinkModel webLinkModel, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = webLinkModel.black_list;
        }
        if ((i & 2) != 0) {
            list2 = webLinkModel.white_list;
        }
        return webLinkModel.copy(list, list2);
    }

    public final List<String> component1() {
        return this.black_list;
    }

    public final List<String> component2() {
        return this.white_list;
    }

    public final WebLinkModel copy(List<String> black_list, List<String> white_list) {
        Intrinsics.e(black_list, "black_list");
        Intrinsics.e(white_list, "white_list");
        return new WebLinkModel(black_list, white_list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WebLinkModel) {
            WebLinkModel webLinkModel = (WebLinkModel) obj;
            return Intrinsics.a(this.black_list, webLinkModel.black_list) && Intrinsics.a(this.white_list, webLinkModel.white_list);
        }
        return false;
    }

    public final List<String> getBlack_list() {
        return this.black_list;
    }

    public final List<String> getWhite_list() {
        return this.white_list;
    }

    public int hashCode() {
        return (this.black_list.hashCode() * 31) + this.white_list.hashCode();
    }

    public String toString() {
        return "WebLinkModel(black_list=" + this.black_list + ", white_list=" + this.white_list + ')';
    }
}
