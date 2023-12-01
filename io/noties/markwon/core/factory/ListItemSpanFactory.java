package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.BulletListItemSpan;
import io.noties.markwon.core.spans.OrderedListItemSpan;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/factory/ListItemSpanFactory.class */
public class ListItemSpanFactory implements SpanFactory {
    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(renderProps)) {
            return new BulletListItemSpan(markwonConfiguration.theme(), CoreProps.BULLET_LIST_ITEM_LEVEL.require(renderProps).intValue());
        }
        return new OrderedListItemSpan(markwonConfiguration.theme(), String.valueOf(CoreProps.ORDERED_LIST_ITEM_NUMBER.require(renderProps)) + ". ");
    }
}
