package com.blued.android.module.common.widget.emoji.manager;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/RecentEmojiManager.class */
public final class RecentEmojiManager implements RecentEmoji {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11151a;
    private EmojiList b = new EmojiList(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/RecentEmojiManager$Data.class */
    public static class Data {

        /* renamed from: a  reason: collision with root package name */
        final Emoji f11152a;
        final long b;

        Data(Emoji emoji, long j) {
            this.f11152a = emoji;
            this.b = j;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/RecentEmojiManager$EmojiList.class */
    static class EmojiList implements Iterable<Data> {

        /* renamed from: a  reason: collision with root package name */
        static final Comparator<Data> f11153a = new Comparator<Data>() { // from class: com.blued.android.module.common.widget.emoji.manager.RecentEmojiManager.EmojiList.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Data data, Data data2) {
                return Long.valueOf(data2.b).compareTo(Long.valueOf(data.b));
            }
        };
        final List<Data> b;

        EmojiList(int i) {
            this.b = new ArrayList(i);
        }

        Collection<Emoji> a() {
            Collections.sort(this.b, f11153a);
            ArrayList arrayList = new ArrayList(this.b.size());
            for (Data data : this.b) {
                arrayList.add(data.f11152a);
            }
            return arrayList;
        }

        void a(Emoji emoji) {
            a(emoji, System.currentTimeMillis());
        }

        void a(Emoji emoji, long j) {
            Iterator<Data> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next().f11152a.equals(emoji)) {
                    it.remove();
                }
            }
            this.b.add(0, new Data(emoji, j));
            if (this.b.size() > 35) {
                this.b.remove(35);
            }
        }

        int b() {
            return this.b.size();
        }

        @Override // java.lang.Iterable
        public Iterator<Data> iterator() {
            return this.b.iterator();
        }
    }

    public RecentEmojiManager(Context context) {
        this.f11151a = context.getApplicationContext();
    }

    private SharedPreferences c() {
        return this.f11151a.getSharedPreferences("emoji-recent-manager", 0);
    }

    public Collection<Emoji> a() {
        Emoji a2;
        if (this.b.b() == 0) {
            String string = c().getString("recent-emojis", "");
            if (string.length() > 0) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
                while (stringTokenizer.hasMoreTokens()) {
                    String[] split = stringTokenizer.nextToken().split(";");
                    if (split.length == 2 && (a2 = EmojiManager.a().a(split[0])) != null && a2.d() == split[0].length()) {
                        this.b.a(a2, Long.parseLong(split[1]));
                    }
                }
            }
        }
        return this.b.a();
    }

    public void a(Emoji emoji) {
        this.b.a(emoji);
    }

    public void b() {
        if (this.b.b() > 0) {
            StringBuilder sb = new StringBuilder(this.b.b() * 5);
            Iterator<Data> it = this.b.iterator();
            while (it.hasNext()) {
                Data next = it.next();
                sb.append(next.f11152a.a());
                sb.append(";");
                sb.append(next.b);
                sb.append(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
            }
            sb.setLength(sb.length() - 1);
            c().edit().putString("recent-emojis", sb.toString()).apply();
        }
    }
}
