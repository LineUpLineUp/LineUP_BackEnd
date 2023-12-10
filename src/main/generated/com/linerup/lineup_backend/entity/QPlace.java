package com.linerup.lineup_backend.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlace is a Querydsl query type for Place
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlace extends EntityPathBase<Place> {

    private static final long serialVersionUID = -192360284L;

    public static final QPlace place = new QPlace("place");

    public final StringPath address = createString("address");

    public final StringPath id = createString("id");

    public final StringPath map_id = createString("map_id");

    public final StringPath name = createString("name");

    public final StringPath x = createString("x");

    public final StringPath y = createString("y");

    public QPlace(String variable) {
        super(Place.class, forVariable(variable));
    }

    public QPlace(Path<? extends Place> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlace(PathMetadata metadata) {
        super(Place.class, metadata);
    }

}

