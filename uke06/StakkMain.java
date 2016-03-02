import java.util.Iterator;

public class StakkMain{
	public static void main(String[] args){
		Stakk<String> ordStakk = new Stakk<String>();

		ordStakk.push("Erlend");
		ordStakk.push("Sophie");
		ordStakk.push("Ola");
		ordStakk.push("Anne");
		ordStakk.push("Nora");

		for(String s : ordStakk){
			System.out.println(s);
		}

		Iterator<String> it = ordStakk.iterator();
		while(it.hasNext()){
			if(it.next().equals("Nora")){
				it.remove();
			}
		}

		System.out.println("--------------------");
		for(String s : ordStakk){
			System.out.println(s);
		}

	}


}
