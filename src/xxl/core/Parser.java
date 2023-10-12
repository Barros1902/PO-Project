package xxl.core;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;

import java.util.Collection;
import java.util.ArrayList;

import xxl.core.exception.OutOfBoundsException;
import xxl.core.exception.UnrecognizedEntryException;
import xxl.core.Representation;
import xxl.core.Calculator;
import xxl.core.Spreadsheet;

class Parser {

  private Spreadsheet _spreadsheet;
  



  public Parser() {
    
  }

  public Spreadsheet parseFile(String filename) throws OutOfBoundsException, IOException, UnrecognizedEntryException /* More Exceptions? */ {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      parseDimensions(reader);

      String line;

      while ((line = reader.readLine()) != null)
        parseLine(line);
    }

    return _spreadsheet;
  }

  private void parseDimensions(BufferedReader reader) throws UnrecognizedEntryException, IOException{
    int rows = -1;
    int columns = -1;
    
    for (int i = 0; i < 2; i++) {
      String[] dimension = reader.readLine().split("=");
      if (dimension[0].equals("linhas"))
        rows = Integer.parseInt(dimension[1]);
        
      else if (dimension[0].equals("colunas"))
        columns = Integer.parseInt(dimension[1]);
      else
        throw new UnrecognizedEntryException("Coordenadas erradas para celula");
    }

    if (rows <= 0 || columns <= 0)
      throw new UnrecognizedEntryException("Dimensões inválidas para a folha");

    _spreadsheet = new Spreadsheet(rows, columns);
  }

  private void parseLine(String line) throws OutOfBoundsException, UnrecognizedEntryException /*, more exceptions? */{
    String[] components = line.split("\\|");

    if (components.length == 1) // do nothing
      return;
    
    if (components.length == 2) {
      String[] address = components[0].split(";");
      Content content = parseContent(components[1]); //Saca o content e manda para o parse content
      // Adiciona cel
      _spreadsheet.insertContent(Integer.parseInt(address[0]), Integer.parseInt(address[1]), content); // insertContent o conteudo devia ser do tipo Content??? 
    } else
      throw new UnrecognizedEntryException("Wrong format in line: " + line);
  }

  // parse the begining of an expression
  Content parseContent(String contentSpecification) throws OutOfBoundsException, UnrecognizedEntryException {
    char c = contentSpecification.charAt(0);

    if (c == '=')
      return parseContentExpression(contentSpecification.substring(1));
    else
      return parseLiteral(contentSpecification);
  }

  private Literals parseLiteral(String literalExpression) throws UnrecognizedEntryException {
    if (literalExpression.charAt(0) == '\'')
      return new CharArray(literalExpression) ;
    else {
      try {
        int val = Integer.parseInt(literalExpression);
        return new Num(val);
      } catch (NumberFormatException nfe) {
        throw new UnrecognizedEntryException("Número inválido: " + literalExpression);
      }
    }
  }

  // contentSpecification is what comes after '='
  private Content parseContentExpression(String contentSpecification) throws OutOfBoundsException, UnrecognizedEntryException /* more exceptions */ {
    if (contentSpecification.contains("("))
      return parseFunction(contentSpecification);
    // It is a reference
    String[] address = contentSpecification.split(";");
    return new Reference(_spreadsheet.getCell(Integer.parseInt(address[0].trim()), Integer.parseInt(address[1]))); //Construtor de Reference?
  }

  private Content parseFunction(String functionSpecification) throws OutOfBoundsException, UnrecognizedEntryException /* more exceptions */ {
    String[] components = functionSpecification.split("[()]");
    if (components[1].contains(","))
      return parseBinaryFunction(components[0], components[1]);
    return null;
    /*return parseIntervalFunction(components[0], components[1]);*/
  }


  private Content parseBinaryFunction(String functionName, String args) throws OutOfBoundsException, UnrecognizedEntryException /* , more Exceptions */ {
    String[] arguments = args.split(",");
    Content arg0 = parseArgumentExpression(arguments[0]);
    Content arg1 = parseArgumentExpression(arguments[1]);

    return switch (functionName) {
      case "ADD" -> new ADD(arg0, arg1); //Criar mais construtores
      case "SUB" -> new SUB(arg0, arg1);
      case "MUL" -> new MUL(arg0, arg1);
      case "DIV" -> new DIV(arg0, arg1);
      default -> throw new UnrecognizedEntryException(args, null);/*dar erro com função inválida: functionName ;*/ //Criar uma exception
    };
  }

  private Content parseArgumentExpression(String argExpression) throws OutOfBoundsException, UnrecognizedEntryException {
    if (argExpression.contains(";")  && argExpression.charAt(0) != '\'') {
      String[] address = argExpression.split(";");
      return new Reference(_spreadsheet.getCell(Integer.parseInt(address[0].trim()), Integer.parseInt(address[1]))); //Construtor de Reference?
      // pode ser diferente do anterior em parseContentExpression
    } else
      return parseLiteral(argExpression);
  }

  /* Para a
  private Content parseIntervalFunction(String functionName, String rangeDescription)
    throws UnrecognizedEntryException  , more exceptions ?  {
    Range range = _spredsheet.buildRange(rangeDescription);
    return switch (functionName) {
      case "CONCAT" -> new Concat com range 
      case "COASLECE" -> new Coaslece com range;
      case "PRODUCT" -> new Product com range;
      case "AVERAGE" -> new Average com range;
      default -> dar erro com função inválida: functionName;
    };
  }*/

  /* Na classe Spreadsheet preciso de algo com a seguinte funcionalidade
  Range createRange(String range) throws ? {
    String[] rangeCoordinates;
    int firstRow, firstColumn, lastRow, lastColumn;
    
    if (range.indexOf(':') != -1) {
      rangeCoordinates = range.split("[:;]");
      firstRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = Integer.parseInt(rangeCoordinates[1]);
      lastRow = Integer.parseInt(rangeCoordinates[2]);
      lastColumn = Integer.parseInt(rangeCoordinates[3]);
    } else {
      rangeCoordinates = range.split(";");
      firstRow = lastRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = lastColumn = Integer.parseInt(rangeCoordinates[1]);
    }

    // check if coordinates are valid
    // if yes
    return new Range with firstRow, firstColumn, lastRow, lastColumn and spreadsheet;
  }
  */
  
}
