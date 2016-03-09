public class Fakultet{
    
    public static int fakIter(int n){
        int fak = 1;

        for(int i = 1; i <= n; i++){
            fak = i*fak;
        }
        return fak;
    }

    public static int fakultet(int n){
        if(n == 0){
            return 1;
        }
        return n*fakultet(n-1);
    }

    public static void main(String[] args){
        System.out.println("FakIter 5: " + fakIter(5));
        System.out.println("FakRek  5: " + fakultet(5));

    }

}