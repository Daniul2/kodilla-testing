package com.kodilla.stream.invoice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValue() {
        SimpleItem item1 = new SimpleItem("Product 1", 10.0, 3);
        SimpleItem item2 = new SimpleItem("Product 2", 25.0, 2);
        SimpleItem item3 = new SimpleItem("Product 3", 5.0, 10);

        assertEquals(30.0, item1.getValue());
        assertEquals(50.0, item2.getValue());
        assertEquals(50.0, item3.getValue());
    }
}
