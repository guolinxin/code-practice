package com.guo.practice.codepractice.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guo.practice.codepractice.file.b2b.Root;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProcessJson {

  public static String inputJsonFile =
      "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/Hardhead BTC (BUP Online-v3).json";

  public static String outputFile =
      "/Users/liguo/Documents/GitHub/code-practice/src/main/java/com/guo/practice/codepractice/file/data/Hardhead BTC (BUP Online-v3).cql";

  public static String cql = "select tx_hash from utxo where used_in_tx_proposal=";

  @SneakyThrows
  private static void createFile(List<String> cqls) {
      Files.write(Paths.get(outputFile), cqls, StandardOpenOption.APPEND);

  }

  public static List<String> loadFIle() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Root root = mapper.readValue(Paths.get(inputJsonFile).toFile(), Root.class);
    List<String> cqls = new ArrayList<>();
    root.getErrors()
        .forEach(
            error -> {
              cqls.add(cql + error.getProposalId() + " ALLOW FILTERING;");
            });
    return cqls;
  }

  public static void main(String[] args) throws IOException {
    //
    List<String> cqls = loadFIle();
    createFile(cqls);
  }
}
