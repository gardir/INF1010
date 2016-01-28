class PersonDemo{
    public static void main(String[] args){
        Person person1 = new Person("Kari");
        Hus hus1 = new Hus();

        person1.setHus(hus1);
        hus1.setEier(person1);
    }
}
