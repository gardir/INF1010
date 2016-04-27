public abstract class Frukt {
    private String frukttype;
    
    public Frukt( String type ) {
        this.frukttype = type;
    }
    
    public String id() {
        return this.frukttype;
    }

    public boolean equals( Object o ) {
        if ( o instanceof Frukt ) {
            return this.frukttype.equals(((Frukt)o).id() ); 
        }
        return false;
    }

}

class Eple extends Frukt {
    
    public Eple() {
        super("Eple");
    }

}

class Kiwi extends Frukt {
    
    public Kiwi() {
        super("Kiwi");
    }

}

class Banan extends Frukt {
    public Banan() {
        super("Banan");
    }
}
