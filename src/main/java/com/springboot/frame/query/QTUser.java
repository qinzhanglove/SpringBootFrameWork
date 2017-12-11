package com.springboot.frame.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTUser is a Querydsl query type for QTUser
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTUser extends com.querydsl.sql.RelationalPathBase<QTUser> {

    private static final long serialVersionUID = 811758455;

    public static final QTUser tUser = new QTUser("t_user");

    public final StringPath tAddress = createString("tAddress");

    public final NumberPath<Integer> tAge = createNumber("tAge", Integer.class);

    public final StringPath tEmail = createString("tEmail");

    public final NumberPath<Long> tId = createNumber("tId", Long.class);

    public final StringPath tName = createString("tName");

    public final com.querydsl.sql.PrimaryKey<QTUser> primary = createPrimaryKey(tId);

    public QTUser(String variable) {
        super(QTUser.class, forVariable(variable), "null", "t_user");
        addMetadata();
    }

    public QTUser(String variable, String schema, String table) {
        super(QTUser.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTUser(String variable, String schema) {
        super(QTUser.class, forVariable(variable), schema, "t_user");
        addMetadata();
    }

    public QTUser(Path<? extends QTUser> path) {
        super(path.getType(), path.getMetadata(), "null", "t_user");
        addMetadata();
    }

    public QTUser(PathMetadata metadata) {
        super(QTUser.class, metadata, "null", "t_user");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(tAddress, ColumnMetadata.named("t_address").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(tAge, ColumnMetadata.named("t_age").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(tEmail, ColumnMetadata.named("t_email").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(tId, ColumnMetadata.named("t_id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(tName, ColumnMetadata.named("t_name").withIndex(5).ofType(Types.VARCHAR).withSize(255));
    }

}

