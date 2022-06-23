package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeCollectorTestSuite {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
    private static int testCounter = 0;
    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName("Tests for shapes")
    class TestShapes {
        @DisplayName("Dodanie Figury")
        @Test
        public void addFigureTest() {
            //given - tworzę listę kształtów i obiekt na podstawie klasy Shape Collector

            ShapeCollector shapeList = new ShapeCollector();
            Circle circle1 = new Circle("circle1", 5);

            //when - dodaję koło za pomocą testowanej metody i tworzę dodatkową liste i koło dla porównania
            shapeList.addFigure(circle1);

            //then - porównuję rezultaty
            assertEquals(shapeList.getFigure(0),circle1);


        }
        @DisplayName("Usunięcie Figury")
        @Test
        public void removeFigureTest() {
            //given - tworzę listę kształtów i dodaję do listy kształty aby móc je później usunąć

            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle1 = new Triangle("triangle1", 10, 5);
            Triangle triangle2 = new Triangle("triangle2", 12, 4);
            shapeCollector.addFigure(triangle1);
            shapeCollector.addFigure(triangle2);

            //when - usuwam jeden element listy i twórzę liste odwzorowującą oczekiwany rezultat aby porównać te listy
            shapeCollector.removeFigure(triangle2);

            //then - porównuję rezultaty
            assertEquals(shapeCollector.getListQuantity(),1);
            /*
            * próbowałam wykorzystać metodę assertNull(shapeCollector.getFigure(1)); ale test nie wychodzi poprawnie
            * dlatego zamieniłam na porównanie ilości obiektów dodanych do listy*/

        }
        @DisplayName("Pobranie Figury")
        @Test
        public void getFigureTest() {
            //given - tworzę listę kształtów i dodaję do listy kształty aby móc odczytać ich nazwę

            ShapeCollector shapeCollector = new ShapeCollector();
            Square square1 = new Square("square1", 10);
            shapeCollector.addFigure(square1);

            //when/then:
            assertEquals(square1,shapeCollector.getFigure(0));

        }
        @DisplayName("Zwrócenie nazw wszystkich figur")
        @Test
        public void showFiguresTest() {
            //given

            ShapeCollector shapeCollector = new ShapeCollector();
            Square square1 = new Square("square1", 10);
            Triangle triangle1 = new Triangle("triangle1", 10, 5);
            Circle circle1 = new Circle("circle1", 5);
            shapeCollector.addFigure(square1);
            shapeCollector.addFigure(triangle1);
            shapeCollector.addFigure(circle1);

            //when
            String showFigures = shapeCollector.showFigures();
            String expectedString = "square1, triangle1, circle1";
            //then
            assertEquals(expectedString, showFigures);

        }
    }
}
