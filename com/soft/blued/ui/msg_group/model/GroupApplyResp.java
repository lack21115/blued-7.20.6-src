package com.soft.blued.ui.msg_group.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupApplyResp.class */
public final class GroupApplyResp {
    private String code = "";
    private int number;
    private List<User> users;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/GroupApplyResp$User.class */
    public static final class User {
        private String name = "";
        private String avatar = "";

        public final String getAvatar() {
            return this.avatar;
        }

        public final String getName() {
            return this.name;
        }

        public final void setAvatar(String str) {
            Intrinsics.e(str, "<set-?>");
            this.avatar = str;
        }

        public final void setName(String str) {
            Intrinsics.e(str, "<set-?>");
            this.name = str;
        }
    }

    public final String getCode() {
        return this.code;
    }

    public final int getNumber() {
        return this.number;
    }

    public final List<User> getUsers() {
        return this.users;
    }

    public final void setCode(String str) {
        Intrinsics.e(str, "<set-?>");
        this.code = str;
    }

    public final void setNumber(int i) {
        this.number = i;
    }

    public final void setUsers(List<User> list) {
        this.users = list;
    }
}
