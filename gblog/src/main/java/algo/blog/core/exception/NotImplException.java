package algo.blog.core.exception;

/**
 * Created by jetluo on 16/7/7.
 */
public class NotImplException extends Exception {
    private Class clazz;
    private String message;

    public NotImplException() {
        super();
    }

    public NotImplException(Class clazz) {
        super();
        this.clazz = clazz;
    }

    public NotImplException(Class clazz, String message) {
        super(message);
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return clazz.getName() + ":\n" + super.toString();
    }


}
