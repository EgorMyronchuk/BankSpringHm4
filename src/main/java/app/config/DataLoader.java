package app.config;

import app.model.Account;
import app.model.Customer;
import app.model.Employer;
import app.repository.AccountRepository;
import app.repository.CustomerRepository;
import app.repository.EmployerRepository;
import app.utils.CardNumberUtils;
import app.utils.CustomCurrency;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Profile("local")
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final EmployerRepository employerRepository;
    private final CardNumberUtils cardNumberUtils;

    @Override
    public void run(String... args) throws Exception {
        // Создаем работодателей
        Employer techCorp = new Employer();
        techCorp.setName("TechCorp");
        techCorp.setAddress("1234 Tech Street");

        Employer healthInc = new Employer();
        healthInc.setName("HealthInc");
        healthInc.setAddress("5678 Health Avenue");

        // Сохраняем работодателей
        employerRepository.save(techCorp);
        employerRepository.save(healthInc);

        // Создаем клиентов
        Customer johnDoe = new Customer();
        johnDoe.setName("John Doe");
        johnDoe.setEmail("john.doe@example.com");
        johnDoe.setAge(30);
        johnDoe.setPhone("+38054366607");
        johnDoe.setPassword("securePassword123");

        Customer janeSmith = new Customer();
        janeSmith.setName("Jane Smith");
        janeSmith.setEmail("jane.smith@example.com");
        janeSmith.setAge(28);
        janeSmith.setPhone("+38054321207");
        janeSmith.setPassword("securePassword456");

        // Присваиваем работодателей клиентам
        johnDoe.getEmployers().add(techCorp);
        janeSmith.getEmployers().add(healthInc);

        // Сохраняем клиентов
        customerRepository.save(johnDoe);
        customerRepository.save(janeSmith);

        // Создаем счета для клиентов
        Account johnAccount = new Account(cardNumberUtils.generateCardNumber(), CustomCurrency.USD, johnDoe);
        johnAccount.setBalance(1000.0);
        accountRepository.save(johnAccount);

        Account janeAccount = new Account(cardNumberUtils.generateCardNumber(), CustomCurrency.EURO, janeSmith);
        janeAccount.setBalance(2000.0);
        accountRepository.save(janeAccount);
    }
}
