package exercise;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String dest) {
        // Прелбразовать STRING в Path
        var pathFile1 = Paths.get(file1).toAbsolutePath().normalize().toFile();
        var pathFile2 = Paths.get(file2).toAbsolutePath().normalize().toFile();

        //  Проверить существует ли file1 и file2
        // Выкинуть ошибку если не найдены файлы

        if (pathFile1.exists() && pathFile2.exists()) {
                // Прочитать данныее из файлов
            System.out.println("Reading file " + pathFile1.getName());
            CompletableFuture<List<String>> futureFile1 = CompletableFuture.supplyAsync(() -> {
                List<String> linesFile1;
                try {
                    linesFile1 = Files.readAllLines(pathFile1.toPath());
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
                return linesFile1;
            });

            System.out.println("Reading file " + pathFile2.getName());
            CompletableFuture<List<String>> futureFile2 = CompletableFuture.supplyAsync(() -> {
                List<String> linesFile2;
                try {
                    linesFile2 = Files.readAllLines(pathFile2.toPath());
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
                return linesFile2;
            });


            CompletableFuture<String> writeToFile = futureFile1.thenCombine(futureFile2, (dataFile1, dataFile2) -> {
                List<String> result = new ArrayList<>();
                result.addAll(dataFile1);
                result.addAll(dataFile2);

                // Если нет - создать файл
                try {
                    // Если нет - создать файл
                    var writePath = Paths.get(dest).toAbsolutePath();
                    if (!writePath.toFile().exists()) {
                        writePath.toFile().createNewFile();
                    }
                    Files.write(writePath, result);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                return result.toString();
            });
            return writeToFile;


        } else {
            System.out.println("NoSuchFileException");
            return CompletableFuture.supplyAsync(() -> {
                return "NoSuchFileException";
            });
        }

    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        String file1 = "/home/alex/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/src/main/resources/file1.txt";
        String file2 = "/home/alex/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/src/main/resources/file2.txt";
        String dest = "/home/alex/Hexlet/hexlet-assignments/java-advanced-ru/asynchrony/src/main/resources/dest.txt";
        unionFiles(file1, file2, dest);
        // END
    }
}

