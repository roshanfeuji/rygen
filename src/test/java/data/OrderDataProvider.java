package data;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class OrderDataProvider {

    @DataProvider(name = "orderData")
    public static Object[][] orderData() {

        List<String> data = Arrays.asList(

                "15 MCDONALD SACRAMENTO",
                "1750 Enterprise Boulevard",
                "Suite 100",
                "Dock 2",
                "West Sacramento",
                "95691",
                "6630",
                "John Smith",
                "john.smith@example.com",
                "McDonald's",
                "Internal note for stop 1",
                "Carrier instruction for stop 1",
                "Alaska",



                "15 MCDONALD SACRAMENTO",
                "1750 Enterprise Boulevard",
                "Suite 100",
                "Dock 2",
                "West Sacramento",
                "95691",
                "6630",
                "John Smith",
                "john.smith@example.com",
                "McDonald's",
                "Internal note for stop 2",
                "Carrier instruction for stop 2",
                "California",


                "Test Product",
                "122",
                "100",
                "10",
                "20",
                "15",
                "Carton",
                "123456",
                "5",
                "PROD-001",
                "20",
                "1000",
                "12345",


                "Do not open",
                "Happy Happy Happy",
                "Inbound",
                "Collect",
                "Parcel",
                "Dropdeck"
        );

        return new Object[][]{
                {data}
        };
    }
}