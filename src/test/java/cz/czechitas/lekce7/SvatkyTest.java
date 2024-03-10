package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    @Test
    void testKdyMaSvatekMonika () {
        Svatky svatky = new Svatky();
        MonthDay kdyMaSvatekMonika = svatky.vratKdyMaSvatek("Monika");
        assertEquals(MonthDay.of(5, 21), kdyMaSvatekMonika);
    }
    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        // Přidání několika jmen do seznamu
        svatky.pridejSvatek("Jan", 1, 1);
        svatky.pridejSvatek("Marie", 3, 3);

        // Ověření, že metoda najde existující jméno
        assertTrue(svatky.jeVSeznamu("Jan"));
        // Ověření, že metoda nenajde neexistující jméno
        assertFalse(svatky.jeVSeznamu("David"));
        }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        // Ověření, že počet jmen je správný
        assertEquals(37, svatky.getPocetJmen());
    }
    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        // Získání seznamu jmen
        Set<String> seznamJmen = svatky.getSeznamJmen();
        // Ověření, že seznam jmen není null
        assertNotNull(seznamJmen);
        // Ověření, že seznam jmen má správný počet položek
        assertEquals(svatky.getPocetJmen(), seznamJmen.size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridejSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        // Přidání nového svátku
        svatky.pridejSvatek("Martina", 17, 7);
        // Ověření, že svátek byl úspěšně přidán
        assertNotNull(svatky.vratKdyMaSvatek("Martina"));
        // Ověření, že svátek má správně nastavený den
        //assertEquals(MonthDay.of(1, 1), svatky.vratKdyMaSvatek("Martina"));
        assertEquals(MonthDay.of(7, 17), svatky.vratKdyMaSvatek("Martina"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridejSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();

        svatky.pridejSvatek("Jakub", 25, Month.JULY);
        assertTrue(svatky.jeVSeznamu("Jakub"));
        // Ověření, že svátek byl úspěšně přidán
        assertNotNull(svatky.vratKdyMaSvatek("Jakub"));
        // Ověření, že svátek má správně nastavený den a měsíc
        assertEquals(MonthDay.of(Month.JULY, 25), svatky.vratKdyMaSvatek("Jakub"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void pridejSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        // Přidání nového svátku
        svatky.pridejSvatek("Veronika", MonthDay.of(Month.FEBRUARY, 7));

        // Ověření, že svátek byl úspěšně přidán
        assertNotNull(svatky.vratKdyMaSvatek("Veronika"));

        // Ověření, že svátek má správně nastavený den a měsíc
        assertEquals(MonthDay.of(Month.FEBRUARY, 7), svatky.vratKdyMaSvatek("Veronika"));

    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Jan", MonthDay.of(Month.JANUARY, 1));
        assertNotNull(svatky.vratKdyMaSvatek("Jan"));
        int pocetPred = svatky.getPocetJmen();
        svatky.smazSvatek("Jan");
        assertNull(svatky.vratKdyMaSvatek("Jan"));
        int pocetPo = svatky.getPocetJmen();
        assertEquals(pocetPred - 1, pocetPo);
    }
}
