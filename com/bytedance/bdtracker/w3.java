package com.bytedance.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.g4;
import com.bytedance.bdtracker.s3;
import com.youzan.androidsdk.tool.AppSigning;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w3.class */
public final class w3 implements s3 {

    /* renamed from: a  reason: collision with root package name */
    public final s3 f21334a;
    public f3<Boolean> b = new a(this);

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w3$a.class */
    public class a extends f3<Boolean> {
        public a(w3 w3Var) {
        }

        @Override // com.bytedance.bdtracker.f3
        public Boolean a(Object[] objArr) {
            try {
                PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo == null) {
                    return false;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            } catch (Throwable th) {
                z2.a(th);
                return false;
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/w3$b.class */
    public class b implements a4.b<g4, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f21335a;

        public b(Context context) {
            this.f21335a = context;
        }

        @Override // com.bytedance.bdtracker.a4.b
        public g4 a(IBinder iBinder) {
            return g4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(g4 g4Var) {
            g4 g4Var2 = g4Var;
            if (g4Var2 == null) {
                return null;
            }
            String c2 = w3.this.c(this.f21335a);
            if (TextUtils.isEmpty(c2)) {
                return null;
            }
            String packageName = this.f21335a.getPackageName();
            g4.a.C0311a c0311a = (g4.a.C0311a) g4Var2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(packageName);
                obtain.writeString(c2);
                obtain.writeString("OUID");
                c0311a.f21223a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public w3(s3 s3Var) {
        this.f21334a = s3Var;
    }

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        if (this.f21334a == null || this.b.b(new Object[0]).booleanValue()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            String str = (String) new a4(context, intent, new b(context)).a();
            s3.a aVar = new s3.a();
            aVar.f21305a = str;
            return aVar;
        }
        return this.f21334a.a(context);
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Boolean b2 = this.b.b(context);
        return (this.f21334a == null || b2.booleanValue()) ? b2.booleanValue() : this.f21334a.b(context);
    }

    public final String c(Context context) {
        Signature[] signatureArr;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            z2.a(e);
        }
        if (packageInfo != null) {
            signatureArr = packageInfo.signatures;
            if (signatureArr == null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(AppSigning.SHA1);
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                    return null;
                } catch (Exception e2) {
                    z2.a(e2);
                    return null;
                }
            }
        }
        signatureArr = null;
        return signatureArr == null ? null : null;
    }
}
