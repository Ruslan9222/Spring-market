package by.tms.springmarket66;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Simon Pirko on 13.10.23
 */

@Configuration
@ComponentScan
@EnableWebMvc
@EnableTransactionManagement
public class SpringConfiguration {

  // TODO: Impl Thymeleaf configuration see docs
  // TODO: Impl Hibernate Spring ORM configuration see code
}
