package pub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    private Bar bar;

    @BeforeEach
    void setUp() {
        bar = new Bar();
    }

    @Test
    void addBoisson() {
        Boisson cafe = new Boisson("Café", false);
        Boisson biere = new Boisson("Bière", true);

        bar.add(cafe);
        bar.add(biere);

        assertTrue(bar.boissonFroide.contains(cafe));
        assertTrue(bar.boissonAlcoolisee.contains(biere));
    }

    @Test
    void addCocktail() {
        Cocktail mojito = new Cocktail("Mojito", false);
        Cocktail smoothie = new Cocktail("Smoothie", true);

        bar.add(mojito);
        bar.add(smoothie);

        assertTrue(bar.cocktailAvecAlcoole.contains(mojito));
        assertTrue(bar.cocktailSansAlcoole.contains(smoothie));
    }

    @Test
    void servBoisson() {
        Boisson jus = new Boisson("Jus d'orange", false);
        bar.add(jus);

        assertEquals(jus, bar.serv("Jus d'orange"));
        assertFalse(bar.boissonFroide.contains(jus));
    }

    @Test
    void servCocktail() {
        Cocktail pinaColada = new Cocktail("Piña Colada", false);
        bar.add(pinaColada);

        assertEquals(pinaColada, bar.serv("Piña Colada"));
        assertFalse(bar.cocktailAvecAlcoole.contains(pinaColada));
    }

    @Test
    void testToString() {
        Boisson the = new Boisson("Thé", false);
        Cocktail virginMojito = new Cocktail("Virgin Mojito", true);

        bar.add(the);
        bar.add(virginMojito);

        String output = bar.toString();

        assertTrue(output.contains("Thé"));
        assertTrue(output.contains("Virgin Mojito"));
    }
}
