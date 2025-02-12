🏨 System Zarządzania Rezerwacjami w Hotelu

System Zarządzania Rezerwacjami w Hotelu to aplikacja konsolowa napisana w Javie, która umożliwia zarządzanie rezerwacjami hotelowymi. Projekt pozwala na dodawanie pokoi, rejestrowanie klientów, tworzenie rezerwacji, anulowanie ich oraz wyświetlanie dostępnych pokoi. Całość opiera się na wykorzystaniu MySQL jako bazy danych.

📋 Funkcjonalności

Dodawanie pokoi: możliwość dodawania pokoi hotelowych z określeniem ich numeru, typu (np. standardowy, luksusowy) oraz ceny za noc.
Wyświetlanie dostępnych pokoi

Pokazuje listę wolnych pokoi, które mogą zostać zarezerwowane.

Rejestrowanie klientów: umożliwia dodawanie nowych klientów do systemu, zapisując ich dane, takie jak imię i nazwisko.

Tworzenie rezerwacji: pozwala zarezerwować wybrany pokój dla konkretnego klienta w określonym terminie.
Anulowanie rezerwacji

Umożliwia anulowanie istniejących rezerwacji i ponowne udostępnienie pokoju.

Wyświetlanie rezerwacji: lista wszystkich rezerwacji z informacjami o pokoju, kliencie i dacie rezerwacji.

📦 Wykorzystywane technologie

Java: Główny język programowania użyty w projekcie.

MySQL: Relacyjna baza danych do przechowywania informacji o pokojach, klientach i rezerwacjach.

JDBC (Java Database Connectivity): Do połączenia aplikacji z bazą danych MySQL.

IntelliJ IDEA: Środowisko programistyczne do tworzenia projektu.

⚙️ Jak uruchomić projekt?

Skonfiguruj środowisko

Zainstaluj JDK (Java Development Kit) w wersji 8 lub nowszej.
Zainstaluj MySQL i utwórz bazę danych (instrukcja poniżej).
Skonfiguruj IntelliJ IDEA i upewnij się, że biblioteka JDBC jest dołączona do projektu.
Stwórz bazę danych
Uruchom MySQL i wykonaj następujące zapytanie SQL, aby utworzyć bazę:

CREATE DATABASE hotel;

CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT NOT NULL,
    room_type VARCHAR(50),
    price_per_night DOUBLE,
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    room_id INT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);
Uruchom projekt

Skopiuj kod projektu na swój komputer.
Skonfiguruj plik połączenia z bazą (np. ustawienia w DatabaseConnector w aplikacji).
Uruchom główną klasę projektu HotelApp.

📚 Przykład działania

![image](https://github.com/user-attachments/assets/f7f9dcea-7c39-43aa-86c6-0b3c5b853859)

🚀 Pomysły na rozwój

Powiadomienia o rezerwacjach: System powiadomień o nadchodzących rezerwacjach.

Zaawansowane filtrowanie pokoi: Możliwość filtrowania po typie pokoju, cenie lub dostępności.

Zarządzanie personelem hotelowym: Rozszerzenie systemu o role administratora oraz pracownika.

Integracja z płatnościami: Dodanie modułu obsługującego płatności online.
