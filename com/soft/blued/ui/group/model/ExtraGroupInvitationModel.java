package com.soft.blued.ui.group.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/ExtraGroupInvitationModel.class */
public class ExtraGroupInvitationModel extends BluedEntityBaseExtra {
    public List<GroupInvitaion> iid;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/model/ExtraGroupInvitationModel$GroupInvitaion.class */
    public class GroupInvitaion {
        public String iid;
        public String uid;

        public GroupInvitaion() {
        }
    }
}
