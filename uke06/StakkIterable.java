public interface StakkIterable<E> extends Iterable<E>{
	public void push(E data);

	public E pop();

	public E top();
}
