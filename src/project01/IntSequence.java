package project01;

/**
 * Created by PawelM on 2016-11-17.
 */
public interface IntSequence {
    default boolean hasNext() { return true; };
    int next();
    static void xxx(){};
    default String yyy() { return "yyy"; };
}
