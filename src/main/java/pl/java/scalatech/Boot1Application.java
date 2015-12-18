package pl.java.scalatech;

import javax.sql.DataSource;

import org.apache.catalina.filters.RemoteIpFilter;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.entity.Role;
import pl.java.scalatech.entity.User;
import pl.java.scalatech.repository.RoleRepository;
import pl.java.scalatech.repository.UserRepository;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class Boot1Application implements CommandLineRunner {

    @Autowired
    private DataSource ds;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        registration.addInitParameter("webAllowOthers", "true");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(Boot1Application.class, args);
    }

    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("+++ ds:  {} , jdbcTempate {}", ds, jdbcTemplate);
        populateDb();

    }

    private void populateDb() {
        Role user = Role.builder().name("USER").build();
        Role admin = Role.builder().name("ADMIN").build();
        user = roleRepository.save(user);
        admin = roleRepository.save(admin);
        User przodownik = User.builder().email("przodownikR1@gmail.com").login("przodownik").enabled(true).roles(Lists.newArrayList(user, admin)).build();
        User bak = User.builder().email("bak@gmail.com").login("bak").enabled(true).roles(Lists.newArrayList(user)).build();
        userRepository.save(przodownik);
        userRepository.save(bak);
    }

    @Scheduled(initialDelay = 2000, fixedRate = 10000)
    public void run() {
      //  log.info("Users {}", userRepository.count());
    }
}
