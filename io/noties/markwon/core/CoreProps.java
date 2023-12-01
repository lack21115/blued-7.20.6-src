package io.noties.markwon.core;

import io.noties.markwon.Prop;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/CoreProps.class */
public abstract class CoreProps {
    public static final Prop<ListItemType> LIST_ITEM_TYPE = Prop.of("list-item-type");
    public static final Prop<Integer> BULLET_LIST_ITEM_LEVEL = Prop.of("bullet-list-item-level");
    public static final Prop<Integer> ORDERED_LIST_ITEM_NUMBER = Prop.of("ordered-list-item-number");
    public static final Prop<Integer> HEADING_LEVEL = Prop.of("heading-level");
    public static final Prop<String> LINK_DESTINATION = Prop.of("link-destination");
    public static final Prop<Boolean> PARAGRAPH_IS_IN_TIGHT_LIST = Prop.of("paragraph-is-in-tight-list");
    public static final Prop<String> CODE_BLOCK_INFO = Prop.of("code-block-info");

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/CoreProps$ListItemType.class */
    public enum ListItemType {
        BULLET,
        ORDERED
    }

    private CoreProps() {
    }
}
