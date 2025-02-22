package dz.rmz;

public class Client {

    private final String name;
    private final String surname;
    private String address;

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return String.format("Name: %s || Surname: %s || Address: %s", name, surname, address);
    }

    public Client(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
