package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {
        private static int testCounter = 0;
        @BeforeEach
        public void before() {
            testCounter ++;
            System.out.println("Test Case number #" + testCounter + ": begin");
        }

        @AfterEach
        public void after() {
            System.out.println("Test Case number #" + testCounter + ": end");
        }


        @DisplayName ("Test Odd Numbers Exterminator on Empty List")
        @Test

        void testOddNumbersExterminatorEmptyList(){
            //given
            List<Integer> emptyList = new ArrayList<>();
            OddNumbersExterminator emptyListObj = new OddNumbersExterminator(emptyList);

            //when
            emptyListObj.exterminate(emptyList);

            //then
            Assertions.assertTrue(emptyList.isEmpty());


        }
        @DisplayName ("Test Odd Numbers Exterminator on Normal List")
        @Test
        void testOddNumbersExterminatorNormalList() {
            //given
            List<Integer> numbersTest2 = new ArrayList<>();
            numbersTest2.add(1);
            numbersTest2.add(2);
            numbersTest2.add(3);
            numbersTest2.add(4);
            numbersTest2.add(5);
            numbersTest2.add(6);
            OddNumbersExterminator numbersList = new OddNumbersExterminator(numbersTest2);

            //when
            numbersList.exterminate(numbersTest2);
            List<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(2);
            expectedResult.add(4);
            expectedResult.add(6);

            //then

            Assertions.assertEquals(numbersTest2,expectedResult);

        }
        @DisplayName ("Test Odd Numbers Exterminator on Normal List Extra(Arrays.asList)")
        @Test
        void testOddNumbersExterminatorNormalList2() {
            //given
            Integer integers[]= new Integer[] {1,2,3,4,5,6};
            List<Integer> numbersTest3 = new ArrayList(Arrays.asList(integers));
            OddNumbersExterminator numbersList3 = new OddNumbersExterminator(numbersTest3);

            //when
            numbersList3.exterminate(numbersTest3);
            List<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(2);
            expectedResult.add(4);
            expectedResult.add(6);

            //then

            Assertions.assertEquals(numbersTest3,expectedResult);
        }


}
