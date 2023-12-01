package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ishumei.dfp.SMSDK;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l.class */
public class l11l1111I1l {
    private static String l1111l111111Il = "sm";
    private static l11l1111I1l l111l1111lIl;
    private l111l1111lI1l l111l11111I1l;
    private l111l1111lI1l l111l11111Il;
    private l111l1111lI1l l111l11111lIl;
    private l111l1111lI1l l111l1111l1Il;
    private l111l1111lI1l l111l1111lI1l;
    private l111l1111lI1l l111l1111llIl;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l1111l111111Il.class */
    static abstract class l1111l111111Il extends l111l11111lIl {
        private l1111l111111Il() {
            super((byte) 0);
        }

        /* synthetic */ l1111l111111Il(byte b) {
            this();
        }

        private static String l111l11111Il() {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }

        protected abstract List<String> l1111l111111Il();

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public final void l1111l111111Il(String str) {
            List<String> l1111l111111Il;
            FileWriter fileWriter;
            try {
                if (!com.ishumei.l111l1111llIl.l111l1111lIl.l11l1111lIIl("android.permission.WRITE_EXTERNAL_STORAGE") || (l1111l111111Il = l1111l111111Il()) == null || l1111l111111Il.size() == 0) {
                    return;
                }
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                for (String str2 : l1111l111111Il) {
                    File file = new File(absolutePath + File.separator + str2);
                    try {
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            File file2 = new File(file.getPath() + ".tmp");
                            if (com.ishumei.l111l1111llIl.l111l1111lI1l.l1111l111111Il(str)) {
                                throw new IOException("file or bytes empty");
                            }
                            FileWriter fileWriter2 = null;
                            try {
                                fileWriter = new FileWriter(file2);
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                fileWriter.write(str);
                                fileWriter.close();
                                file2.renameTo(file);
                            } catch (Throwable th2) {
                                fileWriter2 = fileWriter;
                                th = th2;
                                if (fileWriter2 != null) {
                                    fileWriter2.close();
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public String l111l11111lIl() {
            List<String> l1111l111111Il;
            try {
                if (!com.ishumei.l111l1111llIl.l111l1111lIl.l11l1111lIIl("android.permission.READ_EXTERNAL_STORAGE") || (l1111l111111Il = l1111l111111Il()) == null || l1111l111111Il.size() == 0) {
                    return null;
                }
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                for (String str : l1111l111111Il) {
                    File file = new File(absolutePath + File.separator + str);
                    if (file.exists()) {
                        return com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(file);
                    }
                }
                return "";
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l11111I1l.class */
    static abstract class l111l11111I1l extends l111l11111lIl {
        private l111l11111I1l() {
            super((byte) 0);
        }

        /* synthetic */ l111l11111I1l(byte b) {
            this();
        }

        private static SharedPreferences l111l11111I1l(String str) {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences(str, 0);
        }

        protected abstract String l1111l111111Il();

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public final void l1111l111111Il(String str) {
            SharedPreferences l111l11111I1l;
            try {
                String l1111l111111Il = l1111l111111Il();
                String l111l11111Il = l111l11111Il();
                if (TextUtils.isEmpty(l1111l111111Il) || TextUtils.isEmpty(l111l11111Il) || (l111l11111I1l = l111l11111I1l(l1111l111111Il)) == null) {
                    return;
                }
                SharedPreferences.Editor edit = l111l11111I1l.edit();
                edit.putString(l111l11111Il, str);
                edit.apply();
            } catch (Exception e) {
            }
        }

        protected abstract String l111l11111Il();

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public String l111l11111lIl() {
            SharedPreferences l111l11111I1l;
            try {
                String l1111l111111Il = l1111l111111Il();
                String l111l11111Il = l111l11111Il();
                if (TextUtils.isEmpty(l1111l111111Il) || TextUtils.isEmpty(l111l11111Il) || (l111l11111I1l = l111l11111I1l(l1111l111111Il)) == null) {
                    return null;
                }
                return l111l11111I1l.getString(l111l11111Il, "");
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l11111Il.class */
    static final class l111l11111Il extends l1111l111111Il {
        private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d18b978a929d9c9e9c979aa0");
        private static final String[] l111l11111lIl = {com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d19e919b908d969b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("af969c8b8a8d9a8c"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb90889193909e9b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb909c8a929a918b8c")};
        private List<String> l111l11111I1l;
        private String l111l11111Il;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l111l11111Il(String str, String str2) {
            super((byte) 0);
            this.l111l11111Il = str;
            String str3 = l1111l111111Il + str2;
            this.l111l11111I1l = new ArrayList();
            String[] strArr = l111l11111lIl;
            for (int i = 0; i < 4; i++) {
                String str4 = strArr[i];
                this.l111l11111I1l.add(str4 + File.separator + str3);
            }
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l1111l111111Il
        protected final List<String> l1111l111111Il() {
            return this.l111l11111I1l;
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl, com.ishumei.l1111l111111Il.l11l1111I1l.l111l1111lI1l
        public final void l111l11111lIl(String str) {
            try {
                super.l111l11111lIl(com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl((this.l111l11111Il + BridgeUtil.UNDERLINE_STR + str).getBytes()));
            } catch (IOException e) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l11111lIl.class */
    static abstract class l111l11111lIl implements l111l1111lI1l {
        private ReadWriteLock l1111l111111Il;

        private l111l11111lIl() {
            this.l1111l111111Il = new ReentrantReadWriteLock(true);
        }

        /* synthetic */ l111l11111lIl(byte b) {
            this();
        }

        protected abstract void l1111l111111Il(String str);

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l1111lI1l
        public final String l111l11111I1l() {
            try {
                if (this.l1111l111111Il.readLock().tryLock(50L, TimeUnit.MILLISECONDS)) {
                    String l111l11111lIl = l111l11111lIl();
                    this.l1111l111111Il.readLock().unlock();
                    return l111l11111lIl;
                }
                return "";
            } catch (Exception e) {
                return "";
            }
        }

        protected abstract String l111l11111lIl();

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l1111lI1l
        public void l111l11111lIl(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.l1111l111111Il.writeLock().lock();
                l1111l111111Il(str);
            } catch (Exception e) {
            } catch (Throwable th) {
                this.l1111l111111Il.writeLock().unlock();
                throw th;
            }
            this.l1111l111111Il.writeLock().unlock();
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111l1Il.class */
    static final class l111l1111l1Il extends l1111l111111Il {
        private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c978a929a96d18b878b");
        private List<String> l111l11111lIl;

        l111l1111l1Il() {
            super((byte) 0);
            ArrayList arrayList = new ArrayList();
            this.l111l11111lIl = arrayList;
            arrayList.add(l1111l111111Il);
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l1111l111111Il
        protected final List<String> l1111l111111Il() {
            return this.l111l11111lIl;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l.class */
    public interface l111l1111lI1l {
        String l111l11111I1l();

        void l111l11111lIl(String str);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lIl.class */
    static final class l111l1111lIl extends l111l11111I1l {
        private String l1111l111111Il;

        l111l1111lIl(String str) {
            super((byte) 0);
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context == null) {
                return;
            }
            try {
                this.l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lIl.l111l1111l1Il(str + BridgeUtil.UNDERLINE_STR + context.getPackageName());
            } catch (Exception e) {
            }
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l1111l111111Il() {
            return this.l1111l111111Il;
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l111l11111Il() {
            return this.l1111l111111Il;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111llIl.class */
    static final class l111l1111llIl extends l1111l111111Il {
        private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d18b978a929d9c9e9c979aa0969b87a0");
        private static final String[] l111l11111lIl = {"", com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bbbcb6b2"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("af969c8b8a8d9a8c"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb90889193909e9b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb909c8a929a918b8c")};
        private List<String> l111l11111I1l;
        private String l111l11111Il;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l111l1111llIl(String str) {
            super((byte) 0);
            this.l111l11111Il = l1111l111111Il + str;
            this.l111l11111I1l = new ArrayList();
            String[] strArr = l111l11111lIl;
            for (int i = 0; i < 5; i++) {
                String str2 = strArr[i];
                this.l111l11111I1l.add(str2 + File.separator + this.l111l11111Il);
            }
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l1111l111111Il
        protected final List<String> l1111l111111Il() {
            return this.l111l11111I1l;
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l1111l111111Il, com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public final String l111l11111lIl() {
            String l111l11111lIl2 = super.l111l11111lIl();
            return TextUtils.isEmpty(l111l11111lIl2) ? "" : SMSDK.xx6(l111l11111lIl2, this.l111l11111Il);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l11l1111I11l.class */
    static final class l11l1111I11l extends l111l11111I1l {
        private l11l1111I11l() {
            super((byte) 0);
        }

        /* synthetic */ l11l1111I11l(byte b) {
            this();
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l1111l111111Il() {
            return com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l111l11111Il() {
            return com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");
        }
    }

    /* renamed from: com.ishumei.l1111l111111Il.l11l1111I1l$l11l1111I1l  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l11l1111I1l.class */
    static final class C0453l11l1111I1l extends l111l11111I1l {
        private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("a08c978a929a96");

        private C0453l11l1111I1l() {
            super((byte) 0);
        }

        /* synthetic */ C0453l11l1111I1l(byte b) {
            this();
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l1111l111111Il() {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            if (context == null) {
                return null;
            }
            return com.ishumei.l111l1111llIl.l111l1111lIl.l111l1111l1Il(context.getPackageName() + l1111l111111Il);
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l111l11111Il() {
            return l1111l111111Il();
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l, com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111lIl
        public final String l111l11111lIl() {
            String l111l11111lIl = super.l111l11111lIl();
            return TextUtils.isEmpty(l111l11111lIl) ? "" : SMSDK.xx6(l111l11111lIl, l1111l111111Il());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l11l1111I1l$l11l1111lIIl.class */
    static final class l11l1111lIIl extends l111l11111I1l {
        private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
        private static final String l111l11111lIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");

        l11l1111lIIl() {
            super((byte) 0);
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l1111l111111Il() {
            return l1111l111111Il;
        }

        @Override // com.ishumei.l1111l111111Il.l11l1111I1l.l111l11111I1l
        protected final String l111l11111Il() {
            return l111l11111lIl;
        }
    }

    private l11l1111I1l() {
    }

    public static l11l1111I1l l1111l111111Il() {
        if (l111l1111lIl == null) {
            synchronized (l11l1111I1l.class) {
                try {
                    if (l111l1111lIl == null) {
                        l111l1111lIl = new l11l1111I1l();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return l111l1111lIl;
    }

    private static String l1111l111111Il(List<l111l1111lI1l> list) {
        String l111l11111I1l2;
        for (l111l1111lI1l l111l1111li1l : list) {
            try {
                l111l11111I1l2 = l111l1111li1l.l111l11111I1l();
            } catch (Throwable th) {
            }
            if (!TextUtils.isEmpty(l111l11111I1l2)) {
                return l111l11111I1l2;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l1111l111111Il(com.ishumei.l1111l111111Il.l111l11111lIl l111l11111lil) {
        l111l11111lil.l111l1111l1Il(this.l111l11111lIl.l111l11111I1l());
        l111l11111lil.l111l1111llIl(this.l111l11111I1l.l111l11111I1l());
        l111l11111lil.l11l11l1I1l(this.l111l11111Il.l111l11111I1l());
        l111l11111lil.l1l11l1I1Il(this.l111l1111l1Il.l111l11111I1l());
        l111l11111lil.l11l11l1lI1l(this.l111l1111llIl.l111l11111I1l());
        l111l11111lil.l11l11l1I11l(this.l111l1111lI1l.l111l11111I1l());
        l111l11111lil.l11l1111Il1l(l111l11111Il());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l1111l111111Il(String str) {
        l111l1111lI1l l111l1111li1l = this.l111l11111lIl;
        if (l111l1111li1l != null) {
            l111l1111li1l.l111l11111lIl(str);
        }
        l111l1111lI1l l111l1111li1l2 = this.l111l11111I1l;
        if (l111l1111li1l2 != null) {
            l111l1111li1l2.l111l11111lIl(str);
        }
    }

    public final void l1111l111111Il(String str, String str2) {
        synchronized (this) {
            try {
                this.l111l11111lIl = new l111l1111lIl(str2);
                this.l111l11111I1l = new l111l11111Il(str2, str);
                this.l111l11111Il = new l11l1111I11l((byte) 0);
                this.l111l1111l1Il = new l111l1111l1Il();
                this.l111l1111llIl = new C0453l11l1111I1l((byte) 0);
                this.l111l1111lI1l = new l111l1111llIl(str);
            } catch (Exception e) {
            }
        }
    }

    public final String l111l11111I1l() {
        synchronized (this) {
            if (this.l111l11111I1l == null) {
                return "";
            }
            return this.l111l11111I1l.l111l11111I1l();
        }
    }

    public final String l111l11111Il() {
        String l111l11111I1l2;
        synchronized (this) {
            Iterator it = Arrays.asList(this.l111l11111lIl, this.l111l1111llIl, this.l111l11111Il).iterator();
            do {
                if (!it.hasNext()) {
                    return "";
                }
                l111l11111I1l2 = ((l111l1111lI1l) it.next()).l111l11111I1l();
            } while (TextUtils.isEmpty(l111l11111I1l2));
            return l111l11111I1l2;
        }
    }

    public final String l111l11111lIl() {
        synchronized (this) {
            if (this.l111l11111lIl == null) {
                return "";
            }
            return this.l111l11111lIl.l111l11111I1l();
        }
    }
}
