package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import cn.irisgw.live.PrivilegeStatus;
import cn.irisgw.live.PrivilegeType;
import cn.irisgw.live.SyncTopAudienceExtra;
import cn.irisgw.live.UserProfile;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveCloakingTypeModel;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveCloakingUtil.class */
public class LiveCloakingUtil {
    public static boolean a = false;

    public static int a(List list) {
        int i = 0;
        if (!a()) {
            i = 0;
            if (list != null) {
                if (list.size() != 0) {
                    Iterator it = list.iterator();
                    while (true) {
                        i = 0;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (next instanceof UserProfile.UserPrivilege) {
                            UserProfile.UserPrivilege userPrivilege = (UserProfile.UserPrivilege) next;
                            if (userPrivilege.getType() == PrivilegeType.CONSUMER) {
                                int i2 = 0;
                                if (userPrivilege.getStatus() == PrivilegeStatus.OPEN) {
                                    i2 = 1;
                                }
                                return i2;
                            }
                        } else if (next instanceof SyncTopAudienceExtra.UserPrivilege) {
                            SyncTopAudienceExtra.UserPrivilege userPrivilege2 = (SyncTopAudienceExtra.UserPrivilege) next;
                            if (userPrivilege2.getType() == PrivilegeType.CONSUMER) {
                                i = 0;
                                if (userPrivilege2.getStatus() == PrivilegeStatus.OPEN) {
                                    i = 1;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    return 0;
                }
            }
        }
        return i;
    }

    public static String a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        if (length <= 1) {
            return str + "***" + str;
        }
        return str.substring(0, 1) + "***" + str.substring(length - 1);
    }

    public static String a(String str, int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        return a(str, z);
    }

    public static String a(String str, List<LiveCloakingTypeModel> list) {
        return !b(list) ? str : a(str);
    }

    public static String a(String str, boolean z) {
        String str2 = str;
        if (!a()) {
            if (!z) {
                return str;
            }
            str2 = a(str);
        }
        return str2;
    }

    public static boolean a() {
        return LiveRoomManager.a().p().profile.getUid() == LiveRoomInfo.a().g();
    }

    public static boolean a(LiveCloakingTypeModel liveCloakingTypeModel) {
        return !a() && liveCloakingTypeModel != null && liveCloakingTypeModel.is_qualified == 1 && liveCloakingTypeModel.privilege_status == 1;
    }

    public static boolean b(List<LiveCloakingTypeModel> list) {
        if (a()) {
            return false;
        }
        return a(c(list));
    }

    private static LiveCloakingTypeModel c(List<LiveCloakingTypeModel> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        for (LiveCloakingTypeModel liveCloakingTypeModel : list) {
            if (liveCloakingTypeModel.privilege_type == 2) {
                return liveCloakingTypeModel;
            }
        }
        return null;
    }
}
