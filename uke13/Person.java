public class Person {
    private String navn;

    public Person( String navn ) {
        this.navn = navn;
    }

    public String id() {
        return this.navn;
    }

    public boolean equals( Object o ) {
        if ( o instanceof Person ) {
            Person oPerson = (Person) o;
            return this.navn.equals( oPerson.id() );
        }
        return false;
    }
	
}

class Student extends Person {
    private int studentNr;

    public Student( String navn, int studentNr ) {
        super( navn );
        this.studentNr = studentNr;
    }

    public int hentStudentnr() {
        return this.studentNr;
    }
	
    public boolean equals( Object o ) {
        if ( o instanceof Student ) {
            Student oStudent = (Student) o;
            if ( this.studentNr == oStudent.hentStudentnr() ) {
                return true;
            }
        }
        return super.equals( o );
    }
    
}
