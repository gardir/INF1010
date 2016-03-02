public class Frekvens<E>{
	private Node forste;
	private E maxObj;
	private int max;

	public Frekvens(E[] objekter){
		Node ny = new Node(objekter[0], 1);
		forste = ny;
		Node tmp = forste;
		for(int i = 1; i < objekter.length; i++){
			ny = new Node(objekter[i], 1);
			tmp.neste = ny;
			tmp = tmp.neste;
		}
		max = 0;
	}

	public void printListe(){
		Node tmp = forste;
		while(tmp != null){
			System.out.println(tmp.data + " " + tmp.antall);
			tmp = tmp.neste;
		}

	}

	public void likeSammen(){
		Node tmp = forste;

		while(tmp.neste != null){
			if(tmp.data.equals(tmp.neste.data)){
				tmp.antall++;
				tmp.neste = tmp.neste.neste;
				if(tmp.antall > max){
					max = tmp.antall;
					maxObj = tmp.data;
				}
			}else{
				tmp = tmp.neste;
			}
		}

	}

	public int hentFlestAntallet(){
		return max;
	}

	public E hentFlestObjektet(){
		return maxObj;
	}

	private class Node{
		Node neste;
		E data;
		int antall;

		Node(E e, int ant){
			data = e;
			antall = ant;
		}
	}

}
