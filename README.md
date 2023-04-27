# DistributedApplications 
Projekt opiera się między innymi na wykorzystaniu asynchronicznej komunikacji za pomocą RabbitMQ, Spring Cloud Functions oraz składa się z kilku modułów, które współpracują ze sobą w celu realizacji założonych funkcjonalności. Asynchroniczność pozwala między innymi modulowi raportów "zbierac" eventy/dane bez konieczności tego aby usluga z ktorej potrzebne są dane, była aktualnie dostępna po "drugiej stronie" jak ma się to synchronicznym tradycjnym modelu. 

Głównym modułem jest moduł pracowników, który po dodaniu pracownika tworzy event, który następnie jest konsumowany przez moduł raportów. Moduł raportów, oprócz tego, konsumuje również wiadomości z modułu sprzętowego firmy.

Do rejestrowania poszczególnych mikroserwisów wykorzystałem Eurekę, która umożliwia łatwe zarządzanie i monitorowanie komponentów systemu. Dzięki temu, każdy wiem, która usługa mowiąc potocznie "wstała", co jest ważne przy duzej ilości mikroserwisów.

Konfiguracja poszczególnych serwisów jest zarządzana za pomocą Spring Cloud Config Server, co pozwala na scentralizowane zarządzanie konfiguracją i łatwe wdrażanie zmian w różnych środowiskach.

API Gateway pełni rolę routowania żądań do odpowiednich serwisów, korzystając z zarejestrowanych usług w Eurece. Pozwala to na sprawne przekierowywanie żądań między modułami.

W projekcie zastosowałem również wzorce odpornościowe Resilience4j, które pozwalają na lepsze radzenie sobie z awariami czy opóźnieniami w komunikacji pomiędzy serwisami.

Projekt opiera się na trójwarstwowej strukturze architektonicznej, która pozwala na uporządkowanie kodu i prostsze testowanie. Na warstwy składa się warstwa repozytoriów, warstwa usług (serwisów) oraz warstwa kontrolerów.  

Warstwa repozytoriów (Repository) stanowi abstrakcję nad bazą danych, umożliwiając wykonywanie operacji CRUD (Create, Read, Update, Delete) oraz innych zapytań związanych z obsługą danych

Warstwa usług (Service) zawiera logikę biznesową aplikacji, obejmującą przetwarzanie i walidację danych, implementację reguł biznesowych oraz współpracę z warstwą repozytoriów w celu realizacji operacji na danych. Ta warstwa pozwala na uporządkowanie i scentralizowanie logiki biznesowej, co ułatwia zarządzanie i rozwijanie aplikacji.

Warstwa kontrolerów (Controller) odpowiada za obsługę API, umożliwiając przetwarzanie żądań przychodzących od klientów oraz generowanie odpowiednich odpowiedzi. Kontrolery wykorzystują warstwę serwisów do realizacji logiki biznesowej i zwracania przetworzonych danych do klienta. Dzięki tej warstwie, system może prezentować widoczność swojej funkcjonalności w postaci API, ułatwiając interakcję z innymi komponentami i usługami.
