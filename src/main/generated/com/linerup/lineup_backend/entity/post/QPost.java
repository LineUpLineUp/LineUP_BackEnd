package com.linerup.lineup_backend.entity.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 2133512843L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final com.linerup.lineup_backend.common.model.QBaseEntity _super = new com.linerup.lineup_backend.common.model.QBaseEntity(this);

    public final EnumPath<Category> category = createEnum("category", Category.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final BooleanPath isAgree = createBoolean("isAgree");

    public final QJobRequirement jobRequireMent;

    public final NumberPath<Integer> likeCount = createNumber("likeCount", Integer.class);

    public final com.linerup.lineup_backend.entity.member.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final com.linerup.lineup_backend.entity.QPlace place;

    public final EnumPath<PostStatus> postStatus = createEnum("postStatus", PostStatus.class);

    public final NumberPath<Long> salary = createNumber("salary", Long.class);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jobRequireMent = inits.isInitialized("jobRequireMent") ? new QJobRequirement(forProperty("jobRequireMent")) : null;
        this.member = inits.isInitialized("member") ? new com.linerup.lineup_backend.entity.member.QMember(forProperty("member")) : null;
        this.place = inits.isInitialized("place") ? new com.linerup.lineup_backend.entity.QPlace(forProperty("place")) : null;
    }

}

