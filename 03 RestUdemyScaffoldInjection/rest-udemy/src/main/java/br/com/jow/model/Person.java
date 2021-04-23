package br.com.jow.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    // Serial version uid cria um numero de serie para calasse para que ela possa
    // ser exportada pelos serviços web
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstname;
    private String lastname;
    private String adress;
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(adress, person.adress) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, adress, gender);
    }

// para gerar mais facilmente os hascodes e equals usei a extenção https://marketplace.visualstudio.com/items?itemName=sohibe.java-generate-setters-getters
//java code generator
    public Person() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
