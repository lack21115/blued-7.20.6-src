package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/ShortcutInfoCompat.class */
public class ShortcutInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    Context f2367a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f2368c;
    Intent[] d;
    ComponentName e;
    CharSequence f;
    CharSequence g;
    CharSequence h;
    IconCompat i;
    boolean j;
    Person[] k;
    Set<String> l;
    LocusIdCompat m;
    boolean n;
    int o;
    PersistableBundle p;
    long q;
    UserHandle r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x = true;
    boolean y;
    int z;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/pm/ShortcutInfoCompat$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ShortcutInfoCompat f2369a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private Set<String> f2370c;
        private Map<String, Map<String, List<String>>> d;
        private Uri e;

        public Builder(Context context, ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f2369a = shortcutInfoCompat;
            shortcutInfoCompat.f2367a = context;
            this.f2369a.b = shortcutInfo.getId();
            this.f2369a.f2368c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            this.f2369a.d = (Intent[]) Arrays.copyOf(intents, intents.length);
            this.f2369a.e = shortcutInfo.getActivity();
            this.f2369a.f = shortcutInfo.getShortLabel();
            this.f2369a.g = shortcutInfo.getLongLabel();
            this.f2369a.h = shortcutInfo.getDisabledMessage();
            if (Build.VERSION.SDK_INT >= 28) {
                this.f2369a.z = shortcutInfo.getDisabledReason();
            } else {
                this.f2369a.z = shortcutInfo.isEnabled() ? 0 : 3;
            }
            this.f2369a.l = shortcutInfo.getCategories();
            this.f2369a.k = ShortcutInfoCompat.a(shortcutInfo.getExtras());
            this.f2369a.r = shortcutInfo.getUserHandle();
            this.f2369a.q = shortcutInfo.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2369a.s = shortcutInfo.isCached();
            }
            this.f2369a.t = shortcutInfo.isDynamic();
            this.f2369a.u = shortcutInfo.isPinned();
            this.f2369a.v = shortcutInfo.isDeclaredInManifest();
            this.f2369a.w = shortcutInfo.isImmutable();
            this.f2369a.x = shortcutInfo.isEnabled();
            this.f2369a.y = shortcutInfo.hasKeyFieldsOnly();
            this.f2369a.m = ShortcutInfoCompat.a(shortcutInfo);
            this.f2369a.o = shortcutInfo.getRank();
            this.f2369a.p = shortcutInfo.getExtras();
        }

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f2369a = shortcutInfoCompat;
            shortcutInfoCompat.f2367a = context;
            this.f2369a.b = str;
        }

        public Builder(ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.f2369a = shortcutInfoCompat2;
            shortcutInfoCompat2.f2367a = shortcutInfoCompat.f2367a;
            this.f2369a.b = shortcutInfoCompat.b;
            this.f2369a.f2368c = shortcutInfoCompat.f2368c;
            this.f2369a.d = (Intent[]) Arrays.copyOf(shortcutInfoCompat.d, shortcutInfoCompat.d.length);
            this.f2369a.e = shortcutInfoCompat.e;
            this.f2369a.f = shortcutInfoCompat.f;
            this.f2369a.g = shortcutInfoCompat.g;
            this.f2369a.h = shortcutInfoCompat.h;
            this.f2369a.z = shortcutInfoCompat.z;
            this.f2369a.i = shortcutInfoCompat.i;
            this.f2369a.j = shortcutInfoCompat.j;
            this.f2369a.r = shortcutInfoCompat.r;
            this.f2369a.q = shortcutInfoCompat.q;
            this.f2369a.s = shortcutInfoCompat.s;
            this.f2369a.t = shortcutInfoCompat.t;
            this.f2369a.u = shortcutInfoCompat.u;
            this.f2369a.v = shortcutInfoCompat.v;
            this.f2369a.w = shortcutInfoCompat.w;
            this.f2369a.x = shortcutInfoCompat.x;
            this.f2369a.m = shortcutInfoCompat.m;
            this.f2369a.n = shortcutInfoCompat.n;
            this.f2369a.y = shortcutInfoCompat.y;
            this.f2369a.o = shortcutInfoCompat.o;
            if (shortcutInfoCompat.k != null) {
                this.f2369a.k = (Person[]) Arrays.copyOf(shortcutInfoCompat.k, shortcutInfoCompat.k.length);
            }
            if (shortcutInfoCompat.l != null) {
                this.f2369a.l = new HashSet(shortcutInfoCompat.l);
            }
            if (shortcutInfoCompat.p != null) {
                this.f2369a.p = shortcutInfoCompat.p;
            }
        }

        public Builder addCapabilityBinding(String str) {
            if (this.f2370c == null) {
                this.f2370c = new HashSet();
            }
            this.f2370c.add(str);
            return this;
        }

        public Builder addCapabilityBinding(String str, String str2, List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.d == null) {
                    this.d = new HashMap();
                }
                if (this.d.get(str) == null) {
                    this.d.put(str, new HashMap());
                }
                this.d.get(str).put(str2, list);
            }
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.f2369a.f)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            if (this.f2369a.d == null || this.f2369a.d.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.b) {
                if (this.f2369a.m == null) {
                    ShortcutInfoCompat shortcutInfoCompat = this.f2369a;
                    shortcutInfoCompat.m = new LocusIdCompat(shortcutInfoCompat.b);
                }
                this.f2369a.n = true;
            }
            if (this.f2370c != null) {
                if (this.f2369a.l == null) {
                    this.f2369a.l = new HashSet();
                }
                this.f2369a.l.addAll(this.f2370c);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.d != null) {
                    if (this.f2369a.p == null) {
                        this.f2369a.p = new PersistableBundle();
                    }
                    for (String str : this.d.keySet()) {
                        Map<String, List<String>> map = this.d.get(str);
                        this.f2369a.p.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                        for (String str2 : map.keySet()) {
                            List<String> list = map.get(str2);
                            PersistableBundle persistableBundle = this.f2369a.p;
                            persistableBundle.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.e != null) {
                    if (this.f2369a.p == null) {
                        this.f2369a.p = new PersistableBundle();
                    }
                    this.f2369a.p.putString("extraSliceUri", UriCompat.toSafeString(this.e));
                }
            }
            return this.f2369a;
        }

        public Builder setActivity(ComponentName componentName) {
            this.f2369a.e = componentName;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.f2369a.j = true;
            return this;
        }

        public Builder setCategories(Set<String> set) {
            this.f2369a.l = set;
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.f2369a.h = charSequence;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.f2369a.p = persistableBundle;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.f2369a.i = iconCompat;
            return this;
        }

        public Builder setIntent(Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        public Builder setIntents(Intent[] intentArr) {
            this.f2369a.d = intentArr;
            return this;
        }

        public Builder setIsConversation() {
            this.b = true;
            return this;
        }

        public Builder setLocusId(LocusIdCompat locusIdCompat) {
            this.f2369a.m = locusIdCompat;
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.f2369a.g = charSequence;
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.f2369a.n = true;
            return this;
        }

        public Builder setLongLived(boolean z) {
            this.f2369a.n = z;
            return this;
        }

        public Builder setPerson(Person person) {
            return setPersons(new Person[]{person});
        }

        public Builder setPersons(Person[] personArr) {
            this.f2369a.k = personArr;
            return this;
        }

        public Builder setRank(int i) {
            this.f2369a.o = i;
            return this;
        }

        public Builder setShortLabel(CharSequence charSequence) {
            this.f2369a.f = charSequence;
            return this;
        }

        public Builder setSliceUri(Uri uri) {
            this.e = uri;
            return this;
        }
    }

    ShortcutInfoCompat() {
    }

    private PersistableBundle a() {
        if (this.p == null) {
            this.p = new PersistableBundle();
        }
        Person[] personArr = this.k;
        if (personArr != null && personArr.length > 0) {
            this.p.putInt("extraPersonCount", personArr.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k.length) {
                    break;
                }
                PersistableBundle persistableBundle = this.p;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i3 = i2 + 1;
                sb.append(i3);
                persistableBundle.putPersistableBundle(sb.toString(), this.k[i2].toPersistableBundle());
                i = i3;
            }
        }
        LocusIdCompat locusIdCompat = this.m;
        if (locusIdCompat != null) {
            this.p.putString("extraLocusId", locusIdCompat.getId());
        }
        this.p.putBoolean("extraLongLived", this.n);
        return this.p;
    }

    static LocusIdCompat a(ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (shortcutInfo.getLocusId() == null) {
                return null;
            }
            return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
        }
        return b(shortcutInfo.getExtras());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<ShortcutInfoCompat> a(Context context, List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo shortcutInfo : list) {
            arrayList.add(new Builder(context, shortcutInfo).build());
        }
        return arrayList;
    }

    static Person[] a(PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey("extraPersonCount")) {
            return null;
        }
        int i = persistableBundle.getInt("extraPersonCount");
        Person[] personArr = new Person[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return personArr;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("extraPerson_");
            int i4 = i3 + 1;
            sb.append(i4);
            personArr[i3] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i4;
        }
    }

    private static LocusIdCompat b(PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString("extraLocusId")) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent a(Intent intent) {
        Intent[] intentArr = this.d;
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intentArr[intentArr.length - 1]).putExtra(Intent.EXTRA_SHORTCUT_NAME, this.f.toString());
        if (this.i != null) {
            Drawable drawable = null;
            if (this.j) {
                PackageManager packageManager = this.f2367a.getPackageManager();
                ComponentName componentName = this.e;
                Drawable drawable2 = null;
                if (componentName != null) {
                    try {
                        drawable2 = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException e) {
                        drawable2 = null;
                    }
                }
                drawable = drawable2;
                if (drawable2 == null) {
                    drawable = this.f2367a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.i.addToShortcutIntent(intent, drawable, this.f2367a);
        }
        return intent;
    }

    public ComponentName getActivity() {
        return this.e;
    }

    public Set<String> getCategories() {
        return this.l;
    }

    public CharSequence getDisabledMessage() {
        return this.h;
    }

    public int getDisabledReason() {
        return this.z;
    }

    public PersistableBundle getExtras() {
        return this.p;
    }

    public IconCompat getIcon() {
        return this.i;
    }

    public String getId() {
        return this.b;
    }

    public Intent getIntent() {
        Intent[] intentArr = this.d;
        return intentArr[intentArr.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] intentArr = this.d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.q;
    }

    public LocusIdCompat getLocusId() {
        return this.m;
    }

    public CharSequence getLongLabel() {
        return this.g;
    }

    public String getPackage() {
        return this.f2368c;
    }

    public int getRank() {
        return this.o;
    }

    public CharSequence getShortLabel() {
        return this.f;
    }

    public UserHandle getUserHandle() {
        return this.r;
    }

    public boolean hasKeyFieldsOnly() {
        return this.y;
    }

    public boolean isCached() {
        return this.s;
    }

    public boolean isDeclaredInManifest() {
        return this.v;
    }

    public boolean isDynamic() {
        return this.t;
    }

    public boolean isEnabled() {
        return this.x;
    }

    public boolean isImmutable() {
        return this.w;
    }

    public boolean isPinned() {
        return this.u;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f2367a, this.b).setShortLabel(this.f).setIntents(this.d);
        IconCompat iconCompat = this.i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.f2367a));
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setLongLabel(this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            intents.setDisabledMessage(this.h);
        }
        ComponentName componentName = this.e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.o);
        PersistableBundle persistableBundle = this.p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.k;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    personArr2[i2] = this.k[i2].toAndroidPerson();
                    i = i2 + 1;
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.m;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.n);
        } else {
            intents.setExtras(a());
        }
        return intents.build();
    }
}
