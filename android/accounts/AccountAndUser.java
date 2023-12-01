package android.accounts;

/* loaded from: source-9557208-dex2jar.jar:android/accounts/AccountAndUser.class */
public class AccountAndUser {
    public Account account;
    public int userId;

    public AccountAndUser(Account account, int i) {
        this.account = account;
        this.userId = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountAndUser) {
            AccountAndUser accountAndUser = (AccountAndUser) obj;
            return this.account.equals(accountAndUser.account) && this.userId == accountAndUser.userId;
        }
        return false;
    }

    public int hashCode() {
        return this.account.hashCode() + this.userId;
    }

    public String toString() {
        return this.account.toString() + " u" + this.userId;
    }
}
