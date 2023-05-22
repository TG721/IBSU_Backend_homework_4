package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address")
    private String address;
    // Add the following field for the relationship
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
