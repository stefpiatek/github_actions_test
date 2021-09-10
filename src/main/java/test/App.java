package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"test"})
@EntityScan(basePackages = {"uk.ac.ucl.rits.inform.informdb"})
public class App {
    private Adder adder;

    public App(Adder adder) {
        this.adder = adder;
    }

    /**
     * Launch spring application.
     * @param args command line args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
