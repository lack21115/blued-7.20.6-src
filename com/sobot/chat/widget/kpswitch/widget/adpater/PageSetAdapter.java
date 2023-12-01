package com.sobot.chat.widget.kpswitch.widget.adpater;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.sobot.chat.widget.kpswitch.widget.data.PageEntity;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/adpater/PageSetAdapter.class */
public class PageSetAdapter extends PagerAdapter {
    private final ArrayList<PageSetEntity> mPageSetEntityList = new ArrayList<>();

    public void add(int i, View view) {
        this.mPageSetEntityList.add(i, new PageSetEntity.Builder().addPageEntity(new PageEntity(view)).setShowIndicator(false).build());
    }

    public void add(int i, PageSetEntity pageSetEntity) {
        if (pageSetEntity == null) {
            return;
        }
        this.mPageSetEntityList.add(i, pageSetEntity);
    }

    public void add(View view) {
        add(this.mPageSetEntityList.size(), view);
    }

    public void add(PageSetEntity pageSetEntity) {
        add(this.mPageSetEntityList.size(), pageSetEntity);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public PageSetEntity get(int i) {
        return this.mPageSetEntityList.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        Iterator<PageSetEntity> it = this.mPageSetEntityList.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = i2 + it.next().getPageCount();
        }
    }

    public PageEntity getPageEntity(int i) {
        Iterator<PageSetEntity> it = this.mPageSetEntityList.iterator();
        while (it.hasNext()) {
            PageSetEntity next = it.next();
            if (next.getPageCount() > i) {
                return (PageEntity) next.getPageEntityList().get(i);
            }
            i -= next.getPageCount();
        }
        return null;
    }

    public ArrayList<PageSetEntity> getPageSetEntityList() {
        return this.mPageSetEntityList;
    }

    public int getPageSetStartPosition(PageSetEntity pageSetEntity) {
        if (pageSetEntity == null || TextUtils.isEmpty(pageSetEntity.getUuid())) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mPageSetEntityList.size(); i2++) {
            if (i2 == this.mPageSetEntityList.size() - 1 && !pageSetEntity.getUuid().equals(this.mPageSetEntityList.get(i2).getUuid())) {
                return 0;
            }
            if (pageSetEntity.getUuid().equals(this.mPageSetEntityList.get(i2).getUuid())) {
                return i;
            }
            i += this.mPageSetEntityList.get(i2).getPageCount();
        }
        return i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View instantiateItem = getPageEntity(i).instantiateItem(viewGroup, i, null);
        if (instantiateItem == null) {
            return null;
        }
        viewGroup.addView(instantiateItem);
        return instantiateItem;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void notifyData() {
    }

    public void remove(int i) {
        this.mPageSetEntityList.remove(i);
        notifyData();
    }
}
