package exercise;

import java.awt.*;
import java.io.IOException;
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
        var pathFile1 = Paths.get(file1).toAbsolutePath().toFile();
        var pathFile2 = Paths.get(file2).toAbsolutePath().toFile();

        //  Проверить существует ли file1 и file2
        // Выкинуть ошибку если не найдены файлы

        if (pathFile1.exists() && pathFile2.exists()) {

            try {
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
                        linesFile2 = Files.readAllLines(pathFile1.toPath());
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                    return linesFile2;
                });

                try {
                    var f1 = futureFile1.get();
                    var f2 = futureFile1.get();

                    // Если нет - создать файл
                    var result = Paths.get(dest).toAbsolutePath();
                    if (!result.toFile().exists()) {
                        boolean newFile = result.toFile().createNewFile();
                    }
                    // Записать данные в файл
                    Files.write(result, f1, StandardOpenOption.APPEND);
                    Files.write(result, f2, StandardOpenOption.APPEND);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("NoSuchFileException");
            return null;
        }

        // Прописать мультитрейдинг
        return null;
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

