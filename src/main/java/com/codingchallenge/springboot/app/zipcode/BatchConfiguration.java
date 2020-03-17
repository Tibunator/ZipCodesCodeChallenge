package com.codingchallenge.springboot.app.zipcode;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.codingchallenge.springboot.app.zipcode.models.entity.ZipCodes;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public DataSource dataSource;

	@Bean
	public FlatFileItemReader<ZipCodes> reader() {
		return new FlatFileItemReaderBuilder<ZipCodes>()
		  .name("ZipCodesItemReader")		
		  .resource(new ClassPathResource("CDMX.csv"))
		  .delimited()
		  .names(new String[]{ "d_codigo", "d_asenta", "d_tipo_asenta", "D_mnpio", "d_estado", "d_ciudad", "d_CP",
				  "c_estado", "c_oficina", "c_CP", "c_tipo_asenta", "c_mnpio", "id_asenta_cpcons", "d_zona",
				  "c_cve_ciudad"})
		  .fieldSetMapper(new BeanWrapperFieldSetMapper<ZipCodes>() {{
			   setTargetType(ZipCodes.class);
		  }})
		  .linesToSkip(1)
		  .build();
	} 	
	
	@Bean
	public JdbcBatchItemWriter<ZipCodes> writer() {
		return new JdbcBatchItemWriterBuilder<ZipCodes>()
				   .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ZipCodes>())
				   .sql("INSERT INTO Zip_Codes(d_asenta, d_tipo_asenta, D_mnpio,"
							+ "d_estado, d_ciudad, d_CP, c_estado, c_oficina, c_CP, c_tipo_asenta,"
							+ "c_mnpio, id_asenta_cpcons, d_zona, c_cve_ciudad) VALUES(:d_asenta, :d_tipo_asenta, "
							+ ":D_mnpio, :d_estado, :d_ciudad, :d_CP, :c_estado, :c_oficina, :c_CP, :c_tipo_asenta, "
							+ ":c_mnpio, :id_asenta_cpcons, :d_zona, :c_cve_ciudad)")
				   .dataSource(dataSource)
				   .build();
	}
	
	@Bean
	public Job createEmployeeJob(Step step1) {
		return jobBuilderFactory
		  .get("createZipCodesJob")
		  .incrementer(new RunIdIncrementer())
		  .flow(step1)
		  .end()
		  .build();
	}

	@Bean
	public Step step1(ItemReader<ZipCodes> reader, ItemWriter<ZipCodes> writer) {
		 return stepBuilderFactory
		   .get("step1")
		   .<ZipCodes, ZipCodes>chunk(10)
		   .reader(reader)
		   .writer(writer)
		   .build();
	}
}
