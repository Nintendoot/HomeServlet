import java.util.ArrayList;
import java.util.List;

public class InMemory {
    private static List<Person> personList = new ArrayList<>();

    public InMemory() {
    }

    public void AddToMemory(Person person) {
        personList.add(person);
    }

    public boolean uniqPerson(Person person) {
        boolean proverka = false;
        for (Person person1 : personList) {
            if (person.compareTo(person1) == 0) {
                proverka = true;
                break;
            }
        }
        return proverka;
    }

    public Person personInMemory(String login,String password){
        Person person=null;
        for (Person per:personList){
            if(per.getLogin().equals(login)){
                if(per.getPassword().equals(password)){
                    person=per;
                    break;
                }

            }
        }
        return person;
    }
}
