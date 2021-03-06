package com.jstarcraft.core.orm.lucene.converter;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.Query;

import com.jstarcraft.core.orm.OrmCondition;
import com.jstarcraft.core.orm.lucene.annotation.LuceneIndex;

/**
 * 索引转换器
 * 
 * @author Birdy
 *
 */
public interface IndexConverter {

    /**
     * 转换索引
     * 
     * @param context
     * @param path
     * @param field
     * @param annotation
     * @param name
     * @param type
     * @param data
     * @return
     */
    Iterable<IndexableField> convert(LuceneContext context, String path, Field field, LuceneIndex annotation, Type type, Object data);

    default Query query(LuceneContext context, String path, Field field, LuceneIndex annotation, Type type, OrmCondition condition, Object... data) {
        throw new UnsupportedOperationException();
    }

}
