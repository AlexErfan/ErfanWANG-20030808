package ghostFactoryPattern;

/**
 * The ghost interface which can be implemented later.
 * @author alex
 *
 */
public interface GhostInterface {
	/**
	 * The abstract method which can generate the ghost.
	 * @param ghostNumber - number of the ghost sequence.
	 * @return Ghost - any instances of Ghost.
	 */
	Ghost produce(int ghostNumber);
}
