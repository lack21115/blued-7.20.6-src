package com.blued.android.module.common.user;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.login.model.UserBasicModel;
import java.util.Random;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/UserInfoHelper.class */
public class UserInfoHelper {
    private static int a(int i, int i2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 7) {
                            if (i != 8) {
                                return 0;
                            }
                            return R.drawable.v_merchant;
                        }
                        return R.drawable.v_red;
                    }
                    return R.drawable.v_redribbon;
                }
                return R.drawable.v_yellow;
            }
            return R.drawable.v_purple;
        }
        return R.drawable.v_blue;
    }

    public static int a(ImageView imageView, UserBasicModel userBasicModel) {
        return a(imageView, userBasicModel, (IRequestHost) null);
    }

    public static int a(ImageView imageView, UserBasicModel userBasicModel, IRequestHost iRequestHost) {
        String str;
        int i;
        String str2;
        int nextInt;
        if (imageView == null || userBasicModel == null) {
            return 0;
        }
        ImageLoader.a(iRequestHost, imageView);
        if (userBasicModel.vip_exp_lvl <= 0) {
            imageView.setVisibility(8);
            return 0;
        }
        int i2 = userBasicModel.expire_type > 0 ? userBasicModel.expire_type : userBasicModel.vip_grade;
        if (userBasicModel.is_hide_vip_look == 1) {
            i2 = 0;
        }
        if (i2 == 1) {
            imageView.setVisibility(0);
            str = "vip_small_label_";
            i = 70;
        } else if (i2 != 2) {
            imageView.setVisibility(8);
            str = "_small_label_";
            i = 0;
        } else {
            imageView.setVisibility(0);
            str = "bluedx_small_label_";
            i = 124;
        }
        String str3 = str;
        int i3 = i;
        if (userBasicModel.is_vip_annual == 1) {
            String str4 = str + "year_";
            if (i2 == 2) {
                i3 = 144;
                str3 = str4;
            } else {
                str3 = str4;
                i3 = i;
                if (i2 == 1) {
                    i3 = 96;
                    str3 = str4;
                }
            }
        }
        userBasicModel.vip_exp_lvl = Math.min(userBasicModel.vip_exp_lvl, 9);
        String str5 = str3 + userBasicModel.vip_exp_lvl;
        String str6 = str5;
        if (userBasicModel.expire_type > 0) {
            str6 = str5 + "_expire";
        }
        int identifier = AppInfo.d().getResources().getIdentifier(str6, i.f7952c, AppInfo.d().getPackageName());
        if (userBasicModel.vip_exp_lvl < 8) {
            nextInt = 0;
            str2 = "";
        } else if (userBasicModel.expire_type > 0) {
            nextInt = 0;
            str2 = "";
        } else {
            str2 = str6 + ".png";
            nextInt = new Random().nextInt(100000);
            i3 = 130;
        }
        ImageLoader.c(iRequestHost, str2).b(identifier).e(nextInt).g(-1).a(imageView);
        return i3 / 2;
    }

    public static String a(Context context, TextView textView, String str) {
        String string = !TextUtils.isEmpty(str) ? "0".equals(str) ? context.getString(R.string.role_0) : "1".equals(str) ? context.getString(R.string.role_1) : "0.5".equals(str) ? context.getString(R.string.role_05) : "-1".equals(str) ? context.getString(R.string.role_other) : "0.75".equals(str) ? context.getString(R.string.role_05) : "0.25".equals(str) ? context.getString(R.string.role_05) : context.getString(R.string.role_other) : context.getString(R.string.role_other);
        if (textView != null) {
            textView.setText(string);
        }
        return string;
    }

    public static String a(Context context, String str) {
        return a(context, (TextView) null, str);
    }

    public static void a(int i, View view) {
        if (i == 8) {
            view.setVisibility(8);
        }
    }

    public static void a(Context context, TextView textView, UserBasicModel userBasicModel) {
        a(context, textView, userBasicModel, -1);
    }

    public static void a(Context context, TextView textView, UserBasicModel userBasicModel, int i) {
        if (textView == null || userBasicModel == null) {
            return;
        }
        int i2 = userBasicModel.vip_grade;
        if (userBasicModel.is_hide_vip_look == 1) {
            i2 = 0;
        }
        if (i2 == 1 || i2 == 2) {
            textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_g));
        } else if (i == -1) {
            textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_h));
        } else {
            textView.setTextColor(BluedSkinUtils.a(context, i));
        }
    }

    public static void a(ImageView imageView, int i) {
        int i2 = i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 7 ? i != 8 ? 0 : R.drawable.v_merchant : R.drawable.v_red : R.drawable.v_redribbon : R.drawable.v_yellow : R.drawable.v_purple : R.drawable.v_blue;
        if (i2 == 0) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setImageResource(i2);
        imageView.setVisibility(0);
    }

    public static void a(ImageView imageView, int i, int i2) {
        a(imageView, i, i2, 8);
    }

    public static void a(ImageView imageView, int i, int i2, int i3) {
        if (imageView != null) {
            int a2 = a(i, i2);
            if (a2 == 0) {
                imageView.setVisibility(i3);
                return;
            }
            imageView.setImageResource(a2);
            imageView.setVisibility(0);
        }
    }

    public static void a(ImageView imageView, int i, int i2, int i3, int i4) {
        a(imageView, i, i2, 4, i3, i4);
    }

    public static void a(ImageView imageView, int i, int i2, int i3, int i4, int i5) {
        if (imageView != null) {
            int a2 = a(i, i2);
            if (a2 == 0) {
                imageView.setVisibility(i3);
                return;
            }
            ImageLoader.a((IRequestHost) null, a2).a(i4, i5).a(imageView);
            imageView.setVisibility(0);
        }
    }

    public static void a(ImageView imageView, String str, boolean z, IRequestHost iRequestHost) {
        if (imageView == null) {
            return;
        }
        if (!z) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        ImageLoader.c(iRequestHost, "anim_chat_list.png").e(str.hashCode()).g(-1).a(imageView);
    }

    public static boolean a(int i) {
        return i == 5;
    }

    public static boolean a(String str) {
        if ("4".equals(str) || "12".equals(str)) {
            AppMethods.d(R.string.u_block_this_user);
            return true;
        } else if ("8".equals(str)) {
            AppMethods.d(R.string.been_blocked);
            return true;
        } else {
            return false;
        }
    }

    private static int b(int i, int i2) {
        if (i != 4) {
            if (i != 5) {
                if (i != 7) {
                    if (i != 8) {
                        return 0;
                    }
                    return R.drawable.v_merchant;
                }
                return R.drawable.v_red;
            }
            return R.drawable.v_redribbon;
        }
        return R.drawable.v_yellow;
    }

    public static int b(ImageView imageView, UserBasicModel userBasicModel, IRequestHost iRequestHost) {
        String str;
        int i;
        String str2;
        int nextInt;
        if (imageView == null) {
            return 0;
        }
        ImageLoader.a(iRequestHost, imageView);
        if (userBasicModel.vip_exp_lvl <= 0) {
            imageView.setVisibility(8);
            return 0;
        }
        int i2 = userBasicModel.expire_type > 0 ? userBasicModel.expire_type : userBasicModel.vip_grade;
        if (userBasicModel.is_hide_vip_look == 1) {
            i2 = 0;
        }
        if (i2 == 1) {
            imageView.setVisibility(0);
            str = "vip_short_label_";
            i = 70;
        } else if (i2 != 2) {
            imageView.setVisibility(8);
            str = "_short_label_";
            i = 0;
        } else {
            imageView.setVisibility(0);
            str = "bluedx_short_label_";
            i = 124;
        }
        String str3 = str;
        int i3 = i;
        if (userBasicModel.is_vip_annual == 1) {
            String str4 = str + "year_";
            if (i2 == 2) {
                i3 = 144;
                str3 = str4;
            } else {
                str3 = str4;
                i3 = i;
                if (i2 == 1) {
                    i3 = 96;
                    str3 = str4;
                }
            }
        }
        userBasicModel.vip_exp_lvl = Math.min(userBasicModel.vip_exp_lvl, 9);
        String str5 = str3 + userBasicModel.vip_exp_lvl;
        String str6 = str5;
        if (userBasicModel.expire_type > 0) {
            str6 = str5 + "_expire";
        }
        int identifier = AppInfo.d().getResources().getIdentifier(str6, i.f7952c, AppInfo.d().getPackageName());
        if (userBasicModel.vip_exp_lvl < 8) {
            nextInt = 0;
            str2 = "";
        } else if (userBasicModel.expire_type > 0) {
            nextInt = 0;
            str2 = "";
        } else {
            str2 = str6 + ".png";
            nextInt = new Random().nextInt(100000);
            i3 = 130;
        }
        ImageLoader.c(iRequestHost, str2).b(identifier).e(nextInt).g(-1).a(imageView);
        return i3 / 2;
    }

    public static String b(Context context, TextView textView, String str) {
        String string = !TextUtils.isEmpty(str) ? "0".equals(str) ? context.getString(R.string.role_0) : "1".equals(str) ? context.getString(R.string.role_1) : "0.5".equals(str) ? context.getString(R.string.role_05) : "-1".equals(str) ? context.getString(R.string.role_other) : "0.75".equals(str) ? context.getString(R.string.role_05) : "0.25".equals(str) ? context.getString(R.string.role_05) : context.getString(R.string.role_other) : " - ";
        if (textView != null) {
            textView.setText(string);
        }
        return string;
    }

    public static String b(Context context, String str) {
        return b(context, (TextView) null, str);
    }

    public static void b(ImageView imageView, int i) {
        a(imageView, i, 0);
    }

    public static void b(ImageView imageView, int i, int i2, int i3) {
        if (imageView != null) {
            int b = b(i, i2);
            if (b == 0) {
                imageView.setVisibility(i3);
                return;
            }
            imageView.setImageResource(b);
            imageView.setVisibility(0);
        }
    }

    public static boolean b(int i) {
        return i == 8;
    }

    public static boolean c(int i) {
        return i == 3 || i == 5 || i == 8;
    }
}
