import java.util.LinkedList;

public class Parens {
  public static LinkedList<String> generateParens(int openParensLeft, int counter, String sequence) {
    LinkedList<String> list = new LinkedList<String>();

    if (openParensLeft == 0 && counter == 0) {
      list.add(sequence);
      return list;
    }

    if (openParensLeft > 0) {
      LinkedList<String> openOptions = generateParens(openParensLeft - 1, counter + 1, sequence + "(");
      list.addAll(openOptions);
    }

    if (counter > 0) {
      LinkedList<String> closeOptions = generateParens(openParensLeft, counter - 1, sequence + ")");
      list.addAll(closeOptions);
    }

    return list;
  }

  public static LinkedList<String> generateParens(int count) {
    return generateParens(count, 0, "");
  }

  public static void main(String[] args) {
    LinkedList<String> sequences = generateParens(4);

    /*
      (((())))
      ((()()))
      ((())())
      ((()))()
      (()(()))
      (()()())
      (()())()
      (())(())
      (())()()
      ()((()))
      ()(()())
      ()(())()
      ()()(())
      ()()()()
    */
    for (String seq: sequences) {
      System.out.println(seq);
    }
  }
}
