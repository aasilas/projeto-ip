package interfaces;

public interface Iterator <E>{
    E next();
    boolean hasNext();
    Iterator<E> iterator();
}
