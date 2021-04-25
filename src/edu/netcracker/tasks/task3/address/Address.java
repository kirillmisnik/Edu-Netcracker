package edu.netcracker.tasks.task3.address;

import java.util.Objects;
import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String houseBuilding;
    private int houseNumber;
    private int apartmentNumber;

    public Address(String address) {
        String[] addressItems = address.split(", ");
        country = addressItems[0];
        region = addressItems[1];
        city = addressItems[2];
        street = addressItems[3];
        houseNumber = Integer.parseInt(addressItems[5]);
        houseBuilding = addressItems[4];
        apartmentNumber = Integer.parseInt(addressItems[6]);
    }

    public void setAddress(String address) {
        StringTokenizer addressItems = new StringTokenizer(address, ", . ; ", false);
        while (addressItems.hasMoreTokens()) {
            country = addressItems.nextToken();
            region = addressItems.nextToken();
            city = addressItems.nextToken();
            street = addressItems.nextToken();
            houseNumber = Integer.parseInt(addressItems.nextToken());
            houseBuilding = addressItems.nextToken();
            apartmentNumber = Integer.parseInt(addressItems.nextToken());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && apartmentNumber == address.apartmentNumber && Objects.equals(country, address.country) && Objects.equals(region, address.region) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(houseBuilding, address.houseBuilding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, city, street, houseBuilding, houseNumber, apartmentNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseBuilding='" + houseBuilding + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}

