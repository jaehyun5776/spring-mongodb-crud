package com.golfzon.test.user.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BeanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import org.bson.types.ObjectId;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QObjectId is a Querydsl query type for ObjectId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QObjectId extends BeanPath<ObjectId> {

    private static final long serialVersionUID = 1931139171L;

    public static final QObjectId objectId = new QObjectId("objectId");

    public final NumberPath<Integer> counter = createNumber("counter", Integer.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final NumberPath<Integer> machineIdentifier = createNumber("machineIdentifier", Integer.class);

    public final NumberPath<Short> processIdentifier = createNumber("processIdentifier", Short.class);

    public final NumberPath<Integer> randomValue1 = createNumber("randomValue1", Integer.class);

    public final NumberPath<Short> randomValue2 = createNumber("randomValue2", Short.class);

    public final NumberPath<Long> time = createNumber("time", Long.class);

    public final NumberPath<Integer> timeSecond = createNumber("timeSecond", Integer.class);

    public final NumberPath<Integer> timestamp = createNumber("timestamp", Integer.class);

    public QObjectId(String variable) {
        super(ObjectId.class, forVariable(variable));
    }

    public QObjectId(Path<ObjectId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObjectId(PathMetadata metadata) {
        super(ObjectId.class, metadata);
    }

}

