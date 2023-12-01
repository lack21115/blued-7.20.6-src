package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.soft.blued.ui.msg.MsgChattingFragment;
import com.soft.blued.ui.msg_group.fragment.SearchMemberFragment;
import com.soft.blued.ui.user.fragment.ChooseFollowedFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AtChooseUserHelper.class */
public class AtChooseUserHelper {

    /* renamed from: a  reason: collision with root package name */
    private Context f21026a;
    private List<UserBasicModel> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private String f21027c = a("0");

    public AtChooseUserHelper(Context context) {
        this.f21026a = context;
    }

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) Integer.parseInt(split[i2]));
            i = i2 + 1;
        }
    }

    public static boolean c(String str) {
        String str2 = UserInfo.getInstance().getLoginUserInfo().uid;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.contains(str2) || str.contains(EncryptTool.b(str2));
    }

    public void a(EditText editText, Intent intent, TextWatcher textWatcher) {
        String stringExtra = intent.getStringExtra("UID");
        String stringExtra2 = intent.getStringExtra("USER_NAME");
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = stringExtra;
        userBasicModel.name = stringExtra2;
        a(editText, userBasicModel, textWatcher);
    }

    public void a(EditText editText, UserBasicModel userBasicModel, TextWatcher textWatcher) {
        a(editText, userBasicModel, textWatcher, true);
    }

    public void a(EditText editText, UserBasicModel userBasicModel, TextWatcher textWatcher, boolean z) {
        CharSequence text;
        CharSequence charSequence;
        if (userBasicModel != null) {
            String str = userBasicModel.uid;
            String str2 = userBasicModel.name;
            if (StringUtils.d(str) || StringUtils.d(str2)) {
                return;
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(userBasicModel);
            String str3 = "@" + userBasicModel.name + " " + this.f21027c;
            Editable text2 = editText.getText();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionEnd != 0) {
                text = z ? editText.getText().subSequence(0, selectionEnd - 1) : editText.getText().subSequence(0, selectionEnd);
                charSequence = editText.getText().subSequence(selectionEnd, text2.length());
            } else {
                text = editText.getText();
                charSequence = "";
            }
            editText.removeTextChangedListener(textWatcher);
            editText.setText("");
            editText.append(text);
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new ForegroundColorSpan(this.f21026a.getResources().getColor(2131101766)), 0, str3.length(), 33);
            spannableString.setSpan(new StyleSpan(1), 0, str3.length(), 33);
            editText.addTextChangedListener(textWatcher);
            editText.append(spannableString);
            editText.append(charSequence);
            if (selectionEnd != text2.length()) {
                if (z) {
                    editText.setSelection((selectionEnd + str3.length()) - 1);
                } else {
                    editText.setSelection(selectionEnd + str3.length());
                }
            }
        }
    }

    public boolean a(Object obj, int i, String str, String str2, Editable editable, int i2, int i3) {
        int i4;
        if (StringUtils.d(str2)) {
            return false;
        }
        if (!StringUtils.d(str) && str2.length() <= str.length()) {
            if (str2.length() == str.length() || StringUtils.d(str)) {
                return false;
            }
            int i5 = i2 + 1;
            if (this.f21027c.equals(str.substring(i2, i5))) {
                if (str.length() < i5) {
                    i5 = str.length();
                }
                int i6 = i5 - 1;
                if (this.f21027c.equals(str.substring(i6, i5))) {
                    CharSequence subSequence = editable.subSequence(0, i6);
                    String[] split = (((Object) subSequence) + "").split("@");
                    if (split.length >= 2) {
                        editable.delete((i6 - split[split.length - 1].length()) - 1, i6);
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        } else if (str2.length() < 1 || (i4 = i2 - 1) < 0) {
            return false;
        } else {
            if ((((Object) str2.subSequence(i4, i2)) + "").equals("@")) {
                if (obj != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("from", i);
                    if (!(obj instanceof BaseFragment)) {
                        if (obj instanceof Activity) {
                            Activity activity = (Activity) obj;
                            TerminalActivity.a(activity, ChooseFollowedFragment.class, bundle, i3);
                            ActivityChangeAnimationUtils.a(activity);
                            return true;
                        }
                        return true;
                    } else if (!(obj instanceof MsgChattingFragment)) {
                        BaseFragment baseFragment = (BaseFragment) obj;
                        TerminalActivity.a(baseFragment, ChooseFollowedFragment.class, bundle, i3);
                        ActivityChangeAnimationUtils.a(baseFragment.getActivity());
                        return true;
                    } else {
                        MsgChattingFragment msgChattingFragment = (MsgChattingFragment) obj;
                        int i7 = msgChattingFragment.h.m() == null ? 2 : msgChattingFragment.h.m().group_role;
                        Context context = msgChattingFragment.getContext();
                        SearchMemberFragment.a(context, 1, msgChattingFragment.h.f() + "", i7, i3);
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public boolean a(Object obj, String str, String str2, Editable editable, int i) {
        return a(obj, 0, str, str2, editable, i, 9090);
    }

    public String b(String str) {
        String str2;
        String str3 = str;
        if (!StringUtils.d(str)) {
            int i = 0;
            while (true) {
                int i2 = i;
                str2 = str;
                if (i2 >= this.b.size()) {
                    break;
                }
                String str4 = this.b.get(i2).uid;
                String str5 = this.b.get(i2).name;
                String b = StringUtils.b(this.b.get(i2).name, str4);
                while (true) {
                    if (str.contains("@" + str5)) {
                        str = str.replace("@" + str5, b);
                    }
                }
                i = i2 + 1;
            }
            while (true) {
                str3 = str2;
                if (!str2.contains(this.f21027c)) {
                    break;
                }
                str2 = str2.replace(this.f21027c, "");
            }
        }
        return str3;
    }
}
