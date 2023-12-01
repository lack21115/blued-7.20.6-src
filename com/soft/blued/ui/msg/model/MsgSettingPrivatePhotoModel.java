package com.soft.blued.ui.msg.model;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgSettingPrivatePhotoModel.class */
public class MsgSettingPrivatePhotoModel implements Serializable {
    public Me me;
    public Target target;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgSettingPrivatePhotoModel$Me.class */
    public class Me {
        public int has_photo;
        public int is_sharing;

        public Me() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgSettingPrivatePhotoModel$Target.class */
    public class Target {
        public int has_photo;
        public int is_sharing;

        public Target() {
        }
    }
}
