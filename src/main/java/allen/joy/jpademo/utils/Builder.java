package allen.joy.jpademo.utils;

public abstract class Builder<T> {

    protected T model;

    public T build(){
        return model;
    }
}
