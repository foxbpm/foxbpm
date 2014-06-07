package org.foxbpm.web.db.factory;

import java.sql.Connection;

import javax.sql.DataSource;

import lombok.Setter;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class FoxbpmDBConnectionFactory {
	@Setter
	private DataSource dataSource;

	public Connection createConnection() {
		// 同一个事物获取的同一个数据库连接
		return DataSourceUtils.getConnection(this.dataSource);
	}
}