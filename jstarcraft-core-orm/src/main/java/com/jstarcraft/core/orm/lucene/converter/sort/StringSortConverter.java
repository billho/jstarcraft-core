package com.jstarcraft.core.orm.lucene.converter.sort;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.util.BytesRef;

import com.jstarcraft.core.orm.lucene.annotation.LuceneSort;
import com.jstarcraft.core.orm.lucene.converter.LuceneContext;
import com.jstarcraft.core.orm.lucene.converter.SortConverter;

/**
 * 字符排序串转换器
 * 
 * @author Birdy
 *
 */
public class StringSortConverter implements SortConverter {

    @Override
    public Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, Object data) {
        Collection<IndexableField> indexables = new LinkedList<>();
        indexables.add(new SortedDocValuesField(path, new BytesRef(data.toString())));
        return indexables;
    }

    @Override
    public Sort sort(LuceneContext context, String path, Field field, LuceneSort annotation, Type type, boolean scend) {
        Sort sort = new Sort(new SortField(path, SortField.Type.STRING, !scend));
        return sort;
    }

}
