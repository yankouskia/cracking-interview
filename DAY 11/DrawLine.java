public class DrawLine {
  public static void drawLine(byte[] screen, int width, int x1 , int x2) {
    byte fullByte = Byte.MAX_VALUE;

    int startByte = x1 / 8;
    int startByteOffset = x1 % 8;

    int endByte = x2 / 8;
    int endByteOffset = x2 % 8;

    for (int i = startByte + 1; i < endByte; i++) {
      screen[i] = fullByte;
    }

    byte startByteValue = (byte) (fullByte >>> startByteOffset);
    byte endByteValue = (byte) ((fullByte >>> endByteOffset) << endByteOffset);

    if (startByte != endByte) {
      screen[startByte] = startByteValue;
      screen[endByte] = endByteValue;
    } else {
      screen[startByte] = (byte) (startByteValue & endByteValue);
    }
  }

  public static void main(String[] args) {
    byte[] screen = { 0, 0, 0, 0, 0, 0, 0, 0 };
    drawLine(screen, 32, 35, 50);

    // 0 0 0 0 15 127 124 0
    for (int i = 0; i < screen.length; i++) {
      System.out.print(screen[i] + " ");
    }
  }
}
