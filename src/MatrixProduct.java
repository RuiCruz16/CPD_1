import java.util.Scanner;

public class MatrixProduct {
  public static void main(String[] args) {
    
    int lin, col;
    int op;

    op=1;
    Scanner scan = new Scanner(System.in);

    do {
      System.out.println();
      System.out.print("1. Multiplication \n");
      System.out.print("2. Line Multiplication \n");
      System.out.print("Selection?: ");
      op = scan.nextInt();

      if (op == 0) break;

      System.out.print("Dimensions: lins=cols ? ");
      lin = scan.nextInt();
      col = lin;

      switch (op) {
        case 1:
          onMult(lin, col);
          break;

        case 2:
          OnMultLine(lin,col);
          break;

        default:
          break;
      }

    } while ( op != 0);

    scan.close();
  }

  public static void onMult(int m_ar, int m_br) {
    double[] pha = new double[m_ar * m_ar];
    double[] phb = new double[m_br * m_br];
    double[] phc = new double[m_ar * m_br];

    for (int i = 0; i < m_ar; i++) {
      for (int j = 0; j < m_ar; j++) {
        pha[i * m_ar + j] = 1.0;
      }
    }

    for (int i = 0; i < m_br; i++) {
      for (int j = 0; j < m_br; j++) {
        phb[i * m_br + j] = (double) (i + 1);
      }
    }

    long Time1 = System.currentTimeMillis();

    for (int i = 0; i < m_ar; i++) {
      for (int j = 0; j < m_br; j++) {
          double temp = 0;
          for (int k = 0; k < m_ar; k++) {
            temp += pha[i * m_ar + k] * phb[k * m_br + j];
          }
          phc[i * m_br + j] = temp;
      }
    }

    long Time2 = System.currentTimeMillis();

    double estimatedTime = (Time2 - Time1) / 1000.0;
    System.out.printf("Time: %.3f seconds \n", estimatedTime);

    // Display first 10 elements of the result matrix to verify correctness
    System.out.println("Result matrix:");
    for (int j = 0; j < Math.min(10, m_br); j++) {
      System.out.print(phc[j] + " ");
    }
    System.out.println();
  }

  public static void OnMultLine(int m_ar, int m_br) {
    double[] pha = new double[m_ar * m_ar];
    double[] phb = new double[m_br * m_br];
    double[] phc = new double[m_ar * m_br];

    for (int i = 0; i < m_ar; i++) {
      for (int j = 0; j < m_ar; j++) {
        pha[i * m_ar + j] = 1.0;
      }
    }

    for (int i = 0; i < m_br; i++) {
      for (int j = 0; j < m_br; j++) {
        phb[i * m_br + j] = (double) (i + 1);
      }
    }

    for(int i=0; i<m_ar; i++) {
      for(int j=0; j<m_br; j++) {
        phc[i*m_ar + j] = 0;
      }
    }

    long Time1 = System.currentTimeMillis();

    for(int i=0; i<m_ar; i++) {	
      for(int j=0; j<m_br; j++) {
        for(int k=0; k<m_ar; k++) {
          phc[i*m_ar+k] += pha[i*m_ar+j] * phb[j*m_br+k];
        } 
      }
    }

    long Time2 = System.currentTimeMillis();

    double estimatedTime = (Time2 - Time1) / 1000.0;
    System.out.printf("Time: %.3f seconds \n", estimatedTime);

    // Display first 10 elements of the result matrix to verify correctness
    System.out.println("Result matrix:");
    for (int j = 0; j < Math.min(10, m_br); j++) {
      System.out.print(phc[j] + " ");
    }
    System.out.println();
  }
}
