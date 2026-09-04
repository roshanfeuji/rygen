package data;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class OrderDataProvider {

    @DataProvider(name = "orderData")
    public static Object[][] orderData() {

        List<String> data = Arrays.asList(
                // stop-1_content
                "15 MCDONALD SACRAMENTO",
                "1750 Enterprise Boulevard",
                "Suite 100",
                "Dock 2",
                "West Sacramento",
                "California",
                "95691",
                "United States of America",
                "6630",
                "West Sacramento Operations",
                "John Smith",
                "916-555-0147",
                "john.smith@example.com",
                "McDonald's",
                "09/04/2026 09:00",
                "09/04/2026 12:00",
                "PDT",
                "false",
                "false",
                "false",
                "test",
                "Please check in with the receiving desk upon arrival and use the designated loading dock.",

                // stop-2_content
                "15 MCDONALD SACRAMENTO",
                "1750 Enterprise Boulevard",
                "Suite 100",
                "Dock 2",
                "West Sacramento",
                "California",
                "95691",
                "United States of America",
                "6630",
                "West Sacramento Operations",
                "John Smith",
                "916-555-0147",
                "john.smith@example.com",
                "McDonald's",
                "09/04/2026 09:00",
                "09/04/2026 12:00",
                "PDT",
                "false",
                "false",
                "false",
                "test",
                "Please check in with the receiving desk upon arrival and use the designated loading dock.",

                // line-item-num-1_content
                "Test Product",
                "Box",
                "100",
                "10",
                "20",
                "15",
                "Carton",
                "123456",
                "70",
                "5",
                "PROD-001",
                "20",
                "1000",
                "false",
                "true",
                "false",
                "false",
                "true",
                "PO Number",
                "SO-12345"
        );

        return new Object[][]{
                {data}
        };
    }
}