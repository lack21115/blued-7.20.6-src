package com.tencent.cos.xml.model.tag;

import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging.class */
public class Tagging {
    public TagSet tagSet = new TagSet();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging$Tag.class */
    public static class Tag {
        public String key;
        public String value;

        public Tag() {
        }

        public Tag(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tag) {
                Tag tag = (Tag) obj;
                return this.key.equals(tag.key) && this.value.equals(tag.value);
            }
            return false;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Tagging$TagSet.class */
    public static class TagSet {
        public List<Tag> tags = new LinkedList();

        public void addTag(Tag tag) {
            this.tags.add(tag);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TagSet) {
                TagSet tagSet = (TagSet) obj;
                int size = this.tags.size();
                if (size == tagSet.tags.size()) {
                    int i = 0;
                    while (size != 0) {
                        if (!this.tags.get(i).equals(tagSet.tags.get(i))) {
                            return false;
                        }
                        i++;
                        size--;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tagging) {
            return this.tagSet.equals(((Tagging) obj).tagSet);
        }
        return false;
    }
}
