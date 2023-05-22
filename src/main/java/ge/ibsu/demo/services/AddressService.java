package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.AddressRepository;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(Long id) throws Exception {
        return addressRepository.findById(id).orElseThrow(() -> new Exception("RECORD_NOT_FOUND"));
    }

    public Address add(Address address){
        City city = address.getCity();
        if (city != null) {
            city = cityRepository.save(city);
            address.setCity(city);
        }
        return addressRepository.save(address);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
