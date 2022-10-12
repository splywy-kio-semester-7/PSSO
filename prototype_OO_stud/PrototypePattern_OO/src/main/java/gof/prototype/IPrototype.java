package gof.prototype;

import java.io.*;

public interface IPrototype <T> extends Cloneable {

  /*default Object clone() throws CloneNotSupportedException {
    return this.clone();
  }*/

  T clone() throws CloneNotSupportedException;

  default T shallowClone() {
    T clone = null;
    try {
        clone = (T) this.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
  default T deepClone() {
    T clone = null;
    try {
      ByteArrayOutputStream baOUT = new ByteArrayOutputStream();
      ObjectOutputStream oOUT = new ObjectOutputStream(baOUT);
      oOUT.writeObject(this);

      ByteArrayInputStream baIN = new ByteArrayInputStream(baOUT.toByteArray());
      ObjectInputStream oIN = new ObjectInputStream(baIN);
      clone = (T) oIN.readObject();
    } catch (IOException | ClassNotFoundException e) {//Java 7 required
      e.printStackTrace();
    }
    return clone;
  }

}
