package Implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServiceStation {
    private Map<String, Integer> hatchbackPrices;
    private Map<String, Integer> sedanPrices;
    private Map<String, Integer> suvPrices;
    private Map<String, Map<String, Integer>> carPrices;

    public CarServiceStation() {
        hatchbackPrices = new HashMap<>();
        hatchbackPrices.put("BS01", 2000);
        hatchbackPrices.put("EF01", 5000);
        hatchbackPrices.put("CF01", 2000);
        hatchbackPrices.put("BF01", 1000);
        hatchbackPrices.put("GF01", 3000);

        sedanPrices = new HashMap<>();
        sedanPrices.put("BS01", 4000);
        sedanPrices.put("EF01", 8000);
        sedanPrices.put("CF01", 4000);
        sedanPrices.put("BF01", 1500);
        sedanPrices.put("GF01", 6000);

        suvPrices = new HashMap<>();
        suvPrices.put("BS01", 5000);
        suvPrices.put("EF01", 10000);
        suvPrices.put("CF01", 6000);
        suvPrices.put("BF01", 2500);
        suvPrices.put("GF01", 8000);

        carPrices = new HashMap<>();
        carPrices.put("Hatchback", hatchbackPrices);
        carPrices.put("Sedan", sedanPrices);
        carPrices.put("SUV", suvPrices);
    }

    public int getServicePrice(String carType, String serviceCode) {
        return carPrices.get(carType).get(serviceCode);
    }

    public int getTotalBill(String carType, List<String> serviceCodes) {
        int totalBill = 0;
        for (String serviceCode : serviceCodes) {
            totalBill += getServicePrice(carType, serviceCode);
        }
        return totalBill;
    }

    public String generateBill(String carType, List<String> serviceCodes) {
        int totalBill = getTotalBill(carType, serviceCodes);
        String bill = "Type of Car - " + carType + "\n";
        for (String serviceCode : serviceCodes) {
            bill += "Service Codes - " + serviceCode + "\n";
            bill += "Charges for " + getServiceName(serviceCode) + " - ₹ " + getServicePrice(carType, serviceCode) + "\n";
        }
        bill += "Total Bill - ₹ " + totalBill + "\n";
        if (totalBill > 10000) {
            bill += "Complimentary cleaning provided\n";
        }
        return bill;
    }

    private String getServiceName(String serviceCode) {
        switch (serviceCode) {
            case "BS01":
                return "Basic Servicing";
            case "EF01":
                return "Engine Fixing";
            case "CF01":
                return "Clutch Fixing";
            case "BF01":
                return "Brake Fixing";
            case "GF01":
                return "Gear Fixing";
            default:
                return "Unknown";
        }
    }
}
