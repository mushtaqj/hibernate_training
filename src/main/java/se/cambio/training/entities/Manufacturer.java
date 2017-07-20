package se.cambio.training.entities;

import se.cambio.training.entities.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
@Entity
@Table(name = "MANUFACTURERS")
public class Manufacturer extends AbstractEntity {
    @Basic
    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
