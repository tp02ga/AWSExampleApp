package com.coderscampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.cloud.aws.jdbc.config.annotation.RdsInstanceConfigurer;
import org.springframework.cloud.aws.jdbc.datasource.DataSourceFactory;
import org.springframework.cloud.aws.jdbc.datasource.TomcatJdbcDataSourceFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRdsInstance(databaseName="ebdb", dbInstanceIdentifier="aa1e474aw362jig", username="trevorpage",password="Coderscampustest123")
@EnableContextCredentials(accessKey="AKIAICEJ6UC6BI7WLDZQ", secretKey="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")
@EnableContextRegion(region="us-west-2")
public class AwsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsExampleApplication.class, args);
	}
	
	@Bean
  public RdsInstanceConfigurer instanceConfigurer() {
    return new RdsInstanceConfigurer() {
      @Override
      public DataSourceFactory getDataSourceFactory() {
        TomcatJdbcDataSourceFactory dataSourceFactory = new TomcatJdbcDataSourceFactory();
        dataSourceFactory.setInitialSize(2);
        dataSourceFactory.setMaxActive(15);
        dataSourceFactory.setValidationQuery("SELECT 1");
        dataSourceFactory.setTestOnBorrow(true);
        return dataSourceFactory;
      }
    };
  }
}
