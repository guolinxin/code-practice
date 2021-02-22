package com.guo.practice.codepractice.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.practice.codepractice.file.b2b.Root;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProcessJson {

  public static String inputJsonFile =
      "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/%s.json";

  public static String outputCqlFile =
      "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/%s.cql";

  public static String outputFile =
      "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/%s Proposal Ids.txt";

  //  public static String outputFile =
  //
  // "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/Hardhead BTC (BUP Online-v3).cql";

  public static String cql = "select tx_hash from utxo where used_in_tx_proposal=";

  private static void createFile(String fileName, List<String> cqls) {
    try {
      Files.write(Paths.get(String.format(outputFile, fileName)), cqls, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void createCSVFile(List<String> cqls) {
    try {
      Files.write(Paths.get(outputFile), cqls, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void processJson(String fileName) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Root root =
        mapper.readValue(Paths.get(String.format(inputJsonFile, fileName)).toFile(), Root.class);
    List<String> cqls = new ArrayList<>();
    List<String> ids = new ArrayList<>();
    root.getErrors()
        .forEach(
            error -> {
              cqls.add(cql + error.getProposalId() + " ALLOW FILTERING;");
              ids.add(error.getProposalId());
            });
    //    createFile(fileName, cqls);
    createFile(fileName, ids);
  }

  public static void main(String[] args) throws IOException {
    String fileName = "Argus BTC (BUP Online-v3)";
    //    fileName = "Bowfish BTC (BUP Online-v3)";
    fileName = "Hardhead BTC (BUP Online-v3)";

    processJson(fileName);
  }
}
