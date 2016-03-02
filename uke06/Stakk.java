import java.util.Iterator;

public class Stakk<E> implements StakkIterable<E>{
	private Node forste;

	public Stakk(){
		forste = new Node(null);
	}

	public void push(E data){
		Node ny = new Node(data);

		ny.neste = forste.neste;
		forste.neste = ny;
	}

	public E top(){
		if(forste.neste == null){
			return null;
		}
		return forste.neste.data;
	}

	public E pop(){
		if(forste.neste == null){
			return null;
		}
		Node tmp = forste.neste;
		forste.neste = forste.neste.neste;
		return tmp.data;
	}

	public Iterator<E> iterator(){
		return new StakkIterator();
	}

	private class StakkIterator implements Iterator<E>{
		Node denne;
		Node forrige;
		boolean kaltNext;

		StakkIterator(){
			denne = forste;
			forrige = forste;
			kaltNext = false;
		}

		public boolean hasNext(){
			return denne.neste != null;
		}

		public E next(){
			kaltNext = true;
			if(denne != forste){
				forrige = denne;
			}
			denne = denne.neste;
			return denne.data;
		}

		public void remove(){
			if(kaltNext){
				forrige.neste = denne.neste;
				kaltNext = false;
			}else{
				throw new IllegalStateException();
			}
		}

	}
	

	private class Node{
		Node neste;
		E data;
		Node(E e){
			data = e;
		}
	}


}
