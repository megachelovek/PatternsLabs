package com.ssau;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class SingletonReader {
  private static volatile SingletonReader instance;

  public String path;

  private SingletonReader(String path) {
    this.path = path;
  }

  public static SingletonReader getInstance(String path) {
    if (instance == null) {
      synchronized (SingletonReader.class) {
        if (instance == null) {
          instance = new SingletonReader(path);
        }
      }
    }
    return instance;
  }

  public String[] GetProperties(){
    String[] arrayOfParametres = new String[3];
    FileInputStream fis;
    Properties property = new Properties();
    try {
      fis = new FileInputStream(path);
      property.load(fis);
      arrayOfParametres[0] = property.getProperty("name");
      arrayOfParametres[1] = property.getProperty("login");
      arrayOfParametres[2] = property.getProperty("password");
    } catch (IOException e) {
      System.err.println("ОШИБКА: Файл свойств отсуствует!");
    }
    return arrayOfParametres;
  }

}
