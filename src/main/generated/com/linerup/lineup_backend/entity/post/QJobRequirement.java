package com.linerup.lineup_backend.entity.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobRequirement is a Querydsl query type for JobRequirement
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QJobRequirement extends BeanPath<JobRequirement> {

    private static final long serialVersionUID = -1192480655L;

    public static final QJobRequirement jobRequirement = new QJobRequirement("jobRequirement");

    public final EnumPath<RecruitAge> recruitAge = createEnum("recruitAge", RecruitAge.class);

    public final StringPath recruitGender = createString("recruitGender");

    public final NumberPath<Integer> recruitNumber = createNumber("recruitNumber", Integer.class);

    public QJobRequirement(String variable) {
        super(JobRequirement.class, forVariable(variable));
    }

    public QJobRequirement(Path<? extends JobRequirement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobRequirement(PathMetadata metadata) {
        super(JobRequirement.class, metadata);
    }

}

