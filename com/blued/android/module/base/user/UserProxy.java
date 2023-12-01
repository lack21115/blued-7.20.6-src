package com.blued.android.module.base.user;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/user/UserProxy.class */
public class UserProxy implements IUser {

    /* renamed from: a  reason: collision with root package name */
    private static UserProxy f10433a = new UserProxy();
    private IUser b;

    private UserProxy() {
    }

    public static UserProxy b() {
        return f10433a;
    }

    @Override // com.blued.android.module.base.user.IUser
    public String a() {
        IUser iUser = this.b;
        if (iUser != null) {
            return iUser.a();
        }
        return null;
    }

    public void a(IUser iUser) {
        this.b = iUser;
    }
}
