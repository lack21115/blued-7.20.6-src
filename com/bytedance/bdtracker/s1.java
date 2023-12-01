package com.bytedance.bdtracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/s1.class */
public class s1 extends u1 {

    /* renamed from: c  reason: collision with root package name */
    public final AccountManager f7694c;
    public Account d;
    public final ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>();

    public s1(Context context) {
        this.f7694c = AccountManager.get(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Account account) {
        try {
            if (this.e.size() <= 0 || this.f7694c == null) {
                return;
            }
            for (Map.Entry<String, String> entry : this.e.entrySet()) {
                if (entry != null) {
                    this.f7694c.setUserData(account, entry.getKey(), entry.getValue());
                }
            }
            this.e.clear();
        } catch (Exception e) {
            z2.a(e);
        }
    }

    public void a(final Account account) {
        if (account != null) {
            this.d = account;
            if (this.e.size() <= 0) {
                return;
            }
            this.b.post(new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$s1$EeunYaDOvSXEw4vuVFLwvOjV7Hk
                @Override // java.lang.Runnable
                public final void run() {
                    s1.this.b(account);
                }
            });
        }
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str) {
        this.e.remove(str);
        try {
            if (this.d != null && this.f7694c != null) {
                this.f7694c.setUserData(this.d, str, null);
            }
        } catch (Exception e) {
        }
        u1 u1Var = this.f7708a;
        if (u1Var != null) {
            u1Var.a(str);
        }
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str, String str2) {
        Account account = this.d;
        if (account == null) {
            this.e.put(str, str2);
        } else if (str == null || str2 == null) {
        } else {
            try {
                this.f7694c.setUserData(account, str, str2);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }

    @Override // com.bytedance.bdtracker.u1
    public void a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        a(str, TextUtils.join("\n", strArr));
    }

    @Override // com.bytedance.bdtracker.u1
    public String b(String str) {
        Account account = this.d;
        if (account == null) {
            return this.e.get(str);
        }
        try {
            return this.f7694c.getUserData(account, str);
        } catch (Throwable th) {
            z2.a(th);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.u1
    public String[] c(String str) {
        String b = b(str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return b.split("\n");
    }
}
