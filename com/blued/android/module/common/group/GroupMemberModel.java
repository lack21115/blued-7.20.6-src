package com.blued.android.module.common.group;

import com.blued.android.module.common.login.model.UserBasicModel;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/group/GroupMemberModel.class */
public class GroupMemberModel extends UserBasicModel implements Serializable {
    public int group_role;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.uid.equals(((GroupMemberModel) obj).uid);
    }

    public int hashCode() {
        return this.uid.hashCode();
    }
}
