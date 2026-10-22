public class Patterns {
    public static void main(String[] args) {
        // 1. 
        // * * * *
        // * * * *
        // * * * *
        // * * * *
        // int n = 4;
        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 2.
        // * * * * *
        // * * * * *
        // * * * * *
        // int row = 3;
        // int col = 4;
        // for (int i = 1; i <= row; i++) {
        //     for (int j = 1; j <= col; j++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 3. 
        // *
        // * *
        // * * *
        // * * * * 
        // * * * * *
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 4.
        //         * * * * *
        //       * * * * *
        //     * * * * *
        //   * * * * *
        // * * * * *
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= n; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 5.
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" "+col+" ");
        //     }
        //     System.out.println();
        // }

        // 6.
        // * * * * *
        // * * * *
        // * * *
        // * *
        // * 
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n - row + 1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 7.
        //         *
        //       * * *
        //     * * * * *
        //   * * * * * * *
        // * * * * * * * * *
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 8.
        // * * * * * * *
        //   * * * * *
        //     * * *
        //       *
        // int n = 4;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= row-1; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*n-row-(row-1); col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 9.
        // * * * * * *
        // *         *
        // *         *
        // * * * * * *
        // int n = 4; 

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= 6; j++) {
        //         if ( i == 1 || i == n || j == 1 || j == 6) {
        //             System.out.print(" * ");
        //         } else {
        //             System.out.print("   ");
        //         }
        //     }
        //     System.out.println();
        // }

        // 10.
        // *
        // * *
        // *   *
        // *     *
        // * * * * *
        // int n = 10;

        // for (int row = 1; row <= n; row++) {
        //     if (row == 1 || row == 2 || row == n) {
        //         for (int col = 1; col <= row; col++) {
        //             System.out.print(" * ");
        //         }    
        //     } 
        //     else {
        //         System.out.print(" * ");
        //         for (int col = 1; col <= (row-2) ; col++) {
        //             System.out.print("   ");
        //         }
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 11.
        //         *
        //       *   *
        //     *       *
        //   *           *
        // * * * * * * * * *
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= (n-row); col++) {
        //         System.out.print("   ");
        //     }
            
        //     if (row == 1 || row == n) {
        //         for (int col = 1; col <= (2*row-1); col++) {
        //             System.out.print(" * ");
        //         }
        //     } 
        //     else {
        //         System.out.print(" * ");

        //         for (int col = 1; col <= (2*row-3); col++) {
        //             System.out.print("   ");
        //         }

        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 12.
        //       *
        //     * * *
        //   * * * * *
        // * * * * * * *
        //   * * * * *
        //     * * *
        //       *
        // int n = 4;
        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }
        // for (int row = n-1; row > 0 ; row--) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }


        // 13.
        //       *
        //     *   *
        //   *       *
        // *           *
        //   *       *
        //     *   *
        //       *
        // int n = 4;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= (n-row); col++) {
        //         System.out.print("   ");
        //     }
            
        //     if (row == 1) {
        //         for (int col = 1; col <= (2*row-1); col++) {
        //             System.out.print(" * ");
        //         }
        //     } 
        //     else {
        //         System.out.print(" * ");

        //         for (int col = 1; col <= (2*row-3); col++) {
        //             System.out.print("   ");
        //         }

        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // for (int row = n-1; row > 0; row--) {
        //     for (int col = 1; col <= (n-row); col++) {
        //         System.out.print("   ");
        //     }
            
        //     if (row == 1) {
        //         for (int col = 1; col <= (2*row-1); col++) {
        //             System.out.print(" * ");
        //         }
        //     } 
        //     else {
        //         System.out.print(" * ");

        //         for (int col = 1; col <= (2*row-3); col++) {
        //             System.out.print("   ");
        //         }

        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 14.
        // *             *
        // * *         * *
        // * * *     * * *
        // * * * * * * * *
        // * * * * * * * *
        // * * *     * * *
        // * *         * *
        // *             *
        // int n = 4;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" * ");
        //     }
        //     for (int col = 1; col <= 2*(n-row); col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }
        // for (int row = n; row > 0; row--) {
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" * ");
        //     }
        //     for (int col = 1; col <= 2*(n-row); col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 15.
        // 1
        // 2  3
        // 4  5  6
        // 7  8  9  10
        // 11 12 13 14 15
        // int i = 1;
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" "+i+" ");
        //         i++;
        //     }
        //     System.out.println();
        // }

        // 16.
        // A
        // AB
        // ABC
        // ABCD
        // ABCDE
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     char a = 'A';
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(a);
        //         a++;
        //     }
        //     System.out.println();
        // }

        // 17.
        // E
        // ED
        // EDC
        // EDCB
        // EDCBA
        // int n = 5;

        // for (int row = 1; row <= n; row++) {
        //     char a = 'E';
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(a);
        //         a--;
        //     }
        //     System.out.println();
        // }

        // 18.
        // *  *  *  *  *  *  * 
        //    *  *  *  *  * 
        //       *  *  * 
        //          * 
        //       *  *  * 
        //    *  *  *  *  * 
        // *  *  *  *  *  *  * 
        // int n = 4;

        // for (int row =  n; row > 1; row--) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }
        // for (int row =  1; row <= n; row++) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" * ");
        //     }
        //     System.out.println();
        // }

        // 19.
        //          1 
        //       1  2  1 
        //    1  2  3  2  1 
        // 1  2  3  4  3  2  1 
        // int n = 4;

        // for (int row = 1; row <= n; row++) {
        //     int i = 1;
        //     int j = 1;
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= row; col++) {
        //         System.out.print(" "+i+" ");
        //         i++;
        //     }
        //     int decRowVal = row - 1;
        //     for (int col = 1; col <= row-1; col++) {
        //         System.out.print(" "+decRowVal+" ");
        //         decRowVal--;
        //     }
        //     System.out.println();
        // }

        // 20.
        //          1 
        //       2  2  2 
        //    3  3  3  3  3 
        // 4  4  4  4  4  4  4 
        // int n = 4;
        // int i = 1;
        // for (int row = 1; row <= n; row++) {
        //     for (int col = 1; col <= n-row; col++) {
        //         System.out.print("   ");
        //     }
        //     for (int col = 1; col <= 2*row-1; col++) {
        //         System.out.print(" "+i+" ");
        //     }
        //     i++;
        //     System.out.println();
        // }

        // 21.
        //          A 
        //       A  B  A 
        //    A  B  C  B  A 
        // A  B  C  D  C  B  A 
        int n = 4; 

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n-row; col++) {
                System.out.print("   ");
            }
            char a = 'A';
            for (int col = 1; col <= row; col++) {
                System.out.print(" "+a+" ");
                a++;
            }
            char decCharVal = --a;
            for (int col = 1; col <= row-1; col++) {
                System.out.print(" "+(char)(decCharVal-1)+" ");
                decCharVal--;
            }
            System.out.println();
        }

    }
}