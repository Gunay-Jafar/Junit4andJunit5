package com.in28minutes.unittesing.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals(null,mock.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(5));
    }

    @Test
    public void verificationBasics() {
        String value=mock.get(0);
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("Somestr");

        ArgumentCaptor<String> captor =ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Somestr",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("Somestr1");
        mock.add("Somestr2");

        ArgumentCaptor<String> captor =ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("Somestr1", allValues.get(0));
        assertEquals("Somestr2",allValues.get(1));
    }

}
