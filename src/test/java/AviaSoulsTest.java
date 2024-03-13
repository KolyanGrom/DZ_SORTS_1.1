import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Красноярск", 10_500, 23, 6);
    Ticket ticket2 = new Ticket("Москва", "Тюмень", 6_500, 20, 24);
    Ticket ticket3 = new Ticket("Москва", "Хабаровск", 14_500, 22, 9);
    Ticket ticket4 = new Ticket("Москва", "Хабаровск", 11_500, 5, 14);
    AviaSouls manager = new AviaSouls();

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    public void testCompareTwoTicketsAndSortPrice() {

        Ticket[] tickets = {ticket2, ticket3};
        Arrays.sort(tickets);
        Ticket[] expected = {ticket2, ticket3};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void testSearchTicketCityFromCityToAndSortPrice() {
        Ticket[] expected = {ticket4, ticket3};
        Ticket[] actual = manager.search("Москва", "Хабаровск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchTicketCityFromCityToAndSortTimeFly() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket3};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Хабаровск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
