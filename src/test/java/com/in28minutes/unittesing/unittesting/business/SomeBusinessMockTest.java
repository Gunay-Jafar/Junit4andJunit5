package com.in28minutes.unittesing.unittesting.business;

import com.in28minutes.unittesing.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Test
    public void calculateSumUsingDataService_basic() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSumUsingDataService_empty() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{ });
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSumUsingDataService_oneValue() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{ 5 });
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }


}
