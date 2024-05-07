package com.enayapbm.persist;

import java.io.Serializable;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl implements Serializable {

	private static final long serialVersionUID = -4312335341260051987L;

				@Override
                public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
                                return new Identifier( name.getText(), true);
                }

                @Override
                public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
                                return new Identifier(name.getText(), true);
                }
}


