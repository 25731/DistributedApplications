package pl.janowski.EquipmentsManage.EventSourcing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import pl.janowski.EquipmentsManage.Entity.Printer;

import java.util.function.Function;



@Configuration
public class printerProducer {

    @Bean
    public Function<Printer, Message<String>> printerAddedInput() {
        return (Printer printer) -> {
            String eventMessage = "Dodano drukarkę: " + printer.toString();
            Message<String> message = MessageBuilder.withPayload(eventMessage)
                    .setHeader("type", "printer-added-event")
                    .build();
            return message;
        };
    }
}






//
//    private final StreamBridge streamBridge;
//
//    public printerProducer(StreamBridge streamBridge) {
//        this.streamBridge = streamBridge;
//    }
//
//    public void sendPrinterAddedEvent(Long printerId) {
//        String eventMessage = "Dodano drukarkę: " + printerId;
//        Message<String> message = MessageBuilder.withPayload(eventMessage)
//                .setHeader("type", "printer-added-event")
//                .build();
//        streamBridge.send("printerAddedOutput", message);
//    }
//}
