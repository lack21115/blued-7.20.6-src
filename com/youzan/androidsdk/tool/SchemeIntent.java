package com.youzan.androidsdk.tool;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.telecom.PhoneAccount;
import android.text.TextUtils;
import android.widget.Toast;
import com.youzan.androidsdk.YouzanException;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/SchemeIntent.class */
public final class SchemeIntent {
    public static boolean handleAlive(final Context context, final Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !isAliveType(scheme)) {
            return false;
        }
        new AlertDialog.Builder(context).setMessage("网页请求打开应用").setPositiveButton("打开", new DialogInterface.OnClickListener() { // from class: com.youzan.androidsdk.tool.SchemeIntent.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.this);
                if (!(context instanceof Activity)) {
                    intent.setFlags(276824064);
                }
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            }
        }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setIcon(R.drawable.ic_dialog_alert).show();
        return true;
    }

    public static boolean handleSilently(Context context, Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !isSilentType(scheme)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(uri.toString(), 1);
            parseUri.setFlags(536870912);
            parseUri.addCategory(Intent.CATEGORY_BROWSABLE);
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            if (context instanceof Activity) {
                return m9198(parseUri, (Activity) context);
            }
            try {
                parseUri.setFlags(276824064);
                context.startActivity(parseUri);
                return true;
            } catch (ActivityNotFoundException e) {
                throw new YouzanException("系统未安装相应应用");
            }
        } catch (YouzanException e2) {
            Toast.makeText(context, e2.getMsg(), 0).show();
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean isAliveType(String str) {
        return "sms".equalsIgnoreCase(str) || PhoneAccount.SCHEME_TEL.equalsIgnoreCase(str) || "mailto".equalsIgnoreCase(str) || "geo".equalsIgnoreCase(str);
    }

    public static boolean isSilentType(String str) {
        return "weixin".equalsIgnoreCase(str) || "alipays".equalsIgnoreCase(str) || "mqqwpa".equalsIgnoreCase(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m9198(Intent intent, Activity activity) throws YouzanException {
        Activity parent = activity.getParent();
        if (parent != null) {
            activity = parent;
        }
        try {
            intent.setFlags(536870912);
            return activity.startActivityIfNeeded(intent, -1);
        } catch (ActivityNotFoundException e) {
            throw new YouzanException("系统未安装相应应用");
        }
    }
}
