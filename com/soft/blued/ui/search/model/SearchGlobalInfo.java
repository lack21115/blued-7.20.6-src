package com.soft.blued.ui.search.model;

import com.anythink.expressad.foundation.d.c;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/model/SearchGlobalInfo.class */
public final class SearchGlobalInfo implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19469a = new Companion(null);
    private int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f19470c = 1;
    private boolean d;
    private SearchSessionModel e;
    private SearchUserModel f;
    private GroupInfoModel g;
    private MyCircleModel h;
    private BluedTopic i;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/model/SearchGlobalInfo$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/model/SearchGlobalInfo$SearchShortcutModel.class */
    public static final class SearchShortcutModel {
        private final String icon_url;
        private final String name;
        private final String target_url;

        public SearchShortcutModel() {
            this(null, null, null, 7, null);
        }

        public SearchShortcutModel(String str, String str2, String str3) {
            Intrinsics.e(str, "name");
            Intrinsics.e(str2, c.H);
            Intrinsics.e(str3, "target_url");
            this.name = str;
            this.icon_url = str2;
            this.target_url = str3;
        }

        public /* synthetic */ SearchShortcutModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
        }

        public static /* synthetic */ SearchShortcutModel copy$default(SearchShortcutModel searchShortcutModel, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = searchShortcutModel.name;
            }
            if ((i & 2) != 0) {
                str2 = searchShortcutModel.icon_url;
            }
            if ((i & 4) != 0) {
                str3 = searchShortcutModel.target_url;
            }
            return searchShortcutModel.copy(str, str2, str3);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.icon_url;
        }

        public final String component3() {
            return this.target_url;
        }

        public final SearchShortcutModel copy(String str, String str2, String str3) {
            Intrinsics.e(str, "name");
            Intrinsics.e(str2, c.H);
            Intrinsics.e(str3, "target_url");
            return new SearchShortcutModel(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SearchShortcutModel) {
                SearchShortcutModel searchShortcutModel = (SearchShortcutModel) obj;
                return Intrinsics.a(this.name, searchShortcutModel.name) && Intrinsics.a(this.icon_url, searchShortcutModel.icon_url) && Intrinsics.a(this.target_url, searchShortcutModel.target_url);
            }
            return false;
        }

        public final String getIcon_url() {
            return this.icon_url;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTarget_url() {
            return this.target_url;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.icon_url.hashCode()) * 31) + this.target_url.hashCode();
        }

        public String toString() {
            return "SearchShortcutModel(name=" + this.name + ", icon_url=" + this.icon_url + ", target_url=" + this.target_url + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/model/SearchGlobalInfo$SearchUserModel.class */
    public static final class SearchUserModel extends UserBasicModel {
        private String recentMsg = "";

        public final String getRecentMsg() {
            return this.recentMsg;
        }

        public final void setRecentMsg(String str) {
            Intrinsics.e(str, "<set-?>");
            this.recentMsg = str;
        }
    }

    public final int a() {
        return this.f19470c;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(GroupInfoModel groupInfoModel) {
        this.g = groupInfoModel;
    }

    public final void a(MyCircleModel myCircleModel) {
        this.h = myCircleModel;
    }

    public final void a(BluedTopic bluedTopic) {
        this.i = bluedTopic;
    }

    public final void a(SearchUserModel searchUserModel) {
        this.f = searchUserModel;
    }

    public final void a(SearchSessionModel searchSessionModel) {
        this.e = searchSessionModel;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void b(int i) {
        this.f19470c = i;
    }

    public final boolean b() {
        return this.d;
    }

    public final SearchSessionModel c() {
        return this.e;
    }

    public final SearchUserModel d() {
        return this.f;
    }

    public final GroupInfoModel e() {
        return this.g;
    }

    public final MyCircleModel f() {
        return this.h;
    }

    public final BluedTopic g() {
        return this.i;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.b;
    }

    public final int getType() {
        return this.b;
    }
}
