//package com.example.CSV_FileOperations.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.example.CSV_FileOperations.model.Product;
//import com.example.CSV_FileOperations.repo.ProductRepository;
//
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//    //Reader class Object
//    @Bean
//    public FlatFileItemReader<Product> reader() {
//
//       FlatFileItemReader<Product> reader= new FlatFileItemReader<>();
//       reader.setResource(new ClassPathResource("/invoices.csv"));
//       // Reader. setResource(new FileSystemResource("D:/mydata/invoices.csv"));
//       // reader.setResource(new UrlResource("https://xyz.com/files/invoices.csv"));
//       // reader.setLinesToSkip(1);
//
//       reader.setLineMapper(new DefaultLineMapper() {{
//           setLineTokenizer(new DelimitedLineTokenizer() {{
//              setDelimiter(DELIMITER_COMMA);
//              setNames("name","number","amount","discount","location");
//           }});
//
//           setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
//              setTargetType(Product.class);
//           }});
//       }});
//
//       reader.setRecordSeparatorPolicy(new BlankLineRecordSeparatorPolicy());
//
//       return reader;
//    }
//
//    //Autowire InvoiceRepository
//    @Autowired
//    ProductRepository repository;
//
//    //Writer class Object
//    @Bean
//    public ItemWriter<Product> writer(){
//       // return new InvoiceItemWriter(); // Using lambda expression code instead of a separate implementation
//       return products -> {
//         System.out.println("Saving Invoice Records: " +products);
//         repository.saveAll(products);
//       };
//    }
//
//    //Processor class Object
//    @Bean
//    public ItemProcessor<Product, Product> processor(){
//      // return new InvoiceProcessor(); // Using lambda expression code instead of a separate implementation
//      return product -> {
////    	  product.getProductSKU();
////         Double discount = product.getAmount()*(product.getDiscount()/100.0);
////         Double finalAmount= product.getAmount()-discount;
////         product.setFinalAmount(finalAmount);
//         return product;
//      };
//    }
//
//    //Listener class Object
//    @Bean
//    public JobExecutionListener listener() {
//       return new InvoiceListener();
//    }
//
//    //Autowire StepBuilderFactory
//    @Autowired
//    private StepBuilderFactory sbf;
//
//    //Step Object
//    @Bean
//    public Step stepA() {
//       return sbf.get("stepA")
//               .<Product,Product>chunk(2)
//               .reader(reader())
//               .processor(processor())
//               .writer(writer())
//               .build() 
//       ;
//    }
//
//    //Autowire JobBuilderFactory
//    @Autowired
//    private JobBuilderFactory jbf;
//
//    //Job Object
//    @Bean
//    public Job jobA(){
//       return jbf.get("jobA")
//              .incrementer(new RunIdIncrementer())
//              .listener(listener())
//              .start(stepA())
//           // .next(stepB()) 
//           // .next(stepC())
//              .build()
//       ;
//    }
//
//}
//
//class BlankLineRecordSeparatorPolicy extends SimpleRecordSeparatorPolicy {
//
//    @Override
//    public boolean isEndOfRecord(final String line) {
//        return line.trim().length() != 0 && super.isEndOfRecord(line);
//    }
//
//    @Override
//    public String postProcess(final String record) {
//       if (record == null || record.trim().length() == 0) {
//         return null;
//       }
//       return super.postProcess(record);
//    }
//}
//
//class InvoiceListener implements JobExecutionListener{
//
//    @Override
//    public void beforeJob(JobExecution jobExecution) {
//
//       System.out.println("Job started at: "+ jobExecution.getStartTime());
//       System.out.println("Status of the Job: "+jobExecution.getStatus());
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//
//       System.out.println("Job Ended at: "+ jobExecution.getEndTime());
//       System.out.println("Status of the Job: "+jobExecution.getStatus());
//    }
//
//}
