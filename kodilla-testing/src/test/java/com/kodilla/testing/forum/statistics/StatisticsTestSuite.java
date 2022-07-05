package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class StatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;

    @Test
    public void testCalculateAdvStatisticsFor0Posts{
        //give
    StatisticsClass statisticsClass = new StatisticsClass(statisticsMock);


        //when
    statisticsClass.calculateAdvStatistics(statisticsMock);
        //then
    Assertions.assertEquals(statisticsClass,"123");

    }
}
