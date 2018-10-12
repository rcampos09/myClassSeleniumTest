package com.selenium.dataprovider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FileDataProvider {
  protected static List<String> readLinesFromFile(String path, boolean randomly, int numberOfLines) {
    List<String> lines = new ArrayList<String>();
    try {
      lines = Files.readAllLines(Paths.get(path));
    } catch (IOException e) {
      System.out.println("There was an error reading the file {}");
    }
    if (randomly) {
      Collections.shuffle(lines, new Random(System.nanoTime()));
    }
    if (numberOfLines > 0) {
      return lines.size() < numberOfLines ? lines : lines.subList(0, numberOfLines);
    } else {
      return lines;
    }
  }
  /**
   * Read the content of a text file
   *
   * @param path path to the file
   * @return the content of the file as a String or an empty string if there is a problem
   */
  public static String asString(String path) {
    String data = "";
    try {
      data = new String(Files.readAllBytes(Paths.get(path)));
    } catch (IOException e) {
      System.out.println("There was an error reading the file {}");
    }
    return data;
  }

  /**
   * Get data from a text file separated by lines
   *
   * @param path path to the file
   * @param randomly read lines randomly or sequentially
   * @param numberOfLines number of lines to obtain. -1 to obtain all the lines in the file
   * @return an Iterator that can be handled by TestNG to provide the data to the test method
   */
  public static Iterator<Object[]> asRawLines(String path, boolean randomly, int numberOfLines) {
    List<Object[]> data = new ArrayList<Object[]>();
    readLinesFromFile(path, randomly, numberOfLines).forEach(t-> data.add(new Object[] {t}));

    return data.iterator();
  }

  /**
   * Get data from a text file separated by values depending on the separator
   *
   * @param path path to the file
   * @param separator separator of the values in the file (i.e. comma, tab, etc)
   * @param randomly read lines randomly or sequentially
   * @param numberOfLines number of lines to obtain. -1 to obtain all the lines in the file
   * @return an Array that can be handled by TestNG to provide the data to the test method
   */
  public static Object[][] asSeparatedValues(String path, String separator, boolean randomly,
                                             int numberOfLines) {
    return asSeparatedValues(path, separator, randomly, numberOfLines, 0);
  }

  /**
   * Get data from a text file separated by values depending on the separator. Ignore specified number of lines from the
   * beginning
   *
   * @param path path to the file
   * @param separator separator of the values in the file (i.e. comma, tab, etc)
   * @param randomly read lines randomly or sequentially
   * @param numberOfLines number of lines to obtain. -1 to obtain all the lines in the file
   * @param linesToExclude lines to exclude from the beginning of file
   * @return an Array that can be handled by TestNG to provide the data to the test method
   */
  public static Object[][] asSeparatedValues(String path, String separator, boolean randomly,
                                             int numberOfLines, int linesToExclude) {
    Iterator<Object[]> iterator = asRawLines(path, randomly, numberOfLines);
    List<String> lines = new ArrayList<String>();

    for (int i=0; i < linesToExclude; i++) {
      iterator.next();
    }
    while (iterator.hasNext()) {
      String line = (String) iterator.next()[0];
      if (line.startsWith("#")) continue;
      lines.add(line);
    }
    Object[][] data;
    if (lines.isEmpty()) {
      data = new Object[][] {};
    } else {
      data = new Object[lines.size()][lines.get(0).split(separator).length];
      for (int i = 0; i < lines.size(); i++) {
        Object[] line_aux = lines.get(i).split(separator);
        for (int j = 0; j < line_aux.length; j++) {
          data[i][j] = line_aux[j];
        }
      }
    }
    return data;
  }
}
