package pl.java.scalatech;

import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Hello");
    }
}