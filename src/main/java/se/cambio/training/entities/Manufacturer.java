package se.cambio.training.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author MJameel
 * @since on 7/17/2017.
 */
@Entity
@Table(name = "MANUFACTURERS")
public class Manufacturer extends AbstractEntity {

    @Basic
    private String registrationNumber;

    //  `http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
    @OneToMany(mappedBy = "manufacturer")
    private List<SparePart> spareParts;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
