import java.util.*;

public class BWT
{
  private HashMap<Integer, String> output = new HashMap<>();
  private String inputString;
  private char[] charList;
  private HashMap<Integer, char[]> table = new HashMap<>();

  public BWT (String str)
  {
    this.inputString = str;
    this.charList = str.toCharArray();
    this.algorithm();
  }

  private void algorithm()
  {
    for (int i = 0; i < this.charList.length; i++) {
      this.moveRight();
      char[] newCharList = this.charList.clone();
      this.table.put(i, newCharList);
    }

    List<String> values = new ArrayList<>();
    for (int i = 0; i < this.table.size(); i++) {
      values.add(new String(this.table.get(i)));
    }
    Collections.sort(values);

    Integer index = 999;
    for (int i = 0; i < values.size(); i++) {
      if (values.get(i).equals(this.inputString)) {
        index = i;
        break;
      }
    }

    char[] lastColumnsResult = new char[values.size()];
    for (int i = 0; i < lastColumnsResult.length; i++) {
      lastColumnsResult[i] = values.get(i).charAt(values.size() - 1);
    }

    this.output.put(index, new String(lastColumnsResult));
    System.out.println(this.output);
  }

  private void moveRight() {
    char temp = this.charList[this.charList.length - 1];
    for (int j = this.charList.length - 1; j > 0; j--) {
      this.charList[j] = this.charList[j - 1];
    }
    this.charList[0] = temp;
  }

  public static void main(String[] args) {
    new BWT("JAVA");
  }
}