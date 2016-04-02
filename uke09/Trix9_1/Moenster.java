class Moenster {
    public static void main(String[] args) {
        //uthevHverNteEnkel(3, 16);
        //uthevHverNteModulo(3, 16);
        //sjakk(16, 10);
        uthevRektangler(18, 10, 3, 2);
    }

    private static void uthevHverNteEnkel (int n, int antTegn) {
        for (int i = 0; i < antTegn/n; i++) {

            for (int j = 0 ; j < n-1; j++) {
                System.out.print(" ");
            }

            System.out.print("X");
        }
        System.out.println();
    }

    private static void uthevHverNteModulo (int n, int antTegn) {
        for (int i = 1; i <= antTegn; i++) {
            if (i % n == 0)
                System.out.print("X");
            else
                System.out.print(" ");
        }

        System.out.println();
    }

    private static void sjakk (int bredde, int hoyde) {
        for (int i = 0; i < hoyde; i++) {
            for (int j = 0; j < bredde; j++) {
               if ((j % 2) == (i % 2))
                   //if ((i + j) % 2 == 0)
                   System.out.print(" ");
               else 
                   System.out.print("X");
            }
            
            System.out.println();
        }
    }

    public static void uthevRektangler(int bredde, int hoyde, int rBredde, int rHoyde) {
        for (int i = 0; i < hoyde; i++) {
            for (int j = 0; j < bredde; j++) {
                if (((j / rBredde) % 2) == ((i / rHoyde) % 2))
                    System.out.print(" ");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }
}
