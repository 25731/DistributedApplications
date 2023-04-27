package pl.janowski.employeemanage.MessageProducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import pl.janowski.employeemanage.Entity.Employee;
import java.util.function.Function;

@Configuration
public class EmployeeEventProducer {

    @Bean
    public Function<Employee, Message<String>> EmployeeAddedInput() {
        return (Employee employee) -> {
            String eventMessage = "Dodano pracownika";
            Message<String> message = MessageBuilder.withPayload(eventMessage)
                    .setHeader("type", "employee-add-event")
                    .build();
            return message;
        };
    }
}

