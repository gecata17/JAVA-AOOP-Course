package com.jetbrains;

public class RouteCipher {

    //data
    private int key;

    //default constructor
    public RouteCipher() {
        setKey(1);
    }

    //general purpose constructor
    public RouteCipher(int newKey) {
        setKey(newKey);
    }

    //copy constructor
    public RouteCipher(RouteCipher newRouteCipher) {
        this.key = newRouteCipher.key;
    }

    //setter for key
    public void setKey(int newKey) {
        if (newKey != 0) {
            this.key = newKey;     //validation, it is no possible to be 0
        }
        else {
            this.key = 1;
        }
    }

    //getter for key
    public int getKey() {
        return this.key;
    }



    //helper method for the absolute value of the key
    private int absoluteValue(int key) {
        return (this.key > 0) ? this.key : this.key - 2 * this.key;
    }//end absoluteValue helper method

    //helper method to display elements of a matrix
    private void printMatrix(char[][] matrix, int rows, int columns) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }//end printMatrix method

    //make plain text as we need (with uppercase,without blank spaces
    //without punctuation
    //plaintext "ABORT THE MISSION, YOU HAVE BEEN SPOTTED
    //this method returns ABORTTHEMISSIONYOUHAVABEENSPOTTED
    private char[] makePlainText(char[] text) {
        int counter = 0;    //counter for valid characters

        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'A' && text[i] <= 'Z') {     // check if it is a letter
                text[counter] = text[i];
                counter++;
            }
            if (text[i] >= 'a' && text[i] <= 'z') {    // make all lower case letters to upper case
                text[counter] = (char) (text[i] + 'A' - 'a');
                counter++;
            }

        }

        //new char array with valid characters
        char[] preparedText = new char[counter];


        //assign the valid chars to the new array
        for (int i = 0; i < counter; i++) {
            preparedText[i] = text[i];
        }
        // return  text which is prepared to be filled in the matrix properly
        return preparedText;

    }//end makePlainText helper method



    //This method helps us to fill the text properly in a matrix
    private char[][] fillTextInMatrix(char[] matrixText, int rows, int columns) {
        //blank matrix of type char
        char[][] matrix = new char[rows][columns];

        int plantTextPosition = 0;

        for (int row = 0; row < rows; row++) {

            for (int column = 0; column < columns; column++) {

                if (matrixText.length <= plantTextPosition) {

                    matrix[row][column] = 'X';      // we add X -es in the end

                } else {

                    matrix[row][column] = matrixText[plantTextPosition];
                }

                plantTextPosition++;

            }
        }

        //return filled matrix
        return matrix;

    }//end fillTextInMatrix helper method

    //read the characters from the filled matrix from top-left corner
    //going spirally clockwise
    //if key is positive
    private char[] startFromUpLeftElement(char[][] matrix, int rows, int columns) {
        //array for the encrypted text
        char[] encrypted = new char[rows * columns];


        // we initialize start-up variables
        int i;
        int startRow = 0;
        int startColumn = 0;
        int countFilledElements = 0;
        int allElements = rows * columns;

        while (startRow < rows && startColumn < columns) {

            if (countFilledElements == allElements) {
                break;
            }
            // filling the first column from the remaining columns
            for (i = startRow; i < rows; ++i) {
                encrypted[countFilledElements] = matrix[i][startColumn];
                countFilledElements++;
            }
            startColumn++;

            if (countFilledElements == allElements) {

                break;
            }
            // filling the last row from the remaining rows
            for (i = startColumn; i < columns; ++i) {
                encrypted[countFilledElements] = matrix[rows - 1][i];
                countFilledElements++;
            }
            rows--;

            if (countFilledElements == allElements) {
                break;
            }

            // filling the last column from the remaining columns
            if (startRow < rows) {

                for (i = rows - 1; i >= startRow; --i) {
                    encrypted[countFilledElements] = matrix[i][columns - 1];
                    countFilledElements++;
                }
                columns--;
            }

            if (countFilledElements == allElements){
                break;
            }
            // filling the first row from the remaining rows
            if (startColumn < columns) {

                for (i = columns - 1; i >= startColumn; --i) {
                    encrypted[countFilledElements] = matrix[startRow][i];
                    countFilledElements++;
                }
                startRow++;
            }
        }
        return encrypted;

    }//end startFromTopLeftCornerElement method

    //read the characters from the filled matrix from down-right corner
    //going spirally counter-clockwise
    //if key is negative

    private char[] startFromDownRightElement(char[][] matrix, int rows, int columns) {
        //in order to optimize the file we use matrix 180 degrees rotation
        //// which means the down right element will be placed to the place
        //// of up left element => we can use the same function (startFromUpLeftElement)

        char[][] rotatedMatrix = rotate180Degrees(matrix, rows, columns);// first we rotate the matrix and then we call the function startFromUpLeftElement
        return startFromUpLeftElement(rotatedMatrix, rows, columns);

    }

    private char[][] rotate180Degrees(char[][] matrix, int rows, int columns) {

        for (int row = 0; row < rows / 2; row++) {
            for (int column = 0; column < columns; column++) {
                char temp = matrix[row][column];
                matrix[row][column] = matrix[rows - row - 1][columns - column - 1];
                matrix[rows - row - 1][columns - column - 1] = temp;
            }
        }

        //for odd rows
        if (rows % 2 != 0) {
            for (int column = 0; column < columns / 2; column++) {
                char temp = matrix[rows / 2][column];
                matrix[rows / 2][column] = matrix[rows - rows / 2 - 1][columns - column - 1];
                matrix[rows - rows / 2 - 1][columns - column - 1] = temp;
            }
        }
        return matrix;
    }

    public String encrypt(String plaintText) {
        // we convert string to char array due the assignment
        char[] text = plaintText.toCharArray();
        // we prepare out text by calling the function makePlainText
        char[] readyText = makePlainText(text);

        //set values for rows and columns
        int columns = (absoluteValue(this.key));
        int rows = (readyText.length / columns) + 1;

        System.out.println("Encrypting:");
        System.out.println(readyText);

        //  fill the readyText in matrix properly
        char[][] filledMatrix = fillTextInMatrix(readyText, rows, columns);

        // printMatrix(filledMatrix, rows, columns); //uncomment to see the matrix

        //convert the char arrays to String in order to fulfill the return type of func
        String positiveKey = new String(startFromUpLeftElement(filledMatrix, rows, columns));
        String negativeKey = new String(startFromDownRightElement(filledMatrix, rows, columns));

        //return String dependent of the key
        return (this.key > 0) ? positiveKey : negativeKey;

    }//end of encrypt method


    //we start filling the matrix for TOP-RIGHT element due to the assignment
    // counter-clockwise
    private char[][] fillMatrixWithEncryptedText(char[] clearMatrixText, int rows, int columns) {
        // blank matrix
        char[][] matrix = new char[rows][columns];

        // we set start values
        int i;
        int startRow = 0;
        int endRow = rows - 1;
        int startColumn = columns - 1;
        int endColumn = 0;
        int cntSymbol = 0;

        while (startRow <= endRow && startColumn >= endColumn) {
            /* filling the first row from the remaining rows */
            for (i = startColumn; i >= endColumn; --i) {
                matrix[startRow][i] = clearMatrixText[cntSymbol];
                cntSymbol++;
            }
            startRow++;
            /* filling the first column from the remaining columns */
            if (startColumn >= endColumn) {
                for (i = startRow; i <= endRow; ++i) {
                    matrix[i][endColumn] = clearMatrixText[cntSymbol];
                    cntSymbol++;
                }
                endColumn++;
            }
            /* filling the last row from the remaining rows */
            if (startRow <= endRow) {
                for (i = endColumn; i <= startColumn; i++) {
                    matrix[endRow][i] = clearMatrixText[cntSymbol];
                    cntSymbol++;
                }
                endRow--;
            }
            /* filling the last column from the remaining columns */
            if (startColumn >= endColumn) {
                for (i = endRow; i >= startRow; i--) {
                    matrix[i][startColumn] = clearMatrixText[cntSymbol];
                    cntSymbol++;
                }
                startColumn--;
            }
        }
        return matrix;

    }//end of fillMatrixWithEncryptedText method


    //method to decrypt positive key
    private char[] decryptMatrixPositiveKey(char[][] filledMatrix, int rows, int columns) {
        char[] temp = new char[rows * columns];
        int countElements = 0;
        for (int column = columns - 1; column >= 0; column--) {
            for (int row = 0; row < rows; row++) {
                temp[countElements] = filledMatrix[row][column];
                countElements++;
            }
        }
        return temp;

    }//end of decryptMatrixPositiveKey method

    // usage of  the same logic for encrypting,
    // using the rotating function, we rotate the filled matrix
    //  we read it through decryptMatrixPositiveKey function
    private char[] decryptMatrixNegativeKey(char[][] filledMatrix, int rows, int columns) {
        char[][] reversed = rotate180Degrees(filledMatrix, rows, columns);
        return decryptMatrixPositiveKey(reversed, rows, columns);

    }//end of decryptMatrixNegativeKey method

    public String decrypt(String encryptedText) {
        // we convert string to char array due the assignment
        char[] text = encryptedText.toCharArray();
        char[] preparedText = makePlainText(text);

        int rows = (absoluteValue(this.key));
        int columns = (preparedText.length / rows);

        System.out.println("Decrypting:");
        System.out.println(preparedText);

        char[][] filledMatrix = fillMatrixWithEncryptedText(preparedText, rows, columns);

        // printMatrix(filledMatrix, rows, columns); //uncomment to see the matrix

        //due to the assigment we return different char arrays
        // but having in mind the current function returns String
        // we need to convert the char arrays to String

        char[] withPositiveKey = decryptMatrixPositiveKey(filledMatrix, rows, columns);
        char[] withNegativeKey = decryptMatrixNegativeKey(filledMatrix, rows, columns);

        int count = countX(withNegativeKey);
        String positiveKey = new String(removeXs(count, withPositiveKey));
        String negativeKey = new String(removeXs(count, withNegativeKey));

        return (this.key > 0) ? positiveKey : negativeKey;

    }//end of decrypt method

    //remove Xs in the end
    private char[] removeXs(int amountOfXs, char[] textWithXs) {
        char[] textWithoutXs = new char[textWithXs.length - amountOfXs];
        for (int i = 0; i < textWithXs.length - amountOfXs; i++) {
            textWithoutXs[i] = textWithXs[i];
        }
        return textWithoutXs;

    }//end removeXs method

    //Count Xs in the end
    private int countX(char[] text) {
        int count = 0;
        if (key < 0) {
            for (int i = text.length - 1; i > 0; i--) {
                if (text[i] == 'X') {
                    count++;
                } else {
                    break;
                }
            }
        }
        if (key > 0) {
            for (int i = 0; i < text.length; i++) {
                if (text[i] == 'X') {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;

    }//end of countXs method

    public String toString() {
        //return formatted String
        return String.format("%d", this.key);

    }//end toString method
}
