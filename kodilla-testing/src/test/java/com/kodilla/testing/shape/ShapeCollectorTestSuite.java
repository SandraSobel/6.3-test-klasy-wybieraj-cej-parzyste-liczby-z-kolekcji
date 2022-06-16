package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
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
            List<Shape> shapesList = new ArrayList<Shape>();
            ShapeCollector shapeList = new ShapeCollector(shapesList);
            Circle circle1 = new Circle("circle1", 5);

            //when - dodaję koło za pomocą testowanej metody i tworzę dodatkową liste i koło dla porównania
            shapeList.addFigure(circle1);
            List<Shape> expectedList = new ArrayList<>();
            expectedList.add(circle1);

            //then - porównuję rezultaty
            assertEquals(shapesList, expectedList);

        }
        @DisplayName("Usunięcie Figury")
        @Test
        public void removeFigureTest() {
            //given - tworzę listę kształtów i dodaję do listy kształty aby móc je później usunąć
            List<Shape> shapesList = new ArrayList<Shape>();
            ShapeCollector shapeList = new ShapeCollector(shapesList);
            Triangle triangle1 = new Triangle("triangle1", 10, 5);
            Triangle triangle2 = new Triangle("triangle2", 12, 4);
            shapesList.add(triangle1);
            shapesList.add(triangle2);

            //when - usuwam jeden element listy i twórzę liste odwzorowującą oczekiwany rezultat aby porównać te listy
            List<Shape> expectedList = new ArrayList<Shape>();
            expectedList.add(triangle1);
            shapeList.removeFigure(triangle2);

            //then - porównuję rezultaty
            assertEquals(shapesList, expectedList);

        }
        @DisplayName("Pobranie Figury")
        @Test
        public void getFigureTest() {
            //given - tworzę listę kształtów i dodaję do listy kształty aby móc odczytać ich nazwę
            List<Shape> shapesList = new ArrayList<Shape>();
            ShapeCollector shapeList = new ShapeCollector(shapesList);
            Square square1 = new Square("square1", 10);
            Square square2 = new Square("square2", 12);
            shapesList.add(square1);
            shapesList.add(square2);
        /* jak robię tak to nie działa nie doszłam do tego dlaczego
            //when
            shapeList.getFigure(1);
            //then - porównuję rezultaty
            assertEquals(square2,shapeList);
         */

            //when/then (tak działa):
            assertEquals(square2,shapeList.getFigure(1));

        }
        @DisplayName("Zwrócenie nazw wszystkich figur")
        @Test
        public void showFiguresTest() {
            //given
            List<Shape> shapesList = new ArrayList<Shape>();
            ShapeCollector shapeList = new ShapeCollector(shapesList);
            Square square1 = new Square("square1", 10);
            Triangle triangle1 = new Triangle("triangle1", 10, 5);
            Circle circle1 = new Circle("circle1", 5);
            shapesList.add(square1);
            shapesList.add(triangle1);
            shapesList.add(circle1);

            //when
            String showFigures = shapeList.showFigures();
            String expectedString = "square1, triangle1, circle1";
            //then
            assertEquals(expectedString, showFigures);

        }
    }
}
