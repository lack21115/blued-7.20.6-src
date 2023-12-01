package com.blued.community.ui.circle.model;

import com.brandongogetap.stickyheaders.exposed.StickyHeader;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleBaseMember.class */
public class CircleBaseMember {
    public static final int MUTE_CLOSE = 0;
    public static final int MUTE_OPEN = 1;
    public int admin_level;
    public List<Member> admins;
    public int admins_num;
    public List<Member> members;
    public int members_num;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleBaseMember$Member.class */
    public static class Member implements MultiItemEntity {
        public int adapterType = 0;
        public int admin_level;
        public String avatar;
        public int is_anonym;
        public int is_locked;
        public int is_mute;
        public int is_mute_tag;
        public int mute_time;
        public int mute_type;
        public String name;
        public int number;
        public String uid;

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return this.adapterType;
        }

        public boolean isJoin() {
            return this.admin_level != 3;
        }

        public boolean isManager() {
            return this.admin_level == 2;
        }

        public boolean isMember() {
            return this.admin_level == 0;
        }

        public boolean isNotMember() {
            return this.admin_level == 3;
        }

        public boolean isOwner() {
            return this.admin_level == 1;
        }

        public void setManager() {
            this.admin_level = 2;
        }

        public void setMember() {
            this.admin_level = 0;
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleBaseMember$MemberHeader.class */
    public static class MemberHeader extends Member implements StickyHeader {
    }
}
